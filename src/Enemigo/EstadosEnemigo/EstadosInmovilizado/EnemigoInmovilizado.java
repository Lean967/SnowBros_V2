package src.Enemigo.EstadosEnemigo.EstadosInmovilizado;

import src.Enemigo.Enemigo;
import src.Enemigo.EstadosEnemigo.EstadoEnemigo;
import src.Fabricas.Sprites;
import src.Jugador.SnowBro;
import src.Municiones.BolaDeNieve;
import src.Obstaculos.Pared;
import src.Obstaculos.ParedDestructible;

public abstract class EnemigoInmovilizado extends EstadoEnemigo{
    public EnemigoInmovilizado(Enemigo e, Sprites misSprites) {
        super(e, misSprites);
        this.puedeMoverse = false;
    }

    public boolean puedeMoverse() {
        return this.puedeMoverse;
    }

    public void detener(){
        enemigo.setPasoX(0);
    }

    public void sumarCongelamiento(int suma){
        tiempoDescongelamiento += suma;
    }

    
    public void hacerBucle(){
        enemigo.descongelar();
        moverEnY();
    }

    public void hacerEfecto(BolaDeNieve bolaDeNieve) {
        enemigo.recibirImpactoDeBolaDeNieve(bolaDeNieve.getDaño());
    }

    public void hacerEfecto(SnowBro snowBro){

    }
    public void hacerEfecto(Enemigo enemigo){
    
    }

    public void hacerEfecto(Pared pared){
        
    }
    
    public void hacerEfecto(ParedDestructible paredDestructible){
        enemigo.setPasoX(enemigo.getPasoX() * (-1));
    }

    public void buscarSnowBro(SnowBro snowBro){

    }


}