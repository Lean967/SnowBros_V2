package src.Enemigo.EstadosEnemigo.EstadosInmovilizado;

import src.CapaDatos.ConstantesTeclado;
import src.Enemigo.Enemigo;
import src.Fabricas.Sprites;

public class EnemigoInmovilizadoCuartaFase extends EnemigoInmovilizado{

    public EnemigoInmovilizadoCuartaFase(Enemigo e, Sprites misSprites) {
        super(e, misSprites);
        misSprites.setEstadoActual(ConstantesTeclado.Congelado4);
        enemigo.setCongelamiento(240);
        enemigo.aumentarPuntajePorCongelamiento();
    }

    public void hacerBucle(){
        enemigo.descongelar();
    }

    
}
