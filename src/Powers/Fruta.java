package src.Powers;

import src.CapaDatos.GestorSonido;
import src.Fabricas.Sprites;
import src.Juego.Posicion;
import src.Jugador.SnowBro;
import src.Visitor.Colisionador;

public class Fruta extends PowerUp {
    protected GestorSonido gestorSonido = GestorSonido.getInstancia();


    public Fruta(Sprites misSprites, Posicion pos) {
        super(misSprites, pos);
        puntaje = 500;
        GestorSonido.getInstancia().reproducirSonido("FRUTA");
    }
    public void hacerEfecto(SnowBro snowBro) {
        snowBro.aumentarPuntaje(puntaje);
    }
    public void aceptarColision(Colisionador c) {
        c.colisionar(this);
    }
    public Fruta crearPowerUp(){
        return new Fruta(misSprites, posicion);
    }
    
}
