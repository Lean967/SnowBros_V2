package src.Plataformas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import src.CapaDatos.ConstantesTeclado;
import src.Enemigo.Calabaza;
import src.Enemigo.DemonioRojo;
import src.Enemigo.Enemigo;
import src.Enemigo.Fantasma;
import src.Enemigo.Kamakichi;
import src.Enemigo.Moghera;
import src.Enemigo.RanaDeFuego;
import src.Enemigo.TrollAmarillo;
import src.Fabricas.Sprites;
import src.Juego.Posicion;
import src.Jugador.SnowBro;
import src.Visitor.Colisionador;


public class Quebradiza extends Plataforma {
    protected boolean rota;

    public Quebradiza(Sprites sprites, Posicion posicion) {
        super(sprites, posicion);
        rota=false;
    }

    public void aceptarColision(Colisionador colisionador) {
        colisionador.colisionar(this);
    }

    public void hacerEfecto(SnowBro snowbro) {
        if (!rota) {
            snowbro.setCayendo(false);
            int duracionAnimacion = 1500; // 1.5 segundos
            //creo un timer para que la plataforma no se rompa al momento de tocarla
            new Timer(duracionAnimacion, new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    eliminar();
                    ((Timer)e.getSource()).stop();
                }
            }).start();
        }
        /*else {
            snowbro.setCayendo(true);
        }*/
    }
    public void hacerEfecto(DemonioRojo demonio) {
        if (!rota) {
            demonio.setCayendo(false);
            this.eliminar();
        } else {
            demonio.setCayendo(true);
        }
    }
    public void hacerEfecto(TrollAmarillo troll) {
        if (!rota) {
            troll.setCayendo(false);
            this.eliminar();
        } else {
            troll.setCayendo(true);
        }
    }
    public void hacerEfecto(RanaDeFuego rana) {
        if (!rota) {
            rana.setCayendo(false);
            this.eliminar();
        } else {
            rana.setCayendo(true);
        }
    }
    public void hacerEfecto(Calabaza calabaza) {
        if (!rota) {
            calabaza.setCayendo(false);
            this.eliminar();
        } else {
            calabaza.setCayendo(true);
        }
    }
    public void hacerEfecto(Fantasma fantasma) {
        if (!rota) {
            fantasma.setCayendo(false);
            this.eliminar();
        } else {
            fantasma.setCayendo(true);
        }
    }
    public void hacerEfecto(Kamakichi kamakichi) {
        if (!rota) {
            kamakichi.setCayendo(false);
            this.eliminar();
        } else {
            kamakichi.setCayendo(true);
        }
    }
    public void hacerEfecto(Moghera moghera) {
        if (!rota) {
            moghera.setCayendo(false);
            this.eliminar();
        } else {
            moghera.setCayendo(true);
        }
    }

    protected Quebradiza crearPlataforma(){
        Quebradiza nuevaQuebradiza = new Quebradiza(misSprites, posicion);
        nuevaQuebradiza.setDimensiones(ancho, alto);
        return nuevaQuebradiza;
    }
}