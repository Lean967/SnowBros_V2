package src.Juego;

import src.Enemigo.Enemigo;
import src.Fabricas.FabricaEntidades;
import src.Fabricas.SpritesOriginal;
import src.GUI.InterfacesGUI.ControladorGrafica;
import src.GUI.Observers.Observer;
import src.Jugador.HiloJugador;
import src.Jugador.Jugador;
import src.Jugador.SnowBro;
import src.Jugador.EstadosLogicos.EstadoLogicoSnowBroInmune;
import src.Municiones.Municion;
import src.Niveles.AdministradorNivel;
import src.Niveles.Nivel;
import src.Niveles.Modos.ModoDeJuego;
import src.Obstaculos.Obstaculo;
import src.Plataformas.Plataforma;

public class Juego implements ControladorDeJuego{
    protected Jugador jugador; 
    protected ModoDeJuego modoDeJuego;
    protected String rutaArchivoTexto;
    protected String rutaFondosNiveles;
    protected Ranking ranking;
    protected ControladorGrafica controladorGrafica;
    protected AdministradorNivel administradorNivel;
    protected FabricaEntidades fabricaEntidades;
    protected HiloJugador hiloJugador;
    protected Thread juegoThread;
    protected volatile boolean corriendo = true;
    protected Nivel copiaNivel;
    protected Nivel nivelActual;
    private int tiempoRestanteSegundos; // Tiempo restante para el modo Contrarreloj
    private int contadorCiclos; // Contador para simular 1 segundo
    private static final int CICLOS_POR_SEGUNDO = 60;


    public Juego(ControladorGrafica grafica){
        this.controladorGrafica = grafica;
        this.ranking = new Ranking();
        this.rutaArchivoTexto= "src/CapaDatos/Niveles.txt";
        this.rutaFondosNiveles= "/src/imagenes/Fondos/FondosNivel/";
        //HARCODEO
        fabricaEntidades = new FabricaEntidades(new SpritesOriginal());

    }

    public void setDominio(String Dominio){
        // va a haber que crear clases de tipo Dominio donde c/u tenga su propia fabrica de sprites
        // entonces Juego va a poder hacer dominio.getFabrica y asociarsela a la fabrica de entidades
    }

    public void cambiarModoDeJuego(ModoDeJuego modo) {
        this.modoDeJuego = modo;
    }

    //lo llama Launcher
    public void configurar(){
        controladorGrafica.configurarVentana();
        controladorGrafica.mostrarPantallaInicio();
    }

    public void iniciar() {
        this.administradorNivel = new AdministradorNivel(rutaArchivoTexto, fabricaEntidades);
        administradorNivel.setIndiceNivelActual(1);
        controladorGrafica.agregarImagenFondoPartida(rutaFondosNiveles+modoDeJuego.getNombre()+administradorNivel.getIndiceNivelActual()+".png");
        Jugador jugadorSnowBro = new Jugador("pou");
        this.jugador = jugadorSnowBro;
        siguienteNivel();
        crearCopiaNivel(administradorNivel.getNivelActual());
        iniciarHiloJuego();

    }
    
