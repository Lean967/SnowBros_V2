package src.Jugador;

import src.CapaDatos.ConstantesTeclado;
import src.Enemigo.Calabaza;
import src.Enemigo.DemonioRojo;
import src.Enemigo.Enemigo;
import src.Enemigo.Fantasma;
import src.Enemigo.Kamakichi;
import src.Enemigo.Moghera;
import src.Enemigo.RanaDeFuego;
import src.Enemigo.TrollAmarillo;
import src.Municiones.BolaDeFuego;
import src.Municiones.BolaDeNieve;
import src.Municiones.Bomba;
import src.Municiones.Municion;
import src.Obstaculos.Escalera;
import src.Obstaculos.Obstaculo;
import src.Obstaculos.Pared;
import src.Obstaculos.ParedDestructible;
import src.Obstaculos.SueloResbaladizo;
import src.Obstaculos.Trampa;
import src.Plataformas.Estatica;
import src.Plataformas.Movediza;
import src.Plataformas.Quebradiza;
import src.Powers.Fruta;
import src.Powers.PocionAzul;
import src.Powers.PocionRoja;
import src.Powers.PocionVerde;
import src.Powers.VidaExtra;
import src.Visitor.Colisionador;


public class ColisionadorSnowBro implements Colisionador {
    protected SnowBro snowBro;
    

    public ColisionadorSnowBro (SnowBro snow){
        this.snowBro=snow;
    }

    public void colisionar() {
    }

    public void colisionar (DemonioRojo demonio){
        demonio.hacerEfecto(snowBro);
    }
    
    public void colisionar(Calabaza calabaza){
        calabaza.hacerEfecto(snowBro);
    }


    public void colisionar(Municion municion) {
        
    }


    public void colisionar(Estatica estatica) {
        snowBro.setVelocidadDefectoX(ConstantesTeclado.VELOCIDAD_SNOWBRO_X);
        int miBaseY = snowBro.getPosicion().getY() + snowBro.getBounds().height;
        if(snowBro.getPasoY() >= 0 && miBaseY >= estatica.getPosicion().getY() 
            && miBaseY - snowBro.getPasoY() <= estatica.getPosicion().getY()+1){
            snowBro.setCayendo(false);
            estatica.hacerEfecto(snowBro);
        }
        
    }


    public void colisionar(Pared pared) {
    
        int paredDerecha = pared.getPosicion().getX()+pared.getBounds().width;
        int paredIzquierda=pared.getPosicion().getX();
        int snowDerecha= snowBro.getPosicion().getX()+snowBro.getBounds().width;
        int snowIzquierda= snowBro.getPosicion().getX();

        if(snowDerecha>=paredIzquierda&&snowIzquierda<paredIzquierda&&snowBro.teclas.getDerecha()){
            snowBro.getPosicion().setX(paredIzquierda - snowBro.getBounds().width);
            snowBro.setPasoX(0);
        }

        if(snowIzquierda<=paredDerecha&&snowDerecha>paredDerecha&&snowBro.teclas.getIzquierda()){
            snowBro.getPosicion().setX(paredDerecha);
            snowBro.setPasoX(0);
        }
        
        
    }


    public void colisionar(PocionRoja pocionRoja) {
        pocionRoja.hacerEfecto(snowBro);
        snowBro.setPuntaje(snowBro.getPuntaje()+ pocionRoja.getPuntaje());
    }


    public void colisionar(SnowBro snowBro) {
        
    }


    public void colisionar(Enemigo enemigo) {

    }

    public void colisionar(Movediza movediza) {
        snowBro.setVelocidadDefectoX(ConstantesTeclado.VELOCIDAD_SNOWBRO_X);
        int miBaseY = snowBro.getPosicion().getY() + snowBro.getBounds().height;
        if(snowBro.getPasoY() >= 0 && miBaseY - snowBro.getPasoY() <= movediza.getPosicion().getY()+1){
            snowBro.setCayendo(false);
            movediza.hacerEfecto(snowBro);;
        }
        if (!movediza.getPuntajeObtenido()){
            snowBro.setPuntaje(snowBro.getPuntaje()+movediza.getPuntaje());
            movediza.setPuntajeObtenido(true);
        }
    }

