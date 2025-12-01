package src.Municiones;

import src.Enemigo.Calabaza;
import src.Enemigo.DemonioRojo;
import src.Enemigo.Fantasma;
import src.Enemigo.Kamakichi;
import src.Enemigo.Moghera;
import src.Enemigo.RanaDeFuego;
import src.Enemigo.TrollAmarillo;
import src.Jugador.SnowBro;
import src.Obstaculos.Escalera;
import src.Obstaculos.Pared;
import src.Obstaculos.ParedDestructible;
import src.Obstaculos.SueloResbaladizo;
import src.Obstaculos.Trampa;
import src.Plataformas.Estatica;
import src.Plataformas.Movediza;
import src.Plataformas.Quebradiza;
import src.Powers.Fruta;
import src.Powers.PocionAzul;
import src.Powers.PocionRoja;
import src.Powers.PocionVerde;
import src.Powers.VidaExtra;
import src.Visitor.Colisionador;

public class ColisionadorBomba implements Colisionador{
    protected Bomba bomba;

    public ColisionadorBomba(Bomba b){
        bomba=b;
    }

    public void colisionar(DemonioRojo demonio) {
    }

    public void colisionar(Estatica estatica) {
        
    }

    public void colisionar(SnowBro snowBro) {
        bomba.eliminar();
        snowBro.hacerEfecto(bomba);
    }

    public void colisionar(Pared pared) {
        
    }

    public void colisionar(Movediza movediza) {
        
    }

    public void colisionar(Quebradiza quebradiza) {
        
    }

    public void colisionar(BolaDeNieve bolaDeNieve) {
        bolaDeNieve.eliminar();
        bomba.eliminar();
    }

    public void colisionar(Calabaza calabaza) {
    }

    public void colisionar(PocionRoja pocionRoja) {
    }

    public void colisionar(Escalera escalera) {
    }

    public void colisionar(ParedDestructible paredDestructible) {
        
    }

    public void colisionar(SueloResbaladizo sueloResbaladizo) {
        
    }

    public void colisionar(Trampa trampa) {
        
    }

    public void colisionar(Fruta fruta) {
    }

    public void colisionar(PocionAzul pocionAzul) {
    }

    public void colisionar(PocionVerde pocionVerde) {
    }

    public void colisionar(VidaExtra vidaExtra) {
    }

    public void colisionar(TrollAmarillo troll) {
    }

    public void colisionar(RanaDeFuego rana) {
    }

    public void colisionar(Fantasma fantasma) {
    }

    public void colisionar(Moghera moghera) {
    }

    public void colisionar(Kamakichi kamakichi) {
    }

    public void hacerEfecto(ParedDestructible paredDestructible) {

    }

    public void colisionar(Bomba bomba) {
    }

    public void colisionar(BolaDeFuego bolaDeFuego) {
    }
}