    public void iniciarHiloJuego(){
        this.hiloJugador = new HiloJugador(jugador.getSnowBro());
        this.corriendo=true;
        this.juegoThread = new Thread(() -> {
        while (true) {
            hacerCicloDeJuego();
            try {
                Thread.sleep(16);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
        });juegoThread.start();
    }

    public void detenerHiloJuego(){
        this.corriendo = false;
        if (juegoThread != null) {
           juegoThread.interrupt(); // Interrumpir el hilo para salir del sleep
           try {
              juegoThread.join(); // Esperar a que el hilo termine
           } catch (InterruptedException e) {
               Thread.currentThread().interrupt();
           }
        juegoThread = null;
       }
    }
    

    public void hacerCicloDeJuego(){
        modoDeJuego.modificarContadorCiclos();
        /*if (modoDeJuego != null && modoDeJuego.getNombre().equals("CONTRARRELOJ")) {
            contadorCiclos--;
            
            if (contadorCiclos <= 0) {
                tiempoRestanteSegundos--;
                contadorCiclos = CICLOS_POR_SEGUNDO; // Reiniciar el contador de ciclos
                controladorGrafica.actualizarTiempo(tiempoRestanteSegundos);
                if (tiempoRestanteSegundos <= 0) {
                    this.perderNivel();
                }
            }
        }*/
        hiloJugador.run();
        jugador.getSnowBro().hacerBucle();
        for (Enemigo enemigo : nivelActual.getEnemigos()){
            //enemigo.buscarSnowBro(jugador.getSnowBro());
            enemigo.hacerBucle();
        }
        for( Municion municion : nivelActual.getMuniciones()){
            municion.mover();
        }
        for (Plataforma plataforma: nivelActual.getPlataformas()){
            plataforma.mover();
        }
        nivelActual.getControladorColisiones().detectarColisiones();
    }

    public void crearCopiaNivel(Nivel nivel){
        this.copiaNivel = modoDeJuego.getNivel();
        copiaNivel.setFabricaEntidades(fabricaEntidades);
        for(Enemigo enemigo: nivel.getEnemigos()){
            Enemigo nuevoEnemigo=enemigo.clone();
            copiaNivel.getEnemigos().add(nuevoEnemigo);
            copiaNivel.getEntidades().add(nuevoEnemigo);
        }
        for(Obstaculo obstaculo: nivel.getObstaculos()){
            Obstaculo nuevObstaculo= obstaculo.clone();
            copiaNivel.getObstaculos().add(nuevObstaculo);
            copiaNivel.getEntidades().add(nuevObstaculo);

        }
        for(Plataforma plataforma: nivel.getPlataformas()){
            Plataforma nuevaPlataforma= plataforma.clone();
            copiaNivel.getPlataformas().add(nuevaPlataforma);
            copiaNivel.getEntidades().add(nuevaPlataforma);
        }
        
    }


    public void ganarNivel(){
        administradorNivel.sumarIndiceNivel();
        controladorGrafica.ganarNivel();
    }

    public void perderNivel(){
        controladorGrafica.perderNivel();
    }

    public void siguienteNivel(){
        nivelActual = administradorNivel.getSiguienteNivel(modoDeJuego);
        nivelActual.setJuego(this);
        jugador.setSnowBro(administradorNivel.getNivelActual().getSnowBro());
        nivelActual.iniciarNivel();
        registrarObservers();
        controladorGrafica.mostrarPantallaPartida();
        modoDeJuego.setNivel(nivelActual);
    }

    protected void registrarObservers(){
        registrarObserverJugador(nivelActual.getSnowBro());
        registrarObserverEntidades(nivelActual.getEntidades());
    }

    public void registrarObserverNuevaEntidad(Entidad entidad){
        Observer observerEntidad = controladorGrafica.registrarEntidad(entidad);
        entidad.registrarObserver(observerEntidad);
    }

    protected void configurarControles(){
        controladorGrafica.configurarControles(jugador.getSnowBro());
    }

    protected void registrarObserverJugador(SnowBro snowBro){
        Observer observerJugador = controladorGrafica.registrarSnowBro(snowBro);
        snowBro.registrarObserver(observerJugador);

    }

    protected void registrarObserverEntidades(Iterable<Entidad> entidades){
        for (Entidad entidad : entidades) {
            Observer observerEntidad = controladorGrafica.registrarEntidad(entidad);
            entidad.registrarObserver(observerEntidad);
        }
        
    }

    public void setFabricaEntidades(FabricaEntidades fabrica){
        this.fabricaEntidades = fabrica;
    }

    public void cierreDeJuego(){
        // TODO implementar Serializacion
    }

    public void reiniciarNivel(){
        System.out.println("reiniciando");
        nivelActual.borrarEntidades();
        jugador.getSnowBro().setPosicionInicial();
        jugador.getSnowBro().setEstadoLogico(new EstadoLogicoSnowBroInmune(jugador.getSnowBro()));
        jugador.setNivelActual(copiaNivel);
        
        for(Entidad entidad: copiaNivel.getEntidades()){
            entidad.setNivelActual(copiaNivel);
        }   
        nivelActual = copiaNivel;
        nivelActual.setSnowBro(jugador.getSnowBro());
        registrarObservers();
        hiloJugador.setSnowBro(nivelActual.getSnowBro());
        nivelActual.setJuego(this);
        crearCopiaNivel(nivelActual);
        nivelActual.iniciarNivel();
        controladorGrafica.mostrarPantallaPartida();
    }

    public void cortarJuego() {

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
        return copiaNivel;
    }

    public ModoDeJuego getModoDeJuego() {
        return modoDeJuego;
    }

    public ControladorGrafica getControladorGrafica(){
        return controladorGrafica;
    }
}