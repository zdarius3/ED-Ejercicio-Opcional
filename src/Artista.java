public class Artista implements NivelJerarquia {
    private String nombreArtistico;
    private String generoPrincipal;
    private String nacionalidad;

    public Artista(String nombreArtistico, String generoPrincipal, String nacionalidad) {
        setNombreArtistico(nombreArtistico);
        setGeneroPrincipal(generoPrincipal);
        setNacionalidad(nacionalidad);
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
}
