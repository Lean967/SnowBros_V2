package src.Plataformas;

import src.Enemigo.Enemigo;
import src.Fabricas.Sprites;
import src.Juego.Posicion;
import src.Jugador.SnowBro;
import src.Visitor.Colisionador;


public class Quebradiza extends Plataforma {
    protected boolean rota;
    protected int puntaje;

    public Quebradiza(Sprites sprites, Posicion posicion) {
        super(sprites, posicion);
        rota=false;
        puntaje = 300;
    }

    public void aceptarColision(Colisionador colisionador) {
        colisionador.colisionar(this);
    }

    public void hacerEfecto(SnowBro snowbro) {
        if (!rota){
            snowbro.setCayendo(false);
            eliminar();
        }
    }

    public void hacerEfecto(Enemigo enemigo){
        if (!rota){
            enemigo.setCayendo(false);
            eliminar();
        }
    }

    protected Quebradiza crearPlataforma(){
        Quebradiza nuevaQuebradiza = new Quebradiza(misSprites, posicion);
        nuevaQuebradiza.setDimensiones(ancho, alto);
        return nuevaQuebradiza;
    }
}