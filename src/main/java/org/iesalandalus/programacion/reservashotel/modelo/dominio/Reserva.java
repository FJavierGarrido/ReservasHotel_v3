package org.iesalandalus.programacion.reservashotel.modelo.dominio;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Reserva {
public static final int MAX_NUMERO_MESES_RESERVA=2;
public static final int MAX_HORAS_POSTERIOR_CHECKOUT=12;
public static final String FORMATO_FECHA_RESERVA="dd/MM/yyyy";
public static final String FORMATO_FECHA_HORA_RESERVA = "dd/MM/yyyy HH:mm";  // añadida por error de test


private Huesped huesped;
private Habitacion habitacion;
private Regimen regimen;
private LocalDate fechaInicioReserva;
private LocalDate fechaFinReserva;
private LocalDateTime checkIn;
private LocalDateTime checkOut;


private double precio;
private int numeroPersonas;

private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd/MM/yyyy");


    //Método constructor
    public Reserva(Huesped huesped, Habitacion habitacion, Regimen regimen, LocalDate fechaInicioReserva, LocalDate fechaFinReserva, int numeroPersonas) {
        setHuesped(huesped);
        setHabitacion(habitacion);
        setRegimen(regimen);
        setFechaInicioReserva(fechaInicioReserva);
        setFechaFinReserva(fechaFinReserva);
        setNumeroPersonas(numeroPersonas);
        setPrecio();
    }

    //Constructor copia
    public Reserva(Reserva r) {
        if (r == null) {
            throw new NullPointerException("ERROR: No es posible copiar una reserva nula.");
        }

        setHuesped(new Huesped(r.getHuesped()));
        this.huesped = new Huesped(r.getHuesped());
        this.habitacion = new Habitacion(r.getHabitacion());
        this.regimen = r.getRegimen();
        this.fechaInicioReserva = r.getFechaInicioReserva();
        this.fechaFinReserva = r.getFechaFinReserva();
        this.checkIn = r.getCheckIn();
        this.checkOut = r.getCheckOut();
        this.precio = r.getPrecio();
        this.numeroPersonas = r.getNumeroPersonas();
    }


    // Getter y Setter para huesped
    public Huesped getHuesped() {
        return huesped;
    }

    public void setHuesped(Huesped huesped) {
        if (huesped==null){
            throw new NullPointerException("ERROR: El huésped de una reserva no puede ser nulo.");
        }

        this.huesped = huesped;
    }

    // Getter y Setter para habitacion
    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    // Getter y Setter para regimen
    public Regimen getRegimen() {
        return regimen;
    }

    public void setRegimen(Regimen regimen) {
        this.regimen = regimen;
    }

    // Getter y Setter para fechaInicioReserva
    public LocalDate getFechaInicioReserva() {
        return fechaInicioReserva;
    }

    public void setFechaInicioReserva(LocalDate fechaInicioReserva) {

        if (fechaInicioReserva==null){
            throw new NullPointerException("ERROR: La fecha de inicio de una reserva no puede ser nula.");
        }
        // Validar que la fecha de inicio no sea anterior a hoy
        if (fechaInicioReserva.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("ERROR: La fecha de inicio de la reserva no puede ser anterior al día de hoy.");
        }

        // Validar que la fecha de inicio no sea posterior al número de meses permitido
        LocalDate fechaLimite = LocalDate.now().plusMonths(MAX_NUMERO_MESES_RESERVA);
        if (fechaInicioReserva.isAfter(fechaLimite)) {
            throw new IllegalArgumentException("ERROR: La fecha de inicio de la reserva no puede ser posterior a seis meses.");
        }

        this.fechaInicioReserva = fechaInicioReserva;
    }

    // Getter y Setter para fechaFinReserva
    public LocalDate getFechaFinReserva() {
        return fechaFinReserva;
    }

    public void setFechaFinReserva(LocalDate fechaFinReserva) {
        if (fechaFinReserva==null){
            throw new NullPointerException("ERROR: La fecha de fin de una reserva no puede ser nula.");
        }
        // Validar que la fecha de fin sea posterior a la de inicio
        if (fechaFinReserva==fechaInicioReserva ||  fechaFinReserva.isBefore(fechaInicioReserva)) {
            throw new IllegalArgumentException("ERROR: La fecha de fin de la reserva debe ser posterior a la de inicio.");
        }
        this.fechaFinReserva = fechaFinReserva;
    }

    // Getter y Setter para checkIn
    public LocalDateTime getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDateTime checkIn) {

        if (checkIn == null) {
            throw new NullPointerException("ERROR: El checkin de una reserva no puede ser nulo.");
        }
        if (fechaInicioReserva != null && checkIn.isBefore(fechaInicioReserva.atStartOfDay())) {
            throw new IllegalArgumentException("ERROR: El checkin de una reserva no puede ser anterior a la fecha de inicio de la reserva.");
        }
        this.checkIn = checkIn;

    }

    // Getter y Setter para checkOut
    public LocalDateTime getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalDateTime checkOut) {
        if (checkOut==null){
            throw new NullPointerException("ERROR: El checkout de una reserva no puede ser nulo.");
        }
        if (checkIn != null && checkOut.isBefore(checkIn)) {
            throw new IllegalArgumentException("ERROR: El checkout de una reserva no puede ser anterior al checkin.");
        }

        // Si no hay fecha final, entiende que sale hoy mismo
       if (fechaFinReserva==null){
           fechaFinReserva=LocalDate.now();
       }

        // Validar que el check-out sea como máximo a las 12:00 horas del día de la reserva
        LocalDateTime limiteCheckout = LocalDateTime.of(fechaFinReserva, LocalTime.of(MAX_HORAS_POSTERIOR_CHECKOUT, 0));
        if (checkOut.isAfter(limiteCheckout)) {
            throw new IllegalArgumentException("ERROR: El checkout de una reserva puede ser como máximo 12 horas después de la fecha de fin de la reserva.");
        }
        this.checkOut = checkOut;
    }

    // Getter y Setter para precio
    public Double getPrecio() {
        return precio;
    }
   
    private void setPrecio() {

        if (habitacion == null) {
            throw new NullPointerException("ERROR: La habitación de una reserva no puede ser nula.");
        }
        if (regimen == null) {
            throw new NullPointerException("ERROR: El régimen de una reserva no puede ser nulo.");
        }
        //Clase java.time. Calcula la diferencia entre las fechas
        Period period = Period.between(fechaInicioReserva, fechaFinReserva);

        precio = (habitacion.getPrecio()  +  regimen.getIncrementoPrecio() ) * numeroPersonas * period.getDays(); //obtiene los días


    }

    // Getter y Setter para numeroPersonas
    public int getNumeroPersonas() {
        return numeroPersonas;
    }

    public void setNumeroPersonas(int numeroPersonas) {

        if (numeroPersonas<1){
            throw new IllegalArgumentException("ERROR: El número de personas de una reserva no puede ser menor o igual a 0.");
        }
        if (habitacion != null && numeroPersonas > habitacion.getTipoHabitacion().getNumeroMaximoPersonas()) {
            throw new IllegalArgumentException("ERROR: El número de personas de una reserva no puede superar al máximo de personas establacidas para el tipo de habitación reservada.");
        }
        this.numeroPersonas = numeroPersonas;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reserva reserva = (Reserva) o;
        return Objects.equals(habitacion, reserva.habitacion) && Objects.equals(fechaInicioReserva, reserva.fechaInicioReserva);
    }

    @Override
    public int hashCode() {
        return Objects.hash(habitacion, fechaInicioReserva);
    }


    @Override
    public String toString() {

        String checkInMsg = "";
        if(checkIn == null){
            checkInMsg="No registrado";
        }else{
            checkInMsg = getCheckIn().format(DateTimeFormatter.ofPattern(FORMATO_FECHA_HORA_RESERVA));
        }

        String checkOutMsg = "";
        if(checkIn == null){
            checkOutMsg="No registrado";
        }else{
            checkOutMsg = getCheckOut().format(DateTimeFormatter.ofPattern(FORMATO_FECHA_HORA_RESERVA));
        }

        return  "Huesped: " + huesped.getNombre() +
                " " + huesped.getDni()+
                " Habitación:" + habitacion.getIdentificador() +
                " - " + habitacion.getTipoHabitacion() +
                " Fecha Inicio Reserva: " + getFechaInicioReserva().format(DATE_FORMAT) +
                " Fecha Fin Reserva: " + getFechaFinReserva().format(DATE_FORMAT) +
                " Checkin: " + checkInMsg +
                " Checkout: " + checkOutMsg +
                //" Precio: " + getPrecio().toString().replace(".",",") +
                " Precio: " + String.format("%.2f", getPrecio())+
                " Personas: " + getNumeroPersonas();
    }

}
