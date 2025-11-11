package src.GUI.InterfacesGUI;

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
}
