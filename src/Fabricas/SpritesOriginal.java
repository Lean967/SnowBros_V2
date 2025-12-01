package src.Fabricas;
import java.util.HashMap;
import java.util.Map;

import src.CapaDatos.ConstantesTeclado;
import src.Fabricas.SpritesOriginal;


public class SpritesOriginal extends FabricaSprites{

    public SpritesOriginal(){
        super();
        this.rutaASprites = "/src/imagenes/";
        this.rutaFondosNiveles= "/src/imagenes/Fondos/FondosNivel/";
    }

    public String getRutaAFondosNiveles(){
        return rutaFondosNiveles;
    }

    public String getRutaASprites(){
        return rutaASprites;
    }


    public Sprites getSpritesDemonioRojo() {
        Map<Integer,String> mapeoSprites = new HashMap<Integer,String>();
        mapeoSprites.put(ConstantesTeclado.QUIETODERECHA, rutaASprites+"/demonio_rojo/demonio2.png");
        mapeoSprites.put(ConstantesTeclado.QUIETOIZQUIERDA, rutaASprites+"/demonio_rojo/Botom_01.png");
        mapeoSprites.put(ConstantesTeclado.CONGELADO1, rutaASprites+"/demonio_rojo/DemonioRojo_.png");
        mapeoSprites.put(ConstantesTeclado.CONGELADO2, rutaASprites+"/demonio_rojo/DemonioRojoCongelado2.png");
        mapeoSprites.put(ConstantesTeclado.CONGELADO3, rutaASprites+"/demonio_rojo/DemonioRojoCongelado3.png");
        mapeoSprites.put(ConstantesTeclado.CONGELADO4, rutaASprites+"/demonio_rojo/DemonioRojoCongelado4.png");
        mapeoSprites.put(ConstantesTeclado.CONGELADO5, rutaASprites+"/demonio_rojo/DemonioRojoCongelado5.png");
        mapeoSprites.put(ConstantesTeclado.RODANDO, rutaASprites+"/bola-rodando.gif");
        mapeoSprites.put(ConstantesTeclado.RODANDO_CON_SNOW, rutaASprites+"/bola-con-snow.gif");
        mapeoSprites.put(ConstantesTeclado.MOVIENDOSE_DERECHA,rutaASprites+"/demonio_rojo/DemonioRojo-caminando-derecha.gif" );
        mapeoSprites.put(ConstantesTeclado.MOVIENDOSE_IZQUIERDA, rutaASprites+"/demonio_rojo/DemonioRojo-caminando-izquierda.gif" );
        
        return (new Sprites (mapeoSprites, ConstantesTeclado.QUIETODERECHA));
	}

    public Sprites getSpritesTrollAmarillo() {
        Map<Integer,String> mapeoSprites = new HashMap<Integer,String>();
        mapeoSprites.put(ConstantesTeclado.QUIETODERECHA, rutaASprites+"/troll-amarillo/troll-amarillo-quieto-derecha.png");
        mapeoSprites.put(ConstantesTeclado.QUIETOIZQUIERDA, rutaASprites+"/troll-amarillo/troll-amarillo-quieto-izquierda.png");
        mapeoSprites.put(ConstantesTeclado.MOVIENDOSE_DERECHA,rutaASprites+"/troll-amarillo/troll-amarillo-caminando-derecha.gif");
        mapeoSprites.put(ConstantesTeclado.MOVIENDOSE_IZQUIERDA, rutaASprites+"/troll-amarillo/troll_amarillo_caminando_izquierda.gif" );
        mapeoSprites.put(ConstantesTeclado.RODANDO, rutaASprites+"/bola-rodando.gif");
        mapeoSprites.put(ConstantesTeclado.RODANDO_CON_SNOW, rutaASprites+"/bola-con-snow.gif");
        mapeoSprites.put(ConstantesTeclado.CONGELADO1, rutaASprites+"/troll-amarillo/congelado-1.png");
        mapeoSprites.put(ConstantesTeclado.CONGELADO2, rutaASprites+"/troll-amarillo/congelado-2.png");
        mapeoSprites.put(ConstantesTeclado.CONGELADO3, rutaASprites+"/troll-amarillo/congelado-3.png");
        mapeoSprites.put(ConstantesTeclado.CONGELADO4, rutaASprites+"/troll-amarillo/congelado-4.png");
        mapeoSprites.put(ConstantesTeclado.CONGELADO5, rutaASprites+"/demonio_rojo/DemonioRojoCongelado5.png");
        return (new Sprites (mapeoSprites, ConstantesTeclado.QUIETODERECHA));
    }

