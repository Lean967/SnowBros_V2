package src.Enemigo;

import src.Fabricas.Sprites;
import src.Juego.Posicion;

public class Kamakichi extends JefeDeNivel {
    protected static final int PUNTOS_POR_RODAR=5000;
    protected static final int PUNTOS_POR_CONGELARSE=1000;

    public Kamakichi(Sprites sprites, Posicion posicion) {
        super(sprites, posicion);
    }

    protected Kamakichi crearEnemigo(){
        return new Kamakichi(misSprites, posicion);
    }
    
    public void aumentarPuntajePorEmpujar() {
        this.getNivelActual().getSnowBro().aumentarPuntaje(PUNTOS_POR_RODAR);
    }

    public void aumentarPuntajePorCongelamiento(){
        this.getNivelActual().getSnowBro().aumentarPuntaje(PUNTOS_POR_CONGELARSE);
    }
}
