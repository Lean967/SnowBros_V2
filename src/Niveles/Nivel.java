package src.Niveles;
import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadLocalRandom;

import src.Jugador.SnowBro;
import src.Municiones.Municion;
import src.Niveles.Modos.ModoDeJuego;
import src.Juego.ControladorColisiones;
import src.Juego.Entidad;
import src.Juego.Juego;
import src.Juego.Posicion;
import src.Obstaculos.Escalera;
import src.Obstaculos.Obstaculo;
import src.Obstaculos.Pared;
import src.Obstaculos.ParedDestructible;
import src.Obstaculos.SueloResbaladizo;
import src.Obstaculos.Trampa;
import src.Obstaculos.EstadoPared.ParedNormal;
import src.Obstaculos.EstadoPared.ParedRebote;
import src.CapaDatos.ConstantesTeclado;
import src.Enemigo.*;
import src.Powers.PowerUp;
import src.Plataformas.Estatica;
import src.Plataformas.Movediza;
import src.Plataformas.Movediza.Modo;
import src.Plataformas.Plataforma;
import src.Plataformas.Quebradiza;
import src.Fabricas.FabricaEntidades;
public abstract class Nivel {

    protected LinkedList<Oleada> oleadas;
    protected int oleadaActual;

    protected CopyOnWriteArrayList<Entidad> listaEntidades;
    protected LinkedList<Obstaculo> obstaculos;
    protected CopyOnWriteArrayList<Enemigo> enemigos;
    protected SnowBro snowBro;
    protected CopyOnWriteArrayList<PowerUp> powers;
    protected LinkedList<Plataforma> plataformas;
    protected CopyOnWriteArrayList<Municion> municiones;
    protected JefeDeNivel jefeDeNivel;

    protected FabricaEntidades fabricaEntidades;
    protected ControladorColisiones controladorColisiones;
    protected Juego juego;
    protected int tiempoAparicionCalabaza;
    protected ModoDeJuego modoDeJuego;

    protected Nivel(){
        controladorColisiones = new ControladorColisiones(this);
        listaEntidades = new CopyOnWriteArrayList<>();
        obstaculos = new LinkedList<>();
        enemigos = new CopyOnWriteArrayList<>();
        powers = new CopyOnWriteArrayList<>();
        plataformas = new LinkedList<>();
        municiones = new CopyOnWriteArrayList<>();
        oleadas = new LinkedList<>();
        oleadaActual = -1;
        tiempoAparicionCalabaza=ConstantesTeclado.TIEMPO_APARICION_CALABAZA;
    }

    public void iniciarNivel(){
        modoDeJuego.setEnemigosRestantes(enemigos.size());
    }

    public void setFabricaEntidades (FabricaEntidades fabrica){
        this.fabricaEntidades=fabrica;
    }
    public void setModoDeJuego(ModoDeJuego modoDeJuego){
        this.modoDeJuego = modoDeJuego;
    }
    public void setJuego(Juego juego){
        this.juego = juego;
    }

    public Juego getJuego(){
        return juego;
    }

    public void nivelParaJefe(){
        this.setPlataformaEstatica(-30,460,1, 295, 40);
        this.setPlataformaEstatica(-30,250,1, 295, 40);
        this.setPlataformaEstatica(520,430,1, 295, 40);
        this.setPlataformaEstatica(520,310,1, 295, 40);
        this.setPlataformaEstatica(-5,530, 4,800, 35);
    }

    public void setControladorColisiones(ControladorColisiones controlador){
        this.controladorColisiones = controlador;
    }

    public JefeDeNivel getJefeDeNivel(){
        return jefeDeNivel;
    }

    public void setJefeDeNivel(JefeDeNivel jefeDeNivel){
        this.jefeDeNivel = jefeDeNivel;
        enemigos.add(jefeDeNivel);
        listaEntidades.add(jefeDeNivel);
    }


    public void ganarNivel(){
        juego.ganarNivel();
    }
    
