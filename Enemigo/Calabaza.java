package src.Enemigo;

import src.Enemigo.EstadosEnemigo.EnemigoNormal;
import src.Fabricas.Sprites;
import src.Juego.Posicion;
import src.Visitor.Colisionador;

public class Calabaza extends Enemigo {
    protected static final int PUNTOS_POR_RODAR=300;
    protected static final int PUNTOS_POR_CONGELARSE=150;

    public Calabaza(Sprites sprites , Posicion posicion){
        super(sprites, posicion);
        posInicial=posicion.clonar();
        colisionador = new ColisionadorCalabaza(this);
        estado= new CalabazaNormal(this, sprites);
    }

    public void aceptarColision(Colisionador c) {
        c.colisionar(this);
    }

    protected Calabaza crearEnemigo(){
        Calabaza nuevo = new Calabaza(this.misSprites, this.posInicial.clonar()); 
        nuevo.setEstado(new EnemigoNormal(nuevo, nuevo.getSprites()));
        return nuevo;
    }

    public void aumentarPuntajePorEmpujar() {
        this.getNivelActual().getSnowBro().aumentarPuntaje(PUNTOS_POR_RODAR);
    }
    public void aumentarPuntajePorCongelamiento(){
        this.getNivelActual().getSnowBro().aumentarPuntaje(PUNTOS_POR_CONGELARSE);
    }
}
