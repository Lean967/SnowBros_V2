package src.Enemigo;

import src.Enemigo.EstadosEnemigo.EnemigoNormal;
import src.Fabricas.*;
import src.Juego.Posicion;
import src.Visitor.Colisionador;

public class DemonioRojo extends Enemigo {

    public DemonioRojo(Sprites misSprites, Posicion pos){
        super(misSprites, pos);
        posInicial=pos.clonar();
        colisionador= new ColisionadorDemonioRojo(this);
        vida=250;
        puntosPorCongelarse = 150;
        puntosPorRodar=300;
    }
    
    public void aceptarColision(Colisionador c)  {
        c.colisionar(this);
    }
    
    protected DemonioRojo crearEnemigo(){
        DemonioRojo nuevo = new DemonioRojo(this.misSprites, this.posInicial.clonar()); 
        nuevo.setEstado(new EnemigoNormal(nuevo, nuevo.getSprites()));
        return nuevo;
    }
    public Colisionador getColisionador(){
        return colisionador;
    }

    public void disparar(String direccion) {
    }
    
}