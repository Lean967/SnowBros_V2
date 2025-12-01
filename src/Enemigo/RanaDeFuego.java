package src.Enemigo;

import src.Enemigo.EstadosEnemigo.RanaDeFuegoNormal;
import src.Fabricas.Sprites;
import src.Juego.Posicion;
import src.Jugador.SnowBro;
import src.Municiones.BolaDeNieve;
import src.Visitor.Colisionador;

public class RanaDeFuego extends Enemigo {

    public RanaDeFuego(Sprites sprites, Posicion posicion) {
        super(sprites, posicion);
        colisionador = new ColisionadorRanaDeFuego(this);
        estado = new RanaDeFuegoNormal(this, misSprites);
        alto = 50;
        ancho = 55;
    }

    public void hacerBucle() {
        incrementarContadorCiclos();
        estado.hacerBucle();
    }

    public void hacerEfecto(Enemigo enemigo) {
        estado.hacerEfecto(enemigo);
    }

    public void hacerEfecto(SnowBro snowBro) {
        estado.hacerEfecto(snowBro);
    }

    public void hacerEfecto(BolaDeNieve bolaDeNieve) {
        estado.hacerEfecto(bolaDeNieve);
    }

    public void aceptarColision(Colisionador c) {
        c.colisionar(this);
    }

    public void buscarSnowBro(SnowBro snow) {
        estado.buscarSnowBro(snow);
    }

    protected Enemigo crearEnemigo() {
        return new RanaDeFuego(misSprites, posicion);
    }

    public Colisionador getColisionador() {
        return colisionador;
    }
}