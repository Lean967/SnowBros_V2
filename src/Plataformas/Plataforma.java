package src.Plataformas;

import src.Enemigo.Enemigo;
import src.Fabricas.Sprites;
import src.Juego.Entidad;
import src.Juego.Posicion;
import src.Jugador.SnowBro;
import src.Visitor.Colisionable;
import src.Visitor.Colisionador;

public abstract class Plataforma extends Entidad implements Colisionable{
    public Plataforma(Sprites sprites, Posicion posicion){
        super(sprites, posicion);
    }
    

    public abstract void aceptarColision(Colisionador colisionador);

    public void eliminar(){
        eliminarObservers();
        nivelActual.eliminar(this);
    }

    public abstract void hacerEfecto(SnowBro snowbro);

    public void hacerEfecto(Enemigo enemigo){}

    public void mover(){}


    /*public Rectangle getBounds() {
        return new Rectangle(posicion.getX(), posicion.getY(), ancho, alto);
    }*/

    public Plataforma clone(){
        Plataforma plataformaRetorno = crearPlataforma();
        return plataformaRetorno;
    }

    protected abstract Plataforma crearPlataforma();
}
