package src.CapaDatos;
import java.io.Serializable;

public class Puntaje implements Comparable<Puntaje>, Serializable {
    private static final long serialVersionUID = 1L; 

    private String nombreJugador;
    private int puntos;

    public Puntaje(String nombreJugador, int puntos) {
        this.nombreJugador = nombreJugador;
        this.puntos = puntos;
    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    public int getPuntos() {
        return puntos;
    }

    public int compareTo(Puntaje otro) {
        return otro.puntos - this.puntos;
    }
    public String toString() {
        return nombreJugador + ": " + puntos;
    }
}
