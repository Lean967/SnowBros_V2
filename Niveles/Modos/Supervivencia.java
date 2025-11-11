package src.Niveles.Modos;
import src.Niveles.Nivel;
import src.Niveles.NivelSupervivencia;

public class Supervivencia extends ModoDeJuego{
    
    public Supervivencia() {
     
    }

    public String getNombre(){
        return "SUPERVIVENCIA";

    }
     public Nivel getNivel(){
        return new NivelSupervivencia();
    }
}
