public class LibroPoliciaca extends Libro {
    private String trama;
    private String personajes;

    public LibroPoliciaca(String ISBN, String autor, int numeroPaginas, String nombre, String trama, String personajes) {
        super(ISBN, autor, numeroPaginas, nombre);
        this.trama = trama;
        this.personajes = personajes;
    }

    @Override
    public String obtenerDetalles() {
        return "Nombre: " + getNombre() + ", Autor: " + super.autor + ", Páginas: " + super.numeroPaginas + ", Trama: " + trama + ", Personajes: " + personajes + ",ISBN: " + super.ISBN;
    }
}
