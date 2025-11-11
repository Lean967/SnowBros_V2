package src.Fabricas;

import src.Enemigo.*;
import src.Juego.Posicion;
import src.Jugador.SnowBro;
import src.Municiones.BolaDeNieve;
import src.Obstaculos.Escalera;
import src.Obstaculos.SueloResbaladizo;
import src.Obstaculos.Trampa;
import src.Obstaculos.Pared;
import src.Obstaculos.ParedDestructible;
import src.Plataformas.*;
import src.Powers.*;
public class FabricaEntidades {
    protected FabricaSprites sprites;

    public FabricaEntidades (FabricaSprites fabrica){
        sprites=fabrica;
    }

    // Nivel llama a estos metodos con la posicion que le sea indicada mediante LectorDeNivel
    public DemonioRojo getDemonioRojo(Posicion pos){
        DemonioRojo demonio= new DemonioRojo(sprites.getSpritesDemonioRojo(), pos);
        return demonio;
    }

    public SnowBro getSnowBro(Posicion pos){
        SnowBro snow= new SnowBro(sprites.getSpritesSnowBro(), pos);
        return snow;
    }

    public Pared getParedIzquierda(Posicion pos){
        Pared pared=new Pared(sprites.getSpritesParedIzquierda(), pos);
        return pared;
    }

    public Pared getParedDerecha(Posicion pos){
        Pared pared=new Pared(sprites.getSpritesParedDerecha(), pos);
        return pared;
    }

    public Estatica getPlataformaEstatica(Posicion pos){
        return new Estatica(sprites.getSpritesEstatica(),pos);
    }

    public Movediza getPlataformaMovedizaAscensor(Posicion pos, int limiteSuperior, int limiteInferior, Movediza.Modo modo) {
        Movediza plataforma = new Movediza(sprites.getSpritesEstatica(), pos, modo);
        plataforma.configurarComoAscensor(limiteSuperior, limiteInferior, 2); 
        return plataforma;
    }

    public Movediza getPlataformaMovedizaLateral(Posicion pos, int limiteIzquierdo, int limiteDerecho, Movediza.Modo modo) {
        Movediza plataforma = new Movediza(sprites.getSpritesEstatica(), pos, modo);
        plataforma.configurarComoLateral(limiteIzquierdo, limiteDerecho, 2);
        return plataforma;
    }

    public Quebradiza getPlataformaQuebradiza(Posicion pos){
        Quebradiza pQuebradiza= new Quebradiza(sprites.getSpritesEstatica(),pos);
        return pQuebradiza;
    }

    public PocionRoja getPocionRoja(Posicion pos){
        PocionRoja pocion= new PocionRoja(sprites.getSpritesPocionRoja(),pos);
        return pocion;
    }

    public VidaExtra getVidaExtra(Posicion pos){
        VidaExtra vida= new VidaExtra(sprites.getSpritesVidaExtra(), pos);
        return vida;
    }

    public BolaDeNieve getBolaDeNieve(Posicion pos){
        BolaDeNieve bola= new BolaDeNieve(sprites.getSpritesBolaDeNieve(),pos);
        return bola;
    }

    public TrollAmarillo getTrollAmarillo(Posicion pos){
        TrollAmarillo troll = new TrollAmarillo(sprites.getSpritesTrollAmarillo(), pos); // <- MODIFICADO
        return troll;
    }

    public Calabaza getCalabaza(Posicion pos){
        Calabaza calabaza = new Calabaza(sprites.getSpritesCalabaza(), pos); // <- MODIFICADO
        return calabaza;
    }
    
    public FabricaSprites getFabricaSprites(){
        return this.sprites;
    }

    public ParedDestructible getParedDestructible(Posicion pos) {
        ParedDestructible pDest= new ParedDestructible(sprites.getSpritesEstatica(),pos);
        return pDest;
    }

    public SueloResbaladizo getSueloResbaladizo(Posicion pos) {
        SueloResbaladizo sueloR= new SueloResbaladizo(sprites.getSpritesEstatica(),pos);
        return sueloR;
    }

    public PowerUp getFruta(Posicion posicion) {
        Fruta fruta= new Fruta(sprites.getSpritesFruta(),posicion);
        return fruta;
    }

    public PowerUp getPocionVerde(Posicion posicion) {
        PocionVerde pocion= new PocionVerde(sprites.getSpritesPocionVerde(),posicion);
        return pocion;
    }

    public PowerUp getPocionAzul(Posicion posicion) {
        PocionAzul pocion= new PocionAzul(sprites.getSpritesPocionAzul(),posicion);
        return pocion;
    }

    public Trampa getTrampa(Posicion posicion) {
        Trampa trampa= new Trampa(sprites.getSpritesTrampa(),posicion);
        return trampa;
    }

    public Escalera getEscalera(Posicion posicion) {
        Escalera escalera= new Escalera(sprites.getSpritesEscalera(),posicion);
        return escalera;
    }

    public JefeDeNivel getKamakichi(Posicion posicion) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getKamakichi'");
    }

    public JefeDeNivel getMoguera(Posicion posicion) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getMoguera'");
    }
}
