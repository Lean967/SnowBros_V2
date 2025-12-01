package src.Enemigo;

import src.Jugador.SnowBro;
import src.Municiones.BolaDeFuego;
import src.Municiones.BolaDeNieve;
import src.Municiones.Bomba;
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

public class ColisionadorMoghera implements Colisionador{
    protected Moghera moghera;

    public ColisionadorMoghera(Moghera moghera){
        this.moghera = moghera;
    }

    public void colisionar(Enemigo enemigo){
        enemigo.hacerEfecto(moghera);
    }

    public void colisionar(DemonioRojo demonio) {
        
    }

    public void colisionar(Estatica estatica){
        int miBaseY = moghera.getPosicion().getY() + moghera.getBounds().height;
        int plataformaTopeY = estatica.getPosicion().getY();
        if(moghera.getPasoY() >= 0 && miBaseY >= plataformaTopeY
            && miBaseY - moghera.getPasoY() <= plataformaTopeY+1){
           
            moghera.setCayendo(false);
            moghera.getPosicion().setY(plataformaTopeY - moghera.getBounds().height);
            estatica.hacerEfecto(moghera);;
        }
    }

    public void colisionar(SnowBro snowBro) {
        snowBro.perderVida();
    }

    public void colisionar(Pared pared) {
        pared.hacerEfecto(moghera);
    }

    public void colisionar(Movediza movediza) {
        movediza.hacerEfecto(moghera);
    }

    public void colisionar(Quebradiza quebradiza) {
        quebradiza.hacerEfecto(moghera);
    }

    public void colisionar(BolaDeNieve bolaDeNieve) {
        
    }

   


    public void colisionar(PocionRoja pocionRoja) {
        
    }

    public void colisionar(Escalera escalera) {
        escalera.hacerEfecto(moghera);
    }

    public void colisionar(ParedDestructible paredDestructible) {
        paredDestructible.hacerEfecto(moghera);
    }

    public void colisionar(SueloResbaladizo sueloResbaladizo) {
        sueloResbaladizo.hacerEfecto(moghera);
    }

    public void colisionar(Trampa trampa) {
        trampa.hacerEfecto(moghera);
    }

    public void colisionar(Fruta fruta) {
        
    }

    public void colisionar(PocionAzul pocionAzul) {
        
    }

    public void colisionar(PocionVerde pocionVerde) {
        
    }

    public void colisionar(VidaExtra vidaExtra) {
        
    }

   
    public void colisionar(BolaDeFuego bolaDeFuego) {
        
    }

    public void colisionar(Fantasma fantasma) {
        
    }

    public void colisionar(Bomba bomba) {
    }

    public void colisionar(Kamakichi kamakichi) {
    }

    public void colisionar(Moghera moghera) {
    }

    public void colisionar(Calabaza calabaza) {
    }

    public void colisionar(TrollAmarillo trollAmarillo) {
    }

    public void colisionar(RanaDeFuego ranaDeFuego) {
    
    }
}

