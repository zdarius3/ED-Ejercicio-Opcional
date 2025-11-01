import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

import cu.edu.cujae.ceis.tree.TreeNode;
import cu.edu.cujae.ceis.tree.binary.BinaryTreeNode;
import cu.edu.cujae.ceis.tree.general.GeneralTree;
import cu.edu.cujae.ceis.tree.iterators.general.InDepthIterator;

public class PlataformaMusical implements NivelJerarquia {
    private String nombre;
    private int annoCreacion;
    private GeneralTree<NivelJerarquia> arbol;

    public PlataformaMusical(String nombre, int annoCreacion) {
        setNombre(nombre);
        setAnnoCreacion(annoCreacion);
        arbol = new GeneralTree<>();
        arbol.setRoot(new BinaryTreeNode<NivelJerarquia>(this));
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

    public void mostrarDatos() {
        InDepthIterator<NivelJerarquia> it = arbol.inDepthIterator();

        while (it.hasNext()) {
            BinaryTreeNode<NivelJerarquia> nodo = it.nextNode();
            NivelJerarquia info = nodo.getInfo();
            if (info == this) {
                System.out.println("Plataforma Musical: " + getNombre());
                continue;
            } else if (info instanceof SelloDiscografico) {
                SelloDiscografico sello = (SelloDiscografico) info;
                System.out.println("\nSello Discográfico: " + sello.getNombre());
            } else if (info instanceof Artista) {
                Artista artista = (Artista) info;
                System.out.println("  Artista: " + artista.getNombreArtistico());
            } else if (info instanceof Album) {
                Album album = (Album) info;
                System.out.println("    Álbum: " + album.getTitulo());
            } else if (info instanceof Cancion) {
                Cancion cancion = (Cancion) info;
                System.out.println("      Canción: " + cancion.getTitulo());
            }
        }
        System.out.println();
    }

    public boolean agregarSello(SelloDiscografico s) {
        boolean agregado = false;
        BinaryTreeNode<NivelJerarquia> raiz = (BinaryTreeNode<NivelJerarquia>) arbol.getRoot();

        if (raiz != null) {
            agregado = arbol.insertNode(new BinaryTreeNode<NivelJerarquia>(s), raiz);
        }    

        return agregado;
    }

    public boolean agregarArtistaASello(String nombreSello, Artista a) {
        boolean agregado = false;
        BinaryTreeNode<NivelJerarquia> nodoSello = buscarSelloPorNombre(nombreSello);

        if (nodoSello != null) {
            BinaryTreeNode<NivelJerarquia> nodoArtista = new BinaryTreeNode<NivelJerarquia>(a);
            agregado = arbol.insertNode(nodoArtista, nodoSello);
        }

        return agregado;
        
    }

    public boolean agregarAlbumAArtista(String nombreArtista, Album al) {
        boolean agregado = false;
        BinaryTreeNode<NivelJerarquia> nodoArtista = buscarArtistaPorNombre(nombreArtista);

        if (nodoArtista != null) {
            agregado = arbol.insertNode(new BinaryTreeNode<NivelJerarquia>(al), nodoArtista);
        }

        return agregado;
    }

    public boolean agregarCancionAAlbum(String nombreAlbum, Cancion c) {
        boolean agregado = false;
        BinaryTreeNode<NivelJerarquia> nodoAlbum = buscarAlbumPorTitulo(nombreAlbum);

        if (nodoAlbum != null) {
            agregado = arbol.insertNode(new BinaryTreeNode<NivelJerarquia>(c), nodoAlbum);
        }

        return agregado;
    }

    //inciso b: método que determine la canción más reproducida de toda la plataforma
    public Cancion obtenerCancionMasReproducida() {
        List<TreeNode<NivelJerarquia>> canciones = arbol.getLeaves();
        Cancion cancionMasReproducida = null;
        int maxReproducciones = Integer.MIN_VALUE;

        for (TreeNode<NivelJerarquia> c : canciones) {
            NivelJerarquia info = ((BinaryTreeNode<NivelJerarquia>) c).getInfo();

            if (info instanceof Cancion) { // para evitar problemas en caso de que haya algún artista sin canciones
                Cancion actual = (Cancion) info;
                if (actual.getCantidadReproducciones() > maxReproducciones) {
                    cancionMasReproducida = actual;
                    maxReproducciones = actual.getCantidadReproducciones();
                }
            }
            
        }

        return cancionMasReproducida;
    }

    //inciso c: método que permite transferir un artista de un sello discográfico a otro
    public boolean tranferirArtistaASello(String nombreArtista, String nombreSello) {
        boolean transferido = false;
        BinaryTreeNode<NivelJerarquia> nodoArtista = buscarArtistaPorNombre(nombreArtista);

        if (nodoArtista != null) {
            BinaryTreeNode<NivelJerarquia> nodoSelloNuevo = buscarSelloPorNombre(nombreSello);

            if (nodoSelloNuevo != null) {
                arbol.deleteNode(nodoArtista);                 //borrar del árbol
                nodoArtista.setRight(null);                    //borrar referencias a los nodos que le seguían
                arbol.insertNode(nodoArtista, nodoSelloNuevo); //insertar como hijo del sello
                transferido = true;
            }
        }
        
        return transferido;
    }

    private BinaryTreeNode<NivelJerarquia> buscarArtistaPorNombre(String nombre) {
        BinaryTreeNode<NivelJerarquia> artistaEncontrado = null;
        InDepthIterator<NivelJerarquia> it = arbol.inDepthIterator();

        while(it.hasNext() && artistaEncontrado == null) {
            BinaryTreeNode<NivelJerarquia> nodo = it.nextNode();

            if (nodo.getInfo() instanceof Artista) {
                Artista actual = (Artista) nodo.getInfo();

                if (actual.getNombreArtistico().equals(nombre)) {
                    artistaEncontrado = nodo;
                }

            }
        }

        return artistaEncontrado;
    }

    private BinaryTreeNode<NivelJerarquia> buscarSelloPorNombre(String nombre) {
        BinaryTreeNode<NivelJerarquia> selloEncontrado = null;
        InDepthIterator<NivelJerarquia> it = arbol.inDepthIterator();

        while(it.hasNext() && selloEncontrado == null) {
            BinaryTreeNode<NivelJerarquia> nodo = it.nextNode();

            if (nodo.getInfo() instanceof SelloDiscografico) {
                SelloDiscografico actual = (SelloDiscografico) nodo.getInfo();

                if (actual.getNombre().equals(nombre)) {
                    selloEncontrado = nodo;
                }

            }
        }

        return selloEncontrado;
    }

    //inciso d: método que permite agregar nuevas canciones y actualizar un álbum específico
    public boolean agregarCanciones(/*String nombreArtista,*/ String tituloAlbum, ArrayList<Cancion> canciones){
        boolean agregadas = false;
        BinaryTreeNode<NivelJerarquia> nodoAlbum = buscarAlbumPorTitulo(tituloAlbum);

        if (nodoAlbum != null) {
            for (Cancion c: canciones) {
                BinaryTreeNode<NivelJerarquia> nodoCancion = new BinaryTreeNode<>(c);
                arbol.insertNode(nodoCancion, nodoAlbum);
            }
            agregadas = true;
        }
        
        return agregadas;
    }

    private BinaryTreeNode<NivelJerarquia> buscarAlbumPorTitulo(String titulo) {
        BinaryTreeNode<NivelJerarquia> albumEncontrado = null;
        InDepthIterator<NivelJerarquia> it = arbol.inDepthIterator();

        while(it.hasNext() && albumEncontrado == null) {
            BinaryTreeNode<NivelJerarquia> nodo = it.nextNode();

            if (nodo.getInfo() instanceof Album) {
                Album actual = (Album) nodo.getInfo();

                if (actual.getTitulo().equals(titulo)) {
                    albumEncontrado = nodo;
                }

            }
        }

        return albumEncontrado;
    }

    //inciso e: método que permiten obtener una lista de reproducción dado el nombre de diferentes artistas y la cantidad de canciones de cada artista a incluir
    public ArrayDeque<Cancion> obtenerListaDeReproduccion(List<PedidoListaDeReproduccion> pedidos) {
        ArrayDeque<Cancion> lista = new ArrayDeque<>();

        for (PedidoListaDeReproduccion p: pedidos) {
            BinaryTreeNode<NivelJerarquia> nodoArtista = buscarArtistaPorNombre(p.getNombreArtista());

            if (nodoArtista != null) {
                int i = 0;
                int cancionesAnnadidas = 0;
                List<BinaryTreeNode<NivelJerarquia>> albumes = arbol.getSons(nodoArtista);
                while (i < albumes.size()) {
                    int j = 0;
                    List<BinaryTreeNode<NivelJerarquia>> cancionesAlbum = arbol.getSons(albumes.get(i));

                    while (j < cancionesAlbum.size() && cancionesAnnadidas < p.getCantidadCanciones()) {
                        lista.offerLast((Cancion)cancionesAlbum.get(j).getInfo());
                        cancionesAnnadidas++;
                        j++;
                    }
                    i++;
                }
            }
        }

        return lista;
    }
}
