package src.Enemigo.EstadosEnemigo;

import src.CapaDatos.ConstantesTeclado;
import src.Enemigo.Enemigo;
import src.Fabricas.Sprites;
import src.Jugador.SnowBro;
import src.Municiones.BolaDeNieve;
import src.Obstaculos.Pared;
import src.Obstaculos.ParedDestructible;

public class EnemigoCongeladoImpulsado extends EstadoEnemigo{

    public EnemigoCongeladoImpulsado(Enemigo enemigo, Sprites misSprites,int pasoX){
        super(enemigo, misSprites);
        misSprites.setEstadoActual(ConstantesTeclado.Rodando);
        enemigo.setPasoX(pasoX);
    }
    public void hacerBucle() {
        enemigo.mover();
    }

    public void buscarSnowBro(SnowBro snowBro) {
        
    }

    public void hacerEfecto(SnowBro snowBro) {
        misSprites.setEstadoActual(ConstantesTeclado.RodandoConSnow);
        //snowBro.hacerInvisible();
        
    }

    public void hacerEfecto(Pared pared){
       enemigo.eliminar();
       //snowBro.setPosicion(enemigo.getPosicion());
    }

    public void hacerEfecto(Enemigo enemigo) {
        if(this.enemigo.getPasoX() != 0){
            enemigo.morir();
        }
    }

    public void hacerEfecto(BolaDeNieve bolaDeNieve) {
        
    }
    public void hacerEfecto(ParedDestructible paredDestructible){
        paredDestructible.setEstadoPared(true);
        paredDestructible.eliminar();
    }

    public void moverEnX(){
        if(((enemigo.getPosicion().getX() + enemigo.getPasoX() >= 760 ) || 
            (enemigo.getPosicion().getX() + enemigo.getPasoX() <= -10)) && enemigo.getPosicion().getY() <= 500){

            enemigo.setPasoX(enemigo.getPasoX() * -1);
        }else{
            enemigo.getPosicion().setX(enemigo.getPosicion().getX() + enemigo.getPasoX());
        }
    }
    
}
