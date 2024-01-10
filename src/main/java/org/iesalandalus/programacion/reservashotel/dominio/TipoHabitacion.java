package org.iesalandalus.programacion.reservashotel.dominio;

public enum TipoHabitacion {

    SIMPLE("Habitación Simple", 1),
    DOBLE("Habitación Doble", 2),
    TRIPLE("Habitación Triple", 3),
    SUITE("Suite de Lujo", 4);

    private String cadenaAMostrar;

    // Constructor
    private TipoHabitacion(String descripcion, int capacidadMaxima) {
        this.cadenaAMostrar = descripcion + " (Max. " + capacidadMaxima + " personas)";
    }

    // Método getter
    public String getCadenaAMostrar() {
        return cadenaAMostrar;
    }

    // Método toString
    @Override
    public String toString() {
        return cadenaAMostrar;
    }
}
