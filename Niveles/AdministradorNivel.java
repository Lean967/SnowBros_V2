package src.Niveles;
import src.Fabricas.FabricaEntidades;
import src.Niveles.Modos.ModoDeJuego;

public class AdministradorNivel {
   protected FabricaEntidades fabrica;
   protected String rutaArchivoTexto;
   protected int indiceNivelActual;
   protected Nivel nivel;
   protected String rutaImagenFondoNivel;

   public AdministradorNivel(String ruta, FabricaEntidades fabricaEntidades){
      this.rutaArchivoTexto=ruta;
      this.fabrica=fabricaEntidades;
      this.indiceNivelActual = 1;
   }

   public String getRuta(){
      return  rutaArchivoTexto;
   }

   public Nivel getSiguienteNivel(ModoDeJuego modoDeJuego){
      LectorDeNivel lector = new LectorDeNivel();
      nivel = lector.generarNivel(rutaArchivoTexto, fabrica, modoDeJuego, indiceNivelActual);
      sumarIndiceNivel();
      return nivel;
   }

   public Nivel getNivelActual(){
      return this.nivel;
   }

   public void sumarIndiceNivel(){
      indiceNivelActual++;
   }
   
   public void setIndiceNivelActual(int indice){
      this.indiceNivelActual = indice;
   }

   public int getIndiceNivelActual(){
      return indiceNivelActual;
   }

}
