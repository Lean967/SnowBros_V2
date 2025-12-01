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
    protected int mirar;

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
    public int getMirar(){
        return mirar;
    }
    public void setMirar(int mirar){
        this.mirar = mirar;
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
    public int getVida(){
        return vida;
    }
    
   
}
