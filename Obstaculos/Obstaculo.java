package src.Obstaculos;
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
public abstract class Obstaculo extends Entidad  implements Colisionable {
    public Obstaculo(Sprites sprites, Posicion pos){
        super(sprites, pos);
    }
    
    public abstract void aceptarColision(Colisionador colisionador);

    public void eliminar(){
        eliminarObservers();
        nivelActual.eliminar(this);
    }

    public Obstaculo clone(){
        Obstaculo obstaculoRetorno = crearObstaculo();
        return obstaculoRetorno;
    }
    protected abstract Obstaculo crearObstaculo();

    public abstract void hacerEfecto(SnowBro snowbro);
    public abstract void hacerEfecto(DemonioRojo demonio);
    public abstract void hacerEfecto(TrollAmarillo troll);
    public abstract void hacerEfecto(RanaDeFuego rana);
    public abstract void hacerEfecto(Calabaza calabaza);
    public abstract void hacerEfecto(Fantasma fantasma);
    public abstract void hacerEfecto(Moghera moghera);
    public abstract void hacerEfecto(Kamakichi kamakichi);
}
