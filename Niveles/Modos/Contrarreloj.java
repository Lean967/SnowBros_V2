package src.Niveles.Modos;
import src.Juego.Juego;
import src.Niveles.Nivel;
import src.Niveles.NivelContrarreloj;
public class Contrarreloj extends ModoDeJuego {
    private int tiempoRestanteSegundos; // Tiempo restante para el modo Contrarreloj
    private int contadorCiclos; // Contador para simular 1 segundo
    private static final int CICLOS_POR_SEGUNDO = 60;

    public Contrarreloj() {
        
    }
    public String getNombre(){
        return "CONTRARRELOJ";

    }
    public Nivel getNivel(){
        return new NivelContrarreloj();
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
        if (tiempoRestanteSegundos <= 0) {
            verificarFinDelTiempo();
        }
    }
    private void verificarFinDelTiempo() {
        if (nivel == null || nivel.getJuego() == null) 
            return;
        Juego juego = nivel.getJuego();
        if (nivel.getSnowBro() != null && nivel.getSnowBro().getVidas()>0) {
            juego.ganarNivel();
        } else {
            juego.perderNivel();
        }
    }
    public void setTiempoContrarreloj(int segundos) {
        tiempoRestanteSegundos = segundos;
        contadorCiclos = CICLOS_POR_SEGUNDO;
    }

    public void actualizarTiempo(int tiempoRestanteSegundos) {
        if (nivel != null && nivel.getJuego() != null) {
            nivel.getJuego().getControladorGrafica().actualizarTiempo(tiempoRestanteSegundos);
        }
    }
    
}
