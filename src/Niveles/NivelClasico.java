package src.Niveles;

import src.CapaDatos.GestorSonido;

public class NivelClasico extends Nivel {
    protected static GestorSonido gestorSonido = GestorSonido.getInstancia();
    
    public NivelClasico (){
        super();
    }

    public void iniciarNivel(){
        super.iniciarNivel();
        gestorSonido.detenerMusica();
        gestorSonido.reproducirSonido("APARECE_SNOW");
        gestorSonido.reproducirMusica("CLASICO_NIVEL_MUSICA");
    }
    /*
    public void setMoghera(int x, int y) {
        jefeDeNivel = fabricaEntidades.getMoghera(new Posicion(x, y));
        jefeDeNivel.setNivelActual(this);
        listaEntidades.add(jefeDeNivel);
        enemigos.add(jefeDeNivel);
    }
    public void setKamakichi(int x, int y) {
        jefeDeNivel = fabricaEntidades.getKamakichi(new Posicion(x, y));
        jefeDeNivel.setNivelActual(this);
        listaEntidades.add(jefeDeNivel);
        enemigos.add(jefeDeNivel);
    }
        */

}
