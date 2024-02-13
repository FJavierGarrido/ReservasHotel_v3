package org.iesalandalus.programacion.reservashotel.modelo.dominio;

import java.util.Objects;

public class Habitacion {
    public static final double MIN_PRECIO_HABITACION=40.0;
    public static final double MAX_PRECIO_HABITACION=150.0;
    public static final int MIN_NUMERO_PUERTA=1;
    public static final int MAX_NUMERO_PUERTA=15;
    public static final int MIN_NUMERO_PLANTA=1;
    public static final int MAX_NUMERO_PLANTA=3;

    private String identificador;
    private int planta;
    private int puerta;
    private double precio;
    private TipoHabitacion tipoHabitacion;


    public Habitacion(int planta, int puerta, double precio, TipoHabitacion tipoHabitacion) {
        setPlanta(planta);
        setPrecio(precio);
        setTipoHabitacion(tipoHabitacion);
        setPuerta(puerta);
        setIdentificador(String.valueOf(planta)+String.valueOf(puerta));
    }


    // Constructor copia
    public Habitacion(Habitacion h){
        if (h==null){
            throw new NullPointerException("ERROR: No es posible copiar una habitación nula.");
        }
       // this.identificador = h.identificador;
        this.planta = h.getPlanta();
        this.puerta = h.getPuerta();
        this.precio = h.getPrecio();
        this.tipoHabitacion = h.getTipoHabitacion();
        this.identificador=h.getIdentificador();

    }



    //Planta
    public int getPlanta() {
        return planta;
    }
    private void setPlanta(int planta) {

        if (planta >= MIN_NUMERO_PLANTA && planta <= MAX_NUMERO_PLANTA) {
            this.planta = planta;
        } else {
            throw new IllegalArgumentException("ERROR: No se puede establecer como planta de una habitación un valor menor que 1 ni mayor que 3.");
        }
    }

    //Puerta
    public int getPuerta() {
        return puerta;
    }
    private void setPuerta(int puerta) {
        if (puerta >= MIN_NUMERO_PUERTA && puerta <= MAX_NUMERO_PUERTA) {
            this.puerta = puerta;

        } else {
            throw new IllegalArgumentException("ERROR: No se puede establecer como puerta de una habitación un valor menor que 1 ni mayor que 15.");
        }
    }

    //Precio
    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {

        if (precio >= MIN_PRECIO_HABITACION && precio <= MAX_PRECIO_HABITACION) {
            this.precio = precio;
        } else {
            throw new IllegalArgumentException("ERROR: No se puede establecer como precio de una habitación un valor menor que 40.0 ni mayor que 150.0.");
        }
    }


    //Tipo de Habitación
    public TipoHabitacion getTipoHabitacion() {
        return tipoHabitacion;
    }
    public void setTipoHabitacion(TipoHabitacion tipoHabitacion) {
        if (tipoHabitacion == null) {
            throw new NullPointerException("ERROR: No se puede establecer un tipo de habitación nula.");
        }
        this.tipoHabitacion = tipoHabitacion;
    }





    //Identificador
    public String getIdentificador() {
        return identificador;
    }
    private void setIdentificador() {
        if (getPlanta() >= MIN_NUMERO_PLANTA && getPlanta() <= MAX_NUMERO_PLANTA &&
                getPuerta() >= MIN_NUMERO_PUERTA && getPuerta() <= MAX_NUMERO_PUERTA) {

            this.identificador = String.valueOf(getPlanta()) + String.valueOf(getPuerta());
        } else {
            throw new IllegalArgumentException("Número de identificador no válido1");
        }
    }
    private void setIdentificador(String identificador) {
        if (getPlanta() >= MIN_NUMERO_PLANTA && getPlanta() <= MAX_NUMERO_PLANTA &&
                getPuerta() >= MIN_NUMERO_PUERTA && getPuerta() <= MAX_NUMERO_PUERTA) {

            this.identificador = String.valueOf(getPlanta()) + String.valueOf(getPuerta());
        } else {
            throw new IllegalArgumentException("Número de identificador no válido2");
        }
    }


    //Método equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Habitacion habitacion = (Habitacion) o;
        return Objects.equals(identificador, habitacion.identificador);
    }

    //Método hashcode
    @Override
    public int hashCode() {
        return Objects.hash(identificador);
    }

    //Método toString
    @Override
    public String toString() {
        return  "identificador=" + getIdentificador() +
                " ("+planta +
                "-" + puerta +
                "), precio habitación=" + precio +
                ", tipo habitación=" + tipoHabitacion;
    }

}
