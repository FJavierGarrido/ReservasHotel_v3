package org.iesalandalus.programacion.reservashotel.negocio;


import org.iesalandalus.programacion.reservashotel.MainApp;
import org.iesalandalus.programacion.reservashotel.dominio.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.naming.OperationNotSupportedException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.fail;

public class ReservasTest {

    private static Huesped huesped1;
    private static Huesped huesped2;
    private static Huesped huesped3;

    private static Habitacion habitacion1;
    private static Habitacion habitacion2;
    private static Habitacion habitacion3;

    private static Reserva reserva1;
    private static Reserva reserva2;
    private static Reserva reserva3;
    private static Reserva reservaRepetida1;

    private static final String NOMBRE_JRJR = "José Ramón Jiménez Reyes";
    private static final String DNI_JRJR = "11223344B";
    private static final String TELEFONO_JRJR = "950112233";
    private static final String CORREO_JRJR = "joseramon.jimenez@iesalandalus.org";
    private static final String NOMBRE_ARDR = "Andrés Rubio Del Río";
    private static final String DNI_ARDR = "22334455Y";
    private static final String TELEFONO_ARDR = "666223344";
    private static final String CORREO_ARDR = "andres.rubio@iesalandalus.org";
    private static final LocalDate FECHA_NACIMIENTO_JRJR=LocalDate.of(2002, 9, 15);
    private static final LocalDate FECHA_NACIMIENTO_ARDR=LocalDate.of(1992, 7, 3);
    private static final String NOMBRE_BE = "Bob Esponja";
    private static final String DNI_BE = "33445566R";
    private static final String TELEFONO_BE = "600334455";
    private static final String CORREO_BE = "bog.esponja@iesalandalus.org";
    private static final LocalDate FECHA_NACIMIENTO_BE=LocalDate.of(1996, 10, 30);

    private static final int PLANTA_1=1;
    private static final int PLANTA_2=2;
    private static final int PLANTA_3=3;
    private static final int PUERTA_0=1;
    private static final int PUERTA_10=10;

    private static final double PRECIO_HABITACION_VALIDO=50;
    private static final TipoHabitacion TIPO_HABITACION_DOBLE_VALIDA=TipoHabitacion.DOBLE;
    private static final TipoHabitacion TIPO_HABITACION_SIMPLE_VALIDA=TipoHabitacion.SIMPLE;
    private static final TipoHabitacion TIPO_HABITACION_SUITE_VALIDA=TipoHabitacion.SUITE;

    private static final Regimen REGIMEN_SOLO_ALOJAMIENTO = Regimen.SOLO_ALOJAMIENTO;
    private static final Regimen REGIMEN_PENSION_COMPLETA=Regimen.PENSION_COMPLETA;
    private static final Regimen REGIMEN_MEDIA_PENSION= Regimen.MEDIA_PENSION;

    private static final LocalDate FECHA_INICIO_FUTURA_VALIDA=LocalDate.now().plusDays(3);
    private static final LocalDate FECHA_FIN_FUTURA_VALIDA=FECHA_INICIO_FUTURA_VALIDA.plusDays(7);

    private static final String RESERVAS_NO_CREADAS = "Debería haber creado las reservas correctamente.";
    private static final String TAMANO_NO_ESPERADO = "El tamaño devuelto no es el esperado.";
    private static final String OPERACION_NO_PERMITIDA = "Debería haber saltado una excepción indicando que dicha operación no está permitida.";
    private static final String ERROR_CAPACIDAD_NO_CORRECTA = "ERROR: La capacidad debe ser mayor que cero.";
    private static final String MENSAJE_EXCEPCION_NO_CORRECTO = "El mensaje devuelto por la excepción no es correcto.";
    private static final String OBJETO_DEBERIA_SER_NULO = "No se debería haber creado el objeto.";
    private static final String TIPO_EXCEPCION_NO_CORRECTO = "El tipo de la excepción no es correcto.";
    private static final String EXCEPCION_NO_PROCEDE = "No debería haber saltado la excepción.";
    private static final String RESERVA_NO_ESPERADA = "La reserva devuelta no es la que debería ser.";

