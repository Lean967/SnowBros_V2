package src.Niveles;

import src.Enemigo.JefeDeNivel;
import src.Juego.Posicion;

public class NivelContrarreloj extends Nivel{
    protected JefeDeNivel jefe;
    private static final int DURACION_CONTRARRELOJ = 20;

    public NivelContrarreloj(){
        super();
    }

    public void iniciarNivel() {
        if (juego != null) {
            getJuego().getModoDeJuego().setTiempoContrarreloj(DURACION_CONTRARRELOJ); 
        }
    }


    public void setMoguera(int x, int y) {
        jefe = fabricaEntidades.getMoguera(new Posicion(x, y));
    }


    public void setKamakichi(int x, int y) {
        jefe = fabricaEntidades.getKamakichi(new Posicion(x, y));
    }

    public void setFrecuenciaEnemigos(int frecuencia) {
    }

    public void setFrecuenciaPowers(int frecuencia) {
    }
}
