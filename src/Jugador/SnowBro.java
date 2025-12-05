package src.Jugador;

import src.Fabricas.Sprites;
import src.GUI.Observers.Observer;
import src.Juego.Entidad;
import src.Juego.Personaje;
import src.Juego.Posicion;
import src.Jugador.EstadosLogicos.EstadoLogicoSnowBroEscalera;
import src.Jugador.EstadosLogicos.EstadoLogicoSnowBroMontado;
import src.Jugador.EstadosLogicos.EstadoLogicoSnowBroNormal;
import src.Jugador.EstadosLogicos.EstadoLogicoSnowBroRodandoBola;
import src.Jugador.EstadosPowerUp.EstadoPowerUpNormal;
import src.Jugador.EstadosSprites.EstadoSpritesRodandoBola;
import src.Jugador.EstadosSprites.EstadoSpritesSnowBro;
import src.Jugador.EstadosSprites.EstadoSpritesSnowNormal;
import src.Municiones.BolaDeFuego;
import src.Municiones.Bomba;
import src.Visitor.Colisionable;
import src.Visitor.Colisionador;
import src.CapaDatos.ConstantesTeclado;
import src.CapaDatos.GestorSonido;
import src.CapaDatos.TeclasJugador;
import src.Enemigo.Enemigo;

public class SnowBro extends Personaje implements Colisionable {
    protected EstadoSpritesSnowBro estadoSprites;
    protected EstadoLogicoSnowBroNormal estadoLogico;
    protected TeclasJugador teclas;
    protected ColisionadorSnowBro colisionador;
    protected GestorSonido gestorSonido = GestorSonido.getInstancia();
    protected boolean enEscalera;
    protected int velocidadDefectoX;
    protected Posicion posInicial;
    protected int daño;
    protected EstadoPowerUpNormal powerUp;

    
    public SnowBro(Sprites misSprites, Posicion posicion) {
        super(misSprites, posicion);
        posAnterior=posicion.clonar();
        posInicial=posicion.clonar();
        colisionador= new ColisionadorSnowBro(this);
        cayendo = true;
        estadoSprites= new EstadoSpritesSnowNormal(this, misSprites);
        estadoLogico= new EstadoLogicoSnowBroNormal(this);
        vida=3;
        mirar = ConstantesTeclado.MIRANDO_DERECHA;
        setDimensiones(40   , 50);
        powerUp= new EstadoPowerUpNormal(this);
        velocidadDefectoX = ConstantesTeclado.VELOCIDAD_SNOWBRO_X;
        GestorSonido.getInstancia().reproducirSonido("APARECE_SNOW");
    }
    
    public void mover(){
        estadoLogico.mover(teclas);
    }

    public Posicion getPosAnterior(){
        return this.posAnterior;
    }

    
    public void SubirseAEnemigo(Enemigo enemigo){
        setEstadoLogico(new EstadoLogicoSnowBroMontado(this, enemigo));
        getEstadoSpritesSnowBro().getSprites().setEstadoActual(ConstantesTeclado.QUIETO); 
        enemigo.aumentarPuntajePorEmpujar();
    }

    public void desmontarDeEnemigo(){
        setEstadoLogico(new EstadoLogicoSnowBroNormal(this));
    }

    public void saltar(){
        gestorSonido.reproducirSonido("SALTO_SNOW");
        if(posicion.getY() - pasoY < -10)
            posicion.setY(-10);
        else{
            pasoY = ConstantesTeclado.FUERZA_SALTO;
            posicion.setY(posicion.getY() + pasoY);
            cayendo = true;
        }
        this.misSprites.setEstadoActual(ConstantesTeclado.SALTANDO);
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


    public void setEstadoNormal(){
        estadoSprites= new EstadoSpritesSnowNormal(this, misSprites);
        update();
    }

    public void setEstadoRodandoBola(){
        gestorSonido.reproducirSonido("EMPUJE_SNOW");
        this.estadoLogico = new EstadoLogicoSnowBroRodandoBola(this);
        this.estadoSprites= new EstadoSpritesRodandoBola(this,this.nivelActual.getFabricaEntidades().getFabricaSprites().getSpritesSnowRodandoBola());
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

    public void detenerEnemigos(){
        nivelActual.detenerEnemigos();
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
        powerUp.hacerBucle();
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
            gestorSonido.reproducirSonido("MUERTE_SNOW");
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

    public void sumarVida() {
        if(vida < 3)
            vida++;
    }

    public void subirBajarEscalera() {
        if(!enEscalera){
            estadoLogico = new EstadoLogicoSnowBroEscalera(this);
            enEscalera = true;
        }
        enEscalera = false;
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



    public Entidad clone() {
        SnowBro nuevo = new SnowBro(this.misSprites, this.posInicial.clonar()); 
        nuevo.setEstadoLogico(new EstadoLogicoSnowBroNormal(nuevo));
        return nuevo;
    }
    
    public void setDaño(int nuevoDaño){
        daño=nuevoDaño;
    }

    public int getDaño(){
        return daño;
    }

    public void setEstadoPowerUp(EstadoPowerUpNormal estado){
        powerUp=estado;
    }

    public void hacerInvisible(){
        for(Observer o:observers){
            o.hacerInvisible();
        }
    }

    public void hacerVisible(){
        for(Observer o:observers){
            o.hacerVisible();
        }
    }

    public void hacerEfecto(BolaDeFuego bolaDeFuego){
        estadoLogico.hacerEfecto(bolaDeFuego);
    }
    public void hacerEfecto(Bomba bomba){
        estadoLogico.hacerEfecto(bomba);
    }
    


}