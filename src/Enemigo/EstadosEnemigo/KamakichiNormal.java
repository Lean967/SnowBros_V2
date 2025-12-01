package src.Enemigo.EstadosEnemigo;

import java.util.concurrent.ThreadLocalRandom;

import src.CapaDatos.ConstantesTeclado;
import src.Enemigo.Enemigo;
import src.Fabricas.Sprites;
import src.Jugador.SnowBro;

public class KamakichiNormal extends EnemigoNormal {
    private static final int VELOCIDADY = 1;
    private int duracionAnimacion;

    public KamakichiNormal(Enemigo enemigo, Sprites misSprites) {
        super(enemigo, misSprites);
        esperar = 150;
        duracionAnimacion = -1;
    }

    public void buscarSnowBro(SnowBro snowBro) {

        if(esperar == 0){
            int direccion = ThreadLocalRandom.current().nextInt(-1 , 2);
            enemigo.setPasoY(VELOCIDADY * direccion);
            esperar = 150;
            disparar();
            enemigo.getSprites().setEstadoActual(ConstantesTeclado.ATACANDO);
        }else{
            esperar--;
        }

        mover();
    }

    public void disparar() {
        int xEnemigo = enemigo.getPosicion().getX();
        int yEnemigo = enemigo.getPosicion().getY();

        enemigo.getNivelActual().setBomba(xEnemigo, yEnemigo, ConstantesTeclado.MIRANDO_IZQUIERDA);
        enemigo.getNivelActual().setBomba(xEnemigo, yEnemigo, ConstantesTeclado.MIRANDO_IZQUIERDA);
        enemigo.getNivelActual().setBomba(xEnemigo, yEnemigo, ConstantesTeclado.MIRANDO_DERECHA);
        enemigo.getNivelActual().setBomba(xEnemigo, yEnemigo, ConstantesTeclado.MIRANDO_DERECHA);
    }

    public void mover(){
        int yEnemigo = enemigo.getPosicion().getY();
        if(yEnemigo <= 450 && yEnemigo >= 250){
            enemigo.getPosicion().setY(enemigo.getPasoY() + yEnemigo);
        }else if(yEnemigo > 450){
            enemigo.getPosicion().setY(450);
        }else{
            enemigo.getPosicion().setY(250);
        }

        actualizarSprite();
        enemigo.update();
    }

    public void actualizarSprite(){
        if(enemigo.getPasoY() != 0){
            enemigo.getSprites().setEstadoActual(ConstantesTeclado.SALTANDO);
        }else{
            enemigo.getSprites().setEstadoActual(ConstantesTeclado.QUIETO);
        }
        /*if (enemigo.getDañoRecibido()>=enemigo.getVida()){
            duracionAnimacion=ConstantesTeclado.ANIMACION_PERDER_VIDA-60;
        }*/
    }

    public void hacerBucle(){
        SnowBro snowBro = enemigo.getNivelActual().getSnowBro();
        if(duracionAnimacion==-1){
            buscarSnowBro(snowBro);
        }
        else if(duracionAnimacion>0)
            duracionAnimacion--;
        else if(duracionAnimacion==0){
            enemigo.eliminar();
            duracionAnimacion=-1;
        }
    }

    
}