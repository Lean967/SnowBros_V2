package src.GUI;

import javax.swing.*;
import java.awt.*;
import src.CapaDatos.ConstantesVistas;
import src.CapaDatos.TeclasJugador;
import src.GUI.InterfacesGUI.ControladorVistas;
import src.GUI.Observers.Observer;
import src.GUI.Observers.ObserverGrafico;
import src.GUI.Observers.ObserverJugador;
import src.Juego.EntidadLogica;
import src.Jugador.SnowBro;

public class PanelPartida extends PanelVista{
    private JLabel imagenJuego; 
    private JPanel indicadorSupBar; // panel para la barra superior
    private JLabel indicadorIconoJugador; // label para el icono del jugador
    private JLabel indicadorNumeroVidas; // label
    private JLabel[] indicadorPuntajeDigitos;
    private static final int ALTURA_BARRA = 40; // altura de la barra superior en píxeles
    private static final int TAM_DIGITO   = 20; // el tamaño de los números en pixeles
    private static final int X_DIGITO     = 44; // es la posición horizontal (44 píxeles desde el borde izquierdo del panel)
    private static final int TAM_ICONO = 22; // tamaño del icono del jugador en píxeles
    private static final int X_ICONO = 16; // posición horizontal del icono del jugador en píxeles
    private JLabel[] indicadorTiempoDigitos; // Label para el tiempo restante
    private static final int TAM_TIEMPO = 20; 
    private static final int X_TIEMPO   = 500;
    private static final int ANCHO_DOS_PUNTOS = 6;
    private static final int X_PUNTAJE = 80;
    private static final int Y_PUNTAJE = 10;
    private TeclasJugador teclasActuales;
    private JLabel indicadorNivelTexto;
    private JLabel indicadorNivelNumero;
    private static final int X_NIVEL_TEXTO = 300;
    private static final int X_NIVEL_NUMERO = 360;
    private static final int TAM_ICONO_NIVEL = 22;

    public PanelPartida(ControladorVistas controladorVistas) {
        super(controladorVistas);
        setFocusable(true);
        setLayout(null);
        setPreferredSize(new Dimension(ConstantesVistas.PANEL_ANCHO, ConstantesVistas.PANEL_ALTO));
        configurarBarraSuperior();
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
        // Cargar imagen de la barra superior
        ImageIcon barraImgIcon = new ImageIcon(getClass().getResource("/src/imagenes/barra_superior_partida/barra-negra-superior.jpg"));
        Image barraImg = barraImgIcon.getImage();

        // JPanel personalizado que dibuja la imagen
        indicadorSupBar = new JPanel(null) {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(barraImg, 0, 0, getWidth(), getHeight(), this);
            }
        };

        indicadorSupBar.setBounds(0, 0, getWidth(), ALTURA_BARRA);
        indicadorSupBar.setOpaque(false);

        // Instancio el icono del jugador y lo seteo en la barra superior
        ImageIcon ico = new ImageIcon(getClass().getResource("../imagenes/barra_superior_partida/elemento-barra-jugador.png"));
        Image esc = ico.getImage().getScaledInstance(22, 22, Image.SCALE_SMOOTH);
        indicadorIconoJugador = new JLabel(new ImageIcon(esc));
        indicadorIconoJugador.setBounds(X_ICONO, (ALTURA_BARRA - TAM_ICONO) / 2, TAM_ICONO, TAM_ICONO);
        indicadorSupBar.add(indicadorIconoJugador);

        // Configuro para el número de vidas en las pantallas
        indicadorNumeroVidas = new JLabel();
        indicadorNumeroVidas.setBounds(X_DIGITO, 10, TAM_DIGITO, TAM_DIGITO);
        indicadorSupBar.add(indicadorNumeroVidas);

        // Configuración para el puntaje
        ImageIcon iconoPuntaje = new ImageIcon(getClass().getResource("/src/imagenes/barra_superior_partida/puntaje.png"));
        Image imgPuntaje = iconoPuntaje.getImage().getScaledInstance(90, 25, Image.SCALE_SMOOTH);
        JLabel indicadorPuntajeTexto = new JLabel(new ImageIcon(imgPuntaje));
        indicadorPuntajeTexto.setBounds(X_PUNTAJE, 10, 90, 25);
        indicadorSupBar.add(indicadorPuntajeTexto);

