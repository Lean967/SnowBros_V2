package src.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import src.CapaDatos.ConstantesVistas;
import src.Fabricas.SpritesOriginal;
import src.Fabricas.SpritesPersonal;
import src.GUI.InterfacesGUI.ControladorVistas;

public class PanelDominioAplicacion extends PanelVista {
    private JButton botonDominioOriginal;
    private JButton botonDominioPersonalizado;
    private JLabel imagenDominio;
    private JButton botonVolver;

    protected PanelDominioAplicacion(ControladorVistas controladorVistas) {
        super(controladorVistas);
         setLayout(null);
        setSize(ConstantesVistas.PANEL_ANCHO, ConstantesVistas.PANEL_ALTO);
        agregarBotonVolver();
        agregarImagenFondo();
        agregarBotonDominioOriginal();
        agregarBotonDominioPersonalizado();
        setComponentZOrder(imagenDominio, getComponentCount() - 1);
        setFocusable(true);
   
    }

   
    protected void agregarImagenFondo(){
        imagenDominio = new JLabel();
        ImageIcon iconoImagen = new ImageIcon(this.getClass().getResource("/src/imagenes/Fondos/pantalla_elegir_dominio.png"));
        Image imagenEscalada = iconoImagen.getImage();
		imagenEscalada = imagenEscalada.getScaledInstance(ConstantesVistas.PANEL_ANCHO, ConstantesVistas.PANEL_ALTO,  java.awt.Image.SCALE_SMOOTH);
        Icon iconoImagenEscalado = new ImageIcon(imagenEscalada);
		imagenDominio.setIcon(iconoImagenEscalado);
		imagenDominio.setBounds(0,0, ConstantesVistas.PANEL_ANCHO, ConstantesVistas.PANEL_ALTO);
		add(imagenDominio);
    }  

    protected void agregarBotonDominioOriginal(){
        botonDominioOriginal= new JButton();
        botonDominioOriginal.setVisible(true);
        botonDominioOriginal.setBounds((ConstantesVistas.PANEL_ANCHO / 2) - 135 ,ConstantesVistas.PANEL_ALTO - 150, 250, 80);
        // Hacer el botón transparente
        botonDominioOriginal.setOpaque(false);
        botonDominioOriginal.setContentAreaFilled(false);
        botonDominioOriginal.setBorderPainted(false);
        botonDominioOriginal.setFocusPainted(false);

        ImageIcon icono = new ImageIcon(this.getClass().getResource("/src/imagenes/botones/boton_original.png"));        
        Image imagenEscalada=icono.getImage();
        imagenEscalada= imagenEscalada.getScaledInstance(botonDominioOriginal.getWidth(), botonDominioOriginal.getHeight(),  java.awt.Image.SCALE_SMOOTH);
        Icon iconoImagenEscalado= new ImageIcon(imagenEscalada);
        botonDominioOriginal.setIcon(iconoImagenEscalado);

        botonDominioOriginal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controladorVistas.setDominio(new SpritesOriginal());
                controladorVistas.iniciarJuego();
                
            }
        });

        add(botonDominioOriginal);
    }

    protected void agregarBotonDominioPersonalizado(){
        botonDominioPersonalizado= new JButton();
        botonDominioPersonalizado.setVisible(true);
        botonDominioPersonalizado.setBounds((ConstantesVistas.PANEL_ANCHO / 2) - 135 ,ConstantesVistas.PANEL_ALTO - 240, 250 , 80);
        // Hacer el botón transparente
        botonDominioPersonalizado.setOpaque(false);
        botonDominioPersonalizado.setContentAreaFilled(false);
        botonDominioPersonalizado.setBorderPainted(false);
        botonDominioPersonalizado.setFocusPainted(false);

        ImageIcon icono = new ImageIcon(this.getClass().getResource("/src/imagenes/botones/boton_personalizado.png"));        
        Image imagenEscalada=icono.getImage();
        imagenEscalada= imagenEscalada.getScaledInstance(botonDominioPersonalizado.getWidth(), botonDominioPersonalizado.getHeight(),  java.awt.Image.SCALE_SMOOTH);
        Icon iconoImagenEscalado= new ImageIcon(imagenEscalada);
        botonDominioPersonalizado.setIcon(iconoImagenEscalado);

        botonDominioPersonalizado.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controladorVistas.setDominio(new SpritesPersonal());
                controladorVistas.iniciarJuego();
            }
        });

        add(botonDominioPersonalizado);
    }

    public void addNotify() {
        super.addNotify();
        requestFocusInWindow();
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
                controladorVistas.mostrarPantallaMenu();
            }
        });
        add(botonVolver);
        setComponentZOrder(botonVolver, 0);
    }
}