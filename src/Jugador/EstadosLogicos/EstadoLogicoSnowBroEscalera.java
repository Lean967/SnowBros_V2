package src.Jugador.EstadosLogicos;

import src.CapaDatos.ConstantesTeclado;
import src.CapaDatos.TeclasJugador;
import src.Juego.Posicion;
import src.Jugador.SnowBro;

public class EstadoLogicoSnowBroEscalera extends EstadoLogicoSnowBroNormal{

    public EstadoLogicoSnowBroEscalera(SnowBro snowBro) {
        super(snowBro);
        snowBro.setPasoX(snowBro.getVelocidadDefectoX()/4);
        snowBro.setCayendo(false);
        snowBro.setPasoY(3);

    }

    public void mover(TeclasJugador teclas){
        Posicion posicion = snowBro.getPosicion();

        snowBro.getSprites().setEstadoActual(ConstantesTeclado.QUIETO);
        if(teclas.getArriba()){
            posicion.setY(posicion.getY() - snowBro.getPasoY());
            snowBro.getSprites().setEstadoActual(ConstantesTeclado.MOVIENDOSE_DERECHA);
        }else if(teclas.getAbajo()){
            posicion.setY(posicion.getY() + snowBro.getPasoY());
            snowBro.getSprites().setEstadoActual(ConstantesTeclado.MOVIENDOSE_IZQUIERDA);
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

        snowBro.update();
    }

    public void hacerBucle(){
        if(snowBro.getEnEscalera() == false){
            snowBro.setEstadoLogico(new EstadoLogicoSnowBroNormal(snowBro));
        }
    }

}
