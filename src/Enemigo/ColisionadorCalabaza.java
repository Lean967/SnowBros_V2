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

public class ColisionadorCalabaza implements Colisionador{
    protected Calabaza calabaza;

    public ColisionadorCalabaza(Calabaza calabaza){
        this.calabaza = calabaza;
    }

    public void colisionar(Estatica estatica){
        int miBaseY = calabaza.getPosicion().getY() + calabaza.getBounds().height;
        int plataformaTopeY = estatica.getPosicion().getY();

        if(calabaza.getPasoY() >= 0 && miBaseY >= plataformaTopeY
            && miBaseY - calabaza.getPasoY() <= plataformaTopeY+1){
           
            calabaza.setCayendo(false);
            calabaza.getPosicion().setY(plataformaTopeY - calabaza.getBounds().height);
            estatica.hacerEfecto(calabaza);;
        }
    }

    public void colisionar(Pared pared) {
        calabaza.setPasoX(calabaza.getPasoX() * (-1));
    }

    public void colisionar(Movediza movediza) {
        int miBaseY = calabaza.getPosicion().getY() + calabaza.getBounds().height;
        int plataformaTopeY = movediza.getPosicion().getY();

        if(calabaza.getPasoY() >= 0 && miBaseY >= plataformaTopeY
            && miBaseY - calabaza.getPasoY() <= plataformaTopeY+1){
           
            calabaza.setCayendo(false);
            calabaza.getPosicion().setY(plataformaTopeY - calabaza.getBounds().height);
            movediza.hacerEfecto(calabaza);;
        }
    }


    public void colisionar(Quebradiza quebradiza) {
        int miBaseY = calabaza.getPosicion().getY() + calabaza.getBounds().height;
        int plataformaTopeY = quebradiza.getPosicion().getY();

        if(calabaza.getPasoY() >= 0 && miBaseY >= plataformaTopeY
            && miBaseY - calabaza.getPasoY() <= plataformaTopeY+1){
           
            calabaza.setCayendo(false);
            calabaza.getPosicion().setY(plataformaTopeY - calabaza.getBounds().height);
            quebradiza.hacerEfecto(calabaza);;
        }
    }


    public void colisionar(BolaDeNieve bolaDeNieve) {
        
    }


    public void colisionar(Calabaza calabaza) {
        
    }

    public void colisionar(PocionRoja pocionRoja) {
        
    }


    public void colisionar(Escalera escalera) {
        escalera.hacerEfecto(calabaza);
    }


    public void colisionar(ParedDestructible paredDestructible) {
        
    }


    public void colisionar(SueloResbaladizo sueloResbaladizo) {
        
    }


    public void colisionar(Trampa trampa) {
        
    }

    public void colisionar(Municion municion) {
       
    }



    public void colisionar(SnowBro snowBro) {
        
    }

    public void colisionar(DemonioRojo demonio) {
        demonio.hacerEfecto(calabaza);
    }

    @Override
    public void colisionar(Fruta fruta) {
    }

    @Override
    public void colisionar(PocionAzul pocionAzul) {
    }

    @Override
    public void colisionar(PocionVerde pocionVerde) {
    }

    @Override
    public void colisionar(VidaExtra vidaExtra) {
    }

    @Override
    public void colisionar(TrollAmarillo trollAmarillo) {
    }

    @Override
    public void colisionar(RanaDeFuego ranaDeFuego) {
    }

    
    public void colisionar(BolaDeFuego bolaDeFuego) {
    }

    public void colisionar(Fantasma fantasma) {
        fantasma.hacerEfecto(calabaza);
    }


    public void colisionar(Bomba bomba) {
    }

    public void colisionar(Kamakichi kamakichi) {
    }

    public void colisionar(Moghera moghera) {
    }
}