    private static final String REFERENCIA_NO_ESPERADA = "La referencia devuelta es la misma que la pasada.";
    private static final String OPERACION_NO_REALIZADA = "La operación no la ha realizado correctamente.";
    private static final String RESERVA_NULA = "Debería haber saltado una excepción indicando que no se puede operar con una reserva nula.";
    private static final String ERROR_INSERTAR_RESERVA_NULA = "ERROR: No se puede insertar una reserva nula.";
    private static final String ERROR_RESERVA_EXISTE = "ERROR: Ya existe una reserva igual.";
    private static final String ERROR_NO_MAS_RESERVAS = "ERROR: No se aceptan más reservas.";
    private static final String ERROR_RESERVA_BORRAR_NO_EXISTE = "ERROR: No existe ninguna reserva como la indicada.";
    private static final String ERROR_BORRAR_RESERVA_NULA = "ERROR: No se puede borrar una reserva nula.";
    private static final String RESERVAS_HUESPED_NULO="Debería haber saltado una excepción indicando que no se puede operar con un huésped nulo.";
    private static final String ERROR_RESERVAS_HUESPED_NULO="ERROR: No se pueden buscar reservas de un huesped nulo.";
    private static final String RESERVAS_TIPO_HABITACION_NULA="Debería haber saltado una excepción indicando que no se puede operar con un tipo de habitación nula.";
    private static final String ERROR_RESERVAS_TIPO_HABITACION_NULA="ERROR: No se pueden buscar reservas de un tipo de habitación nula.";
    private static final String RESERVAS_HABITACION_NULA="Debería haber saltado una excepción indicando que no se puede operar con una habitación nula.";
    private static final String ERROR_RESERVAS_HABITACION_NULA="ERROR: No se pueden buscar reservas de una habitación nula.";


    @BeforeAll
    public static void asignarValoresAtributos() {
        huesped1 = new Huesped(NOMBRE_JRJR, DNI_JRJR, CORREO_JRJR, TELEFONO_JRJR, FECHA_NACIMIENTO_JRJR);
        huesped2 = new Huesped(NOMBRE_ARDR, DNI_ARDR, CORREO_ARDR, TELEFONO_ARDR, FECHA_NACIMIENTO_ARDR);
        huesped3 = new Huesped(NOMBRE_BE, DNI_BE, CORREO_BE, TELEFONO_BE, FECHA_NACIMIENTO_BE);

        habitacion1 = new Habitacion(PLANTA_1, PUERTA_0, PRECIO_HABITACION_VALIDO, TIPO_HABITACION_SIMPLE_VALIDA);
        habitacion2 = new Habitacion(PLANTA_2, PUERTA_10, PRECIO_HABITACION_VALIDO, TIPO_HABITACION_DOBLE_VALIDA);
        habitacion3 = new Habitacion(PLANTA_3, PUERTA_10, PRECIO_HABITACION_VALIDO, TIPO_HABITACION_SUITE_VALIDA);

        reserva1 = new Reserva(huesped1, habitacion1,REGIMEN_SOLO_ALOJAMIENTO,FECHA_INICIO_FUTURA_VALIDA, FECHA_FIN_FUTURA_VALIDA,1);
        reserva2 = new Reserva(huesped2, habitacion2,REGIMEN_PENSION_COMPLETA,FECHA_INICIO_FUTURA_VALIDA, FECHA_FIN_FUTURA_VALIDA,2);
        reserva3 = new Reserva(huesped3, habitacion3,REGIMEN_MEDIA_PENSION,FECHA_INICIO_FUTURA_VALIDA, FECHA_FIN_FUTURA_VALIDA,3);
        reservaRepetida1 = new Reserva(huesped1, habitacion1,REGIMEN_SOLO_ALOJAMIENTO,FECHA_INICIO_FUTURA_VALIDA, FECHA_FIN_FUTURA_VALIDA,1);

    }

