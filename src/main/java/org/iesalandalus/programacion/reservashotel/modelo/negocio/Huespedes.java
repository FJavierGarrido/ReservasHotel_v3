package org.iesalandalus.programacion.reservashotel.modelo.negocio;

import org.iesalandalus.programacion.reservashotel.modelo.dominio.Huesped;

import javax.naming.OperationNotSupportedException;

public class Huespedes {

    private int capacidad;
    private static int tamano;
    private static Huesped[] huespedes;


    public Huespedes(int capacidad) {
        if (capacidad<=0){
            throw new IllegalArgumentException("ERROR: La capacidad debe ser mayor que cero.");
        }

        this.capacidad = capacidad;
        this.tamano = 0;
        this.huespedes = new Huesped[capacidad];
    }

    // Método para obtener una copia profunda de la colección
    public static Huesped[] get() {
        return copiaProfundaHuespedes();
    }

    private static Huesped[] copiaProfundaHuespedes() {
        Huesped[] copia = new Huesped[tamano];
        for (int i = 0; i < tamano; i++) {
            copia[i] = new Huesped(huespedes[i]);  // Copia profunda de cada Huesped
        }
        return copia;
    }

    public int getTamano() {
        return tamano;
    }

    public int getCapacidad() {
        return capacidad;
    }


    // Método para insertar huéspedes no nulos al final de la colección sin admitir repetidos
    public void insertar(Huesped huesped) throws OperationNotSupportedException  {

            if (huesped == null) {
                throw new NullPointerException("ERROR: No se puede insertar un huï¿½sped nulo.");
            }
            if (contieneHuesped(huesped)){
            throw new OperationNotSupportedException("ERROR: Ya existe un huï¿½sped con ese dni.");
            }
            if (tamanoSuperado(tamano)){
            throw new OperationNotSupportedException("ERROR: No se aceptan mï¿½s huï¿½spedes.");
            }

            if (!contieneHuesped(huesped) && !tamanoSuperado(tamano)) {
                huespedes[tamano++] = new Huesped(huesped); // Copia profunda del huésped
            } else {
                throw new OperationNotSupportedException("ERROR: No se aceptan más huéspedes.");
            }

    }

    private boolean contieneHuesped(Huesped huesped) {
        for (int i = 0; i < tamano; i++) {
            if (huespedes[i].equals(huesped)) {
                return true;
            }
        }
        return false;
    }




    // Método para buscar un huésped en la colección
    public Huesped buscar(Huesped huesped) {
        int indice = buscarIndice(huesped);
        return (indice != -1) ? huespedes[indice] : null;
    }

    private int buscarIndice(Huesped huesped) {
        for (int i = 0; i < tamano; i++) {
            if (huespedes[i].equals(huesped)) {
                return i;
            }
        }
        return -1;
    }


    // Método para borrar un huésped de la colección
    public void borrar(Huesped huesped) throws OperationNotSupportedException {

        if (huesped==null){
            throw new NullPointerException("ERROR: No se puede borrar un huï¿½sped nulo.");
        }
        if (!contieneHuesped(huesped)){
            throw new OperationNotSupportedException("ERROR: No existe ningï¿½n huï¿½sped como el indicado.");
        }


        int indice = buscarIndice(huesped);
        if (indice != -1) {
            desplazarUnaPosicionHaciaIzquierda(indice);
            tamano--;
        }
    }

    private void desplazarUnaPosicionHaciaIzquierda(int indice) {
        for (int i = indice; i < tamano - 1; i++) {
            huespedes[i] = huespedes[i + 1];
        }
        huespedes[tamano - 1] = null;
    }

    private boolean tamanoSuperado(int indice) {
            return indice >= capacidad;
        }



}
