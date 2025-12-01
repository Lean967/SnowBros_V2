package src.Enemigo.EstadosEnemigo;

import src.CapaDatos.ConstantesTeclado;
import src.Enemigo.Enemigo;
import src.Fabricas.Sprites;
import src.Juego.Posicion;
import src.Jugador.SnowBro;
import src.Municiones.BolaDeNieve;
import src.Obstaculos.Pared;
import src.Obstaculos.ParedDestructible;
public class FantasmaNormal extends EnemigoNormal{
    

    public FantasmaNormal(Enemigo enemigo,Sprites misSprites){
        super(enemigo, misSprites);
        
    }


    public void hacerEfecto(BolaDeNieve bolaDeNieve) {
    }

    public void buscarSnowBro(SnowBro snowBro) {
        int xEnemigo = enemigo.getPosicion().getX();
        int yEnemigo = enemigo.getPosicion().getY();
        int xJugador = snowBro.getPosicion().getX();
        int yJugador = snowBro.getPosicion().getY();
        int velocidad = ConstantesTeclado.VELOCIDAD_ENEMIGO_X;

        if(esperar == 0){
            // Movimiento horizontal
            if (xJugador < xEnemigo) {
                enemigo.setPasoX(-velocidad);
                misSprites.setEstadoActual(ConstantesTeclado.MOVIENDOSE_IZQUIERDA);
            } else if (xJugador > xEnemigo) {
                enemigo.setPasoX(velocidad);
                misSprites.setEstadoActual(ConstantesTeclado.MOVIENDOSE_DERECHA);
            } else {
                enemigo.setPasoX(0);
            }

            // Movimiento vertical
            if (yJugador < yEnemigo) {
                enemigo.setPasoY(-velocidad);
            } else if (yJugador > yEnemigo) {
                enemigo.setPasoY(velocidad);
            } else {
                enemigo.setPasoY(0);
            }

            esperar = 120;
        }else{
            esperar--;
        }

        // Actualizar posición
        Posicion pos = enemigo.getPosicion();
        pos.setX(pos.getX() + enemigo.getPasoX());
        pos.setY(pos.getY() + enemigo.getPasoY());
        enemigo.update();
    }

    

    public void hacerEfecto(SnowBro snowBro) {
        snowBro.perderVida();
    }

    public void hacerEfecto(Enemigo enemigo) {
    }

    public void hacerEfecto(Pared pared) {
        
    }

    public void hacerEfecto(ParedDestructible paredDestructible) {
        
    }
}

