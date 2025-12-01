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

public class ColisionadorBolaDeFuego implements Colisionador{
    protected BolaDeFuego bolaDeFuego;

    public ColisionadorBolaDeFuego(BolaDeFuego bola){
        bolaDeFuego=bola;
    }

    public void colisionar(DemonioRojo demonio) {
    }

    public void colisionar(Estatica estatica) {
        bolaDeFuego.eliminar();
    }

    public void colisionar(SnowBro snowBro) {
        bolaDeFuego.eliminar();
        snowBro.hacerEfecto(bolaDeFuego);
    }

    public void colisionar(Pared pared) {
        bolaDeFuego.eliminar();
    }

    public void colisionar(Movediza movediza) {
        bolaDeFuego.eliminar();
    }

    public void colisionar(Quebradiza quebradiza) {
        bolaDeFuego.eliminar();
    }

    public void colisionar(BolaDeNieve bolaDeNieve) {
        bolaDeNieve.eliminar();
        bolaDeFuego.eliminar();
    }

    public void colisionar(Calabaza calabaza) {
    }

    public void colisionar(PocionRoja pocionRoja) {
    }

    public void colisionar(Escalera escalera) {
    }

    public void colisionar(ParedDestructible paredDestructible) {
        bolaDeFuego.eliminar();
    }

    public void colisionar(SueloResbaladizo sueloResbaladizo) {
        bolaDeFuego.eliminar();
    }

    public void colisionar(Trampa trampa) {
        bolaDeFuego.eliminar();
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
        bolaDeFuego.eliminar();
    }

    public void colisionar(Bomba bomba) {
        bomba.eliminar();
        bolaDeFuego.eliminar();
    }

    public void colisionar(BolaDeFuego bolaDeFuego) {
        bolaDeFuego.eliminar();
        bolaDeFuego.eliminar();
    }
}
