package src.Niveles;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import src.CapaDatos.ConstantesTeclado;
import src.Fabricas.FabricaEntidades;
import src.Niveles.Modos.ModoDeJuego;
import src.Plataformas.Movediza;

public class LectorDeNivel {
    private boolean leyendoOleada;
    private boolean leyendoEntidades;
    private boolean nivelTerminado;
    private Oleada oleada;

    public LectorDeNivel() {
        leyendoEntidades = false;
        leyendoOleada = false;
    }

    public Nivel generarNivel(String rutaNivel, FabricaEntidades fabricaEntidades,  ModoDeJuego modoDeJuego, int numeroNivel) {
        Nivel nivel = modoDeJuego.getNivel();
        nivel.setFabricaEntidades(fabricaEntidades);
        nivelTerminado = false;
        boolean lineaEncontrada = false;
        
        try(BufferedReader lector = new BufferedReader(new FileReader(rutaNivel))){
            String linea;
            
            

            while((linea = lector.readLine()) != null && !nivelTerminado){
                linea = linea.trim(); // Quitar espacios al inicio/final
                if(linea.isEmpty() || linea.startsWith("#")){ // Ignorar líneas vacías o comentarios
                    continue;
                }


                if(!lineaEncontrada){
                    lineaEncontrada = linea.equals(modoDeJuego.getNombre()+String.valueOf(numeroNivel));
                    continue;
                }

                
                if(modoDeJuego.getNombre().equals("CLASICO")){
                    parsearLineaClasico(linea,  nivel);
                }else if(modoDeJuego.getNombre().equals("CONTRARRELOJ")){
                    parsearLineaContrarreloj(linea, nivel);
                }else if(modoDeJuego.getNombre().equals("SUPERVIVENCIA")){
                    parsearLineaSupervivencia(linea, nivel);
                }
                


            }
            
        }catch (IOException e) {
            System.err.println("Error al leer el archivo de nivel: " + rutaNivel);
        }
        catch (NumberFormatException e) {
             System.err.println("Error de formato numérico en el archivo de nivel: " + rutaNivel);
        }


        if(!lineaEncontrada){
            nivel = null;
        }
        return nivel;
    }

    private void parsearLineaClasico(String linea ,Nivel nivel) {

        parsearLinea(linea, nivel);

        
    }

    private void parsearLineaContrarreloj(String linea, Nivel nivel){
        if(!leyendoEntidades && (!linea.equals("ENTIDADES")) && !linea.equals("FIN")){
            String[] partes = linea.split(":", 2);

            String primeraParte = partes[0].toUpperCase();
            String segundaParte = partes[1];

            if (primeraParte.equals("TIEMPOLIMITE")){
                nivel.setTiempoLimite(Integer.parseInt(segundaParte));
            }
        }

        parsearLinea(linea, nivel);
    }

    private void parsearLineaSupervivencia(String linea, Nivel nivel){
        if(!leyendoEntidades && !linea.equals("ENTIDADES") && !linea.equals("FIN")){
            String[] partes = linea.split(":", 2);

            String primeraParte = partes[0].toUpperCase();
            String segundaParte = partes[1];

            if (primeraParte.equals("PUNTAJEOBJETIVO")){
                nivel.setPuntajeObjetivo((Integer.parseInt(segundaParte)));
            }
        }
        
        parsearLinea(linea, nivel);

    }
    

    private void parsearLinea(String linea, Nivel nivel){

        if(leyendoEntidades){
            switch (linea) {
            case "FINENTIDADES":
                leyendoEntidades = false;
                break;
            case "OLEADA":
                leyendoOleada = true;
                oleada = new Oleada(nivel.getFabricaEntidades());
                break;  
            case "FINOLEADA":
                leyendoOleada = false;
                nivel.setNuevaOleada(oleada);
                break;
            default:
                if (leyendoOleada) {
                    leerOleada(linea);
                }else{
                    leerEntidades(linea, nivel);
                }
                break;
            }
        }
        

        

        if(!leyendoEntidades){
            switch (linea) {
                case "ENTIDADES":
                    leyendoEntidades = true;
                    break;    
                case("FIN"):
                    nivelTerminado = true;  
                default:
                    break;
            }
        }
    }

