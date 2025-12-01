package src.Jugador.EstadosPowerUp;

import src.CapaDatos.ConstantesTeclado;
import src.Jugador.SnowBro;

public class EstadoPowerUpVerde extends EstadoPowerUpNormal{
    protected int tiempoPocionVerde;

    public EstadoPowerUpVerde(SnowBro snowBro){
        super(snowBro);
        tiempoPocionVerde= ConstantesTeclado.TIEMPO_POCION_VERDE;
    }

    public void hacerBucle(){
        if(tiempoPocionVerde>0){
            tiempoPocionVerde--;
            snowBro.getNivelActual().detenerEnemigos();
        }
        else{
            snowBro.getNivelActual().liberarEnemigos();
            snowBro.setEstadoPowerUp(new EstadoPowerUpNormal(snowBro));

        }
    }
}
