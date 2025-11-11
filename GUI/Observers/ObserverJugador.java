package src.GUI.Observers;

import java.awt.Dimension;
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
        //ajustarTamañoPorDefecto();
        update();
    }

    private void ajustarTamañoPorDefecto(){
        Dimension pref = getPreferredSize();
        if (pref == null || pref.width == 0 || pref.height == 0) {
            pref = new Dimension(48, 48); // ajustar según tamaño real del sprite
            setPreferredSize(pref);
        }
        setSize(pref);
    }

    public void update(){
        //super.update();
        //setLocation(snowBroObservado.getPosicion().getX(), snowBroObservado.getPosicion().getY());
        setBounds(snowBroObservado.getBounds());
        actualizarImagen();

        // refrescar el número de vidas al costado del icono
        panelPartida.actualizarIndicadorVidas(snowBroObservado.getVidas());
        this.panelPartida.actualizarIndicadorPuntaje(snowBroObservado.getPuntaje());

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
          setIcon(new ImageIcon()); // Icono vacío como fallback
        }
    }
}
