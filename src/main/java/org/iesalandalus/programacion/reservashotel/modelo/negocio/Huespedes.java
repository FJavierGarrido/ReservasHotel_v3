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

    // M�todo para obtener una copia profunda de la colecci�n
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


    // M�todo para insertar hu�spedes no nulos al final de la colecci�n sin admitir repetidos
    public void insertar(Huesped huesped) {
        Objects.requireNonNull(huesped, "ERROR: No se puede insertar un hu�sped nulo.");
        if (huespedes.contains(huesped)) {
            throw new IllegalArgumentException("ERROR: Ya existe un hu�sped con ese dni.");
        }
        huespedes.add(huesped);
    }


    public Huesped buscar(Huesped huesped) {
        Objects.requireNonNull(huesped, "ERROR: No se puede buscar un hu�sped nulo.");
        int indice = huespedes.indexOf(huesped);
        return (indice != -1) ? huespedes.get(indice) : null;
    }

    // M�todo para buscar un hu�sped en la colecci�n
    public boolean borrar(Huesped huesped) {
        Objects.requireNonNull(huesped, "ERROR: No se puede borrar un hu�sped nulo.");
        return huespedes.remove(huesped);
    }

}