    @Test
    public void constructorCapacidadValidaCreaReservasCorrectamente() {
        Reservas reservas = new Reservas(MainApp.CAPACIDAD);
        assertNotEquals(null, reservas, RESERVAS_NO_CREADAS);
        assertEquals(MainApp.CAPACIDAD, reservas.getCapacidad(), RESERVAS_NO_CREADAS);
        assertEquals(0, reservas.getTamano(), TAMANO_NO_ESPERADO);
    }

    @Test
    public void constructorCapacidadNoValidaLanzaExcepcion() {
        Reservas reservas = null;

        try {
            reservas = new Reservas(0);
            fail(OPERACION_NO_PERMITIDA);
        } catch (IllegalArgumentException e) {
            assertEquals(ERROR_CAPACIDAD_NO_CORRECTA, e.getMessage(), MENSAJE_EXCEPCION_NO_CORRECTO);
            assertEquals(null, reservas, OBJETO_DEBERIA_SER_NULO);
        } catch (Exception e) {
            fail(TIPO_EXCEPCION_NO_CORRECTO);
        }
        try {
            reservas = new Reservas(-1);
            fail(OPERACION_NO_PERMITIDA);
        } catch (IllegalArgumentException e) {
            assertEquals(ERROR_CAPACIDAD_NO_CORRECTA, e.getMessage(), MENSAJE_EXCEPCION_NO_CORRECTO);
            assertEquals(null, reservas, OBJETO_DEBERIA_SER_NULO);
        } catch (Exception e) {
            fail(TIPO_EXCEPCION_NO_CORRECTO);
        }
    }

    @Test
    public void insertarReservaValidaInsertaReservaCorrectamente() {
        Reservas reservas = new Reservas(5);

        try {
            reservas.insertar(reserva1);

            Reserva[] copiaReservas = reservas.get();
            assertEquals(1, reservas.getTamano(), TAMANO_NO_ESPERADO);
            assertEquals(reserva1, reservas.buscar(reserva1), RESERVA_NO_ESPERADA);
            assertNotSame(reserva1, copiaReservas[0], REFERENCIA_NO_ESPERADA);
            assertEquals(reserva1, copiaReservas[0], OPERACION_NO_REALIZADA);
        } catch (OperationNotSupportedException e) {
            fail(EXCEPCION_NO_PROCEDE);
        }
    }

    @Test
    public void insertarDosReservasValidasInsertaReservasCorrectamente() {
        Reservas reservas = new Reservas(5);

        try {
            reservas.insertar(reserva1);
            reservas.insertar(reserva2);

            Reserva[] copiaReservas = reservas.get();
            assertEquals(2, reservas.getTamano(), TAMANO_NO_ESPERADO);
            assertEquals(reserva1, reservas.buscar(reserva1), RESERVA_NO_ESPERADA);
            assertNotSame(reserva1, copiaReservas[0], REFERENCIA_NO_ESPERADA);
            assertEquals(reserva1, copiaReservas[0], OPERACION_NO_REALIZADA);
            assertEquals(reserva2, reservas.buscar(reserva2), RESERVA_NO_ESPERADA);
            assertNotSame(reserva2, copiaReservas[1], REFERENCIA_NO_ESPERADA);
            assertEquals(reserva2, copiaReservas[1], OPERACION_NO_REALIZADA);



        } catch (OperationNotSupportedException e) {


            fail(EXCEPCION_NO_PROCEDE);

        }
    }

