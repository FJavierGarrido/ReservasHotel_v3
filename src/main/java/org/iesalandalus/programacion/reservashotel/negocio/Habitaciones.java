package org.iesalandalus.programacion.reservashotel.negocio;

import org.iesalandalus.programacion.reservashotel.dominio.Habitacion;

import javax.naming.OperationNotSupportedException;

public class Habitaciones {

    private int capacidad;
    private int tamano;
    private Habitacion[] habitaciones;


    public Habitaciones(int capacidad) {
        if (capacidad <= 0) {
            throw new IllegalArgumentException("ERROR: La capacidad debe ser mayor que cero.");
        }
        this.capacidad = capacidad;
        this.tamano = 0;
        this.habitaciones = new Habitacion[capacidad];
    }

    // Método para obtener una copia profunda de la colección
    public Habitacion[] get() {
        return copiaProfundaHabitaciones();
    }

    private Habitacion[] copiaProfundaHabitaciones() {
        Habitacion[] copia = new Habitacion[tamano];
        for (int i = 0; i < tamano; i++) {
            copia[i] = new Habitacion(habitaciones[i]); // Copia profunda de cada Habitacion
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
    public void insertar(Habitacion habitacion) throws OperationNotSupportedException {
        if (habitacion == null) {
            throw new NullPointerException("ERROR: No se puede insertar una habitación nula.");
        }
        if (contieneHabitacion(habitacion)){
            throw new OperationNotSupportedException("ERROR: Ya existe una habitación con ese identificador.");
        }
        if (tamanoSuperado(tamano)){
            throw new OperationNotSupportedException("ERROR: No se aceptan más habitaciones.");
        }

        if (!contieneHabitacion(habitacion) && !tamanoSuperado(tamano)) {
            habitaciones[tamano++] = new Habitacion(habitacion); // Copia profunda de la habitación
        } else {
            throw new OperationNotSupportedException("ERROR: Ya existe una habitación con ese identificador.");
        }
    }

    private boolean contieneHabitacion(Habitacion habitacion) {
        for (int i = 0; i < tamano; i++) {
            if (habitaciones[i].equals(habitacion)) {
                return true;
            }
        }
        return false;
    }

    // Método para buscar una habitación en la colección
    public Habitacion buscar(Habitacion habitacion) {
        int indice = buscarIndice(habitacion);
        return (indice != -1) ? habitaciones[indice] : null;
    }

    private int buscarIndice(Habitacion habitacion) {
        for (int i = 0; i < tamano; i++) {
            if (habitaciones[i].equals(habitacion)) {
                return i;
            }
        }
        return -1;
    }

    // Método para borrar una habitación de la colección
    public void borrar(Habitacion habitacion) throws OperationNotSupportedException {
        if (habitacion == null) {
            throw new NullPointerException("ERROR: No se puede borrar una habitación nula.");
        }

        if (!contieneHabitacion(habitacion)) {
            throw new OperationNotSupportedException("ERROR: No existe ninguna habitación como la indicada.");
        }

        int indice = buscarIndice(habitacion);
        if (indice != -1) {
            desplazarUnaPosicionHaciaIzquierda(indice);
            tamano--;
        }
    }

    private void desplazarUnaPosicionHaciaIzquierda(int indice) {
        for (int i = indice; i < tamano - 1; i++) {
            habitaciones[i] = habitaciones[i + 1];
        }
        habitaciones[tamano - 1] = null;
    }

    private boolean tamanoSuperado(int indice) {
        return indice >= capacidad;
    }









}
