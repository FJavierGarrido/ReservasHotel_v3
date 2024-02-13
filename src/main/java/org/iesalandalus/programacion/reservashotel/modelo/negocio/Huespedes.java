package org.iesalandalus.programacion.reservashotel.modelo.negocio;

import org.iesalandalus.programacion.reservashotel.modelo.dominio.Huesped;

import javax.naming.OperationNotSupportedException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Huespedes {

    private static List<Huesped> huespedes;


    public Huespedes() {
        this.huespedes = new ArrayList<>();
    }

    // Método para obtener una copia profunda de la colección
    public static List<Huesped> get() {
        return copiaProfundaHuespedes();
    }

    private static List<Huesped> copiaProfundaHuespedes() {
        List<Huesped> copia = new ArrayList<>();
        for (Huesped huesped : huespedes) {
            copia.add(new Huesped(huesped)); // Copia profunda de cada Huesped
        }
        return copia;
    }

    public int getTamano() {
        return huespedes.size();
    }


    // Método para insertar huéspedes no nulos al final de la colección sin admitir repetidos
    public void insertar(Huesped huesped) {
        Objects.requireNonNull(huesped, "ERROR: No se puede insertar un huésped nulo.");
        if (huespedes.contains(huesped)) {
            throw new IllegalArgumentException("ERROR: Ya existe un huésped con ese dni.");
        }
        huespedes.add(huesped);
    }


    public Huesped buscar(Huesped huesped) {
        Objects.requireNonNull(huesped, "ERROR: No se puede buscar un huésped nulo.");
        int indice = huespedes.indexOf(huesped);
        return (indice != -1) ? huespedes.get(indice) : null;
    }

    // Método para buscar un huésped en la colección
    public boolean borrar(Huesped huesped) {
        Objects.requireNonNull(huesped, "ERROR: No se puede borrar un huésped nulo.");
        return huespedes.remove(huesped);
    }

}
