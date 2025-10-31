import java.util.ArrayList;

public class SelloDiscografico {
    private String nombre;
    private String paisOrigen;
    private int annoFundacion;
    private ArrayList<Artista> artistas;

    public SelloDiscografico(String nombre, String paisOrigen, int annoFundacion) {
        setNombre(nombre);
        setPaisOrigen(paisOrigen);
        setAnnoFundacion(annoFundacion);
        artistas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getPaisOrigen() {
        return paisOrigen;
    }

    public void setPaisOrigen(String paisOrigen) {
        this.paisOrigen = paisOrigen;
    }

    public int getAnnoFundacion() {
        return annoFundacion;
    }

    public void setAnnoFundacion(int annoFundacion) {
        this.annoFundacion = annoFundacion;
    }

    //auxiliar inciso b
    public Cancion getCancionMasReproducida() {
        Cancion cancionMasReproducida = null;
        int maxReproducciones = 0;

        for (Artista a: artistas) {
            Cancion aux = a.getCancionMasReproducida();
            if (aux != null && aux.getCantidadReproducciones() > maxReproducciones) {
                maxReproducciones = aux.getCantidadReproducciones();
                cancionMasReproducida = aux;
            }
        }

        return cancionMasReproducida;
    }

    //auxiliares inciso c
    public boolean borrarArtista(Artista a) {
        return artistas.remove(a);
    }

    public boolean agregarArtista(Artista a) {
        return artistas.add(a);
    }

    public Artista buscarArtista(String nombre) {
        Artista artista = null;
        boolean encontrado = false;
        int i = 0;

        while(!encontrado && i < artistas.size()) {
            Artista aux = artistas.get(i);
            if (aux.getNombreArtistico().equals(nombre)) {
                artista = aux;
                encontrado = true;
            }
            i++;
        }

        return artista;
    }

    public void mostrarArtistasYAlbumes(){
        for(Artista a: artistas) {
            System.out.println(a.getNombreArtistico() + ": ");
            a.mostrarAlbumesYCanciones();
        }
    }
}
