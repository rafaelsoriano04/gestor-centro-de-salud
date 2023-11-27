package clases;

public class Usuario {
    String usuario, contraseña;
    Persona persona;
    int rol;
    
    /* Los roles son:
    0 = Administrador
    1 = Secretario
    2 = Medico
    3 = Enfermero
    */

    public Usuario(String usuario, String contraseña, Persona persona, int rol) {
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.persona = persona;
        this.rol = rol;
    }
}
