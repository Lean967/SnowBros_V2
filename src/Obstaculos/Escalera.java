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
import src.Visitor.Colisionador;

public class Escalera extends Obstaculo {

    public Escalera(Sprites sprites, Posicion pos) {
        super(sprites, pos);
    }

    public void aceptarColision(Colisionador colisionador) {
        colisionador.colisionar(this);
    }

    public void hacerEfecto(SnowBro snowbro) {
        snowbro.subirBajarEscalera();
        snowbro.setVelocidadDefectoX(snowbro.getVelocidadDefectoX()/4);
    }
    public void hacerEfecto(DemonioRojo demonio) {
        //no puede subir y bajar escaleras.
    }
    public void hacerEfecto(TrollAmarillo troll) {
        //no puede subir y bajar escaleras.
    }
    public void hacerEfecto(RanaDeFuego rana) {
        rana.setPasoY(rana.getPasoY()+1);
    }
    public void hacerEfecto(Calabaza calabaza) {
        //no puede subir y bajar escaleras.
    }
    public void hacerEfecto(Fantasma fantasma) {
        //no puede subir y bajar escaleras.
    }
    public void hacerEfecto(Moghera moghera) {
        //no puede subir y bajar escaleras.
    }
    public void hacerEfecto(Kamakichi kamakichi) {
        //no puede subir y bajar escaleras.
    }

    protected Escalera crearObstaculo(){
        Escalera nuevaEscalera = new Escalera(misSprites, posicion);
        nuevaEscalera.setDimensiones(ancho, alto);
        return nuevaEscalera;
    }
}
