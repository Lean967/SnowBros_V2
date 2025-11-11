package src.Jugador;

import src.CapaDatos.ConstantesTeclado;
import src.Enemigo.Calabaza;
import src.Enemigo.DemonioRojo;
import src.Enemigo.Enemigo;
import src.Municiones.BolaDeNieve;
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
    private static final int POWER=300;
    private static final int FRUTA=500;
    
    private static final int PLAT_MOVIL=200;
    private static final int PLAT_QUEB=300;

    public ColisionadorSnowBro (SnowBro snow){
        this.snowBro=snow;
    }

    public void colisionar() {
    }

    public void colisionar (DemonioRojo demonio){
        System.out.println("Colisionando Snow a Demonio");
        demonio.hacerEfecto(snowBro);
        /*if(!snowBro.getInmunidad()){
        snowBro.getSprites().setEstadoActual(ConstantesTeclado.PerderVida);
        snowBro.perderVida();
        }
        snowBro.alejarDeEnemigo(demonio.getPosicion());*/
    }
    
    public void colisionar(Calabaza calabaza){
        calabaza.hacerEfecto(snowBro);
    }


    public void colisionar(Municion municion) {
        
    }


    public void colisionar(Estatica estatica) {
        int miBaseY = snowBro.getPosicion().getY() + snowBro.getBounds().height;
        if(snowBro.getPasoY() >= 0 && miBaseY >= estatica.getPosicion().getY() 
            && miBaseY - snowBro.getPasoY() <= estatica.getPosicion().getY()+1){
            snowBro.setCayendo(false);
            estatica.hacerEfecto(snowBro);
        }
        
    }


    public void colisionar(Pared pared) {
        snowBro.setPasoX(snowBro.getPasoX() * -1);
    
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
        snowBro.setPuntaje(snowBro.getPuntaje()+POWER);
    }


    public void colisionar(SnowBro snowBro) {
        
    }


    public void colisionar(Enemigo enemigo) {
        /*System.out.println("Colisionando Snow a enemigo");
        snowBro.getSprites().setEstadoActual(ConstantesTeclado.PerderVida);
        snowBro.perderVida();*/

        //snowBro.alejarDeEnemigo(enemigo.getPosicion());
    }

    public void colisionar(Movediza movediza) {
        int miBaseY = snowBro.getPosicion().getY() + snowBro.getBounds().height;
        if(snowBro.getPasoY() >= 0 && miBaseY >= movediza.getPosicion().getY() 
            && miBaseY - snowBro.getPasoY() <= movediza.getPosicion().getY()+1){
            snowBro.setCayendo(false);
            movediza.hacerEfecto(snowBro);;
        }
        if (!movediza.getPuntajeObtenido()){
            snowBro.setPuntaje(snowBro.getPuntaje()+PLAT_MOVIL);
            movediza.setPuntajeObtenido(true);
        }
    }

    public void colisionar(Obstaculo obstaculo) {
        int miBaseY = snowBro.getPosicion().getY() + snowBro.getBounds().height;
            if(snowBro.getPasoY() >= 0 && miBaseY >= obstaculo.getPosicion().getY() 
                && miBaseY - snowBro.getPasoY() <= obstaculo.getPosicion().getY()+1){
                snowBro.setCayendo(false);
                obstaculo.hacerEfecto(snowBro);;
            }
    }

    public void colisionar(Quebradiza quebradiza) {
        int miBaseY = snowBro.getPosicion().getY() + snowBro.getBounds().height;
            if(snowBro.getPasoY() >= 0 && miBaseY >= quebradiza.getPosicion().getY() 
                && miBaseY - snowBro.getPasoY() <= quebradiza.getPosicion().getY()+1){
                snowBro.setCayendo(false);
                quebradiza.hacerEfecto(snowBro);;
            }
            snowBro.setPuntaje(snowBro.getPuntaje()+PLAT_QUEB);
    }

    public void colisionar(BolaDeNieve bolaDeNieve) {
        
    }

    public void colisionar(Escalera escalera) {
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
        fruta.hacerEfecto(snowBro);
        fruta.eliminar();
        snowBro.setPuntaje(snowBro.getPuntaje()+FRUTA);
    }

    public void colisionar(PocionAzul pocionAzul) {
        pocionAzul.hacerEfecto(snowBro);
        pocionAzul.eliminar();
        snowBro.setPuntaje(snowBro.getPuntaje()+POWER);
    }
    public void colisionar(PocionVerde pocionVerde) {
        pocionVerde.hacerEfecto(snowBro);
        pocionVerde.eliminar();
        snowBro.setPuntaje(snowBro.getPuntaje()+POWER);
    }
    public void colisionar(VidaExtra vidaExtra) {
        vidaExtra.hacerEfecto(snowBro);
        vidaExtra.eliminar();
    }
}