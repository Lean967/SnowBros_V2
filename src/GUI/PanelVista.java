package src.GUI;



import javax.swing.JPanel;

import src.GUI.InterfacesGUI.ControladorVistas;

public class PanelVista extends JPanel{
    protected ControladorVistas controladorVistas;

    protected PanelVista(ControladorVistas controladorVistas){
        this.controladorVistas = controladorVistas;
        //setPreferredSize(new Dimension(ConstantesVistas.PANEL_ANCHO, ConstantesVistas.PANEL_ALTO));

    }
}
