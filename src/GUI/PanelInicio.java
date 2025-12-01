package src.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import src.CapaDatos.ConstantesVistas;
import src.CapaDatos.GestorSonido;
import src.GUI.InterfacesGUI.ControladorVistas;

public class PanelInicio extends PanelVista{

    private JLabel imagenInicio;
    private JButton botonIniciarPartida;
    protected static GestorSonido gestorSonido = GestorSonido.getInstancia();


    public PanelInicio(ControladorVistas controladorVistas) {
        super(controladorVistas);
        setSize(ConstantesVistas.PANEL_ANCHO, ConstantesVistas.PANEL_ALTO);
        setLayout(null);
        agregarImagenFondo();
        agregarBotonIniciarPartida();
        //Forzamos el botón a estar en la capa superior 
        setComponentZOrder(botonIniciarPartida, 0);
        setFocusable(true);
    }

    protected void agregarImagenFondo(){
        imagenInicio = new JLabel();
        ImageIcon iconoImagen = new ImageIcon(this.getClass().getResource("/src/imagenes/Fondos/pantallainicio.jpeg"));
        Image imagenEscalada = iconoImagen.getImage();
		imagenEscalada = imagenEscalada.getScaledInstance(ConstantesVistas.PANEL_ANCHO, ConstantesVistas.PANEL_ALTO,  java.awt.Image.SCALE_SMOOTH);
        Icon iconoImagenEscalado = new ImageIcon(imagenEscalada);
		imagenInicio.setIcon(iconoImagenEscalado);
		imagenInicio.setBounds(0,0, ConstantesVistas.PANEL_ANCHO, ConstantesVistas.PANEL_ALTO);
		add(imagenInicio);
    }   

    protected void agregarBotonIniciarPartida(){
        botonIniciarPartida = new JButton();
        botonIniciarPartida.setVisible(true);
        botonIniciarPartida.setBounds((ConstantesVistas.PANEL_ANCHO / 2) - 100 ,ConstantesVistas.PANEL_ALTO - 150, 200 , 50);
        // Hacer el botón transparente
        botonIniciarPartida.setOpaque(false);
        botonIniciarPartida.setContentAreaFilled(false);
        botonIniciarPartida.setBorderPainted(false);
        botonIniciarPartida.setFocusPainted(false);

        ImageIcon icono = new ImageIcon(this.getClass().getResource("/src/imagenes/botones/start_icono.png"));        
        Image imagenEscalada=icono.getImage();
        imagenEscalada= imagenEscalada.getScaledInstance(botonIniciarPartida.getWidth(), botonIniciarPartida.getHeight(),  java.awt.Image.SCALE_SMOOTH);
        Icon iconoImagenEscalado= new ImageIcon(imagenEscalada);
        botonIniciarPartida.setIcon(iconoImagenEscalado);

        botonIniciarPartida.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gestorSonido.reproducirSonido("BOTON_START");
                setNombreJugador();
                if(controladorVistas.getNombreJugador()!=null)
                   controladorVistas.mostrarPantallaModoJuego();
            }
        });

        add(botonIniciarPartida);
    }

    public void setNombreJugador(){
        Icon iconoPersonalizado;
            try {
                ImageIcon iconoOriginal = new ImageIcon(this.getClass().getResource("/src/imagenes/icono_nombre_jugador.png"));
                Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(
                    50, 50, Image.SCALE_SMOOTH);
                iconoPersonalizado = new ImageIcon(imagenEscalada);
            } catch (Exception ex) {
                // En caso de error, usa el icono de pregunta por defecto
                iconoPersonalizado = UIManager.getIcon("OptionPane.questionIcon");
            }

            String nombreJugador = (String) JOptionPane.showInputDialog(
                PanelInicio.this, 
                "Ingresa tu nombre para empezar a jugar:", 
                "SNOW BRO'S NICK & TOM (TDP'S VERSION)", 
                JOptionPane.PLAIN_MESSAGE, 
                iconoPersonalizado, 
                null, 
                null 
            );
            if (nombreJugador != null && !nombreJugador.trim().isEmpty()) {
                
                // Opcional: Limitar la longitud del nombre y eliminar espacios extra
                nombreJugador = nombreJugador.trim(); 
                if (nombreJugador.length() > 10) {
                    nombreJugador = nombreJugador.substring(0, 10);
                }
                
                controladorVistas.setNombreJugador(nombreJugador);
            } else {
                JOptionPane.showMessageDialog(
                    PanelInicio.this, 
                    "Debes ingresar un nombre para continuar.", 
                    "Advertencia", 
                    JOptionPane.WARNING_MESSAGE
                );
            }
        }



    // Cuando el panel se agrega a la ventana, pedimos el foco para que reciba eventos del teclado sin hacer clic
    public void addNotify() {
        gestorSonido.reproducirMusica("PANELES_MUSICA");
        super.addNotify();
        requestFocusInWindow();
    }

}
