package org.example;

import org.example.modelo.EstadoCita;
import org.example.servicio.CitaService;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        CitaService servicio = new CitaService();
        int opcion;

        do {
            System.out.println("\n--- SISTEMA DE CITAS MÉDICAS ---");
            System.out.println("1. Registrar cita");
            System.out.println("2. Listar citas");
            System.out.println("3. Cambiar estado de cita");
            System.out.println("4. Eliminar cita");
            System.out.println("5. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> {
                    System.out.print("Nombre del paciente: ");
                    String nombre = sc.nextLine();
                    System.out.print("Fecha (YYYY-MM-DD): ");
                    LocalDate fecha = LocalDate.parse(sc.nextLine());
                    servicio.registrarCita(nombre, fecha);
                }
                case 2 -> servicio.listarCitas().forEach(System.out::println);

                case 3 -> {
                    System.out.print("ID de la cita: ");
                    int id = sc.nextInt();
                    System.out.print("Nuevo estado (PROGRAMADA / CANCELADA / ATENDIDA): ");
                    EstadoCita estado = EstadoCita.valueOf(sc.next().toUpperCase());

                    if (!servicio.cambiarEstado(id, estado)) {
                        System.out.println(" No se puede cambiar el estado (regla violada o ID inválido).");
                    }
                }
                case 4 -> {
                    System.out.print("ID de la cita a eliminar: ");
                    int id = sc.nextInt();
                    if (!servicio.eliminarCita(id)) {
                        System.out.println(" Cita no encontrada.");
                    }
                }
            }
        } while (opcion != 5);
    }
}
