package src.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import src.CapaDatos.ConstantesVistas;
import src.CapaDatos.TeclasJugador;
import src.GUI.InterfacesGUI.ControladorVistas;
import src.GUI.Observers.Observer;
import src.GUI.Observers.ObserverGrafico;
import src.GUI.Observers.ObserverJugador;
import src.Juego.EntidadLogica;
import src.Jugador.SnowBro;
import src.Niveles.Nivel;

public class PanelPartida extends PanelVista{
    private JLabel imagenJuego; 
    private JPanel indicadorSupBar; // panel para la barra superior
    private JLabel indicadorIconoJugador; // label para el icono del jugador
    private JLabel indicadorNumeroVidas; // label
    private JLabel indicadorPuntaje;
    private static final int ALTURA_BARRA = 40; // altura de la barra superior en píxeles
    private static final int TAM_DIGITO   = 20; // el tamaño de los números en pixeles
    private static final int X_DIGITO     = 44; // es la posición horizontal (44 píxeles desde el borde izquierdo del panel)
    private static final int TAM_ICONO = 22; // tamaño del icono del jugador en píxeles
    private static final int X_ICONO = 16; // posición horizontal del icono del jugador en píxeles
    private JButton botonVolver;
    private JLabel indicadorTiempo; // Label para el tiempo restante
    private static final int TAM_TIEMPO = 20; 
    private static final int X_TIEMPO   = 580;
    private Nivel nivel;
    private static final int ANCHO_PUNTAJE = 300;
    private static final int X_PUNTAJE = 100;
    private static final int Y_PUNTAJE = 10;

    public PanelPartida(ControladorVistas controladorVistas) {
        super(controladorVistas);
        setFocusable(true);
        setLayout(null);
        setPreferredSize(new Dimension(ConstantesVistas.PANEL_ANCHO, ConstantesVistas.PANEL_ALTO));
        agregarBotonVolver();
        configurarBarraSuperior();
    }
    
    protected void setNivel(Nivel n){
        nivel=n;
    }
    protected void agregarImagenFondo(String rutaImagen){
        imagenJuego = new JLabel();
        ImageIcon iconoImagen = new ImageIcon(this.getClass().getResource(rutaImagen));
        Image imagenEscalada = iconoImagen.getImage();
		imagenEscalada = imagenEscalada.getScaledInstance(ConstantesVistas.PANEL_ANCHO, ConstantesVistas.PANEL_ALTO,  java.awt.Image.SCALE_SMOOTH);
        Icon iconoImagenEscalado = new ImageIcon(imagenEscalada);
		imagenJuego.setIcon(iconoImagenEscalado);
		imagenJuego.setBounds(0,0, ConstantesVistas.PANEL_ANCHO, ConstantesVistas.PANEL_ALTO);
		add(imagenJuego);
        setComponentZOrder(imagenJuego, getComponentCount() - 1);
    }


    private void configurarBarraSuperior() {
        // JPanel que representa la franja negra arriba
        indicadorSupBar = new JPanel(null);
        indicadorSupBar.setBackground(Color.BLACK);
        indicadorSupBar.setBounds(0, 0, getWidth(), ALTURA_BARRA); 
        indicadorSupBar.setOpaque(true);

        // Instancio el icono del jugador y lo seteo en la barra superior
        ImageIcon ico = new ImageIcon(getClass().getResource("../imagenes/barra_superior_partida/elemento-barra-jugador.png"));
        Image esc = ico.getImage().getScaledInstance(22, 22, Image.SCALE_SMOOTH);
        indicadorIconoJugador = new JLabel(new ImageIcon(esc));
        indicadorIconoJugador.setBounds(X_ICONO, (ALTURA_BARRA - TAM_ICONO) / 2, TAM_ICONO, TAM_ICONO);
        indicadorSupBar.add(indicadorIconoJugador);

        // Configuro para el número de vidas en las pantallas
        indicadorNumeroVidas = new JLabel();
        indicadorNumeroVidas.setBounds(X_DIGITO, (ALTURA_BARRA - TAM_DIGITO) / 2, TAM_DIGITO, TAM_DIGITO);
        indicadorSupBar.add(indicadorNumeroVidas);

        // Configuración para el puntaje
        indicadorPuntaje = new JLabel("00000"); // Puntaje inicial
        indicadorPuntaje.setForeground(Color.WHITE); 
        indicadorPuntaje.setFont(new Font("Monospaced", Font.BOLD, 18));
        indicadorPuntaje.setBounds(X_PUNTAJE, Y_PUNTAJE, ANCHO_PUNTAJE, TAM_DIGITO);
        indicadorSupBar.add(indicadorPuntaje);

        //configuro indicador de tiempo para contrarreloj
        indicadorTiempo = new JLabel("00:00"); 
        indicadorTiempo.setForeground(Color.WHITE); 
        indicadorTiempo.setFont(new Font("Monospaced", Font.BOLD, TAM_TIEMPO)); 
        indicadorTiempo.setBounds(X_TIEMPO, (ALTURA_BARRA - TAM_TIEMPO) / 2, 70, TAM_TIEMPO); 
        indicadorSupBar.add(indicadorTiempo);
        indicadorTiempo.setVisible(false); // Por defecto, oculto

        agregarBotonVolver();
        add(indicadorSupBar);
        setComponentZOrder(indicadorSupBar, 0);
    }

