package src.Municiones;
import src.Fabricas.Sprites;
import src.Juego.Entidad;
import src.Juego.Posicion;
import src.Visitor.Colisionable;
import src.Visitor.Colisionador;

public abstract class Municion extends Entidad implements Colisionable {
    protected Colisionador colisionador;
    protected int daño;
    protected int pasoX;
    protected int pasoY;


    public Municion(Sprites sprites, Posicion pos){
        super(sprites, pos);
    }


    public void mover() {
        posicion.setX(posicion.getX() + pasoX);
        update();
    }

    public void eliminar(){
        eliminarObservers();
        nivelActual.eliminar(this);
    }


    public void setPasoX(int paso) {
        this.pasoX = paso;
    }
    public void setPasoY(int paso){
        this.pasoY = paso;
    }
    public abstract void aceptarColision(Colisionador c);

    public Colisionador getColisionador(){
        return colisionador;
    }
    public int getDaño(){
        return daño;
    }

}