        // Configuro los dígitos del puntaje (5 dígitos)
        indicadorPuntajeDigitos = new JLabel[5];
        for (int i = 0; i < 5; i++) {
            indicadorPuntajeDigitos[i] = new JLabel();
            indicadorPuntajeDigitos[i].setBounds(X_PUNTAJE + 100 + (i * TAM_DIGITO),12,TAM_DIGITO,TAM_DIGITO);            
            indicadorSupBar.add(indicadorPuntajeDigitos[i]);
        }
        actualizarIndicadorPuntaje(0); // Inicializa el puntaje en 00000

        // Configuro los dígitos del tiempo
        indicadorTiempoDigitos = new JLabel[5];
        int currentX = X_TIEMPO;
        for (int i = 0; i < 5; i++) {
            indicadorTiempoDigitos[i] = new JLabel();
            int width = (i == 2) ? ANCHO_DOS_PUNTOS : TAM_TIEMPO;
            indicadorTiempoDigitos[i].setBounds(currentX,10,width,TAM_TIEMPO);
            indicadorSupBar.add(indicadorTiempoDigitos[i]);
            indicadorTiempoDigitos[i].setVisible(false);

            currentX += width; // sumo el ancho para el siguiente dígito
        }
        actualizarTiempo(0);

        // Imagen "NIVEL"
        ImageIcon iconoNivelTexto = new ImageIcon(getClass().getResource("/src/imagenes/barra_superior_partida/nivel.png"));
        int ANCHO_NIVEL_TEXTO = 60;
        int ALTO_NIVEL_TEXTO = 20;
        Image imgNivelTexto = iconoNivelTexto.getImage().getScaledInstance(ANCHO_NIVEL_TEXTO, ALTO_NIVEL_TEXTO, Image.SCALE_SMOOTH);
        indicadorNivelTexto = new JLabel(new ImageIcon(imgNivelTexto));
        indicadorNivelTexto.setBounds(X_NIVEL_TEXTO, 12, ANCHO_NIVEL_TEXTO, ALTO_NIVEL_TEXTO);
        indicadorSupBar.add(indicadorNivelTexto);

        // Imagen del número
        ImageIcon iconoNum = new ImageIcon(getClass().getResource("/src/imagenes/barra_superior_partida/font-numero-1.png"));
        Image imgNum = iconoNum.getImage().getScaledInstance(TAM_ICONO_NIVEL, TAM_ICONO_NIVEL, Image.SCALE_SMOOTH);
        indicadorNivelNumero = new JLabel(new ImageIcon(imgNum));
        indicadorNivelNumero.setBounds(X_NIVEL_NUMERO, 10, TAM_ICONO_NIVEL, TAM_ICONO_NIVEL);
        indicadorSupBar.add(indicadorNivelNumero);

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

        if (teclasActuales != null) {
            removeKeyListener(teclasActuales);
        }
        configurarTeclasJugador(snowBro);

        observerJugador.setSize(preferida);
        
    
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
        teclasActuales = new TeclasJugador(snowBro);
        snowBro.setTeclas(teclasActuales);

