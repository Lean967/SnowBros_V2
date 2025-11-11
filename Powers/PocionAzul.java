package src.Powers;

import src.Fabricas.Sprites;
import src.Juego.Posicion;
import src.Jugador.SnowBro;
import src.Visitor.Colisionador;

public class PocionAzul extends PowerUp {

    public PocionAzul(Sprites misSprites, Posicion pos) {
        super(misSprites, pos);
    }
    public void hacerEfecto(SnowBro snowBro) {
        snowBro.setEstadoAzul();
    }
    public void aceptarColision(Colisionador c) {
        c.colisionar(this);
    }
}