    @Test
    public void insertarTresReservasValidasInsertaReservasCorrectamente() {
        Reservas reservas = new Reservas(5);

        try {
            reservas.insertar(reserva1);
            reservas.insertar(reserva2);
            reservas.insertar(reserva3);

            Reserva[] copiaReservas = reservas.get();

            assertEquals(3, reservas.getTamano(), TAMANO_NO_ESPERADO);
            assertEquals(reserva1, reservas.buscar(reserva1), RESERVA_NO_ESPERADA);
            assertNotSame(reserva1, copiaReservas[0], REFERENCIA_NO_ESPERADA);
            assertEquals(reserva1, copiaReservas[0], OPERACION_NO_REALIZADA);
            assertEquals(reserva2, reservas.buscar(reserva2), RESERVA_NO_ESPERADA);
            assertNotSame(reserva2, copiaReservas[1], REFERENCIA_NO_ESPERADA);
            assertEquals(reserva2, copiaReservas[1], OPERACION_NO_REALIZADA);
            assertEquals(reserva3, reservas.buscar(reserva3), RESERVA_NO_ESPERADA);
            assertNotSame(reserva3, copiaReservas[2], REFERENCIA_NO_ESPERADA);
            assertEquals(reserva3, copiaReservas[2], OPERACION_NO_REALIZADA);


        } catch (OperationNotSupportedException e) {
            fail(EXCEPCION_NO_PROCEDE);
        }
    }

    @Test
    public void insertarReservaNulaLanzaExcepcion() {
        Reservas reservas = new Reservas(5);

        try {
            reservas.insertar(null);
            fail(RESERVA_NULA);
        } catch (NullPointerException e) {
            assertEquals(ERROR_INSERTAR_RESERVA_NULA, e.getMessage(), MENSAJE_EXCEPCION_NO_CORRECTO);
            assertEquals(0, reservas.getTamano(), TAMANO_NO_ESPERADO);
        } catch (Exception e) {
            fail(TIPO_EXCEPCION_NO_CORRECTO);
        }
    }

    @Test
    public void insertarReservaRepetidaLanzaExcepcion() {
        Reservas reservas = new Reservas(5);

        try {
            reservas.insertar(reserva1);
            reservas.insertar(reserva2);
            reservas.insertar(reserva3);
            reservas.insertar(reservaRepetida1);
            fail(OPERACION_NO_PERMITIDA);
        } catch (OperationNotSupportedException e) {
            assertEquals(ERROR_RESERVA_EXISTE, e.getMessage(), MENSAJE_EXCEPCION_NO_CORRECTO);
            assertEquals(3, reservas.getTamano(), TAMANO_NO_ESPERADO);
        } catch (Exception e) {
            fail(TIPO_EXCEPCION_NO_CORRECTO);
        }

        reservas = new Reservas(5);
        try {
            reservas.insertar(reserva2);
            reservas.insertar(reserva1);
            reservas.insertar(reserva3);
            reservas.insertar(reservaRepetida1);
            fail(OPERACION_NO_PERMITIDA);
        } catch (OperationNotSupportedException e) {
            assertEquals(ERROR_RESERVA_EXISTE, e.getMessage(), MENSAJE_EXCEPCION_NO_CORRECTO);
            assertEquals(3, reservas.getTamano(), TAMANO_NO_ESPERADO);
        } catch (Exception e) {
            fail(TIPO_EXCEPCION_NO_CORRECTO);
        }

        reservas = new Reservas(5);
        try {
            reservas.insertar(reserva2);
            reservas.insertar(reserva3);
            reservas.insertar(reserva1);
            reservas.insertar(reservaRepetida1);
            fail(OPERACION_NO_PERMITIDA);
        } catch (OperationNotSupportedException e) {
            assertEquals(ERROR_RESERVA_EXISTE, e.getMessage(), MENSAJE_EXCEPCION_NO_CORRECTO);
            assertEquals(3, reservas.getTamano(), TAMANO_NO_ESPERADO);
        } catch (Exception e) {
            fail(TIPO_EXCEPCION_NO_CORRECTO);
        }
    }

