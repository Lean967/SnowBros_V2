package src.Niveles;

import src.CapaDatos.GestorSonido;
import src.Juego.Posicion;

public class NivelContrarreloj extends Nivel{
    protected int tiempoLimite;
    protected static GestorSonido gestorSonido = GestorSonido.getInstancia();


    public NivelContrarreloj(){
        super();
        tiempoLimite = 0;
        
    }

    public void iniciarNivel() {
        super.iniciarNivel();
        if (juego != null) {
            getJuego().getModoDeJuego().setTiempoContrarreloj(tiempoLimite); 
        }
        gestorSonido.detenerMusica();
        gestorSonido.reproducirSonido("APARECE_SNOW");
        gestorSonido.reproducirMusica("CONTRARRELOJ_NIVEL_MUSICA");
    }

    public void setTiempoLimite(int tiempoLimite){
        this.tiempoLimite = tiempoLimite;
    }
    public int getTiempoLimite(){
        return tiempoLimite;
    }
}
