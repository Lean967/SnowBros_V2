package src.Fabricas;

import java.util.HashMap;
import java.util.Map;

import src.CapaDatos.ConstantesTeclado;

public abstract class FabricaSprites {
    protected String rutaASprites;

    protected FabricaSprites(){
        //HARCODEO
        this.rutaASprites = "src/imagenes/";
    }

 
    public Sprites getSpritesDemonioRojo() {
        Map<Integer,String> mapeoSprites = new HashMap<Integer,String>();
        mapeoSprites.put(ConstantesTeclado.Quieto, rutaASprites+"/demonio_rojo/Botom_01.png");
        mapeoSprites.put(ConstantesTeclado.Congelado1, rutaASprites+"/demonio_rojo/DemonioRojoCongelado1.png");
        mapeoSprites.put(ConstantesTeclado.Congelado2, rutaASprites+"/demonio_rojo/DemonioRojoCongelado2.png");
        mapeoSprites.put(ConstantesTeclado.Congelado3, rutaASprites+"/demonio_rojo/DemonioRojoCongelado3.png");
        mapeoSprites.put(ConstantesTeclado.Congelado4, rutaASprites+"/demonio_rojo/DemonioRojoCongelado4.png");
        mapeoSprites.put(ConstantesTeclado.Congelado5, rutaASprites+"/demonio_rojo/DemonioRojoCongelado5.png");
        mapeoSprites.put(ConstantesTeclado.Rodando, rutaASprites+"/bola-rodando.gif");
        mapeoSprites.put(ConstantesTeclado.MoviendoseDerecha,rutaASprites+"/demonio_rojo/DemonioRojo-caminando-derecha.gif" );
        mapeoSprites.put(ConstantesTeclado.MoviendoseIzquierda, rutaASprites+"/demonio_rojo/DemonioRojo-caminando-izquierda.gif" );
        mapeoSprites.put(ConstantesTeclado.RodandoConSnow, rutaASprites+"/bola-con-snow.gif");
        return (new Sprites (mapeoSprites, ConstantesTeclado.Quieto));
	}

    public Sprites getSpritesTrollAmarillo() {
        Map<Integer,String> mapeoSprites = new HashMap<Integer,String>();
        //lo ponemos en estado quieto pero deberia variar
        mapeoSprites.put(ConstantesTeclado.Quieto, rutaASprites+"/troll_amarillo/troll_amarillo_quieto.png");
        mapeoSprites.put(ConstantesTeclado.Rodando, rutaASprites+"bola-rondando.gif");
        return (new Sprites (mapeoSprites, ConstantesTeclado.Quieto));
    }

    public Sprites getSpritesCalabaza() {
        Map<Integer,String> mapeoSprites = new HashMap<Integer,String>();

        mapeoSprites.put(ConstantesTeclado.Quieto, rutaASprites+"/calabaza/CalabazaQuietoDerecha.png");
        mapeoSprites.put(ConstantesTeclado.MoviendoseDerecha, rutaASprites+"/calabaza/CalabazaMoverDerecha.png");
        mapeoSprites.put(ConstantesTeclado.MoviendoseIzquierda, rutaASprites+"/calabaza/CalabazaMoverIzquierda.png");
        mapeoSprites.put(ConstantesTeclado.Congelado1, rutaASprites+"/calabaza/CalabazaMoverIzquierda.png");
        mapeoSprites.put(ConstantesTeclado.Congelado2, rutaASprites+"/calabaza/CalabazaMoverIzquierda.png");
        mapeoSprites.put(ConstantesTeclado.Congelado3, rutaASprites+"/calabaza/CalabazaMoverIzquierda.png");
        mapeoSprites.put(ConstantesTeclado.Congelado4, rutaASprites+"/calabaza/CalabazaMoverIzquierda.png");
        mapeoSprites.put(ConstantesTeclado.Congelado5, rutaASprites+"/demonio_rojo/DemonioRojoCongelado5.png");
        return (new Sprites (mapeoSprites, ConstantesTeclado.Quieto));
    }

