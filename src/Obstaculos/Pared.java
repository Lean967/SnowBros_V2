package src.Obstaculos;

import src.Enemigo.Calabaza;
import src.Enemigo.DemonioRojo;
import src.Enemigo.Enemigo;
import src.Enemigo.Fantasma;
import src.Enemigo.Kamakichi;
import src.Enemigo.Moghera;
import src.Enemigo.RanaDeFuego;
import src.Enemigo.TrollAmarillo;
import src.Jugador.SnowBro;
import src.Municiones.Municion;
import src.Obstaculos.EstadoPared.ParedNormal;
import src.Visitor.Colisionador;
import src.Fabricas.Sprites;
import src.Juego.Posicion;


public class Pared extends Obstaculo{
   protected ParedNormal estado;

    public Pared(Sprites misSprites,Posicion pos){
        super(misSprites,pos);
        estado= new ParedNormal(this);
    }
    /*public void colisionarCon(SnowBro jugador) {
        jugador.restaurarPosicion();
    }*/

    public void aceptarColision(Colisionador colisionador){
        colisionador.colisionar(this);
    }

    public void hacerEfecto(SnowBro snowbro) {
        snowbro.restaurarPosicion();
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
    public void hacerEfecto(Enemigo enemigo){
        estado.hacerEfecto(enemigo);
    }

    protected Pared crearObstaculo(){
        Pared nuevaPared = new Pared(misSprites, posicion);
        nuevaPared.setDimensiones(ancho, alto);
        return nuevaPared;
    }

    public ParedNormal getEstado(){
        return estado;
    }

    public void setEstado(ParedNormal estado){
        this.estado=estado;
    }

    public void hacerEfecto(DemonioRojo demonio) {
        estado.hacerEfecto(demonio);
    }

    public void hacerEfecto(TrollAmarillo troll) {
        estado.hacerEfecto(troll);
    }

    public void hacerEfecto(RanaDeFuego rana) {
        estado.hacerEfecto(rana);
    }
}
