package src.Fabricas;
import java.util.HashMap;
import java.util.Map;

import src.CapaDatos.ConstantesTeclado;
import src.Fabricas.SpritesPersonal;


public class SpritesPersonal extends FabricaSprites {
    
    public SpritesPersonal(){
        super();
        this.rutaASprites = "/src/imagenes-personalizadas";
        this.rutaFondosNiveles= "/src/imagenes-personalizadas/fondos/";

    }

    public String getRutaASprites() {
        return rutaASprites;
    }

    public String getRutaAFondosNiveles() {
        return rutaFondosNiveles;
    }

    public Sprites getSpritesDemonioRojo() {
        Map<Integer,String> mapeoSprites = new HashMap<Integer,String>();
        mapeoSprites.put(ConstantesTeclado.QUIETODERECHA, rutaASprites+"/demonio-rojo(gompaa)/hongo-quieto.PNG");
        mapeoSprites.put(ConstantesTeclado.QUIETOIZQUIERDA, rutaASprites+"/demonio-rojo(gompaa)/hongo-quieto.PNG");
        mapeoSprites.put(ConstantesTeclado.CONGELADO1, rutaASprites+"/demonio-rojo(gompaa)/hongo-congelado-1.png");
        mapeoSprites.put(ConstantesTeclado.CONGELADO2, rutaASprites+"/demonio-rojo(gompaa)/hongo-congelado-2.png");
        mapeoSprites.put(ConstantesTeclado.CONGELADO3, rutaASprites+"/demonio-rojo(gompaa)/hongo-congelado-3.png");
        mapeoSprites.put(ConstantesTeclado.CONGELADO4, rutaASprites+"/demonio-rojo(gompaa)/hongo-congelado-4.png");
        mapeoSprites.put(ConstantesTeclado.CONGELADO5, rutaASprites+"/demonio-rojo(gompaa)/hongo-congelado-4.png");
        mapeoSprites.put(ConstantesTeclado.RODANDO, rutaASprites+"/bolaNieve/bola-nieve-girando.gif");
        mapeoSprites.put(ConstantesTeclado.RODANDO_CON_SNOW, rutaASprites+"/bolaNieve/bola-nieve-girando.gif");
        mapeoSprites.put(ConstantesTeclado.MOVIENDOSE_DERECHA,rutaASprites+"/demonio-rojo(gompaa)/hongo-caminando.gif" );
        mapeoSprites.put(ConstantesTeclado.MOVIENDOSE_IZQUIERDA, rutaASprites+"/demonio-rojo(gompaa)/hongo-caminando.gif" );
        return (new Sprites (mapeoSprites, ConstantesTeclado.QUIETODERECHA));
    }

    public Sprites getSpritesTrollAmarillo() {
        Map<Integer,String> mapeoSprites = new HashMap<Integer,String>();
        mapeoSprites.put(ConstantesTeclado.QUIETODERECHA, "/src/imagenes/troll-amarillo/troll-amarillo-quieto-derecha.png");
        mapeoSprites.put(ConstantesTeclado.QUIETOIZQUIERDA, "/src/imagenes/troll-amarillo/troll-amarillo-quieto-izquierda.png");
        mapeoSprites.put(ConstantesTeclado.MOVIENDOSE_DERECHA,rutaASprites+"/troll-amarillo(tortuga-amarilla)/tortuga-amarilla-caminando-derecha.giff");
        mapeoSprites.put(ConstantesTeclado.MOVIENDOSE_IZQUIERDA, rutaASprites+"/troll-amarillo(tortuga-amarilla)/tortuga-amarilla-caminando-izquierda.gif" );
        mapeoSprites.put(ConstantesTeclado.RODANDO, rutaASprites+"/bolaNieve/bola-nieve-girando.gif");
        mapeoSprites.put(ConstantesTeclado.RODANDO_CON_SNOW, rutaASprites+"/bolaNieve/bola-nieve-girando.gif");
        mapeoSprites.put(ConstantesTeclado.CONGELADO1, rutaASprites+"/troll-amarillo(tortuga-amarilla)/tortuga-amarilla-congelado-1.png");
        mapeoSprites.put(ConstantesTeclado.CONGELADO2, rutaASprites+"/troll-amarillo(tortuga-amarilla)/tortuga-amarilla-congelado-2.png");
        mapeoSprites.put(ConstantesTeclado.CONGELADO3, rutaASprites+"/troll-amarillo(tortuga-amarilla)/tortuga-amarilla-congelado-3.png");
        mapeoSprites.put(ConstantesTeclado.CONGELADO4, rutaASprites+"/troll-amarillo(tortuga-amarilla)/tortuga-amarilla-congelado-4.png");
        mapeoSprites.put(ConstantesTeclado.CONGELADO5, rutaASprites+"/troll-amarillo(tortuga-amarilla)/tortuga-amarilla-congelado-4.png\"");
        return (new Sprites (mapeoSprites, ConstantesTeclado.QUIETODERECHA));
    }

