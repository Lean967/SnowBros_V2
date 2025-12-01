package src.Niveles.Modos;
import src.Niveles.Nivel;
import src.Niveles.NivelContrarreloj;
public class Contrarreloj extends ModoDeJuego {
    private int tiempoRestanteSegundos; // Tiempo restante para el modo Contrarreloj
    private int contadorCiclos; // Contador para simular 1 segundo
    private static final int CICLOS_POR_SEGUNDO = 60;
    private boolean jefeEnCombate=false;

    public Contrarreloj() {
        
    }
    public String getNombre(){
        return "CONTRARRELOJ";

    }
    public Nivel getNivel(){
        return new NivelContrarreloj();
    }

    public void hacerBucle() {
        modificarContadorCiclos();
    }


    public void modificarContadorCiclos() {
        if (contadorCiclos > 0) {
            contadorCiclos--;
        } else {
            tiempoRestanteSegundos--;
            actualizarTiempo(tiempoRestanteSegundos);

            contadorCiclos = CICLOS_POR_SEGUNDO;
        }
        // Verifico si termino el tiempo
        if(tiempoRestanteSegundos <= 0){
            nivel.perder();
        }
        else if (cantidadEnemigos == 0 && nivel.getSnowBro().getVidas() > 0 && !jefeEnCombate) {
            nivel.getJuego().nivelParaJefe();
            tiempoRestanteSegundos = nivel.getTiempoLimite();
            jefeEnCombate=true;
        }else if(jefeEnCombate && nivel.getJefeDeNivel() == null && nivel.getSnowBro().getVidas() > 0){
                nivel.ganarNivel();
        }
    }
    
    public void setTiempoContrarreloj(int segundos) {
        tiempoRestanteSegundos = segundos;
        contadorCiclos = CICLOS_POR_SEGUNDO;
    }

    public void actualizarTiempo(int tiempoRestanteSegundos) {
        nivel.getJuego().getControladorGrafica().actualizarTiempo(tiempoRestanteSegundos);
    }
    
}
