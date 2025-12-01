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

public class ColisionadorRanaDeFuego implements Colisionador{
    protected RanaDeFuego rana;

    public ColisionadorRanaDeFuego(RanaDeFuego rana){
        this.rana=rana;
    }

    public void colisionar(Estatica estatica){
        int miBaseY = rana.getPosicion().getY() + rana.getBounds().height;
        int plataformaTopeY = estatica.getPosicion().getY();

        if(rana.getPasoY() >= 0 && miBaseY >= plataformaTopeY
            && miBaseY - rana.getPasoY() <= plataformaTopeY+1){
           
            rana.setCayendo(false);
            rana.getPosicion().setY(plataformaTopeY - rana.getBounds().height);
            estatica.hacerEfecto(rana);
        }
    }

    public void colisionar(Pared pared) {
        pared.hacerEfecto(rana);
    }

    public void colisionar(Movediza movediza) {
        movediza.hacerEfecto(rana);
    }


    public void colisionar(Quebradiza quebradiza) {
        quebradiza.hacerEfecto(rana);
    }


    public void colisionar(BolaDeNieve bolaDeNieve) {
        
    }

    public void colisionar(PocionRoja pocionRoja) {
        
    }


    public void colisionar(Escalera escalera) {
        escalera.hacerEfecto(rana);
    }


    public void colisionar(ParedDestructible paredDestructible) {
        rana.hacerEfecto(paredDestructible);
    }


    public void colisionar(SueloResbaladizo sueloResbaladizo) {
        sueloResbaladizo.hacerEfecto(rana);
    }


    public void colisionar(Trampa trampa) {
        trampa.hacerEfecto(rana);
    }

    public void colisionar(Municion municion) {
       
    }

    public void colisionar(SnowBro snowBro) {
        
    }

    public void colisionar(Fruta fruta) {
    }


    public void colisionar(PocionAzul pocionAzul) {
    }


    public void colisionar(PocionVerde pocionVerde) {
    }


    public void colisionar(VidaExtra vidaExtra) {
    }


    public void colisionar(DemonioRojo demonio) {
        demonio.hacerEfecto(rana);
    }

    public void colisionar(Calabaza calabaza) {
        calabaza.hacerEfecto(rana);
    }

    public void colisionar(TrollAmarillo trollAmarillo) {
        trollAmarillo.hacerEfecto(rana);
    }


    public void colisionar(RanaDeFuego ranaDeFuego) {
        ranaDeFuego.hacerEfecto(rana);
    }

    public void colisionar(BolaDeFuego bolaDeFuego) {
    }

    public void colisionar(Fantasma fantasma) {
        fantasma.hacerEfecto(rana);
    }

    public void colisionar(Bomba bomba) {
    }

    public void colisionar(Kamakichi kamakichi) {
        kamakichi.hacerEfecto(rana);
    }

    public void colisionar(Moghera moghera) {
        moghera.hacerEfecto(rana);
    }
}