    public Sprites getSpritesCalabaza() {
        Map<Integer,String> mapeoSprites = new HashMap<Integer,String>();
        mapeoSprites.put(ConstantesTeclado.QUIETODERECHA, "/src/imagenes/calabaza/CalabazaQuietoDerecha.png");
        mapeoSprites.put(ConstantesTeclado.QUIETOIZQUIERDA, "/src/imagenes/calabaza/CalabazaQuietoIzquierda.png");


        mapeoSprites.put(ConstantesTeclado.MOVIENDOSE_DERECHA, rutaASprites+"/calabaza (mago)/mago-caminando-derecha.gif");
        mapeoSprites.put(ConstantesTeclado.MOVIENDOSE_IZQUIERDA, rutaASprites+"/calabaza (mago)/mago-caminando-izquierda.gif");
        return (new Sprites (mapeoSprites, ConstantesTeclado.QUIETO));
    }

    public Sprites getSpritesSnowBro() {
        Map<Integer,String> mapeoSprites = new HashMap<Integer,String>();
        mapeoSprites.put(ConstantesTeclado.QUIETO, rutaASprites+"/snow(mario)/mario-quieto-derecha.png");
        mapeoSprites.put(ConstantesTeclado.QUIETODERECHA, rutaASprites+"/snow(mario)/mario-quieto-derecha.png");
        mapeoSprites.put(ConstantesTeclado.QUIETOIZQUIERDA, rutaASprites+"/snow(mario)/mario-quieto-izquierda.png");
        mapeoSprites.put(ConstantesTeclado.MOVIENDOSE_DERECHA, rutaASprites+ "/snow(mario)/mario-caminando-derecha.gif");
        mapeoSprites.put(ConstantesTeclado.MOVIENDOSE_IZQUIERDA, rutaASprites+ "/snow(mario)/mario-caminando-izquierda.gif");
        mapeoSprites.put(ConstantesTeclado.PERDER_VIDA, rutaASprites+"/snow(mario)/mario-muerto.gif");
        mapeoSprites.put(ConstantesTeclado.SALTANDO, rutaASprites+"/snow(mario)/mario-saltando-derecha.png");
        return (new Sprites (mapeoSprites, ConstantesTeclado.QUIETO));
    }

    public Sprites getSpritesSnowRojo() {
        throw new UnsupportedOperationException("Unimplemented method 'getSpritesSnowRojo'");
    }

    public Sprites getSpritesSnowRodandoBola() {
        Map<Integer,String> mapeoSprites = new HashMap<Integer,String>();
        mapeoSprites.put(ConstantesTeclado.QUIETO, rutaASprites+"/snow(mario)/mario-quieto-derecha.png");
        mapeoSprites.put(ConstantesTeclado.MOVIENDOSE_DERECHA, rutaASprites+"/snow(mario)/mario-pegando-bola-de-nieve-derecha.png");
        mapeoSprites.put(ConstantesTeclado.MOVIENDOSE_IZQUIERDA, rutaASprites+"/snow(mario)/mario-pegando-bola-de-nieve-izquierda.png");
        return (new Sprites (mapeoSprites, ConstantesTeclado.QUIETO));
    }

    public Sprites getSpritesEstatica() {
        Map<Integer,String> mapeoSprites = new HashMap<Integer,String>();
        mapeoSprites.put(ConstantesTeclado.QUIETO, rutaASprites+"/plataformas/plataforma7.PNG");
        mapeoSprites.put(2, rutaASprites+"/plataformas/plataforma 5.PNG");
        mapeoSprites.put(3, rutaASprites+"/plataformas/plataforma 8.PNG");
        mapeoSprites.put(4,rutaASprites+"/plataformas/plataforma 9.PNG");
        mapeoSprites.put(5, rutaASprites+"/plataformas/plataforma 11.PNG");
        mapeoSprites.put(6, rutaASprites+"/plataformas/plataforma-12.png");
        return (new Sprites (mapeoSprites, ConstantesTeclado.QUIETO));
    }

