package src.Niveles.Modos;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import src.Niveles.Nivel;
import src.Niveles.NivelSupervivencia;

public class Supervivencia extends ModoDeJuego{
    protected int tiempoEspera;
    protected int tiempoAparicionJefe;
    private boolean jefeEnCombate;
    
    public Supervivencia() {
        tiempoAparicionJefe = ThreadLocalRandom.current().nextInt(600, 1200);
        tiempoEspera = 130;
        jefeEnCombate = false;
    }

    public String getNombre(){
        return "SUPERVIVENCIA";

    }
     public Nivel getNivel(){
        return new NivelSupervivencia();
    }


    public void hacerBucle() {
        if(tiempoAparicionJefe == 0 && !jefeEnCombate){
            nivel.getJuego().nivelParaJefe();
            jefeEnCombate = true;
        }else{
            tiempoAparicionJefe--;
        }
        if(cantidadEnemigos == 0){
            if(tiempoEspera>0){
                tiempoEspera--;
            }else{
                tiempoEspera = 180;
                nivel.siguienteOleada();
            }
        }
        if(nivel.getSnowBro().getPuntaje() >= nivel.getPuntajeObjetivo()){
            jefeEnCombate=false;
            nivel.ganarNivel();
        }
    }

    
}
