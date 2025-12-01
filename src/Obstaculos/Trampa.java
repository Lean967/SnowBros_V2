package src.Obstaculos;

import src.Enemigo.Calabaza;
import src.Enemigo.DemonioRojo;
import src.Enemigo.Fantasma;
import src.Enemigo.Kamakichi;
import src.Enemigo.Moghera;
import src.Enemigo.RanaDeFuego;
import src.Enemigo.TrollAmarillo;
import src.Fabricas.Sprites;
import src.Juego.Posicion;
import src.Jugador.SnowBro;
import src.Municiones.BolaDeNieve;
import src.Visitor.Colisionador;

public class Trampa extends Obstaculo {

    public Trampa(Sprites sprites, Posicion pos) {
        super(sprites, pos);
    }

    public void aceptarColision(Colisionador colisionador) {
        colisionador.colisionar(this);
    }

    public void hacerEfecto(SnowBro snowbro) {
        snowbro.perderVida();
    }
    public void hacerEfecto(BolaDeNieve bola){
        bola.eliminar();
    }

    //NO LE AFECTA A LOS ENEMIGOS.
    public void hacerEfecto(DemonioRojo demonioRojo) {
    }
    public void hacerEfecto(TrollAmarillo troll) {
    }
    public void hacerEfecto(RanaDeFuego rana) {
    }
    public void hacerEfecto(Calabaza calabaza) {
    }
    public void hacerEfecto(Fantasma fantasma) {
    }
    public void hacerEfecto(Moghera moghera) {
    }
    public void hacerEfecto(Kamakichi kamakichi) {
    }

    protected Trampa crearObstaculo(){
        Trampa nuevaTrampa = new Trampa(misSprites, posicion);
        nuevaTrampa.setDimensiones(ancho, alto);
        return nuevaTrampa;
    }
}