    public Sprites getSpritesCalabaza() {
        Map<Integer,String> mapeoSprites = new HashMap<Integer,String>();
        mapeoSprites.put(ConstantesTeclado.QUIETODERECHA, rutaASprites+"/calabaza/CalabazaQuietoDerecha.png");
        mapeoSprites.put(ConstantesTeclado.QUIETOIZQUIERDA, rutaASprites+"/calabaza/CalabazaQuietoIzquierda.png");
        mapeoSprites.put(ConstantesTeclado.MOVIENDOSE_DERECHA, rutaASprites+"/calabaza/CalabazaMoverDerecha.png");
        mapeoSprites.put(ConstantesTeclado.MOVIENDOSE_IZQUIERDA, rutaASprites+"/calabaza/CalabazaMoverIzquierda.png");
        return (new Sprites (mapeoSprites, ConstantesTeclado.QUIETO));
    }

    public Sprites getSpritesSnowBro(){
        Map<Integer,String> mapeoSprites = new HashMap<Integer,String>();
        mapeoSprites.put(ConstantesTeclado.QUIETO, rutaASprites+"/SnowBroRecortado/snow01.png");
        mapeoSprites.put(ConstantesTeclado.QUIETODERECHA, rutaASprites+"/SnowBroRecortado/snow01.png");
        mapeoSprites.put(ConstantesTeclado.QUIETOIZQUIERDA, rutaASprites+"/SnowBroRecortado/snow02.png");
        mapeoSprites.put(ConstantesTeclado.MOVIENDOSE_DERECHA, rutaASprites+ "/SnowBroRecortado/snowbro-caminando-derecha.gif");
        mapeoSprites.put(ConstantesTeclado.MOVIENDOSE_IZQUIERDA, rutaASprites+ "/SnowBroRecortado/snowbro-caminando-izquierda.gif");
        mapeoSprites.put(ConstantesTeclado.PERDER_VIDA, rutaASprites+"/SnowBroRecortado/snowbro-muriendo.gif");
        mapeoSprites.put(ConstantesTeclado.SALTANDO, rutaASprites+"/SnowBroRecortado/snowbro-saltando.gif");
        return (new Sprites (mapeoSprites, ConstantesTeclado.QUIETO));
    }

    public Sprites getSpritesSnowRojo(){
        Map<Integer,String> mapeoSprites = new HashMap<Integer,String>();
        mapeoSprites.put(ConstantesTeclado.QUIETO, rutaASprites+"/SnowBro/Nick--Tom_0001_Capa-2.png");
        mapeoSprites.put(ConstantesTeclado.QUIETODERECHA, rutaASprites+"/SnowBroRecortado/snow01.png");
        mapeoSprites.put(ConstantesTeclado.QUIETOIZQUIERDA, rutaASprites+"/SnowBroRecortado/snow02.png");
        mapeoSprites.put(ConstantesTeclado.MOVIENDOSE_DERECHA, rutaASprites+ "/SnowBroRecortado/snowbro-caminando-derecha.gif");
        mapeoSprites.put(ConstantesTeclado.MOVIENDOSE_IZQUIERDA, rutaASprites+ "/SnowBroRecortado/snowbro-caminando-izquierda.gif");
        mapeoSprites.put(ConstantesTeclado.PERDER_VIDA, rutaASprites+"/SnowBro/Nick--Tom_0040_Capa-41.png");
        mapeoSprites.put(ConstantesTeclado.SALTANDO, rutaASprites+"/SnowBroRecortado/snowbro-saltando.gif");
        return (new Sprites (mapeoSprites, ConstantesTeclado.QUIETO));
    }

