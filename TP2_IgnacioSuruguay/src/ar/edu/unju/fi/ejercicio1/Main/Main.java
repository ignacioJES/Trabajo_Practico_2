package ar.edu.unju.fi.ejercicio1.Main;

import java.util.ArrayList;
import java.util.Scanner;
import ar.edu.unju.fi.ejercicio1.Model.Producto;

public class Main {
    public static void main(String[] args) {
        ArrayList<Producto> productos = new ArrayList<>();
        try (Scanner scanner = new Scanner(System.in)) {
            int opcion;
            do {
                System.out.println("Menú de opciones:");
                System.out.println("1 - Crear Producto");
                System.out.println("2 - Mostrar productos");
                System.out.println("3 - Modificar producto");
                System.out.println("4 - Salir");
                System.out.print("Elija una opción: ");
                opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.println("Crear Producto:");
                        System.out.print("Código: ");
                        String codigo = scanner.next();
                        System.out.print("Descripción: ");
                        String descripcion = scanner.next();
                        System.out.print("Precio Unitario: ");
                        double precio = scanner.nextDouble();

                        System.out.println("------ Origen de fabricación ------");
                        for (Producto.OrigenFabricacion origen : Producto.OrigenFabricacion.values()) {
                            System.out.println((origen.ordinal() + 1) + " - " + origen.name());
                        }
                        System.out.print("Elija una opción: ");
                        int origenOption = scanner.nextInt();
                        Producto.OrigenFabricacion origen = Producto.OrigenFabricacion.values()[origenOption - 1];

                        System.out.println("------ Categoría ------");
                        for (Producto.Categoria categoria : Producto.Categoria.values()) {
                            System.out.println((categoria.ordinal() + 1) + " - " + categoria.name());
                        }
                        System.out.print("Elija una opción: ");
                        int categoriaOption = scanner.nextInt();
                        Producto.Categoria categoria = Producto.Categoria.values()[categoriaOption - 1];

                        productos.add(new Producto(codigo, descripcion, precio, origen, categoria));
                        System.out.println("Producto creado con éxito.");
                        break;

                    case 2:
                        System.out.println("Mostrar productos:");
                        for (Producto producto : productos) {
                            System.out.println("Código: " + producto.getCodigo());
                            System.out.println("Descripción: " + producto.getDescripcion());
                            System.out.println("Precio Unitario: " + producto.getPrecioUnitario());
                            System.out.println("Origen de fabricación: " + producto.getOrigenFabricacion());
                            System.out.println("Categoría: " + producto.getCategoria());
                            System.out.println("-------------------------");
                        }
                        break;

                    case 3:
                        System.out.println("Modificar producto:");
                        System.out.print("Ingrese el código del producto a modificar: ");
                        String codigoModificar = scanner.next();

                        for (Producto producto : productos) {
                            if (producto.getCodigo().equals(codigoModificar)) {
                                System.out.print("Nuevo Precio Unitario: ");
                                double nuevoPrecio = scanner.nextDouble();
                                producto.setPrecioUnitario(nuevoPrecio);
                                System.out.println("Producto modificado con éxito.");
                                break;
                            }
                        }
                        break;

                    case 4:
                        System.out.println("Saliendo del programa...");
                        break;

                    default:
                        System.out.println("Opción inválida. Intente de nuevo.");
                }
            } while (opcion != 4);
        }
    }
}