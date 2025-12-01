package src.Niveles;

import java.awt.Rectangle;
import java.util.LinkedList;

import src.Enemigo.Enemigo;
import src.Juego.ControladorColisiones;
import src.Juego.Entidad;
import src.Jugador.SnowBro;
import src.Municiones.Municion;
import src.Obstaculos.Obstaculo;
import src.Plataformas.Plataforma;
import src.Powers.PowerUp;

public class ControladorColisionesParaJefe extends ControladorColisiones {

    public ControladorColisionesParaJefe(Nivel nivel) {
        super(nivel);
    }
    public void detectarColisiones(){
        plataformas = new LinkedList<>();
        obstaculos = new LinkedList<>();
        powerUps = new LinkedList<>();
        enemigos = new LinkedList<>();
        municiones = new LinkedList<>();

        for(Plataforma  plataforma: nivel.getPlataformas()){
            plataformas.add(plataforma);
        }
        for(PowerUp powerUp : nivel.getPowers()){
            powerUps.add(powerUp);
        }
        for(Enemigo enemigo: nivel.getEnemigos()){
            enemigos.add(enemigo);
        }
        for(Municion municion: nivel.getMuniciones()){
            municiones.add(municion);
        }
        SnowBro snowBro = nivel.getSnowBro();

        //Colisiones SnowBro - Enemigos
        for(Enemigo enemigo : enemigos){
            if(estanColisionando(snowBro, enemigo)){
                enemigo.aceptarColision(snowBro.getColisionador());
            }
        }

        //Colisiones SnowBro - Proyectiles
       /*  for(Municion municion : municiones){
            if(estanColisionando(snowBro, municion)){
                snowBro.aceptarColision(municion.getColisionador());
            }
        }*/

        //Colisiones SnowBro - Pasivos
        for(Plataforma plataforma : plataformas){
            if(estanColisionando(snowBro, plataforma)){
                plataforma.aceptarColision(snowBro.getColisionador());
            }
        }
        
        for(Obstaculo obstaculo : obstaculos){
            if(estanColisionando(snowBro, obstaculo)){
                obstaculo.aceptarColision(snowBro.getColisionador());
            }
        }
        for(PowerUp powerUp : powerUps){
            if(estanColisionando(snowBro, powerUp)){
                powerUp.aceptarColision(snowBro.getColisionador());
            }
        }
        

        //colisiones Enemigos - Proyectiles
       for(Enemigo enemigo : enemigos){
            for(Municion municion : municiones){
                if(estanColisionando(enemigo, municion)){
                    enemigo.aceptarColision(municion.getColisionador());
                }
            }
        }

        //colisiones Enemigos - Plataformas
        for(Enemigo enemigo : enemigos){
            for(Plataforma plataforma : plataformas){
                if(estanColisionando(enemigo, plataforma)){
                    plataforma.aceptarColision(enemigo.getColisionador());
                }
            }
        }

        //colisiones Enemigos - Obstaculos
        for(Enemigo enemigo : enemigos){
            for(Obstaculo obstaculo : obstaculos){
                if(estanColisionando(enemigo, obstaculo)){
                    obstaculo.aceptarColision(enemigo.getColisionador());
                }
            }
        }

        //colisiones Enemigos - Enemigos
        for(Enemigo enemigo1 : enemigos){
            for(Enemigo enemigo2 : enemigos){
                if(enemigo1 != enemigo2 && estanColisionando(enemigo1, enemigo2)){
                    enemigo1.aceptarColision(enemigo2.getColisionador());
                }
            }
        }

        //colisiones Municiones - Plataformas
        for(Municion municion : municiones){
            for(Plataforma plataforma : plataformas){
                if(estanColisionando(municion, plataforma)){
                    plataforma.aceptarColision(municion.getColisionador());
                }
            }
        }

        for(Municion municion : municiones){
            for(Obstaculo obstaculo : obstaculos){
                if(estanColisionando(municion, obstaculo)){
                    obstaculo.aceptarColision(municion.getColisionador()); 
                }
            }
        }


    }

    protected boolean estanColisionando(Entidad entidad1, Entidad entidad2) {

        Rectangle rectanguloEntidad1 = entidad1.getBounds();
        Rectangle rectanguloEntidad2 = entidad2.getBounds(); 

        return rectanguloEntidad1.intersects(rectanguloEntidad2);
    }
        
}
