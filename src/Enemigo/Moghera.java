package src.Enemigo;

import src.Enemigo.EstadosEnemigo.MogheraNormal;
import src.Fabricas.Sprites;
import src.Juego.Posicion;
import src.Visitor.Colisionador;

public class Moghera extends JefeDeNivel {


    public Moghera(Sprites sprites, Posicion posicion) {
        super(sprites, posicion);
        puntosPorRodar = 5000;
        puntosPorCongelarse = 1000;
        this.colisionador = new ColisionadorMoghera(this);
        this.estado = new MogheraNormal(this, sprites);
        this.dañoRecibido=0;
        vida = 500;
    }

    public void aceptarColision(Colisionador colisionador){
        colisionador.colisionar(this);
    }

    protected Enemigo crearEnemigo() {
        return new Moghera(misSprites, posicion);
    }
    public Colisionador getColisionador() {
        return colisionador;
    }

    

    

    
    

    
}
