package src.Obstaculos.EstadoPared;

import src.Enemigo.Enemigo;
import src.Obstaculos.Pared;

public class ParedNormal {
    protected Pared pared;

    public ParedNormal(Pared pared){
        this.pared=pared;
    }

    public void hacerEfecto(Enemigo enemigo){
        enemigo.getEstado().eliminarEnemigoPorPared();
    }

}
