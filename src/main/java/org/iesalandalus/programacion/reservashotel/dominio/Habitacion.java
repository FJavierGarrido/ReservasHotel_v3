package org.iesalandalus.programacion.reservashotel.dominio;

import java.util.Objects;

public class Habitacion {
    public final double MIN_PRECIO_HABITACION=40;
    public final double MAX_PRECIO_HABITACION=150;
    public final int MIN_NUMERO_PUERTA=1;
    public final int MAX_NUMERO_PUERTA=15;
    public final int MIN_NUMERO_PLANTA=1;
    public final int MAX_NUMERO_PLANTA=3;

    private String identificador;
    private int planta;
    private int puerta;
    private double precio;
    private TipoHabitacion tipoHabitacion;
    private String descripcion;


    public Habitacion(int planta, int puerta, double precio, String descripcion) {
        setPlanta(planta);
        setPuerta(puerta);
        setPrecio(precio);
        setDescripcion(descripcion);
    }
    public Habitacion(int planta, int puerta, double precio, TipoHabitacion tipoHabitacion, String descripcion) {
        setPlanta(planta);
        setPuerta(puerta);
        setPrecio(precio);
        setTipoHabitacion(tipoHabitacion);
        setDescripcion(descripcion);
    }

    // Constructor copia
    public Habitacion(Habitacion habitacion){
        this.identificador = habitacion.identificador;
        this.planta = habitacion.planta;
        this.puerta = habitacion.puerta;
        this.precio = habitacion.precio;
        this.tipoHabitacion = habitacion.tipoHabitacion;
        this.descripcion = habitacion.descripcion;
    }



    //Planta
    public int getPlanta() {
        return planta;
    }
    private void setPlanta(int planta) {
        if (planta >= MIN_NUMERO_PLANTA && planta <= MAX_NUMERO_PLANTA) {
            this.planta = planta;
        } else {
            throw new IllegalArgumentException("Número de planta no válido");
        }
    }

    //Puerta
    public int getPuerta() {
        return puerta;
    }
    private void setPuerta(int puerta) {
        if (puerta >= MIN_NUMERO_PUERTA && puerta <= MAX_NUMERO_PUERTA) {
            this.puerta = puerta;
            this.identificador = String.valueOf(planta + puerta);
        } else {
            throw new IllegalArgumentException("Número de puerta no válido");
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
            throw new IllegalArgumentException("Precio no válido");
        }
    }


    //Tipo de Habitación
    public TipoHabitacion getTipoHabitacion() {
        return tipoHabitacion;
    }
    public void setTipoHabitacion(TipoHabitacion tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }


    //Descripción
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    //Identificador
    public String getIdentificador() {
        return identificador;
    }
    private void setIdentificador() {
        planta = getPlanta();
        puerta = getPuerta();

        if (planta >= MIN_NUMERO_PLANTA && planta <= MAX_NUMERO_PLANTA && puerta >= MIN_NUMERO_PUERTA && puerta <= MAX_NUMERO_PUERTA) {

            this.identificador = String.valueOf(planta + puerta);
        } else {
            throw new IllegalArgumentException("Número de planta o puerta no válido");
        }
    }
    private void setIdentificador(String identificador) {
        this.identificador = identificador;
    }


    //Método equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Habitacion that = (Habitacion) o;
        return Objects.equals(identificador, that.identificador);
    }

    //Método hashcode
    @Override
    public int hashCode() {
        return Objects.hash(identificador);
    }

    //Método toString
    @Override
    public String toString() {
        return "Habitación{" +
                "identificador='" + identificador + '\'' +
                ", planta=" + planta +
                ", puerta=" + puerta +
                ", precio=" + precio +
                ", tipo de habitación=" + tipoHabitacion +
                ", descripción='" + descripcion + '\'' +
                '}';
    }

}
