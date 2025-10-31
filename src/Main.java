import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {

        System.out.println("Creando plataforma");
        PlataformaMusical plataforma = new PlataformaMusical("MusicApp", 2023);
        
        System.out.println("Nombre: " + plataforma.getNombre());
        System.out.println("Año de creación: " + plataforma.getAnnoCreacion());
        System.out.println();

        SelloDiscografico sello1 = new SelloDiscografico("Sony Music", "Estados Unidos", 1950);
        SelloDiscografico sello2 = new SelloDiscografico("Universal Music", "Estados Unidos", 1960);
        
        Artista artista1 = new Artista("Juan Pérez", "Pop", "España");
        Artista artista2 = new Artista("María García", "Rock", "México");
        
        Cancion cancion1 = new Cancion("Canción 1", 3.5f, 1, 1000);
        Cancion cancion2 = new Cancion("Canción 2", 4.0f, 2, 2000);
        Cancion cancion3 = new Cancion("Canción 3", 3.8f, 1, 1500);

        Album album1 = new Album("Album 1", 2023, "Pop", 2);
        album1.agregarCancion(cancion1);
        album1.agregarCancion(cancion2);
        
        Album album2 = new Album("Album 2", 2023, "Rock", 1);
        album2.agregarCancion(cancion3);

        artista1.agregarAlbum(album1);
        artista2.agregarAlbum(album2);
        
        sello1.agregarArtista(artista1);
        sello2.agregarArtista(artista2);

        plataforma.agregarSello(sello1);
        plataforma.agregarSello(sello2);

        System.out.println("Mostrando datos de la plataforma");
        plataforma.mostrarTodosLosDatos();
        
        //test inciso b
        Cancion masReproducida = plataforma.cancionMasReproducida();
        System.out.println("Canción más reproducida " 
            + (masReproducida != null 
                ? masReproducida.getTitulo() 
                : "Ninguna encontrada"));
        System.out.println();

        //test inciso c
        System.out.println("Transfiriendo artista Juan Pérez al sello Universal Music");
        boolean transferExito = plataforma.transferirArtista("Juan Pérez", "Universal Music");
        System.out.println("Resultado: " + transferExito);
        System.out.println("Mostrando datos luego de la tranferencia");
        plataforma.mostrarTodosLosDatos();
        
        //test inciso d
        System.out.println("Añadiendo nuevas canciones al Album 1");
        ArrayList<Cancion> nuevasCanciones = new ArrayList<>();
        nuevasCanciones.add(new Cancion("Nueva Canción 1", 3.5f, 3, 0));
        nuevasCanciones.add(new Cancion("Nueva Canción 2", 3.8f, 4, 0));
        boolean addExito = plataforma.agregarCanciones("Juan Pérez", "Album 1", nuevasCanciones);
        System.out.println("Resultado: " + addExito);
        album1.mostrarCanciones();
        System.out.println();

        //test inciso e
        System.out.println("Creando lista de reproducción");
        List<PedidoListaDeReproduccion> pedidos = new ArrayList<>();
        pedidos.add(new PedidoListaDeReproduccion("Juan Pérez", 3));
        pedidos.add(new PedidoListaDeReproduccion("María García", 1));
        
        ArrayDeque<Cancion> playlist = plataforma.obtenerListaDeReproduccion(pedidos);
        System.out.println("Lista creada con " + playlist.size() + " canciones");
        
        System.out.println("Contenido de la lista:");
        while (!playlist.isEmpty()) {
            Cancion c = playlist.pop();
            System.out.println("- " + c.getTitulo());
        }
    }
}
