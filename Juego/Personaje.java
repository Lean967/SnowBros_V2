package src.Juego;

import src.Fabricas.Sprites;

public abstract class Personaje extends Entidad {
    protected int vida;
    protected int velocidad;
    protected ControladorColisiones controladorColisiones;
    protected int pasoY;
    protected int pasoX;
    protected boolean cayendo;
    protected int puntaje=0;

    public Personaje(Sprites misSprites, Posicion posicion) {
        super(misSprites, posicion);
        cayendo = true;
    }
    
    public void setCayendo(boolean caer){
        this.cayendo=caer;
    }
    public boolean getCayendo(){
        return cayendo;
    }
    public int getPasoY(){
        return pasoY;
    }
    public int getPasoX(){
        return pasoX;
    }
    public void setPasoX(int paso){
        pasoX=paso;
    }
    public void setPasoY(int paso){
        pasoY=paso;
    }
    public void disparar(){

    }

    public void subirBajarEscalera(){
    }
    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int p){
        puntaje=puntaje+p;
    }
    
   
}
