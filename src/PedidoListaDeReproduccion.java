public class PedidoListaDeReproduccion {
    private String nombreArtista;
    private int cantidadCanciones;

    public PedidoListaDeReproduccion(String nombreArtista, int cantidadCanciones) {
        setNombreArtista(nombreArtista);
        setCantidadCanciones(cantidadCanciones);
    }

    public String getNombreArtista() {
        return nombreArtista;
    }

    public void setNombreArtista(String nombreArtista) {
        this.nombreArtista = nombreArtista;
    }

    public int getCantidadCanciones() {
        return cantidadCanciones;
    }

    public void setCantidadCanciones(int cantidadCanciones) {
        this.cantidadCanciones = cantidadCanciones;
    }
}
