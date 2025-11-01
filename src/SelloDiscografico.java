public class SelloDiscografico implements NivelJerarquia {
    private String nombre;
    private String paisOrigen;
    private int annoFundacion;

    public SelloDiscografico(String nombre, String paisOrigen, int annoFundacion) {
        setNombre(nombre);
        setPaisOrigen(paisOrigen);
        setAnnoFundacion(annoFundacion);
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
}
