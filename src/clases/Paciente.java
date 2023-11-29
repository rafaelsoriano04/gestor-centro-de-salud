package clases;

import java.time.LocalDate;

/**
 *
 * @author Usuario
 */
public class Paciente extends Persona {
    String tipoSagre;
    String genero;
    String antededentes;
    String altura;
    String peso;
    
    
    public Paciente(String nombre, String apellido, String cedula, LocalDate fechaNaci, String tipo, String gene,String altura,
            String peso, String antecedentes) {
        super(nombre, apellido, cedula, fechaNaci);
        this.tipoSagre = tipo;
        this.genero = gene;
        this.altura = altura;
        this.peso = peso;
        this.antededentes = antededentes;
        
    }
    
}
