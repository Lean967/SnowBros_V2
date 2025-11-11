package src.Juego;
import src.Niveles.Nivel;
import src.Niveles.Modos.*;
public interface ControladorDeJuego {
    public void setDominio(String dominio);
    public void cambiarModoDeJuego(ModoDeJuego modo);
    public void iniciar();
    public void iniciarHiloJuego();
    public void detenerHiloJuego();
    public void cierreDeJuego();
    public void cortarJuego();
    public Nivel getNivelActual();
}
