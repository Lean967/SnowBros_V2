package src.GUI;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import src.CapaDatos.ConstantesVistas;
import src.CapaDatos.GestorSonido;
import src.GUI.InterfacesGUI.ControladorVistas;


public class PanelJuegoGanado extends PanelVista{
    private JLabel imagenGanar;
    private JButton botonMenu;
    protected GestorSonido gestorSonido = GestorSonido.getInstancia();
    

    public PanelJuegoGanado(ControladorVistas controladorVistas) {
        super(controladorVistas);
        setSize(ConstantesVistas.PANEL_ANCHO, ConstantesVistas.PANEL_ALTO);
        setLayout(null);
        agregarImagenFondo();
        agregarBotonMenu();
        //Forzamos el botón a estar en la capa superior 
        setComponentZOrder(botonMenu, 0);
        setFocusable(true);
    }

    protected void agregarImagenFondo(){
        imagenGanar = new JLabel();
        ImageIcon iconoImagen = new ImageIcon(this.getClass().getResource("/src/imagenes/Fondos/pantalla_ganador.png"));
        Image imagenEscalada = iconoImagen.getImage();
		imagenEscalada = imagenEscalada.getScaledInstance(ConstantesVistas.PANEL_ANCHO, ConstantesVistas.PANEL_ALTO,  java.awt.Image.SCALE_SMOOTH);
        Icon iconoImagenEscalado = new ImageIcon(imagenEscalada);
		imagenGanar.setIcon(iconoImagenEscalado);
		imagenGanar.setBounds(0,0, ConstantesVistas.PANEL_ANCHO, ConstantesVistas.PANEL_ALTO);
		add(imagenGanar);
    }   

    protected void agregarBotonMenu(){
        botonMenu = new JButton();
        botonMenu.setVisible(true);
        botonMenu.setBounds((ConstantesVistas.PANEL_ANCHO / 2) -100,ConstantesVistas.PANEL_ALTO - 210, 180, 80);
        // Hacer el botón transparente
        botonMenu.setOpaque(false);
        botonMenu.setContentAreaFilled(false);
        botonMenu.setBorderPainted(false);
        botonMenu.setFocusPainted(false);

        ImageIcon icono = new ImageIcon(this.getClass().getResource("/src/imagenes/botones/boton_menu.png"));        
        Image imagenEscalada=icono.getImage();
        imagenEscalada= imagenEscalada.getScaledInstance(botonMenu.getWidth(), botonMenu.getHeight(),  java.awt.Image.SCALE_SMOOTH);
        Icon iconoImagenEscalado= new ImageIcon(imagenEscalada);
        botonMenu.setIcon(iconoImagenEscalado);

        botonMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controladorVistas.mostrarPantallaModoJuego();
            }
        });

        add(botonMenu);
    }

    public void addNotify() {
        gestorSonido.detenerMusica();
        gestorSonido.reproducirMusica("JUEGO_GANADO");
        super.addNotify();
        requestFocusInWindow();
    }

}

