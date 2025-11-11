package src.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import src.CapaDatos.ConstantesVistas;
import src.GUI.InterfacesGUI.ControladorVistas;

public class PanelInicio extends PanelVista{

    private JLabel imagenInicio;
    private JButton botonIniciarPartida;
    

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
                controladorVistas.mostrarPantallaMenu();
            }
        });

        add(botonIniciarPartida);
    }


    // Cuando el panel se agrega a la ventana, pedimos el foco para que reciba eventos del teclado sin hacer clic
    public void addNotify() {
        super.addNotify();
        requestFocusInWindow();
    }

}
