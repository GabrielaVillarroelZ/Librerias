public class LibroComedia extends Libro {
    private String tipoHumor;

    public LibroComedia(String ISBN, String autor, int numeroPaginas, String nombre, String tipoHumor) {
        super(ISBN, autor, numeroPaginas, nombre);
        this.tipoHumor = tipoHumor;
    }

    @Override
    public String obtenerDetalles() {
        return "Nombre: " + getNombre() + ", Autor: " + super.autor + ", Páginas: " + super.numeroPaginas  + ",ISBN: " + super.ISBN;
    }
}
