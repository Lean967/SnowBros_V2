package src.Juego;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import src.CapaDatos.Puntaje;


public class Ranking implements Serializable{
    private static final int MAX_PUNTAJES = 5;
    private List<Puntaje> ranking;

    public Ranking() {
        this.ranking = new ArrayList<>();
    }
 
    public void agregarPuntaje(String nombre, int puntos) {
        Puntaje nuevoPuntaje = new Puntaje(nombre, puntos);
        this.ranking.add(nuevoPuntaje);
        Collections.sort(this.ranking);
        if (this.ranking.size() > MAX_PUNTAJES) {
            this.ranking.remove(MAX_PUNTAJES); 
        }
    }

    public List<Puntaje> getTopPuntajes(int cantidad) {
        int limite = Math.min(cantidad, this.ranking.size());
        return Collections.unmodifiableList(this.ranking.subList(0, limite));
    }
}

