package src.Jugador.EstadosLogicos;

import src.CapaDatos.ConstantesTeclado;
import src.CapaDatos.TeclasJugador;
import src.Juego.Posicion;
import src.Jugador.SnowBro;

public class EstadoLogicoSnowBroNormal  {
    protected SnowBro snowBro;
    protected int duracionAnimacionPerderVida;


    public EstadoLogicoSnowBroNormal(SnowBro snowBro){
        this.snowBro=snowBro;
    }

    public void mover(TeclasJugador teclas){
        snowBro.setEnEscalera(false);
        Posicion posicion = snowBro.getPosicion();
        
        snowBro.setPosAnterior(posicion.clonar());
        snowBro.setPasoX(5);
    
        if (teclas.getArriba() && !snowBro.getCayendo()) {
            snowBro.saltar();
        }
        if (teclas.getIzquierda()) {
            /*if(!cayendo){
                this.estadoSprites.misSprites.setEstadoActual(ConstantesTeclado.MoviendoseIzquierda);
            }*/
            if(posicion.getX() - snowBro.getPasoX() < -10)
                posicion.setX(-10);
            else
                posicion.setX(posicion.getX() - snowBro.getPasoX());
                snowBro.setMirar(ConstantesTeclado.SnowBroMirandoIzquierda); 
        }
        if (teclas.getDerecha()) {
            /*if(!cayendo){
                this.estadoSprites.misSprites.setEstadoActual(ConstantesTeclado.MoviendoseDerecha);
            }*/
            if(posicion.getX() + snowBro.getPasoX() > 760)
                posicion.setX(760);
            else 
                posicion.setX(posicion.getX() + snowBro.getPasoX());
                snowBro.setMirar(ConstantesTeclado.SnowBroMirandoDerecha);
        }
        /*if(!cayendo && !teclas.getDerecha() && !teclas.getIzquierda()){

            this.estadoSprites.misSprites.setEstadoActual(ConstantesTeclado.Quieto);
        }*/
        if(snowBro.getCayendo()){
            if(posicion.getY() + snowBro.getPasoX() > 520)
                posicion.setY(520);
            else{
                if((snowBro.getPasoY() + ConstantesTeclado.Gravedad) <= ConstantesTeclado.MaxVelocidadCaida){
                    snowBro.setPasoY(ConstantesTeclado.Gravedad + snowBro.getPasoY());
                }
                posicion.setY(posicion.getY() + snowBro.getPasoY());
                //this.estadoSprites.misSprites.setEstadoActual(ConstantesTeclado.Saltando);
            }
            
        }
        actualizarSpriteSegunMovimiento();
        snowBro.setCayendo(true);
        snowBro.update();
    }

    public void perderVida(){
        snowBro.setVida(snowBro.getVidas() - 1);
        System.out.println("-1 vida");
        snowBro.setEstadoLogico(new EstadoLogicoSnowBroPerdiendoVida(snowBro));
        //snowBro.controlarVidas();   
    }

    public void disparar() {
        snowBro.getNivelActual().setBolaDeNieve(snowBro.getPosicion().getX(), snowBro.getPosicion().getY());
        System.out.println("Disparando bola de nieve");
    }

    public void actualizarSpriteSegunMovimiento(){
      boolean teclasMovimiento = snowBro.getTeclasJugador().getDerecha() || snowBro.getTeclasJugador().getIzquierda();

      if(snowBro.getEnEscalera()){
        return;
      }
      if(snowBro.getCayendo()){
        snowBro.getEstadoSpritesSnowBro().getSprites().setEstadoActual(ConstantesTeclado.Saltando);
      } 
      else {if (snowBro.getTeclasJugador().getIzquierda()) {
               snowBro.getEstadoSpritesSnowBro().getSprites().setEstadoActual(ConstantesTeclado.MoviendoseIzquierda);
            } 
            else if (snowBro.getTeclasJugador().getDerecha()) {
                    snowBro.getEstadoSpritesSnowBro().getSprites().setEstadoActual(ConstantesTeclado.MoviendoseDerecha);
                 } 
                 else if (!teclasMovimiento) {
                    snowBro.getEstadoSpritesSnowBro().getSprites().setEstadoActual(ConstantesTeclado.Quieto);
                 }
      }
    }
 

    public void hacerBucle(){
        
    }
}