    public Sprites getSpritesParedIzquierda() {
        Map<Integer,String> mapeoSprites=new HashMap<Integer,String>();
        mapeoSprites.put(ConstantesTeclado.QUIETO,rutaASprites+"/plataformas/pared 3.PNG");
        return (new Sprites(mapeoSprites,ConstantesTeclado.QUIETO));
    }

    public Sprites getSpritesParedDerecha() {
        Map<Integer,String> mapeoSprites=new HashMap<Integer,String>();
        mapeoSprites.put(ConstantesTeclado.QUIETO,rutaASprites+"/plataformas/pared 3.PNG");
        return (new Sprites(mapeoSprites,ConstantesTeclado.QUIETO));
    }

    public Sprites getSpritesPocionRoja() {
        Map<Integer, String> mapeoSprites= new HashMap<Integer,String>();
        mapeoSprites.put(ConstantesTeclado.QUIETO, rutaASprites+"/power-up/pocion-roja.png");
        return (new Sprites(mapeoSprites, ConstantesTeclado.QUIETO));
    }

    public Sprites getSpritesVidaExtra() {
        Map<Integer, String> mapeoSprites= new HashMap<Integer,String>();
        mapeoSprites.put(ConstantesTeclado.QUIETO, rutaASprites+"/power-up/vida-extra.png");
        return (new Sprites(mapeoSprites, ConstantesTeclado.QUIETO));
    }

    public Sprites getSpritesBolaDeNieve() {
        Map<Integer, String> mapeoSprites= new HashMap<Integer,String>();
        mapeoSprites.put(ConstantesTeclado.QUIETO, rutaASprites+"/snow(mario)/nieve.gif");
        return (new Sprites(mapeoSprites, ConstantesTeclado.QUIETO));
    }


    
    public Sprites getSpritesFruta() {
        Map<Integer, String> mapeoSprites= new HashMap<Integer,String>();
        mapeoSprites.put(ConstantesTeclado.QUIETO, rutaASprites+"/power-up/fruta.png");
        return (new Sprites(mapeoSprites, ConstantesTeclado.QUIETO));
    }

    public Sprites getSpritesPocionVerde() {
        Map<Integer, String> mapeoSprites= new HashMap<Integer,String>();
        mapeoSprites.put(ConstantesTeclado.QUIETO, rutaASprites+"/power-up/pocion-verde.png");
        return (new Sprites(mapeoSprites, ConstantesTeclado.QUIETO));
    }

    public Sprites getSpritesEscalera() {
        Map<Integer, String> mapeoSprites= new HashMap<Integer,String>();
        mapeoSprites.put(ConstantesTeclado.QUIETO, rutaASprites+"/plataformas/escalera.png");
        return (new Sprites(mapeoSprites, ConstantesTeclado.QUIETO));
    }

    public Sprites getSpritesTrampa() {
        Map<Integer, String> mapeoSprites= new HashMap<Integer,String>();
        mapeoSprites.put(ConstantesTeclado.QUIETO,"/src/imagenes/plataformas/escalera.png");
        return (new Sprites(mapeoSprites, ConstantesTeclado.QUIETO));
    }

