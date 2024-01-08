package clases;

import java.time.LocalDate;

/**
 *
 * @author Usuario
 */
public class Cita {
    public int numeroCita;
    public String paciente;
    public String medico;
    public LocalDate fecha;
    public String estado;

    public Cita(int numeroCita, String paciente, String medico, LocalDate fecha, String estado) {
        this.numeroCita = numeroCita;
        this.paciente = paciente;
        this.medico = medico;
        this.fecha = fecha;
        this.estado = estado;
    }

    @Override
    public String toString() {
        return String.valueOf(numeroCita);
    }
    
    

    
    
}
