package src.Enemigo;

import java.util.Random;

import src.Fabricas.Sprites;
import src.Juego.Posicion;
import src.Visitor.Colisionador;
import src.Jugador.SnowBro;

public class TrollAmarillo extends Enemigo {
    protected static final int PUNTOS_POR_RODAR=500;
    protected static final int PUNTOS_POR_CONGELARSE=300;

    protected Random random;
    protected int contadorMovimiento = 0;
    protected String direccionActual;

    public TrollAmarillo(Sprites sprites, Posicion posicion) {
        super(sprites, posicion);
    }

    public void aceptarColision(Colisionador c) {
    }
    public void buscarSnowBro(SnowBro snow){
        pasoX = 1;
        pasoY = 1; // velocidad vertical
        if (!estado.puedeMoverse()) {
            return; // no se mueve si está congelado
        }

        // Variables de control persistentes
        if (random == null) random = new Random();
        if (contadorMovimiento >= 50 || direccionActual == null) {
            contadorMovimiento = 0;

            // 0=quieto, 1=derecha, 2=izquierda, 3=arriba, 4=abajo
            int opcion = random.nextInt(5);
            switch (opcion) {
                case 1 -> direccionActual = "derecha";
                case 2 -> direccionActual = "izquierda";
                case 3 -> direccionActual = "arriba";
                case 4 -> direccionActual = "abajo";
                default -> direccionActual = "quieto";
            }
        }

        // Aplicar movimiento según dirección actual
        switch (direccionActual) {
            case "derecha" -> this.posicion.setX(this.posicion.getX() + pasoX);
            case "izquierda" -> this.posicion.setX(this.posicion.getX() - pasoX);
            case "arriba" -> this.posicion.setY(this.posicion.getY() - pasoY);
            case "abajo" -> this.posicion.setY(this.posicion.getY() + pasoY);
        }

        // Actualiza frame y contador
        update();
        contadorMovimiento++;
    }

    protected TrollAmarillo crearEnemigo(){
        return new TrollAmarillo(misSprites, posicion);
    }
    
    public void aumentarPuntajePorEmpujar() {
        this.getNivelActual().getSnowBro().aumentarPuntaje(PUNTOS_POR_RODAR);
    }

    public void aumentarPuntajePorCongelamiento(){
        this.getNivelActual().getSnowBro().aumentarPuntaje(PUNTOS_POR_CONGELARSE);
    }
}
