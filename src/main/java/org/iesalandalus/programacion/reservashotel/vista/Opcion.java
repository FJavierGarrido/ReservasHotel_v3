package org.iesalandalus.programacion.reservashotel.vista;

public enum Opcion {
    SALIR("Salir"),
    INSERTAR_HUESPED("Insertar Huesped"),
    BUSCAR_HUESPED("Buscar Huesped"),
    BORRAR_HUESPED("Borrar Huesped"),
    MOSTRAR_HUESPED("Mostrar Huesped"),
    INSERTAR_HABITACION("Insertar Habitacion"),
    BUSCAR_HABITACION("Buscar Habitacion"),
    BORRAR_HABITACION("Borrar Habitacion"),
    MOSTRAR_HABITACIONES("Mostrar Habitaciones"),
    INSERTAR_RESERVA("Insertar Reserva"),
    ANULAR_RESERVA("Anular Reserva"),
    MOSTRAR_RESERVAS("Mostrar Reservas"),
    CONSULTAR_DISPONIBILIDAD("Consultar Disponibilidad");

    private String mensajeAMostrar;

    private Opcion(String mensajeAMostrar) {
        this.mensajeAMostrar = mensajeAMostrar;
    }

    public String toString() {
        return ordinal() + " .- " + mensajeAMostrar;
    }
}
