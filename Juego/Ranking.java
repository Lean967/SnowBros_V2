package src.Juego;

import java.io.Serializable;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;

import src.CapaDatos.Puntaje;


public class Ranking implements Serializable{
    private PriorityQueue<Puntaje> coleccionPuntajes;


    public Ranking (){
        coleccionPuntajes= new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void agregarPuntaje(Puntaje puntaje) {
        coleccionPuntajes.add(puntaje);
    }

    // HAY Q CORREGIR
    public LinkedList<Puntaje> getTopPuntajes(int cantidad) {
        LinkedList<Puntaje> topPuntajes= new LinkedList<> ();
        PriorityQueue<Puntaje> aux= new PriorityQueue<>(Collections.reverseOrder());
        if (coleccionPuntajes.size()>=cantidad){
            for (int i=0; i<cantidad; i++){
                aux.add(coleccionPuntajes.peek());
                topPuntajes.addLast(coleccionPuntajes.poll());
            }
        }
        else {
            for (int i=0; i<coleccionPuntajes.size(); i++){
                aux.add(coleccionPuntajes.peek());
                topPuntajes.addLast(coleccionPuntajes.poll());
            }
        }
        return topPuntajes;
    }
}
