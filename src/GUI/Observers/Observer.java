package src.GUI.Observers;

import src.Juego.EntidadLogica;

public interface Observer {
    public void update();

    public void eliminarEntidad(EntidadLogica e);
    
    public void hacerInvisible();

    public void hacerVisible();
}
