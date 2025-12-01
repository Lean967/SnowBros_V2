package src.Jugador.EstadosLogicos;

import src.CapaDatos.ConstantesTeclado;
import src.Jugador.SnowBro;

public class EstadoLogicoSnowBroInmune extends EstadoLogicoSnowBroNormal{
    
    protected int tiempoInmunidad;

    public EstadoLogicoSnowBroInmune(SnowBro snowBro){
        super(snowBro);
        tiempoInmunidad=ConstantesTeclado.TIEMPO_INMUNIDAD;
        snowBro.getSprites().setEstadoActual(ConstantesTeclado.QUIETO);
    }

    public void perderVida(){
    }

    public void hacerBucle(){
        if(tiempoInmunidad>0)
            tiempoInmunidad--;
        else{
            snowBro.setEstadoLogico(new EstadoLogicoSnowBroNormal(snowBro));
        }
    }


}