    public void borrarEntidades(){
        for(Entidad entidad : listaEntidades){
            entidad.eliminarObservers();
        }
        listaEntidades.clear();
        obstaculos.clear();
        enemigos.clear();
        powers.clear();
        plataformas.clear();
        municiones.clear();
    }

    public void setNuevaOleada(Oleada oleada){
        oleadas.addLast(oleada);
    }

    protected void borrarPowersUps(){
        for(PowerUp powerUp : powers){
            eliminar(powerUp);
        }
    }
    protected void borrarMuniciones(){
        for(Municion municion : municiones){
            eliminar(municion);
        }
    }

    public void perder(){
        borrarEntidades();
        juego.perderNivel();
        snowBro.eliminar();

    }


    public void detenerEnemigos(){
        for(Enemigo e: enemigos){
            e.detener();
        }
    }

    public void liberarEnemigos(){
        for(Enemigo e: enemigos){
            e.restaurarPaso();
        }
    }

   

    public void siguienteOleada(){
        
    }

    public void setPuntajeObjetivo(int puntajeObjetivo){

    }
    public int getPuntajeObjetivo(){
        return 1000;
    }

    public void setTiempoLimite(int tiempoLimite){
        
    }
    public int getTiempoLimite(){
        return 100;
    }

    public void reiniciar(){
        juego.reiniciarNivel();
    }
   
    //Jugador
    public void setSnowBro (int x, int y){
        this.snowBro= fabricaEntidades.getSnowBro(new Posicion(x, y));
        snowBro.setNivelActual(this);
    }

    public void setSnowBro (SnowBro snowNuevo){
        this.snowBro= snowNuevo;
        snowBro.setNivelActual(this);
    }

    // Obstaculos
    public void setParedIzquierda(int x, int y, int estadoSprite, int ancho, int alto){
        Pared pared=fabricaEntidades.getParedIzquierda(new Posicion(x, y));
        pared.setNivelActual(this);
        pared.setDimensiones(ancho, alto);
        listaEntidades.add(pared);
        obstaculos.addLast(pared);
        pared.getSprites().setEstadoActual(estadoSprite);
        //hardcoding
        pared.setEstado(new ParedRebote(pared));
    }

    public void setParedDerecha(int x, int y, int estadoSprite, int ancho, int alto){
        Pared pared=fabricaEntidades.getParedDerecha(new Posicion(x, y));
        pared.setNivelActual(this);
        pared.setDimensiones(ancho, alto);
        listaEntidades.add(pared);
        obstaculos.addLast(pared);
        pared.getSprites().setEstadoActual(estadoSprite);
        //hardcoding
        pared.setEstado(new ParedNormal(pared));
    }

    public void setSueloResbaladizo(int x, int y, int estadoSprite){
        SueloResbaladizo suelo = fabricaEntidades.getSueloResbaladizo(new Posicion(x, y));
        suelo.setNivelActual(this);
        suelo.setDimensiones(100, 30); 
        listaEntidades.add(suelo);
        obstaculos.addLast(suelo);
    }
    public void setParedDestructible(int x, int y, int estadoSprite){
        ParedDestructible pared = fabricaEntidades.getParedDestructible(new Posicion(x, y));
        pared.setNivelActual(this);
        pared.setDimensiones(20, 100); 
        listaEntidades.add(pared);
        obstaculos.addLast(pared);
    }
    public void setTrampa(int x, int y, int estadoSprite){
        Trampa trampa = fabricaEntidades.getTrampa(new Posicion(x, y));
        trampa.setNivelActual(this);
        trampa.setDimensiones(30, 20); 
        listaEntidades.add(trampa);
        obstaculos.addLast(trampa);
    }
    public void setEscalera(int x, int y, int estadoSprite){
        Escalera escalera= fabricaEntidades.getEscalera(new Posicion(x, y));
        escalera.setNivelActual(this);
        escalera.setDimensiones(30, 150); 
        listaEntidades.add(escalera);
        obstaculos.addLast(escalera);
    }
    
