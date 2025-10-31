import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class PlataformaMusical {
    private String nombre;
    private int annoCreacion;
    private ArrayList<SelloDiscografico> sellosDiscograficos;

    public PlataformaMusical(String nombre, int annoCreacion) {
        setNombre(nombre);
        setAnnoCreacion(annoCreacion);
        this.sellosDiscograficos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAnnoCreacion() {
        return annoCreacion;
    }

    public void setAnnoCreacion(int annoCreacion) {
        this.annoCreacion = annoCreacion;
    }

    public ArrayList<SelloDiscografico> getSellos() {
        return sellosDiscograficos;
    }

    public void agregarSello(SelloDiscografico s) {
        sellosDiscograficos.add(s);
    }

    //inciso b: método que determine la canción más reproducida de toda la plataforma
    public Cancion cancionMasReproducida() {
        Cancion cancionMasReproducida = null;
        int maxReproducciones = 0;

        for (SelloDiscografico s: sellosDiscograficos) {
            Cancion aux = s.getCancionMasReproducida();
            if (aux != null && aux.getCantidadReproducciones() > maxReproducciones) {
                maxReproducciones = aux.getCantidadReproducciones();
                cancionMasReproducida = aux;
            }
        }

        return cancionMasReproducida;
    }

    //inciso c: método que permite transferir un artista de un sello discográfico a otro
    public boolean transferirArtista(String nombreArtista, String nombreSelloNuevo) {
        SelloDiscografico selloObjetivo = buscarSello(nombreSelloNuevo);
        Artista artista = buscarYEliminarArtista(nombreArtista);
        boolean exito = false;

        if (artista != null && selloObjetivo != null) {
            selloObjetivo.agregarArtista(artista);
            exito = true;
        }

        return exito;
    }

    private SelloDiscografico buscarSello(String nombre) {
        SelloDiscografico sello = null;
        boolean encontrado = false;
        int i = 0;

        while(!encontrado && i < sellosDiscograficos.size()) {
            SelloDiscografico aux = sellosDiscograficos.get(i);
            if (aux.getNombre().equals(nombre)) {
                sello = aux;
                encontrado = true;
            }
            i++;
        }

        return sello;
    }

    private Artista buscarYEliminarArtista(String nombre) {
        Artista artista = null;
        boolean encontrado = false;
        int i = 0;

        while (!encontrado && i < sellosDiscograficos.size()) {
            SelloDiscografico sello = sellosDiscograficos.get(i);
            artista = sello.buscarArtista(nombre);
            if (artista != null) {
                sello.borrarArtista(artista);
                encontrado = true;
            }
            i++;
        }

        return artista;
    }

    //inciso d: método que permite agregar nuevas canciones y actualizar un álbum específico
    public boolean agregarCanciones(String nombreArtista, String tituloAlbum, ArrayList<Cancion> canciones){
        boolean exito = false;
        Artista artista = buscarArtista(nombreArtista);

        if (artista != null) {
            Album album = artista.buscarAlbum(tituloAlbum);

            if (album != null) {
                album.agregarCanciones(canciones);
                exito = true;
            }
        }
        
        return exito;
    }

    private Artista buscarArtista(String nombre) {
        Artista artista = null;
        boolean encontrado = false;
        int i = 0;

        while (!encontrado && i < sellosDiscograficos.size()) {
            SelloDiscografico sello = sellosDiscograficos.get(i);
            artista = sello.buscarArtista(nombre);
            if (artista != null) {
                encontrado = true;
            }
            i++;
        }

        return artista;
    }

    //inciso e: métodos que permiten obtener una lista de reproducción dado el nombre de diferentes artistas y la cantidad de canciones de cada artista a incluir
    public ArrayDeque<Cancion> obtenerListaDeReproduccion(List<PedidoListaDeReproduccion> pedidos) {
        ArrayDeque<Cancion> lista = new ArrayDeque<>();

        for (PedidoListaDeReproduccion p: pedidos) {
            Artista artista = buscarArtista(p.getNombreArtista());

            if (artista != null) {
                ArrayDeque<Cancion> canciones = artista.obtenerNCanciones(p.getCantidadCanciones());
                while(!canciones.isEmpty()) {
                    Cancion aux = canciones.pollFirst();
                    lista.offerLast(aux);
                }
            }
        }

        return lista;
    }

    public void mostrarTodosLosDatos() {
        for (SelloDiscografico s: sellosDiscograficos) {
            System.out.println(s.getNombre() + ": ");
            s.mostrarArtistasYAlbumes();
        }
    }
}
