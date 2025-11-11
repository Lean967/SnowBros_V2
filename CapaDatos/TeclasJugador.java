package src.CapaDatos;

import java.awt.event.KeyEvent;//representa un evento de teclado. Cada vez que el usuario presiona, suelta o escribe una tecla, se genera un KeyEvent que nos permite saber que tecla se presionó
import java.awt.event.KeyListener;

import src.Jugador.SnowBro;

public class TeclasJugador implements KeyListener{
    private boolean arriba, abajo, izquierda, derecha, quieto, espacioPresionado;
    protected SnowBro snowbro;
    protected int direccion;

    public TeclasJugador(SnowBro snowbro) {
        arriba = false;
        abajo = false;
        izquierda = false;
        derecha = false;
        espacioPresionado=false;
        this.snowbro = snowbro;
    }

    public void keyPressed(KeyEvent e) {
        int tecla = e.getKeyCode();
        switch(tecla) {
            case KeyEvent.VK_W:
                arriba = true;
                break;
            case KeyEvent.VK_S:    
                abajo = true;
                break;
            case KeyEvent.VK_A: 
                izquierda = true;
                break;
            case KeyEvent.VK_D:
                derecha = true;
                break;
            case KeyEvent.VK_SPACE:
                if(!espacioPresionado){
                    espacioPresionado = true;
                    snowbro.espacioPresionado();
                }
                break;
        }
    }

    public void keyReleased(KeyEvent e) {
        int tecla = e.getKeyCode();
        switch(tecla) {
            case KeyEvent.VK_W:
                arriba = false;
                break;
            case KeyEvent.VK_S:
                abajo = false;
                break;
            case KeyEvent.VK_A:
                izquierda = false;
                break;
            case KeyEvent.VK_D:
                derecha = false;
                break;
            case KeyEvent.VK_SPACE:
                espacioPresionado = false;
                break;

        }
    }
    public void keyTyped(KeyEvent e) {}
    public boolean getArriba(){
        return arriba;
    }
    public boolean getAbajo(){
        return abajo;
    }
    public boolean getIzquierda(){
        return izquierda;
    }
    public boolean getDerecha(){
        return derecha;
    }
    public boolean getQuieto(){
        return quieto;
    }

    public boolean getEspacioPresionado(){
        return espacioPresionado;
    }

    public SnowBro getSnowBro(){
        return snowbro;
    }

    
}