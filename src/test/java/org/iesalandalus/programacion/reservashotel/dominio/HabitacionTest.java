package org.iesalandalus.programacion.reservashotel.dominio;

import org.junit.jupiter.api.Test;

import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class HabitacionTest {
/*
    private static final String CADENA_NO_ESPERADA = "La cadena devuelta no es la esperada.";
    private static final String PLANTA_NO_ESPERADA = "El número de planta devuelta no es la misma que la pasada al constructor.";
    private static final String PUERTA_NO_ESPERADA = "El número de puerta devuelta no es la misma que la pasada al constructor.";
    private static final String PRECIO_HABITACION_NO_ESPERADO = "El precio devuelto no es el mismo que el pasada al constructor.";
    private static final String TIPO_HABITACION_NO_ESPERADA = "El tipo de habitación devuelta no es el mismo que el pasada al constructor.";
    private static final String IDENTIFICADOR_HABITACION_NO_ESPERADO = "El identificador de la habitación no es el esperado.";

    private static final int PLANTA_1=1;
    private static final int PUERTA_0=0;
    private static final int PUERTA_10=10;

    private static final double PRECIO_HABITACION_VALIDO=50;
    private static final TipoHabitacion TIPO_HABITACION_VALIDA=TipoHabitacion.DOBLE;
    private static final String MENSAJE_EXCEPCION_NO_CORRECTO = "El mensaje devuelto por la excepción no es correcto.";
    private static final String OBJETO_DEBERIA_SER_NULO = "No se debería haber creado el objeto habitación.";
    private static final String TIPO_EXCEPCION_NO_CORRECTA = "El tipo de la excepción no es correcto.";

    private static final String PLANTA_INCORRECTA = "Debería haber saltado una excepción indicando que la planta es incorrecta.";
    private static final String ERROR_PLANTA_INCORRECTA= "ERROR: No se puede establecer como planta de una habitación un valor menor que " + Habitacion.MIN_NUMERO_PLANTA + " ni mayor que " + Habitacion.MAX_NUMERO_PLANTA + ".";
    private static final String PUERTA_INCORRECTA="Debería haber saltado una excepción indicando que la puerta es incorrecta.";
    private static final String ERROR_PUERTA_INCORRECTA= "ERROR: No se puede establecer como puerta de una habitación un valor menor que " + Habitacion.MIN_NUMERO_PUERTA + " ni mayor que " + Habitacion.MAX_NUMERO_PUERTA + ".";

    private static final String PRECIO_HABITACION_INCORRECTO= "Debería haber saltado una excepción indicando que el precio de la habitación es incorrecto.";
    private static final String ERROR_PRECIO_HABITACION_INCORRECTO= "ERROR: No se puede establecer como precio de una habitación un valor menor que " + Habitacion.MIN_PRECIO_HABITACION + " ni mayor que " + Habitacion.MAX_PRECIO_HABITACION + ".";

    private static final String TIPO_HABITACION_INCORRECTO = "Debería haber saltado una excepción indicando que el tipo de la habitación es incorrecto.";
    private static final String ERROR_TIPO_HABITACION_NULA="ERROR: No se puede establecer un tipo de habitación nula.";

    private static final String HABITACION_NO_ESPERADA = "La habitación copiada debería ser la misma que la pasada como parámetro.";

    private static final String HABITACION_NULA = "Debería haber saltado una excepción indicando que no se puede copiar una habitación nula.";
    private static final String ERROR_COPIAR_HABITACION_NULA = "ERROR: No es posible copiar una habitación nula.";


    @Test
    public void constructorPlantaValidaPuertaValidaPrecioValidoTipoHabitacionValidaCreaHabitacionCorrectamente() {
        Habitacion habitacion = new Habitacion(PLANTA_1, PUERTA_0, PRECIO_HABITACION_VALIDO, TIPO_HABITACION_VALIDA);
        assertEquals(PLANTA_1, habitacion.getPlanta(), PLANTA_NO_ESPERADA);
        assertEquals(PUERTA_0, habitacion.getPuerta(), PUERTA_NO_ESPERADA);
        assertEquals(PRECIO_HABITACION_VALIDO, habitacion.getPrecio(), PRECIO_HABITACION_NO_ESPERADO);
        assertEquals(TIPO_HABITACION_VALIDA, habitacion.getTipoHabitacion(), TIPO_HABITACION_NO_ESPERADA);
        assertEquals(String.valueOf(PLANTA_1)+PUERTA_0, habitacion.getIdentificador(), IDENTIFICADOR_HABITACION_NO_ESPERADO);

        habitacion = new Habitacion(PLANTA_1, PUERTA_10, PRECIO_HABITACION_VALIDO, TIPO_HABITACION_VALIDA);
        assertEquals(PLANTA_1, habitacion.getPlanta(), PLANTA_NO_ESPERADA);
        assertEquals(PUERTA_10, habitacion.getPuerta(), PUERTA_NO_ESPERADA);
        assertEquals(PRECIO_HABITACION_VALIDO, habitacion.getPrecio(), PRECIO_HABITACION_NO_ESPERADO);
        assertEquals(TIPO_HABITACION_VALIDA, habitacion.getTipoHabitacion(), TIPO_HABITACION_NO_ESPERADA);
        assertEquals(String.valueOf(PLANTA_1)+PUERTA_10, habitacion.getIdentificador(), IDENTIFICADOR_HABITACION_NO_ESPERADO);

    }

    @Test
    public void constructorPlantaNoValidaPuertaValidaPrecioValidoTipoHabitacionValidaLanzaExcepcion() {
        Habitacion habitacion = null;
        try {
            habitacion = new Habitacion(-2, PUERTA_10, PRECIO_HABITACION_VALIDO, TIPO_HABITACION_VALIDA);
            fail(PLANTA_INCORRECTA);
        } catch (IllegalArgumentException e) {
            assertEquals(ERROR_PLANTA_INCORRECTA, e.getMessage(), MENSAJE_EXCEPCION_NO_CORRECTO);
            assertEquals(null, habitacion, OBJETO_DEBERIA_SER_NULO);
        } catch (Exception e) {
            fail(TIPO_EXCEPCION_NO_CORRECTA);
        }

        try {
            habitacion = new Habitacion(0, PUERTA_10, PRECIO_HABITACION_VALIDO, TIPO_HABITACION_VALIDA);
            fail(PLANTA_INCORRECTA);
        } catch (IllegalArgumentException e) {
            assertEquals(ERROR_PLANTA_INCORRECTA, e.getMessage(), MENSAJE_EXCEPCION_NO_CORRECTO);
            assertEquals(null, habitacion, OBJETO_DEBERIA_SER_NULO);
        } catch (Exception e) {
            fail(TIPO_EXCEPCION_NO_CORRECTA);
        }

        try {
            habitacion = new Habitacion(4, PUERTA_10, PRECIO_HABITACION_VALIDO, TIPO_HABITACION_VALIDA);
            fail(PLANTA_INCORRECTA);
        } catch (IllegalArgumentException e) {
            assertEquals(ERROR_PLANTA_INCORRECTA, e.getMessage(), MENSAJE_EXCEPCION_NO_CORRECTO);
            assertEquals(null, habitacion, OBJETO_DEBERIA_SER_NULO);
        } catch (Exception e) {
            fail(TIPO_EXCEPCION_NO_CORRECTA);
        }
    }

    @Test
    public void constructorPlantaValidaPuertaNoValidaPrecioValidoTipoHabitacionValidaLanzaExcepcion() {
        Habitacion habitacion = null;
        try {
            habitacion = new Habitacion(PLANTA_1, -2, PRECIO_HABITACION_VALIDO, TIPO_HABITACION_VALIDA);
            fail(PUERTA_INCORRECTA);
        } catch (IllegalArgumentException e) {
            assertEquals(ERROR_PUERTA_INCORRECTA, e.getMessage(), MENSAJE_EXCEPCION_NO_CORRECTO);
            assertEquals(null, habitacion, OBJETO_DEBERIA_SER_NULO);
        } catch (Exception e) {
            fail(TIPO_EXCEPCION_NO_CORRECTA);
        }

        try {
            habitacion = new Habitacion(PLANTA_1, 15, PRECIO_HABITACION_VALIDO, TIPO_HABITACION_VALIDA);
            fail(PUERTA_INCORRECTA);
        } catch (IllegalArgumentException e) {
            assertEquals(ERROR_PUERTA_INCORRECTA, e.getMessage(), MENSAJE_EXCEPCION_NO_CORRECTO);
            assertEquals(null, habitacion, OBJETO_DEBERIA_SER_NULO);
        } catch (Exception e) {
            fail(TIPO_EXCEPCION_NO_CORRECTA);
        }

    }

    @Test
    public void constructorPlantaValidaPuertaValidaPrecioNoValidoTipoHabitacionValidaLanzaExcepcion() {
        Habitacion habitacion = null;
        try {
            habitacion = new Habitacion(PLANTA_1, PUERTA_0, -2, TIPO_HABITACION_VALIDA);
            fail(PRECIO_HABITACION_INCORRECTO);
        } catch (IllegalArgumentException e) {
            assertEquals(ERROR_PRECIO_HABITACION_INCORRECTO, e.getMessage(), MENSAJE_EXCEPCION_NO_CORRECTO);
            assertEquals(null, habitacion, OBJETO_DEBERIA_SER_NULO);
        } catch (Exception e) {
            fail(TIPO_EXCEPCION_NO_CORRECTA);
        }

        try {
            habitacion = new Habitacion(PLANTA_1, PUERTA_0, 155, TIPO_HABITACION_VALIDA);
            fail(PRECIO_HABITACION_INCORRECTO);
        } catch (IllegalArgumentException e) {
            assertEquals(ERROR_PRECIO_HABITACION_INCORRECTO, e.getMessage(), MENSAJE_EXCEPCION_NO_CORRECTO);
            assertEquals(null, habitacion, OBJETO_DEBERIA_SER_NULO);
        } catch (Exception e) {
            fail(TIPO_EXCEPCION_NO_CORRECTA);
        }

    }

    @Test
    public void constructorPlantaValidaPuertaValidaPrecioValidoTipoHabitacionNoValidaLanzaExcepcion() {
        Habitacion habitacion = null;
        try {
            habitacion = new Habitacion(PLANTA_1, PUERTA_0, PRECIO_HABITACION_VALIDO, null);
            fail(TIPO_HABITACION_INCORRECTO);
        } catch (NullPointerException e) {
            assertEquals(ERROR_TIPO_HABITACION_NULA, e.getMessage(), MENSAJE_EXCEPCION_NO_CORRECTO);
            assertEquals(null, habitacion, OBJETO_DEBERIA_SER_NULO);
        } catch (Exception e) {
            fail(TIPO_EXCEPCION_NO_CORRECTA);
        }

    }

    @Test
    public void constructorHabitacionValidaCopiaHabitacionCorrectamente() {
        Habitacion habitacion1 = new Habitacion(PLANTA_1, PUERTA_0, PRECIO_HABITACION_VALIDO, TIPO_HABITACION_VALIDA);
        Habitacion habitacion2 = new Habitacion(habitacion1);
        assertEquals(habitacion1, habitacion2, HABITACION_NO_ESPERADA);
        assertEquals(PLANTA_1, habitacion2.getPlanta(), PLANTA_NO_ESPERADA);
        assertEquals(PUERTA_0, habitacion2.getPuerta(), PUERTA_NO_ESPERADA);
        assertEquals(PRECIO_HABITACION_VALIDO, habitacion2.getPrecio(), PRECIO_HABITACION_NO_ESPERADO);
        assertEquals(TIPO_HABITACION_VALIDA, habitacion2.getTipoHabitacion(), TIPO_HABITACION_NO_ESPERADA);
        assertEquals(String.valueOf(PLANTA_1)+PUERTA_0, habitacion2.getIdentificador(), IDENTIFICADOR_HABITACION_NO_ESPERADO);
    }

    @Test
    public void constructorHabitacionNulaLanzaExcepcion() {
        Habitacion habitacion = null;

        try {
            habitacion = new Habitacion(null);
            fail(HABITACION_NULA);
        } catch (NullPointerException e) {
            assertEquals(ERROR_COPIAR_HABITACION_NULA, e.getMessage(), MENSAJE_EXCEPCION_NO_CORRECTO);
            assertEquals(null, habitacion, OBJETO_DEBERIA_SER_NULO);
        } catch (Exception e) {
            fail(TIPO_EXCEPCION_NO_CORRECTA);
        }
    }

    @Test
    public void toStringDevuelveLaCadenaEsperada() {
        Habitacion habitacion = new Habitacion(PLANTA_1, PUERTA_0, PRECIO_HABITACION_VALIDO, TIPO_HABITACION_VALIDA);


        assertEquals(String.format("identificador=%s (%d-%d), precio habitación=%s, tipo habitación=%s", habitacion.getIdentificador(), habitacion.getPlanta(), habitacion.getPuerta(), habitacion.getPrecio(), habitacion.getTipoHabitacion()), habitacion.toString(), CADENA_NO_ESPERADA);
    }

*/
}
