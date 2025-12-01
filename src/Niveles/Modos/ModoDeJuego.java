package src.Niveles.Modos;
import src.Niveles.Nivel;

public abstract class ModoDeJuego {
    protected int cantidadEnemigos;
    protected Nivel nivel;
    protected int tiempoTranscurrido = 0;
    protected int contadorCiclosAsc = 0;
    protected static final int CICLOS_POR_SEGUNDO = 60;
    
    public abstract String getNombre();
    public abstract void hacerBucle();
    public void modificarContadorCiclos(){}
    public void setTiempoContrarreloj(int duracionContrarreloj) {}

    public void setNivel(Nivel nivel){
    this.nivel = nivel;
    }
    public abstract Nivel getNivel();

    public void setEnemigosRestantes(int enemigosRestantes){
        cantidadEnemigos = enemigosRestantes;
    }

    public void matarEnemigo(){
        cantidadEnemigos--;
    }

    public void reiniciarTiempoAscendente() {
        tiempoTranscurrido = 0;
        contadorCiclosAsc = CICLOS_POR_SEGUNDO;
    }

    public void actualizarTiempoAscendente() {
        if (contadorCiclosAsc > 0) {
            contadorCiclosAsc--;
        } else {
            tiempoTranscurrido++;
            nivel.getJuego().getControladorGrafica().actualizarTiempo(tiempoTranscurrido);
            contadorCiclosAsc = CICLOS_POR_SEGUNDO;
        }
    }

}
