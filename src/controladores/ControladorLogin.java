package controladores;

import base.MetodosSQL;
import clases.Usuario;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import utilidades.Encriptacion;

// Clase con los metodos del login
public class ControladorLogin {

    public boolean validarLogin(String usuario, String contraseña) {
        Usuario tempUser = new MetodosSQL().getUsuario(usuario);
        if (tempUser == null) {
            JOptionPane.showMessageDialog(null, "El usuario no existe, inténtelo de nuevo.");
            return false;
        }
        try {
            if (new Encriptacion().desencriptar(tempUser.contraseña).equals(contraseña)) {
                JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso.");
                return true;
            }
        } catch (Exception ex) {
            Logger.getLogger(ControladorLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null, "La contraseña es incorrecta");
        return false;
    }

    public boolean validarUsuario(String usuario) {
        Usuario tempUser = new MetodosSQL().getUsuario(usuario);
        if (tempUser == null) {
            JOptionPane.showMessageDialog(null, "El usuario no existe, inténtelo de nuevo.");
            return false;
        }
        return true;
    }

}
