public class BibliotecaEspecializada extends Biblioteca {
    private TipoLibro tipoEspecializado;

    public BibliotecaEspecializada(String nombre, String director, int capacidadCatalogo, TipoLibro tipoEspecializado) {
        super(nombre, director, capacidadCatalogo);
        this.tipoEspecializado = tipoEspecializado;
    }

    @Override
    public void agregarLibro(Libro libro) {
        if (libro instanceof LibroTerror && tipoEspecializado != TipoLibro.TERROR) {
            System.out.println("Esta biblioteca solo acepta libros de tipo " + tipoEspecializado);
            return;
        }
        if (libro instanceof LibroComedia && tipoEspecializado != TipoLibro.COMEDIA) {
            System.out.println("Esta biblioteca solo acepta libros de tipo " + tipoEspecializado);
            return;
        }
        if (libro instanceof LibroPoliciaca && tipoEspecializado != TipoLibro.POLICIACA) {
            System.out.println("Esta biblioteca solo acepta libros de tipo " + tipoEspecializado);
            return;
        }
        super.agregarLibro(libro);
    }
}
