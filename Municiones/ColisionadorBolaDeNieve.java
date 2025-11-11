package src.Municiones;

import src.Visitor.Colisionador;

import java.awt.Rectangle;

import src.CapaDatos.ConstantesTeclado;
import src.Enemigo.Calabaza;
import src.Enemigo.DemonioRojo;
import src.Jugador.SnowBro;
import src.Obstaculos.Pared;
import src.Obstaculos.ParedDestructible;
import src.Plataformas.Estatica;
import src.Plataformas.Movediza;
import src.Plataformas.Quebradiza;

public class ColisionadorBolaDeNieve implements Colisionador {
    protected BolaDeNieve bolaDeNieve;
    private static final int OBS_DEST=150;

    public ColisionadorBolaDeNieve(BolaDeNieve bolaDeNieve){
        this.bolaDeNieve=bolaDeNieve;
    }

    public void colisionar(DemonioRojo demonio){
        bolaDeNieve.eliminar();
        demonio.hacerEfecto(bolaDeNieve);
        /*demonio.recibirImpacto(ConstantesTeclado.DañoBolaDeNieve);
        demonio.setPasoX(0);
        demonio.setPuedeMoverse(false);*/
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
        throw new UnsupportedOperationException("Unimplemented method 'colisionar'");
    }
    
    
    public void colisionar(ParedDestructible paredDestructible) {
        bolaDeNieve.eliminar(); 
        if (!paredDestructible.getEstadoPared()) {
            paredDestructible.eliminar();
        }
        bolaDeNieve.getNivelActual().getSnowBro().setPuntaje(bolaDeNieve.getNivelActual().getSnowBro().getPuntaje()+OBS_DEST);
    }

    public void colisionar(Movediza movediza) {
    }

    public void colisionar(Quebradiza quebradiza) {
    }

    public void colisionar(Pared pared) {
    }

    public void colisionar(BolaDeNieve bolaDeNieve) {
    }
    
}
