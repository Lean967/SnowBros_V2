package src.GUI.Observers;

import java.net.URL;

import javax.swing.ImageIcon;

import src.GUI.PanelPartida;
import src.Jugador.SnowBro;

public class ObserverJugador extends ObserverGrafico{
    private PanelPartida panelPartida;
    private SnowBro snowBroObservado;

    public ObserverJugador(PanelPartida panelPartida, SnowBro jugadorObservado){
        super(jugadorObservado);
        this.panelPartida = panelPartida;
        this.snowBroObservado = jugadorObservado;
        setOpaque(false);
        update();
    }

    public void update(){
        setBounds(snowBroObservado.getBounds());
        actualizarImagen();

        panelPartida.actualizarIndicadorVidas(snowBroObservado.getVidas());
        this.panelPartida.actualizarIndicadorPuntaje(snowBroObservado.getPuntaje());
        panelPartida.actualizarIndicadorNivel(snowBroObservado.getNivelActual().getJuego().getAdministradorNivel().getIndiceNivelActual() - 1);

        revalidate();
        repaint();
    }
    
    protected void actualizarImagen(){
        String rutaImagen = entidadObservada.getSprites().getRutaImagenActual();
        if (!rutaImagen.startsWith("/")) {
          rutaImagen = "/" + rutaImagen;
        }
        URL url = getClass().getResource(rutaImagen);
        if (url != null) {
          setIcon(new ImageIcon(url));
        } else {
          setIcon(new ImageIcon());
        }
    }
}
