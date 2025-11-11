package src.Obstaculos;

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

public class ParedDestructible extends Obstaculo{
    protected boolean rota;

    public ParedDestructible(Sprites sprites, Posicion pos) {
        super(sprites, pos);
        rota=false;
    }

    public void aceptarColision(Colisionador colisionador) {
        colisionador.colisionar(this); //en el colsionador del enemigo congelado deberia romperse la estructura le seteo true y elimino el sprite.
    }
    public void setEstadoPared(boolean rota){
        this.rota=rota;
    }
    public boolean getEstadoPared(){
        return rota;
    }

    protected ParedDestructible crearObstaculo(){
        return new ParedDestructible(misSprites, posicion);
    }
}
