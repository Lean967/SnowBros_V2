package src.Plataformas;

import src.Enemigo.Calabaza;
import src.Enemigo.DemonioRojo;
import src.Enemigo.Enemigo;
import src.Enemigo.Fantasma;
import src.Enemigo.Kamakichi;
import src.Enemigo.Moghera;
import src.Enemigo.RanaDeFuego;
import src.Enemigo.TrollAmarillo;
import src.Fabricas.Sprites;
import src.Juego.Posicion;
import src.Jugador.SnowBro;
import src.Visitor.Colisionador;

public class Estatica extends Plataforma {
    public Estatica(Sprites misSprites, Posicion pos){
        super(misSprites, pos);
    }

    protected Estatica crearPlataforma(){
        Estatica nuevaEstatica = new Estatica(misSprites, posicion);
        nuevaEstatica.setDimensiones(ancho, alto);
        return nuevaEstatica;
    }
    public void colisionarCon(SnowBro jugador) {
        jugador.restaurarPosicion();
    }

    public void aceptarColision(Colisionador colisionador){
        colisionador.colisionar(this);
    }

    public void hacerEfecto(SnowBro snowbro) {
        snowbro.setCayendo(false);
    }
    public void hacerEfecto(Enemigo enemigo){
        enemigo.setCayendo(false);
    }
}