    @Test
    public void insertarReservaValidaConReservasLlenoLanzaExcepcion() {
        Reservas reservas = new Reservas(2);

        try {
            reservas.insertar(reserva1);
            reservas.insertar(reserva2);
            reservas.insertar(reserva3);
            fail(OPERACION_NO_PERMITIDA);
        } catch (OperationNotSupportedException e) {
            assertEquals(ERROR_NO_MAS_RESERVAS, e.getMessage(), MENSAJE_EXCEPCION_NO_CORRECTO);
            assertEquals(2, reservas.getTamano(), TAMANO_NO_ESPERADO);
            assertEquals(reserva1, reservas.buscar(reserva1), RESERVA_NO_ESPERADA);
            assertNotSame(reserva1, reservas.buscar(reserva1), REFERENCIA_NO_ESPERADA);
            assertEquals(reserva1, reservas.get()[0], OPERACION_NO_REALIZADA);
            assertEquals(reserva2, reservas.buscar(reserva2), RESERVA_NO_ESPERADA);
            assertNotSame(reserva2, reservas.buscar(reserva2), REFERENCIA_NO_ESPERADA);
            assertEquals(reserva2, reservas.get()[1], OPERACION_NO_REALIZADA);
        } catch (Exception e) {
            fail(TIPO_EXCEPCION_NO_CORRECTO);
        }
    }

    @Test
    public void borrarReservaExistenteBorraReservaCorrectamente() throws OperationNotSupportedException {
        Reservas reservas = new Reservas(5);

        try {
            reservas.insertar(reserva1);
            reservas.borrar(reserva1);
            assertEquals(0, reservas.getTamano(), TAMANO_NO_ESPERADO);
            assertEquals(null, reservas.buscar(reserva1), RESERVA_NO_ESPERADA);
        } catch (Exception e) {
            fail(EXCEPCION_NO_PROCEDE);
        }

        reservas = new Reservas(5);
        try {
            reservas.insertar(reserva1);
            reservas.insertar(reserva2);
            reservas.borrar(reserva1);
            assertEquals(1, reservas.getTamano(), TAMANO_NO_ESPERADO);
            assertEquals(reserva2, reservas.buscar(reserva2), RESERVA_NO_ESPERADA);
            assertEquals(null, reservas.buscar(reserva1), RESERVA_NO_ESPERADA);
        } catch (Exception e) {
            fail(EXCEPCION_NO_PROCEDE);
        }

        reservas = new Reservas(5);
        try {
            reservas.insertar(reserva1);
            reservas.insertar(reserva2);
            reservas.borrar(reserva2);
            assertEquals(1, reservas.getTamano(), TAMANO_NO_ESPERADO);
            assertEquals(reserva1, reservas.buscar(reserva1), RESERVA_NO_ESPERADA);
            assertEquals(null, reservas.buscar(reserva2), RESERVA_NO_ESPERADA);
        } catch (Exception e) {
            fail(EXCEPCION_NO_PROCEDE);
        }

        reservas = new Reservas(5);
        try {
            reservas.insertar(reserva1);
            reservas.insertar(reserva2);
            reservas.insertar(reserva3);
            reservas.borrar(reserva1);
            assertEquals(2, reservas.getTamano(), TAMANO_NO_ESPERADO);
            assertEquals(null, reservas.buscar(reserva1), RESERVA_NO_ESPERADA);
            assertEquals(reserva2, reservas.buscar(reserva2), RESERVA_NO_ESPERADA);
            assertEquals(reserva3, reservas.buscar(reserva3), RESERVA_NO_ESPERADA);
        } catch (Exception e) {
            fail(EXCEPCION_NO_PROCEDE);
        }

        reservas = new Reservas(5);
        try {
            reservas.insertar(reserva1);
            reservas.insertar(reserva2);
            reservas.insertar(reserva3);
            reservas.borrar(reserva2);
            assertEquals(2, reservas.getTamano(), TAMANO_NO_ESPERADO);
            assertEquals(null, reservas.buscar(reserva2), RESERVA_NO_ESPERADA);
            assertEquals(reserva1, reservas.buscar(reserva1), RESERVA_NO_ESPERADA);
            assertEquals(reserva3, reservas.buscar(reserva3), RESERVA_NO_ESPERADA);
        } catch (Exception e) {
            fail(EXCEPCION_NO_PROCEDE);
        }

        reservas = new Reservas(5);
        try {
            reservas.insertar(reserva1);
            reservas.insertar(reserva2);
            reservas.insertar(reserva3);
            reservas.borrar(reserva3);
            assertEquals(2, reservas.getTamano(), TAMANO_NO_ESPERADO);
            assertEquals(null, reservas.buscar(reserva3), RESERVA_NO_ESPERADA);
            assertEquals(reserva1, reservas.buscar(reserva1), RESERVA_NO_ESPERADA);
            assertEquals(reserva2, reservas.buscar(reserva2), RESERVA_NO_ESPERADA);
        } catch (Exception e) {
            fail(EXCEPCION_NO_PROCEDE);
        }

        reservas = new Reservas(3);
        try {
            reservas.insertar(reserva1);
            reservas.insertar(reserva2);
            reservas.insertar(reserva3);
            reservas.borrar(reserva2);
            assertEquals(2, reservas.getTamano(), TAMANO_NO_ESPERADO);
            assertEquals(null, reservas.buscar(reserva2), RESERVA_NO_ESPERADA);
            assertEquals(reserva1, reservas.buscar(reserva1), RESERVA_NO_ESPERADA);
            assertEquals(reserva3, reservas.buscar(reserva3), RESERVA_NO_ESPERADA);
        } catch (Exception e) {
            fail(EXCEPCION_NO_PROCEDE);
        }
    }

