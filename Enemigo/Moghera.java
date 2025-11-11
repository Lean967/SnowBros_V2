package src.Enemigo;

import java.awt.dnd.MouseDragGestureRecognizer;

import src.Fabricas.Sprites;
import src.Juego.Posicion;

public class Moghera extends JefeDeNivel{
    protected static final int PUNTOS_POR_RODAR=5000;
    protected static final int PUNTOS_POR_CONGELARSE=1000;

    public Moghera(Sprites sprites, Posicion posicion) {
        super(sprites, posicion);
    }
    
    protected Moghera crearEnemigo(){
        return new Moghera(misSprites, posicion);
    }

    public void aumentarPuntajePorEmpujar() {
        this.getNivelActual().getSnowBro().aumentarPuntaje(PUNTOS_POR_RODAR);
    }

    public void aumentarPuntajePorCongelamiento(){
        this.getNivelActual().getSnowBro().aumentarPuntaje(PUNTOS_POR_CONGELARSE);
    }
}
