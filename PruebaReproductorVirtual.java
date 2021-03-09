package evf.javadoc.original;

import java.util.ArrayList;
import java.util.List;



public class PruebaReproductorVirtual {
    public static void main(String[] args) {

        List<Cancion> canciones = new ArrayList<Cancion>();
        Cancion cancion1 = new Cancion("Roses",new Artista("David"));
        Cancion cancion2 = new Cancion("Ride",new Artista("21Pilots"));
        canciones.add(cancion1);
        canciones.add(cancion2);

        List<ListaReproduccion> listasReproduccion = new ArrayList<ListaReproduccion>();
        List<Cancion> cancionesListaReproduccion = new ArrayList<Cancion>();
        cancionesListaReproduccion.add(cancion2);
        ListaReproduccion listaReproduccion = new ListaReproduccion("Hello",cancionesListaReproduccion);
        listasReproduccion.add(listaReproduccion);

        ReproductorVirtual reproductor = new ReproductorVirtual(canciones,listasReproduccion);

        reproductor.reproducirCancion("Roses");
        reproductor.reproducirListaReproduccion("Hello");
    }
}
