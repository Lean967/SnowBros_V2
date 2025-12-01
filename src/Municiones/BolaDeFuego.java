package src.Municiones;

import src.CapaDatos.ConstantesTeclado;
import src.Fabricas.Sprites;
import src.Juego.Entidad;
import src.Juego.Posicion;
import src.Visitor.Colisionador;

//la bola se dispara, y se mueve pero no se ve, no se por que
public class BolaDeFuego extends Municion {
    protected static int GRAVEDAD=ConstantesTeclado.GRAVEDAD;
    protected static int VELOCIDAD_CAIDA_MAX=ConstantesTeclado.MAX_VELOCIDAD_CAIDA;

    public BolaDeFuego(Sprites sprites, Posicion pos) {
        super(sprites, pos);
        colisionador= new ColisionadorBolaDeFuego(this);
        this.daño = 1; 
        alto = 20;
        ancho = 20;
    }

    public void hacerBucle() {
        if(posicion.getY() <= 600 && posicion.getY() >= -10 && posicion.getX() <= 760 && posicion.getX() >= -10){
            posicion.setX(posicion.getX() + pasoX);
            posicion.setY(posicion.getY() + pasoY);
            pasoY = pasoY + ConstantesTeclado.GRAVEDAD;
            mover();
        }else{
            eliminar();
        }
        
        
    }
    
    public void aceptarColision(Colisionador c) {
        c.colisionar(this);
    }

    public Entidad clone() {
        return new BolaDeFuego(misSprites, posicion.clonar());
    }
}