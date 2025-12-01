package src.Jugador.EstadosLogicos;

import src.CapaDatos.ConstantesTeclado;
import src.CapaDatos.TeclasJugador;
import src.Jugador.SnowBro;

public class EstadoLogicoSnowBroPerdiendoVida extends EstadoLogicoSnowBroNormal {
    protected int duracionAnimacionPerderVida;


    public EstadoLogicoSnowBroPerdiendoVida(SnowBro snowBro){
        super(snowBro);
        duracionAnimacionPerderVida = ConstantesTeclado.ANIMACION_PERDER_VIDA;
        snowBro.getSprites().setEstadoActual(ConstantesTeclado.PERDER_VIDA);
    }

    public void perderVida(){
    }


    public void hacerBucle(){
        snowBro.detenerEnemigos();
        if(duracionAnimacionPerderVida>0)
            duracionAnimacionPerderVida--;
        else {
            snowBro.controlarVidas();
        }
    }
    
    public void mover(TeclasJugador teclas){
        
    }

    public void disparar(){

    }

    public void actualizarSpriteSegunMovimiento(){

    }
}

