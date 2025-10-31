import java.util.ArrayList;
import java.util.List;

public class Album {
    private String titulo;
    private int annoLanzamiento;
    private String generoPredominante;
    private int cantidadCanciones;
    private ArrayList<Cancion> canciones;

    public Album(String titulo, int annoLanzamiento, String generoPredominante, int cantidadCanciones) {
        setTitulo(titulo);
        setAnnoLanzamiento(annoLanzamiento);
        setGeneroPredominante(generoPredominante);
        setCantidadCanciones(cantidadCanciones);
        canciones = new ArrayList<>();
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnnoLanzamiento() {
        return annoLanzamiento;
    }

    public void setAnnoLanzamiento(int annoLanzamiento) {
        this.annoLanzamiento = annoLanzamiento;
    }

    public String getGeneroPredominante() {
        return generoPredominante;
    }

    public void setGeneroPredominante(String generoPredominante) {
        this.generoPredominante = generoPredominante;
    }

    public int getCantidadCanciones() {
        return cantidadCanciones;
    }

    public void setCantidadCanciones(int cantidadCanciones) {
        this.cantidadCanciones = cantidadCanciones;
    }

    public ArrayList<Cancion> getCanciones() {
        return canciones;
    }

    public void agregarCancion(Cancion c) {
        canciones.add(c);
    }

    //auxiliar inciso b
    public Cancion getCancionMasReproducida() {
        Cancion cancionMasReproducida = null;
        int max = 0;

        for (Cancion c: canciones) {
            if (c.getCantidadReproducciones() > max) {
                max = c.getCantidadReproducciones();
                cancionMasReproducida = c;
            }
        }

        return cancionMasReproducida;
    }

    public void agregarCanciones(List<Cancion> cancionesNuevas) {
        canciones.addAll(cancionesNuevas);
    }

    public void mostrarCanciones() {
        for (Cancion c: canciones) {
            System.out.println(c.getTitulo());
        }
    }
}
