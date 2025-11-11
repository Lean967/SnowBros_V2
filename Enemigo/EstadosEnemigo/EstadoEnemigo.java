package src.Enemigo.EstadosEnemigo;

import src.CapaDatos.ConstantesTeclado;
import src.Enemigo.Enemigo;
import src.Fabricas.Sprites;
import src.Jugador.SnowBro;
import src.Municiones.BolaDeNieve;
import src.Obstaculos.Pared;
import src.Obstaculos.ParedDestructible;

public abstract class EstadoEnemigo{
    protected Enemigo enemigo;
    public Sprites misSprites;
    protected boolean puedeMoverse;
    protected int tiempoDescongelamiento;

    public EstadoEnemigo(Enemigo e, Sprites misSprites){
        this.enemigo = e;
        this.misSprites = misSprites;
        tiempoDescongelamiento=0;

    }

    public void mover(){
        moverEnX();
        moverEnY();
        enemigo.actualizarSprite();
        enemigo.update();
    }

    public Sprites getSprites(){
        return misSprites;
    }

    public void actualizarSprite(){
        
    }


    public void moverEnY(){
        if(enemigo.getCayendo()){
            if(enemigo.getPosicion().getY() + enemigo.getPasoY() > 520)
                enemigo.getPosicion().setY(520);
            else{
                if((enemigo.getPasoY() + ConstantesTeclado.Gravedad) <= ConstantesTeclado.MaxVelocidadCaida){
                    enemigo.setPasoY(enemigo.getPasoY() + ConstantesTeclado.Gravedad);
                }
                enemigo.getPosicion().setY(enemigo.getPosicion().getY() + enemigo.getPasoY());
                //this.misSprites.setEstadoActual(ConstantesTeclado.Saltando);
            }
        }
    }

    public void moverEnX(){
        if((enemigo.getPosicion().getX() + enemigo.getPasoX() >= 760 ) || 
            (enemigo.getPosicion().getX() + enemigo.getPasoX() <= -10)){

            enemigo.setPasoX(enemigo.getPasoX() * -1);
        }else{
            enemigo.getPosicion().setX(enemigo.getPosicion().getX() + enemigo.getPasoX());
        }
    }

    public void setPuedeMoverse(boolean seMueve){
        this.puedeMoverse = seMueve;
    }

    public boolean puedeMoverse(){
        return puedeMoverse;
    }

    public abstract void hacerBucle();

    public abstract void buscarSnowBro(SnowBro snowBro);

    public abstract void hacerEfecto(SnowBro snowBro);
    public abstract void hacerEfecto(Enemigo enemigo);
    public abstract void hacerEfecto(BolaDeNieve bolaDeNieve);
    public abstract void hacerEfecto(Pared pared);
    public abstract void hacerEfecto(ParedDestructible paredDestructible);
}