    // Powers
    public PowerUp setPocionAzul(int x, int y){
        PowerUp pocionAzul = fabricaEntidades.getPocionAzul(new Posicion(x, y));
        pocionAzul.setNivelActual(this);
        listaEntidades.add(pocionAzul);
        powers.add(pocionAzul); 
        return pocionAzul;
    }
    public PowerUp setPocionRoja(int x, int y){
        PowerUp pocionRoja = fabricaEntidades.getPocionRoja(new Posicion(x, y));
        pocionRoja.setNivelActual(this);
        listaEntidades.add(pocionRoja);
        powers.add(pocionRoja);
        return pocionRoja;
    }
    public PowerUp setFruta(int x, int y){
        PowerUp fruta = fabricaEntidades.getFruta(new Posicion(x, y));
        fruta.setNivelActual(this);
        listaEntidades.add(fruta);
        powers.add(fruta);
        return fruta;
    }
    public PowerUp setPocionVerde(int x, int y){
        PowerUp pocionVerde = fabricaEntidades.getPocionVerde(new Posicion(x, y));
        pocionVerde.setNivelActual(this);
        listaEntidades.add(pocionVerde);
        powers.add(pocionVerde);
        return pocionVerde;
    }
    public PowerUp setVidaExtra(int x, int y){
        PowerUp vidaExtra = fabricaEntidades.getVidaExtra(new Posicion(x, y));
        vidaExtra.setNivelActual(this);
        listaEntidades.add(vidaExtra);
        powers.add(vidaExtra);
        return vidaExtra;
    }

    // Enemigos
    public void setCalabaza(int x, int y){
        Calabaza calabaza = fabricaEntidades.getCalabaza(new Posicion(x, y));
        calabaza.setNivelActual(this);
        listaEntidades.add(calabaza);
        enemigos.add(calabaza);
        juego.registrarObserverNuevaEntidad(calabaza);
    }
    public void setTrollAmarillo(int x, int y){
        TrollAmarillo trollAmarillo = fabricaEntidades.getTrollAmarillo(new Posicion(x, y));
        trollAmarillo.setNivelActual(this);
        listaEntidades.add(trollAmarillo);
        enemigos.add(trollAmarillo);
    }
    public void setFantasma(int x, int y){
        Fantasma fantasma = fabricaEntidades.getFantasma(new Posicion(x, y));
        fantasma.setNivelActual(this);
        juego.registrarObserverNuevaEntidad(fantasma);
        listaEntidades.add(fantasma);
        enemigos.add(fantasma);
    }

    public void setDemonioRojo(int x, int y){
        DemonioRojo demonioRojo = fabricaEntidades.getDemonioRojo(new Posicion(x, y));
        demonioRojo.setNivelActual(this);
        listaEntidades.add(demonioRojo);
        enemigos.add(demonioRojo);
    }

    public void setRanaDeFuego(int x, int y){
        RanaDeFuego rana = fabricaEntidades.getRanaDeFuego(new Posicion(x, y));
        rana.setNivelActual(this);
        listaEntidades.add(rana);
        enemigos.add(rana);
    }
    public void setMoghera(int x, int y, int estadoSprite, int ancho, int alto){
        Moghera moghera = fabricaEntidades.getMoghera(new Posicion(x, y));
        moghera.setNivelActual(this);
        moghera.setDimensiones(ancho, alto);
        moghera.getSprites().setEstadoActual(estadoSprite);
        
        jefeDeNivel = moghera;
    }
    public void setKamakichi(int x, int y, int ancho, int alto){
        Kamakichi kamakichi = fabricaEntidades.getKamakichi(new Posicion(x, y));
        kamakichi.setNivelActual(this);
        kamakichi.setDimensiones(ancho, alto);
        jefeDeNivel = kamakichi;
    }

    //Plataformas
    public void setPlataformaEstatica(int x, int y, int estadoSprite, int ancho, int alto){
        Estatica plataformaEstatica = fabricaEntidades.getPlataformaEstatica(new Posicion(x, y));
        plataformaEstatica.setNivelActual(this);
        plataformaEstatica.setDimensiones(ancho, alto);
        listaEntidades.add(plataformaEstatica);
        plataformas.addLast(plataformaEstatica);
        plataformaEstatica.getSprites().setEstadoActual(estadoSprite);
    }

