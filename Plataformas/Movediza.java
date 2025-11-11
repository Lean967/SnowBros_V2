package src.Plataformas;

import src.Enemigo.Calabaza;
import src.Enemigo.DemonioRojo;
import src.Enemigo.Fantasma;
import src.Enemigo.Kamakichi;
import src.Enemigo.Moghera;
import src.Enemigo.RanaDeFuego;
import src.Enemigo.TrollAmarillo;
import src.Fabricas.Sprites;
import src.Juego.Posicion;
import src.Jugador.SnowBro;
import src.Visitor.Colisionador;


public class Movediza extends Plataforma {
    protected boolean puntajeYaObtenido=false;
    
    // Límites de movimiento
    protected int limiteSuperior;
    protected int limiteInferior;
    protected int limiteIzquierdo;
    protected int limiteDerecho;
    
    // Estado de movimiento
    protected int velocidadMovimiento = 2;
    protected int pasoY;
    protected int pasoX;

    // Modos de movimiento 
    public enum Modo { VERTICAL, HORIZONTAL }
    public Modo modo;

    // Constructor genérico
    public Movediza(Sprites sprites, Posicion posicion, Modo m) {
        super(sprites, posicion);
        this.modo = m;
        this.velocidadMovimiento = 2;
        inicializarSegunModo();
    }

    private void inicializarSegunModo() {
        if (modo == Modo.VERTICAL) {
            this.pasoY = velocidadMovimiento;
            this.pasoX = 0;
        } else {
            this.pasoX = velocidadMovimiento;
            this.pasoY = 0;
        }
    }

    // Configuradores de movimiento
    public void configurarComoAscensor(int limiteSup, int limiteInf, int velocidad) {
        this.limiteSuperior = limiteSup;
        this.limiteInferior = limiteInf;
        this.velocidadMovimiento = Math.max(1, velocidad);
        this.modo = Modo.VERTICAL;

        if (this.pasoY == 0) {                                                    // Si no tenía dirección previa (pasoY == 0), empieza bajando
            this.pasoY = velocidadMovimiento; 
        } else {                                                                 // Si ya tenía dirección, mantener el sentido (abs para no invertir)
            this.pasoY = Math.abs(this.pasoY);
        }
        this.pasoX = 0; // Ascensor no se mueve en X
    }

    public void configurarComoLateral(int limiteIzq, int limiteDer, int velocidad) {
        this.limiteIzquierdo = limiteIzq;
        this.limiteDerecho = limiteDer;
        this.velocidadMovimiento = Math.max(1, velocidad);
        this.modo = Modo.HORIZONTAL;
        this.pasoX = velocidadMovimiento;
        this.pasoY = 0;
    }

    public void mover() {
        if (modo == Modo.VERTICAL) {
            posicion.setY(posicion.getY() + pasoY);                              // Movemos en Y según la dirección actual
            
            // Lo hacemos bajar una vez detectado el limite inferior
            if (posicion.getY() >= limiteInferior && pasoY > 0) {
                posicion.setY(limiteInferior);                                   // Pegamos al limite                       
                pasoY = -velocidadMovimiento;                                    // Invertimos dirección   
            } 

            // Lo hacemos subir una vez detectado el limite superior
            else if (posicion.getY() <= limiteSuperior && pasoY < 0) {
                posicion.setY(limiteSuperior);                                  // Pegamos al limite
                pasoY = velocidadMovimiento;                                    // Invertimos dirección
            }
        } else if (modo == Modo.HORIZONTAL) {
            posicion.setX(posicion.getX() + pasoX);                             // Movemos en X según la dirección actual
            
            // Yendo a la derecha
            if (posicion.getX() >= limiteDerecho && pasoX > 0) {
                posicion.setX(limiteDerecho);
                pasoX = -velocidadMovimiento;                                   // Invertimos dirección, ahora va a la izquierda
            }

            // Yendo a la izquierda
            else if (posicion.getX() <= limiteIzquierdo && pasoX < 0) {
                posicion.setX(limiteIzquierdo);
                pasoX = velocidadMovimiento;                                    // Invertimos dirección, ahora va a la derecha  
            }
        }

        // Actualizamos la interfaz gráfica
        update();                                                               
    } 

    public void aceptarColision(Colisionador colisionador) {
        colisionador.colisionar(this);
    }

    

    public void hacerEfecto(SnowBro snowbro) { /*ESTO HAY QUE REVISAR YA QUE NO LOGRA COLISIONAR, UNA VEZ LOGRADO BORRAR ESTE COMENTARIO */
        snowbro.setCayendo(false);

        // Solo modificar pasoY si SnowBro NO está saltando (es decir, si su pasoY es <= 0)
        if (snowbro.getPasoY() <= 0) {
            snowbro.setPasoY(pasoY);
        }
        System.out.println("SnowBro en plataforma movediza, pasoY de la plataforma: " + pasoY);
    }

    public void hacerEfecto(DemonioRojo demonio) {
        demonio.setCayendo(false);
        demonio.setPasoY(demonio.getPasoY()+pasoY);
    }
    public void hacerEfecto(TrollAmarillo troll) {
        troll.setCayendo(false);
        troll.setPasoY(troll.getPasoY()+pasoY);
    }
    public void hacerEfecto(RanaDeFuego rana) {
        rana.setCayendo(false);
        rana.setPasoY(rana.getPasoY()+pasoY);
    }
    public void hacerEfecto(Calabaza calabaza) {
        calabaza.setCayendo(false);
        calabaza.setPasoY(calabaza.getPasoY()+pasoY);
    }
    public void hacerEfecto(Fantasma fantasma) {
    }

    public void hacerEfecto(Kamakichi kamakichi) {
    }
    //no se si deberia poder subirse a la plataforma
    public void hacerEfecto(Moghera moghera) {
        moghera.setCayendo(false);
        moghera.setPasoY(moghera.getPasoY()+pasoY);
    }

    protected Movediza crearPlataforma(){
        Movediza nuevaMovediza = new Movediza(misSprites, posicion, modo);
        nuevaMovediza.setDimensiones(ancho, alto);
        return nuevaMovediza;
    }

    public boolean getPuntajeObtenido() {
        return puntajeYaObtenido;
    }

    public void setPuntajeObtenido(boolean b) {
        puntajeYaObtenido=b;
    }
    
}
