package clases;

import java.time.LocalDate;

/**
 *
 * @author Usuario
 */
public class PersonalMedico extends Persona{
    int id;
    // La especialidad es Medico o Enfermero, manejamos con int 0 o 1 respectivamente.
    int especialidad;
    String horario;
    
    public PersonalMedico(String nombre, String apellido, String cedula, LocalDate fechaNaci) {
        super(nombre, apellido, cedula, fechaNaci);
    }
    
}
