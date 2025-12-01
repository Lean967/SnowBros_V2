package src.Enemigo;

import src.Enemigo.EstadosEnemigo.FantasmaNormal;
import src.Fabricas.Sprites;
import src.Juego.Posicion;
import src.Visitor.Colisionador;

public class Fantasma extends Enemigo {

    public Fantasma(Sprites sprites, Posicion posicion) {
        super(sprites, posicion);
        puntosPorCongelarse = 200;
        colisionador= new ColisionadorFantasma(this);
        estado= new FantasmaNormal(this, sprites);
        puntosPorRodar = 400;
        alto = 45;
        ancho = 40;
    }


    public void aceptarColision(Colisionador c) {
        c.colisionar(this);
    }
    
    protected Fantasma crearEnemigo(){
        return new Fantasma(misSprites, posicion);
    }

    public Colisionador getColisionador() {
        return colisionador;
    }

    public void morir() {
        
    }

}
