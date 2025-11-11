package src.Powers;

import src.Enemigo.Enemigo;
import src.Fabricas.Sprites;
import src.Juego.Posicion;
import src.Jugador.SnowBro;
import src.Visitor.Colisionador;

public class PocionVerde extends PowerUp{

    public PocionVerde(Sprites misSprites, Posicion pos) {
        super(misSprites, pos);
    }
    public void hacerEfecto(SnowBro snowBro) {
        Iterable<Enemigo> lista= snowBro.getNivelActual().getEnemigos();
        for (Enemigo e: lista)
            e.detener(4000); //4 segundos
    }
    public void aceptarColision(Colisionador c) {
        c.colisionar(this);
    }
    
}
