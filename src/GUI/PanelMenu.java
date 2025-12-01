package src.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import src.CapaDatos.ConstantesVistas;
import src.GUI.InterfacesGUI.ControladorVistas;

public class PanelMenu extends PanelVista {
    private JButton botonElegirDominio;
    private JButton botonRanking;
    private JLabel imagenMenu;
    private JButton botonVolver;


    public PanelMenu(ControladorVistas controladorVistas) {
        super(controladorVistas);
        setLayout(null);
        setSize(ConstantesVistas.PANEL_ANCHO, ConstantesVistas.PANEL_ALTO);
        agregarImagenFondo();
        agregarBotonElegirDominio();
        agregarBotonRanking();
        agregarBotonVolver();
        setComponentZOrder(imagenMenu, getComponentCount() - 1);
        setFocusable(true);

    }

    protected void agregarImagenFondo(){
        imagenMenu = new JLabel();
        ImageIcon iconoImagen = new ImageIcon(this.getClass().getResource("/src/imagenes/Fondos/pantalla_menu.png"));
        Image imagenEscalada = iconoImagen.getImage();
		imagenEscalada = imagenEscalada.getScaledInstance(ConstantesVistas.PANEL_ANCHO, ConstantesVistas.PANEL_ALTO,  java.awt.Image.SCALE_SMOOTH);
        Icon iconoImagenEscalado = new ImageIcon(imagenEscalada);
		imagenMenu.setIcon(iconoImagenEscalado);
		imagenMenu.setBounds(0,0, ConstantesVistas.PANEL_ANCHO, ConstantesVistas.PANEL_ALTO);
		add(imagenMenu);
    }  
    

    private void agregarBotonElegirDominio() {
        botonElegirDominio = new JButton();
        botonElegirDominio.setVisible(true);
        botonElegirDominio.setBounds((ConstantesVistas.PANEL_ANCHO / 2) -140 ,ConstantesVistas.PANEL_ALTO - 180, 250 , 80);

        botonElegirDominio.setOpaque(false);
        botonElegirDominio.setContentAreaFilled(false);
        botonElegirDominio.setBorderPainted(false);
        botonElegirDominio.setFocusPainted(false);

        ImageIcon icono = new ImageIcon(this.getClass().getResource("/src/imagenes/botones/boton_elegir_dominio.png"));        
        Image imagenEscalada=icono.getImage();
        imagenEscalada= imagenEscalada.getScaledInstance(botonElegirDominio.getWidth(), botonElegirDominio.getHeight(),  java.awt.Image.SCALE_SMOOTH);
        Icon iconoImagenEscalado= new ImageIcon(imagenEscalada);
        botonElegirDominio.setIcon(iconoImagenEscalado);

        botonElegirDominio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controladorVistas.mostrarPantallaDominioAplicacion();
            }
        });

        add(botonElegirDominio);
    }

    private void agregarBotonRanking() {
        botonRanking= new JButton();
        botonRanking.setVisible(true);
        botonRanking.setBounds((ConstantesVistas.PANEL_ANCHO / 2) -140 ,ConstantesVistas.PANEL_ALTO - 320, 250 , 80);

        botonRanking.setOpaque(false);
        botonRanking.setContentAreaFilled(false);
        botonRanking.setBorderPainted(false);
        botonRanking.setFocusPainted(false);

        ImageIcon icono = new ImageIcon(this.getClass().getResource("/src/imagenes/botones/boton_ranking.png"));        
        Image imagenEscalada=icono.getImage();
        imagenEscalada= imagenEscalada.getScaledInstance(botonRanking.getWidth(), botonRanking.getHeight(),  java.awt.Image.SCALE_SMOOTH);
        Icon iconoImagenEscalado= new ImageIcon(imagenEscalada);
        botonRanking.setIcon(iconoImagenEscalado);

        botonRanking.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controladorVistas.mostrarPantallaRanking();
            }
        });

        add(botonRanking);
    }

    protected void agregarBotonVolver(){
        botonVolver = new JButton();
        botonVolver.setVisible(true);
        final int ANCHO_BOTON = 100; // Ancho para el botón en la esquina
        final int ALTO_BOTON = 40;   // Alto del botón
        final int MARGEN_DERECHO = 20; // Espacio desde el borde derecho
        final int MARGEN_SUPERIOR = 20; // Espacio desde el borde superior
        int xPos = ConstantesVistas.PANEL_ANCHO - ANCHO_BOTON - MARGEN_DERECHO;
        int yPos = MARGEN_SUPERIOR;
        botonVolver.setBounds(xPos, yPos, ANCHO_BOTON , ALTO_BOTON);

        // Hacer el botón transparente
        botonVolver.setOpaque(false);
        botonVolver.setContentAreaFilled(false);
        botonVolver.setBorderPainted(false);
        botonVolver.setFocusPainted(false);

        ImageIcon icono = new ImageIcon(this.getClass().getResource("/src/imagenes/botones/boton_volver.png"));        
        Image imagenEscalada=icono.getImage();
        imagenEscalada= imagenEscalada.getScaledInstance(botonVolver.getWidth(), botonVolver.getHeight(),  java.awt.Image.SCALE_SMOOTH);
        Icon iconoImagenEscalado= new ImageIcon(imagenEscalada);
        botonVolver.setIcon(iconoImagenEscalado);

        botonVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controladorVistas.mostrarPantallaModoJuego();
            }
        });
        add(botonVolver);
        setComponentZOrder(botonVolver, 0);
    }


    public void addNotify() {
        super.addNotify();
        requestFocusInWindow();
    }
}