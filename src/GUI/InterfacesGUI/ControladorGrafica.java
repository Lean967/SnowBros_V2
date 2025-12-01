package src.GUI.InterfacesGUI;

import src.Juego.EntidadLogica;
import src.Juego.Ranking;
import src.GUI.Observers.Observer;
import src.Juego.ControladorDeJuego;
import src.Jugador.SnowBro;

public interface ControladorGrafica {
    public void mostrarPantallaPartida();
    public void mostrarPantallaRanking();
    public void mostrarPantallaMenu();
    public void mostrarPantallaFinDeJuego();
    public void mostrarPantallaInicio();
    public void mostrarPantallaDominioAplicacion();
    public void registrarControladorDeJuego(ControladorDeJuego juego);
    public Observer registrarEntidadEstatica(EntidadLogica entidad);
    public Observer registrarEntidadEnemigo(EntidadLogica enemigo);
    public Observer registrarSnowBro(SnowBro snowBro);
    public void configurarVentana();
    public void configurarControles(SnowBro snowBro);
    public void ganarNivel();
    public void perderNivel();
    public void actualizarTiempo(int tiempoRestanteSegundos);
    public void agregarImagenFondoPartida(String ruta);
    public void setPanelRanking(Ranking ranking);
    public void limpiarEntidadesPartida();
    public void ganarJuego();
    public void actualizarIndiceNivel(int nivel);
    public Object getPanelPartida();
}