    private void leerEntidades(String linea, Nivel nivel){
        String[] partes = linea.split(":", 2);
        if (partes.length != 2) {
            System.err.println("Formato de línea incorrecto: " + linea);
            return;
        }

        String tipoEntidad = partes[0].toUpperCase();
        Map<String, String> parametros = parsearParametros(partes[1]);

        int x = Integer.parseInt(parametros.get("x"));
        int y = Integer.parseInt(parametros.get("y"));

        //Valores por defecto
        int estadoSprite = ConstantesTeclado.QUIETO; 
        int alto=48;
        int ancho=48;
        int limiteSup=0;
        int limiteInf=0;
        int limiteIzq = 0;
        int limiteDer = 0;

        if (parametros.containsKey("sprite")) {
          estadoSprite = Integer.parseInt(parametros.get("sprite"));
        }
        if (parametros.containsKey("alto")) {
          alto= Integer.parseInt(parametros.get("alto"));
        }
        if (parametros.containsKey("ancho")) {
          ancho= Integer.parseInt(parametros.get("ancho"));
        }
        if (parametros.containsKey("limitesup")) {
            limiteSup = Integer.parseInt(parametros.get("limitesup"));
        }
        if (parametros.containsKey("limiteinf")) {
            limiteInf = Integer.parseInt(parametros.get("limiteinf"));
        }
        if (parametros.containsKey("limiteizq")) {
            limiteIzq = Integer.parseInt(parametros.get("limiteizq"));
        }
        if (parametros.containsKey("limiteder")) {
            limiteDer = Integer.parseInt(parametros.get("limiteder"));
        }


        switch (tipoEntidad) {
            //SNOWBRO
            case "SNOWBRO":
                nivel.setSnowBro(x, y);
                break;
            //ENEMIGOS
            case "CALABAZA":
                nivel.setCalabaza(x, y);
                break;
            case "DEMONIOROJO":
                nivel.setDemonioRojo(x, y);
                break;
            case "TROLLAMARILLO":
                nivel.setTrollAmarillo(x, y);
                break;
            case "FANTASMA":
                nivel.setFantasma(x, y);
                break;
            case "RANADEFUEGO":
                nivel.setRanaDeFuego(x, y);
                break;
            //PLATAFORMAS Y ELEMENTOS
            case "PAREDIZQUIERDA":
                 nivel.setParedIzquierda(x, y, estadoSprite, ancho, alto);
                 break;
            case "PAREDDERECHA":
                 nivel.setParedDerecha(x, y, estadoSprite, ancho, alto);
                 break;
            case "SUELORESBALADIZO":
                nivel.setSueloResbaladizo(x, y, estadoSprite);
                break;
            case "PAREDDESTRUCTIBLE":
                nivel.setParedDestructible(x, y, estadoSprite);
                break;
            case "TRAMPA":
                nivel.setTrampa(x, y, estadoSprite);
                break;
            case "ESCALERA":
                nivel.setEscalera(x, y, estadoSprite);
                break;
            case "PLATAFORMAESTATICA":
                nivel.setPlataformaEstatica(x, y, estadoSprite, ancho, alto);
                break;
            case "PLATAFORMAQUEBRADIZA":
                nivel.setPlataformaQuebradiza(x, y, estadoSprite, ancho, alto);
                break;
            case "PLATAFORMAMOVEDIZAASCENSOR":
                nivel.setPlataformaMovedizaAscensor(x, y, limiteSup, limiteInf, estadoSprite, ancho, alto, Movediza.Modo.VERTICAL);
                break;
            case "PLATAFORMAMOVEDIZALATERAL":
                nivel.setPlataformaMovedizaLateral(x, y, limiteIzq, limiteDer, estadoSprite, ancho, alto, Movediza.Modo.HORIZONTAL);
                break;
            case "VIDAEXTRA":
                nivel.setVidaExtra(x, y);
                break;
            case "POCIONROJA":
                nivel.setPocionRoja(x, y);
                break;
            case "POCIONAZUL":
                nivel.setPocionAzul(x, y);
                break;
            case "POCIONVERDE":
                nivel.setPocionVerde(x, y);
                break;
            case "FRUTA":
                nivel.setFruta(x, y);
                break;
            //JEFES
            case "MOGHERA":
                nivel.setMoghera(x, y,estadoSprite, ancho, alto);
                break;
            case "KAMAKICHI":
                nivel.setKamakichi(x, y, ancho, alto);
                break;
            
            default:
                System.err.println("Tipo de entidad desconocido: " + tipoEntidad);
                break;
    }
}

    private Map<String, String> parsearParametros(String parametrosString) {
        Map<String, String> parametros = new HashMap<>();
        String[] pares = parametrosString.split(",");
        for (String par : pares) {
            String[] claveValor = par.split("=", 2);
            if (claveValor.length == 2) {
                parametros.put(claveValor[0].trim().toLowerCase(), claveValor[1].trim()); // Clave en minúscula
            }
        }
        return parametros;
    }


    public void leerOleada(String linea){
        String[] partes = linea.split(":", 2);
        if (partes.length != 2) {
            System.err.println("Formato de línea incorrecto: " + linea);
            return;
        }

        String tipoEntidad = partes[0].toUpperCase();
        Map<String, String> parametros = parsearParametros(partes[1]);

        int x = Integer.parseInt(parametros.get("x"));
        int y = Integer.parseInt(parametros.get("y"));


        switch (tipoEntidad) {
            //ENEMIGOS
            case "DEMONIOROJO":
                oleada.setDemonioRojo(x, y);
                break;
            case "RANADEFUEGO":
                oleada.setRanaDeFuego(x,y);
                break;
            case "TROLLAMARILLO":
                oleada.setTrollAmarillo(x, y);
                break;
            default:
                System.err.println("Tipo de entidad desconocido: " + tipoEntidad);
                break;
    }
    }

}