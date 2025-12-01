package src.Enemigo;

import java.util.Random;

import src.Enemigo.EstadosEnemigo.TrollAmarilloNormal;
import src.Fabricas.Sprites;
import src.Juego.Posicion;
import src.Visitor.Colisionador;

public class TrollAmarillo extends Enemigo {
    protected Random random;
    protected int contadorMovimiento = 0;
    protected String direccionActual;

    public TrollAmarillo(Sprites sprites, Posicion posicion) {
        super(sprites, posicion);
        posInicial = posicion.clonar();
        colisionador = new ColisionadorTrollAmarillo(this);
        vida = 250;
        puntosPorCongelarse = 300;
        puntosPorRodar = 500;
        setEstado(new TrollAmarilloNormal(this, misSprites));
        ancho = 55;
        alto = 50;
    }

    public void aceptarColision(Colisionador c) {
        c.colisionar(this);
    }

    protected TrollAmarillo crearEnemigo(){
        return new TrollAmarillo(misSprites, posicion);
    }
    public Colisionador getColisionador(){
        return colisionador;
    }
    
}
