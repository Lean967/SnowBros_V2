package src.Enemigo.EstadosEnemigo.EstadosInmovilizado;

import src.CapaDatos.ConstantesTeclado;
import src.Enemigo.Enemigo;
import src.Fabricas.Sprites;

public class EnemigoInmovilizadoSegundaFase extends EnemigoInmovilizado {
    public EnemigoInmovilizadoSegundaFase(Enemigo e, Sprites misSprites) {
        super(e, misSprites);
        misSprites.setEstadoActual(ConstantesTeclado.Congelado2);
        enemigo.setCongelamiento(120);
    }

    public void hacerBucle(){
        enemigo.descongelar();
    }
}
