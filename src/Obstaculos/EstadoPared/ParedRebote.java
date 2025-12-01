package src.Obstaculos.EstadoPared;

import src.Enemigo.Enemigo;
import src.Obstaculos.Pared;

public class ParedRebote extends ParedNormal{
    
    public ParedRebote(Pared pared){
        super(pared);
    }

    public void hacerEfecto(Enemigo enemigo){
        enemigo.setPasoX(enemigo.getPasoX() * (-1));
    }

}
