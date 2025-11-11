package src.Visitor;

import src.Enemigo.Calabaza;
import src.Enemigo.DemonioRojo;
import src.Plataformas.Estatica;
import src.Plataformas.Movediza;
import src.Plataformas.Quebradiza;
import src.Powers.Fruta;
import src.Powers.PocionAzul;
import src.Powers.PocionRoja;
import src.Powers.PocionVerde;
import src.Powers.VidaExtra;
import src.Jugador.SnowBro;
import src.Municiones.BolaDeNieve;
import src.Obstaculos.Escalera;
import src.Obstaculos.Pared;
import src.Obstaculos.ParedDestructible;
import src.Obstaculos.SueloResbaladizo;
import src.Obstaculos.Trampa;

public interface Colisionador {
     public void colisionar(DemonioRojo demonio);
     public void colisionar(Estatica estatica);
     public void colisionar(SnowBro snowBro);
     public void colisionar(Pared pared);
     public void colisionar(Movediza movediza);
     public void colisionar(Quebradiza quebradiza);
     public void colisionar(BolaDeNieve bolaDeNieve);
     public void colisionar(Calabaza calabaza);
     public void colisionar(PocionRoja pocionRoja);
     public void colisionar(Escalera escalera);
     public void colisionar(ParedDestructible paredDestructible);
     public void colisionar(SueloResbaladizo sueloResbaladizo);
     public void colisionar(Trampa trampa);
     public void colisionar(Fruta fruta);
     public void colisionar(PocionAzul pocionAzul);
     public void colisionar(PocionVerde pocionVerde);
     public void colisionar(VidaExtra vidaExtra);
}
