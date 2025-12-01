package src.Powers;

import src.CapaDatos.GestorSonido;
import src.Fabricas.Sprites;
import src.Juego.Posicion;
import src.Jugador.SnowBro;
import src.Jugador.EstadosPowerUp.EstadoPowerUpRoja;
import src.Visitor.Colisionador;

public class PocionRoja extends PowerUp {
    public PocionRoja(Sprites misSprites, Posicion pos){
        super(misSprites, pos);
        GestorSonido.getInstancia().reproducirSonido("POWER_POCION");
    }

    public void hacerEfecto(SnowBro snowBro){
        snowBro.setEstadoPowerUp(new EstadoPowerUpRoja(snowBro));
        eliminar();
    }

    public void aceptarColision(Colisionador c){
        c.colisionar(this);
    }

    public PocionRoja crearPowerUp(){
        return new PocionRoja(misSprites, posicion);
    }
}
