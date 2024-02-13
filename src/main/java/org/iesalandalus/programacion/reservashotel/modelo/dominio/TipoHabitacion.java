package org.iesalandalus.programacion.reservashotel.modelo.dominio;

public enum TipoHabitacion {

    SIMPLE("SIMPLE", 1),
    DOBLE("DOBLE", 2),
    TRIPLE("TRIPLE", 3),
    SUITE("SUITE", 4);

    private String descripcion;
    private int numeroMaximoPersonas;

    // Constructor
    private TipoHabitacion(String descripcion, int capacidadMaxima) {
        this.descripcion = descripcion;
        this.numeroMaximoPersonas = capacidadMaxima;
    }


    // Método getter para la capacidad máxima
    public int getNumeroMaximoPersonas() {
        return numeroMaximoPersonas;
    }

    // Método toString
    @Override
    public String toString() {
        return descripcion;
    }
}
