package clases;

import java.time.LocalDate;

/**
 *
 * @author Usuario
 */
public class Paciente extends Persona {
    String tipoSagre;
    Boolean genero;
    String antededentes;
    float altura;
    float peso;
    
    
    public Paciente(String nombre, String apellido, String cedula, LocalDate fechaNaci) {
        super(nombre, apellido, cedula, fechaNaci);
        
    }
    
}
