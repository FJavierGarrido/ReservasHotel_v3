package org.iesalandalus.programacion.reservashotel.modelo;


import org.iesalandalus.programacion.reservashotel.modelo.dominio.Habitacion;
import org.iesalandalus.programacion.reservashotel.modelo.dominio.Huesped;
import org.iesalandalus.programacion.reservashotel.modelo.dominio.Reserva;
import org.iesalandalus.programacion.reservashotel.modelo.dominio.TipoHabitacion;
import org.iesalandalus.programacion.reservashotel.modelo.negocio.Habitaciones;
import org.iesalandalus.programacion.reservashotel.modelo.negocio.Huespedes;
import org.iesalandalus.programacion.reservashotel.modelo.negocio.Reservas;

import javax.naming.OperationNotSupportedException;
import java.time.LocalDateTime;

public class Modelo {

    private Huespedes huespedes;
    private Habitaciones habitaciones;
    private Reservas reservas;

    public Modelo() {
       //encargada de comunicarse con las tres clases que hacen referencia a las colecciones de datos (huéspedes, habitaciones y reservas).
    }

    public void comenzar() {
        // Crear instancias de las clases de negocio
        this.huespedes = new Huespedes();
        this.habitaciones = new Habitaciones();
        this.reservas = new Reservas();
    }

    public void terminar() {
        System.out.println("El modelo ha terminado.");
    }

    public void insertar(Huesped h) throws Exception {
        if(h == null)
        {
            throw new Exception("ERROR: No se puede insertar un huésped nulo.");
        }
        huespedes.insertar(h);
    }

    public void insertar(Habitacion h) throws Exception {
        if(h == null)
        {
            throw new Exception("ERROR: No se puede insertar una habitación nula.");
        }
        habitaciones.insertar(h);
    }

    public void insertarReserva(Reserva r) throws Exception {
        if(r == null)
        {
            throw new Exception("ERROR: No se puede insertar una reserva nula.");
        }
        reservas.insertar(r);
    }

    public Huesped buscar(Huesped huesped) {
        return huespedes.buscar(huesped);
    }

    public Habitacion buscar(Habitacion habitacion) {
        return habitaciones.buscar(habitacion);
    }

    public Reserva buscar(Reserva reserva) {
        return reservas.buscar(reserva);
    }

    public void borrar(Huesped huesped) throws OperationNotSupportedException {
        huespedes.borrar(huesped);
    }

    public void borrar(Habitacion habitacion) throws OperationNotSupportedException {
        habitaciones.borrar(habitacion);
    }

    public void borrar(Reserva reserva) throws OperationNotSupportedException {
        reservas.borrar(reserva);
    }


    public Huesped[] getHuespedes() {
        return Huespedes.get();
    }

    public Habitacion[] getHabitaciones() {
        return habitaciones.get();
    }

    public Habitacion[] getHabitaciones(TipoHabitacion tipoHabitacion) {
        return habitaciones.get();
    }

    public Reserva[] getReservas() {
        return reservas.get();
    }

    public Reserva[] getReservas(Huesped huesped) {
        return reservas.getReservas(huesped);
    }

    public Reserva[] getReservas(TipoHabitacion tipoHabitacion) {
        return reservas.getReservas(tipoHabitacion);
    }

    public Reserva[] getReservasFuturas(Habitacion habitacion) {
        return reservas.getReservasFuturas(habitacion);
    }

    public void realizarCheckin(Reserva reserva, LocalDateTime fecha) {
        reservas.realizarCheckin(reserva, fecha);
    }
    public void realizarCheckout(Reserva reserva, LocalDateTime fecha) {
        reservas.realizarCheckOut(reserva, fecha);
    }

}
