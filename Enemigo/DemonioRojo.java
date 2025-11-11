package src.Enemigo;

import src.Enemigo.EstadosEnemigo.EnemigoNormal;
import src.Fabricas.*;
import src.Juego.Posicion;
import src.Visitor.Colisionador;

public class DemonioRojo extends Enemigo {
    protected static final int PUNTOS_POR_RODAR=300;
    protected static final int PUNTOS_POR_CONGELARSE=150;

    public DemonioRojo(Sprites misSprites, Posicion pos){
        super(misSprites, pos);
        posInicial=pos.clonar();
        colisionador= new ColisionadorDemonioRojo(this);
        vida=250;
    }
    
    public void aceptarColision(Colisionador c)  {
        c.colisionar(this);
    }
    
    protected DemonioRojo crearEnemigo(){
        DemonioRojo nuevo = new DemonioRojo(this.misSprites, this.posInicial.clonar()); 
        nuevo.setEstado(new EnemigoNormal(nuevo, nuevo.getSprites()));
        return nuevo;
    }
    
    public void aumentarPuntajePorEmpujar() {
        this.getNivelActual().getSnowBro().aumentarPuntaje(PUNTOS_POR_RODAR);
    }

    public void aumentarPuntajePorCongelamiento(){
        this.getNivelActual().getSnowBro().aumentarPuntaje(PUNTOS_POR_CONGELARSE);
    }
}