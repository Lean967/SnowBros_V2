package src.Jugador;

import src.Fabricas.Sprites;
import src.Juego.Entidad;
import src.Juego.Personaje;
import src.Juego.Posicion;
import src.Jugador.EstadosLogicos.EstadoLogicoSnowBroMontado;
import src.Jugador.EstadosLogicos.EstadoLogicoSnowBroNormal;
import src.Jugador.EstadosLogicos.EstadoLogicoSnowBroRodandoBola;
import src.Jugador.EstadosSprites.EstadoSpritesRodandoBola;
import src.Jugador.EstadosSprites.EstadoSpritesSnowAzul;
import src.Jugador.EstadosSprites.EstadoSpritesSnowBro;
import src.Jugador.EstadosSprites.EstadoSpritesSnowNormal;
import src.Jugador.EstadosSprites.EstadoSpritesSnowRojo;
import src.Visitor.Colisionable;
import src.Visitor.Colisionador;
import src.CapaDatos.ConstantesTeclado;
import src.CapaDatos.TeclasJugador;
import src.Enemigo.Enemigo;

public class SnowBro extends Personaje implements Colisionable {
    protected EstadoSpritesSnowBro estadoSprites;
    protected EstadoLogicoSnowBroNormal estadoLogico;
    protected TeclasJugador teclas;
    protected ColisionadorSnowBro colisionador;
    protected int mirar;
    protected boolean enEscalera;
    protected int velocidadDefectoX;
    protected Posicion posInicial;


    
    public SnowBro(Sprites misSprites, Posicion posicion) {
        super(misSprites, posicion);
        posAnterior=posicion.clonar();
        posInicial=posicion.clonar();
        colisionador= new ColisionadorSnowBro(this);
        cayendo = true;
        //enEscalera=false;
        estadoSprites= new EstadoSpritesSnowNormal(this, misSprites);
        estadoLogico= new EstadoLogicoSnowBroNormal(this);
        vida=3;
        mirar = ConstantesTeclado.SnowBroMirandoDerecha;
        setDimensiones(40   , 50);
        velocidadDefectoX = ConstantesTeclado.VelocidadSnowBroX;
    }
    
    public void mover(){
        estadoLogico.mover(teclas);
    }

    public Posicion getPosAnterior(){
        return this.posAnterior;
    }

    
    public void SubirseAEnemigo(Enemigo enemigo){
        setEstadoLogico(new EstadoLogicoSnowBroMontado(this, enemigo));
        getEstadoSpritesSnowBro().getSprites().setEstadoActual(ConstantesTeclado.Quieto); 
        enemigo.aumentarPuntajePorEmpujar();
    }

    public void desmontarDeEnemigo(){
        setEstadoLogico(new EstadoLogicoSnowBroNormal(this));
    }

    public void saltar(){
        if(posicion.getY() - pasoY < -10)
            posicion.setY(-10);
        else{
            pasoY = ConstantesTeclado.FuerzaSalto;
            posicion.setY(posicion.getY() + pasoY);
            cayendo = true;
        }
        this.misSprites.setEstadoActual(ConstantesTeclado.Saltando);
    }

    public void setVelocidadDefectoX(int velocidad){
        velocidadDefectoX = velocidad;
    }
    public int getVelocidadDefectoX(){
        return this.velocidadDefectoX;
    }
    

    public void espacioPresionado(){
        disparar();
    }

    public void setTeclas(TeclasJugador teclas){
        this.teclas=teclas;
    }
    public TeclasJugador getTeclasJugador(){
        return this.teclas;
    }
    public int getMirar(){
        return this.mirar;
    }

    
    public void setEstadoRojo(){
        this.estadoSprites= new EstadoSpritesSnowRojo(this, this.nivelActual.getFabricaEntidades().getFabricaSprites().getSpritesSnowRojo());
        System.out.println("Estado cambiado a Rojo");
        update();
    }

    public void setEstadoNormal(){
        estadoSprites= new EstadoSpritesSnowNormal(this, misSprites);
        update();
    }

