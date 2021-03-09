package evf.javadoc.original;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class ReproductorVirtual {
    List<Cancion> canciones;
    List<ListaReproduccion> listasReproduccion;
    Queue<Cancion> colaReproduccion;
    
    public static final String CANCION_DEFECTO="Sympathy for the devil";

    public ReproductorVirtual(List<Cancion> canciones,List<ListaReproduccion> listasReproduccion) {
        this.canciones = canciones;
        this.listasReproduccion = listasReproduccion;
        colaReproduccion = new LinkedList<Cancion>();
        Cancion c = null;
        if (this.canciones.isEmpty()){
               c = new Cancion(CANCION_DEFECTO,new Artista("Rolling Stones"));
               canciones.add(c);
               encolarSiguienteCancion(c);
        }
    }


    public Cancion seleccionarCancion(String nombreCancion){
       Cancion cancionSolicitada = null;
       for(Cancion song : canciones){
           if(song.getNombreCancion().equals(nombreCancion)) {
               cancionSolicitada = song;
               break;
           }
       }
       if(cancionSolicitada == null){
           throw new IllegalArgumentException("Canción no disponible ");
       }
       return cancionSolicitada;
    }



    public void reproducirCancion(String nombreCancion){
        Cancion cancionSolicitada = seleccionarCancion(nombreCancion);
        cancionSolicitada.reproducirCancion();
    }


    public void encolarSiguienteCancion(String nombreCancion){
        Cancion cancionSolicitada = seleccionarCancion(nombreCancion);
        colaReproduccion.add(cancionSolicitada);
    }


    private void encolarSiguienteCancion(Cancion cancion){
        colaReproduccion.add(cancion);
    }
    
    
    public ListaReproduccion seleccionarListaReproduccion(String nombrePlayList){
        ListaReproduccion listaReproduccionSeleccionada = null;
        for(ListaReproduccion listaReproduccion : listasReproduccion){
            if(listaReproduccion.getNombreListaReproduccion().equals(nombrePlayList)){
                listaReproduccionSeleccionada = listaReproduccion;
            }
        }
        if(listaReproduccionSeleccionada == null){
            throw new IllegalArgumentException("Lista de reproducción no disponible");
        }
        return listaReproduccionSeleccionada;
    }


    public void reproducirListaReproduccion(String nombreListaReproduccion){
       ListaReproduccion listaReproduccion =  seleccionarListaReproduccion(nombreListaReproduccion);
       List<Cancion> cancionesListaReproduccion = listaReproduccion.getCancionesListaReproduccion();

        cancionesListaReproduccion.get(0).reproducirCancion();

        Cancion cancionActual;
        for(int i = 1 ; i < cancionesListaReproduccion.size() ; i++){
            cancionActual = cancionesListaReproduccion.get(i);
            //colaReproduccion.add(cancionActual);
            encolarSiguienteCancion(cancionActual);
        }
    }

}