        setFocusable(true);
        addKeyListener(teclasActuales);
        requestFocusInWindow();
    }

    public void actualizarIndicadorVidas(int vidas) {
        String ruta;
        switch (vidas) {
            case 0: ruta = "/src/imagenes/barra_superior_partida/font-numero-0.png"; break;
            case 1: ruta = "/src/imagenes/barra_superior_partida/font-numero-1.png"; break;
            case 2: ruta = "/src/imagenes/barra_superior_partida/font-numero-2.png"; break;
            default: ruta = "/src/imagenes/barra_superior_partida/font-numero-3.png"; break;
        }
        indicadorNumeroVidas.setIcon(new ImageIcon(new ImageIcon(getClass().getResource(ruta)).getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT)));
        indicadorNumeroVidas.setBounds(X_DIGITO, 10, TAM_DIGITO, TAM_DIGITO);
    }


    public void actualizarIndicadorPuntaje(int puntaje) {
        String puntajeFormateado = String.format("%05d", puntaje);
        for (int i = 0; i < 5; i++) {
            char digito = puntajeFormateado.charAt(i);
            String ruta = "/src/imagenes/barra_superior_partida/font-numero-" + digito + ".png";
            try {
                ImageIcon icono = new ImageIcon(getClass().getResource(ruta));
                Image img = icono.getImage().getScaledInstance(TAM_DIGITO, TAM_DIGITO, Image.SCALE_SMOOTH);
                indicadorPuntajeDigitos[i].setIcon(new ImageIcon(img));
            } catch (Exception e) {
                System.out.println("Error cargando imagen para el dígito " + digito + ": " + ruta);
            }
        }
        actualizar();
    }
    
    public void doLayout() {
        super.doLayout();
        if (indicadorSupBar != null) 
            indicadorSupBar.setSize(getWidth(), indicadorSupBar.getHeight());
    }

    public void limpiarEntidades(){
        if (imagenJuego != null) {
        imagenJuego.removeAll(); // Elimina todos los Observers (entidades gráficas)
        }
        if (imagenJuego != null) {
            remove(imagenJuego);
        }
        imagenJuego = null; 
        actualizar();
    }
    

    public void addNotify() {
        super.addNotify();
        requestFocusInWindow();
    }

    protected void actualizar(){
        revalidate();
        repaint();
    }

    // Lo llama hacerCicloDeJuego. Actualiza el tiempo mostrado en formato MM:SS
    public void actualizarTiempo(int tiempoRestanteSegundos) {
        SwingUtilities.invokeLater(() -> {
            int minutos = tiempoRestanteSegundos / 60;
            int segundos = tiempoRestanteSegundos % 60;
            String tiempoFormateado = String.format("%02d:%02d", minutos, segundos);

            int labelIndex = 0;
            for (int i = 0; i < tiempoFormateado.length(); i++) {
                char c = tiempoFormateado.charAt(i);
                String ruta;
                int width = TAM_TIEMPO;
                if (c == ':') {
                    ruta = "/src/imagenes/barra_superior_partida/font-dos-puntos.jpg";
                    width = ANCHO_DOS_PUNTOS;
                } else {
                    ruta = "/src/imagenes/barra_superior_partida/font-numero-" + c + ".png";
                }
                try {
                    ImageIcon icono = new ImageIcon(getClass().getResource(ruta));
                    Image img = icono.getImage().getScaledInstance(width, TAM_TIEMPO, Image.SCALE_SMOOTH);
                    indicadorTiempoDigitos[labelIndex].setIcon(new ImageIcon(img));
                    indicadorTiempoDigitos[labelIndex].setVisible(true);
                    labelIndex++;
                } catch (Exception e) {
                    System.out.println("Error cargando imagen para " + c + ": " + ruta);
                }
            }

            if (tiempoRestanteSegundos <= 10) {
                for (JLabel digito : indicadorTiempoDigitos) {
                    digito.setForeground(Color.RED);
                }
            } else {
                for (JLabel digito : indicadorTiempoDigitos) {
                    digito.setForeground(Color.WHITE);
                }
            }
            actualizar();
        });
    }

    public void detenerContadorVisual() {
        SwingUtilities.invokeLater(() -> {
            for (JLabel digito : indicadorTiempoDigitos) {
                digito.setVisible(false);
                digito.setForeground(Color.WHITE);
            }
        });
    }

    public void actualizarIndicadorNivel(int nivel) {
        String rutaNumero = "/src/imagenes/barra_superior_partida/font-numero-" + nivel + ".png";
        try {
            ImageIcon icono = new ImageIcon(getClass().getResource(rutaNumero));
            Image img = icono.getImage().getScaledInstance(TAM_ICONO_NIVEL, TAM_ICONO_NIVEL, Image.SCALE_SMOOTH);
            indicadorNivelNumero.setIcon(new ImageIcon(img));
        } catch (Exception e) {
            System.out.println("No existe imagen para el nivel " + nivel + ": " + rutaNumero);
        }

        actualizar();
    }
}
