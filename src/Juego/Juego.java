package src.Juego;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.SwingUtilities;

import src.CapaDatos.GestorSonido;
import src.Enemigo.JefeDeNivel;
import src.Fabricas.FabricaEntidades;
import src.Fabricas.FabricaSprites;
import src.GUI.PanelPartida;
import src.GUI.InterfacesGUI.ControladorGrafica;
import src.GUI.Observers.Observer;
import src.Jugador.Jugador;
import src.Jugador.SnowBro;
import src.Jugador.EstadosLogicos.EstadoLogicoSnowBroInmune;
import src.Niveles.AdministradorNivel;
import src.Niveles.Nivel;
import src.Niveles.Modos.ModoDeJuego;
import src.Plataformas.Movediza;

public class Juego implements ControladorDeJuego{
    protected Jugador jugador; 
    protected ModoDeJuego modoDeJuego;
    protected String rutaArchivoTexto;
    protected String rutaFondosNiveles;
    protected Ranking TopJugadores;
    protected ControladorGrafica controladorGrafica;
    protected AdministradorNivel administradorNivel;
    protected FabricaEntidades fabricaEntidades;
    protected HiloJuego hiloJuego;
    protected Nivel nivelActual;
    protected SnowBro snowBro;
    protected GestorSonido gestorSonido = GestorSonido.getInstancia();
    


    public Juego(ControladorGrafica grafica){
        this.controladorGrafica = grafica;
        this.TopJugadores = new Ranking();
        this.rutaArchivoTexto= "src/CapaDatos/Niveles.txt";
        snowBro=null;
    }
    

    public void setDominio(FabricaSprites fabricaSprites){
        fabricaEntidades= new FabricaEntidades(fabricaSprites);
        this.rutaFondosNiveles= fabricaSprites.getRutaAFondosNiveles();

    }

    public void cambiarModoDeJuego(ModoDeJuego modo) {
        this.modoDeJuego = modo;
        try{
            FileInputStream fileInputStream = new FileInputStream("Ranking"+modoDeJuego.getNombre()+".tdp");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            TopJugadores = (Ranking) objectInputStream.readObject();
            objectInputStream.close(); 
        }
        catch(IOException e){
            e.printStackTrace();
            TopJugadores = new Ranking();
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
            TopJugadores = new Ranking();

        }
        controladorGrafica.setPanelRanking(TopJugadores);
    }

    //lo llama Launcher
    public void configurar(){
        controladorGrafica.configurarVentana();
        controladorGrafica.mostrarPantallaInicio();
    }

    public void iniciar() {
        this.administradorNivel = new AdministradorNivel(rutaArchivoTexto, fabricaEntidades);
        siguienteNivel(); 
    }

    public void intentarDeNuevo(){
        nivelActual = administradorNivel.getNivelActual();
        configurarNivel();
        iniciarNivel();
    }
    

