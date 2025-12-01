package src.Fabricas;

public abstract class FabricaSprites {
    protected String rutaASprites;
    protected FabricaSprites fabrica;
    protected String rutaFondosNiveles;


    protected FabricaSprites(){
    }

    public abstract String getRutaASprites();
    public abstract String getRutaAFondosNiveles();

    public abstract Sprites getSpritesDemonioRojo();

    public abstract Sprites getSpritesTrollAmarillo();

    public abstract Sprites getSpritesCalabaza();

    public abstract Sprites getSpritesSnowBro();

    public abstract Sprites getSpritesSnowRojo();

    public abstract Sprites getSpritesSnowRodandoBola();

    public abstract Sprites getSpritesEstatica();

    public abstract Sprites getSpritesParedIzquierda();
    public abstract Sprites getSpritesParedDerecha();

    public abstract Sprites getSpritesPocionRoja();

    public abstract Sprites getSpritesVidaExtra();

    public abstract Sprites getSpritesBolaDeNieve();

    public abstract Sprites getSpritesSnowAzul();

    public abstract Sprites getSpritesFruta();
    public abstract Sprites getSpritesPocionVerde();
    public abstract Sprites getSpritesPocionAzul();

    public abstract Sprites getSpritesEscalera();


    public abstract Sprites getSpritesTrampa();
    public abstract Sprites getSpritesRanaDeFuego();

    public abstract Sprites getSpritesMoghera();

    public abstract Sprites getSpritesKamakichi();


    public abstract Sprites getSpritesFantasma();


    public abstract Sprites getSpritesBolaDeFuego();


    public abstract Sprites getSpritesBomba();

}
    
