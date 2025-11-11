package src.Niveles;

public class NivelSupervivencia extends Nivel {
    protected int puntajeObjetivo;

    public NivelSupervivencia(){
        super();
    }

    public void iniciarNivel() {
        siguienteOleada();
    }

    public void setPuntajeObjetivo(int puntajeObjetivo){
        this.puntajeObjetivo = puntajeObjetivo;
    }

}
