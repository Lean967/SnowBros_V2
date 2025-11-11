package src.Municiones;

import src.CapaDatos.ConstantesTeclado;
import src.Fabricas.Sprites;
import src.Juego.Posicion;
import src.Visitor.Colisionador;

public class BolaDeNieve extends Municion {

    public BolaDeNieve(Sprites sprites, Posicion pos) {
        super(sprites, pos);
        colisionador=new ColisionadorBolaDeNieve(this);
        ancho = 12;
        alto = 18;
        this.daño = 50;
        this.pasoY=-5;
    }
    
    public void aceptarColision(Colisionador c){
        c.colisionar(this);
    }

    public void mover(){
        posicion.setX(posicion.getX() + pasoX);
        posicion.setY(posicion.getY() + pasoY);
        pasoY += ConstantesTeclado.Gravedad;
        update();
    }
}
