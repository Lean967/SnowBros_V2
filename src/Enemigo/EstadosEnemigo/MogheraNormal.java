package src.Enemigo.EstadosEnemigo;

import java.util.concurrent.ThreadLocalRandom;

import src.CapaDatos.ConstantesTeclado;
import src.Enemigo.Enemigo;
import src.Enemigo.Moghera;
import src.Fabricas.Sprites;
import src.Jugador.SnowBro;

public class MogheraNormal extends EnemigoNormal {

    private static final int FUERZA_SALTO = -20;
    private static final int GRAVEDAD = ConstantesTeclado.GRAVEDAD;
    private static final int VELOCIDAD_HORIZONTAL_LENTA = 1; 
    private static final int VELOCIDAD_CAIDA_MAX = ConstantesTeclado.MAX_VELOCIDAD_CAIDA;
    private static final int FRECUENCIA_DISPARO = 120;
    private static final int FRECUENCIA_MOVIMIENTO_X = 2;

    protected int duracionAnimacion=-1;

    public MogheraNormal(Enemigo enemigo, Sprites sprites) {
        super(enemigo, sprites);
        puedeMoverse = true;
    }

    public void buscarSnowBro(SnowBro snowBro) {
        if (!puedeMoverse) 
             return;
        Moghera moghera = (Moghera) enemigo;

        int diffX = snowBro.getPosicion().getX() - moghera.getPosicion().getX(); 

        if (moghera.getContadorCiclos() % FRECUENCIA_MOVIMIENTO_X == 0) {
            if (diffX > 0) {
                moghera.setPasoX(VELOCIDAD_HORIZONTAL_LENTA); 
            } else if (diffX < 0) {
                 moghera.setPasoX(-VELOCIDAD_HORIZONTAL_LENTA);
            } else {
                moghera.setPasoX(0);
            }
        } else {
            moghera.setPasoX(0); 
        }
        if (moghera.getCayendo()) {
            int nuevaVelY = moghera.getPasoY() + GRAVEDAD;
            moghera.setPasoY(Math.min(nuevaVelY, VELOCIDAD_CAIDA_MAX));
        } else {
            moghera.setPasoY(0);
        }

        if(esperar == 0){
            int probabilidadSalto = 100;
            int numeroAleatorio1a100 = ThreadLocalRandom.current().nextInt(101);
            if(numeroAleatorio1a100 <= probabilidadSalto){
                enemigo.setPasoY(FUERZA_SALTO);
            }
            esperar = 150;
        }else{
            esperar--;
        }


        this.mover();
        moghera.update();
    }

    public void disparar() {
        Moghera moghera = (Moghera) enemigo;
        
        if (moghera.getContadorCiclos() % FRECUENCIA_DISPARO == 0) {
            SnowBro snowBro = moghera.getNivelActual().getSnowBro();
            int diffX = snowBro.getPosicion().getX() - moghera.getPosicion().getX();
            
            int direccion;
            if (diffX > 0) {
                direccion = ConstantesTeclado.MIRANDO_DERECHA;
            } else {
                direccion = ConstantesTeclado.MIRANDO_IZQUIERDA;
            }

            enemigo.getNivelActual().setBolaDeFuego(enemigo.getPosicion().getX(), enemigo.getPosicion().getY(), direccion, 30, 70);
        }
    }

    public void hacerBucle(){
        if(puedeMoverse){
            SnowBro snowBro = enemigo.getNivelActual().getSnowBro();
            if(duracionAnimacion==-1){
                buscarSnowBro(snowBro);
                disparar();
            }
        }
        if(duracionAnimacion>0)
            duracionAnimacion--;
        else if(duracionAnimacion==0){
            enemigo.eliminar();
            duracionAnimacion=-1;
        }
    }

    public void actualizarSprite(){ //OBJETIVO DE DAÑO= 500
        if(enemigo.getPasoX() == 0){
           misSprites.setEstadoActual(ConstantesTeclado.QUIETO);
        }
        if (enemigo.getDañoRecibido()>=enemigo.getVida()){
            enemigo.getSprites().setEstadoActual(ConstantesTeclado.PERDER_VIDA);
            duracionAnimacion=ConstantesTeclado.ANIMACION_PERDER_VIDA-60;
        }
    }


}