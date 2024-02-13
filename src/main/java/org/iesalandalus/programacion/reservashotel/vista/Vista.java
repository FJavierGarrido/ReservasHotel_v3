package org.iesalandalus.programacion.reservashotel.vista;

import org.iesalandalus.programacion.reservashotel.controlador.Controlador;
import org.iesalandalus.programacion.reservashotel.modelo.dominio.Habitacion;
import org.iesalandalus.programacion.reservashotel.modelo.dominio.Huesped;
import org.iesalandalus.programacion.reservashotel.modelo.dominio.Reserva;
import org.iesalandalus.programacion.reservashotel.modelo.dominio.TipoHabitacion;
import org.iesalandalus.programacion.reservashotel.modelo.negocio.Habitaciones;
import org.iesalandalus.programacion.reservashotel.modelo.negocio.Huespedes;
import org.iesalandalus.programacion.reservashotel.modelo.negocio.Reservas;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Vista {

    private Controlador controlador;
    private Habitaciones habitaciones;
    private Huespedes huespedes;
    private Reservas reservas;

    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }

    public void comenzar() {
        Opcion opcion;
        do {
            Consola.mostrarMenu();
            opcion = Consola.elegirOpcion();
            ejecutarOpcion(opcion);
        } while (opcion != Opcion.SALIR);
    }

    public void terminar() {
        System.out.println("Hasta luego.");
    }

    private void ejecutarOpcion(Opcion opcion) {
        switch (opcion) {
            case INSERTAR_HUESPED:
                insertarHuesped();
                break;
            case BUSCAR_HUESPED:
                buscarHuesped();
                break;
            case BORRAR_HUESPED:
                borrarHuesped();
                break;
            case MOSTRAR_HUESPED:
                mostrarHuespedes();
                break;
            case INSERTAR_HABITACION:
                insertarHabitacion();
                break;
            case BUSCAR_HABITACION:
                buscarHabitacion();
                break;
            case BORRAR_HABITACION:
                borrarHabitacion();
                break;
            case MOSTRAR_HABITACIONES:
                mostrarHabitaciones();
                break;
            case INSERTAR_RESERVA:
                insertarReserva();
                break;
            /*case ANULAR_RESERVA:
                anularReserva();
                break;*/
            case MOSTRAR_RESERVAS:
                mostrarReservas();
                break;
            /*case CONSULTAR_DISPONIBILIDAD:
                consultarDisponibilidad();
                break;
            case REALIZAR_CHECKIN:
                realizarCheckin();
                break;
            case REALIZAR_CHECKOUT:
                realizarCheckout();
                break;*/
            case SALIR:
                terminar();
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }

    // Métodos para realizar las diferentes operaciones

    private void insertarHuesped() {
        try {
            Huesped huesped = Consola.leerHuesped();
            huespedes.insertar(huesped);
            System.out.println("Huesped insertado correctamente.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void buscarHuesped() {
        try {
            Huesped huesped = Consola.getHuespedPorDni();
            Huesped huespedEncontrado = huespedes.buscar(huesped);
            if (huespedEncontrado != null) {
                System.out.println(huespedEncontrado);
            } else {
                System.out.println("No se encontró el huésped.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void borrarHuesped() {
        try {
            Huesped huesped = Consola.getHuespedPorDni();
            huespedes.borrar(huesped);
            System.out.println("Huesped borrado correctamente.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    private void mostrarHuespedes() {
        List<Huesped> listaHuespedes = huespedes.get();
        if (!listaHuespedes.isEmpty()) {
            Huesped[] arrayHuespedes = listaHuespedes.toArray(new Huesped[0]);
            Arrays.sort(arrayHuespedes, Comparator.comparing(Huesped::getDni));
            for (Huesped huesped : arrayHuespedes) {
                System.out.println(huesped);
            }
        } else {
            System.out.println("No hay huéspedes registrados.");
        }
    }

    private void insertarHabitacion() {
        try {
            Habitacion habitacion = Consola.leerHabitacion();
            habitaciones.insertar(habitacion);
            System.out.println("Habitación insertada correctamente.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void buscarHabitacion() {
        try {
            Habitacion habitacion = Consola.leerHabitacionPorIdentificador();
            Habitacion habitacionEncontrada = habitaciones.buscar(habitacion);
            if (habitacionEncontrada != null) {
                System.out.println(habitacionEncontrada);
            } else {
                System.out.println("No se encontró la habitación.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void borrarHabitacion() {
        try {
            Habitacion habitacion = Consola.leerHabitacionPorIdentificador();
            habitaciones.borrar(habitacion);
            System.out.println("Habitación borrada correctamente.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void mostrarHabitaciones() {
        Habitacion[] listaHabitaciones = habitaciones.get().toArray(new Habitacion[0]);
        if (listaHabitaciones.length > 0) {
            Arrays.sort(listaHabitaciones, Comparator.comparing(Habitacion::getIdentificador));
            for (Habitacion habitacion : listaHabitaciones) {
                System.out.println(habitacion);
            }
        } else {
            System.out.println("No hay habitaciones registradas.");
        }
    }


    private void insertarReserva() {
        try {
            Reserva reserva = Consola.leerReserva();
            reservas.insertar(reserva);
            System.out.println("Reserva insertada correctamente.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /*private void anularReserva() {
        try {
            controlador.borrar();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }*/

    public void mostrarReservas() {
        List<Reserva> listaReservas = reservas.get();
        if (listaReservas.isEmpty()) {
            System.out.println("No hay reservas almacenadas.");
        } else {
            for (Reserva reserva : listaReservas) {
                System.out.println(reserva.toString());
            }
        }
    }


    /*private Habitacion consultarDisponibilidad(TipoHabitacion tipoHabitacion, LocalDate fechaInicio, LocalDate fechaFin) {
        for (Habitacion habitacion : habitaciones.get()) {
            if (habitacion.getTipoHabitacion().equals(tipoHabitacion) &&
                    reservas.get().stream().noneMatch(reserva ->
                            reserva.getHabitacion().equals(habitacion) &&
                                    !reserva.getFechaFinReserva().isBefore(fechaInicio) &&
                                    !reserva.getFechaInicioReserva().isAfter(fechaFin))) {
                return habitacion;
            }
        }
        System.out.println("No hay habitaciones disponibles para el tipo de habitación y fechas indicadas.");
        return null;
    }


    private void realizarCheckin() {
        try {
            Huesped huesped = Consola.getHuespedPorDni();
            reservas.realizarCheckin(huesped);
            System.out.println("Check-in realizado correctamente.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void realizarCheckout() {
        try {
            Huesped huesped = Consola.getHuespedPorDni();
              controlador.realizarCheckout(huesped);
            System.out.println("Check-out realizado correctamente.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }*/


}
