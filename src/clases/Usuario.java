package clases;

import java.util.ArrayList;

public class Usuario {
    public String usuario, contraseña;
    String ci;
    /* 
    Los roles son:
    0 = Administrador
    1 = Secretario
    2 = Medico
    3 = Enfermero
    */
    int rol;
    /*
    Preguntas de seguridad:
    1. Primera mascota
    2. En que ciudad se conocieron tus padres
    3. Nombre de la primera escuela a la que
    4. Nombre de tu primera mascota
    */
    public ArrayList<String> respuestas;

    public Usuario(String usuario, String contraseña, int rol, ArrayList<String> respuestas) {
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.rol = rol;
        this.respuestas = respuestas;
    }


}
