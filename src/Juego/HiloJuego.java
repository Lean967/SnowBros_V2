package src.Juego;

import src.Enemigo.Enemigo;
import src.Municiones.Municion;
import src.Plataformas.Plataforma;
import src.Powers.PowerUp;

public class HiloJuego extends Thread{
    protected Juego juego;
    private volatile boolean corriendo;

    public HiloJuego(String nombre){
        super(nombre);
        corriendo = true;
    }

    public void setJuego(Juego juego){
        this.juego = juego;
    }

    public void detener(){
        corriendo = false;
    }

    public void run(){
        try{
            while(corriendo){
                
                
                juego.getNivelActual().getSnowBro().mover();
                juego.getNivelActual().getSnowBro().hacerBucle();
                for (Enemigo enemigo :  juego.getNivelActual().getEnemigos()){
                    enemigo.hacerBucle();
                }
                for( Municion municion :  juego.getNivelActual().getMuniciones()){
                    municion.mover();
                }
                for (Plataforma plataforma:  juego.getNivelActual().getPlataformas()){
                    plataforma.mover();
                }
                for(PowerUp powerUp : juego.getNivelActual().getPowers()){
                    powerUp.hacerBucle();
                }
                juego.getNivelActual().hacerBucle();
                
                juego.getNivelActual().getControladorColisiones().detectarColisiones();

                juego.getModoDeJuego().hacerBucle();

                sleep(17);
            }
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
