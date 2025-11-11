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

    public PanelMenu(ControladorVistas controladorVistas) {
        super(controladorVistas);
        setLayout(null);
        setSize(ConstantesVistas.PANEL_ANCHO, ConstantesVistas.PANEL_ALTO);
        agregarImagenFondo();
        agregarBotonElegirDominio();
        agregarBotonRanking();
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


    public void addNotify() {
        super.addNotify();
        requestFocusInWindow();
    }
}