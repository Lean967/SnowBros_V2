package src.Juego;
import java.awt.Rectangle;

import src.Fabricas.Sprites;
import src.GUI.Observers.Observer;

public interface EntidadLogica {
    public Posicion getPosicion();
    public Sprites getSprites();
    public void registrarObserver(Observer observer);
    
    public Rectangle getBounds();
}