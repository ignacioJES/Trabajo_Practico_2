package ar.edu.unju.fi.ejercicio2.Main;

import ar.edu.unju.fi.ejercicio2.Model.Efemeride;
import ar.edu.unju.fi.ejercicio2.constantes.Mes;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Efemeride> efemerides = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        while (opcion != 5) {
            System.out.println("\nMenú de acciones:");
            System.out.println("1 - Crear efeméride");
            System.out.println("2 - Mostrar efemérides");
            System.out.println("3 - Eliminar efeméride");
            System.out.println("4 - Modificar efeméride");
            System.out.println("5 - Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    crearEfemeride(efemerides, scanner);
                    break;
                case 2:
                    mostrarEfemerides(efemerides);
                    break;
                case 3:
                    eliminarEfemeride(efemerides, scanner);
                    break;
                case 4:
                    modificarEfemeride(efemerides, scanner);
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                    break;
            }
        }
    }

    private static void crearEfemeride(ArrayList<Efemeride> efemerides, Scanner scanner) {
        System.out.print("Ingrese el código de la efeméride: ");
        int codigo = scanner.nextInt();
        System.out.print("Ingrese el número del mes (1-12): ");
        int numMes = scanner.nextInt();
        while (numMes < 1 || numMes > 12) {
            System.out.print("Número de mes inválido. Ingrese el número del mes (1-12): ");
            numMes = scanner.nextInt();
        }
        Mes mes = Mes.values()[numMes - 1];
        System.out.print("Ingrese el día: ");
        int dia = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        System.out.print("Ingrese el detalle: ");
        String detalle = scanner.nextLine();

        Efemeride efemeride = new Efemeride(codigo, mes, dia, detalle);
        efemerides.add(efemeride);
        System.out.println("Efeméride creada correctamente.");
    }

    private static void mostrarEfemerides(ArrayList<Efemeride> efemerides) {
        System.out.println("\nListado de efemérides:");
        for (Efemeride efemeride : efemerides) {
            System.out.println(efemeride);
        }
    }

    private static void eliminarEfemeride(ArrayList<Efemeride> efemerides, Scanner scanner) {
        System.out.print("Ingrese el código de la efeméride a eliminar: ");
        int codigoEliminar = scanner.nextInt();
        boolean eliminado = efemerides.removeIf(efemeride -> efemeride.getCodigo() == codigoEliminar);
        if (eliminado) {
            System.out.println("Efeméride eliminada correctamente.");
        } else {
            System.out.println("No se encontró ninguna efeméride con el código ingresado.");
        }
    }

    private static void modificarEfemeride(ArrayList<Efemeride> efemerides, Scanner scanner) {
        System.out.print("Ingrese el código de la efeméride a modificar: ");
        int codigoModificar = scanner.nextInt();
        scanner.nextLine();
        boolean modificado = false;
        for (Efemeride efemeride : efemerides) {
            if (efemeride.getCodigo() == codigoModificar) {
                System.out.print("Ingrese el nuevo número del mes (1-12): ");
                int nuevoNumMes = scanner.nextInt();
                while (nuevoNumMes < 1 || nuevoNumMes > 12) {
                    System.out.print("Número de mes inválido. Ingrese el número del mes (1-12): ");
                    nuevoNumMes = scanner.nextInt();
                }
                Mes nuevoMes = Mes.values()[nuevoNumMes - 1];
                System.out.print("Ingrese el nuevo día: ");
                int nuevoDia = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer
                System.out.print("Ingrese el nuevo detalle: ");
                String nuevoDetalle = scanner.nextLine();

                efemeride.setMes(nuevoMes);
                efemeride.setDia(nuevoDia);
                efemeride.setDetalle(nuevoDetalle);
                modificado = true;
                System.out.println("Efeméride modificada correctamente.");
                break;
            }
        }
        if (!modificado) {
            System.out.println("No se encontró ninguna efeméride con el código ingresado.");
        }
    }
}
