package clases;

/**
 *
 * @author Usuario
 */
public class PersonalMedico extends Persona {
    int ci;
    // La especialidad es Medico o Enfermero, manejamos con int 0 o 1 respectivamente.
    int especialidad;

    public PersonalMedico(int ci, int especialidad, String nombre, String apellido, String cedula) {
        super(nombre, apellido, cedula);
        this.ci = ci;
        this.especialidad = especialidad;
    }
}
