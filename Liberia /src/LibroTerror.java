public class LibroTerror extends Libro {
    private double calificacion;

    public LibroTerror(String ISBN, String autor, int numeroPaginas, String nombre, double calificacion) {
        super(ISBN, autor, numeroPaginas, nombre);
        this.calificacion = calificacion;
    }

    @Override
    public String obtenerDetalles() {
        return "Nombre: " + getNombre() + ", Autor: " + super.autor + ", Páginas: " + super.numeroPaginas + ", Calificación: " + calificacion + ",ISBN: " + super.ISBN;
    }
}