    public Observer incorporarSnowBro(SnowBro snowBro){
        ObserverJugador observerJugador = new ObserverJugador(this, snowBro);
        Dimension preferida = observerJugador.getPreferredSize();
        if (preferida == null || preferida.width == 0 || preferida.height == 0) {
          preferida = new Dimension(48, 48); // Ajustar según el tamaño real del sprite
          observerJugador.setPreferredSize(preferida);
        }
        observerJugador.setSize(preferida);
        configurarTeclasJugador(snowBro);
    
        imagenJuego.add(observerJugador);
        imagenJuego.setComponentZOrder(observerJugador, 0);
        observerJugador.update();

        actualizarIndicadorVidas(snowBro.getVidas()); // Inicializa el indicador de vidas

        actualizar();
        return observerJugador;
    }

    public Observer incorporarEntidad(EntidadLogica entidad){
        ObserverGrafico observerEntidad = new ObserverGrafico( entidad);
        imagenJuego.add(observerEntidad);

        observerEntidad.update();

        actualizar();
        return observerEntidad;
    }

    public void configurarTeclasJugador(SnowBro snowBro){
        //  Manejador de teclas
        TeclasJugador teclas = new TeclasJugador(snowBro);
        snowBro.setTeclas(teclas);

        setFocusable(true);
        addKeyListener(teclas);
        requestFocusInWindow();
    }

    // Cambia la imagen de vidas según las vidas actuales
    public void actualizarIndicadorVidas(int vidas) {
        String ruta;
        switch (vidas) {
            case 0: ruta = "/src/imagenes/barra_superior_partida/font-numero-0.png"; break;
            case 1: ruta = "/src/imagenes/barra_superior_partida/font-numero-1.png"; break;
            case 2: ruta = "/src/imagenes/barra_superior_partida/font-numero-2.png"; break;
            default: ruta = "/src/imagenes/barra_superior_partida/font-numero-3.png"; break;
        }
        // Cada 'case' selecciona la imagen del número correspondiente. El 'break' evita que el código siga ejecutando los demás casos
        indicadorNumeroVidas.setIcon(new ImageIcon(new ImageIcon(getClass().getResource(ruta)).getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT)));
        indicadorNumeroVidas.setBounds(X_DIGITO, (ALTURA_BARRA - TAM_DIGITO) / 2, TAM_DIGITO, TAM_DIGITO);
    }


    public void actualizarIndicadorPuntaje(int puntaje) {
        String puntajeFormateado = String.format("%05d", puntaje); 
        indicadorPuntaje.setText("PUNTAJE: "+puntajeFormateado);
    }
    
    // Redefinimos doLayout para que la barra superior siempre quede arriba y se adapte al ancho del panel, incluso si la ventana cambia de tamaño

    @Override
    public void doLayout() {
        super.doLayout();
        if (indicadorSupBar != null) 
            indicadorSupBar.setSize(getWidth(), indicadorSupBar.getHeight());
    }
    

    public void addNotify() {
        super.addNotify();
        requestFocusInWindow();
    }

    protected void actualizar(){
        revalidate();
        repaint();
    }

    protected void agregarBotonVolver(){
        botonVolver = new JButton();
        botonVolver.setVisible(true);
        int ANCHO_BOTON = 100;
        int ALTO_BOTON = ALTURA_BARRA;
        int MARGEN_DERECHA = 10;
        int xPos = ConstantesVistas.PANEL_ANCHO - ANCHO_BOTON - MARGEN_DERECHA; 
        int yPos = 0;
        botonVolver.setBounds(xPos, yPos, ANCHO_BOTON , ALTO_BOTON);
        
        // Botón transparente
        botonVolver.setOpaque(false);
        botonVolver.setContentAreaFilled(false);
        botonVolver.setBorderPainted(false);
        botonVolver.setFocusPainted(false);

        ImageIcon icono = new ImageIcon(this.getClass().getResource("/src/imagenes/botones/boton_volver.png"));
        Image imagenEscalada=icono.getImage();
        imagenEscalada= imagenEscalada.getScaledInstance(ANCHO_BOTON, ALTO_BOTON, java.awt.Image.SCALE_SMOOTH);
        Icon iconoImagenEscalado= new ImageIcon(imagenEscalada);
        botonVolver.setIcon(iconoImagenEscalado);

        botonVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controladorVistas.mostrarPantallaMenu();
                nivel.perder();
            }
        });

        //Agrego a barra sup
        if (indicadorSupBar != null) {
            indicadorSupBar.add(botonVolver);
        } else {
            System.err.println("Error: indicadorSupBar no está inicializado al agregar el botón Volver.");
            add(botonVolver);
        }
    }

    // Lo llama hacerCicloDeJuego
    public void actualizarTiempo(int tiempoRestanteSegundos) {
        SwingUtilities.invokeLater(() -> {
            indicadorTiempo.setText(formatearTiempo(tiempoRestanteSegundos));
            indicadorTiempo.setVisible(true);
            actualizar();
            
            if (tiempoRestanteSegundos <= 10) {
                 indicadorTiempo.setForeground(Color.RED);
            }
        });
    }

    private String formatearTiempo(int totalSegundos) {
        int minutos = totalSegundos / 60;
        int segundos = totalSegundos % 60;
        return String.format("%02d:%02d", minutos, segundos);
    }
    
    // Método para detener la visualización del contador
    public void detenerContadorVisual() {
        SwingUtilities.invokeLater(() -> {
            indicadorTiempo.setVisible(false);
            indicadorTiempo.setForeground(Color.WHITE);
        });
    }
}
