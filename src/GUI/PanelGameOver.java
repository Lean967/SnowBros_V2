package src.GUI;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import src.CapaDatos.ConstantesVistas;
import src.GUI.InterfacesGUI.ControladorVistas;

public class PanelGameOver extends PanelVista{
    private JLabel imagenGameOver;
    private JButton botonTryAgain;
    private JButton botonMenu;
    

    public PanelGameOver(ControladorVistas controladorVistas) {
        super(controladorVistas);
        setSize(ConstantesVistas.PANEL_ANCHO, ConstantesVistas.PANEL_ALTO);
        setLayout(null);
        agregarImagenFondo();
        agregarBotonIntentarDeNuevo();
        agregarBotonMenu();
        //Forzamos el botón a estar en la capa superior 
        setComponentZOrder(botonTryAgain, 0);
        setComponentZOrder(botonMenu, 0);
        setFocusable(true);
    }

    protected void agregarImagenFondo(){
        imagenGameOver = new JLabel();
        ImageIcon iconoImagen = new ImageIcon(this.getClass().getResource("/src/imagenes/Fondos/pantalla_game_over.png"));
        Image imagenEscalada = iconoImagen.getImage();
		imagenEscalada = imagenEscalada.getScaledInstance(ConstantesVistas.PANEL_ANCHO, ConstantesVistas.PANEL_ALTO,  java.awt.Image.SCALE_SMOOTH);
        Icon iconoImagenEscalado = new ImageIcon(imagenEscalada);
		imagenGameOver.setIcon(iconoImagenEscalado);
		imagenGameOver.setBounds(0,0, ConstantesVistas.PANEL_ANCHO, ConstantesVistas.PANEL_ALTO);
		add(imagenGameOver);
    }   

    protected void agregarBotonIntentarDeNuevo(){
        botonTryAgain = new JButton();
        botonTryAgain.setVisible(true);
        botonTryAgain.setBounds((ConstantesVistas.PANEL_ANCHO / 2) - 230,ConstantesVistas.PANEL_ALTO - 210, 230, 80);
        // Hacer el botón transparente
        botonTryAgain.setOpaque(false);
        botonTryAgain.setContentAreaFilled(false);
        botonTryAgain.setBorderPainted(false);
        botonTryAgain.setFocusPainted(false);

        ImageIcon icono = new ImageIcon(this.getClass().getResource("/src/imagenes/botones/boton_intenta_de_nuevo.png"));        
        Image imagenEscalada=icono.getImage();
        imagenEscalada= imagenEscalada.getScaledInstance(botonTryAgain.getWidth(), botonTryAgain.getHeight(),  java.awt.Image.SCALE_SMOOTH);
        Icon iconoImagenEscalado= new ImageIcon(imagenEscalada);
        botonTryAgain.setIcon(iconoImagenEscalado);

        botonTryAgain.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controladorVistas.iniciarJuego();
            }
        });

        add(botonTryAgain);
    }

    protected void agregarBotonMenu(){
        botonMenu = new JButton();
        botonMenu.setVisible(true);
        botonMenu.setBounds((ConstantesVistas.PANEL_ANCHO / 2) - 5,ConstantesVistas.PANEL_ALTO - 210, 180, 80);
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

}