    public Sprites getSpritesRanaDeFuego() {
        Map<Integer, String> mapeoSprites= new HashMap<Integer,String>();
        mapeoSprites.put(ConstantesTeclado.QUIETODERECHA, "/src/imagenes/rana-de-fuego/rana-de-fuego-quieto-derecha.PNG");
        mapeoSprites.put(ConstantesTeclado.QUIETOIZQUIERDA, "/src/imagenes/rana-de-fuego/rana-de-fuego-quieto-izquierda.PNG");


        mapeoSprites.put(ConstantesTeclado.MOVIENDOSE_DERECHA, rutaASprites+"/rana-de-fuego(dragon)/rana-de-fuego-caminando-derecha.gif");
        mapeoSprites.put(ConstantesTeclado.MOVIENDOSE_IZQUIERDA, rutaASprites+"/rana-de-fuego(dragon)/rana-de-fuego-caminando-izquierda.gif");
        mapeoSprites.put(ConstantesTeclado.CONGELADO1, rutaASprites+"/rana-de-fuego(dragon)/rana-de-fuego-congelado-derecha-1.png");
        mapeoSprites.put(ConstantesTeclado.CONGELADO2, rutaASprites+"/rana-de-fuego(dragon)/rana-de-fuego-congelado-derecha-2.png");
        mapeoSprites.put(ConstantesTeclado.CONGELADO3, rutaASprites+"/rana-de-fuego(dragon)/rana-de-fuego-congelado-derecha-3.png");
        mapeoSprites.put(ConstantesTeclado.CONGELADO4, rutaASprites+"/rana-de-fuego(dragon)/rana-de-fuego-congelado-derecha-4.png");
        mapeoSprites.put(ConstantesTeclado.CONGELADO5, rutaASprites+"/rana-de-fuego(dragon)/rana-de-fuego-congelado-derecha-4.png");
        mapeoSprites.put(ConstantesTeclado.RODANDO, rutaASprites+"/bolaNieve/bola-nieve-girando.gif");
        mapeoSprites.put(ConstantesTeclado.RODANDO_CON_SNOW, rutaASprites+"/bolaNieve/bola-nieve-girando.gif");
        return (new Sprites(mapeoSprites, ConstantesTeclado.QUIETODERECHA));
    }

    public Sprites getSpritesMoghera() {
        Map<Integer, String> mapeoSprites= new HashMap<Integer,String>();
        mapeoSprites.put(ConstantesTeclado.QUIETO, rutaASprites+ "/mongera(bowser)/bowser-apareciendo.gif");
        mapeoSprites.put(ConstantesTeclado.PERDER_VIDA, rutaASprites+ "/mongera(bowser)/bowser-muerto.gif");
        mapeoSprites.put(ConstantesTeclado.SALTANDO, rutaASprites+ "/mongera(bowser)/bowser-moviendose.gif");
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
        mapeoSprites.put(ConstantesTeclado.QUIETOIZQUIERDA, rutaASprites+ "/src/imagenes/fantasmas/fantasma_moviendose_izquierda.gif");
        mapeoSprites.put(ConstantesTeclado.QUIETODERECHA, rutaASprites+ "/src/imagenes/fantasmas/fantasma_moviendose_derecha.gif");

        mapeoSprites.put(ConstantesTeclado.MOVIENDOSE_IZQUIERDA, rutaASprites+ "/fantasma/fantasma-moviendose-izquierda.gif");
        mapeoSprites.put(ConstantesTeclado.MOVIENDOSE_DERECHA, rutaASprites+ "/fantasma/fantasma-moviendose-derecha.gif");
        return (new Sprites(mapeoSprites, ConstantesTeclado.QUIETODERECHA));
    }

    public Sprites getSpritesBolaDeFuego() {
        Map<Integer, String> mapeoSprites= new HashMap<Integer,String>();
        mapeoSprites.put(ConstantesTeclado.QUIETO, rutaASprites+"/mongera(bowser)/fuego-moviendose.gif");
        return (new Sprites(mapeoSprites, ConstantesTeclado.QUIETO));
    }

    public Sprites getSpritesBomba() {
        Map<Integer, String> mapeoSprites= new HashMap<Integer,String>();
        mapeoSprites.put(ConstantesTeclado.MOVIENDOSE_IZQUIERDA, rutaASprites+"/Kamakichi/bomba-cayendo-izquierda.png");
        mapeoSprites.put(ConstantesTeclado.MOVIENDOSE_DERECHA, rutaASprites+"/Kamakichi/bomba-cayendo-izquierda.png");
        return (new Sprites(mapeoSprites, ConstantesTeclado.MOVIENDOSE_DERECHA));
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


    public Sprites getSpritesPocionAzul() {
        Map<Integer, String> mapeoSprites= new HashMap<Integer,String>();
        mapeoSprites.put(ConstantesTeclado.QUIETO, rutaASprites+"/SnowBroRecortado/PocionAzul.png");
        return (new Sprites(mapeoSprites, ConstantesTeclado.QUIETO));
    }
}
