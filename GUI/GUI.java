package src.GUI;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import src.CapaDatos.ConstantesVistas;
import src.CapaDatos.GestorRanking;
import src.GUI.InterfacesGUI.ControladorGrafica;
import src.GUI.InterfacesGUI.ControladorVistas;
import src.GUI.Observers.Observer;
import src.Juego.ControladorDeJuego;
import src.Juego.EntidadLogica;
import src.Jugador.SnowBro;
import src.Niveles.Modos.ModoDeJuego;

public class GUI implements ControladorGrafica, ControladorVistas {
    protected JFrame ventana;
    protected PanelPartida panelPartida;
    protected PanelMenu panelMenu;
    protected PanelRanking panelRanking;
    protected ControladorDeJuego controladorJuego;
    protected PanelInicio panelInicio;
    protected PanelDominioAplicacion panelDominioAplicacion;
    protected PanelModoJuego panelModoJuego;
    protected PanelGameOver panelGameOver;
    protected GestorRanking gestorR;
   

    public GUI(){
        this.gestorR = new GestorRanking();
        panelPartida = new PanelPartida(this);
        panelMenu = new PanelMenu(this);
        panelRanking = new PanelRanking(this, gestorR);
        panelInicio = new PanelInicio(this);
        panelDominioAplicacion= new PanelDominioAplicacion(this);
        panelModoJuego= new PanelModoJuego(this);
        panelGameOver= new PanelGameOver(this);
       
    }

    public void configurarVentana(){
        ventana = new JFrame("TdP :: Snowbros Nick & Tom");
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setResizable(false);
		ventana.setSize(ConstantesVistas.VENTANA_ANCHO, ConstantesVistas.VENTANA_ALTO);
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);
		ventana.setFocusable(true);
        ventana.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                cierreDeJuego();
            }
        });
	}
    
    public void iniciarJuego(){
        controladorJuego.iniciar();
    }
    public void iniciarHiloJuego(){
        controladorJuego.iniciarHiloJuego();
    }

    public void detenerHiloJuego(){
        controladorJuego.detenerHiloJuego();
    }

    public void ganarNivel(){
        //TODO hay que hacerlo bien
        mostrarPantallaFinDeJuego();
    }

    public void perderNivel(){
        mostrarPantallaGameOver();
    }

    public void cambiarModoDeJuego(ModoDeJuego modo){
        controladorJuego.cambiarModoDeJuego(modo);
    }
    

    public Observer registrarSnowBro(SnowBro snowBro){
        Observer observerJugador = panelPartida.incorporarSnowBro(snowBro);
        actualizarGUI();
        return observerJugador;
    }

    public Observer registrarEntidad(EntidadLogica entidad){
        Observer observerEntidad = panelPartida.incorporarEntidad(entidad);
        actualizarGUI();
        return observerEntidad;
    }

    public void configurarControles(SnowBro snowBro){
        panelPartida.configurarTeclasJugador(snowBro);

    }

    public void agregarImagenFondoPartida(String ruta){
        panelPartida.agregarImagenFondo(ruta);
    }

    public void mostrarPantallaMenu(){
        ventana.setContentPane(panelMenu);
        actualizarGUI();
    }

    public void mostrarPantallaGameOver(){
        ventana.setContentPane(panelGameOver);
        actualizarGUI();
    }

    public void mostrarPantallaPartida(){
        ventana.setContentPane(panelPartida);
        actualizarGUI();
    }

    public void mostrarPantallaRanking(){
        ventana.setContentPane(panelRanking);
        actualizarGUI();
    }

    public void mostrarPantallaFinDeJuego(){

    }

    public void mostrarPantallaInicio() {
        ventana.setContentPane(panelInicio);
        actualizarGUI();
    }

    public void mostrarPantallaDominioAplicacion(){
        ventana.setContentPane(panelDominioAplicacion);
        actualizarGUI();
    }

    public void mostrarPantallaModoJuego(){
        ventana.setContentPane(panelModoJuego);
        actualizarGUI();
    }

    protected void actualizarGUI() {
		ventana.revalidate();
		ventana.repaint();
	}

    public void registrarControladorDeJuego(ControladorDeJuego juego) {
        this.controladorJuego = juego;
        panelPartida.setNivel(controladorJuego.getNivelActual());
    }

    public PanelPartida getPanelPartida() {
        return panelPartida;
    }

    public void cierreDeJuego(){
        controladorJuego.cierreDeJuego();
    }

    public void actualizarTiempo(int tiempoRestanteSegundos) {
        panelPartida.actualizarTiempo(tiempoRestanteSegundos);
    }
}