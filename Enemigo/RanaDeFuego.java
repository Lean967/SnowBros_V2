package src.Enemigo;

import src.Fabricas.Sprites;
import src.Juego.Posicion;
import src.Visitor.Colisionador;

public class RanaDeFuego extends Enemigo {
    protected static final int PUNTOS_POR_RODAR=500;
    protected static final int PUNTOS_POR_CONGELARSE=300;

    public RanaDeFuego(Sprites sprites, Posicion posicion) {
        super(sprites, posicion);
        //TODO Auto-generated constructor stub
    }


    public void aceptarColision(Colisionador c) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'aceptarColision'");
    }

    protected RanaDeFuego crearEnemigo(){
        return new RanaDeFuego(misSprites, posicion);
    }
    
    public void aumentarPuntajePorEmpujar() {
        this.getNivelActual().getSnowBro().aumentarPuntaje(PUNTOS_POR_RODAR);
    }

    public void aumentarPuntajePorCongelamiento(){
        this.getNivelActual().getSnowBro().aumentarPuntaje(PUNTOS_POR_CONGELARSE);
    }
}
