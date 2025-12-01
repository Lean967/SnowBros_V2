package src.Enemigo.EstadosEnemigo;

import src.CapaDatos.ConstantesTeclado;
import src.Enemigo.Enemigo;
import src.Fabricas.Sprites;
import src.Jugador.SnowBro;
import src.Municiones.BolaDeNieve;
import src.Obstaculos.Pared;
import src.Obstaculos.ParedDestructible;

import java.util.concurrent.ThreadLocalRandom;

public class TrollAmarilloNormal extends EnemigoNormal {
    private int contadorCambioDireccion;

    public TrollAmarilloNormal(Enemigo e, Sprites misSprites) {
        super(e, misSprites);
        puedeMoverse = true;
        contadorCambioDireccion = 0;
    }

    public void buscarSnowBro(SnowBro snowBro) {
        if (!puedeMoverse) return;

        // Cambia la direccion aleatoriamente
        if (contadorCambioDireccion <= 0) {
            int dirX = ThreadLocalRandom.current().nextInt(-1, 2); // -1,0,1
            int probabilidadSalto = 30;
            int numeroAleatorio1a100 = ThreadLocalRandom.current().nextInt(101);
            enemigo.setPasoX(dirX * ConstantesTeclado.VELOCIDAD_ENEMIGO_X * 2);
            if(numeroAleatorio1a100 <= probabilidadSalto){
                enemigo.setPasoY(ConstantesTeclado.FUERZA_SALTO_TROLLAMARILLO);
            }
            // elegir tiempo aleatorio hasta próximo cambio
            contadorCambioDireccion = ThreadLocalRandom.current().nextInt(30, 90);
        } else {
            contadorCambioDireccion--;
        }
        this.mover();
        enemigo.setCayendo(true);
    }

    public void hacerBucle() {
        if (puedeMoverse) {
            SnowBro snowBro = enemigo.getNivelActual().getSnowBro();
            buscarSnowBro(snowBro);
        } else if (tiempoDescongelamiento > 0) {
            tiempoDescongelamiento--;
            if (enemigo.getCayendo()) {
                puedeMoverse = true;
                this.mover();
            }
            puedeMoverse = false;
        } else {
            puedeMoverse = true;
        }
    }
}
