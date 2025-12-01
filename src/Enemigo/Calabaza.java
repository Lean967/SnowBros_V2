package src.Enemigo;

import src.Fabricas.Sprites;
import src.Juego.Posicion;
import src.Visitor.Colisionador;

public class Calabaza extends Enemigo {

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
        nuevo.setEstado(new CalabazaNormal(nuevo, nuevo.getSprites()));
        return nuevo;
    }
    public Colisionador getColisionador(){
        return colisionador;
    }

    public void morir(){
        
    }
}
