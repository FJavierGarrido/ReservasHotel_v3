package org.iesalandalus.programacion.reservashotel.modelo.negocio;

import org.iesalandalus.programacion.reservashotel.modelo.dominio.Habitacion;
import org.iesalandalus.programacion.reservashotel.modelo.dominio.Huesped;
import org.iesalandalus.programacion.reservashotel.modelo.dominio.Reserva;
import org.iesalandalus.programacion.reservashotel.modelo.dominio.TipoHabitacion;

import javax.naming.OperationNotSupportedException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Reservas {


    private List<Reserva> reservas;

    public Reservas() {
        this.reservas = new ArrayList<>();
    }

    public List<Reserva> get() {
        return new ArrayList<>(reservas);
    }

    public void insertar(Reserva reserva) {
        Objects.requireNonNull(reserva, "ERROR: No se puede insertar una reserva nula.");
        if (buscar(reserva) != null) {
            throw new IllegalArgumentException("ERROR: Ya existe una reserva igual.");
        }
        reservas.add(reserva);
    }


    private List<Reserva> copiaProfundaReservas() {
        List<Reserva> copiaProfunda = new ArrayList<>();
        for (Reserva reserva : reservas) {
            copiaProfunda.add(new Reserva(reserva));
        }
        return copiaProfunda;
    }


    public Reserva buscar(Reserva reserva) {
        Objects.requireNonNull(reserva, "ERROR: No se pueden buscar reservas de un tipo de habitación nula.");
        int indice = reservas.indexOf(reserva);
        if (indice != -1) {
            return new Reserva(reservas.get(indice));
        }
        return null;
    }

    public boolean borrar(Reserva reserva) {
        return reservas.remove(reserva);
    }

    public List<Reserva> getReservas(Huesped huesped) {
        Objects.requireNonNull(huesped, "ERROR: No se pueden buscar reservas de un huesped nulo.");
        List<Reserva> reservasHuesped = new ArrayList<>();
        for (Reserva reserva : reservas) {
            if (reserva.getHuesped().equals(huesped)) {
                reservasHuesped.add(new Reserva(reserva));
            }
        }
        return reservasHuesped;
    }

    public List<Reserva> getReservas(TipoHabitacion tipoHabitacion) {
        Objects.requireNonNull(tipoHabitacion, "ERROR: No se pueden buscar reservas de un tipo de habitación nula.");
        List<Reserva> reservasTipoHabitacion = new ArrayList<>();
        for (Reserva reserva : reservas) {
            if (reserva.getHabitacion().getTipoHabitacion().equals(tipoHabitacion)) {
                reservasTipoHabitacion.add(new Reserva(reserva));
            }
        }
        return reservasTipoHabitacion;
    }

    public List<Reserva> getReservasFuturas(Habitacion habitacion) {
        Objects.requireNonNull(habitacion, "ERROR: No se pueden buscar reservas de una habitación nula.");
        List<Reserva> reservasFuturas = new ArrayList<>();
        for (Reserva reserva : reservas) {
            if (reserva.getHabitacion().equals(habitacion) &&
                    reserva.getFechaInicioReserva().isAfter(LocalDate.now())) {
                reservasFuturas.add(new Reserva(reserva));
            }
        }
        return reservasFuturas;
    }

    public void realizarCheckin(Reserva reserva, LocalDateTime fecha) {
        Objects.requireNonNull(reserva, "ERROR: No se puede realizar check-in de una reserva nula.");
        Objects.requireNonNull(fecha, "ERROR: La fecha de check-in no puede ser nula.");
        reserva.setCheckIn(fecha);
    }

    public void realizarCheckOut(Reserva reserva, LocalDateTime fecha) {
        Objects.requireNonNull(reserva, "ERROR: No se puede realizar check-out de una reserva nula.");
        Objects.requireNonNull(fecha, "ERROR: La fecha de check-out no puede ser nula.");
        reserva.setCheckOut(fecha);
    }



}


