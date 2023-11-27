package controladores;

// Clase con los metodos del login
public class ControladorLogin {

    public boolean compararUsuario(String usuario) {
        // Compara el string ingresado con la base de datos
        return usuario.equals("Nano");
    }

    public boolean compararContraseña(String contraseña) {
        // Compara el string ingresado con la base de datos
        return contraseña.equals("1234");
    }
}
