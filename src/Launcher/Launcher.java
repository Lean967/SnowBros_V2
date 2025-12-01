package src.Launcher;

import src.GUI.GUI;
import src.GUI.InterfacesGUI.ControladorGrafica;
import src.Juego.Juego;
import java.awt.EventQueue;

public class Launcher {

    public static void main(String[ ]args){
    EventQueue.invokeLater(new Runnable() {
            public void run() {
                try{
                    ControladorGrafica controladorGrafica = new GUI();
                    Juego juego = new Juego(controladorGrafica);
                    controladorGrafica.registrarControladorDeJuego(juego);
                    juego.configurar();

                }catch (Exception e) {
					e.printStackTrace();
				}

                
            }
        });
    }
    
}
