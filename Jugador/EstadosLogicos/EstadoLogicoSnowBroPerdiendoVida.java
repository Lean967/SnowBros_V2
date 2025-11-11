package src.Jugador.EstadosLogicos;

import src.CapaDatos.ConstantesTeclado;
import src.CapaDatos.TeclasJugador;
import src.Jugador.SnowBro;

public class EstadoLogicoSnowBroPerdiendoVida extends EstadoLogicoSnowBroNormal {
    protected int duracionAnimacionPerderVida;


    public EstadoLogicoSnowBroPerdiendoVida(SnowBro snowBro){
        super(snowBro);
        duracionAnimacionPerderVida = 90;
        snowBro.getSprites().setEstadoActual(ConstantesTeclado.PerderVida);
    }

    public void perderVida(){
        System.out.println("SnowBro inmune, no pierde vida");
    }


    public void hacerBucle(){
        snowBro.detenerEnemigos(duracionAnimacionPerderVida);
        if(duracionAnimacionPerderVida>0)
            duracionAnimacionPerderVida--;
        else {
            //snowBro.getSprites().setEstadoActual(ConstantesTeclado.Quieto);
            snowBro.controlarVidas();
        }
    }
        /*else{
            //if(duracionAnimacionPerderVida==0) snowBro.controlarVidas();
            snowBro.mover();
        }*/
    
    public void mover(TeclasJugador teclas){
        
    }

    public void disparar(){

    }

    public void actualizarSpriteSegunMovimiento(){

    }
}

