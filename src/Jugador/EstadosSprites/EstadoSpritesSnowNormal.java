package src.Jugador.EstadosSprites;

import src.Fabricas.Sprites;
import src.Jugador.SnowBro;

public class EstadoSpritesSnowNormal  extends EstadoSpritesSnowBro{

    public EstadoSpritesSnowNormal(SnowBro snowBro, Sprites misSprites) {
        super(snowBro, misSprites);
    }

    public Sprites getSprites(){
        return this.misSprites;
    }
    
}
