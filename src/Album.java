public class Album implements NivelJerarquia {
    private String titulo;
    private int annoLanzamiento;
    private String generoPredominante;
    private int cantidadCanciones;

    public Album(String titulo, int annoLanzamiento, String generoPredominante, int cantidadCanciones) {
        setTitulo(titulo);
        setAnnoLanzamiento(annoLanzamiento);
        setGeneroPredominante(generoPredominante);
        setCantidadCanciones(cantidadCanciones);
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
}
