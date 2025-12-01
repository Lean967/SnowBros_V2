package src.Jugador.EstadosLogicos;

import src.CapaDatos.ConstantesTeclado;
import src.CapaDatos.TeclasJugador;
import src.Jugador.SnowBro;

public class EstadoLogicoSnowBroRodandoBola extends EstadoLogicoSnowBroNormal{

    public EstadoLogicoSnowBroRodandoBola(SnowBro snowBro) {
        super(snowBro);
    }


    public void disparar(){

    }

    public void mover(TeclasJugador teclas){
        if(teclas.getIzquierda()){
            snowBro.setPasoX(-1 * ConstantesTeclado.VELOCIDAD_RODAR_BOLA);
            snowBro.setMirar(ConstantesTeclado.MIRANDO_IZQUIERDA);
        }else if(teclas.getDerecha()){
            snowBro.setPasoX(1 * ConstantesTeclado.VELOCIDAD_RODAR_BOLA);
            snowBro.setMirar(ConstantesTeclado.MIRANDO_DERECHA);
        }else{
            snowBro.setPasoX(0);
        }
        snowBro.setCayendo(true);

        snowBro.getPosicion().setX(snowBro.getPasoX() + snowBro.getPosicion().getX());
        snowBro.setEstadoNormal();
        snowBro.setEstadoLogico(new EstadoLogicoSnowBroNormal(snowBro));
    }
}
