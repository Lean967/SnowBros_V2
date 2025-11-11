package src.Jugador;

import src.Niveles.Nivel;

public class Jugador {
    protected String nombre;
    protected SnowBro snowBro;
    protected Nivel nivelActual;

    public Jugador(String nombre) {
        this.nombre = nombre;
    }

    protected void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setSnowBro(SnowBro snowBro) {
        this.snowBro = snowBro;
    }

    public SnowBro getSnowBro() {
        return this.snowBro;
    }

    public void setNivelActual(Nivel nivel){
        this.nivelActual=nivel;
    }
    
    public Nivel getNivelActual(){
        return this.nivelActual;
    }


}
