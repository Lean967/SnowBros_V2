package src.Enemigo;

import src.Fabricas.Sprites;
import src.Juego.Posicion;
import src.Visitor.Colisionador;

public class Fantasma extends Enemigo {
    protected static final int PUNTOS_POR_RODAR=400;
    protected static final int PUNTOS_POR_CONGELARSE=200;

    public Fantasma(Sprites sprites, Posicion posicion) {
        super(sprites, posicion);
        //TODO Auto-generated constructor stub
    }


    public void aceptarColision(Colisionador c) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'aceptarColision'");
    }
    
    protected Fantasma crearEnemigo(){
        return new Fantasma(misSprites, posicion);
    }

    public void aumentarPuntajePorEmpujar() {
        this.getNivelActual().getSnowBro().aumentarPuntaje(PUNTOS_POR_RODAR);
    }

    public void aumentarPuntajePorCongelamiento(){
        this.getNivelActual().getSnowBro().aumentarPuntaje(PUNTOS_POR_CONGELARSE);
    }
}
