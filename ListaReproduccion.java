package evf.javadoc.original;

import java.util.List;

public class ListaReproduccion {
    String nombreListaReproduccion;
    List<Cancion> cancionesListaReproduccion;
    

    public ListaReproduccion(String nombreListaReproduccion,List<Cancion> cancionesListaReproduccion) {
        this.nombreListaReproduccion = nombreListaReproduccion;
        this.cancionesListaReproduccion = cancionesListaReproduccion;
    }
    

    public void agregarCancion(Cancion cancion){
        cancionesListaReproduccion.add(cancion);
    }

    public String getNombreListaReproduccion() {
        return nombreListaReproduccion;
    }


    public List<Cancion> getCancionesListaReproduccion() {
        return cancionesListaReproduccion;
    }


}

