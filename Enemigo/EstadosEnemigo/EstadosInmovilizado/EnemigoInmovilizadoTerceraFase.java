package src.Enemigo.EstadosEnemigo.EstadosInmovilizado;

import src.CapaDatos.ConstantesTeclado;
import src.Enemigo.Enemigo;
import src.Fabricas.Sprites;

public class EnemigoInmovilizadoTerceraFase extends EnemigoInmovilizado{

    public EnemigoInmovilizadoTerceraFase(Enemigo e, Sprites misSprites) {
        super(e, misSprites);
        misSprites.setEstadoActual(ConstantesTeclado.Congelado3);
        enemigo.setCongelamiento(180);
    }

    public void hacerBucle(){
        enemigo.descongelar();
    }

    

}
