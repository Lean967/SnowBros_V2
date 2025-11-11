package src.Niveles;
import java.awt.List;
import java.awt.Rectangle;
import java.util.LinkedList;
import java.util.Random;

import src.Jugador.Jugador;
import src.Jugador.SnowBro;
import src.Municiones.Municion;
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

    protected LinkedList<Entidad> listaEntidades;
    protected LinkedList<Obstaculo> obstaculos;
    protected LinkedList<Enemigo> enemigos;
    protected SnowBro snowBro;
    protected LinkedList<PowerUp> powers;
    protected LinkedList<Plataforma> plataformas;
    protected LinkedList<Municion> municiones;

    protected FabricaEntidades fabricaEntidades;
    protected ControladorColisiones controladorColisiones;
    protected Juego juego;

    protected Nivel(){
        controladorColisiones = new ControladorColisiones(this);
        listaEntidades = new LinkedList<>();
        obstaculos = new LinkedList<>();
        enemigos = new LinkedList<>();
        powers = new LinkedList<>();
        plataformas = new LinkedList<>();
        municiones = new LinkedList<>();
        oleadas = new LinkedList<>();
        oleadaActual = -1;
    }

    public abstract void iniciarNivel();

    public void setFabricaEntidades (FabricaEntidades fabrica){
        this.fabricaEntidades=fabrica;
    }
    public void setJuego(Juego juego){
        this.juego = juego;
    }

    public Juego getJuego(){
        return juego;
    }

    public void ganar(){
        borrarEntidades();
        juego.ganarNivel();
    }
    
    public void borrarEntidades(){
        for(Entidad entidad : listaEntidades){
            entidad.eliminarObservers();
        }
        snowBro.eliminar();
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


    public void detenerEnemigos(int duracion){
        for(Enemigo e: enemigos){
            e.detener(duracion);
        }
    }

    public void siguienteOleada(){
        Oleada siguienteOleada = oleadas.get(oleadaActual + 1);
        if(siguienteOleada != null){
            oleadaActual++;
            for(Enemigo enemigo : siguienteOleada.getEnemigos()){
                enemigos.addLast(enemigo);
                enemigo.setNivelActual(this);
                juego.registrarObserverNuevaEntidad(enemigo);
            }
        }
        else{
            ganar();
        }
    }

    public void setPuntajeObjetivo(int puntajeObjetivo){

    }

    public void setTiempoLimite(int timepoLimite){
        
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
        listaEntidades.addLast(pared);
        obstaculos.addLast(pared);
        pared.getSprites().setEstadoActual(estadoSprite);
    }

    public void setParedDerecha(int x, int y, int estadoSprite, int ancho, int alto){
        Pared pared=fabricaEntidades.getParedDerecha(new Posicion(x, y));
        pared.setNivelActual(this);
        pared.setDimensiones(ancho, alto);
        listaEntidades.addLast(pared);
        obstaculos.addLast(pared);
        pared.getSprites().setEstadoActual(estadoSprite);
    }

    public void setSueloResbaladizo(int x, int y, int estadoSprite){
        SueloResbaladizo suelo = fabricaEntidades.getSueloResbaladizo(new Posicion(x, y));
        suelo.setNivelActual(this);
        suelo.setDimensiones(100, 70); 
        listaEntidades.addLast(suelo);
        obstaculos.addLast(suelo);
    }
    public void setParedDestructible(int x, int y, int estadoSprite){
        ParedDestructible pared = fabricaEntidades.getParedDestructible(new Posicion(x, y));
        pared.setNivelActual(this);
        pared.setDimensiones(20, 100); 
        listaEntidades.addLast(pared);
        obstaculos.addLast(pared);
    }
    public void setTrampa(int x, int y, int estadoSprite){
        Trampa trampa = fabricaEntidades.getTrampa(new Posicion(x, y));
        trampa.setNivelActual(this);
        trampa.setDimensiones(30, 20); 
        listaEntidades.addLast(trampa);
        obstaculos.addLast(trampa);
    }
    public void setEscalera(int x, int y, int estadoSprite){
        Escalera escalera= fabricaEntidades.getEscalera(new Posicion(x, y));
        escalera.setNivelActual(this);
        escalera.setDimensiones(30, 70); 
        listaEntidades.addLast(escalera);
        obstaculos.addLast(escalera);
    }
    
    // Powers
    public PowerUp setPocionAzul(int x, int y){
        PowerUp pocionAzul = fabricaEntidades.getPocionAzul(new Posicion(x, y));
        pocionAzul.setNivelActual(this);
        listaEntidades.addLast(pocionAzul);
        powers.addLast(pocionAzul); 
        return pocionAzul;
    }
    public PowerUp setPocionRoja(int x, int y){
        PowerUp pocionRoja = fabricaEntidades.getPocionRoja(new Posicion(x, y));
        pocionRoja.setNivelActual(this);
        listaEntidades.addLast(pocionRoja);
        powers.addLast(pocionRoja);
        return pocionRoja;
    }
    public PowerUp setFruta(int x, int y){
        PowerUp fruta = fabricaEntidades.getFruta(new Posicion(x, y));
        fruta.setNivelActual(this);
        listaEntidades.addLast(fruta);
        powers.addLast(fruta);
        return fruta;
    }
    public PowerUp setPocionVerde(int x, int y){
        PowerUp pocionVerde = fabricaEntidades.getPocionVerde(new Posicion(x, y));
        pocionVerde.setNivelActual(this);
        listaEntidades.addLast(pocionVerde);
        powers.addLast(pocionVerde);
        return pocionVerde;
    }
    public PowerUp setVidaExtra(int x, int y){
        PowerUp vidaExtra = fabricaEntidades.getVidaExtra(new Posicion(x, y));
        vidaExtra.setNivelActual(this);
        listaEntidades.addLast(vidaExtra);
        powers.addLast(vidaExtra);
        return vidaExtra;
    }

    // Enemigos
    public void setCalabaza(int x, int y){
        Calabaza calabaza = fabricaEntidades.getCalabaza(new Posicion(x, y));
        calabaza.setNivelActual(this);
        listaEntidades.addLast(calabaza);
        enemigos.addLast(calabaza);
    }
    public void setTrollAmarillo(int x, int y){
        TrollAmarillo trollAmarillo = fabricaEntidades.getTrollAmarillo(new Posicion(x, y));
        trollAmarillo.setNivelActual(this);
        listaEntidades.addLast(trollAmarillo);
        enemigos.addLast(trollAmarillo);
    }
    public void setFantasma(int x, int y);

    public void setDemonioRojo(int x, int y){
        DemonioRojo demonioRojo = fabricaEntidades.getDemonioRojo(new Posicion(x, y));
        demonioRojo.setNivelActual(this);
        listaEntidades.addLast(demonioRojo);
        enemigos.addLast(demonioRojo);
    }

    public void setRanaDeFuego(int x, int y){
        
    }
    public void setMoguera(int x, int y){

    }
    public void setKamakichi(int x, int y){

    }

    //Plataformas
    public void setPlataformaEstatica(int x, int y, int estadoSprite, int ancho, int alto){
        Estatica plataformaEstatica = fabricaEntidades.getPlataformaEstatica(new Posicion(x, y));
        plataformaEstatica.setNivelActual(this);
        plataformaEstatica.setDimensiones(ancho, alto);
        listaEntidades.addLast(plataformaEstatica);
        plataformas.addLast(plataformaEstatica);
        plataformaEstatica.getSprites().setEstadoActual(estadoSprite);
    }

    public void setPlataformaQuebradiza(int x, int y, int estadoSprite, int ancho, int alto){
        Quebradiza plataformaQuebradiza = fabricaEntidades.getPlataformaQuebradiza(new Posicion(x, y));
        plataformaQuebradiza.setNivelActual(this);
        plataformaQuebradiza.setDimensiones(ancho, alto); //le puse un tamanio preestablecido, lo podemos poner desde el lector de nivel
        listaEntidades.addLast(plataformaQuebradiza);
        plataformas.addLast(plataformaQuebradiza);
        plataformaQuebradiza.getSprites().setEstadoActual(estadoSprite);
    }

    public void setPlataformaMovedizaAscensor(int x, int y, int limiteSup, int limiteInf, int estadoSprite, int ancho, int alto, Modo modo) {
        Movediza plataforma = fabricaEntidades.getPlataformaMovedizaAscensor(new Posicion(x, y), limiteSup, limiteInf, modo);
        plataforma.setNivelActual(this);
        plataforma.setDimensiones(ancho, alto);
        plataforma.getSprites().setEstadoActual(estadoSprite);

        listaEntidades.addLast(plataforma);
        plataformas.addLast(plataforma);
    }

    public void setPlataformaMovedizaLateral(int x, int y, int limiteIzq, int limiteDer, int estadoSprite, int ancho, int alto, Modo modo) {
        Movediza plataforma = fabricaEntidades.getPlataformaMovedizaLateral(new Posicion(x, y), limiteIzq, limiteDer, modo);
        plataforma.setNivelActual(this);
        plataforma.setDimensiones(ancho, alto);
        plataforma.getSprites().setEstadoActual(estadoSprite);

        listaEntidades.addLast(plataforma);
        plataformas.addLast(plataforma);
    }

    //Municiones
    public void setBolaDeNieve(int x, int y){
        Municion bolaDeNieve = fabricaEntidades.getBolaDeNieve(new Posicion(x, y));
        bolaDeNieve.setNivelActual(this);
        juego.registrarObserverNuevaEntidad(bolaDeNieve);
        if(snowBro.getMirar() == ConstantesTeclado.SnowBroMirandoDerecha){
            bolaDeNieve.setPasoX(10);
        } else {
            bolaDeNieve.setPasoX(-10);
        }
        listaEntidades.addLast(bolaDeNieve);
        municiones.addLast(bolaDeNieve);
    }

    
    // Colisiones

    public ControladorColisiones getControladorColisiones(){
        return controladorColisiones;
    }

    public SnowBro getSnowBro(){
        return this.snowBro;
    }

    public LinkedList<Entidad> getEntidades(){
        return this.listaEntidades;
    }

    public LinkedList<Obstaculo> getObstaculos(){
        return this.obstaculos;
    }

    public LinkedList<Enemigo> getEnemigos(){
        return this.enemigos;
    }

    public LinkedList<PowerUp> getPowers(){
        return this.powers;
    }

    public LinkedList<Plataforma> getPlataformas(){
        return this.plataformas;
    }

    public LinkedList<Municion> getMuniciones(){
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
        int numAleatorio1a5= random.nextInt(5);
        numeroAleatorio1a100+=1;
        numAleatorio1a5+=1;

        if(numeroAleatorio1a100 < probabilidad){
            switch (numAleatorio1a5){
                case 1: power= setPocionAzul(posEnemigoEliminado.getX(), posEnemigoEliminado.getY());
                case 2: power= setPocionRoja(posEnemigoEliminado.getX(), posEnemigoEliminado.getY());
                case 3: power= setFruta(posEnemigoEliminado.getX(), posEnemigoEliminado.getY());
                case 4: power= setPocionVerde(posEnemigoEliminado.getX(), posEnemigoEliminado.getY());
                case 5: power= setVidaExtra(posEnemigoEliminado.getX(), posEnemigoEliminado.getY());
            }
            juego.registrarObserverNuevaEntidad(power);

        }

    }
}
