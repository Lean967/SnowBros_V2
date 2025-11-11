package src.CapaDatos;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GestorRanking {

    private static final String NOMBRE_ARCHIVO = "ranking.txt"; //revisar
    private static final int MAX_PUNTAJES = 5;

    private List<Puntaje> ranking;

    public GestorRanking() {
        this.ranking = new ArrayList<>();
        cargarRanking();
    }
    
    private void cargarRanking() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(NOMBRE_ARCHIVO))) {
            this.ranking = (List<Puntaje>) ois.readObject(); 
            Collections.sort(this.ranking); 
        } catch (FileNotFoundException e) {
            System.out.println("Archivo de ranking no encontrado. Se crea una lista vacía.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al cargar el ranking: " + e.getMessage());
            e.printStackTrace();
        }
    }
    public void guardarRanking() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(NOMBRE_ARCHIVO))) {
            oos.writeObject(this.ranking);
            System.out.println("Ranking guardado exitosamente.");
        } catch (IOException e) {
            System.err.println("Error al guardar el ranking: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void agregarPuntaje(String nombre, int puntos) {
        Puntaje nuevoPuntaje = new Puntaje(nombre, puntos);
        this.ranking.add(nuevoPuntaje);
        Collections.sort(this.ranking);
        if (this.ranking.size() > MAX_PUNTAJES) {
            this.ranking.remove(MAX_PUNTAJES); 
        }
        guardarRanking();
    }
    public List<Puntaje> getTopPuntajes(int cantidad) {
        int limite = Math.min(cantidad, this.ranking.size());
        return Collections.unmodifiableList(this.ranking.subList(0, limite));
    }
}
