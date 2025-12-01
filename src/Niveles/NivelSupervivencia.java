package src.Niveles;

import src.CapaDatos.GestorSonido;
import src.Enemigo.Enemigo;

public class NivelSupervivencia extends Nivel {
    protected int puntajeObjetivo;
    protected GestorSonido gestorSonido = GestorSonido.getInstancia();


    public NivelSupervivencia(){
        super();
    }

    public void iniciarNivel() {
        siguienteOleada();
        modoDeJuego.setEnemigosRestantes(enemigos.size());
        gestorSonido.detenerMusica();
        gestorSonido.reproducirSonido("APARECE_SNOW");
        gestorSonido.reproducirMusica("SUPERVIVENCIA_NIVEL_MUSICA");
    }

    public void siguienteOleada(){
        if(oleadaActual < oleadas.size()-1){
            oleadaActual++;
            Oleada siguienteOleada = oleadas.get(oleadaActual);
            for(Enemigo enemigo : siguienteOleada.getEnemigos()){
                enemigos.add(enemigo);
                enemigo.setNivelActual(this);
                juego.registrarObserverNuevaEntidad(enemigo);
            }
            modoDeJuego.setEnemigosRestantes(enemigos.size());
        }
        else if(enemigos.isEmpty()){
            ganarNivel();
        }
    }

    public void setPuntajeObjetivo(int puntajeObjetivo){
        this.puntajeObjetivo = puntajeObjetivo;
    }

    public void hacerBucle(){
        
    }

    public int getPuntajeObjetivo(){
        return puntajeObjetivo;
    }

}
