package src.Juego;

import java.awt.Rectangle;
import java.util.LinkedList;
import java.util.List;
import src.Fabricas.Sprites;
import src.GUI.Observers.Observer;
import javax.swing.SwingUtilities;
import src.Niveles.Nivel;


public abstract class Entidad implements EntidadLogica { 
    protected Posicion posicion;
    protected List<Observer> observers;
    protected Sprites misSprites;
    protected ControladorColisiones controladorColisiones;
    protected int ancho;
    protected int alto;
    protected Posicion posAnterior;
    protected Nivel nivelActual;
    protected Posicion posInicial;

    public Entidad(Sprites sprites, Posicion pos){
        this.misSprites = sprites;
        this.posicion = pos;
        this.posInicial=pos.clonar();
        this.observers= new LinkedList<>();
        this.ancho = 40; // valor por defecto
        this.alto = 45;  // valor por defecto
    }

    public void getState(){}
    public void setState(){}

    public void update(){
        for (Observer o : observers) {
            if (SwingUtilities.isEventDispatchThread()) {
                o.update();
            } else {
                SwingUtilities.invokeLater(() -> o.update());
            }
        }
    }
    public void eliminarObservers(){
        for (Observer o : observers) {
            o.eliminarEntidad(this);
        }
        observers.clear();
    }

    public void setDimensiones(int ancho, int alto) {
        this.ancho = ancho;
        this.alto = alto;
    }

    public abstract Entidad clone();
    
    public void registrarObserver(Observer observer){
        this.observers.add(observer);
    }

    public void setPosicion(int deltax, int deltay){
        this.posicion.setX(posicion.getX()+deltax);
        this.posicion.setY(posicion.getY()+deltay);
    }

    public Posicion getPosicion(){
        return this.posicion;
    }

    public Sprites getSprites() {
        return misSprites;
    }

    public void setNivelActual(Nivel nivel){
        this.nivelActual=nivel;
    }
    public Nivel getNivelActual(){
        return this.nivelActual;
    }
    

    public Rectangle getBounds() {
        return new Rectangle(posicion.getX(), posicion.getY(), ancho, alto);
    }

    public void setControladorColisiones(ControladorColisiones controladorColisiones){
        this.controladorColisiones= controladorColisiones;
    }

    public ControladorColisiones getControladorColisiones(){
        return this.controladorColisiones;
    }
    public void restaurarPosicion() {
        posicion.setX(posAnterior.getX());
        posicion.setY(posAnterior.getY());
    }
}