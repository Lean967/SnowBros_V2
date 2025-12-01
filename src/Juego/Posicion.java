package src.Juego;

public class Posicion {
    protected int x;
    protected int y;

    public Posicion(int x, int y){
        this.x = x;
        this.y = y;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }
    /*public double distancia(Posicion p){
    }*/

    public Posicion clonar(){
        return new Posicion(this.x, this.y);
    }
}
