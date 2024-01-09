

package base;

import clases.Cita;
import clases.Consulta;
import clases.Paciente;
import clases.PersonalMedico;
import clases.Usuario;
import java.awt.List;
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


public class MetodosSQL {
    public boolean guardarRecM(RecetaMedica receta) {
        Connection con = null;
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String fechaComoCadena = receta.fecha.format(formatter);
            con = Conexion.getConnection();
            String sql = "INSERT INTO receta (id, ciP, indicaciones, fecha, cantTolMed) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, receta.id); // apellido es una cadena de texto
            pstmt.setString(2, receta.paciente.cedula); // fechaNacimiento es una cadena de texto
            pstmt.setString(3, receta.indicaciones); // tipoSangre es una cadena de texto
            pstmt.setString(4, fechaComoCadena); // genero es una cadena de texto
            pstmt.setInt(5, Integer.valueOf(receta.cantTot));
            pstmt.executeUpdate();
            this.guardarMedRM();
            pstmt.close();
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }

        return false;

    }

    public boolean guardarMedRM() throws SQLException {
        Connection con = null;

        try {
            con = Conexion.getConnection();
            for (int i = 0; i < medicamentosList.size(); i++) {

                String sql = "INSERT INTO medRM (numRM,nombre,cantidad) VALUES (?, ?, ?)";
                PreparedStatement pstmt = con.prepareStatement(sql);
                pstmt.setString(1, medicamentosList.get(i).numRM);
                pstmt.setString(2, medicamentosList.get(i).nombre);
                pstmt.setInt(3, medicamentosList.get(i).cantidad);

                pstmt.executeUpdate();

            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return false;

    }

    public RecetaMedica obtenerRecetaPorId(String id) {
        Connection con = null;
        RecetaMedica receta = null;
        String sql = "SELECT * FROM receta WHERE id = ?";
        con = Conexion.getConnection();

        try ( PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                // Asume que tienes un método obtenerPacientePorCedula en tu clase Paciente
                Paciente paciente = obtenerPacientePorCedula(rs.getString("ciP"));

                if (paciente != null) {
                    // Asume que tienes un constructor adecuado en tu clase Receta
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                    receta = new RecetaMedica(
                            rs.getString("id"),
                            paciente,
                            rs.getString("indicaciones"),
                            LocalDate.parse(rs.getString("fecha"), formatter),
                            rs.getInt("cantTotMed")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return receta;
    }
    public String codRM() {
        Connection con = null;
        String siguienteId = "001"; // Valor predeterminado si no hay registros existentes

        String sql = "SELECT MAX(id) AS maxId FROM receta";
        con = Conexion.getConnection();

        try ( PreparedStatement pstmt = con.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String maxId = rs.getString("maxId");
                if (maxId != null) {
                    int numero = Integer.parseInt(maxId) + 1;
                    siguienteId = String.format("%03d", numero);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return siguienteId;
    }
    public void llenarComboRM(JComboBox<Medicamento> medicamentos, String name) {
        Connection con = null;

        String sql = "SELECT * FROM Medicamento WHERE nombre LIKE ?";

        try {
            con = Conexion.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, name + "%");
            ResultSet rs = pstmt.executeQuery();

            // Limpia el JComboBox antes de llenarlo
            medicamentos.removeAllItems();

            boolean encontrado = false; // Variable para verificar si se encontraron resultados

            while (rs.next()) {
                Medicamento medicamento = new Medicamento(rs.getInt("id"), rs.getString("nombre"));
                medicamentos.addItem(medicamento);
                encontrado = true; // Se encontraron resultados
            }

            if (!encontrado) {
                JOptionPane.showMessageDialog(null, "No se encontraron medicamentos con el nombre proporcionado");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Medicamento buscarMedicamento(String idNombre, JComboBox<Medicamento> comboBox) {
        Connection con = null;
        Medicamento medicamento = null;
        String sql;

        sql = "SELECT * FROM Medicamento WHERE id = ?";

        con = Conexion.getConnection();
        try ( PreparedStatement pstmt = con.prepareStatement(sql)) {
            if (sql.contains("?")) {
                pstmt.setString(1, idNombre);
            }

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                // Asume que tienes un constructor adecuado en tu clase Medicamento

                medicamento = new Medicamento(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("especificaciones"),
                        rs.getString("RegistroSanitario"),
                        rs.getDouble("precio"),
                        rs.getInt("cantidad")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return medicamento;
    }
    public Usuario getUsuario(String nombreUsuario) {
        Connection conn = null;
        PreparedStatement ps = null;
        Usuario usuario = null;

        try {
            conn = Conexion.getConnection();
            String query = "SELECT usuario, ci, contraseña, rol, pregunta1, pregunta2, pregunta3, pregunta4, nombre, apellido FROM Usuarios WHERE usuario = ?";
            ps = conn.prepareStatement(query);
            ps.setString(1, nombreUsuario);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String usuarioDB = rs.getString("usuario");
                String ci = rs.getString("ci");
                String contraseñaDB = new Encriptacion().desencriptar(rs.getString("contraseña"));
                int rolDB = rs.getInt("rol");
                String pregunta1 = rs.getString("pregunta1");
                String pregunta2 = rs.getString("pregunta2");
                String pregunta3 = rs.getString("pregunta3");
                String pregunta4 = rs.getString("pregunta4");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                ArrayList<String> respuestas = new ArrayList<>();
                respuestas.add(new Encriptacion().desencriptar(pregunta1));
                respuestas.add(new Encriptacion().desencriptar(pregunta2));
                respuestas.add(new Encriptacion().desencriptar(pregunta3));
                respuestas.add(new Encriptacion().desencriptar(pregunta4));

                usuario = new Usuario(usuarioDB, contraseñaDB, rolDB, respuestas, ci, nombre, apellido);
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
    
    public boolean updateUsuario(String usuario, String nuevoUsuario, String nombre, String apellido) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = Conexion.getConnection();
            String query = "UPDATE Usuarios SET usuario = ?, nombre = ?, apellido = ? WHERE usuario = ?";

            ps = conn.prepareStatement(query);
            ps.setString(1, nuevoUsuario);
            ps.setString(2, nombre);
            ps.setString(3, apellido);
            ps.setString(4, usuario);

            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (conn != null) {
                Conexion.cerrarConexion();
            }
        }
        return false;
    }
    
    public boolean eliminarUsuario(String usuario) {
        String sql = "DELETE FROM Usuarios WHERE usuario = ?";
        Connection con = null;
        con = Conexion.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, usuario);
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public ArrayList<Usuario> traerUsuarios() {
        ArrayList<Usuario> listaUsuarios = new ArrayList<>();
        String sql = "SELECT * FROM Usuarios";

        try (Connection conn = Conexion.getConnection(); Statement st = conn.createStatement(); ResultSet resultSet = st.executeQuery(sql)) {
            while (resultSet.next()) {
                int rol = resultSet.getInt("rol");
                String ci = resultSet.getString("ci");
                String usuario = resultSet.getString("usuario");
                String nombre = resultSet.getString("nombre");
                String apellido = resultSet.getString("apellido");
                Usuario u = new Usuario(usuario, ci, nombre, apellido, rol);
                listaUsuarios.add(u);
                // Aquí debes crear un nuevo objeto Usuario y añadirlo a listaUsuarios
                // Por ejemplo: listaUsuarios.add(new Usuario(ci, nombre, apellido, usuario, rol));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaUsuarios;
    }

    public ArrayList<Usuario> traerUsuariosSimilares(String patron) {
        ArrayList<Usuario> listaUsuarios = new ArrayList<>();
        String sql = "SELECT * FROM Usuarios WHERE ci LIKE ? || '%'";

        try (Connection conn = Conexion.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, patron);

            try (ResultSet resultSet = ps.executeQuery()) {
                while (resultSet.next()) {
                    int rol = resultSet.getInt("rol");
                    String ci = resultSet.getString("ci");
                    String usuario = resultSet.getString("usuario");
                    String nombre = resultSet.getString("nombre");
                    String apellido = resultSet.getString("apellido");

                    Usuario u = new Usuario(usuario, ci, nombre, apellido, rol);
                    listaUsuarios.add(u);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaUsuarios;
    }

    public boolean crearUsuario(Usuario u) {
        Connection con = null;
        try {
            con = Conexion.getConnection();
            String sql = "INSERT INTO Usuarios (usuario, ci, contraseña, rol, pregunta1, pregunta2, pregunta3, pregunta4, nombre, apellido)"
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, u.usuario);
            ps.setString(2, u.ci);
            ps.setString(3, new Encriptacion().encriptar(u.contraseña));
            ps.setInt(4, u.rol);
            ps.setString(5, new Encriptacion().encriptar(u.respuestas.get(0)));
            ps.setString(6, new Encriptacion().encriptar(u.respuestas.get(1)));
            ps.setString(7, new Encriptacion().encriptar(u.respuestas.get(2)));
            ps.setString(8, new Encriptacion().encriptar(u.respuestas.get(3)));
            ps.setString(9, u.nombre);
            ps.setString(10, u.apellido);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
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
            Conexion.cerrarConexion();
            return affectedRows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean crearCita(int paciente, int doctor, LocalDate fechaHora) {
        if (contarCitasFecha(doctor, fechaHora) < 5) {
            Connection con = null;
            con = Conexion.getConnection();
            String sql = "INSERT INTO CitasMedicas (doctor, paciente, fecha_hora, estado) VALUES (?, ?, ?,?)";
            try (PreparedStatement pstmt = con.prepareStatement(sql)) {
                pstmt.setInt(1, doctor);
                pstmt.setInt(2, paciente);
                pstmt.setDate(3, java.sql.Date.valueOf(fechaHora));
                pstmt.setString(4, "Pendiente");
                int affectedRows = pstmt.executeUpdate();
                Conexion.cerrarConexion();
                if (affectedRows > 0) {
                    return true; // La cita fue creada exitosamente
                }

            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

    public int contarCitasFecha(int doctor, LocalDate fecha) {
        int contadorCitas = 0;

        String sql = "SELECT COUNT(*) FROM CitasMedicas WHERE doctor = ? AND CAST(fecha_hora AS DATE) = ?";
        Connection con = null;
        con = Conexion.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, doctor);
            pstmt.setDate(2, java.sql.Date.valueOf(fecha));
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    contadorCitas = rs.getInt(1);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();

        }
        Conexion.cerrarConexion();
        return contadorCitas;
    }

    public ArrayList<PersonalMedico> llenarMedicos() {
        ArrayList<PersonalMedico> nombres = new ArrayList<>();
        Connection con = null;
        try {
            con = Conexion.getConnection();
            String sql = "SELECT nombre, apellido, cedula FROM PersonalMedico";
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                String nombreMedico = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                int cedula = rs.getInt("cedula");
                PersonalMedico p = new PersonalMedico(nombreMedico, apellido, String.valueOf(cedula), LocalDate.now());
                nombres.add(p);
            }

            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return nombres;
    }

    public ArrayList<Cita> llenarCitas(String cedula) {
        ArrayList<Cita> nombres = new ArrayList<>();
        Connection con = null;
        try {
            con = Conexion.getConnection();
            String sql = "SELECT CitasMedicas.id, PersonalMedico.nombre AS nombreme, PersonalMedico.apellido AS apeme, CitasMedicas.fecha_hora,"
                    + " CitasMedicas.estado \n"
                    + "FROM CitasMedicas \n"
                    + "JOIN PersonalMedico ON CitasMedicas.doctor = PersonalMedico.cedula \n"
                    + "WHERE CitasMedicas.paciente = ";
            sql = sql + cedula;

            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String doctor = "Dr/a. " + rs.getString("nombreme");
                doctor = doctor + " " + rs.getString("apeme");
                String estado = rs.getString("estado");
                LocalDate fecha = rs.getDate("fecha_hora").toLocalDate();
                Cita c = new Cita(id, cedula, doctor, fecha, estado);
                nombres.add(c);
            }

            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return nombres;
    }

    public boolean eliminarCita(String id) {
        String sql = "DELETE FROM CitasMedicas WHERE id = ?";
        Connection con = null;
        con = Conexion.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, id);
            int affectedRows = pstmt.executeUpdate();
            Conexion.cerrarConexion();
            return affectedRows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean crearConsulta(Consulta consulta) {
        String sql = "INSERT INTO Consulta ( paciente, doctor, fecha_hora, tipo, sintomas, diagnostico, tratamiento, observaciones) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?)";
        LocalDate localDate = LocalDate.now();

        java.sql.Date sqlDate = java.sql.Date.valueOf(localDate);
        
        
        try (Connection con = Conexion.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setInt(1, consulta.paciente);
            pstmt.setInt(2, consulta.doctor);
            pstmt.setDate(3, sqlDate);
            pstmt.setString(4, consulta.tipo);
            pstmt.setString(5, consulta.signos);
            pstmt.setString(6, consulta.diagnostico);
            pstmt.setString(7, consulta.tratamiento);
            pstmt.setString(8, consulta.observacion);
            System.out.println(sql);
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            // Podrías lanzar una excepción personalizada o manejarlo según tu lógica de negocio
            return false;
        }
    }
    
    public ArrayList<Consulta> llenarCOnsultas(int paciente, int doctor) {
        ArrayList<Consulta> nombres = new ArrayList<>();
        Connection con = null;
        try {
            con = Conexion.getConnection();
            String sql = "SELECT * FROM Consulta WHERE paciente = ? AND doctor = ?";
            
            PreparedStatement pstmt = con.prepareStatement(sql);
            
            pstmt.setInt(1, paciente); // idPaciente es una variable que contiene el ID del paciente
            pstmt.setInt(2, doctor);
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                Consulta c = new Consulta(rs.getInt("id"), rs.getInt("paciente"), rs.getInt("doctor"), 
                        rs.getDate("fecha_hora").toLocalDate(), rs.getString("tipo"), rs.getString("sintomas"), 
                        rs.getString("diagnostico"), rs.getString("tratamiento"), rs.getString("observaciones"));
                
                nombres.add(c);
            }

            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return nombres;
    }
    
    public boolean eliminarConsulta(int id) {
        String sql = "DELETE FROM Consulta WHERE id = ?";
        Connection con = null;
        con = Conexion.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            int affectedRows = pstmt.executeUpdate();
            Conexion.cerrarConexion();
            return affectedRows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean modificarConsulta(Consulta consulta) {
        Connection con = null;
        
        con = Conexion.getConnection();
        String sql = "UPDATE Consulta SET tipo = ?, sintomas = ?, diagnostico = ?, tratamiento = ?, observaciones = ? WHERE id = ?";
        
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, consulta.tipo);
            pstmt.setString(2, consulta.signos);
            pstmt.setString(3, consulta.diagnostico);
            pstmt.setString(4, consulta.tratamiento);
            pstmt.setString(5, consulta.observacion);
            pstmt.setInt(6, consulta.numconsulta);
            

            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    
       }
}

