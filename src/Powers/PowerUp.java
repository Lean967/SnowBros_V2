package src.Powers;
import src.Visitor.Colisionable;
import src.Juego.Entidad;
import src.CapaDatos.ConstantesTeclado;
import src.Fabricas.Sprites;
import src.Juego.Posicion;
import src.Jugador.SnowBro;

public abstract class PowerUp extends Entidad implements Colisionable  {
    protected int puntaje;
    protected int tiempoEnNivel;

    public PowerUp(Sprites misSprites, Posicion pos){
        super(misSprites,pos);
        ancho = 20;
        alto = 25;
        puntaje = 300;
        tiempoEnNivel = ConstantesTeclado.TIEMPO_POWERUPS_EN_NIVEL;
        
   }

    public void eliminar(){
        eliminarObservers();
        nivelActual.eliminar(this);
    }

    public PowerUp clone(){
        PowerUp nuevoPowerUp = crearPowerUp();
        nuevoPowerUp.setDimensiones(ancho, alto);
        return nuevoPowerUp;
    }
    protected abstract PowerUp crearPowerUp();
    
    public abstract void hacerEfecto(SnowBro snowBro);

    public int getPuntaje(){
        return puntaje;
    }

    public void hacerBucle(){
        if(tiempoEnNivel > 0){
            tiempoEnNivel--;
        }else{
            eliminar();
        }
    }
}
