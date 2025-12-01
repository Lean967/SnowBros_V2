package src.Jugador.EstadosLogicos;

import src.CapaDatos.TeclasJugador;
import src.Enemigo.Enemigo;
import src.Jugador.SnowBro;

public class EstadoLogicoSnowBroMontado extends EstadoLogicoSnowBroNormal {
    protected Enemigo enemigo;

    public EstadoLogicoSnowBroMontado (SnowBro snowBro, Enemigo enemigo){
        super(snowBro);
        this.enemigo = enemigo;
        snowBro.setCayendo(false);
    }

    public void disparar() {
    }



    public void mover(TeclasJugador teclas){
        snowBro.getPosicion().setX(enemigo.getPosicion().getX());
        snowBro.getPosicion().setY(enemigo.getPosicion().getY() - snowBro.getBounds().height);
        if(snowBro.getTeclasJugador().getArriba()){
            snowBro.saltar();
            snowBro.setEstadoLogico(new EstadoLogicoSnowBroNormal(snowBro));
            snowBro.hacerVisible();
        }

        snowBro.update();
    }

    public void perderVida(){
        
    }
}