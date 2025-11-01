import java.util.ArrayDeque;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        PlataformaMusical plataforma = new PlataformaMusical("MusicApp", 2023);

        SelloDiscografico sello1 = new SelloDiscografico("Sello1", "Estados Unidos", 1950);
        SelloDiscografico sello2 = new SelloDiscografico("Sello2", "Estados Unidos", 1960);
        SelloDiscografico sello3 = new SelloDiscografico("Sello3", "Cuba", 1970);

        plataforma.agregarSello(sello1);
        plataforma.agregarSello(sello2);
        plataforma.agregarSello(sello3);
        plataforma.mostrarDatos();

        Artista artista1 = new Artista("Artista1", "Rock", "USA");
        Artista artista2 = new Artista("Artista2", "Rock", "USA");
        Artista artista3 = new Artista("Artista3", "Rock", "USA");

        Artista artista4 = new Artista("Artista4", "Rock", "USA");
        Artista artista5 = new Artista("Artista5", "Rock", "USA");
        Artista artista6 = new Artista("Artista6", "Rock", "USA");
        Artista artista7 = new Artista("Artista7", "Rock", "USA");

        plataforma.agregarArtistaASello("Sello1", artista1);
        plataforma.agregarArtistaASello("Sello1", artista2);
        plataforma.agregarArtistaASello("Sello1", artista3);
        plataforma.agregarArtistaASello("Sello2", artista4);
        plataforma.agregarArtistaASello("Sello2", artista5);
        plataforma.agregarArtistaASello("Sello3", artista6);
        plataforma.agregarArtistaASello("Sello3", artista7);
        plataforma.mostrarDatos();

        Album album1 = new Album("Album1", 2000, "Rock", 15);
        Album album2 = new Album("Album2", 2005, "Rock", 12);
        Album album3 = new Album("Album3", 2010, "Rock", 10);
        Album album4 = new Album("Album4", 2010, "Rock", 10);
        Album album5 = new Album("Album5", 2010, "Rock", 10);
        Album album6 = new Album("Album6", 2010, "Rock", 10);
        Album album7 = new Album("Album7", 2010, "Rock", 10);
        Album album8 = new Album("Album8", 2010, "Rock", 10);

        plataforma.agregarAlbumAArtista("Artista1", album1);
        plataforma.agregarAlbumAArtista("Artista2", album2);
        plataforma.agregarAlbumAArtista("Artista3", album3);
        plataforma.agregarAlbumAArtista("Artista4", album4);
        plataforma.agregarAlbumAArtista("Artista5", album5);
        plataforma.agregarAlbumAArtista("Artista6", album6);
        plataforma.agregarAlbumAArtista("Artista7", album7);
        plataforma.agregarAlbumAArtista("Artista7", album8);
        plataforma.mostrarDatos();

        Cancion cancion1 = new Cancion("Cancion1", 3.5f, 1, 500);
        Cancion cancion2 = new Cancion("Cancion2", 3.7f, 2, 510);
        Cancion cancion3 = new Cancion("Cancion3", 2.8f, 1, 501);
        Cancion cancion4 = new Cancion("Cancion4", 3.9f, 2, 700);
        Cancion cancion5 = new Cancion("Cancion5", 4.0f, 1, 500);
        Cancion cancion6 = new Cancion("Cancion6", 2.8f, 1, 501);
        Cancion cancion7 = new Cancion("Cancion7", 3.9f, 2, 999);
        Cancion cancion8 = new Cancion("Cancion8", 4.0f, 1, 500);
        Cancion cancion9 = new Cancion("Cancion9", 2.8f, 1, 501);
        Cancion cancion10 = new Cancion("Cancion10", 3.9f, 2, 700);
        Cancion cancion11 = new Cancion("Cancion11", 4.0f, 1, 500);
        Cancion cancion12 = new Cancion("Cancion12", 2.8f, 1, 501);
        Cancion cancion13 = new Cancion("Cancion13", 3.9f, 2, 700);
        Cancion cancion14 = new Cancion("Cancion14", 4.0f, 1, 500);

        plataforma.agregarCancionAAlbum("Album1", cancion1);
        plataforma.agregarCancionAAlbum("Album1", cancion2);
        plataforma.agregarCancionAAlbum("Album2", cancion3);
        plataforma.agregarCancionAAlbum("Album2", cancion4);
        plataforma.agregarCancionAAlbum("Album3", cancion5);
        plataforma.agregarCancionAAlbum("Album4", cancion6);
        plataforma.agregarCancionAAlbum("Album4", cancion7);
        plataforma.agregarCancionAAlbum("Album5", cancion8);
        plataforma.agregarCancionAAlbum("Album6", cancion9);
        plataforma.agregarCancionAAlbum("Album6", cancion10);
        plataforma.agregarCancionAAlbum("Album7", cancion11);
        plataforma.agregarCancionAAlbum("Album8", cancion12);
        plataforma.agregarCancionAAlbum("Album8", cancion13);
        plataforma.agregarCancionAAlbum("Album8", cancion14);
        plataforma.mostrarDatos();

        Cancion masReproducida = plataforma.obtenerCancionMasReproducida();
        System.out.println("Canción con más reproducciones: " + masReproducida.getTitulo() 
                        + " con " + masReproducida.getCantidadReproducciones() + " reproducciones");

        boolean transferido = plataforma.tranferirArtistaASello("Artista1", "Sello3");
        System.out.println("\nArtista1 tranferido al Sello3: " + transferido);
        plataforma.mostrarDatos();

        ArrayList<Cancion> cancionesNuevas = new ArrayList<>();
        cancionesNuevas.add(new Cancion("Cancion15", 4.0f, 1, 500));
        cancionesNuevas.add(new Cancion("Cancion16", 4.0f, 1, 500));
        cancionesNuevas.add(new Cancion("Cancion17", 4.0f, 1, 500));
        cancionesNuevas.add(new Cancion("Cancion18", 4.0f, 1, 500));

        boolean agregadas = plataforma.agregarCanciones("Album8", cancionesNuevas);
        System.out.println("Canciones 15-18 agregadas al Album8: " + agregadas);
        plataforma.mostrarDatos();

        ArrayList<PedidoListaDeReproduccion> pedidos = new ArrayList<>();
        pedidos.add(new PedidoListaDeReproduccion("Artista1", 1));
        pedidos.add(new PedidoListaDeReproduccion("Artista7", 5));
        pedidos.add(new PedidoListaDeReproduccion("Artista6", 1));

        System.out.println("Obteniendo lista de reproducción con 1 canción de Artista 1, "
                        + "5 de Artista7, y 1 de Artista6");
        ArrayDeque<Cancion> lista = plataforma.obtenerListaDeReproduccion(pedidos);
        while (!lista.isEmpty()) {
            Cancion actual = lista.pollFirst();
            System.out.println("- " + actual.getTitulo());
        }
    }
}
