package src.Enemigo;

import src.CapaDatos.GestorSonido;
import src.Fabricas.Sprites;
import src.Juego.Posicion;

public abstract class JefeDeNivel extends Enemigo{
    
    public JefeDeNivel(Sprites sprites, Posicion posicion) {
        super(sprites, posicion);
        GestorSonido.getInstancia().reproducirSonido("APARICION_JEFE");
    }

    public void hacerBucle(){
        incrementarContadorCiclos();
        estado.hacerBucle();
    }

    
    public void morir() {
        super.morir();
    }

    public void recibirImpactoDeBolaDeNieve(int daño){
        dañoRecibido += daño;
        estado.actualizarSprite();
        update();
    }

    public void eliminar(){
        eliminarObservers();
        nivelActual.eliminarJefe(this);
        nivelActual.generarPowerUp(posicion);
    }
}