    @Test
    public void borrarReservaNoExistenteLanzaExcepcion() {
        Reservas reservas = new Reservas(5);

        try {
            reservas.insertar(reserva1);
            reservas.borrar(reserva2);
            fail(OPERACION_NO_PERMITIDA);
        } catch (OperationNotSupportedException e) {
            assertEquals(ERROR_RESERVA_BORRAR_NO_EXISTE, e.getMessage(), MENSAJE_EXCEPCION_NO_CORRECTO);
            assertEquals(1, reservas.getTamano(),TAMANO_NO_ESPERADO);
        } catch (Exception e) {
            fail(TIPO_EXCEPCION_NO_CORRECTO);
        }


        reservas = new Reservas(5);
        try {
            reservas.insertar(reserva1);
            reservas.insertar(reserva2);
            reservas.borrar(reserva3);
            fail(OPERACION_NO_PERMITIDA);
        } catch (OperationNotSupportedException e) {
            assertEquals(ERROR_RESERVA_BORRAR_NO_EXISTE, e.getMessage(), MENSAJE_EXCEPCION_NO_CORRECTO);
            assertEquals(2, reservas.getTamano(),TAMANO_NO_ESPERADO);
        } catch (Exception e) {
            fail(TIPO_EXCEPCION_NO_CORRECTO);
        }
    }

    @Test
    public void borrarReservaNulaLanzaExcepcion() {
        Reservas reservas = new Reservas(5);
        try {
            reservas.insertar(reserva1);
            reservas.borrar(null);
            fail(RESERVA_NULA);
        } catch (NullPointerException e) {
            assertEquals(ERROR_BORRAR_RESERVA_NULA, e.getMessage(), MENSAJE_EXCEPCION_NO_CORRECTO);
            assertEquals(1, reservas.getTamano(), TAMANO_NO_ESPERADO);
        } catch (Exception e) {
            fail(TIPO_EXCEPCION_NO_CORRECTO);
        }
    }

    @Test
    public void reservasHuespedNoNuloDevuelveReservasCorrectamente()
    {
        Reservas reservas = new Reservas(3);
        try {
            reservas.insertar(reserva1);
            reservas.insertar(reserva2);
            reservas.insertar(reserva3);

            assertEquals(huesped1, reservas.getReservas(huesped1)[0].getHuesped(), RESERVA_NO_ESPERADA);
            assertEquals(huesped2,reservas.getReservas(huesped2)[0].getHuesped(), RESERVA_NO_ESPERADA);
            assertEquals(huesped3, reservas.getReservas(huesped3)[0].getHuesped(), RESERVA_NO_ESPERADA);
        } catch (Exception e) {
            fail(EXCEPCION_NO_PROCEDE);
        }
    }

