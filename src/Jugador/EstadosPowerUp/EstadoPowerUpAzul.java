package src.Jugador.EstadosPowerUp;

import src.CapaDatos.ConstantesTeclado;
import src.Jugador.SnowBro;

public class EstadoPowerUpAzul extends EstadoPowerUpNormal{
    protected int tiempoPocionAzul;

    public EstadoPowerUpAzul(SnowBro snowBro){
        super(snowBro);
        tiempoPocionAzul=ConstantesTeclado.TIEMPO_POCION_AZUL;
        snowBro.setVelocidadDefectoX(ConstantesTeclado.VELOCIDAD_POCIONAZUL_SNOWBRO_X);
    }

    public void hacerBucle(){
        if(tiempoPocionAzul>0)
            tiempoPocionAzul--;
        else{
            snowBro.setEstadoPowerUp(new EstadoPowerUpNormal(snowBro));
        }
    }
}
