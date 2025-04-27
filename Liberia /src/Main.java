import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Biblioteca biblioteca = null;

        while (true) {
            System.out.println("1. Crear biblioteca");
            System.out.println("2. Buscar libro por ISBN");
            System.out.println("3. Consultar número de libros");
            System.out.println("4. Agregar libro al catálogo");
            System.out.println("5. Eliminar libro");
            System.out.println("6. Mostrar todos los libros");
            System.out.println("7. Exportar libros a archivo");
            System.out.println("8. Salir");
            System.out.print("Selecciona una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre de la biblioteca: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese el nombre del director: ");
                    String director = scanner.nextLine();
                    System.out.print("Ingrese la capacidad del catálogo: ");
                    int capacidad = scanner.nextInt();
                    scanner.nextLine();
                    biblioteca = new Biblioteca(nombre, director, capacidad);
                    System.out.println("Biblioteca creada con éxito.");
                    break;
                case 2:
                    if (biblioteca == null) {
                        System.out.println("Primero debe crear la biblioteca.");
                        break;
                    }
                    System.out.print("Ingrese el ISBN del libro: ");
                    String isbnBuscar = scanner.nextLine();
                    try {
                        biblioteca.buscarLibroPorISBN(isbnBuscar);
                    } catch (LibroNoEncontradoException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    if (biblioteca == null) {
                        System.out.println("Primero debe crear la biblioteca.");
                        break;
                    }
                    System.out.println("Número de libros en el catálogo: " + biblioteca.obtenerNumeroLibros());
                    break;
                case 4:
                    if (biblioteca == null) {
                        System.out.println("Primero debe crear la biblioteca.");
                        break;
                    }
                    System.out.print("Ingrese el tipo de libro (Terror, Comedia, Policiaca): ");
                    String tipo = scanner.nextLine();
                    System.out.print("Ingrese el nombre del libro: ");
                    String nombreLibro = scanner.nextLine();
                    System.out.print("Ingrese el ISBN del libro: ");
                    String ISBN = scanner.nextLine();
                    System.out.print("Ingrese el autor del libro: ");
                    String autor = scanner.nextLine();
                    System.out.print("Ingrese el número de páginas: ");
                    int paginas = scanner.nextInt();
                    scanner.nextLine();

                    Libro libro = null;
                    if (tipo.equalsIgnoreCase("Terror")) {
                        System.out.print("Ingrese la calificación del libro: ");
                        double calificacion = scanner.nextDouble();
                        scanner.nextLine();
                        libro = new LibroTerror(ISBN, autor, paginas, nombreLibro, calificacion);
                    } else if (tipo.equalsIgnoreCase("Comedia")) {
                        System.out.print("Ingrese el tipo de humor: ");
                        String tipoHumor = scanner.nextLine();
                        libro = new LibroComedia(ISBN, autor, paginas, nombreLibro, tipoHumor);
                    } else if (tipo.equalsIgnoreCase("Policiaca")) {
                        System.out.print("Ingrese la trama (misterio o intriga): ");
                        String trama = scanner.nextLine();
                        System.out.print("Ingrese los personajes del libro: ");
                        String personajes = scanner.nextLine();
                        libro = new LibroPoliciaca(ISBN, autor, paginas, nombreLibro, trama, personajes);
                    } else {
                        System.out.println("Tipo de libro no válido.");
                        break;
                    }

                    try {
                        biblioteca.agregarLibro(libro);
                        System.out.println("Libro agregado con éxito.");
                    } catch (CatalogoLlenoException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    if (biblioteca == null) {
                        System.out.println("Primero debe crear la biblioteca.");
                        break;
                    }
                    System.out.print("Ingrese el ISBN del libro a eliminar: ");
                    String isbnEliminar = scanner.nextLine();
                    try {
                        biblioteca.eliminarLibro(isbnEliminar);
                        System.out.println("Libro eliminado con éxito.");
                    } catch (LibroNoEncontradoException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 6:
                    if (biblioteca == null) {
                        System.out.println("Primero debe crear la biblioteca.");
                        break;
                    }
                    biblioteca.mostrarLibros();
                    break;
                case 7:
                    if (biblioteca == null) {
                        System.out.println("Primero debe crear la biblioteca.");
                        break;
                    }
                    biblioteca.exportarLibros();
                    break;
                case 8:
                    System.out.println("Saliendo...");
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}
