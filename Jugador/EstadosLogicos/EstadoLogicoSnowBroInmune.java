package src.Jugador.EstadosLogicos;

import src.CapaDatos.ConstantesTeclado;
import src.Jugador.SnowBro;

public class EstadoLogicoSnowBroInmune extends EstadoLogicoSnowBroNormal{
    
    protected int tiempoInmunidad;

    public EstadoLogicoSnowBroInmune(SnowBro snowBro){
        super(snowBro);
        tiempoInmunidad=180;
        snowBro.getSprites().setEstadoActual(ConstantesTeclado.Quieto);
    }

    public void perderVida(){
        System.out.println("SnowBro inmune, no pierde vida");
    }

    public void hacerBucle(){
        if(tiempoInmunidad>0)
            tiempoInmunidad--;
        else{
            snowBro.setEstadoLogico(new EstadoLogicoSnowBroNormal(snowBro));
        }
    }


}
