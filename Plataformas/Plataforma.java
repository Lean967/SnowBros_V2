package src.Plataformas;

import src.Enemigo.Calabaza;
import src.Enemigo.DemonioRojo;
import src.Enemigo.Fantasma;
import src.Enemigo.Kamakichi;
import src.Enemigo.Moghera;
import src.Enemigo.RanaDeFuego;
import src.Enemigo.TrollAmarillo;
import src.Fabricas.Sprites;
import src.Juego.Entidad;
import src.Juego.Posicion;
import src.Jugador.SnowBro;
import src.Visitor.Colisionable;
import src.Visitor.Colisionador;

public abstract class Plataforma extends Entidad implements Colisionable{
    public Plataforma(Sprites sprites, Posicion posicion){
        super(sprites, posicion);
        //this.ancho = 48; // valor por defecto
        //this.alto = 48;  // valor por defecto
    }
    

    public abstract void aceptarColision(Colisionador colisionador);

    public void eliminar(){
        eliminarObservers();
        nivelActual.eliminar(this);
    }

    public abstract void hacerEfecto(SnowBro snowbro);
    public abstract void hacerEfecto(DemonioRojo demonio);
    public abstract void hacerEfecto(TrollAmarillo troll);
    public abstract void hacerEfecto(RanaDeFuego rana);
    public abstract void hacerEfecto(Calabaza calabaza);
    public abstract void hacerEfecto(Fantasma fantasma);
    public abstract void hacerEfecto(Kamakichi kamakichi);
    public abstract void hacerEfecto(Moghera moghera);
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