    public void setPlataformaQuebradiza(int x, int y, int estadoSprite, int ancho, int alto){
        Quebradiza plataformaQuebradiza = fabricaEntidades.getPlataformaQuebradiza(new Posicion(x, y));
        plataformaQuebradiza.setNivelActual(this);
        plataformaQuebradiza.setDimensiones(ancho, alto); 
        listaEntidades.add(plataformaQuebradiza);
        plataformas.addLast(plataformaQuebradiza);
        plataformaQuebradiza.getSprites().setEstadoActual(estadoSprite);
    }

    public void setPlataformaMovedizaAscensor(int x, int y, int limiteSup, int limiteInf, int estadoSprite, int ancho, int alto, Modo modo) {
        Movediza plataforma = fabricaEntidades.getPlataformaMovedizaAscensor(new Posicion(x, y), limiteSup, limiteInf, modo);
        plataforma.setNivelActual(this);
        plataforma.setDimensiones(ancho, alto);
        plataforma.getSprites().setEstadoActual(estadoSprite);

        listaEntidades.add(plataforma);
        plataformas.addLast(plataforma);
    }

    public void setPlataformaMovedizaLateral(int x, int y, int limiteIzq, int limiteDer, int estadoSprite, int ancho, int alto, Modo modo) {
        Movediza plataforma = fabricaEntidades.getPlataformaMovedizaLateral(new Posicion(x, y), limiteIzq, limiteDer, modo);
        plataforma.setNivelActual(this);
        plataforma.setDimensiones(ancho, alto);
        plataforma.getSprites().setEstadoActual(estadoSprite);

        listaEntidades.add(plataforma);
        plataformas.addLast(plataforma);
    }

    //Municiones
    public void setBolaDeNieve(int x, int y, int daño){
        Municion bolaDeNieve = fabricaEntidades.getBolaDeNieve(new Posicion(x, y));
        bolaDeNieve.setNivelActual(this);
        juego.registrarObserverNuevaEntidad(bolaDeNieve);
        if(snowBro.getMirar() == ConstantesTeclado.MIRANDO_DERECHA){
            bolaDeNieve.setPasoX(12);
        } else {
            bolaDeNieve.setPasoX(-12);
        }
        listaEntidades.add(bolaDeNieve);
        municiones.add(bolaDeNieve);
        bolaDeNieve.setDaño(daño);
    }

    public void setBolaDeFuego(int x, int y, int direccion){
        Municion bolaDeFuego = fabricaEntidades.getBolaDeFuego(new Posicion(x, y));
        bolaDeFuego.setNivelActual(this);
        juego.registrarObserverNuevaEntidad(bolaDeFuego);
        if(direccion == ConstantesTeclado.MIRANDO_DERECHA){
            bolaDeFuego.setPasoX(6);
        }else{
            bolaDeFuego.setPasoX(-6);
        }
        bolaDeFuego.setPasoY(0);

        listaEntidades.add(bolaDeFuego);
        municiones.add(bolaDeFuego);
        
    }
    public void setBolaDeFuego(int x, int y, int direccion, int ancho, int alto){
        Municion bolaDeFuego = fabricaEntidades.getBolaDeFuego(new Posicion(x, y));
        bolaDeFuego.setNivelActual(this);
        juego.registrarObserverNuevaEntidad(bolaDeFuego);
        if(direccion == ConstantesTeclado.MIRANDO_DERECHA){
            bolaDeFuego.setPasoX(6);
        }else{
            bolaDeFuego.setPasoX(-6);
        }
        bolaDeFuego.setPasoY(0);

        listaEntidades.add(bolaDeFuego);
        municiones.add(bolaDeFuego);
        bolaDeFuego.setDimensiones(ancho, alto);
        
    }

