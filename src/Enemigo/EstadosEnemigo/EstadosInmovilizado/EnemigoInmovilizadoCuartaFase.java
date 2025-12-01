package src.Enemigo.EstadosEnemigo.EstadosInmovilizado;

import src.CapaDatos.ConstantesTeclado;
import src.Enemigo.Enemigo;
import src.Fabricas.Sprites;

public class EnemigoInmovilizadoCuartaFase extends EnemigoInmovilizado{

    public EnemigoInmovilizadoCuartaFase(Enemigo e, Sprites misSprites) {
        super(e, misSprites);
        misSprites.setEstadoActual(ConstantesTeclado.CONGELADO4);
        enemigo.setCongelamiento(240);
    }

    public void hacerBucle(){
        super.hacerBucle();
    }

    
}
