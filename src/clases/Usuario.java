package clases;

import java.util.ArrayList;

public class Usuario {
    public String usuario, contraseña;
    public String ci, nombre, apellido;
    /* 
    Los roles son:
    0 = Administrador
    1 = Secretario
    2 = Medico
    3 = Enfermero
    */
    public int rol;
    /*
    Preguntas de seguridad:
    1. Primera mascota
    2. En que ciudad se conocieron tus padres
    3. Nombre de la primera escuela a la que
    4. Nombre de tu primera mascota
    */
    public ArrayList<String> respuestas;

    public Usuario(String usuario, String contraseña, int rol, ArrayList<String> respuestas, String ci,
            String nombre, String apellido) {
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.rol = rol;
        this.respuestas = respuestas;
        this.ci = ci;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Usuario(String usuario, String ci, String nombre, String apellido, int rol) {
        this.usuario = usuario;
        this.ci = ci;
        this.nombre = nombre;
        this.apellido = apellido;
        this.rol = rol;
        this.respuestas = new ArrayList<>();
    }

    public Usuario() {
        this.respuestas = new ArrayList<>();
    }
    
    public void setRespuestas(ArrayList<String> respuestas) {
        this.respuestas = respuestas;
    }
    
}

