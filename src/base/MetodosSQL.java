package base;

import clases.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilidades.Encriptacion;

/**
 *
 * @author Usuario
 */
public class MetodosSQL {

    public Usuario getUsuario(String nombreUsuario) {
        Connection conn = null;
        PreparedStatement ps = null;
        Usuario usuario = null;

        try {
            conn = Conexion.getConnection();

            String query = "SELECT usuario, contraseña, rol, pregunta1, pregunta2, pregunta3, pregunta4 FROM Usuarios WHERE usuario = ?";
            ps = conn.prepareStatement(query);
            ps.setString(1, nombreUsuario);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String usuarioDB = rs.getString("usuario");
                String contraseñaDB = rs.getString("contraseña");
                int rolDB = rs.getInt("rol");
                String pregunta1 = rs.getString("pregunta1");
                String pregunta2 = rs.getString("pregunta2");
                String pregunta3 = rs.getString("pregunta3");
                String pregunta4 = rs.getString("pregunta4");
                ArrayList<String> respuestas = new ArrayList<>();
                respuestas.add(new Encriptacion().desencriptar(pregunta1));
                respuestas.add(new Encriptacion().desencriptar(pregunta2));
                respuestas.add(new Encriptacion().desencriptar(pregunta3));
                respuestas.add(new Encriptacion().desencriptar(pregunta4));

                usuario = new Usuario(usuarioDB, contraseñaDB, rolDB, respuestas);
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (Exception ex) {
            Logger.getLogger(MetodosSQL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conn != null) {
                Conexion.cerrarConexion();
            }
        }

        return usuario;
    }

    public boolean updateContraseña(String nombreUsuario, String nuevaContraseña) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = Conexion.getConnection();

            String query = "UPDATE Usuarios SET contraseña = ? WHERE usuario = ?";
            ps = conn.prepareStatement(query);
            ps.setString(1, nuevaContraseña);
            ps.setString(2, nombreUsuario);

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("La contraseña ha sido actualizada correctamente.");
                return true;
            } else {
                System.out.println("No se pudo actualizar la contraseña para el usuario " + nombreUsuario);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (conn != null) {
                Conexion.cerrarConexion();
            }
        }
        return false;
    }

}
