package src.CapaDatos;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class GestorSonido {
    private static GestorSonido instanciaSonido;
    private boolean isMute;
    private final Map<String, Clip> sonidos = new HashMap<>();
    private Clip musicaActual;
    private static final String RUTA_ARCHIVO = "src/CapaDatos/MusicaNiveles.txt";

    // Constructor privado para evitar la instanciación externa.
    private GestorSonido() {
        // Inicialización de recursos (p. ej., cargar archivos de sonido, configurar volumen)
        cargarArchivo();
        this.isMute = false;
    }

    // 3. Método estático y público para obtener la instancia.
    // Usamos 'synchronized' para seguridad en entornos multihilo,
    // asegurando que la instancia solo se crea una vez.

      /** Devuelve instancia única (thread-safe). */
    public static GestorSonido getInstancia() {
        if (instanciaSonido == null) {
            synchronized (GestorSonido.class) {
                if (instanciaSonido == null) {
                    instanciaSonido = new GestorSonido();
                }
            }
        }
        return instanciaSonido;
    }

    //Funcionalida del Gestor

     // Reproduce efecto corto (una vez). 
    public void reproducirSonido(String archivoSonido) {
        Clip clip = sonidos.get(archivoSonido);
        if (clip != null) {
            clip.setFramePosition(0);
            clip.start();
        }
    }

    public void invertirMute() {
        this.isMute = !this.isMute;
    }
    
    public boolean isMute() {
        return isMute;
    }


    // Carga sonidos desde MusicaNiveles.txt 
    public void cargarArchivo() {
        try (java.io.BufferedReader br = new java.io.BufferedReader(new java.io.FileReader(RUTA_ARCHIVO))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.startsWith("#") || linea.trim().isEmpty()) continue;
                String[] partes = linea.split("=");
                if (partes.length == 2) {
                    String ruta = partes[0].trim();
                    String nombre = partes[1].trim();
                    sonidos.put(nombre, cargarClip(ruta));
                }
            }
        } catch (IOException e) {
        }
    }

    /** Carga un clip de audio desde ruta. */
    private Clip cargarClip(String ruta) {
        try {
            AudioInputStream audio = AudioSystem.getAudioInputStream(new BufferedInputStream(new FileInputStream(ruta)));
            Clip clip = AudioSystem.getClip();
            clip.open(audio);
            return clip;
        } catch (Exception e) {
            System.err.println("No se pudo cargar: " + ruta);
            return null;
        }
    }


    /** Reproduce música en bucle infinito. */
    public void reproducirMusica(String nombre) {
        detenerMusica();
        musicaActual = sonidos.get(nombre);
        if (musicaActual != null) {
            musicaActual.setFramePosition(0);
            musicaActual.loop(Clip.LOOP_CONTINUOUSLY);
        }
    }

    /** Detiene música actual. */
    public void detenerMusica() {
        if (musicaActual != null && musicaActual.isRunning()) {
            musicaActual.stop();
            musicaActual.close();
            musicaActual = null;
        }
    }

    /** Detiene efecto específico. */
    public void detenerSonido(String nombre) {
        Clip clip = sonidos.get(nombre);
        if (clip != null && clip.isRunning()) {
            clip.stop();
        }
    }

    /** Establece volumen (0.0f = silencio, 1.0f = máximo). */
    public void establecerVolumen(String nombre, double volumen) {
        Clip clip = sonidos.get(nombre);
        if (clip != null && clip.isControlSupported(FloatControl.Type.MASTER_GAIN)) {
            FloatControl gain = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            float dB = (float) (Math.log10(volumen) * 20);
            gain.setValue(Math.max(gain.getMinimum(), Math.min(gain.getMaximum(), dB)));
        }
    }

    /** Establece volumen global (afecta todos los clips). */
    public void establecerVolumenGlobal(float volumen) {
        for (Clip clip : sonidos.values()) {
            if (clip != null && clip.isControlSupported(FloatControl.Type.MASTER_GAIN)) {
                FloatControl gain = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
                float dB = (float) (Math.log10(volumen) * 20);
                gain.setValue(Math.max(gain.getMinimum(), Math.min(gain.getMaximum(), dB)));
            }
        }
    }
}
