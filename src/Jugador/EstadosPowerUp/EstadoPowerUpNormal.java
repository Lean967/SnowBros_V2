package src.Jugador.EstadosPowerUp;

import src.CapaDatos.ConstantesTeclado;
import src.Jugador.SnowBro;

public class EstadoPowerUpNormal {
    protected SnowBro snowBro;

    public EstadoPowerUpNormal(SnowBro snowBro){
        this.snowBro= snowBro;
        snowBro.setVelocidadDefectoX(ConstantesTeclado.VELOCIDAD_SNOWBRO_X);
        snowBro.setDaño(ConstantesTeclado.DAÑO_BOLA_NIEVE);
    }

    public void hacerBucle(){
        
    }

}
