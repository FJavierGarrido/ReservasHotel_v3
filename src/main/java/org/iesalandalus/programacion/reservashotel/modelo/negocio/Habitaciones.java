package org.iesalandalus.programacion.reservashotel.modelo.negocio;

import org.iesalandalus.programacion.reservashotel.modelo.dominio.Habitacion;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Habitaciones {

    private int capacidad;
    private int tamano;
    private List<Habitacion> habitaciones;

    public Habitaciones() {
        this.capacidad = Integer.MAX_VALUE; // Sin l�mite predeterminado de capacidad
        this.habitaciones = new ArrayList<>();
    }

    public Habitaciones(int capacidad) {
        if (capacidad <= 0) {
            throw new IllegalArgumentException("ERROR: La capacidad debe ser mayor que cero.");
        }
        this.capacidad = capacidad;
        this.habitaciones = new ArrayList<>();
    }
    // M�todo para obtener una copia profunda de la colecci�n

    public List<Habitacion> get() {
        return copiaProfundaHabitaciones();
    }

    private List<Habitacion> copiaProfundaHabitaciones() {
        List<Habitacion> copia = new ArrayList<>();
        for (Habitacion habitacion : habitaciones) {
            copia.add(new Habitacion(habitacion)); // Copia profunda de cada Habitacion
        }
        return copia;
    }

    public int getTamano() {
        return tamano;
    }

    public int getCapacidad() {
        return capacidad;
    }

    // M�todo para insertar habitaciones no nulas al final de la colecci�n sin admitir repetidos
    public void insertar(Habitacion habitacion) {
        Objects.requireNonNull(habitacion, "ERROR: No se puede insertar una habitaci�n nula.");
        if (contieneHabitacion(habitacion)) {
            throw new IllegalArgumentException("ERROR: Ya existe una habitaci�n con ese identificador.");
        }
        if (tamanoSuperado()) {
            throw new IllegalArgumentException("ERROR: No se aceptan m�s habitaciones.");
        }

        habitaciones.add(new Habitacion(habitacion)); // Copia profunda de la habitaci�n
    }


    private boolean contieneHabitacion(Habitacion habitacion) {
        return habitaciones.contains(habitacion);
    }

    // M�todo para buscar una habitaci�n en la colecci�n
    public Habitacion buscar(Habitacion habitacion) {
        int indice = habitaciones.indexOf(habitacion);
        return (indice != -1) ? habitaciones.get(indice) : null;
    }


    // M�todo para borrar una habitaci�n de la colecci�n
    public void borrar(Habitacion habitacion) {
        Objects.requireNonNull(habitacion, "ERROR: No se puede borrar una habitaci�n nula.");

        if (!contieneHabitacion(habitacion)) {
            throw new IllegalArgumentException("ERROR: No existe ninguna habitaci�n como la indicada.");
        }

        habitaciones.remove(habitacion);
    }

    private boolean tamanoSuperado() {
        return habitaciones.size() >= capacidad;
    }

}
