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
import src.Municiones.Municion;
import src.Visitor.Colisionador;

//solo reduce la velocidad del jugador, a los enemigos no le afecta.
public class SueloResbaladizo extends Obstaculo {

    public SueloResbaladizo(Sprites sprites, Posicion pos) {
        super(sprites, pos);
    }

    public void aceptarColision(Colisionador colisionador) {
        colisionador.colisionar(this);
    }

    public void hacerEfecto(SnowBro snowbro) {
        snowbro.setCayendo(false);
        snowbro.setPasoX(snowbro.getPasoX()/2);
    }

    public void hacerEfecto(DemonioRojo demonio) {
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

    protected SueloResbaladizo crearObstaculo(){
        return new SueloResbaladizo(misSprites, posicion);
    }
}
