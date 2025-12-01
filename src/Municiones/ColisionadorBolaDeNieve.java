package src.Municiones;

import src.Visitor.Colisionador;

import java.awt.Rectangle;

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

public class ColisionadorBolaDeNieve implements Colisionador {
    protected BolaDeNieve bolaDeNieve;
    private static final int OBS_DEST=150;

    public ColisionadorBolaDeNieve(BolaDeNieve bolaDeNieve){
        this.bolaDeNieve=bolaDeNieve;
    }

    public void colisionar(DemonioRojo demonio){
        bolaDeNieve.eliminar();
        demonio.hacerEfecto(bolaDeNieve);
    }

    public void colisionar(Calabaza calabaza){
        bolaDeNieve.eliminar();
        calabaza.hacerEfecto(bolaDeNieve);
    }
    
    public void colisionar(Municion municion){
        throw new UnsupportedOperationException("Unimplemented method 'colisionar'");
    }
    
    public void colisionar(Estatica estatica){
        Rectangle rectanguloEstatica = estatica.getBounds();
        if(bolaDeNieve.getBounds().intersects(rectanguloEstatica.getX(),rectanguloEstatica.getMinY(),rectanguloEstatica.getWidth(), 1)){
            bolaDeNieve.eliminar();
        }
        
    }
    
    
    
    public void colisionar(SnowBro snowBro){
    }
    
    
    public void colisionar(ParedDestructible paredDestructible) {
        bolaDeNieve.eliminar(); 
        paredDestructible.eliminar();
    }

    public void colisionar(Moghera moghera) {
        bolaDeNieve.eliminar();
        moghera.hacerEfecto(bolaDeNieve);

    }


    public void colisionar(Kamakichi kamakichi) {
        bolaDeNieve.eliminar();
        kamakichi.hacerEfecto(bolaDeNieve);
    }


    public void colisionar(Movediza movediza) {
    }

    public void colisionar(Quebradiza quebradiza) {
    }

    public void colisionar(Pared pared) {
    }

    public void colisionar(BolaDeNieve bolaDeNieve) {
    }


    public void colisionar(PocionRoja pocionRoja) {
        
    }

    public void colisionar(Escalera escalera) {
        
    }

    public void colisionar(SueloResbaladizo sueloResbaladizo) {
        
    }

    public void colisionar(Trampa trampa) {
        int miBaseY = bolaDeNieve.getPosicion().getY() + bolaDeNieve.getBounds().height;
            if(bolaDeNieve.getPasoY() >= 0 && miBaseY >= trampa.getPosicion().getY() 
                && miBaseY - bolaDeNieve.getPasoY() <= trampa.getPosicion().getY()+1){
                trampa.hacerEfecto(bolaDeNieve);;
            }
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
        bolaDeNieve.eliminar();
        trollAmarillo.hacerEfecto(bolaDeNieve);
    }

    public void colisionar(RanaDeFuego ranaDeFuego) {
        bolaDeNieve.eliminar();
        ranaDeFuego.hacerEfecto(bolaDeNieve);
    }

    public void colisionar(BolaDeFuego bolaDeFuego) {
        bolaDeFuego.eliminar();
        bolaDeNieve.eliminar();
    }
    public void colisionar(Fantasma fantasma) {
        fantasma.hacerEfecto(bolaDeNieve);
    }

    public void colisionar(Bomba bomba) {
        bomba.eliminar();
        bolaDeNieve.eliminar();
    }
    
}
