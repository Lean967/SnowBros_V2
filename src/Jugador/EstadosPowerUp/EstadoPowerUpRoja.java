package src.Jugador.EstadosPowerUp;

import src.CapaDatos.ConstantesTeclado;
import src.Jugador.SnowBro;

public class EstadoPowerUpRoja extends EstadoPowerUpNormal{
    protected int tiempoPocionRoja;
    
    public EstadoPowerUpRoja(SnowBro snowBro){
        super(snowBro);
        tiempoPocionRoja=ConstantesTeclado.TIEMPO_POCION_ROJA;
        snowBro.setDaño(ConstantesTeclado.DAÑO_BOLA_NIEVE_POCIONROJA);
        snowBro.setVelocidadDefectoX(ConstantesTeclado.VELOCIDAD_SNOWBRO_X);
    }

    public void hacerBucle(){
        if(tiempoPocionRoja>0)
            tiempoPocionRoja--;
        else {
            snowBro.setEstadoPowerUp(new EstadoPowerUpNormal(snowBro));
        }
    }
}
