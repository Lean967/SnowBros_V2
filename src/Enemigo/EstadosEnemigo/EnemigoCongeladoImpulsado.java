package src.Enemigo.EstadosEnemigo;

import src.CapaDatos.ConstantesTeclado;
import src.CapaDatos.GestorSonido;
import src.Enemigo.Enemigo;
import src.Enemigo.Kamakichi;
import src.Enemigo.Moghera;
import src.Fabricas.Sprites;
import src.Jugador.SnowBro;
import src.Jugador.EstadosLogicos.EstadoLogicoSnowBroMontado;
import src.Jugador.EstadosLogicos.EstadoLogicoSnowBroNormal;
import src.Municiones.BolaDeNieve;
import src.Obstaculos.Pared;
import src.Obstaculos.ParedDestructible;

public class EnemigoCongeladoImpulsado extends EstadoEnemigo{
    protected SnowBro snowBro;
    protected boolean rebotoContraPared;

    public EnemigoCongeladoImpulsado(Enemigo enemigo, Sprites misSprites, int pasoX, SnowBro snowBro){
        super(enemigo, misSprites);
        misSprites.setEstadoActual(ConstantesTeclado.RODANDO);
        enemigo.setPasoX(pasoX);
        this.snowBro = snowBro;
        rebotoContraPared=false;
    }
    public void hacerBucle() {
        enemigo.mover();
    }

    public void buscarSnowBro(SnowBro snowBro) {
        
    }


    public void hacerEfecto(SnowBro snowBro) {
        if(rebotoContraPared){
            misSprites.setEstadoActual(ConstantesTeclado.RODANDO_CON_SNOW);
            snowBro.hacerInvisible();
            snowBro.setEstadoLogico(new EstadoLogicoSnowBroMontado(snowBro, enemigo));
        }
        
    }

    public void hacerEfecto(Pared pared){
       pared.hacerEfecto(enemigo);
       rebotoContraPared=true;
    }

    public void hacerEfecto(Enemigo enemigo) {
        if(this.enemigo.getPasoX() != 0){
            enemigo.morir();
        }
    }
    public void hacerEfecto(Kamakichi kamakichi){
        if(this.enemigo.getPasoX() != 0){
            kamakichi.recibirImpactoDeBolaDeNieve(100);
        }
    }
    public void hacerEfecto(Moghera moghera){
        if(this.enemigo.getPasoX() != 0){
            moghera.recibirImpactoDeBolaDeNieve(100);
        }
    }

    public void hacerEfecto(BolaDeNieve bolaDeNieve) {
        
    }
    public void hacerEfecto(ParedDestructible paredDestructible){
        paredDestructible.setEstadoPared(true);
        enemigo.getNivelActual().getSnowBro().setPuntaje(enemigo.getNivelActual().getSnowBro().getPuntaje() + paredDestructible.getPuntaje());
        paredDestructible.eliminar();
    }

    public void moverEnX(){
        if(((enemigo.getPosicion().getX() + enemigo.getPasoX() >= 760 ) || 
            (enemigo.getPosicion().getX() + enemigo.getPasoX() <= -10)) && enemigo.getPosicion().getY() <= 500){

            enemigo.eliminar();
            snowBro.setEstadoLogico(new EstadoLogicoSnowBroNormal(snowBro));
        }else{
            enemigo.getPosicion().setX(enemigo.getPosicion().getX() + enemigo.getPasoX());
        }
    }

    public void eliminarEnemigoPorPared(){
        GestorSonido.getInstancia().reproducirSonido("MUERTE_ENEMIGOCONGELADO");
        enemigo.eliminar();
        snowBro.setEstadoLogico(new EstadoLogicoSnowBroNormal(snowBro));
        snowBro.hacerVisible();
    }
}
