package controladores;

import base.MetodosSQL;
import clases.Usuario;
import interfaces.FrmMenP;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

// Clase con los metodos del login
public class ControladorLogin {

    public boolean validarLogin(String usuario, String contraseña) {
        Usuario tempUser = new MetodosSQL().getUsuario(usuario);
        if (tempUser == null) {
            JOptionPane.showMessageDialog(null, "El usuario no existe, inténtelo de nuevo.");
            return false;
        }
        try {
            if (tempUser.contraseña.equals(contraseña)) {
                this.ocultarBoton(tempUser);
                return true;
            }
        } catch (Exception ex) {
            Logger.getLogger(ControladorLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null, "La contraseña es incorrecta");
        return false;
    }

    public void ocultarBoton(Usuario tempUser) {
        FrmMenP menP = new FrmMenP(tempUser);
        menP.setVisible(true);
        menP.btn_pacientes.setEnabled(true);
        menP.btn_usuarios.setEnabled(tempUser.rol == 0);
        menP.btn_citas.setEnabled(tempUser.rol == 0 || tempUser.rol == 1 || tempUser.rol == 3);
        menP.btn_consulta.setEnabled(tempUser.rol == 3);
        menP.btn_farmacia.setEnabled(tempUser.rol == 0 || tempUser.rol == 1 || tempUser.rol == 2);
        menP.btn_reportes.setEnabled(tempUser.rol == 0 || tempUser.rol == 1 || tempUser.rol == 3);
    }
    /*
        Los roles son:
        0 = Administrador
        1 = Secretario
        2 = Medico
        3 = Enfermero
    */
}
