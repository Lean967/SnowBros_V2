package src.Niveles.Modos;
import src.Niveles.Nivel;
import src.Niveles.NivelClasico;

public class Clasico extends ModoDeJuego {

    public Clasico() {
    }

    public String getNombre(){
        return "CLASICO";
    }

    public Nivel getNivel(){
        return new NivelClasico();
    }
}
