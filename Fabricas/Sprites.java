package src.Fabricas;

import java.awt.Image;
import java.util.Map;
import javax.swing.ImageIcon;

public class Sprites {
    protected Map<Integer, String> estadoImagen;
    protected int estadoActual;

    public Sprites(Map<Integer, String> mapeoEstadoImagen, int estadoInicial){
        this.estadoImagen = mapeoEstadoImagen;
        this.estadoActual = estadoInicial;
    }

    public void setEstadoActual(int estado){
        this.estadoActual = estado;
    }

    public int getEstadoActual(){
        return estadoActual;
    }

    public String getRutaImagenActual(){
        return estadoImagen.get(estadoActual);
    }
    public Image getImagenActual() {
        String ruta = getRutaImagenActual();
        if (ruta == null) return null;
        return new ImageIcon(ruta).getImage();
    }
    public int getWidth() {
        Image img = getImagenActual();
        return img != null ? img.getWidth(null) : 0;
    }
    public int getHeight() {
        Image img = getImagenActual();
        return img != null ? img.getHeight(null) : 0;
    }
}
