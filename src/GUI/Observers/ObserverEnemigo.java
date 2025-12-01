package src.GUI.Observers;

import java.net.URL;

import javax.swing.ImageIcon;

import src.Juego.EntidadLogica;

public class ObserverEnemigo extends ObserverGrafico {


    public ObserverEnemigo(EntidadLogica enemigoObservado) {
        super(enemigoObservado);
        this.entidadObservada = enemigoObservado;
        setOpaque(false);
        update();
    }

    public void update() {
        setBounds(entidadObservada.getBounds());
        actualizarImagen();

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
