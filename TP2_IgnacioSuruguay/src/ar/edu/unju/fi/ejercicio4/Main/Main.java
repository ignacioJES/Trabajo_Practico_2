package ar.edu.unju.fi.ejercicio4.Main;

import ar.edu.unju.fi.ejercicio4.Model.Jugador;
import ar.edu.unju.fi.ejercicio4.constantes.Posicion;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Jugador> jugadores = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        while (opcion != 5) {
            System.out.println("\nMenú de acciones:");
            System.out.println("1 - Alta de jugador");
            System.out.println("2 - Mostrar todos los jugadores");
            System.out.println("3 - Modificar la posición de un jugador");
            System.out.println("4 - Eliminar un jugador");
            System.out.println("5 - Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    altaJugador(jugadores, scanner);
                    break;
                case 2:
                    mostrarJugadores(jugadores);
                    break;
                case 3:
                    modificarPosicion(jugadores, scanner);
                    break;
                case 4:
                    eliminarJugador(jugadores, scanner);
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

    private static void altaJugador(ArrayList<Jugador> jugadores, Scanner scanner) {
        System.out.print("Ingrese el nombre del jugador: ");
        String nombre = scanner.next();
        System.out.print("Ingrese el apellido del jugador: ");
        String apellido = scanner.next();
        System.out.print("Ingrese la fecha de nacimiento del jugador (yyyy-mm-dd): ");
        LocalDate fechaNacimiento = LocalDate.parse(scanner.next());
        System.out.print("Ingrese la nacionalidad del jugador: ");
        String nacionalidad = scanner.next();
        System.out.print("Ingrese la estatura del jugador: ");
        double estatura = scanner.nextDouble();
        System.out.print("Ingrese el peso del jugador: ");
        double peso = scanner.nextDouble();
        System.out.println("Seleccione la posición del jugador:");
        for (Posicion posicion : Posicion.values()) {
            System.out.println((posicion.ordinal() + 1) + " - " + posicion);
        }
        System.out.print("Opción: ");
        int opcionPosicion = scanner.nextInt();
        Posicion posicion = Posicion.values()[opcionPosicion - 1];

        Jugador jugador = new Jugador(nombre, apellido, fechaNacimiento, nacionalidad, estatura, peso, posicion);
        jugadores.add(jugador);
        System.out.println("Jugador agregado correctamente.");
    }

    private static void mostrarJugadores(ArrayList<Jugador> jugadores) {
        System.out.println("\nListado de jugadores:");
        for (Jugador jugador : jugadores) {
            System.out.println(jugador);
        }
    }

    private static void modificarPosicion(ArrayList<Jugador> jugadores, Scanner scanner) {
        System.out.print("Ingrese el nombre del jugador a modificar: ");
        String nombre = scanner.next();
        System.out.print("Ingrese el apellido del jugador a modificar: ");
        String apellido = scanner.next();

        Iterator<Jugador> iterator = jugadores.iterator();
        boolean encontrado = false;
        while (iterator.hasNext()) {
            Jugador jugador = iterator.next();
            if (jugador.getNombre().equals(nombre) && jugador.getApellido().equals(apellido)) {
                System.out.println("Seleccione la nueva posición del jugador:");
                for (Posicion posicion : Posicion.values()) {
                    System.out.println((posicion.ordinal() + 1) + " - " + posicion);
                }
                System.out.print("Opción: ");
                int opcionPosicion = scanner.nextInt();
                Posicion nuevaPosicion = Posicion.values()[opcionPosicion - 1];
                jugador.setPosicion(nuevaPosicion);
                encontrado = true;
                System.out.println("Posición modificada correctamente.");
                break;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontró ningún jugador con ese nombre y apellido.");
        }
    }

    private static void eliminarJugador(ArrayList<Jugador> jugadores, Scanner scanner) {
        System.out.print("Ingrese el nombre del jugador a eliminar: ");
        String nombreEliminar = scanner.next();
        System.out.print("Ingrese el apellido del jugador a eliminar: ");
        String apellidoEliminar = scanner.next();

        Iterator<Jugador> iterator = jugadores.iterator();
        boolean eliminado = false;
        while (iterator.hasNext()) {
            Jugador jugador = iterator.next();
            if (jugador.getNombre().equals(nombreEliminar) && jugador.getApellido().equals(apellidoEliminar)) {
                iterator.remove();
                eliminado = true;
                System.out.println("Jugador eliminado correctamente.");
                break;
            }
        }

        if (!eliminado) {
            System.out.println("No se encontró ningún jugador con ese nombre y apellido.");
        }
    }
}