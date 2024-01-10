package org.iesalandalus.programacion.reservashotel.dominio;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegimenTest {

    private static final String NOMBRE_NO_VALIDO = "El nombre del tipo de régimen no es válido.";
    private static final String INCREMENTO_PRECIO_NO_VALIDO = "El incremento de precio establecido para el régimen no es el correcto.";


    @Test
    void objectosValidosRegimen() {
        assertEquals("SOLO_ALOJAMIENTO", Regimen.SOLO_ALOJAMIENTO.name(), NOMBRE_NO_VALIDO);
        assertEquals("ALOJAMIENTO_DESAYUNO", Regimen.ALOJAMIENTO_DESAYUNO.name(), NOMBRE_NO_VALIDO);
        assertEquals("MEDIA_PENSION", Regimen.MEDIA_PENSION.name(), NOMBRE_NO_VALIDO);
        assertEquals("PENSION_COMPLETA", Regimen.PENSION_COMPLETA.name(), NOMBRE_NO_VALIDO);
    }

    @Test
    void incrementoPrecioValidos() {
        assertEquals(0, Regimen.SOLO_ALOJAMIENTO.getIncrementoPrecio(), INCREMENTO_PRECIO_NO_VALIDO);
        assertEquals(15, Regimen.ALOJAMIENTO_DESAYUNO.getIncrementoPrecio(), INCREMENTO_PRECIO_NO_VALIDO);
        assertEquals(30, Regimen.MEDIA_PENSION.getIncrementoPrecio(), INCREMENTO_PRECIO_NO_VALIDO);
        assertEquals(50, Regimen.PENSION_COMPLETA.getIncrementoPrecio(), INCREMENTO_PRECIO_NO_VALIDO);
    }


}