    public Sprites getSpritesSnowRodandoBola(){
        Map<Integer,String> mapeoSprites = new HashMap<Integer,String>();
        mapeoSprites.put(ConstantesTeclado.QUIETO, rutaASprites+"/SnowBroRecortado/snow01.png");
        mapeoSprites.put(ConstantesTeclado.MOVIENDOSE_DERECHA, rutaASprites+"/SnowBroRecortado/snowbro-empujando-bola-derecha.gif");
        mapeoSprites.put(ConstantesTeclado.MOVIENDOSE_IZQUIERDA, rutaASprites+"/SnowBroRecortado/snowbro-empujando-bola-izquierda.gif");
        return (new Sprites (mapeoSprites, ConstantesTeclado.QUIETO));
    }

    public Sprites getSpritesEstatica(){
        Map<Integer,String> mapeoSprites = new HashMap<Integer,String>();
        mapeoSprites.put(ConstantesTeclado.QUIETO, rutaASprites+"/Plataformas/plataformas-rosas/plataforma-rosa-central-flotante.png");
        mapeoSprites.put(2, rutaASprites+"/Plataformas/plataformas-rosas/plataforma-rosa-izquierda.png");
        mapeoSprites.put(3, rutaASprites+"/Plataformas/plataformas-rosas/plataforma-rosa-derecha.png");
        mapeoSprites.put(4,rutaASprites+"/Plataformas/plataformas-rosas/plataforma-rosa-base.png");
        mapeoSprites.put(5, rutaASprites+"/Plataformas/plataforma-naranja/plataforma-naranja-flotante-central-3.png");
        mapeoSprites.put(6, rutaASprites+"/Plataformas/plataforma-naranja/plataformaCLASICO2.png");
        return (new Sprites (mapeoSprites, ConstantesTeclado.QUIETO));
    }

    public Sprites getSpritesParedIzquierda(){
        Map<Integer,String> mapeoSprites=new HashMap<Integer,String>();
        mapeoSprites.put(ConstantesTeclado.QUIETO,rutaASprites+"/Paredes/pared-rosa-izquierda.png");
        return (new Sprites(mapeoSprites,ConstantesTeclado.QUIETO));
    }
    public Sprites getSpritesParedDerecha(){
        Map<Integer,String> mapeoSprites=new HashMap<Integer,String>();
        mapeoSprites.put(ConstantesTeclado.QUIETO,rutaASprites+"/Paredes/pared-rosa-derecha.png");
        return (new Sprites(mapeoSprites,ConstantesTeclado.QUIETO));
    }

    public Sprites getSpritesPocionRoja(){
        Map<Integer, String> mapeoSprites= new HashMap<Integer,String>();
        mapeoSprites.put(ConstantesTeclado.QUIETO, rutaASprites+"/SnowBroRecortado/pocion-roja.png");
        return (new Sprites(mapeoSprites, ConstantesTeclado.QUIETO));
    }

    public Sprites getSpritesVidaExtra(){
        Map<Integer, String> mapeoSprites= new HashMap<Integer,String>();
        mapeoSprites.put(ConstantesTeclado.QUIETO, rutaASprites+"/star.png");
        return (new Sprites(mapeoSprites, ConstantesTeclado.QUIETO));
    }

    public Sprites getSpritesBolaDeNieve(){
        Map<Integer, String> mapeoSprites= new HashMap<Integer,String>();
        mapeoSprites.put(ConstantesTeclado.QUIETO, rutaASprites+"/SnowBro/Nick--Tom_0012_Capa-13.png");
        return (new Sprites(mapeoSprites, ConstantesTeclado.QUIETO));
    }


