package src.Enemigo;

import src.Visitor.Colisionador;
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

public class ColisionadorDemonioRojo implements Colisionador {
    protected DemonioRojo demonioRojo;

    public ColisionadorDemonioRojo (DemonioRojo demonioRojo){
        this.demonioRojo=demonioRojo;
    }

    public void colisionar(DemonioRojo demonio) {
        demonio.hacerEfecto(demonioRojo);
    }

    public void colisionar(Estatica estatica){
        int miBaseY = demonioRojo.getPosicion().getY() + demonioRojo.getBounds().height;
        int plataformaTopeY = estatica.getPosicion().getY();
        if(demonioRojo.getPasoY() >= 0 && miBaseY >= plataformaTopeY
            && miBaseY - demonioRojo.getPasoY() <= plataformaTopeY+1){
           
            demonioRojo.getPosicion().setY(plataformaTopeY - demonioRojo.getBounds().height);
            estatica.hacerEfecto(demonioRojo);;
        }
    }

    public void colisionar(Municion municion) {
       
    }



    public void colisionar(SnowBro snowBro) {
        
    }

    public void colisionar(Pared pared) {
        demonioRojo.hacerEfecto(pared);
    }


    public void colisionar(Movediza movediza) {
        movediza.hacerEfecto(demonioRojo);
    }


    public void colisionar(Quebradiza quebradiza) {
        quebradiza.hacerEfecto(demonioRojo);
    }


    public void colisionar(BolaDeNieve bolaDeNieve) {
        
    }


    public void colisionar(Calabaza calabaza) {
        calabaza.hacerEfecto(demonioRojo);
    }

    public void colisionar(PocionRoja pocionRoja) {
        
    }


    public void colisionar(Escalera escalera) {
        escalera.hacerEfecto(demonioRojo);
    }


    public void colisionar(ParedDestructible paredDestructible) {
        demonioRojo.hacerEfecto(paredDestructible);
    }


    public void colisionar(SueloResbaladizo sueloResbaladizo) {
        sueloResbaladizo.hacerEfecto(demonioRojo);
    }


    public void colisionar(Trampa trampa) {
        trampa.hacerEfecto(demonioRojo);
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
        trollAmarillo.hacerEfecto(demonioRojo);
    }

    public void colisionar(RanaDeFuego ranaDeFuego) {
        ranaDeFuego.hacerEfecto(demonioRojo);
    }

    public void colisionar(BolaDeFuego bolaDeFuego) {
    }

    public void colisionar(Fantasma fantasma) {
        fantasma.hacerEfecto(demonioRojo);
    }

    public void colisionar(Bomba bomba) {
        
    }

    public void colisionar(Kamakichi kamakichi) {
        kamakichi.hacerEfecto(demonioRojo);
    }

    public void colisionar(Moghera moghera) {
        moghera.hacerEfecto(demonioRojo);
    }
}
