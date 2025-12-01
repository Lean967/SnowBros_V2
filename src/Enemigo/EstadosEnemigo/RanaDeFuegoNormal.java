package src.Enemigo.EstadosEnemigo;

import java.util.concurrent.ThreadLocalRandom;

import src.CapaDatos.ConstantesTeclado;
import src.Enemigo.Enemigo;
import src.Fabricas.Sprites;
import src.Jugador.SnowBro;

public class RanaDeFuegoNormal extends EnemigoNormal {
    protected int tiempoDisparo;

    public RanaDeFuegoNormal(Enemigo enemigo, Sprites misSprites) {
        super(enemigo, misSprites);
        tiempoDisparo = ConstantesTeclado.TIEMPO_DISPARO_RANA;
    }

    public void buscarSnowBro(SnowBro snow) {
        if (puedeMoverse) {
            if(esperar == 0){
                int numAleatorio = ThreadLocalRandom.current().nextInt(-1, 2);
                enemigo.setPasoX(numAleatorio);
                esperar(120);
                if(enemigo.getPasoX() == 0 && tiempoDisparo <= 0){
                    disparar(enemigo.getMirar());
                    tiempoDisparo = ConstantesTeclado.TIEMPO_DISPARO_RANA;
                }
            }else{
                esperar--;
                tiempoDisparo--;
            }
            actualizarSprite();
            this.mover();
        }
    }

    public void disparar(int direccion){
        enemigo.getNivelActual().setBolaDeFuego(enemigo.getPosicion().getX(), enemigo.getPosicion().getY() + 10, direccion);
    }

    
}

