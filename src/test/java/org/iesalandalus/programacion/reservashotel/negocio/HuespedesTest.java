package org.iesalandalus.programacion.reservashotel.negocio;



import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import javax.naming.OperationNotSupportedException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class HuespedesTest {

    private static final String ERROR_CAPACIDAD_NO_CORRECTA = "ERROR: La capacidad debe ser mayor que cero.";
    private static final String ERROR_INSERTAR_HUESPED_NULO = "ERROR: No se puede insertar un huésped nulo.";
    private static final String ERROR_BORRAR_HUESPED_NULO = "ERROR: No se puede borrar un huésped nulo.";
    private static final String ERROR_NO_MAS_HUESPEDES = "ERROR: No se aceptan más huéspedes.";
    private static final String ERROR_HUESPED_EXISTE = "ERROR: Ya existe un huésped con ese dni.";
    private static final String ERROR_HUESPED_BORRAR_NO_EXISTE = "ERROR: No existe ningún huésped como el indicado.";

    private static final String OPERACION_NO_PERMITIDA = "Debería haber saltado una excepción indicando que dicha operación no está permitida.";
    private static final String HUESPED_NULO = "Debería haber saltado una excepción indicando que no se puede operar con un huésped nulo.";
    private static final String MENSAJE_EXCEPCION_NO_CORRECTO = "El mensaje devuelto por la excepción no es correcto.";
    private static final String TIPO_EXCEPCION_NO_CORRECTO = "El tipo de la excepción no es correcto.";
    private static final String EXCEPCION_NO_PROCEDE = "No debería haber saltado la excepción.";
    private static final String OPERACION_NO_REALIZADA = "La operación no la ha realizado correctamente.";
    private static final String HUESPEDES_NO_CREADOS = "Debería haber creado los huéspedes correctamente.";
    private static final String REFERENCIA_NO_ESPERADA = "La referencia devuelta es la misma que la pasada.";
    private static final String TAMANO_NO_ESPERADO = "El tamaño devuelto no es el esperado.";
    private static final String HUESPED_NO_ESPERADO = "El huésped devuelto no es el que debería ser.";
    private static final String OBJETO_DEBERIA_SER_NULO = "No se debería haber creado el objeto.";

    private static final String NOMBRE_JRJR = "José Ramón Jiménez Reyes";
    private static final String DNI_JRJR = "11223344B";
    private static final String TELEFONO_JRJR = "950112233";
    private static final String CORREO_JRJR = "joseramon.jimenez@iesalandalus.org";
    private static final LocalDate FECHA_NACIMIENTO_JRJR=LocalDate.of(2002, 9, 15);
    private static final String NOMBRE_ARDR = "Andrés Rubio Del Río";
    private static final String DNI_ARDR = "22334455Y";
    private static final String TELEFONO_ARDR = "666223344";
    private static final String CORREO_ARDR = "andres.rubio@iesalandalus.org";
    private static final LocalDate FECHA_NACIMIENTO_ARDR=LocalDate.of(1992, 7, 3);
    private static final String NOMBRE_BE = "Bob Esponja";
    private static final String DNI_BE = "33445566R";
    private static final String TELEFONO_BE = "600334455";
    private static final String CORREO_BE = "bog.esponja@iesalandalus.org";
    private static final LocalDate FECHA_NACIMIENTO_BE=LocalDate.of(1996, 10, 30);


    private static Huesped huesped1;
    private static Huesped huesped2;
    private static Huesped huesped3;
    private static Huesped huespedRepetido1;


    @BeforeAll
    public static void asignarValoresAtributos() {
        huesped1 = new Huesped(NOMBRE_JRJR, DNI_JRJR, CORREO_JRJR, TELEFONO_JRJR, FECHA_NACIMIENTO_JRJR);
        huesped2 = new Huesped(NOMBRE_ARDR, DNI_ARDR, CORREO_ARDR, TELEFONO_ARDR, FECHA_NACIMIENTO_ARDR);
        huesped3 = new Huesped(NOMBRE_BE, DNI_BE, CORREO_BE, TELEFONO_BE, FECHA_NACIMIENTO_BE);
        huespedRepetido1 =new Huesped(NOMBRE_ARDR, DNI_ARDR, CORREO_ARDR, TELEFONO_ARDR, FECHA_NACIMIENTO_ARDR);

    }

    @Test
    public void constructorCapacidadValidaCreaHuespedesCorrectamente() {
        Huespedes huespedes = new Huespedes(MainApp.CAPACIDAD);
        assertNotEquals(null, huespedes, HUESPEDES_NO_CREADOS);
        assertEquals(MainApp.CAPACIDAD, huespedes.getCapacidad(), HUESPEDES_NO_CREADOS);
        assertEquals(0, huespedes.getTamano(), TAMANO_NO_ESPERADO);
    }

    @Test
    public void constructorCapacidadNoValidaLanzaExcepcion() {
        Huespedes huespedes = null;

        try {
            huespedes = new Huespedes(0);
            fail(OPERACION_NO_PERMITIDA);
        } catch (IllegalArgumentException e) {
            assertEquals(ERROR_CAPACIDAD_NO_CORRECTA, e.getMessage(), MENSAJE_EXCEPCION_NO_CORRECTO);
            assertEquals(null, huespedes, OBJETO_DEBERIA_SER_NULO);
        } catch (Exception e) {
            fail(TIPO_EXCEPCION_NO_CORRECTO);
        }
        try {
            huespedes = new Huespedes(-1);
            fail(OPERACION_NO_PERMITIDA);
        } catch (IllegalArgumentException e) {
            assertEquals(ERROR_CAPACIDAD_NO_CORRECTA, e.getMessage(), MENSAJE_EXCEPCION_NO_CORRECTO);
            assertEquals(null, huespedes, OBJETO_DEBERIA_SER_NULO);
        } catch (Exception e) {
            fail(TIPO_EXCEPCION_NO_CORRECTO);
        }
    }

    @Test
    public void insertarHuespedValidoInsertaHuespedCorrectamente() {
        Huespedes huespedes = new Huespedes(5);

        try {
            huespedes.insertar(huesped1);

            Huesped[] copiaHuespedes = huespedes.get();
            assertEquals(1, huespedes.getTamano(), TAMANO_NO_ESPERADO);
            assertEquals(huesped1, huespedes.buscar(huesped1), HUESPED_NO_ESPERADO);
            assertNotSame(huesped1, copiaHuespedes[0], REFERENCIA_NO_ESPERADA);
            assertEquals(huesped1, copiaHuespedes[0], OPERACION_NO_REALIZADA);
        } catch (OperationNotSupportedException e) {
            fail(EXCEPCION_NO_PROCEDE);
        }
    }

    @Test
    public void insertarDosHuespedesValidosInsertaHuespedesCorrectamente() {
        Huespedes huespedes = new Huespedes(5);

        try {
            huespedes.insertar(huesped1);
            huespedes.insertar(huesped2);

            Huesped[] copiaHuespedes = huespedes.get();
            assertEquals(2, huespedes.getTamano(), TAMANO_NO_ESPERADO);
            assertEquals(huesped1, huespedes.buscar(huesped1), HUESPED_NO_ESPERADO);
            assertNotSame(huesped1, copiaHuespedes[0], REFERENCIA_NO_ESPERADA);
            assertEquals(huesped1, copiaHuespedes[0], OPERACION_NO_REALIZADA);
            assertEquals(huesped2, huespedes.buscar(huesped2), HUESPED_NO_ESPERADO);
            assertNotSame(huesped2, copiaHuespedes[1], REFERENCIA_NO_ESPERADA);
            assertEquals(huesped2, copiaHuespedes[1], OPERACION_NO_REALIZADA);
        } catch (OperationNotSupportedException e) {
            fail(EXCEPCION_NO_PROCEDE);
        }
    }

    @Test
    public void insertarTresHuespedesValidosInsertaHuespedesCorrectamente() {
        Huespedes huespedes = new Huespedes(5);

        try {
            huespedes.insertar(huesped1);
            huespedes.insertar(huesped2);
            huespedes.insertar(huesped3);

            Huesped[] copiaHuespedes = huespedes.get();

            assertEquals(3, huespedes.getTamano(), TAMANO_NO_ESPERADO);
            assertEquals(huesped1, huespedes.buscar(huesped1), HUESPED_NO_ESPERADO);
            assertNotSame(huesped1, copiaHuespedes[0], REFERENCIA_NO_ESPERADA);
            assertEquals(huesped1, copiaHuespedes[0], OPERACION_NO_REALIZADA);
            assertEquals(huesped2, huespedes.buscar(huesped2), HUESPED_NO_ESPERADO);
            assertNotSame(huesped2, copiaHuespedes[1], REFERENCIA_NO_ESPERADA);
            assertEquals(huesped2, copiaHuespedes[1], OPERACION_NO_REALIZADA);
            assertEquals(huesped3, huespedes.buscar(huesped3), HUESPED_NO_ESPERADO);
            assertNotSame(huesped3, copiaHuespedes[2], REFERENCIA_NO_ESPERADA);
            assertEquals(huesped3, copiaHuespedes[2], OPERACION_NO_REALIZADA);


        } catch (OperationNotSupportedException e) {
            fail(EXCEPCION_NO_PROCEDE);
        }
    }

    @Test
    public void insertarHuespedNuloLanzaExcepcion() {
        Huespedes huespedes = new Huespedes(5);

        try {
            huespedes.insertar(null);
            fail(HUESPED_NULO);
        } catch (NullPointerException e) {
            assertEquals(ERROR_INSERTAR_HUESPED_NULO, e.getMessage(), MENSAJE_EXCEPCION_NO_CORRECTO);
            assertEquals(0, huespedes.getTamano(), TAMANO_NO_ESPERADO);
        } catch (Exception e) {
            fail(TIPO_EXCEPCION_NO_CORRECTO);
        }
    }

    @Test
    public void insertarHuespedRepetidoLanzaExcepcion() {
        Huespedes huespedes = new Huespedes(5);

        try {
            huespedes.insertar(huesped1);
            huespedes.insertar(huesped2);
            huespedes.insertar(huesped3);
            huespedes.insertar(huespedRepetido1);
            fail(OPERACION_NO_PERMITIDA);
        } catch (OperationNotSupportedException e) {
            assertEquals(ERROR_HUESPED_EXISTE, e.getMessage(), MENSAJE_EXCEPCION_NO_CORRECTO);
            assertEquals(3, huespedes.getTamano(), TAMANO_NO_ESPERADO);
        } catch (Exception e) {
            fail(TIPO_EXCEPCION_NO_CORRECTO);
        }

        huespedes = new Huespedes(5);
        try {
            huespedes.insertar(huesped2);
            huespedes.insertar(huesped1);
            huespedes.insertar(huesped3);
            huespedes.insertar(huespedRepetido1);
            fail(OPERACION_NO_PERMITIDA);
        } catch (OperationNotSupportedException e) {
            assertEquals(ERROR_HUESPED_EXISTE, e.getMessage(), MENSAJE_EXCEPCION_NO_CORRECTO);
            assertEquals(3, huespedes.getTamano(), TAMANO_NO_ESPERADO);
        } catch (Exception e) {
            fail(TIPO_EXCEPCION_NO_CORRECTO);
        }

        huespedes = new Huespedes(5);
        try {
            huespedes.insertar(huesped2);
            huespedes.insertar(huesped3);
            huespedes.insertar(huesped1);
            huespedes.insertar(huespedRepetido1);
            fail(OPERACION_NO_PERMITIDA);
        } catch (OperationNotSupportedException e) {
            assertEquals(ERROR_HUESPED_EXISTE, e.getMessage(), MENSAJE_EXCEPCION_NO_CORRECTO);
            assertEquals(3, huespedes.getTamano(), TAMANO_NO_ESPERADO);
        } catch (Exception e) {
            fail(TIPO_EXCEPCION_NO_CORRECTO);
        }
    }

    @Test
    public void insertarHuespedValidoConHuespedesLlenoLanzaExcepcion() {
        Huespedes huespedes = new Huespedes(2);

        try {
            huespedes.insertar(huesped1);
            huespedes.insertar(huesped2);
            huespedes.insertar(huesped3);
            fail(OPERACION_NO_PERMITIDA);
        } catch (OperationNotSupportedException e) {
            assertEquals(ERROR_NO_MAS_HUESPEDES, e.getMessage(), MENSAJE_EXCEPCION_NO_CORRECTO);
            assertEquals(2, huespedes.getTamano(), TAMANO_NO_ESPERADO);
            assertEquals(huesped1, huespedes.buscar(huesped1), HUESPED_NO_ESPERADO);
            assertNotSame(huesped1, huespedes.buscar(huesped1), REFERENCIA_NO_ESPERADA);
            assertEquals(huesped1, huespedes.get()[0], OPERACION_NO_REALIZADA);
            assertEquals(huesped2, huespedes.buscar(huesped2), HUESPED_NO_ESPERADO);
            assertNotSame(huesped2, huespedes.buscar(huesped2), REFERENCIA_NO_ESPERADA);
        } catch (Exception e) {
            fail(TIPO_EXCEPCION_NO_CORRECTO);
        }
    }

    @Test
    public void borrarHuespedExistenteBorraHuespedCorrectamente() throws OperationNotSupportedException {
        Huespedes huespedes = new Huespedes(5);

        try {
            huespedes.insertar(huesped1);
            huespedes.borrar(huesped1);
            assertEquals(0, huespedes.getTamano(), TAMANO_NO_ESPERADO);
            assertEquals(null, huespedes.buscar(huesped1), HUESPED_NO_ESPERADO);
        } catch (Exception e) {
            fail(EXCEPCION_NO_PROCEDE);
        }

        huespedes = new Huespedes(5);
        try {
            huespedes.insertar(huesped1);
            huespedes.insertar(huesped2);
            huespedes.borrar(huesped1);
            assertEquals(1, huespedes.getTamano(), TAMANO_NO_ESPERADO);
            assertEquals(huesped2, huespedes.buscar(huesped2), HUESPED_NO_ESPERADO);
            assertEquals(null, huespedes.buscar(huesped1), HUESPED_NO_ESPERADO);
        } catch (Exception e) {
            fail(EXCEPCION_NO_PROCEDE);
        }

        huespedes = new Huespedes(5);
        try {
            huespedes.insertar(huesped1);
            huespedes.insertar(huesped2);
            huespedes.borrar(huesped2);
            assertEquals(1, huespedes.getTamano(), TAMANO_NO_ESPERADO);
            assertEquals(huesped1, huespedes.buscar(huesped1), HUESPED_NO_ESPERADO);
            assertEquals(null, huespedes.buscar(huesped2), HUESPED_NO_ESPERADO);
        } catch (Exception e) {
            fail(EXCEPCION_NO_PROCEDE);
        }

        huespedes = new Huespedes(5);
        try {
            huespedes.insertar(huesped1);
            huespedes.insertar(huesped2);
            huespedes.insertar(huesped3);
            huespedes.borrar(huesped1);
            assertEquals(2, huespedes.getTamano(), TAMANO_NO_ESPERADO);
            assertEquals(null, huespedes.buscar(huesped1), HUESPED_NO_ESPERADO);
            assertEquals(huesped2, huespedes.buscar(huesped2), HUESPED_NO_ESPERADO);
            assertEquals(huesped3, huespedes.buscar(huesped3), HUESPED_NO_ESPERADO);
        } catch (Exception e) {
            fail(EXCEPCION_NO_PROCEDE);
        }

        huespedes = new Huespedes(5);
        try {
            huespedes.insertar(huesped1);
            huespedes.insertar(huesped2);
            huespedes.insertar(huesped3);
            huespedes.borrar(huesped2);
            assertEquals(2, huespedes.getTamano(), TAMANO_NO_ESPERADO);
            assertEquals(null, huespedes.buscar(huesped2), HUESPED_NO_ESPERADO);
            assertEquals(huesped1, huespedes.buscar(huesped1), HUESPED_NO_ESPERADO);
            assertEquals(huesped3, huespedes.buscar(huesped3), HUESPED_NO_ESPERADO);
        } catch (Exception e) {
            fail(EXCEPCION_NO_PROCEDE);
        }

        huespedes = new Huespedes(5);
        try {
            huespedes.insertar(huesped1);
            huespedes.insertar(huesped2);
            huespedes.insertar(huesped3);
            huespedes.borrar(huesped3);
            assertEquals(2, huespedes.getTamano(), TAMANO_NO_ESPERADO);
            assertEquals(null, huespedes.buscar(huesped3), HUESPED_NO_ESPERADO);
            assertEquals(huesped1, huespedes.buscar(huesped1), HUESPED_NO_ESPERADO);
            assertEquals(huesped2, huespedes.buscar(huesped2), HUESPED_NO_ESPERADO);
        } catch (Exception e) {
            fail(EXCEPCION_NO_PROCEDE);
        }

        huespedes = new Huespedes(3);
        try {
            huespedes.insertar(huesped1);
            huespedes.insertar(huesped2);
            huespedes.insertar(huesped3);
            huespedes.borrar(huesped2);
            assertEquals(2, huespedes.getTamano(), TAMANO_NO_ESPERADO);
            assertEquals(null, huespedes.buscar(huesped2), HUESPED_NO_ESPERADO);
            assertEquals(huesped1, huespedes.buscar(huesped1), HUESPED_NO_ESPERADO);
            assertEquals(huesped3, huespedes.buscar(huesped3), HUESPED_NO_ESPERADO);
        } catch (Exception e) {
            fail(EXCEPCION_NO_PROCEDE);
        }
    }

    @Test
    public void borrarHuespedNoExistenteLanzaExcepcion() {
        Huespedes huespedes = new Huespedes(5);

        try {
            huespedes.insertar(huesped1);
            huespedes.borrar(huesped2);
            fail(OPERACION_NO_PERMITIDA);
        } catch (OperationNotSupportedException e) {
            assertEquals(ERROR_HUESPED_BORRAR_NO_EXISTE, e.getMessage(), MENSAJE_EXCEPCION_NO_CORRECTO);
            assertEquals(1, huespedes.getTamano(),TAMANO_NO_ESPERADO);
        } catch (Exception e) {
            fail(TIPO_EXCEPCION_NO_CORRECTO);
        }


        huespedes = new Huespedes(5);
        try {
            huespedes.insertar(huesped1);
            huespedes.insertar(huesped2);
            huespedes.borrar(huesped3);
            fail(OPERACION_NO_PERMITIDA);
        } catch (OperationNotSupportedException e) {
            assertEquals(ERROR_HUESPED_BORRAR_NO_EXISTE, e.getMessage(), MENSAJE_EXCEPCION_NO_CORRECTO);
            assertEquals(2, huespedes.getTamano(),TAMANO_NO_ESPERADO);
        } catch (Exception e) {
            fail(TIPO_EXCEPCION_NO_CORRECTO);
        }
    }

    @Test
    public void borrarHuespedNuloLanzaExcepcion() {
        Huespedes huespedes = new Huespedes(5);
        try {
            huespedes.insertar(huesped1);
            huespedes.borrar(null);
            fail(HUESPED_NULO);
        } catch (NullPointerException e) {
            assertEquals(ERROR_BORRAR_HUESPED_NULO, e.getMessage(), MENSAJE_EXCEPCION_NO_CORRECTO);
            assertEquals(1, huespedes.getTamano(), TAMANO_NO_ESPERADO);
        } catch (Exception e) {
            fail(TIPO_EXCEPCION_NO_CORRECTO);
        }
    }





}
