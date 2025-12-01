package src.GUI.Observers;

import java.net.URL;

import javax.swing.ImageIcon;

import src.GUI.PanelPartida;
import src.Jugador.SnowBro;

public class ObserverJugador extends ObserverPersonaje{
    private PanelPartida panelPartida;
    private SnowBro snowBroObservado;

    public ObserverJugador(PanelPartida panelPartida, SnowBro jugadorObservado){
      super(jugadorObservado);
      this.panelPartida = panelPartida;
      this.snowBroObservado = jugadorObservado;
      update();
    }

    public void update(){
        panelPartida.actualizarIndicadorVidas(snowBroObservado.getVidas());
        this.panelPartida.actualizarIndicadorPuntaje(snowBroObservado.getPuntaje());
        panelPartida.actualizarIndicadorNivel(snowBroObservado.getNivelActual().getJuego().getAdministradorNivel().getIndiceNivelActual() - 1);

        super.update();
    }
}