    public Sprites getSpritesSnowAzul() {
        Map<Integer, String> mapeoSprites= new HashMap<Integer,String>();
        mapeoSprites.put(ConstantesTeclado.QUIETO, rutaASprites+"/SnowBroRecortado/snow01.png");
         mapeoSprites.put(ConstantesTeclado.MOVIENDOSE_DERECHA, rutaASprites+ "/SnowBroRecortado/snowbro-caminando-derecha.gif");
        mapeoSprites.put(ConstantesTeclado.MOVIENDOSE_IZQUIERDA, rutaASprites+ "/SnowBroRecortado/snowbro-caminando-izquierda.gif");
        mapeoSprites.put(ConstantesTeclado.PERDER_VIDA, rutaASprites+"/SnowBroRecortado/snowbro-muriendo.gif");
        mapeoSprites.put(ConstantesTeclado.SALTANDO, rutaASprites+"/SnowBroRecortado/snowbro-saltando.gif");
        return (new Sprites(mapeoSprites, ConstantesTeclado.QUIETO));
    }


    public Sprites getSpritesFruta() {
        Map<Integer, String> mapeoSprites= new HashMap<Integer,String>();
        mapeoSprites.put(ConstantesTeclado.QUIETO, rutaASprites+"/SnowBroRecortado/fruta.png");
        return (new Sprites(mapeoSprites, ConstantesTeclado.QUIETO));
    }
    public Sprites getSpritesPocionVerde() {
        Map<Integer, String> mapeoSprites= new HashMap<Integer,String>();
        mapeoSprites.put(ConstantesTeclado.QUIETO, rutaASprites+"/SnowBroRecortado/PocionVerde.png");
        return (new Sprites(mapeoSprites, ConstantesTeclado.QUIETO));
    }
    public Sprites getSpritesPocionAzul() {
        Map<Integer, String> mapeoSprites= new HashMap<Integer,String>();
        mapeoSprites.put(ConstantesTeclado.QUIETO, rutaASprites+"/SnowBroRecortado/PocionAzul.png");
        return (new Sprites(mapeoSprites, ConstantesTeclado.QUIETO));
    }


    public Sprites getSpritesEscalera() {
        Map<Integer, String> mapeoSprites= new HashMap<Integer,String>();
        mapeoSprites.put(ConstantesTeclado.QUIETO, rutaASprites+"/SnowBroRecortado/escalera.png");
        return (new Sprites(mapeoSprites, ConstantesTeclado.QUIETO));
    }


    public Sprites getSpritesTrampa() {
        Map<Integer, String> mapeoSprites= new HashMap<Integer,String>();
        mapeoSprites.put(ConstantesTeclado.QUIETO, rutaASprites+"/SnowBroRecortado/trampa.png");
        return (new Sprites(mapeoSprites, ConstantesTeclado.QUIETO));
    }

    public Sprites getSpritesRanaDeFuego(){
        Map<Integer, String> mapeoSprites= new HashMap<Integer,String>();
        mapeoSprites.put(ConstantesTeclado.QUIETODERECHA, rutaASprites+"/rana-de-fuego/rana-de-fuego-quieto-derecha.PNG");
        mapeoSprites.put(ConstantesTeclado.QUIETOIZQUIERDA, rutaASprites+"/rana-de-fuego/rana-de-fuego-quieto-izquierda.PNG");
        mapeoSprites.put(ConstantesTeclado.MOVIENDOSE_DERECHA, rutaASprites+"/rana-de-fuego/rana_de_fuego_caminando_derecha.gif");
        mapeoSprites.put(ConstantesTeclado.MOVIENDOSE_IZQUIERDA, rutaASprites+"/rana-de-fuego/rana_de_fuego_caminando_izquierda.gif");
        mapeoSprites.put(ConstantesTeclado.CONGELADO1, rutaASprites+"/rana-de-fuego/rana-de-fuego-congelado-derecha-1.PNG");
        mapeoSprites.put(ConstantesTeclado.CONGELADO2, rutaASprites+"/rana-de-fuego/rana-de-fuego-congelado-derecha-2.PNG");
        mapeoSprites.put(ConstantesTeclado.CONGELADO3, rutaASprites+"/rana-de-fuego/rana-de-fuego-congelado-derecha-3.PNG");
        mapeoSprites.put(ConstantesTeclado.CONGELADO4, rutaASprites+"/rana-de-fuego/rana-de-fuego-congelado-derecha-3.PNG");
        mapeoSprites.put(ConstantesTeclado.CONGELADO5, rutaASprites+"/demonio_rojo/DemonioRojoCongelado5.png");
        mapeoSprites.put(ConstantesTeclado.RODANDO, rutaASprites+"/bola-rodando.gif");
        mapeoSprites.put(ConstantesTeclado.RODANDO_CON_SNOW, rutaASprites+"/bola-con-snow.gif");
        return (new Sprites(mapeoSprites, ConstantesTeclado.QUIETODERECHA));
    }


