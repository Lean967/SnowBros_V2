package src.Enemigo;

import src.Jugador.SnowBro;
import src.Municiones.BolaDeFuego;
import src.Municiones.BolaDeNieve;
import src.Municiones.Bomba;
import src.Municiones.Municion;
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

public class ColisionadorTrollAmarillo implements Colisionador{
    protected TrollAmarillo troll;

    public ColisionadorTrollAmarillo (TrollAmarillo trollAm){
        troll=trollAm;
    }

    public void colisionar(DemonioRojo demonio) {
        demonio.hacerEfecto(troll);
    }

    public void colisionar(Estatica estatica){
        int miBaseY = troll.getPosicion().getY() + troll.getBounds().height;
        int plataformaTopeY = estatica.getPosicion().getY();
        if(troll.getPasoY() >= 0 && miBaseY >= plataformaTopeY
            && miBaseY - troll.getPasoY() <= plataformaTopeY+1){
           
            troll.getPosicion().setY(plataformaTopeY - troll.getBounds().height);
            estatica.hacerEfecto(troll);;
        }
    }

    public void colisionar(Municion municion) {
       
    }



    public void colisionar(SnowBro snowBro) {
        
    }

    public void colisionar(Pared pared) {
        pared.hacerEfecto(troll);
    }


    public void colisionar(Movediza movediza) {
        movediza.hacerEfecto(troll);
    }


    public void colisionar(Quebradiza quebradiza) {
        quebradiza.hacerEfecto(troll);
        
    }


    public void colisionar(BolaDeNieve bolaDeNieve) {
        
    }


    public void colisionar(Calabaza calabaza) {
        calabaza.hacerEfecto(troll);
    }

    public void colisionar(PocionRoja pocionRoja) {
        
    }


    public void colisionar(Escalera escalera) {
        escalera.hacerEfecto(troll);
    }


    public void colisionar(ParedDestructible paredDestructible) {
        troll.hacerEfecto(paredDestructible);
    }


    public void colisionar(SueloResbaladizo sueloResbaladizo) {
        sueloResbaladizo.hacerEfecto(troll);
        
    }


    public void colisionar(Trampa trampa) {
        trampa.hacerEfecto(troll);
    }

    public void colisionar(Fruta fruta) {
    }

    public void colisionar(PocionAzul pocionAzul) {
    }

    public void colisionar(PocionVerde pocionVerde) {
    }

    public void colisionar(VidaExtra vidaExtra) {
    }

    public void colisionar(TrollAmarillo trollAmarillo) {
        trollAmarillo.hacerEfecto(troll);
    }

    public void colisionar(RanaDeFuego ranaDeFuego) {
        ranaDeFuego.hacerEfecto(troll);
    }

    public void colisionar(BolaDeFuego bolaDeFuego) {
    }

    public void colisionar(Fantasma fantasma) {
        fantasma.hacerEfecto(troll);
    }

    public void colisionar(Bomba bomba) {
        
    }

    public void colisionar(Kamakichi kamakichi) {
        kamakichi.hacerEfecto(troll);
    }

    public void colisionar(Moghera moghera) {
        moghera.hacerEfecto(troll);
    }

}
