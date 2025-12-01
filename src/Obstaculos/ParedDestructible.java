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

public class ParedDestructible extends Obstaculo{
    protected boolean rota;
    protected int puntaje;
    Colisionador colisionador;

    public ParedDestructible(Sprites sprites, Posicion pos) {
        super(sprites, pos);
        colisionador= new ColisionadorParedDestructible(this);
        rota=false;
        puntaje = 150;
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
    public int getPuntaje(){
        return puntaje;
    }

    protected ParedDestructible crearObstaculo(){
        ParedDestructible nuevaPared = new ParedDestructible(misSprites, posicion);
        nuevaPared.setDimensiones(ancho, alto);
        return nuevaPared;
    }

    public void hacerEfecto(SnowBro snowbro) {
        
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

    
}
