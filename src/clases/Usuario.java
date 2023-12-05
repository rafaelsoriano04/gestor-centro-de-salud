package clases;

public class Usuario {
    public String usuario, contraseña;
    String ci;
    int rol;
    
    /* Los roles son:
    0 = Administrador
    1 = Secretario
    2 = Medico
    3 = Enfermero
    */

    public Usuario(String usuario, String contraseña, int rol) {
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.rol = rol;
    }
}
