package src.GUI.Observers;

import src.Juego.EntidadLogica;
import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ObserverGrafico extends JLabel implements Observer{
    protected EntidadLogica entidadObservada;
    protected String rutaImagenActual;
    
    public ObserverGrafico(EntidadLogica observada){
        super();
        this.entidadObservada = observada;
    }
    
    public void update(){
        actualizarImagen();
        actualizarPosicionTamaño();
    }

    protected void actualizarImagen(){
       
        try {
            if (entidadObservada.getSprites() == null) {
                setIcon(new ImageIcon());
                return;
            }
            String rutaImagen = entidadObservada.getSprites().getRutaImagenActual();
            if (rutaImagen == null || rutaImagen.isEmpty()) {
                setIcon(new ImageIcon());
                return;
            }
            if (!rutaImagen.startsWith("/")) {
                rutaImagen = "/" + rutaImagen;
            }
            URL url = getClass().getResource(rutaImagen);
            if (url == null) {
                setIcon(new ImageIcon());
                return;
            }
            if(!rutaImagen.endsWith(".gif")){
                if(!rutaImagen.equals(rutaImagenActual)){
                    ImageIcon raw = new ImageIcon(url);
                    Image img = raw.getImage();
                    java.awt.Rectangle bounds = entidadObservada.getBounds();
                    int w = bounds.width > 0 ? bounds.width : raw.getIconWidth();
                    int h = bounds.height > 0 ? bounds.height : raw.getIconHeight();
                    Image scaled = img.getScaledInstance(w, h, Image.SCALE_FAST);
                    setIcon(new ImageIcon(scaled));
                }
            }else{
                ImageIcon icono = new ImageIcon(url);
                setIcon(icono);
            }
            
        } catch (Exception ex) {
            setIcon(new ImageIcon());
        }
    }

    protected void actualizarPosicionTamaño(){
        setBounds(entidadObservada.getBounds());
    }    

    public void eliminarEntidad(EntidadLogica e){
        java.awt.Container parent = ObserverGrafico.this.getParent();
        parent.remove(ObserverGrafico.this);
        parent.revalidate();
        parent.repaint();

    }

    public void hacerInvisible(){
      setVisible(false);
    }

    public void hacerVisible(){
        setVisible(true);
    }
}
