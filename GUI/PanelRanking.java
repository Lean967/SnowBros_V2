package src.GUI;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import src.CapaDatos.ConstantesVistas;
import src.CapaDatos.GestorRanking;
import src.CapaDatos.Puntaje; 
import src.GUI.InterfacesGUI.ControladorVistas;

public class PanelRanking extends PanelVista {

    private JLabel imagenRanking;
    private JButton botonVolver;
    private GestorRanking gestorRanking;
    private static final int cantMaxPuntaje=5;

    public PanelRanking(ControladorVistas controladorVistas, GestorRanking gestorRanking) {
        super(controladorVistas);
        this.gestorRanking = gestorRanking;
        setLayout(null);
        setSize(ConstantesVistas.PANEL_ANCHO, ConstantesVistas.PANEL_ALTO);
        agregarImagenFondo();
        agregarContenedorRanking();
        agregarBotonVolver();
        setComponentZOrder(imagenRanking, getComponentCount() - 1);
        setFocusable(true);
    }


    private void agregarImagenFondo() {
        imagenRanking= new JLabel();
        ImageIcon iconoImagen = new ImageIcon(this.getClass().getResource("/src/imagenes/Fondos/pantalla_ranking.png"));
        Image imagenEscalada = iconoImagen.getImage();
		imagenEscalada = imagenEscalada.getScaledInstance(ConstantesVistas.PANEL_ANCHO, ConstantesVistas.PANEL_ALTO,  java.awt.Image.SCALE_SMOOTH);
        Icon iconoImagenEscalado = new ImageIcon(imagenEscalada);
		imagenRanking.setIcon(iconoImagenEscalado);
		imagenRanking.setBounds(0,0, ConstantesVistas.PANEL_ANCHO, ConstantesVistas.PANEL_ALTO);
		add(imagenRanking);
    }
    
   

    private void agregarContenedorRanking() {

    List<Puntaje> listaPuntajes = obtenerDatosDeRanking(cantMaxPuntaje);
    String[] nombresColumnas = {"POS", "JUGADOR", "PUNTOS"};

    DefaultTableModel modeloTabla = new DefaultTableModel(nombresColumnas, 0);
    JTable tablaRanking = new JTable(modeloTabla);
    JScrollPane scrollPanelRanking = new JScrollPane(tablaRanking);

    if (!listaPuntajes.isEmpty()) {
        int posicion = 1;
        for (Puntaje puntaje : listaPuntajes) {
            // Objeto[] contiene los datos de una fila
            Object[] datosFila = {posicion+"°", puntaje.getNombreJugador(), puntaje.getPuntos()};
            modeloTabla.addRow(datosFila);
            posicion++;
        }
        //HARCODING
    } else {Object[] datosFila = {1+"°", "pou", 123};
            modeloTabla.addRow(datosFila);
        }
    /* } else {
        JLabel mensajeSinDatos = new JLabel("No hay puntajes registrados. ");
        mensajeSinDatos.setFont(new Font("SansSerif", Font.BOLD, 18));
        mensajeSinDatos.setForeground(Color.WHITE);
        mensajeSinDatos.setHorizontalAlignment(SwingConstants.CENTER);
        
        scrollPanelRanking.setViewportView(mensajeSinDatos);
        
        // Es importante hacer el JScrollPane opaco si el JLabel va a ser el único contenido
        // para que el fondo del mensaje se vea limpio si es necesario.
        scrollPanelRanking.getViewport().setOpaque(true);
        scrollPanelRanking.getViewport().setBackground(new Color (0, 0, 0, 0)); 
    }*/

    
    // Estilos y Formatos
    
    // Fuente y tamaño general de la tabla
    tablaRanking.setFont(new Font("SansSerif", Font.BOLD, 16));
    tablaRanking.setBackground(new Color(0, 0, 0, 0)); // Transparente
    tablaRanking.setForeground(Color.WHITE);
    tablaRanking.setRowHeight(25); // Altura de las filas

    // Estilo del Encabezado
    tablaRanking.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 18));
    tablaRanking.getTableHeader().setBackground(new Color(50, 50, 50));
    tablaRanking.getTableHeader().setForeground(Color.YELLOW);
    
    // Centrar POS y PUNTOS
    DefaultTableCellRenderer rendererCentrado = new DefaultTableCellRenderer();
    rendererCentrado.setHorizontalAlignment(SwingConstants.CENTER);
    
    // Columna 0 (POS) y Columna 2 (PUNTOS)
    tablaRanking.getColumnModel().getColumn(0).setCellRenderer(rendererCentrado);
    tablaRanking.getColumnModel().getColumn(1).setCellRenderer(rendererCentrado);
    tablaRanking.getColumnModel().getColumn(2).setCellRenderer(rendererCentrado);

    // Establecer anchos de columna preferidos
    tablaRanking.getColumnModel().getColumn(0).setPreferredWidth(50);  // POS
    tablaRanking.getColumnModel().getColumn(1).setPreferredWidth(200); // JUGADOR
    tablaRanking.getColumnModel().getColumn(2).setPreferredWidth(100); // PUNTOS

    
    // Usamos las constantes y la posición original (ajustada para el JTable)
    final int POS_X = (ConstantesVistas.PANEL_ANCHO / 2) - 200;
    final int POS_Y = 180;
    final int ANCHO = 400;
    final int ALTO = 300;
    
    scrollPanelRanking.setBounds(POS_X, POS_Y, ANCHO, ALTO);
    
    // Configuración para que el fondo sea transparente, manteniendo el JTable visible
    scrollPanelRanking.setOpaque(false);
    scrollPanelRanking.getViewport().setOpaque(false);

    // Borde y Título
    scrollPanelRanking.setBorder(BorderFactory.createTitledBorder(
        BorderFactory.createLineBorder(Color.WHITE, 4), 
        "TOP " + cantMaxPuntaje + " MEJORES PUNTAJES", 
        TitledBorder.CENTER, // Centrado
        TitledBorder.TOP,    // Arriba
        new Font("SansSerif", Font.BOLD, 20), 
        Color.YELLOW));
    
      add(scrollPanelRanking);
    }

    private List<Puntaje> obtenerDatosDeRanking(int cantidadMaximaPuntajes) {
       return gestorRanking.getTopPuntajes(cantidadMaximaPuntajes);
    }

    protected void agregarBotonVolver(){
        botonVolver = new JButton();
        botonVolver.setVisible(true);
        botonVolver.setBounds((ConstantesVistas.PANEL_ANCHO / 2) - 98 ,ConstantesVistas.PANEL_ALTO - 110, 180 , 40);
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
    }

   
}