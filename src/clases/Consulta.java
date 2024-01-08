package clases;

import java.time.LocalDate;

public class Consulta {

    public int numconsulta, paciente,doctor;
    public LocalDate fecha;
    public String tipo, signos, diagnostico, tratamiento, observacion;

    public Consulta(int numconsulta, int paciente,int doctor, LocalDate fecha, String tipo, String signos, String diagnostico, String tratamiento, String observacion) {
        this.numconsulta = numconsulta;
        this.paciente = paciente;
        this.fecha = fecha;
        this.tipo = tipo;
        this.signos = signos;
        this.diagnostico = diagnostico;
        this.tratamiento = tratamiento;
        this.observacion = observacion;
        this.doctor = doctor;
    }

}
