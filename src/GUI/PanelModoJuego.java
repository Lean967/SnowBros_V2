package src.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import src.CapaDatos.ConstantesVistas;
import src.CapaDatos.GestorSonido;
import src.GUI.InterfacesGUI.ControladorVistas;
import src.Niveles.Modos.Clasico;
import src.Niveles.Modos.Contrarreloj;
import src.Niveles.Modos.Supervivencia;

public class PanelModoJuego extends PanelVista {
    private JButton botonModoClasico;
    private JButton botonModoSupervivencia;
    private JButton botonModoContrarreloj;
    private JLabel imagenModo;
    protected GestorSonido gestorSonido = GestorSonido.getInstancia();


    protected PanelModoJuego(ControladorVistas controladorVistas) {
        super(controladorVistas);
        setLayout(null);
        setSize(ConstantesVistas.PANEL_ANCHO, ConstantesVistas.PANEL_ALTO);
        agregarFondo();
        agregarBotonModoClasico();
        agregarBotonModoSupervivencia();
        agregarBotonModoContrarreloj();
        setComponentZOrder(imagenModo, getComponentCount() - 1);
        setFocusable(true);
        
    }

    
    private void agregarFondo() {
        imagenModo = new JLabel();
        URL recurso = getClass().getResource("/src/imagenes/Fondos/pantalla_modo.png");
        ImageIcon iconoImagen = new ImageIcon(recurso);
        Image imagenEscalada = iconoImagen.getImage().getScaledInstance(
                ConstantesVistas.PANEL_ANCHO, ConstantesVistas.PANEL_ALTO, Image.SCALE_SMOOTH);
        imagenModo.setIcon(new ImageIcon(imagenEscalada));
        imagenModo.setBounds(0, 0, ConstantesVistas.PANEL_ANCHO, ConstantesVistas.PANEL_ALTO);
        add(imagenModo);
    }

   protected void agregarBotonModoClasico(){
        botonModoClasico= new JButton();
        botonModoClasico.setVisible(true);
        botonModoClasico.setBounds((ConstantesVistas.PANEL_ANCHO / 2) - 100,ConstantesVistas.PANEL_ALTO - 200, 200, 80);
        // Hacer el botón transparente
        botonModoClasico.setOpaque(false);
        botonModoClasico.setContentAreaFilled(false);
        botonModoClasico.setBorderPainted(false);
        botonModoClasico.setFocusPainted(false);

        ImageIcon icono = new ImageIcon(this.getClass().getResource("/src/imagenes/botones/boton_clasico.png"));        
        Image imagenEscalada=icono.getImage();
        imagenEscalada= imagenEscalada.getScaledInstance(botonModoClasico.getWidth(), botonModoClasico.getHeight(),  java.awt.Image.SCALE_SMOOTH);
        Icon iconoImagenEscalado= new ImageIcon(imagenEscalada);
        botonModoClasico.setIcon(iconoImagenEscalado);

        botonModoClasico.addActionListener((ActionListener) new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controladorVistas.cambiarModoDeJuego(new Clasico());
                controladorVistas.mostrarPantallaMenu();

            }
        });

        add(botonModoClasico);
    }

    protected void agregarBotonModoSupervivencia(){
        botonModoSupervivencia= new JButton();
        botonModoSupervivencia.setVisible(true);
        botonModoSupervivencia.setBounds((ConstantesVistas.PANEL_ANCHO)-300, ConstantesVistas.PANEL_ALTO - 200, 210, 85);
        botonModoSupervivencia.setOpaque(false);
        botonModoSupervivencia.setContentAreaFilled(false);
        botonModoSupervivencia.setBorderPainted(false);
        botonModoSupervivencia.setFocusPainted(false);

        ImageIcon icono = new ImageIcon(this.getClass().getResource("/src/imagenes/botones/boton_supervivencia.png"));        
        Image imagenEscalada=icono.getImage();
        imagenEscalada= imagenEscalada.getScaledInstance(botonModoSupervivencia.getWidth(), botonModoSupervivencia.getHeight(),  java.awt.Image.SCALE_SMOOTH);
        Icon iconoImagenEscalado= new ImageIcon(imagenEscalada);
        botonModoSupervivencia.setIcon(iconoImagenEscalado);

        botonModoSupervivencia.addActionListener((ActionListener) new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controladorVistas.cambiarModoDeJuego(new Supervivencia());
                controladorVistas.mostrarPantallaMenu();
            }
        });

        add(botonModoSupervivencia);
    }
    protected void agregarBotonModoContrarreloj(){
        botonModoContrarreloj= new JButton();
        botonModoContrarreloj.setVisible(true);
        botonModoContrarreloj.setBounds((ConstantesVistas.PANEL_ANCHO/2)-315, ConstantesVistas.PANEL_ALTO - 200, 210, 85);
        botonModoContrarreloj.setOpaque(false);
        botonModoContrarreloj.setContentAreaFilled(false);
        botonModoContrarreloj.setBorderPainted(false);
        botonModoContrarreloj.setFocusPainted(false);

        ImageIcon icono = new ImageIcon(this.getClass().getResource("/src/imagenes/botones/boton_contrarreloj.png"));        
        Image imagenEscalada=icono.getImage();
        imagenEscalada= imagenEscalada.getScaledInstance(botonModoContrarreloj.getWidth(), botonModoContrarreloj.getHeight(),  java.awt.Image.SCALE_SMOOTH);
        Icon iconoImagenEscalado= new ImageIcon(imagenEscalada);
        botonModoContrarreloj.setIcon(iconoImagenEscalado);

        botonModoContrarreloj.addActionListener((ActionListener) new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controladorVistas.cambiarModoDeJuego(new Contrarreloj());
                controladorVistas.mostrarPantallaMenu();
            }
        });

        add(botonModoContrarreloj);
    }


    public void addNotify() {
        gestorSonido.detenerMusica();
        gestorSonido.reproducirMusica("PANELES_MUSICA");
        super.addNotify();
        requestFocusInWindow();
    }

        
}

