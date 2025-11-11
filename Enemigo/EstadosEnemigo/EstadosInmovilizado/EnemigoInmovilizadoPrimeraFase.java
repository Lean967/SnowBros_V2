package src.Enemigo.EstadosEnemigo.EstadosInmovilizado;

import src.CapaDatos.ConstantesTeclado;
import src.Enemigo.Enemigo;
import src.Fabricas.Sprites;


public class EnemigoInmovilizadoPrimeraFase extends EnemigoInmovilizado{

    public EnemigoInmovilizadoPrimeraFase(Enemigo e, Sprites misSprites) {
        super(e, misSprites);
        misSprites.setEstadoActual(ConstantesTeclado.Congelado1);
        enemigo.setCongelamiento(60);
    }

    public void hacerBucle(){
        enemigo.descongelar();
    }

   
}
