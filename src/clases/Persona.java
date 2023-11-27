package clases;

import java.time.LocalDate;
import java.time.Period;

public class Persona {

    String nombre;
    String apellido;
    String cedula;
    LocalDate fechaNaci;

    public Persona(String nombre, String apellido, String cedula, LocalDate fechaNaci) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.fechaNaci = fechaNaci;
    }

    // LocalDate.of(1990, 5, 15)
    public int edad() {
        LocalDate ahora = LocalDate.now();
        Period periodo = Period.between(this.fechaNaci, ahora);
        return periodo.getYears();
    }

    @Override
    public String toString() {
        return "Nombre y apellido: " + nombreApell() + "\nEdad: " + edad();
    }

    public String nombreApell() {
        return this.nombre + " " + this.apellido;
    }

    public String getCedula() {
        return this.cedula;
    }

}
