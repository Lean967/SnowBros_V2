package src.Powers;

import src.CapaDatos.GestorSonido;
import src.Fabricas.Sprites;
import src.Juego.Posicion;
import src.Jugador.SnowBro;
import src.Jugador.EstadosPowerUp.EstadoPowerUpAzul;
import src.Visitor.Colisionador;

public class PocionAzul extends PowerUp {

    public PocionAzul(Sprites misSprites, Posicion pos) {
        super(misSprites, pos);
        GestorSonido.getInstancia().reproducirSonido("POWER_POCION");
    }
    public void hacerEfecto(SnowBro snowBro) {
        snowBro.setEstadoPowerUp(new EstadoPowerUpAzul(snowBro));
        eliminar();
    }
    public void aceptarColision(Colisionador c) {
        c.colisionar(this);
    }

    public PocionAzul crearPowerUp(){
        return new PocionAzul(misSprites, posicion);
    }
}
