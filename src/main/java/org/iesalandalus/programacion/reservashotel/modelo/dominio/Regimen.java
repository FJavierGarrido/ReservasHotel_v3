package org.iesalandalus.programacion.reservashotel.modelo.dominio;

public enum Regimen {

    SOLO_ALOJAMIENTO("SOLO_ALOJAMIENTO", 0),
    ALOJAMIENTO_DESAYUNO("ALOJAMIENTO_DESAYUNO", 15),
    MEDIA_PENSION("MEDIA_PENSION", 30),
    PENSION_COMPLETA("PENSION_COMPLETA", 50);


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
