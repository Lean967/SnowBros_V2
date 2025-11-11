package src.Niveles;

import src.CapaDatos.GestorSonido;
import src.Enemigo.JefeDeNivel;
import src.Juego.Posicion;

public class NivelClasico extends Nivel {
    protected JefeDeNivel jefe;
    protected static GestorSonido gestorSonido = GestorSonido.getInstancia();
    
    public NivelClasico (){
        super();
    }

    public void iniciarNivel(){
        gestorSonido.reproducirMusica("CLASICO_NIVEL_1_MUSICA");
    }

    public void setMoguera(int x, int y) {
        jefe = fabricaEntidades.getMoguera(new Posicion(x, y));
    }


    public void setKamakichi(int x, int y) {
        jefe = fabricaEntidades.getKamakichi(new Posicion(x, y));
    }

}