    @Test
    public void reservasHuespedNuloLanzaExcepcion()
    {
        Reservas reservas = new Reservas(3);
        Huesped huespedNulo=null;
        try {
            reservas.insertar(reserva1);
            reservas.insertar(reserva2);
            reservas.insertar(reserva3);

            assertEquals(null, reservas.getReservas(huespedNulo), RESERVA_NO_ESPERADA);
            fail(RESERVAS_HUESPED_NULO);
        }
        catch(NullPointerException e)
        {
            assertEquals(ERROR_RESERVAS_HUESPED_NULO, e.getMessage(), MENSAJE_EXCEPCION_NO_CORRECTO);
        }
        catch (Exception e) {
            fail(TIPO_EXCEPCION_NO_CORRECTO);
        }
    }

    @Test
    public void reservasTipoHabitacionNoNulaDevuelveReservasCorrectamente()
    {
        Reservas reservas = new Reservas(3);
        try {
            reservas.insertar(reserva1);
            reservas.insertar(reserva2);
            reservas.insertar(reserva3);

            assertEquals(huesped1, reservas.getReservas(TIPO_HABITACION_SIMPLE_VALIDA)[0].getHuesped(), RESERVA_NO_ESPERADA);
            assertEquals(huesped2,reservas.getReservas(TIPO_HABITACION_DOBLE_VALIDA)[0].getHuesped(), RESERVA_NO_ESPERADA);
            assertEquals(huesped3, reservas.getReservas(TIPO_HABITACION_SUITE_VALIDA)[0].getHuesped(), RESERVA_NO_ESPERADA);
        } catch (Exception e) {
            fail(EXCEPCION_NO_PROCEDE);
        }
    }

    @Test
    public void reservasTipoHabitacionNulaLanzaExcepcion()
    {
        Reservas reservas = new Reservas(3);
        TipoHabitacion tipoHabitacion=null;
        try {
            reservas.insertar(reserva1);
            reservas.insertar(reserva2);
            reservas.insertar(reserva3);

            assertEquals(null, reservas.getReservas(tipoHabitacion), RESERVA_NO_ESPERADA);
            fail(RESERVAS_TIPO_HABITACION_NULA);
        }
        catch(NullPointerException e)
        {
            assertEquals(ERROR_RESERVAS_TIPO_HABITACION_NULA, e.getMessage(), MENSAJE_EXCEPCION_NO_CORRECTO);
        }
        catch (Exception e) {
            fail(TIPO_EXCEPCION_NO_CORRECTO);
        }
    }

    @Test
    public void reservasFuturasHabitacionNulaLanzaExcepcion()
    {
        Reservas reservas = new Reservas(3);
        Habitacion habitacionNula=null;
        try {
            reservas.insertar(reserva1);
            reservas.insertar(reserva2);
            reservas.insertar(reserva3);

            assertEquals(null, reservas.getReservasFuturas(habitacionNula), RESERVA_NO_ESPERADA);
            fail(RESERVAS_HABITACION_NULA);
        }
        catch(NullPointerException e)
        {
            assertEquals(ERROR_RESERVAS_HABITACION_NULA, e.getMessage(), MENSAJE_EXCEPCION_NO_CORRECTO);
        }
        catch (Exception e) {
            fail(TIPO_EXCEPCION_NO_CORRECTO);
        }
    }

    @Test
    public void reservasFuturasHabitacionNoNulaDevuelveReservasCorrectamente()
    {
        Reservas reservas = new Reservas(3);

        try {
            reservas.insertar(reserva1);
            reservas.insertar(reserva2);
            reservas.insertar(reserva3);

            assertEquals(huesped1, reservas.getReservasFuturas(habitacion1)[0].getHuesped(), RESERVA_NO_ESPERADA);
            assertEquals(huesped2,reservas.getReservasFuturas(habitacion2)[0].getHuesped(), RESERVA_NO_ESPERADA);
            assertEquals(huesped3, reservas.getReservasFuturas(habitacion3)[0].getHuesped(), RESERVA_NO_ESPERADA);

        }
        catch (Exception e) {
            fail(EXCEPCION_NO_PROCEDE);
        }
    }

}
