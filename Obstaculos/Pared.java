package src.Obstaculos;

import src.Enemigo.Calabaza;
import src.Enemigo.DemonioRojo;
import src.Enemigo.Fantasma;
import src.Enemigo.Kamakichi;
import src.Enemigo.Moghera;
import src.Enemigo.RanaDeFuego;
import src.Enemigo.TrollAmarillo;
import src.Jugador.SnowBro;
import src.Municiones.Municion;
import src.Visitor.Colisionador;
import src.Fabricas.Sprites;
import src.Juego.Posicion;

public class Pared extends Obstaculo{
    public Pared(Sprites misSprites,Posicion pos){
        super(misSprites,pos);
    }
    public void colisionarCon(SnowBro jugador) {
        jugador.restaurarPosicion();
    }

    public void aceptarColision(Colisionador colisionador){
        colisionador.colisionar(this);
    }

    public void hacerEfecto(SnowBro snowbro) {
        snowbro.restaurarPosicion();
    }
    public void hacerEfecto(DemonioRojo demonioRojo) {
        demonioRojo.restaurarPosicion();
    }
    public void hacerEfecto(TrollAmarillo troll) {
        troll.restaurarPosicion();
    }
    public void hacerEfecto(RanaDeFuego rana) {
        rana.restaurarPosicion();
    }
    public void hacerEfecto(Calabaza calabaza) {
        calabaza.restaurarPosicion();
    }
    public void hacerEfecto(Fantasma fantasma) {
        fantasma.restaurarPosicion();
    }
    public void hacerEfecto(Moghera moghera) {
        moghera.restaurarPosicion();
    }
    public void hacerEfecto(Kamakichi kamakichi) {
        kamakichi.restaurarPosicion();
    }
    public void hacerEfecto(Municion municion){
        municion.eliminar();
    }

    protected Pared crearObstaculo(){
        return new Pared(misSprites, posicion);
    }
}
