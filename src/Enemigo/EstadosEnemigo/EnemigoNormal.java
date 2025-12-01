package src.Enemigo.EstadosEnemigo;

import src.CapaDatos.ConstantesTeclado;
import src.Enemigo.Enemigo;
import src.Fabricas.Sprites;
import src.Jugador.SnowBro;
import src.Municiones.BolaDeNieve;
import src.Obstaculos.Pared;
import src.Obstaculos.ParedDestructible;

import java.util.concurrent.ThreadLocalRandom;

public class EnemigoNormal extends EstadoEnemigo{
    protected int esperar;

    public EnemigoNormal(Enemigo e, Sprites misSprites) {
        super(e, misSprites);
        puedeMoverse = true;
        esperar = 0;
    }

    public void buscarSnowBro(SnowBro snowBro) {
        if(puedeMoverse){
                
            int diferenciaX = snowBro.getPosicion().getX() - enemigo.getPosicion().getX();
            int diferenciaY = snowBro.getPosicion().getY() - enemigo.getPosicion().getY();

            if (Math.abs(diferenciaY) < 10) {
                if (diferenciaX > 0) {
                    // SnowBro está a la derecha
                    enemigo.setPasoX(ConstantesTeclado.VELOCIDAD_ENEMIGO_X );
                } else if (diferenciaX < 0) {
                    // SnowBro está a la izquierda
                    enemigo.setPasoX(ConstantesTeclado.VELOCIDAD_ENEMIGO_X  *-1);
                }
            }else if(esperar == 0){
                int numAleatorio = ThreadLocalRandom.current().nextInt(-1, 2);
                enemigo.setPasoX(numAleatorio);
                esperar(120);
            }else{
                esperar--;
            }

            this.mover();
            actualizarSprite();
            enemigo.setCayendo(true);
        }

    }

    public void detener(){

        enemigo.setPasoX(0);
        setPuedeMoverse(false);
        getSprites().setEstadoActual(ConstantesTeclado.QUIETO);
        actualizarSprite();
    }

    public void hacerEfecto(SnowBro snowBro) {
        snowBro.perderVida();
    }

    public void hacerEfecto(Pared pared){
        pared.hacerEfecto(enemigo);
    }

    public void esperar(int espera){
        esperar = espera;
    }

    public void hacerEfecto(Enemigo enemigo) {
    }

     public void hacerEfecto(ParedDestructible paredDestructible){
        enemigo.setPasoX(enemigo.getPasoX() * (-1));
    }

    public void hacerEfecto(BolaDeNieve bolaDeNieve) {
        enemigo.recibirImpactoDeBolaDeNieve(bolaDeNieve.getDaño());
    }

    public void hacerBucle(){
        if(puedeMoverse){
            SnowBro snowBro = enemigo.getNivelActual().getSnowBro();
            buscarSnowBro(snowBro);
        }else if(tiempoDescongelamiento>0){
            tiempoDescongelamiento--;
            if(enemigo.getCayendo()){
                puedeMoverse=true;
                this.mover();
            }
            puedeMoverse=false;
        }else{
            puedeMoverse=true;
        }
    }

    public void actualizarSprite(){
        if(enemigo.getPasoX() == 0){
            if (enemigo.getMirar() == ConstantesTeclado.MIRANDO_IZQUIERDA) {
                misSprites.setEstadoActual(ConstantesTeclado.QUIETOIZQUIERDA);
            }else{
                misSprites.setEstadoActual(ConstantesTeclado.QUIETODERECHA);
            }
        }else if(enemigo.getPasoX() > 0){
            misSprites.setEstadoActual(ConstantesTeclado.MOVIENDOSE_DERECHA);
            enemigo.setMirar(ConstantesTeclado.MIRANDO_DERECHA);
        }else{
            misSprites.setEstadoActual(ConstantesTeclado.MOVIENDOSE_IZQUIERDA);
            enemigo.setMirar(ConstantesTeclado.MIRANDO_IZQUIERDA);
        }
    }


}
