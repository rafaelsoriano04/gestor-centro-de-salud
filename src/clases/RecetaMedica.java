
package clases;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class RecetaMedica {
    public String id;
    public Paciente paciente;
    public ArrayList<Medicamento> listaMedicamentos;
    public String indicaciones;
    public LocalDate fecha;
    public int cantTot;

    public RecetaMedica(String id, Paciente paciente, String indicaciones, LocalDate fecha,int cantTot) {
        this.id = id;
        this.paciente = paciente;
        this.cantTot = cantTot;
        this.indicaciones = indicaciones;
        this.fecha = fecha;
    }
    public RecetaMedica(String id, Paciente paciente,  String indicaciones, LocalDate fecha, int cantTot, ArrayList<Medicamento> listaMedicamentos) {
        this.id = id;
        this.paciente = paciente;
        this.listaMedicamentos = listaMedicamentos;
        this.indicaciones = indicaciones;
        this.fecha = fecha;
        this.cantTot = cantTot;
    }
    
    
    
}


