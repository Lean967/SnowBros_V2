package src.Niveles.Modos;
import src.Niveles.Nivel;
public abstract class ModoDeJuego {
    protected Nivel nivel;
    
    public abstract String getNombre();
    public void modificarContadorCiclos(){}
    public void setTiempoContrarreloj(int duracionContrarreloj) {}
    public void setNivel(Nivel n) { 
        nivel = n; 
    }
    public Nivel getNivel() { 
        return nivel; 
    }
}
