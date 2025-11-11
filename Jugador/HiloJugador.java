package src.Jugador;

public class HiloJugador extends Thread{
    protected Thread hiloJugador= new Thread();
    protected SnowBro snow;

    public HiloJugador(SnowBro snow){
        this.snow=snow;
    }

    public void setSnowBro(SnowBro snow){
        this.snow=snow;
    }


    public void run(){
        snow.mover();
    }
}
