package src.GUI.InterfacesGUI;

import src.Fabricas.FabricaSprites;
import src.Niveles.Modos.ModoDeJuego;

public interface ControladorVistas {
    public void iniciarJuego();
    public void iniciarHiloJuego();
    public void detenerHiloJuego();
    public void mostrarPantallaMenu();
    public void mostrarPantallaPartida();
    public void mostrarPantallaInicio();
    public void mostrarPantallaRanking();
    public void mostrarPantallaDominioAplicacion();
    public void mostrarPantallaModoJuego();
    public void cambiarModoDeJuego(ModoDeJuego modo);
    public void setNombreJugador(String nombreJugador);
    public String getNombreJugador();
    public void setDominio(FabricaSprites fabrica);
}
