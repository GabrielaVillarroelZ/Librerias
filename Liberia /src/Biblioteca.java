import java.util.ArrayList;
import java.util.List;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class Biblioteca {
    private String nombre;
    private String director;
    private List<Libro> catalogo;
    private int capacidadCatalogo;

    public Biblioteca(String nombre, String director, int capacidadCatalogo) {
        this.nombre = nombre;
        this.director = director;
        this.capacidadCatalogo = capacidadCatalogo;
        this.catalogo = new ArrayList<>();
    }

    public void exportarLibros() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombre))) {
            oos.writeObject(catalogo);
            System.out.println("Libros exportados con éxito a " + nombre );
        } catch (IOException e) {
            System.out.println("Error al exportar los libros: " + e.getMessage());
        }
    }

    public void agregarLibro(Libro libro) {
        if (catalogo.size() >= capacidadCatalogo) {
            throw new CatalogoLlenoException("No hay espacio en el catálogo para más libros.");
        }

        for (Libro l : catalogo) {
            if (l.getISBN().equals(libro.getISBN())) {
                System.out.println("El libro ya está en el catálogo.");
                return;
            }
        }
        catalogo.add(libro);
        System.out.println("Libro agregado: " + libro.obtenerDetalles());
    }

    public void eliminarLibro(String ISBN) throws LibroNoEncontradoException {
        for (Libro libro : catalogo) {
            if (libro.getISBN().equals(ISBN)) {
                catalogo.remove(libro);
                System.out.println("Libro eliminado: " + libro.obtenerDetalles());
                return;
            }
        }
        throw new LibroNoEncontradoException("No se encontró un libro con el ISBN: " + ISBN);
    }

    public void buscarLibroPorISBN(String ISBN) throws LibroNoEncontradoException {
        for (Libro libro : catalogo) {
            if (libro.getISBN().equals(ISBN)) {
                System.out.println("Libro encontrado: " + libro.obtenerDetalles());
                return;
            }
        }
        throw new LibroNoEncontradoException("No se encontró un libro con el ISBN: " + ISBN);
    }

    public void mostrarLibros() {
        if (catalogo.isEmpty()) {
            System.out.println("No hay libros en el catálogo.");
            return;
        }
        System.out.println("Libros en el catálogo:");
        for (Libro libro : catalogo) {
            System.out.println(libro.obtenerDetalles());
        }
    }

    public int obtenerNumeroLibros() {
        return catalogo.size();
    }

    public boolean existeCatalogo() {
        return catalogo != null;
    } }


