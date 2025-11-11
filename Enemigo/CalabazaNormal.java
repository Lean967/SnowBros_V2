package src.Enemigo;

import java.util.concurrent.ThreadLocalRandom;

import src.CapaDatos.ConstantesTeclado;
import src.Enemigo.EstadosEnemigo.EnemigoNormal;
import src.Fabricas.Sprites;
import src.Jugador.SnowBro;
import src.Municiones.BolaDeNieve;
public class CalabazaNormal extends EnemigoNormal{


    public CalabazaNormal(Enemigo enemigo,Sprites misSprites){
        super(enemigo, misSprites);
    }


    public void hacerEfecto(BolaDeNieve bolaDeNieve) {
        int nuevoX = (int)(Math.random() * 800); // ancho del nivel
        int nuevoY = (int)(Math.random() * 435); // alto del nivel

        enemigo.getPosicion().setX(nuevoX);
        enemigo.getPosicion().setY(nuevoY);

        System.out.println("La Calabaza se teletransportó a: (" + nuevoX + ", " + nuevoY + ")");
        
        
    }
   


}
