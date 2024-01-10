package org.iesalandalus.programacion.reservashotel.dominio;

public enum Regimen {

    SOLO_ALOJAMIENTO("Solo alojamiento", 10),
    ALOJAMIENTO_DESAYUNO("Alojamiento y desayuno", 15),
    MEDIA_PENSION("Media pensión", 20),
    PENSION_COMPLETA("Pensión completa", 25);


    private final String descripcion;
    private final double incrementoPrecio;

    // Constructor
    private Regimen(String descripcion, int incrementoPrecio) {
        this.descripcion = descripcion;
        this.incrementoPrecio = incrementoPrecio;
    }

    // Método getter para la descripción
    public double getIncrementoPrecio() {
        return incrementoPrecio;
    }

    // Método toString
    @Override
    public String toString() {
        return "Régimen{" +
                "descripcion='" + descripcion + '\'' +
                ", incrementoPrecioPorPersona=" + incrementoPrecio +
                '}';
    }

}
