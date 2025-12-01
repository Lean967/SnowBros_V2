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

    public void detener(){}

    public void actualizarSprite(){
        
    }


    public void moverEnY(){
        if(enemigo.getCayendo()){
            if(enemigo.getPosicion().getY() + enemigo.getPasoY() > 520)
                enemigo.getPosicion().setY(520);
            else{
                if((enemigo.getPasoY() + ConstantesTeclado.GRAVEDAD) <= ConstantesTeclado.MAX_VELOCIDAD_CAIDA){
                    enemigo.setPasoY(enemigo.getPasoY() + ConstantesTeclado.GRAVEDAD);
                }
                enemigo.getPosicion().setY(enemigo.getPosicion().getY() + enemigo.getPasoY());
            }
        }
        enemigo.setCayendo(true);
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

    public void eliminarEnemigoPorPared(){
        enemigo.setPasoX(enemigo.getPasoX() * (-1));
    }

    public abstract void hacerBucle();

    public abstract void buscarSnowBro(SnowBro snowBro);

    public abstract void hacerEfecto(SnowBro snowBro);
    public abstract void hacerEfecto(Enemigo enemigo);
    public abstract void hacerEfecto(BolaDeNieve bolaDeNieve);
    public abstract void hacerEfecto(Pared pared);
    public abstract void hacerEfecto(ParedDestructible paredDestructible);

    public void disparar() {
        final int COOLDOWN = 125; 
        if (enemigo.getContadorCiclos() >= COOLDOWN) {
            SnowBro snowBro = enemigo.getNivelActual().getSnowBro();
            int xEnemigo = enemigo.getPosicion().getX();
            int yEnemigo = enemigo.getPosicion().getY();
            int xSnow = snowBro.getPosicion().getX();
            int ySnow = snowBro.getPosicion().getY();
            int toleranciaY = 20;

            // Verifica si están aprox en la misma altura
            if (Math.abs(yEnemigo - ySnow) <= toleranciaY) {
                String direccion = null;
                if (xSnow > xEnemigo) {
                    direccion = "derecha";
                } else if (xSnow < xEnemigo) {
                    direccion = "izquierda";
                }
                if (direccion != null) {
                    enemigo.disparar(direccion);
                    enemigo.resetearContadorCiclos();
                }
            }
        }
    }
}