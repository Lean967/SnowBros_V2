package src.Powers;
import src.Visitor.Colisionable;
import src.Visitor.Colisionador;
import src.Juego.Entidad;
import src.Fabricas.Sprites;
import src.Juego.Posicion;
import src.Jugador.SnowBro;

public abstract class PowerUp extends Entidad implements Colisionable  {
    public PowerUp(Sprites misSprites, Posicion pos){
        super(misSprites,pos);
        ancho = 20;
        alto = 25;
    }

    public void eliminar(){
        eliminarObservers();
        nivelActual.eliminar(this);
    }
    
    public abstract void hacerEfecto(SnowBro snowBro);
}
