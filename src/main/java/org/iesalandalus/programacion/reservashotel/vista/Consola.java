package org.iesalandalus.programacion.reservashotel.vista;

import org.iesalandalus.programacion.reservashotel.modelo.dominio.*;
import org.iesalandalus.programacion.reservashotel.modelo.negocio.Huespedes;
import org.iesalandalus.programacion.utilidades.Entrada;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Consola {


    private Consola() {

    }

    public static void mostrarMenu() {
        for (Opcion opcion : Opcion.values()) {
            System.out.println(opcion.toString());
        }
    }

    public static Opcion elegirOpcion() {
        int opcion = 0;
        try {
            do {
                System.out.println("Introduce el n�mero de opci�n: ");
                opcion = Entrada.entero();
            } while (opcion < 0 || opcion >= Opcion.values().length);
        } catch (Exception e) {
            System.out.println("No ha introducido un n�mero correcto del men�: " + e.getMessage());
        }

        // Devuelve la instancia de Opcion correspondiente al valor entero
        return Opcion.values()[opcion];
    }


    public static Huesped leerHuesped() {
        System.out.println("Ingrese el nombre: ");
        String nombre = Entrada.cadena();

        System.out.println("Ingrese el DNI: ");
        String dni = Entrada.cadena();

        System.out.println("Ingrese el email: ");
        String correo = Entrada.cadena();

        System.out.println("Ingrese el tel�fono: ");
        String telefono = Entrada.cadena();

        System.out.println("Ingrese la fecha de nacimiento: ");
        String fechaNacimiento = Entrada.cadena();
        //LocalDate fecha = LocalDate.parse(fechaNacimiento);


        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fecha = LocalDate.parse(fechaNacimiento, formato);



        return new Huesped(nombre, dni, correo, telefono, fecha);
    }

    public static Huesped getHuespedPorDni() {

        System.out.println("Ingrese el DNI: ");
        String dni = Entrada.cadena();

        // Recorre la colecci�n de hu�spedes para buscar el DNI
        for (Huesped huesped : Huespedes.get()) {
            if (huesped.getDni().equals(dni)) {
                // Se encontr� el hu�sped con el DNI proporcionado
                System.out.println("Huesped encontrado:");
                System.out.println("Nombre: " + huesped.getNombre());
                System.out.println("Dni: " + huesped.getDni());
                System.out.println("Correo: " + huesped.getCorreo());
                System.out.println("Tel�fono: " + huesped.getTelefono());
                System.out.println("Fecha de Nacimiento: " + huesped.getFechaNacimiento());
                // Puedes agregar m�s campos seg�n sea necesario
                return huesped;
            }
        }

        // Si no se encuentra un hu�sped con el DNI proporcionado
        System.out.println("No se encontr� ning�n hu�sped con el DNI: " + dni);
        return null;
    }


    public static LocalDate leerFecha(String mensaje) {
        LocalDate fecha = null;
        do {
            System.out.print(mensaje);
            String fechaStr = Entrada.cadena();
            try {
                fecha = LocalDate.parse(fechaStr);
            } catch (Exception e) {
                System.out.println("Formato de fecha incorrecto. Int�ntelo nuevamente.");
            }
        } while (fecha == null);
        return fecha;
    }


    public static Habitacion leerHabitacion() {
        // Pedir datos de la habitaci�n
        System.out.print("Ingrese la planta de la habitaci�n: ");
        int planta = Entrada.entero();
        System.out.print("Ingrese el n�mero de puerta de la habitaci�n: ");
        int puerta = Entrada.entero();
        System.out.print("Ingrese el precio de la habitaci�n: ");
        double precio = Entrada.real();

        System.out.println("Seleccione el tipo de habitaci�n:");
        TipoHabitacion tipoHabitacion = Consola.leerTipoHabitacion();

        // Crear la instancia de la habitaci�n con los datos proporcionados
        Habitacion habitacion = new Habitacion(planta, puerta, precio, tipoHabitacion);
        return habitacion;
    }

    public static Habitacion leerHabitacionPorIdentificador() {
        try {
            System.out.println("Ingrese los datos de identificaci�n de la habitaci�n:");

            System.out.print("N�mero de planta: ");
            int numeroPlanta = Entrada.entero();

            System.out.print("N�mero de puerta: ");
            int numeroPuerta = Entrada.entero();

            double precio=0;

            // Devolver una instancia de Habitaci�n con los datos planta y puerta reales, (precio y tipo ficticio)
            return new Habitacion(numeroPlanta, numeroPuerta,precio, TipoHabitacion.SUITE);

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            // Puedes agregar m�s l�gica seg�n sea necesario
            return null; // o lanzar una excepci�n si prefieres
        }
    }


    public static TipoHabitacion leerTipoHabitacion() {
        TipoHabitacion[] tipos = TipoHabitacion.values();

        System.out.println("Seleccione un tipo de habitaci�n:");

        for (int i = 0; i < tipos.length; i++) {
            System.out.println((i + 1) + ". " + tipos[i]);
        }

        int opcion;
        do {
            System.out.print("Ingrese el n�mero correspondiente: ");
            opcion = Entrada.entero();


            if (opcion < 1 || opcion > tipos.length) {
                System.out.println("Opci�n no v�lida. Intente nuevamente.");
            }
        } while (opcion < 1 || opcion > tipos.length);

        // Devolver la instancia del TipoHabitacion correspondiente
        return tipos[opcion - 1];
    }

    public static Regimen leerRegimen() {
        Regimen[] regimenes = Regimen.values();

        System.out.println("Seleccione un tipo de r�gimen:");

        for (int i = 0; i < regimenes.length; i++) {
            System.out.println((i + 1) + ". " + regimenes[i]);
        }

        int opcion;
        do {
            System.out.print("Ingrese el n�mero correspondiente: ");
            opcion = Entrada.entero();

            // Validar la entrada
            if (opcion < 1 || opcion > regimenes.length) {
                System.out.println("Opci�n no v�lida. Intente nuevamente.");
            }
        } while (opcion < 1 || opcion > regimenes.length);

        // Devolver la instancia del Regimen correspondiente
        return regimenes[opcion - 1];
    }

    public static Reserva leerReserva() {
        try {
            System.out.println("Ingrese los datos de la reserva:");

            Huesped huesped = leerHuesped();
            Habitacion habitacion = leerHabitacion();
            Regimen regimen = leerRegimen();
            LocalDate fechaInicio = leerFecha("Ingrese la fecha de inicio de la reserva (dd/mm/aaa): ");
            LocalDate fechaFin = leerFecha("Ingrese la fecha de fin de la reserva (dd/mm/aaa): ");
            int numeroPersonas = leerNumeroPersonas();

            // Crear la reserva
            Reserva reserva = new Reserva(huesped, habitacion, regimen, fechaInicio, fechaFin, numeroPersonas);

            return reserva;

        } catch (Exception e) {
            System.out.println("Error al ingresar los datos de la reserva: " + e.getMessage());
            return null;
        }
    }




    private static int leerNumeroPersonas() {

        System.out.println("Ingrese el n�mero de personas: ");
        return Entrada.entero();
    }

    public static LocalDateTime leerFechaHora() {
        LocalDateTime fechaHora = null;
        do {
            try {
                System.out.print("Ingrese la fecha y hora en el formato 'dd/MM/yyyy HH:mm': ");
                String fechaHoraStr = Entrada.cadena();
                DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
                fechaHora = LocalDateTime.parse(fechaHoraStr, formato);
            } catch (Exception e) {
                System.out.println("Formato de fecha y hora incorrecto. Inténtelo nuevamente.");
            }
        } while (fechaHora == null);
        return fechaHora;
    }

}


