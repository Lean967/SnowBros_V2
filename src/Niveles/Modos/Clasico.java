package src.Niveles.Modos;
import src.CapaDatos.ConstantesTeclado;
import src.CapaDatos.GestorSonido;
import src.Niveles.Nivel;
import src.Niveles.NivelClasico;

public class Clasico extends ModoDeJuego {
    protected int TIEMPO_ESPERA_GANAR=ConstantesTeclado.TIEMPO_ESPERA_GANAR;
    private boolean primeraVez = true;
    protected boolean jefeEnCombate=false;


    protected static GestorSonido gestorSonido = GestorSonido.getInstancia();


    public Clasico() {
        jefeEnCombate = false;
    }

    public String getNombre(){
        return "CLASICO";
    }

    public Nivel getNivel(){
        return new NivelClasico();
    }

    public void hacerBucle(){
        if(cantidadEnemigos == 0 && nivel.getSnowBro().getVidas() > 0){
            if(TIEMPO_ESPERA_GANAR>0){
                TIEMPO_ESPERA_GANAR--;
            }else{
                if(!jefeEnCombate){
                    nivel.getJuego().nivelParaJefe();
                    jefeEnCombate = true;
                }else if(nivel.getJefeDeNivel()==null&&nivel.getSnowBro().getVidas() > 0){
                        if(primeraVez) {
                            gestorSonido.detenerMusica();
                            primeraVez=false;
                            gestorSonido.reproducirMusica("JUEGO_GANADO");
                        }
                        if(TIEMPO_ESPERA_GANAR>0){
                            TIEMPO_ESPERA_GANAR--;
                        }else{
                            gestorSonido.detenerMusica();
                            TIEMPO_ESPERA_GANAR=ConstantesTeclado.TIEMPO_ESPERA_GANAR;
                            primeraVez=true;
                            jefeEnCombate=false;
                            nivel.ganarNivel();
                        }
                    }
            }
        }

    }
}