    public Sprites getSpritesMoghera() {
        Map<Integer, String> mapeoSprites= new HashMap<Integer,String>();
        mapeoSprites.put(ConstantesTeclado.QUIETO, rutaASprites+ "/Moghera/moghera-escupiendo.gif");
        mapeoSprites.put(ConstantesTeclado.PERDER_VIDA, rutaASprites+ "/Moghera/moghera-muerto.gif");
        mapeoSprites.put(ConstantesTeclado.SALTANDO, rutaASprites+ "/Moghera/moghera-saltando.gif");
        return (new Sprites(mapeoSprites, ConstantesTeclado.QUIETO));
    }


    public Sprites getSpritesKamakichi() {
        Map<Integer, String> mapeoSprites= new HashMap<Integer,String>();
        mapeoSprites.put(ConstantesTeclado.ATACANDO, rutaASprites+ "/Kamakichi/kamakichi-atacando.giff");
        mapeoSprites.put(ConstantesTeclado.QUIETO, rutaASprites+ "/Kamakichi/kamakichi-capa-2.gif");
        mapeoSprites.put(ConstantesTeclado.SALTANDO, rutaASprites+ "/Kamakichi/kamakichi-movimiento-vertical.gif");
        return (new Sprites(mapeoSprites, ConstantesTeclado.QUIETO));
    }


    public Sprites getSpritesFantasma() { 
        Map<Integer, String> mapeoSprites= new HashMap<Integer,String>();
        mapeoSprites.put(ConstantesTeclado.QUIETOIZQUIERDA, rutaASprites+ "/fantasmas/fantasma_moviendose_izquierda.gif");
        mapeoSprites.put(ConstantesTeclado.QUIETODERECHA, rutaASprites+ "/fantasmas/fantasma_moviendose_derecha.gif");
        mapeoSprites.put(ConstantesTeclado.MOVIENDOSE_IZQUIERDA, rutaASprites+ "/fantasmas/fantasma_moviendose_izquierda.gif");
        mapeoSprites.put(ConstantesTeclado.MOVIENDOSE_DERECHA, rutaASprites+ "/fantasmas/fantasma_moviendose_derecha.gif");
        return (new Sprites(mapeoSprites, ConstantesTeclado.QUIETODERECHA));
    }


    public Sprites getSpritesBolaDeFuego() {
        Map<Integer, String> mapeoSprites= new HashMap<Integer,String>();
        mapeoSprites.put(ConstantesTeclado.QUIETO, rutaASprites+"/Moghera/fuego-disparo-modelo.gif");
        return (new Sprites(mapeoSprites, ConstantesTeclado.QUIETO));
    }


    public Sprites getSpritesBomba() {
        Map<Integer, String> mapeoSprites= new HashMap<Integer,String>();
        mapeoSprites.put(ConstantesTeclado.MOVIENDOSE_IZQUIERDA, rutaASprites+"/Kamakichi/bomba-cayendo-izquierda.png");
        mapeoSprites.put(ConstantesTeclado.MOVIENDOSE_DERECHA, rutaASprites+"/Kamakichi/bomba-cayendo-izquierda.png");
        return (new Sprites(mapeoSprites, ConstantesTeclado.MOVIENDOSE_DERECHA));
    }
}