    public void detenerHiloJuego(){
        if (hiloJuego != null) {  
            hiloJuego.detener(); 
            try {
                
                hiloJuego.join();
                
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
    }
    public void ganarNivel(){
        agregarJugadorRanking(jugador.getNombre(), jugador.getSnowBro().getPuntaje());

        if(nivelActual != null){
            nivelActual.borrarEntidades();
        }
        snowBro=jugador.getSnowBro();
        SwingUtilities.invokeLater(new Runnable() {
            public void run(){
                detenerHiloJuego();
                controladorGrafica.ganarNivel();
            }
        });
        gestorSonido.reproducirSonido("GAME_OVER");

        
    }

    public void iniciarCicloDeJuego(){
        hiloJuego = new HiloJuego("HiloJuego");
        this.hiloJuego.setJuego(this);
        hiloJuego.start();
    }

    public void perderNivel(){
        agregarJugadorRanking(jugador.getNombre(),jugador.getSnowBro().getPuntaje());
        jugador.getSnowBro().setPuntaje(0);
        
        controladorGrafica.limpiarEntidadesPartida();
        SwingUtilities.invokeLater(new Runnable() {
            public void run(){
                detenerHiloJuego();
                controladorGrafica.perderNivel();
            }
        });
        snowBro=null;
        gestorSonido.reproducirSonido("GAME_OVER");
    }

    public void siguienteNivel(){    
        nivelActual = administradorNivel.getSiguienteNivel(modoDeJuego);
        if(nivelActual != null){
            controladorGrafica.limpiarEntidadesPartida();
            configurarNivel();
            
            iniciarNivel();
        }else{
            snowBro.setPuntaje(0);
            ganarJuego();
        }
    }

    public void configurarNivel(){
        controladorGrafica.agregarImagenFondoPartida(rutaFondosNiveles+modoDeJuego.getNombre()+administradorNivel.getIndiceNivelActual()+".png");
        nivelActual.setJuego(this);
        nivelActual.setModoDeJuego(modoDeJuego);
        modoDeJuego.setNivel(nivelActual);

        jugador.setSnowBro(nivelActual.getSnowBro());
        snowBro = nivelActual.getSnowBro();
    }

    public void iniciarNivel(){
        nivelActual.iniciarNivel();
        registrarObservers();

        controladorGrafica.mostrarPantallaPartida();
        controladorGrafica.actualizarIndiceNivel(administradorNivel.getIndiceNivelActual());

        iniciarCicloDeJuego();
    }

    public void ganarJuego(){
        controladorGrafica.ganarJuego();
        

        controladorGrafica.limpiarEntidadesPartida();
        SwingUtilities.invokeLater(new Runnable() {
            public void run(){
                detenerHiloJuego();
                controladorGrafica.ganarJuego();
            }
        });
        
        
        
    }

    public void nivelParaJefe(){
        if(nivelActual != null){
            JefeDeNivel jefe=nivelActual.getJefeDeNivel();
            int tiempoLimite = nivelActual.getTiempoLimite();
            int puntajeObjetivo = nivelActual.getPuntajeObjetivo();
            nivelActual.borrarEntidades();
            controladorGrafica.limpiarEntidadesPartida(); 
            controladorGrafica.agregarImagenFondoPartida(rutaFondosNiveles+modoDeJuego.getNombre()+administradorNivel.getIndiceNivelActual()+".png");
            nivelActual.setSnowBro(jugador.getSnowBro());
            nivelActual.getSnowBro().setPosicionInicial();
            nivelActual.setJefeDeNivel(jefe);
            nivelActual.setPuntajeObjetivo(puntajeObjetivo);
            nivelActual.setTiempoLimite(tiempoLimite);
            jefe.setCayendo(false);

            //Plataforma principal
            nivelActual.setPlataformaEstatica(-5, 530, 4, 800, 35); // Base del nivel
            
            // Plataformas
            /*nivelActual.setPlataformaMovedizaAscensor(80, 450, 200, 450, 1, 100, 25,Movediza.Modo.VERTICAL);
            nivelActual.setPlataformaMovedizaAscensor(620, 400, 150, 400, 1, 100, 25,Movediza.Modo.VERTICAL);
            nivelActual.setPlataformaQuebradiza(350, 400, 1, 100, 25);
            nivelActual.setPlataformaMovedizaLateral(10, 300, 10, 300, 1, 150, 25,Movediza.Modo.HORIZONTAL);
            nivelActual.setPlataformaMovedizaLateral(500, 200, 500, 750, 1, 150, 25,Movediza.Modo.HORIZONTAL);*/


            // Obstaculos
            nivelActual.setEscalera(385, 250, 0);
            nivelActual.setTrampa(200, 500, 0);
            
            // Paredes
            nivelActual.setParedIzquierda(0, 0, 0, 20, 560);
            nivelActual.setParedDerecha(780, 0, 0, 20, 560);
            
            // Inicializacion
            nivelActual.iniciarNivel();
            registrarObservers(); 
            
        }
    }

    public void setNombreJugador(String nombreJugador){
        this.jugador= new Jugador(nombreJugador);
    }

    public String getNombreJugador(){
        return jugador.getNombre();
    }


    protected void registrarObservers(){
        registrarObserverJugador(nivelActual.getSnowBro());
        registrarObserverEnemigos(nivelActual.getEnemigos());
        registrarObserversEstaticos(nivelActual.getObstaculos());
        registrarObserversEstaticos(nivelActual.getPlataformas());
    }

    public void registrarObserverNuevaEntidadEstatica(Entidad entidad){
        Observer observerEntidad = controladorGrafica.registrarEntidadEstatica(entidad);
        entidad.registrarObserver(observerEntidad);
    }
    public void registrarObserverNuevaEntidadEnemigo(Entidad entidad){
        Observer observerEntidad = controladorGrafica.registrarEntidadEnemigo(entidad);
        entidad.registrarObserver(observerEntidad);
    }

    protected void configurarControles(){
        controladorGrafica.configurarControles(jugador.getSnowBro());
    }

    protected void registrarObserverJugador(SnowBro snowBro){
        Observer observerJugador = controladorGrafica.registrarSnowBro(snowBro);
        snowBro.registrarObserver(observerJugador);

    }

    protected void registrarObserversEstaticos(Iterable<? extends Entidad> estaticos){
        for (Entidad entidad : estaticos) {
            Observer observerEntidad = controladorGrafica.registrarEntidadEstatica(entidad);
            entidad.registrarObserver(observerEntidad);
        }
    }

    protected void registrarObserverEnemigos(Iterable<? extends Entidad> enemigos){
        for (Entidad entidad : enemigos) {
            Observer observerEntidad = controladorGrafica.registrarEntidadEnemigo(entidad);
            entidad.registrarObserver(observerEntidad);
        }
    }

    public void setFabricaEntidades(FabricaEntidades fabrica){
        this.fabricaEntidades = fabrica;
    }


    public void agregarJugadorRanking(String nombreJugador, int puntajeJugador){
        this.TopJugadores.agregarPuntaje(nombreJugador, puntajeJugador);
    }


    public void reiniciarNivel(){
        jugador.getSnowBro().setPosicionInicial();
        jugador.getSnowBro().setEstadoLogico(new EstadoLogicoSnowBroInmune(jugador.getSnowBro()));
    }

    public void cortarJuego() {

    }

    public void cierreDeJuego(){
        // se guarda el ranking antes de cerrar el juego
        try{
            // no se hace un .txt porque el archivo no sera posible de leer por un humano (esta en lenguaje maquina)
            FileOutputStream fileOutputStream= new FileOutputStream("Ranking"+modoDeJuego.getNombre()+".tdp");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(this.TopJugadores);
            objectOutputStream.flush();
            objectOutputStream.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    /*public void crearFabricaOriginal(){
        FabricaSprites fabricaSprites = new SpritesOriginal();
        this.fabricaEntidades = new FabricaEntidades(fabricaSprites);
    }

    public void crearFabricaPersonal(){
        FabricaSprites fabricaSprites = new SpritesPersonal();
        this.fabricaEntidades = new FabricaEntidades(fabricaSprites);
    }*/

    public Nivel getNivelActual(){
        return nivelActual;
    }

    public ModoDeJuego getModoDeJuego() {
        return modoDeJuego;
    }

    public ControladorGrafica getControladorGrafica(){
        return controladorGrafica;
    }

    public Thread getHiloJuego(){
        return hiloJuego;
    }
    public AdministradorNivel getAdministradorNivel(){
        return administradorNivel;
    }


    
}