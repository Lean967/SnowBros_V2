package src.Niveles;

import java.util.LinkedList;

import src.Enemigo.DemonioRojo;
import src.Enemigo.Enemigo;
import src.Enemigo.TrollAmarillo;
import src.Fabricas.FabricaEntidades;
import src.Juego.Entidad;
import src.Juego.Posicion;
import src.Municiones.Municion;
import src.Obstaculos.Obstaculo;
import src.Plataformas.Plataforma;

public class Oleada {
    protected LinkedList<Enemigo> enemigos;
    protected FabricaEntidades fabricaEntidades;

    public Oleada(FabricaEntidades fEntidades){
        fabricaEntidades = fEntidades;
        enemigos = new LinkedList<>();
    }


    public void añadirEnemigo(Enemigo nuevEnemigo){
        enemigos.addLast(nuevEnemigo);
    }

    public void setDemonioRojo(int x, int y){
         DemonioRojo demonioRojo = fabricaEntidades.getDemonioRojo(new Posicion(x, y));
         enemigos.addLast(demonioRojo);
    }

    public void setRanaDeFuego(int x, int y){
        RanaDeFuego ranaDeFuego = fabricaEntidades.getRanaDeFuego(new Posicion(x, y));
        enemigos.addLast(ranaDeFuego);
    }

    public void setTrollAmarillo(int x, int y){
        TrollAmarillo trollAmarillo = fabricaEntidades.getTrollAmarillo(new Posicion(x, y));
        enemigos.addLast(trollAmarillo);
    }


    public LinkedList<Enemigo> getEnemigos(){
        LinkedList<Enemigo> listaRetorno = new LinkedList<>();
        for(Enemigo enemigo : enemigos){
            listaRetorno.addLast(enemigo.clone());
        }

        return listaRetorno;
    }
}
