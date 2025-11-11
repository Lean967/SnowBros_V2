package src.Enemigo;

import src.Fabricas.Sprites;
import src.Juego.Posicion;
import src.Visitor.Colisionador;

public abstract class JefeDeNivel extends Enemigo{
    
    public JefeDeNivel(Sprites sprites, Posicion posicion) {
        super(sprites, posicion);
        //TODO Auto-generated constructor stub
    }

    public void aceptarColision(Colisionador c) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'aceptarColision'");
    }
    
}