package base;

import clases.Paciente;
import clases.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

    //Crear Paciente
    public boolean crearPaciente(Paciente pac) {
        Connection con = null;
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String fechaComoCadena = pac.fechaNaci.format(formatter);
            con = Conexion.getConnection();
            String sql = "INSERT INTO paciente (cedula, nombre, apellido, fechaNacimiento, tipoSangre, "
                    + "genero, altura, peso, antecedente) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, Integer.valueOf(pac.getCedula())); // cedula es un entero
            pstmt.setString(2, pac.nombre); // nombre es una cadena de texto
            pstmt.setString(3, pac.apellido); // apellido es una cadena de texto
            pstmt.setString(4, fechaComoCadena); // fechaNacimiento es una cadena de texto
            pstmt.setString(5, pac.tipoSagre); // tipoSangre es una cadena de texto
            pstmt.setString(6, pac.genero); // genero es una cadena de texto
            pstmt.setInt(7, Integer.valueOf(pac.altura)); // altura es un entero
            pstmt.setInt(8, Integer.valueOf(pac.peso)); // peso es un entero
            pstmt.setString(9, pac.antededentes);
            pstmt.executeUpdate();
            pstmt.close();

        } catch (Exception e) {
            System.out.println(e);
        }

        return false;
    }

    public boolean modificarPaciente(Paciente pac) {
        Connection con = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String fechaComoCadena = pac.fechaNaci.format(formatter);
            con = Conexion.getConnection();
        String sql = "UPDATE paciente SET nombre = ?, apellido = ?, fechaNacimiento = ?, tipoSangre = ?, genero = ?, "
                + "altura = ?, peso = ?, antecedente = ? WHERE cedula = ?";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, pac.nombre);
            pstmt.setString(2, pac.apellido);
            pstmt.setString(3, fechaComoCadena); 
            pstmt.setString(4, pac.tipoSagre);
            pstmt.setString(5, pac.genero);
            pstmt.setInt(6, Integer.valueOf(pac.altura));
            pstmt.setInt(7, Integer.valueOf(pac.peso));
            pstmt.setString(8, pac.antededentes);
            pstmt.setInt(9, Integer.valueOf(pac.cedula));

            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    public Paciente obtenerPacientePorCedula(String cedula) {
        Connection con = null;
        Paciente paciente = null;
        String sql = "SELECT * FROM paciente WHERE cedula = ?";
        con = Conexion.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, cedula);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                // Asume que tienes un constructor adecuado en tu clase Paciente
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                paciente = new Paciente(
                        
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        String.valueOf(rs.getInt("cedula")),
                        LocalDate.parse(rs.getString("fechaNacimiento"), formatter),
                        rs.getString("tipoSangre"),
                        rs.getString("genero"),
                        String.valueOf(rs.getInt("altura")),
                        String.valueOf(rs.getInt("peso")),
                        rs.getString("antecedente")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return paciente;
    }
    
    
    public boolean eliminarPacientePorCedula(String cedula) {
    String sql = "DELETE FROM paciente WHERE cedula = ?";
    Connection con = null;
    con = Conexion.getConnection();
    try (PreparedStatement pstmt = con.prepareStatement(sql)) {
        pstmt.setString(1, cedula);
        int affectedRows = pstmt.executeUpdate();
        return affectedRows > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}

}
