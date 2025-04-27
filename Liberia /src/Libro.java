import java.io.Serializable;

public abstract class Libro implements Serializable {
    public String ISBN;
    public String autor;
    public int numeroPaginas;
    public String nombre;

    public Libro(String ISBN, String autor, int numeroPaginas, String nombre) {
        this.ISBN = ISBN;
        this.autor = autor;
        this.numeroPaginas = numeroPaginas;
        this.nombre = nombre;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getAutor() {
        return autor;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public String getNombre() {
        return nombre;
    }
    @Override
    public String toString() {
        return "ISBN: " + ISBN + ", Autor: " + autor + ", Páginas: " + numeroPaginas;
    }

    public abstract String obtenerDetalles();
}

