package src.Municiones;

import src.CapaDatos.ConstantesTeclado;
import src.Fabricas.Sprites;
import src.Juego.Entidad;
import src.Juego.Posicion;
import src.Visitor.Colisionador;

public class BolaDeNieve extends Municion {

    public BolaDeNieve(Sprites sprites, Posicion pos) {
        super(sprites, pos);
        colisionador=new ColisionadorBolaDeNieve(this);
        ancho = 16;
        alto = 16;
        this.daño = ConstantesTeclado.DAÑO_BOLA_NIEVE;
        this.pasoY=-4;
    }
    
    public void aceptarColision(Colisionador c){
        c.colisionar(this);
    }

    public void mover(){
        posicion.setX(posicion.getX() + pasoX);
        posicion.setY(posicion.getY() + pasoY);
        pasoY += ConstantesTeclado.GRAVEDAD;
        update();
    }

    public Entidad clone() {
        return new BolaDeNieve(misSprites, posAnterior);
    }
    
    public void setDaño(int nuevoDaño){
        this.daño=nuevoDaño;
    }
}
