package clases;

import java.time.LocalDate;

public class PersonalAdministrativo extends Persona {
    int ci;
    // El rol es Admin o Secretari@, manejamos con int 0 o 1 respectivamente.
    int rol;

    public PersonalAdministrativo(int ci, int rol, String horario, String nombre, String apellido, String cedula, LocalDate fechaNaci) {
        super(nombre, apellido, cedula, fechaNaci);
        this.ci = ci;
        this.rol = rol;
    }
}
