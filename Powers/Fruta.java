package src.Powers;

import src.Fabricas.Sprites;
import src.Juego.Posicion;
import src.Jugador.SnowBro;
import src.Visitor.Colisionador;

public class Fruta extends PowerUp {
    protected static final int puntos=500;

    public Fruta(Sprites misSprites, Posicion pos) {
        super(misSprites, pos);
    }
    public void hacerEfecto(SnowBro snowBro) {
        snowBro.aumentarPuntaje(puntos);
    }
    public void aceptarColision(Colisionador c) {
        c.colisionar(this);
    }
    
}
