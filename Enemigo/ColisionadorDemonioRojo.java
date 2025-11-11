package src.Enemigo;

import src.Visitor.Colisionador;
import src.Jugador.SnowBro;
import src.Municiones.BolaDeNieve;
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
           
            demonioRojo.setCayendo(false);
            demonioRojo.getPosicion().setY(plataformaTopeY - demonioRojo.getBounds().height);
            estatica.hacerEfecto(demonioRojo);;
        }
    }

    public void colisionar(Municion municion) {
       
    }



    public void colisionar(SnowBro snowBro) {
        
    }

    public void colisionar(Pared pared) {
        demonioRojo.getEstado().hacerEfecto(pared);
    }


    public void colisionar(Movediza movediza) {
        
    }


    public void colisionar(Quebradiza quebradiza) {
        
    }


    public void colisionar(BolaDeNieve bolaDeNieve) {
        
    }


    public void colisionar(Calabaza calabaza) {
        
    }

    public void colisionar(PocionRoja pocionRoja) {
        
    }


    public void colisionar(Escalera escalera) {
        escalera.hacerEfecto(demonioRojo);
    }


    public void colisionar(ParedDestructible paredDestructible) {
        demonioRojo.getEstado().hacerEfecto(paredDestructible);
    }


    public void colisionar(SueloResbaladizo sueloResbaladizo) {
        
    }


    public void colisionar(Trampa trampa) {
        
    }

    @Override
    public void colisionar(Fruta fruta) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'colisionar'");
    }

    @Override
    public void colisionar(PocionAzul pocionAzul) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'colisionar'");
    }

    @Override
    public void colisionar(PocionVerde pocionVerde) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'colisionar'");
    }

    @Override
    public void colisionar(VidaExtra vidaExtra) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'colisionar'");
    }
}
