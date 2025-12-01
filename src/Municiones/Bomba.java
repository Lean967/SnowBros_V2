package src.Municiones;

import src.CapaDatos.ConstantesTeclado;
import src.Fabricas.Sprites;
import src.Juego.Entidad;
import src.Juego.Posicion;
import src.Visitor.Colisionador;

public class Bomba extends Municion {

    public Bomba(Sprites sprites, Posicion posicion) {
        super(sprites, posicion);
        colisionador = new ColisionadorBomba(this);
    }

    public void mover() {
        if(posicion.getY() <= 600 && posicion.getX() <= 760 && posicion.getX() >= -10){
            posicion.setX(posicion.getX() + pasoX);
            posicion.setY(posicion.getY() + pasoY);
            pasoY = pasoY + ConstantesTeclado.GRAVEDAD;
            update();
        }else{
            eliminar();
        }
        
    }

    public void aceptarColision(Colisionador c) {
        c.colisionar(this);
    }

    public Entidad clone() {
        return new Bomba(misSprites, posicion);
    }
}
