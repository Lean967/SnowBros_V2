package src.Juego;
import src.Fabricas.FabricaSprites;
import src.Niveles.Nivel;
import src.Niveles.Modos.*;
public interface ControladorDeJuego {
    public void setDominio(FabricaSprites fabricaSprites);
    public void cambiarModoDeJuego(ModoDeJuego modo);
    public void iniciar();
    public void iniciarCicloDeJuego();
    public void siguienteNivel();
    public void detenerHiloJuego();
    public void cierreDeJuego();
    public void cortarJuego();
    public Nivel getNivelActual();
    public void setNombreJugador(String nombreJugador);
    public String getNombreJugador();
}
