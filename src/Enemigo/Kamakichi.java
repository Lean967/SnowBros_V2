package src.Enemigo;

import src.Enemigo.EstadosEnemigo.KamakichiNormal;
import src.Fabricas.Sprites;
import src.Juego.Posicion;
import src.Visitor.Colisionador;

public class Kamakichi extends JefeDeNivel {

    public Kamakichi(Sprites sprites, Posicion posicion) {
        super(sprites, posicion);
        colisionador = new ColisionadorKamakichi(this);
        estado = new KamakichiNormal(this, misSprites);
        puntosPorRodar = 5000;
        puntosPorCongelarse = 1000;
        this.dañoRecibido=0;
        vida = 500;
        ancho = 120;
        alto = 74;
    }



    protected Enemigo crearEnemigo() {
        return new Kamakichi(misSprites, posicion);
    }

    public void aceptarColision(Colisionador colisionador){
        colisionador.colisionar(this);
    }

    public Colisionador getColisionador() {
        return colisionador;
    }

    public void recibirImpactoDeBolaDeNieve(int daño){
        dañoRecibido += daño;
        if(dañoRecibido >= vida){
            morir();
        }
        estado.actualizarSprite();
        update();
    }

    
}