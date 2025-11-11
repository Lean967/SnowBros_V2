package src.Enemigo;

import src.Juego.Personaje;
import src.Visitor.Colisionable;
import src.Visitor.Colisionador;
import src.CapaDatos.ConstantesTeclado;
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

public abstract class Enemigo extends Personaje implements Colisionable{
    protected Colisionador colisionador;
    protected double dañoRecibido;
    protected EstadoEnemigo estado;
    protected int tiempoCongelamiento;

    public Enemigo(Sprites sprites, Posicion posicion){
        super(sprites, posicion);
        estado=new EnemigoNormal(this,sprites);
        dañoRecibido=0;
        vida = 250;
        pasoX = ConstantesTeclado.VelocidadEnemigoX;
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

    public void detener(int tiempo){
        this.setPasoX(0);
        this.setPasoY(0);
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
    
    public Colisionador getColisionador(){
        return colisionador;
    }
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

    public void hacerEfecto(SnowBro snowBro){
        estado.hacerEfecto(snowBro);
    }

    public void hacerEfecto(BolaDeNieve bolaDeNieve){
        estado.hacerEfecto(bolaDeNieve);
    }

    public void morir(){
        this.eliminar();
        System.out.println("Enemigo eliminado");
    }

    public void eliminar(){
        eliminarObservers();
        nivelActual.eliminar(this);
        nivelActual.generarPowerUp(posicion);
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
            System.out.println("quinto impacto, congelado!");
        }
        else if (dañoRecibido >= vida/5 * 4) {
            estado= new EnemigoInmovilizadoCuartaFase(this, misSprites);
            System.out.println("cuarto impacto");
        }
        else if (dañoRecibido >= vida/5 * 3) {
            estado= new EnemigoInmovilizadoTerceraFase(this, misSprites);
            System.out.println("tercer impacto");
        }
        else if (dañoRecibido >= vida/5 * 2) {
            estado= new EnemigoInmovilizadoSegundaFase(this, misSprites);
            System.out.println("segundo impacto");
        }
        else if(dañoRecibido >= vida/5){
            estado= new EnemigoInmovilizadoPrimeraFase(this, misSprites);
            System.out.println("primer impacto");
        }
        else{
            estado.getSprites().setEstadoActual(ConstantesTeclado.Quieto);
        }
    }


    public abstract void aumentarPuntajePorEmpujar();


    public abstract void aumentarPuntajePorCongelamiento();
}

