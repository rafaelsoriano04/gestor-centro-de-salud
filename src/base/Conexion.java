package base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
    protected final String jdbcUrl = "jdbc:sqlserver://nano-server.database.windows.net:1433;database=Centro_de_Salud;user=CloudSAb6453eac@nano-server;password=Molly2023;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
    protected static Connection connection = null;

    public Conexion() {
        try {
            // Cargar el controlador JDBC
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el controlador JDBC: " + e.getMessage());
        }
    }

    public boolean getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(jdbcUrl);
                System.out.println("Conectado");
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

}