    public Sprites getSpritesSnowBro(){
        Map<Integer,String> mapeoSprites = new HashMap<Integer,String>();
        mapeoSprites.put(ConstantesTeclado.Quieto, rutaASprites+"/SnowBroRecortado/snow01.png");
        mapeoSprites.put(ConstantesTeclado.MoviendoseDerecha, rutaASprites+ "/SnowBroRecortado/snowbro-caminando-derecha.gif");
        mapeoSprites.put(ConstantesTeclado.MoviendoseIzquierda, rutaASprites+ "/SnowBroRecortado/snowbro-caminando-izquierda.gif");
        mapeoSprites.put(ConstantesTeclado.PerderVida, rutaASprites+"/SnowBroRecortado/snowbro-muriendo.gif");
        mapeoSprites.put(ConstantesTeclado.Saltando, rutaASprites+"/SnowBroRecortado/snowbro-saltando.gif");
        return (new Sprites (mapeoSprites, ConstantesTeclado.Quieto));
    }

    public Sprites getSpritesSnowRojo(){
        Map<Integer,String> mapeoSprites = new HashMap<Integer,String>();
        mapeoSprites.put(ConstantesTeclado.Quieto, rutaASprites+"/SnowBro/Nick--Tom_0001_Capa-2.png");
        mapeoSprites.put(ConstantesTeclado.MoviendoseDerecha, rutaASprites+ "/SnowBroRecortado/snowbro-caminando-derecha.gif");
        mapeoSprites.put(ConstantesTeclado.MoviendoseIzquierda, rutaASprites+ "/SnowBroRecortado/snowbro-caminando-izquierda.gif");
        mapeoSprites.put(ConstantesTeclado.PerderVida, rutaASprites+"/SnowBro/Nick--Tom_0040_Capa-41.png");
        mapeoSprites.put(ConstantesTeclado.Saltando, rutaASprites+"/SnowBroRecortado/snowbro-saltando.gif");
        return (new Sprites (mapeoSprites, ConstantesTeclado.Quieto));
    }

    public Sprites getSpritesSnowRodandoBola(){
        Map<Integer,String> mapeoSprites = new HashMap<Integer,String>();
        mapeoSprites.put(ConstantesTeclado.Quieto, rutaASprites+"/SnowBroRecortado/snow01.png");
        mapeoSprites.put(ConstantesTeclado.MoviendoseDerecha, rutaASprites+"/SnowBroRecortado/snowbro-empujando-bola-derecha.gif");
        mapeoSprites.put(ConstantesTeclado.MoviendoseIzquierda, rutaASprites+"/SnowBroRecortado/snowbro-empujando-bola-izquierda.gif");
        return (new Sprites (mapeoSprites, ConstantesTeclado.Quieto));
    }

    public Sprites getSpritesEstatica(){
        Map<Integer,String> mapeoSprites = new HashMap<Integer,String>();
        mapeoSprites.put(ConstantesTeclado.Quieto, rutaASprites+"/Plataformas/plataformas-rosas/plataforma-rosa-central-flotante.png");
        mapeoSprites.put(2, rutaASprites+"/Plataformas/plataformas-rosas/plataforma-rosa-izquierda.png");
        mapeoSprites.put(3, rutaASprites+"/Plataformas/plataformas-rosas/plataforma-rosa-derecha.png");
        return (new Sprites (mapeoSprites, ConstantesTeclado.Quieto));
    }

    public Sprites getSpritesParedIzquierda(){
        Map<Integer,String> mapeoSprites=new HashMap<Integer,String>();
        mapeoSprites.put(ConstantesTeclado.Quieto,rutaASprites+"/Paredes/pared-rosa-izquierda.png");
        return (new Sprites(mapeoSprites,ConstantesTeclado.Quieto));
    }
    public Sprites getSpritesParedDerecha(){
        Map<Integer,String> mapeoSprites=new HashMap<Integer,String>();
        mapeoSprites.put(ConstantesTeclado.Quieto,rutaASprites+"/Paredes/pared-rosa-derecha.png");
        return (new Sprites(mapeoSprites,ConstantesTeclado.Quieto));
    }

