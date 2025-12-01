package src.Jugador.EstadosLogicos;

import src.CapaDatos.ConstantesTeclado;
import src.CapaDatos.GestorSonido;
import src.CapaDatos.TeclasJugador;
import src.Juego.Posicion;
import src.Jugador.SnowBro;
import src.Municiones.BolaDeFuego;
import src.Municiones.Bomba;

public class EstadoLogicoSnowBroNormal  {
    protected SnowBro snowBro;
    protected int duracionAnimacionPerderVida;
    protected GestorSonido gestorSonido = GestorSonido.getInstancia();



    public EstadoLogicoSnowBroNormal(SnowBro snowBro){
        this.snowBro=snowBro;
        
    }

    public void mover(TeclasJugador teclas){
        snowBro.setEnEscalera(false);
        Posicion posicion = snowBro.getPosicion();
        
        snowBro.setPosAnterior(posicion.clonar());
        snowBro.setPasoX(snowBro.getVelocidadDefectoX());
    
        if (teclas.getArriba() && !snowBro.getCayendo()) {
            snowBro.saltar();
        }
        if (teclas.getIzquierda()) {
            if(posicion.getX() - snowBro.getPasoX() < -10)
                posicion.setX(-10);
            else
                posicion.setX(posicion.getX() - snowBro.getPasoX());
                snowBro.setMirar(ConstantesTeclado.MIRANDO_IZQUIERDA); 
        }
        if (teclas.getDerecha()) {
            if(posicion.getX() + snowBro.getPasoX() > 760)
                posicion.setX(760);
            else 
                posicion.setX(posicion.getX() + snowBro.getPasoX());
                snowBro.setMirar(ConstantesTeclado.MIRANDO_DERECHA);
        }

        if(snowBro.getCayendo()){
            if(posicion.getY() + snowBro.getPasoX() > 520)
                posicion.setY(520);
            else{
                if((snowBro.getPasoY() + ConstantesTeclado.GRAVEDAD) <= ConstantesTeclado.MAX_VELOCIDAD_CAIDA){
                    snowBro.setPasoY(ConstantesTeclado.GRAVEDAD + snowBro.getPasoY());
                }
                posicion.setY(posicion.getY() + snowBro.getPasoY());
            }
            
        }
        actualizarSpriteSegunMovimiento();
        snowBro.setCayendo(true);
        snowBro.update();
    }

    public void perderVida(){
        gestorSonido.reproducirSonido("SNOW_PERDER_VIDA");
        snowBro.setVida(snowBro.getVidas() - 1);
        snowBro.setEstadoLogico(new EstadoLogicoSnowBroPerdiendoVida(snowBro));
    }

    public void disparar() {
        snowBro.getNivelActual().setBolaDeNieve(snowBro.getPosicion().getX(), snowBro.getPosicion().getY(), snowBro.getDaño());
        gestorSonido.reproducirSonido("SNOW_DISPARO_BOLADENIEVE");
    }

    public void hacerEfecto(BolaDeFuego bolaDeFuego){
        perderVida();
    }
    public void hacerEfecto(Bomba bomba){
        perderVida();
    }

    public void actualizarSpriteSegunMovimiento(){
      boolean teclasMovimiento = snowBro.getTeclasJugador().getDerecha() || snowBro.getTeclasJugador().getIzquierda();

      if(snowBro.getEnEscalera()){
        return;
      }
      if(snowBro.getCayendo()){
        snowBro.getEstadoSpritesSnowBro().getSprites().setEstadoActual(ConstantesTeclado.SALTANDO);
      } 
      else {if (snowBro.getTeclasJugador().getIzquierda()) {
               snowBro.getEstadoSpritesSnowBro().getSprites().setEstadoActual(ConstantesTeclado.MOVIENDOSE_IZQUIERDA);
            } 
            else if (snowBro.getTeclasJugador().getDerecha()) {
                    snowBro.getEstadoSpritesSnowBro().getSprites().setEstadoActual(ConstantesTeclado.MOVIENDOSE_DERECHA);
                 } 
                 else if (!teclasMovimiento) {
                    if(snowBro.getMirar()==ConstantesTeclado.QUIETOIZQUIERDA)
                        snowBro.getEstadoSpritesSnowBro().getSprites().setEstadoActual(ConstantesTeclado.QUIETOIZQUIERDA);
                    else snowBro.getEstadoSpritesSnowBro().getSprites().setEstadoActual(ConstantesTeclado.QUIETODERECHA);
                 }
      }
    }
 

    public void hacerBucle(){
        
    }
}


