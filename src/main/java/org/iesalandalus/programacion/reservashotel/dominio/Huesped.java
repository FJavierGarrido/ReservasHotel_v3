package org.iesalandalus.programacion.reservashotel.dominio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Huesped {



    private final String ER_TELEFONO= "[0-9]{9}";
    private final String ER_CORREO="([a-z0-9].{3})(@)([a-z]{3})(.[a-z]{2})";
    private final String ER_DNI= "([0-9]{8})([a-zA-Z])";

    public String FORMATO_FECHA;


    private String nombre;
    private String telefono;
    private String correo;
    private String dni;
    private LocalDate fechaNacimiento;

    //Constructor
    public Huesped(String nombre, String dni, String correo, String telefono, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.dni = dni;
        this.correo = correo;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
    }

    // Constructor copia
    public Huesped(Huesped otroHuesped) {
        this.nombre = otroHuesped.nombre;
        this.dni = otroHuesped.dni;
        this.correo = otroHuesped.correo;
        this.telefono = otroHuesped.telefono;
        this.fechaNacimiento = otroHuesped.fechaNacimiento;
    }


    private String formateaNombre(String nombre) {

        if (nombre == null || nombre.isEmpty()) {
            return nombre;
        }

        //elimina espacios en blanco del principio y final y divide palabras
        String[] partes = nombre.trim().split("\\s+");
        StringBuilder resultado = new StringBuilder();

        //recorre cada palabra y pone mayúscula la primera letra, minúsculas las demás y un espacio al final
        for (String parte : partes) {
            resultado.append(Character.toUpperCase(parte.charAt(0)))
                    .append(parte.substring(1).toLowerCase())
                    .append(" ");

        }

        return resultado.toString().trim();
    }


    private String comprobarLetraDni(String dni) {

        // Definir la expresión regular con 2 grupos
        String dni2 ="^(\\d{8}) ([A-HJ-NP-TV-Z])$";
        // Compilar la expresión regular
        Pattern pattern = Pattern.compile(dni2);
        // Obtener el objeto Matcher
        Matcher matcher = pattern.matcher(dni);

        try {
            if (matcher.matches()) {
                // Obtener el número y la letra mediante los grupos
                String numero = matcher.group(1);
                String letra = matcher.group(2);


                String letrasValidas = "ABCDEFGHJKLMNPQRSTVWXYZ";


                // Verificar si la letra pasada es válida
                char letraEsperada = letrasValidas.charAt(Integer.parseInt(numero) % 23);
                if (letra.charAt(0) == letraEsperada) {
                    return dni;
                } else {
                    return "ERROR: Letra DNI no válido";
                }
            }
        }catch (NumberFormatException | IndexOutOfBoundsException e) {
            // Capturar excepciones relacionadas con la conversión a número y acceso a índice fuera de rango
            return "ERROR: Excepción durante la validación del DNI - " + e.getMessage();
        }

        return "ERROR: Formato de DNI no válido";
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre)
    {

        if (nombre!=null && !nombre.isEmpty()){
            String[] palabras = nombre.split(" ");

            // Formatear cada palabra con la primera letra en mayúscula y las demás en minúsculas
            for (int i = 0; i < palabras.length; i++) {
                palabras[i] = palabras[i].substring(0, 1).toUpperCase() + palabras[i].substring(1).toLowerCase();
            }

            // Unir las palabras formateadas de nuevo en un solo string
            this.nombre = String.join(" ", palabras);
        }
        else {
            throw new IllegalArgumentException("ERROR: Ha introducido un nombre no válido");
        }
    }


    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {

        if (telefono.matches(ER_TELEFONO)) {
            this.telefono = telefono;

        } else {
            throw new IllegalArgumentException("ERROR: Formato de teléfono no válido");
        }

    }


    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {

        if (correo.matches(ER_CORREO)) {
            this.correo = correo;
        } else {
            throw new IllegalArgumentException("ERROR: Formato de correo no válido");
        }

    }

    public String getDni(){
        return dni;
    }

    private void setDni(String dni) {
        if (dni.matches(ER_DNI)){
            comprobarLetraDni(dni);
            this.dni=dni;
        }else {
            throw new IllegalArgumentException("ERROR: Formato de DNI no válido");
        }
    }


    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }


    // Expresión regular para validar el formato de fecha de nacimiento (DD-MM-YYYY)
    public static final String FECHA_NACIMIENTO_REGEX = "\\d{2}-\\d{2}-\\d{4}";

    // Formato de fecha para el parsing
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private void setFechaNacimiento(String fechaNacimiento) {
        // Validar el formato de fecha de nacimiento

        if (fechaNacimiento.matches(FECHA_NACIMIENTO_REGEX)) {
            this.fechaNacimiento = LocalDate.parse(fechaNacimiento, DATE_FORMAT);
        } else {
            throw new IllegalArgumentException("ERROR: Formato de fecha de nacimiento no válido");
        }
    }


    private String getIniciales() {
        StringBuilder iniciales = new StringBuilder();

        // Dividir el nombre en palabras
        String[] palabras = nombre.split(" ");

        // Obtener la inicial de cada palabra
        for (String palabra : palabras) {
            if (!palabra.isEmpty()) {
                iniciales.append(palabra.charAt(0));
            }
        }
        return iniciales.toString().toUpperCase();
    }


    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Huesped huesped = (Huesped) o;
        return Objects.equals(dni, huesped.dni);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dni);
    }

    public String toString() {
        return "nombre=" + nombre +
                " ("+getIniciales()+")"+
                ", DNI=" + dni +
                ", correo=" + correo +
                ", teléfono=" + telefono +
                ", fecha nacimiento=" + fechaNacimiento;
    }

}