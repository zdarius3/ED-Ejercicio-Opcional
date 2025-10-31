import java.util.ArrayDeque;
import java.util.ArrayList;

public class Artista {
    private String nombreArtistico;
    private String generoPrincipal;
    private String nacionalidad;
    private ArrayList<Album> albumes;

    public Artista(String nombreArtistico, String generoPrincipal, String nacionalidad) {
        setNombreArtistico(nombreArtistico);
        setGeneroPrincipal(generoPrincipal);
        setNacionalidad(nacionalidad);
        albumes = new ArrayList<>();
    }

    public String getNombreArtistico() {
        return nombreArtistico;
    }

    public void setNombreArtistico(String nombreArtistico) {
        this.nombreArtistico = nombreArtistico;
    }

    public String getGeneroPrincipal() {
        return generoPrincipal;
    }

    public void setGeneroPrincipal(String generoPrincipal) {
        this.generoPrincipal = generoPrincipal;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    //auxiliar inciso b
    public Cancion getCancionMasReproducida() {
        Cancion cancionMasReproducida = null;
        int max = 0;

        for (Album a: albumes) {
            Cancion aux = a.getCancionMasReproducida();
            if (aux != null && aux.getCantidadReproducciones() > max) {
                max = aux.getCantidadReproducciones();
                cancionMasReproducida = aux;
            }
        }

        return cancionMasReproducida;
    }

    //auxiliar inciso d
    public Album buscarAlbum(String nombreAlbum) {
        Album album = null;
        boolean encontrado = false;
        int i = 0;

        while(!encontrado && i < albumes.size()) {
            Album a = albumes.get(i);
            if (a.getTitulo().equals(nombreAlbum)) {
                album = a;
                encontrado = true;
            }
            i++;
        }

        return album;
    }

    // auxiliar: agregar un album al artista
    public boolean agregarAlbum(Album a) {
        return albumes.add(a);
    }

    //auxiliar inciso e
    public ArrayDeque<Cancion> obtenerNCanciones(int n) {
        ArrayDeque<Cancion> canciones = new ArrayDeque<>();
        int i;
        int cancionesAnnadidas = 0;

        for (Album a: albumes) {
            i = 0;
            ArrayList<Cancion> cancionesAlbum = a.getCanciones();
            while(cancionesAnnadidas < n && i < cancionesAlbum.size()) {
                Cancion c = cancionesAlbum.get(i);
                canciones.offerLast(c);
                i++;
                cancionesAnnadidas++;
            }
        }

        return canciones;
    }

    public void mostrarAlbumesYCanciones(){
        for (Album a: albumes) {
            System.out.println(a.getTitulo() + ": ");
            a.mostrarCanciones();
            System.out.println();
        }
    }
}
