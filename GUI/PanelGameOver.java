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
    

    public PanelGameOver(ControladorVistas controladorVistas) {
        super(controladorVistas);
        setSize(ConstantesVistas.PANEL_ANCHO, ConstantesVistas.PANEL_ALTO);
        setLayout(null);
        agregarImagenFondo();
        agregarBotonIniciarPartida();
        //Forzamos el botón a estar en la capa superior 
        setComponentZOrder(botonTryAgain, 0);
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

    protected void agregarBotonIniciarPartida(){
        botonTryAgain = new JButton();
        botonTryAgain.setVisible(true);
        botonTryAgain.setBounds((ConstantesVistas.PANEL_ANCHO / 2) - 100 ,ConstantesVistas.PANEL_ALTO - 210, 230, 130);
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
                controladorVistas.mostrarPantallaMenu();
            }
        });

        add(botonTryAgain);
    }

}
