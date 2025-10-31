public class Cancion {
    private String titulo;
    private float duracion;
    private int numeroPista;
    private int cantidadReproducciones;

    public Cancion(String titulo, float duracion, int numeroPista, int cantidadReproducciones) {
        setTitulo(titulo);
        setDuracion(duracion);
        setNumeroPista(numeroPista);
        setCantidadReproducciones(cantidadReproducciones);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public float getDuracion() {
        return duracion;
    }

    public void setDuracion(float duracion) {
        this.duracion = duracion;
    }

    public int getNumeroPista() {
        return numeroPista;
    }

    public void setNumeroPista(int numeroPista) {
        this.numeroPista = numeroPista;
    }

    public int getCantidadReproducciones() {
        return cantidadReproducciones;
    }

    public void setCantidadReproducciones(int cantidadReproducciones) {
        this.cantidadReproducciones = cantidadReproducciones;
    }
}
