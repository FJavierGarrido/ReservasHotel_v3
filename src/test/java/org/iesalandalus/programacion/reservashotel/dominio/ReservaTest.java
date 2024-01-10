package org.iesalandalus.programacion.reservashotel.dominio;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.*;

public class ReservaTest {
/*
    private static final String ERROR_EXCEPCION = "Debería haber saltado la excepción.";
    private static final String ERROR_NO_EXCEPCION = "No debería haber saltado la excepción.";
    private static final String NOMBRE_ARDR = "Andrés Rubio Del Río";
    private static final String DNI_ARDR = "22334455Y";
    private static final String TELEFONO_ARDR = "666223344";
    private static final String CORREO_ARDR = "andres.rubio@iesalandalus.org";
    private DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern(Reserva.FORMATO_FECHA_RESERVA);
    private DateTimeFormatter formatoFechaHora = DateTimeFormatter.ofPattern(Reserva.FORMATO_FECHA_HORA_RESERVA);

    private static final LocalDate FECHA_NACIMIENTO_ARDR=LocalDate.of(1992, 7, 3);
    private static final int PLANTA_1=1;
    private static final int PUERTA_10=10;

    private static final double PRECIO_HABITACION_SIMPLE=50;
    private static final TipoHabitacion TIPO_HABITACION_SIMPLE=TipoHabitacion.SIMPLE;
    private static final TipoHabitacion TIPO_HABITACION_DOBLE=TipoHabitacion.SIMPLE;

    Huesped huesped = new Huesped(NOMBRE_ARDR, DNI_ARDR, CORREO_ARDR, TELEFONO_ARDR, FECHA_NACIMIENTO_ARDR);
    Habitacion habitacionSimple = new Habitacion(PLANTA_1, PUERTA_10, PRECIO_HABITACION_SIMPLE, TIPO_HABITACION_SIMPLE);

    private static final Regimen REGIMEN_SOLO_ALOJAMIENTO = Regimen.SOLO_ALOJAMIENTO;
    private static final Regimen REGIMEN_PENSION_COMPLETA=Regimen.PENSION_COMPLETA;
    private static final LocalDate FECHA_INICIO_FUTURA_VALIDA=LocalDate.now().plusDays(3);
    private static final LocalDate FECHA_FIN_FUTURA_VALIDA=FECHA_INICIO_FUTURA_VALIDA.plusDays(7);

    private static final String OBJETO_DEBERIA_SER_NULO = "No se debería haber creado el objeto reserva.";
    private static final String MENSAJE_EXCEPCION_NO_CORRECTO = "El mensaje devuelto por la excepción no es correcto.";
    private static final String ERROR_HUESPED_NULO="ERROR: El huésped de una reserva no puede ser nulo.";
    private static final String ERROR_HABITACION_NULA="ERROR: La habitación de una reserva no puede ser nula.";
    private static final String ERROR_REGIMEN_NULO="ERROR: El régimen de una reserva no puede ser nulo.";
    private static final String ERROR_FECHA_INICIO_NULA="ERROR: La fecha de inicio de una reserva no puede ser nula.";
    private static final String ERROR_FECHA_FIN_NULA="ERROR: La fecha de fin de una reserva no puede ser nula.";
    private static final String RESERVA_NULA = "Debería haber saltado una excepción indicando que no se puede copiar una reserva nula.";
    private static final String ERROR_COPIAR_RESERVA_NULA = "ERROR: No es posible copiar una reserva nula.";
    private static final String TIPO_EXCEPCION_NO_CORRECTA = "El tipo de la excepción no es correcto.";
    private static final String ERROR_FECHA_INICIO_RESERVA_NULA="ERROR: La fecha de inicio de una reserva no puede ser nula.";

    private static final String ERROR_FECHA_FIN_RESERVA_NULA="ERROR: La fecha de fin de una reserva no puede ser nula.";

    private static final String ERROR_EXCEPCION_FECHA_INICIO_RESERVA="Debería haber saltado una excepción indicando que no se puede establecer una fecha de inicio de reserva nula.";
    private static final String ERROR_EXCEPCION_FECHA_FIN_RESERVA="Debería haber saltado una excepción indicando que no se puede establecer una fecha de fin de reserva nula.";
    private static final String ERROR_FECHA_INICIO_RESERVA_ANTERIOR="ERROR: La fecha de inicio de la reserva no puede ser anterior al día de hoy.";
    private static final String ERROR_FECHA_FIN_RESERVA_ANTERIOR="ERROR: La fecha de fin de la reserva debe ser posterior a la de inicio.";
    private static final String ERROR_EXCEPCION_FECHA_INICIO="Debería haber saltado una excepción indicando que la fecha de inicio no es correcta.";
    private static final String ERROR_EXCEPCION_FECHA_FIN="Debería haber saltado una excepción indicando que la fecha de fin no es correcta.";
    private static final String ERROR_FECHA_INICIO_RESERVA_POSTERIOR="ERROR: La fecha de inicio de la reserva no puede ser posterior a seis meses.";
    private static final String ERROR_EXCEPCION_CHECKIN_NULO="Debería haber saltado una excepción indicando que no se puede establecer una fecha de checkin nula.";
    private static final String ERROR_EXCEPCION_CHECKIN="Debería haber saltado una excepción indicando que el checkin no es válido.";
    private static final String ERROR_CHECKIN_NULO="ERROR: El checkin de una reserva no puede ser nulo.";
    private static final String ERROR_CHECKIN_ANTERIOR="ERROR: El checkin de una reserva no puede ser anterior a la fecha de inicio de la reserva.";
    private static final String ERROR_EXCEPCION_CHECKOUT_NULO="Debería haber saltado una excepción indicando que no se puede establecer una fecha de checkout nula.";
    private static final String ERROR_CHECKOUT_NULO="ERROR: El checkout de una reserva no puede ser nulo.";
    private static final String ERROR_EXCEPCION_CHECKOUT="Debería haber saltado una excepción indicando que el checkout no es válido.";
    private static final String ERROR_CHECKOUT_ANTERIOR="ERROR: El checkout de una reserva no puede ser anterior al checkin.";
    private static final String ERROR_CHECKOUT_POSTERIOR="ERROR: El checkout de una reserva puede ser como máximo 12 horas después de la fecha de fin de la reserva.";
    private static final String MENSAJE_PRECIO_NO_CORRECTO="El precio calculado no es correcto.";
    private static final String ERROR_NUMERO_PERSONAS_RESERVA="ERROR: El número de personas de una reserva no puede ser menor o igual a 0.";
    private static final String ERROR_NUMERO_MAXIMO_PERSONAS_RESERVA="ERROR: El número de personas de una reserva no puede superar al máximo de personas establacidas para el tipo de habitación reservada.";

    @Test
    public void constructorParametrosValidoCreaReservaCorrectamenteTest() {
        Reserva reserva = null;
        try {
            System.out.println(habitacionSimple);
            reserva = new Reserva(huesped, habitacionSimple,REGIMEN_SOLO_ALOJAMIENTO,FECHA_INICIO_FUTURA_VALIDA, FECHA_FIN_FUTURA_VALIDA,1);
            assertEquals(huesped, reserva.getHuesped());
            assertEquals(habitacionSimple, reserva.getHabitacion());
            assertEquals(REGIMEN_SOLO_ALOJAMIENTO, reserva.getRegimen());
            assertEquals(FECHA_INICIO_FUTURA_VALIDA, reserva.getFechaInicioReserva());
            assertEquals(FECHA_FIN_FUTURA_VALIDA, reserva.getFechaFinReserva());
            assertEquals(1, reserva.getNumeroPersonas());
        } catch (IllegalArgumentException e) {
            fail(ERROR_NO_EXCEPCION);
        }
    }

    @Test
    public void constructorParametrosNoValidoTest() {
        Reserva reserva = null;
        try {
            reserva = new Reserva(null, habitacionSimple, REGIMEN_SOLO_ALOJAMIENTO,FECHA_INICIO_FUTURA_VALIDA, FECHA_FIN_FUTURA_VALIDA,1);
            fail(ERROR_EXCEPCION);
        } catch (NullPointerException e) {
            assertEquals(ERROR_HUESPED_NULO, e.getMessage(), MENSAJE_EXCEPCION_NO_CORRECTO);
            assertEquals(null, reserva, OBJETO_DEBERIA_SER_NULO);
        }
        try {
            reserva = new Reserva(huesped, null, REGIMEN_SOLO_ALOJAMIENTO,FECHA_INICIO_FUTURA_VALIDA, FECHA_FIN_FUTURA_VALIDA,1);
            fail(ERROR_EXCEPCION);
        } catch (NullPointerException e) {
            assertEquals(ERROR_HABITACION_NULA, e.getMessage(), MENSAJE_EXCEPCION_NO_CORRECTO);
            assertEquals(null, reserva, OBJETO_DEBERIA_SER_NULO);
        }
        try {
            reserva = new Reserva(huesped, habitacionSimple, null,FECHA_INICIO_FUTURA_VALIDA, FECHA_FIN_FUTURA_VALIDA,1);
            fail(ERROR_EXCEPCION);
        } catch (NullPointerException e) {
            assertEquals(ERROR_REGIMEN_NULO, e.getMessage(), MENSAJE_EXCEPCION_NO_CORRECTO);
            assertEquals(null, reserva, OBJETO_DEBERIA_SER_NULO);
        }

        try {
            reserva = new Reserva(huesped, habitacionSimple, REGIMEN_SOLO_ALOJAMIENTO,null, FECHA_FIN_FUTURA_VALIDA,1);
            fail(ERROR_EXCEPCION);
        } catch (NullPointerException e) {
            assertEquals(ERROR_FECHA_INICIO_NULA, e.getMessage(), MENSAJE_EXCEPCION_NO_CORRECTO);
            assertEquals(null, reserva, OBJETO_DEBERIA_SER_NULO);
        }

        try {
            reserva = new Reserva(huesped, habitacionSimple, REGIMEN_SOLO_ALOJAMIENTO,FECHA_INICIO_FUTURA_VALIDA, null,1);
            fail(ERROR_EXCEPCION);
        } catch (NullPointerException e) {
            assertEquals(ERROR_FECHA_FIN_NULA, e.getMessage(), MENSAJE_EXCEPCION_NO_CORRECTO);
            assertEquals(null, reserva, OBJETO_DEBERIA_SER_NULO);
        }

        try {
            reserva = new Reserva(huesped, habitacionSimple, REGIMEN_SOLO_ALOJAMIENTO,FECHA_INICIO_FUTURA_VALIDA, FECHA_FIN_FUTURA_VALIDA,-1);
            fail(ERROR_EXCEPCION);
        } catch (IllegalArgumentException e) {
            assertEquals(ERROR_NUMERO_PERSONAS_RESERVA, e.getMessage(), MENSAJE_EXCEPCION_NO_CORRECTO);
            assertEquals(null, reserva, OBJETO_DEBERIA_SER_NULO);
        }

        try {
            reserva = new Reserva(huesped, habitacionSimple, REGIMEN_SOLO_ALOJAMIENTO,FECHA_INICIO_FUTURA_VALIDA, FECHA_FIN_FUTURA_VALIDA,0);
            fail(ERROR_EXCEPCION);
        } catch (IllegalArgumentException e) {
            assertEquals(ERROR_NUMERO_PERSONAS_RESERVA, e.getMessage(), MENSAJE_EXCEPCION_NO_CORRECTO);
            assertEquals(null, reserva, OBJETO_DEBERIA_SER_NULO);
        }
    }

    @Test
    public void constructorCopiaValidoCopiaReservaCorrectamente() {
        Reserva reserva = new Reserva(huesped, habitacionSimple,REGIMEN_SOLO_ALOJAMIENTO,FECHA_INICIO_FUTURA_VALIDA, FECHA_FIN_FUTURA_VALIDA,1);
        Reserva reserva1;
        try {
            reserva1 = new Reserva(reserva);
            assertEquals(huesped, reserva1.getHuesped());
            assertEquals(habitacionSimple, reserva1.getHabitacion());
            assertEquals(REGIMEN_SOLO_ALOJAMIENTO, reserva1.getRegimen());
            assertEquals(FECHA_INICIO_FUTURA_VALIDA, reserva1.getFechaInicioReserva());
            assertEquals(FECHA_FIN_FUTURA_VALIDA, reserva1.getFechaFinReserva());
            assertEquals(1, reserva1.getNumeroPersonas());
        } catch (IllegalArgumentException e) {
            fail(ERROR_NO_EXCEPCION);
        }
    }

    @Test
    public void constructorReservaNulaLanzaExcepcion() {
        Reserva reserva = null;
        try {
            reserva = new Reserva(null);
            fail(RESERVA_NULA);
        } catch (NullPointerException e) {
            assertEquals(ERROR_COPIAR_RESERVA_NULA, e.getMessage(), MENSAJE_EXCEPCION_NO_CORRECTO);
            assertEquals(null, reserva, OBJETO_DEBERIA_SER_NULO);
        }
        catch (Exception e) {
            fail(TIPO_EXCEPCION_NO_CORRECTA);
        }
    }

    @Test
    public void fechaInicioReservaNoValidaLanzaExcepcion()
    {
        Reserva reserva = new Reserva(huesped, habitacionSimple,REGIMEN_SOLO_ALOJAMIENTO,FECHA_INICIO_FUTURA_VALIDA, FECHA_FIN_FUTURA_VALIDA,1);

        try
        {
            reserva.setFechaInicioReserva(null);
            fail(ERROR_EXCEPCION_FECHA_INICIO_RESERVA);
        }
        catch (NullPointerException e)
        {
            assertEquals(ERROR_FECHA_INICIO_RESERVA_NULA, e.getMessage(), MENSAJE_EXCEPCION_NO_CORRECTO);
        }
        catch (Exception e) {
            fail(TIPO_EXCEPCION_NO_CORRECTA);
        }

        try
        {
            reserva.setFechaInicioReserva(LocalDate.now().minusDays(3));
            fail(ERROR_EXCEPCION_FECHA_INICIO);
        }
        catch (IllegalArgumentException e)
        {
            assertEquals(ERROR_FECHA_INICIO_RESERVA_ANTERIOR, e.getMessage(), MENSAJE_EXCEPCION_NO_CORRECTO);
        }
        catch (Exception e) {
            fail(TIPO_EXCEPCION_NO_CORRECTA);
        }

        try
        {
            reserva.setFechaInicioReserva(LocalDate.now().plusMonths(Reserva.MAX_NUMERO_MESES_RESERVA+1));
            fail(ERROR_EXCEPCION_FECHA_INICIO);
        }
        catch (IllegalArgumentException e)
        {
            assertEquals(ERROR_FECHA_INICIO_RESERVA_POSTERIOR, e.getMessage(), MENSAJE_EXCEPCION_NO_CORRECTO);
        }
        catch (Exception e) {
            fail(TIPO_EXCEPCION_NO_CORRECTA);
        }
    }

    @Test
    public void fechaFinReservaNoValidaLanzaExcepcion()
    {
        Reserva reserva = new Reserva(huesped, habitacionSimple,REGIMEN_SOLO_ALOJAMIENTO,FECHA_INICIO_FUTURA_VALIDA, FECHA_FIN_FUTURA_VALIDA,1);

        try
        {
            reserva.setFechaFinReserva(null);
            fail(ERROR_EXCEPCION_FECHA_FIN_RESERVA);
        }
        catch (NullPointerException e)
        {
            assertEquals(ERROR_FECHA_FIN_RESERVA_NULA, e.getMessage(), MENSAJE_EXCEPCION_NO_CORRECTO);
        }
        catch (Exception e) {
            fail(TIPO_EXCEPCION_NO_CORRECTA);
        }

        try
        {
            reserva.setFechaFinReserva(reserva.getFechaInicioReserva());
            fail(ERROR_EXCEPCION_FECHA_FIN);
        }
        catch (IllegalArgumentException e)
        {
            assertEquals(ERROR_FECHA_FIN_RESERVA_ANTERIOR, e.getMessage(), MENSAJE_EXCEPCION_NO_CORRECTO);
        }
        catch (Exception e) {
            fail(TIPO_EXCEPCION_NO_CORRECTA);
        }

        try
        {
            reserva.setFechaFinReserva(reserva.getFechaInicioReserva().minusDays(3));
            fail(ERROR_EXCEPCION_FECHA_FIN);
        }
        catch (IllegalArgumentException e)
        {
            assertEquals(ERROR_FECHA_FIN_RESERVA_ANTERIOR, e.getMessage(), MENSAJE_EXCEPCION_NO_CORRECTO);
        }
        catch (Exception e) {
            fail(TIPO_EXCEPCION_NO_CORRECTA);
        }
    }

    @Test
    public void checkInReservaNoValidoLanzaExcepcion() {
        Reserva reserva = new Reserva(huesped, habitacionSimple, REGIMEN_SOLO_ALOJAMIENTO, FECHA_INICIO_FUTURA_VALIDA, FECHA_FIN_FUTURA_VALIDA, 1);

        try {
            reserva.setCheckIn(null);
            fail(ERROR_EXCEPCION_CHECKIN_NULO);
        } catch (NullPointerException e) {
            assertEquals(ERROR_CHECKIN_NULO, e.getMessage(), MENSAJE_EXCEPCION_NO_CORRECTO);
        } catch (Exception e) {
            fail(TIPO_EXCEPCION_NO_CORRECTA);
        }

        try {
            reserva.setCheckIn(reserva.getFechaInicioReserva().atStartOfDay().minusDays(3));
            fail(ERROR_EXCEPCION_CHECKIN);
        } catch (IllegalArgumentException e) {
            assertEquals(ERROR_CHECKIN_ANTERIOR, e.getMessage(), MENSAJE_EXCEPCION_NO_CORRECTO);
        } catch (Exception e) {
            fail(TIPO_EXCEPCION_NO_CORRECTA);
        }
    }

    @Test
    public void checkOutReservaNoValidoLanzaExcepcion() {
        Reserva reserva = new Reserva(huesped, habitacionSimple, REGIMEN_SOLO_ALOJAMIENTO, FECHA_INICIO_FUTURA_VALIDA, FECHA_FIN_FUTURA_VALIDA, 1);

        reserva.setCheckIn(reserva.getFechaInicioReserva().atStartOfDay().plus(3,ChronoUnit.HOURS));

        try {
            reserva.setCheckOut(null);
            fail(ERROR_EXCEPCION_CHECKOUT_NULO);
        } catch (NullPointerException e) {
            assertEquals(ERROR_CHECKOUT_NULO, e.getMessage(), MENSAJE_EXCEPCION_NO_CORRECTO);
        } catch (Exception e) {
            fail(TIPO_EXCEPCION_NO_CORRECTA);
        }

        try {

            reserva.setCheckOut(reserva.getCheckIn().minusDays(3));
            fail(ERROR_EXCEPCION_CHECKOUT);
        } catch (IllegalArgumentException e) {
            assertEquals(ERROR_CHECKOUT_ANTERIOR, e.getMessage(), MENSAJE_EXCEPCION_NO_CORRECTO);
        } catch (Exception e) {
            fail(TIPO_EXCEPCION_NO_CORRECTA);
        }

        try {
            reserva.setCheckOut(reserva.getFechaFinReserva().atStartOfDay().plusDays(3));
            fail(ERROR_EXCEPCION_CHECKOUT);
        } catch (IllegalArgumentException e) {
            assertEquals(ERROR_CHECKOUT_POSTERIOR, e.getMessage(), MENSAJE_EXCEPCION_NO_CORRECTO);
        } catch (Exception e) {
            fail(TIPO_EXCEPCION_NO_CORRECTA);
        }
    }

    @Test
    public void precioReservaNoValido() {
        Reserva reserva = new Reserva(huesped, habitacionSimple, REGIMEN_SOLO_ALOJAMIENTO, FECHA_INICIO_FUTURA_VALIDA, FECHA_FIN_FUTURA_VALIDA, 1);
        double precioHabitacion=reserva.getHabitacion().getPrecio();
        double precioRegimen=reserva.getRegimen().getIncrementoPrecio()* reserva.getNumeroPersonas();

        reserva.setCheckIn(FECHA_INICIO_FUTURA_VALIDA.atStartOfDay().plusDays(1));
        reserva.setCheckOut(reserva.getCheckIn().plusDays(5));

        Period period = Period.between(reserva.getFechaInicioReserva(), reserva.getFechaFinReserva());


        assertEquals(reserva.getPrecio(),(precioHabitacion+precioRegimen)*period.getDays(),MENSAJE_PRECIO_NO_CORRECTO);
    }

    @Test
    public void numeroPersonasReservaNoValido()
    {
        Reserva reserva= new Reserva(huesped, habitacionSimple, REGIMEN_SOLO_ALOJAMIENTO,FECHA_INICIO_FUTURA_VALIDA, FECHA_FIN_FUTURA_VALIDA,1);

        try {
            reserva.setNumeroPersonas(0);
            fail(ERROR_EXCEPCION);
        } catch (IllegalArgumentException e) {
            assertEquals(ERROR_NUMERO_PERSONAS_RESERVA, e.getMessage(), MENSAJE_EXCEPCION_NO_CORRECTO);
        }

        try {
            reserva.setNumeroPersonas(-1);
            fail(ERROR_EXCEPCION);
        } catch (IllegalArgumentException e) {
            assertEquals(ERROR_NUMERO_PERSONAS_RESERVA, e.getMessage(), MENSAJE_EXCEPCION_NO_CORRECTO);
        }

        try {
            reserva.setNumeroPersonas(20);
            fail(ERROR_EXCEPCION);
        } catch (IllegalArgumentException e) {
            assertEquals(ERROR_NUMERO_MAXIMO_PERSONAS_RESERVA, e.getMessage(), MENSAJE_EXCEPCION_NO_CORRECTO);
        }

    }

    @Test
    void toStringDevuelveLaCadenaEsperada() {
        Reserva reserva = new Reserva(huesped, habitacionSimple,REGIMEN_PENSION_COMPLETA,FECHA_INICIO_FUTURA_VALIDA, FECHA_FIN_FUTURA_VALIDA,1);

        String cadenaEsperada=String.format("Huesped: %s %s Habitación:%s - %s Fecha Inicio Reserva: %s Fecha Fin Reserva: %s Checkin: %s Checkout: %s Precio: %.2f Personas: %d", reserva.getHuesped().getNombre(), reserva.getHuesped().getDni(),
                reserva.getHabitacion().getIdentificador(),reserva.getHabitacion().getTipoHabitacion(), reserva.getFechaInicioReserva().format(formatoFecha),
                reserva.getFechaFinReserva().format(formatoFecha), "No registrado", "No registrado", reserva.getPrecio(), 1);

        assertEquals(cadenaEsperada, reserva.toString());

        reserva.setCheckIn(reserva.getFechaInicioReserva().atStartOfDay().plus(3, ChronoUnit.HOURS));
        reserva.setCheckOut(reserva.getFechaFinReserva().atStartOfDay().plus(3,ChronoUnit.HOURS));

        cadenaEsperada=String.format("Huesped: %s %s Habitación:%s - %s Fecha Inicio Reserva: %s Fecha Fin Reserva: %s Checkin: %s Checkout: %s Precio: %.2f Personas: %d", reserva.getHuesped().getNombre(), reserva.getHuesped().getDni(),
                reserva.getHabitacion().getIdentificador(),reserva.getHabitacion().getTipoHabitacion(), reserva.getFechaInicioReserva().format(formatoFecha),
                reserva.getFechaFinReserva().format(formatoFecha), reserva.getCheckIn().format(formatoFechaHora),
                reserva.getCheckOut().format(formatoFechaHora), reserva.getPrecio(), 1);

        assertEquals(cadenaEsperada, reserva.toString());
    }


*/
}
