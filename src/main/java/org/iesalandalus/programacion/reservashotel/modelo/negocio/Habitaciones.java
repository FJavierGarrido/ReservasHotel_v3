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
        this.capacidad = Integer.MAX_VALUE; // Sin límite predeterminado de capacidad
        this.habitaciones = new ArrayList<>();
    }

    public Habitaciones(int capacidad) {
        if (capacidad <= 0) {
            throw new IllegalArgumentException("ERROR: La capacidad debe ser mayor que cero.");
        }
        this.capacidad = capacidad;
        this.habitaciones = new ArrayList<>();
    }
    // Método para obtener una copia profunda de la colección

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

    // Método para insertar habitaciones no nulas al final de la colección sin admitir repetidos
    public void insertar(Habitacion habitacion) {
        Objects.requireNonNull(habitacion, "ERROR: No se puede insertar una habitación nula.");
        if (contieneHabitacion(habitacion)) {
            throw new IllegalArgumentException("ERROR: Ya existe una habitación con ese identificador.");
        }
        if (tamanoSuperado()) {
            throw new IllegalArgumentException("ERROR: No se aceptan más habitaciones.");
        }

        habitaciones.add(new Habitacion(habitacion)); // Copia profunda de la habitación
    }


    private boolean contieneHabitacion(Habitacion habitacion) {
        return habitaciones.contains(habitacion);
    }

    // Método para buscar una habitación en la colección
    public Habitacion buscar(Habitacion habitacion) {
        int indice = habitaciones.indexOf(habitacion);
        return (indice != -1) ? habitaciones.get(indice) : null;
    }


    // Método para borrar una habitación de la colección
    public void borrar(Habitacion habitacion) {
        Objects.requireNonNull(habitacion, "ERROR: No se puede borrar una habitación nula.");

        if (!contieneHabitacion(habitacion)) {
            throw new IllegalArgumentException("ERROR: No existe ninguna habitación como la indicada.");
        }

        habitaciones.remove(habitacion);
    }

    private boolean tamanoSuperado() {
        return habitaciones.size() >= capacidad;
    }

}
