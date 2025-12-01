package src.Powers;

import src.CapaDatos.GestorSonido;
import src.Fabricas.Sprites;
import src.Juego.Posicion;
import src.Jugador.SnowBro;
import src.Jugador.EstadosPowerUp.EstadoPowerUpVerde;
import src.Visitor.Colisionador;

public class PocionVerde extends PowerUp{

    public PocionVerde(Sprites misSprites, Posicion pos) {
        super(misSprites, pos);
        GestorSonido.getInstancia().reproducirSonido("POWER_POCION");
    }
    public void hacerEfecto(SnowBro snowBro) {
        snowBro.setEstadoPowerUp(new EstadoPowerUpVerde(snowBro));
        eliminar();
    }
    public void aceptarColision(Colisionador c) {
        c.colisionar(this);
    }
    public PocionVerde crearPowerUp(){
        return new PocionVerde(misSprites, posicion);
    }
    
}