    public void setEstadoRodandoBola(){
        this.estadoLogico = new EstadoLogicoSnowBroRodandoBola(this);
        this.estadoSprites= new EstadoSpritesRodandoBola(this,this.nivelActual.getFabricaEntidades().getFabricaSprites().getSpritesSnowRodandoBola());
        System.out.println("Estado cambiado a rodando bola");
        update();
    }


    public void disparar(){
        estadoLogico.disparar();
    }
    public void aumentarPuntaje(int puntos){
        setPuntaje(getPuntaje()+puntos);
    }
   
    public void aceptarColision(Colisionador c){
        c.colisionar(this);
    }

    public Colisionador getColisionador(){
        return this.colisionador;
    }

    public void detenerEnemigos(int duracion){
        nivelActual.detenerEnemigos(duracion);
    }

    public EstadoSpritesSnowBro getEstadoSpritesSnowBro(){
        return this.estadoSprites;
    }
    public Sprites getSprites(){
        return this.estadoSprites.getSprites();
    }

    public int getPasoY(){
        return this.pasoY;
    }

    public void hacerBucle(){
        estadoLogico.hacerBucle();
    }

      
    public void perderVida() {
        //la inmunidad se controla en el estadoEnemigo
        estadoLogico.perderVida();
        
    }

    public void setVida(int vida){
        this.vida=vida;
        update();
    }

    public int getVidas() {
        return vida;
    }

    public void setPosicionInicial(){
        posicion=posInicial.clonar();
        update();
    }

    public void controlarVidas(){
        if (vida == 0){
            System.out.println("sin vidas");
            nivelActual.perder();
        }
        else {
            nivelActual.reiniciar();
            update();
        }
    }

    public void eliminar(){
        eliminarObservers();
        nivelActual.eliminar(this);
    }

    public void setEstadoLogico(EstadoLogicoSnowBroNormal estadoLogico){
        this.estadoLogico=estadoLogico;
    }

    /*public void alejarDeEnemigo(Posicion posicionEnemigo) {
       restaurarPosicion(); 
       int snowEnX = this.posicion.getX();
       int enemigoEnX = posicionEnemigo.getX();
       int desplazamiento = 30; // distancia de alejamiento 
    
       if (snowEnX < enemigoEnX) {
          // el enemigo está a la derecha, mover SnowBro a la izquierda
         this.posicion.setX(snowEnX - desplazamiento);
        } else {
          // El enemigo está a la izquierda o en la misma posición, mover SnowBro a la derecha
          this.posicion.setX(snowEnX + desplazamiento);
        }

       // aseguro que no se sale de los límites 
       if(this.posicion.getX() < -10)
          this.posicion.setX(-10);
       if(this.posicion.getX() > 760)
          this.posicion.setX(760);
    
       update();
    }*/

    public void sumarVida() {
        if (vida<3)
            vida++;
    }

    public void setEstadoAzul() {
        this.estadoSprites= new EstadoSpritesSnowAzul(this, this.nivelActual.getFabricaEntidades().getFabricaSprites().getSpritesSnowAzul());
        System.out.println("Estado cambiado a Azul");
        update();
    }

    public void subirBajarEscalera() {
        enEscalera = true;
        cayendo = false;
        pasoY = 0;
        if(teclas.getArriba()){
            pasoY = ConstantesTeclado.VelocidadY;
            posicion.setY(posicion.getY() + pasoY); 
            estadoSprites.misSprites.setEstadoActual(ConstantesTeclado.MoviendoseDerecha);
        }
        else if(teclas.getAbajo()){
            pasoY = ConstantesTeclado.VelocidadY;
            posicion.setY(posicion.getY() - pasoY); 
            estadoSprites.misSprites.setEstadoActual(ConstantesTeclado.MoviendoseDerecha);
        }
    }

    public void setEnEscalera(Boolean enEscalera){
        this.enEscalera = enEscalera;
    }

    public boolean getEnEscalera(){
        return enEscalera;
    }

    public void setPosAnterior(Posicion posicion){
        this.posAnterior = posicion;
    }

    public void setMirar(int mirar){
        this.mirar = mirar;
    }

    public Entidad clone() {
        SnowBro nuevo = new SnowBro(this.misSprites, this.posInicial.clonar()); 
        nuevo.setEstadoLogico(new EstadoLogicoSnowBroNormal(nuevo));
        return nuevo;
    }
    
}