    public Sprites getSpritesPocionRoja(){
        Map<Integer, String> mapeoSprites= new HashMap<Integer,String>();
        mapeoSprites.put(ConstantesTeclado.Quieto, rutaASprites+"/SnowBroRecortado/pocion-roja.png");
        return (new Sprites(mapeoSprites, ConstantesTeclado.Quieto));
    }

    public Sprites getSpritesVidaExtra(){
        Map<Integer, String> mapeoSprites= new HashMap<Integer,String>();
        mapeoSprites.put(ConstantesTeclado.Quieto, rutaASprites+"/star.png");
        return (new Sprites(mapeoSprites, ConstantesTeclado.Quieto));
    }

    public Sprites getSpritesBolaDeNieve(){
        Map<Integer, String> mapeoSprites= new HashMap<Integer,String>();
        mapeoSprites.put(ConstantesTeclado.Quieto, rutaASprites+"/SnowBro/Nick--Tom_0012_Capa-13.png");
        return (new Sprites(mapeoSprites, ConstantesTeclado.Quieto));
    }


    public Sprites getSpritesSnowAzul() {
        Map<Integer, String> mapeoSprites= new HashMap<Integer,String>();
        mapeoSprites.put(ConstantesTeclado.Quieto, rutaASprites+"/SnowBroRecortado/snow01.png");
         mapeoSprites.put(ConstantesTeclado.MoviendoseDerecha, rutaASprites+ "/SnowBroRecortado/snowbro-caminando-derecha.gif");
        mapeoSprites.put(ConstantesTeclado.MoviendoseIzquierda, rutaASprites+ "/SnowBroRecortado/snowbro-caminando-izquierda.gif");
        mapeoSprites.put(ConstantesTeclado.PerderVida, rutaASprites+"/SnowBroRecortado/snowbro-muriendo.gif");
        mapeoSprites.put(ConstantesTeclado.Saltando, rutaASprites+"/SnowBroRecortado/snowbro-saltando.gif");
        //mapeoSprites.put(ConstantesTeclado.SnowRodandoBolaDerecha, rutaASprites+"/SnowBroRecortado/snowbro-empujando-bola-derecha.gif");
        //mapeoSprites.put(ConstantesTeclado.SnowRodandoBolaIzquierda, rutaASprites+"/SnowBroRecortado/snowbro-empujando-bola-izquierda.gif");
        return (new Sprites(mapeoSprites, ConstantesTeclado.Quieto));
    }


    public Sprites getSpritesFruta() {
        Map<Integer, String> mapeoSprites= new HashMap<Integer,String>();
        mapeoSprites.put(ConstantesTeclado.Quieto, rutaASprites+"/SnowBroRecortado/fruta.png");
        return (new Sprites(mapeoSprites, ConstantesTeclado.Quieto));
    }
    public Sprites getSpritesPocionVerde() {
        Map<Integer, String> mapeoSprites= new HashMap<Integer,String>();
        mapeoSprites.put(ConstantesTeclado.Quieto, rutaASprites+"/SnowBroRecortado/PocionVerde.png");
        return (new Sprites(mapeoSprites, ConstantesTeclado.Quieto));
    }
    public Sprites getSpritesPocionAzul() {
        Map<Integer, String> mapeoSprites= new HashMap<Integer,String>();
        mapeoSprites.put(ConstantesTeclado.Quieto, rutaASprites+"/SnowBroRecortado/PocionAzul.png");
        return (new Sprites(mapeoSprites, ConstantesTeclado.Quieto));
    }


    public Sprites getSpritesEscalera() {
        Map<Integer, String> mapeoSprites= new HashMap<Integer,String>();
        mapeoSprites.put(ConstantesTeclado.Quieto, rutaASprites+"/SnowBroRecortado/escalera.png");
        return (new Sprites(mapeoSprites, ConstantesTeclado.Quieto));
    }


    public Sprites getSpritesTrampa() {
        Map<Integer, String> mapeoSprites= new HashMap<Integer,String>();
        mapeoSprites.put(ConstantesTeclado.Quieto, rutaASprites+"/SnowBroRecortado/trampa.png");
        return (new Sprites(mapeoSprites, ConstantesTeclado.Quieto));
    }
}