    public void colisionar(Obstaculo obstaculo) {
        int miBaseY = snowBro.getPosicion().getY() + snowBro.getBounds().height;
            if(snowBro.getPasoY() >= 0 && miBaseY >= obstaculo.getPosicion().getY() 
                && miBaseY - snowBro.getPasoY() <= obstaculo.getPosicion().getY()+1){
                snowBro.setCayendo(false);
                obstaculo.hacerEfecto(snowBro);
            }
    }

    public void colisionar(Quebradiza quebradiza) {
        snowBro.setVelocidadDefectoX(ConstantesTeclado.VELOCIDAD_SNOWBRO_X);
        int miBaseY = snowBro.getPosicion().getY() + snowBro.getBounds().height;
            if(snowBro.getPasoY() >= 0 && miBaseY >= quebradiza.getPosicion().getY() 
                && miBaseY - snowBro.getPasoY() <= quebradiza.getPosicion().getY()+1){
                snowBro.setCayendo(false);
                quebradiza.hacerEfecto(snowBro);;
            }
    }

    public void colisionar(BolaDeNieve bolaDeNieve) {
        
    }

    public void colisionar(Escalera escalera) {
        snowBro.setVelocidadDefectoX(ConstantesTeclado.VELOCIDAD_SNOWBRO_X);
        this.snowBro.setCayendo(false);
        escalera.hacerEfecto(snowBro);
    }

    public void colisionar(ParedDestructible paredDes) {
        
        int paredDerecha = paredDes.getPosicion().getX()+paredDes.getBounds().width;
        int paredIzquierda=paredDes.getPosicion().getX();
        int snowDerecha= snowBro.getPosicion().getX()+snowBro.getBounds().width;
        int snowIzquierda= snowBro.getPosicion().getX();

        if(snowDerecha>=paredIzquierda&&snowIzquierda<paredIzquierda&&snowBro.teclas.getDerecha()){
            snowBro.getPosicion().setX(paredIzquierda - snowBro.getBounds().width);
            snowBro.setPasoX(0);
        }

        if(snowIzquierda<=paredDerecha&&snowDerecha>paredDerecha&&snowBro.teclas.getIzquierda()){
            snowBro.getPosicion().setX(paredDerecha);
            snowBro.setPasoX(0);
        }
    
    }


    public void colisionar(SueloResbaladizo sueloRes) {
        int miBaseY = snowBro.getPosicion().getY() + snowBro.getBounds().height;
        if(snowBro.getPasoY() >= 0 && miBaseY >= sueloRes.getPosicion().getY() 
            && miBaseY - snowBro.getPasoY() <= sueloRes.getPosicion().getY()+1){
            snowBro.setCayendo(false);
            sueloRes.hacerEfecto(snowBro);
        }   
    }


    public void colisionar(Trampa trampa) {
        trampa.hacerEfecto(snowBro);
    }
    public void colisionar(Fruta fruta) {
        fruta.eliminar();
        snowBro.setPuntaje(snowBro.getPuntaje()+fruta.getPuntaje());
    }

    public void colisionar(PocionAzul pocionAzul) {
        pocionAzul.hacerEfecto(snowBro);
        snowBro.setPuntaje(snowBro.getPuntaje()+pocionAzul.getPuntaje());
    }
    public void colisionar(PocionVerde pocionVerde) {
        pocionVerde.hacerEfecto(snowBro);
        snowBro.setPuntaje(snowBro.getPuntaje()+pocionVerde.getPuntaje());
    }
    public void colisionar(VidaExtra vidaExtra) {
        vidaExtra.hacerEfecto(snowBro);
        vidaExtra.eliminar();
    }

    public void colisionar(TrollAmarillo trollAmarillo) {
        trollAmarillo.hacerEfecto(snowBro);
    }

    public void colisionar(RanaDeFuego ranaDeFuego) {
        ranaDeFuego.hacerEfecto(snowBro);
    }

    public void colisionar(BolaDeFuego bolaDeFuego) {
        snowBro.perderVida();
        bolaDeFuego.eliminar();
    }

    public void colisionar(Fantasma fantasma) {
        fantasma.hacerEfecto(snowBro);
    }

    public void colisionar(Bomba bomba) {
        snowBro.perderVida();
    }

    public void colisionar(Kamakichi kamakichi) {
        kamakichi.hacerEfecto(snowBro);
    }

    public void colisionar(Moghera moghera) {
        moghera.hacerEfecto(snowBro);
    }
}