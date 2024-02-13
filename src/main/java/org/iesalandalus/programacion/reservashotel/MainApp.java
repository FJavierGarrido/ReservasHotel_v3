package org.iesalandalus.programacion.reservashotel;


import org.iesalandalus.programacion.reservashotel.controlador.Controlador;
import org.iesalandalus.programacion.reservashotel.modelo.Modelo;
import org.iesalandalus.programacion.reservashotel.vista.Vista;


public class MainApp {


    public static void main(String[] args) {
        Modelo modelo= new Modelo();
        Vista vista= new Vista();
        Controlador controlador= new Controlador(modelo,vista);
        controlador.comenzar();
    }
}