    public void setBomba(int x, int y, int direccion){
        Municion bomba = fabricaEntidades.getBomba(new Posicion(x, y));
        bomba.setNivelActual(this);
        juego.registrarObserverNuevaEntidad(bomba);
        int velocidadX = ThreadLocalRandom.current().nextInt(2, 10);
        int velocidadY = -ThreadLocalRandom.current().nextInt(20, 30);
        if(direccion == ConstantesTeclado.MIRANDO_DERECHA){
            bomba.setPasoX(velocidadX);
        }else{
            bomba.setPasoX(-velocidadX);
        }
        bomba.setPasoY(velocidadY);

        listaEntidades.add(bomba);
        municiones.add(bomba);
    }
    
    // Colisiones

    public ControladorColisiones getControladorColisiones(){
        return controladorColisiones;
    }

    public SnowBro getSnowBro(){
        return this.snowBro;
    }

    public CopyOnWriteArrayList<Entidad> getEntidades(){
        return this.listaEntidades;
    }

    public LinkedList<Obstaculo> getObstaculos(){
        return this.obstaculos;
    }

    public CopyOnWriteArrayList<Enemigo> getEnemigos(){
        return this.enemigos;
    }

    public CopyOnWriteArrayList<PowerUp> getPowers(){
        return this.powers;
    }

    public LinkedList<Plataforma> getPlataformas(){
        return this.plataformas;
    }

    public CopyOnWriteArrayList<Municion> getMuniciones(){
        return this.municiones;
    }

    public FabricaEntidades getFabricaEntidades(){
        return this.fabricaEntidades;
    }
    
    public void eliminar(PowerUp powerUp){
        this.listaEntidades.remove(powerUp);
        this.powers.remove(powerUp);
    }
    
    public void eliminar(Municion municion){
        this.listaEntidades.remove(municion);
        this.municiones.remove(municion);
    }
    public void eliminar(Plataforma plataforma){
        this.listaEntidades.remove(plataforma);
        this.plataformas.remove(plataforma);
    }
    public void eliminar(Obstaculo obstaculo){
        this.listaEntidades.remove(obstaculo);
        this.obstaculos.remove(obstaculo);
    }
    public void eliminar(Enemigo enemigo){
        this.listaEntidades.remove(enemigo);
        this.enemigos.remove(enemigo);
        modoDeJuego.matarEnemigo();
    }
    public void eliminarJefe(JefeDeNivel jefeDeNivel){
        eliminar(jefeDeNivel);
        this.jefeDeNivel = null;
    }
    public void eliminar(SnowBro snowBro){
        this.listaEntidades.remove(snowBro);
        this.snowBro=null;
    }

    public void generarPowerUp(Posicion posEnemigoEliminado){
        Random random = new Random();
        PowerUp power=null;
        int probabilidad=30;
        int numeroAleatorio1a100 = random.nextInt(100);
        int numAleatorio1a5= random.nextInt(1, 5);
        numeroAleatorio1a100+=1;
        numAleatorio1a5+=1;

        if(numeroAleatorio1a100 <= probabilidad){
            switch (numAleatorio1a5){
                case 1: power= setPocionAzul(posEnemigoEliminado.getX(), posEnemigoEliminado.getY()); break;
                case 2: power= setPocionRoja(posEnemigoEliminado.getX(), posEnemigoEliminado.getY()); break;
                case 3: power= setFruta(posEnemigoEliminado.getX(), posEnemigoEliminado.getY()); break;
                case 4: power= setPocionVerde(posEnemigoEliminado.getX(), posEnemigoEliminado.getY()); break;
                case 5: power= setVidaExtra(posEnemigoEliminado.getX(), posEnemigoEliminado.getY()); break;
            }
            juego.registrarObserverNuevaEntidad(power);

        }

    }

    public void hacerBucle(){
        if(tiempoAparicionCalabaza>0){
            tiempoAparicionCalabaza--;
        }
        else{
            tiempoAparicionCalabaza=ConstantesTeclado.TIEMPO_APARICION_CALABAZA;
            int x = ThreadLocalRandom.current().nextInt(50, 700);
            int y = ThreadLocalRandom.current().nextInt(50, 500);
            setCalabaza(x, y);
        }
        modoDeJuego.actualizarTiempoAscendente();
    }
}
