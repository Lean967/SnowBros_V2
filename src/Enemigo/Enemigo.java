package src.Enemigo;

import src.Juego.Personaje;
import src.Visitor.Colisionable;
import src.Visitor.Colisionador;
import src.CapaDatos.ConstantesTeclado;
import src.CapaDatos.GestorSonido;
import src.Enemigo.EstadosEnemigo.EnemigoCongelado;
import src.Enemigo.EstadosEnemigo.EnemigoNormal;
import src.Enemigo.EstadosEnemigo.EstadoEnemigo;
import src.Enemigo.EstadosEnemigo.EstadosInmovilizado.EnemigoInmovilizadoCuartaFase;
import src.Enemigo.EstadosEnemigo.EstadosInmovilizado.EnemigoInmovilizadoPrimeraFase;
import src.Enemigo.EstadosEnemigo.EstadosInmovilizado.EnemigoInmovilizadoSegundaFase;
import src.Enemigo.EstadosEnemigo.EstadosInmovilizado.EnemigoInmovilizadoTerceraFase;
import src.Fabricas.Sprites;
import src.Juego.Posicion;
import src.Jugador.SnowBro;
import src.Municiones.BolaDeNieve;
import src.Obstaculos.Pared;
import src.Obstaculos.ParedDestructible;

public abstract class Enemigo extends Personaje implements Colisionable{
    protected GestorSonido gestorSonido = GestorSonido.getInstancia();
    protected Colisionador colisionador;
    protected double dañoRecibido;
    protected EstadoEnemigo estado;
    protected int tiempoCongelamiento;
    protected int puntosPorRodar;
    protected int puntosPorCongelarse;
    protected int contadorCiclos;

    public Enemigo(Sprites sprites, Posicion posicion){
        super(sprites, posicion);
        estado=new EnemigoNormal(this,sprites);
        contadorCiclos=0;
        dañoRecibido=0;
        vida = 250;
        pasoX = ConstantesTeclado.VELOCIDAD_ENEMIGO_X ;
        posAnterior=posicion.clonar();

    }

    
    public void buscarSnowBro(SnowBro snowBro){
        posAnterior=posicion.clonar();
        estado.buscarSnowBro(snowBro);
    }

    public void mover(){
        estado.mover();

    }

    public Enemigo clone(){
        Enemigo enemigoRetorno = crearEnemigo();
        return enemigoRetorno;
    }
    protected abstract Enemigo crearEnemigo();

    public void detener(){
        estado.detener();
        update();
    }
    public void restaurarPaso(){
        estado.setPuedeMoverse(true);
    }
    
    public void hacerBucle(){
        estado.hacerBucle();
    }


    public void descongelar(){
        if(tiempoCongelamiento > 0){
            tiempoCongelamiento--;
            if(tiempoCongelamiento==240){
                setDañoRecibido(200);
                actualizarEstadoInmovilizado();
            }
            if(tiempoCongelamiento==180){
                setDañoRecibido(150);
                actualizarEstadoInmovilizado();
            }
            if(tiempoCongelamiento==120){
                setDañoRecibido(100);
                actualizarEstadoInmovilizado();
            }
            if(tiempoCongelamiento==60){
                setDañoRecibido(50);
                actualizarEstadoInmovilizado();
            }
            update();
        }else{
          this.estado = new EnemigoNormal(this, this.misSprites);
          setDañoRecibido(0);
          actualizarEstadoInmovilizado();
        }
    }

    public abstract void aceptarColision(Colisionador c);
    
    public EstadoEnemigo getEstado(){
        return estado;
    }

    public void actualizarSprite(){
        estado.actualizarSprite();
    }
    
    public void setEstado(EstadoEnemigo estado){
        this.estado=estado;
    }
    
    public double getDañoRecibido(){
        return dañoRecibido;
    }

    public void setDañoRecibido(int i) {
        dañoRecibido=i;
    }

    public void recibirImpactoDeBolaDeNieve(int daño) {
        estado.setPuedeMoverse(false);
        dañoRecibido += daño;
        actualizarEstadoInmovilizado();
        update();
    }

    public void hacerEfecto(Enemigo enemigo){
        estado.hacerEfecto(enemigo);
    }

    public void hacerEfecto(Pared pared){
        estado.hacerEfecto(pared);
    }
    public void hacerEfecto(ParedDestructible paredDestructible){
        estado.hacerEfecto(paredDestructible);
    }
    public void hacerEfecto(SnowBro snowBro){
        estado.hacerEfecto(snowBro);
    }

    public void hacerEfecto(BolaDeNieve bolaDeNieve){
        estado.hacerEfecto(bolaDeNieve);
    }

    public void morir(){
        this.eliminar();
    }

    public void eliminar(){
        eliminarObservers();
        nivelActual.eliminar(this);
        nivelActual.generarPowerUp(posicion);
        gestorSonido.reproducirSonido("ENEMIGO_MUERTO");
    }

    public void congelar() {
        estado = new EnemigoCongelado(this, misSprites);
    }

    public Sprites getSprites(){
        return this.estado.misSprites;
    }


    public void setCongelamiento(int congelamiento){
        tiempoCongelamiento = congelamiento;
    }


    public void actualizarEstadoInmovilizado(){
        if (dañoRecibido >= vida) {
            estado = new EnemigoCongelado(this, misSprites);
        }
        else if (dañoRecibido >= vida/5 * 4) {
            estado= new EnemigoInmovilizadoCuartaFase(this, misSprites);
        }
        else if (dañoRecibido >= vida/5 * 3) {
            estado= new EnemigoInmovilizadoTerceraFase(this, misSprites);
        }
        else if (dañoRecibido >= vida/5 * 2) {
            estado= new EnemigoInmovilizadoSegundaFase(this, misSprites);
        }
        else if(dañoRecibido >= vida/5){
            estado= new EnemigoInmovilizadoPrimeraFase(this, misSprites);
        }
        else{
            estado.getSprites().setEstadoActual(ConstantesTeclado.QUIETO);
        }
    }


    public void aumentarPuntajePorEmpujar() {
        this.getNivelActual().getSnowBro().aumentarPuntaje(puntosPorRodar);
    }

    public void aumentarPuntajePorCongelamiento(){
        this.getNivelActual().getSnowBro().aumentarPuntaje(puntosPorCongelarse);
    }


    public abstract Colisionador getColisionador();

    public void disparar(String direccion){}

    public void incrementarContadorCiclos(){
        this.contadorCiclos++;
    }
    
    public void resetearContadorCiclos(){
        this.contadorCiclos = 0;
    }
    
    public int getContadorCiclos() {
        return this.contadorCiclos;
    }
}

