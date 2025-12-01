package src.Enemigo;

import java.util.concurrent.ThreadLocalRandom;

import src.Enemigo.EstadosEnemigo.EnemigoNormal;
import src.Fabricas.Sprites;
import src.Jugador.SnowBro;
import src.Municiones.BolaDeNieve;

public class CalabazaNormal extends EnemigoNormal{
    protected int tiempoAparicionFantasma;

    public CalabazaNormal(Enemigo enemigo,Sprites misSprites){
        super(enemigo, misSprites);
        tiempoAparicionFantasma = ThreadLocalRandom.current().nextInt(600, 1000);
    }


    public void hacerEfecto(BolaDeNieve bolaDeNieve) {
        int nuevoX = (int)(Math.random() * 800);
        int nuevoY = (int)(Math.random() * 435);

        enemigo.getPosicion().setX(nuevoX);
        enemigo.getPosicion().setY(nuevoY);
        
        
    }

    public void hacerBucle(){
        SnowBro snowBro = enemigo.getNivelActual().getSnowBro();
        buscarSnowBro(snowBro);

        if(tiempoAparicionFantasma > 0){
            tiempoAparicionFantasma--;
        }else{
            enemigo.getNivelActual().setFantasma(enemigo.getPosicion().getX(), enemigo.getPosicion().getY());
            tiempoAparicionFantasma = ThreadLocalRandom.current().nextInt(600, 1000);
        }
    }
   


}
