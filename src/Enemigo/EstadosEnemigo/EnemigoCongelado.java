package src.Enemigo.EstadosEnemigo;

import src.CapaDatos.ConstantesTeclado;
import src.Enemigo.Enemigo;
import src.Fabricas.Sprites;
import src.Jugador.SnowBro;
import src.Municiones.BolaDeNieve;
import src.Obstaculos.Pared;
import src.Obstaculos.ParedDestructible;

public class EnemigoCongelado extends EstadoEnemigo {
    protected boolean colisionandoConPared;

    public EnemigoCongelado(Enemigo e, Sprites misSprites){
        super(e,misSprites);
        misSprites.setEstadoActual(ConstantesTeclado.CONGELADO5);
        enemigo.setPasoX(0);
        enemigo.setCongelamiento(480);
        enemigo.aumentarPuntajePorCongelamiento();
        colisionandoConPared=false;
    }

    public void hacerBucle(){
        enemigo.descongelar();
    }


    public void hacerEfecto(SnowBro snowBro) {
      int snowBaseY = snowBro.getPosicion().getY() + snowBro.getBounds().height;
    
    // Rango de tolerancia vertical para considerar colisión superior (montaje)
      boolean colisionSuperior = snowBro.getCayendo() && (snowBaseY <= enemigo.getBounds().getMaxY() - 5);
      boolean colisionLateral = !colisionSuperior; 
      int direccionSnowBro = snowBro.getMirar() == ConstantesTeclado.MIRANDO_DERECHA ? 1 : -1;

      if (colisionSuperior) {
        // 1. MONTARSE ENCIMA 
        int snowBroWidth = snowBro.getBounds().width;
        int enemigoWidth = enemigo.getBounds().width;
        int centrarX = enemigo.getPosicion().getX() + (enemigoWidth / 2) - (snowBroWidth / 2);
        
        snowBro.getPosicion().setX(centrarX);
        snowBro.getPosicion().setY(enemigo.getPosicion().getY() - snowBro.getBounds().height);

        snowBro.SubirseAEnemigo(enemigo);
        enemigo.setEstado(new EnemigoCongeladoImpulsado(enemigo, misSprites, direccionSnowBro * ConstantesTeclado.VELOCIDAD_LANZAMIENTO_BOLA, snowBro));
        

      } else if (colisionLateral) {
        

        if (snowBro.getTeclasJugador().getEspacioPresionado()) {

            enemigo.setEstado(new EnemigoCongeladoImpulsado(enemigo, misSprites,direccionSnowBro * ConstantesTeclado.VELOCIDAD_PATEAR_BOLA, snowBro));
            snowBro.getEstadoSpritesSnowBro().getSprites().setEstadoActual(ConstantesTeclado.QUIETO); 
        } 
        else {
            if(!colisionandoConPared){
              boolean snowBroEmpujaDerecha = (snowBro.getPosicion().getX() < enemigo.getPosicion().getX()) && 
              snowBro.getTeclasJugador().getDerecha(); 
                                            
              boolean snowBroEmpujaIzquierda = (snowBro.getPosicion().getX() > enemigo.getPosicion().getX()) && 
              snowBro.getTeclasJugador().getIzquierda(); 

              if (snowBroEmpujaDerecha || snowBroEmpujaIzquierda) {
                  
                  // Si está empujando, la dirección de la bola es la dirección del movimiento
                  snowBro.setEstadoRodandoBola();
                  if(snowBroEmpujaDerecha) snowBro.getEstadoSpritesSnowBro().getSprites().setEstadoActual(ConstantesTeclado.MOVIENDOSE_DERECHA);
                  else snowBro.getEstadoSpritesSnowBro().getSprites().setEstadoActual(ConstantesTeclado.MOVIENDOSE_IZQUIERDA);
                  
                  enemigo.setPasoX(direccionSnowBro * ConstantesTeclado.VELOCIDAD_RODAR_BOLA);

                  enemigo.mover();
                  enemigo.setPasoX(0);
              }
            }
        }
      }

    }

    

    public void buscarSnowBro(SnowBro snowBro) {
    }

    public void hacerEfecto(Enemigo enemigo) {
       
    }

    public void hacerEfecto(ParedDestructible paredDestructible){
      enemigo.setPasoX(enemigo.getPasoX() * (-1));
      colisionandoConPared=true;
    }

    public void hacerEfecto(BolaDeNieve bolaDeNieve) {
        
    }

    public void hacerEfecto(Pared pared){
      colisionandoConPared=true;
    }

    
}
