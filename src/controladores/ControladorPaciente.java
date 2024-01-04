
package controladores;

import base.Conexion;
import base.MetodosSQL;
import clases.Paciente;


public class ControladorPaciente {
    public boolean insertarpaciente(Paciente pac){
        //conectar a la base de datos e insertar
        if (new MetodosSQL().crearPaciente(pac)) {
             return true;
        }
       
       return false;
    }
}
