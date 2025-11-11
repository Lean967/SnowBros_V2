package src.Jugador.EstadosSprites;
import src.Fabricas.Sprites;
import src.Jugador.SnowBro;

public class EstadoSpritesSnowBro {
    protected SnowBro snowBro;
    public Sprites misSprites;

    public EstadoSpritesSnowBro(SnowBro snowBro, Sprites misSprites){
        this.snowBro = snowBro;
        this.misSprites = misSprites;
    }

    public Sprites getSprites(){
        return this.misSprites;
    }
    
}
