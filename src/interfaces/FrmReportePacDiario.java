/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package interfaces;

import base.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author aliso
 */
public class FrmReportePacDiario extends javax.swing.JFrame {

    /**
     * Creates new form FrmReportePacDiario
     */
    public FrmReportePacDiario() {
        initComponents();
        this.setLocationRelativeTo(null);
         try {
            JTable("Consulta");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

     public void JTable(String tabla) throws SQLException {
        Connection con;
        con = Conexion.getConnection();
        String sql = " select * from " + tabla;
        PreparedStatement ps = con.prepareStatement(sql);

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Doctor");
        modelo.addColumn("Paciente");
        modelo.addColumn("Fecha Hora");
        modelo.addColumn("Tipo");
        modelo.addColumn("Síntomas");
        modelo.addColumn("Diagnóstico");
        modelo.addColumn("Tratamiento");
        modelo.addColumn("Observaciones");
        tablapacdiario.setModel(modelo);

        String[] datos = new String[9];
        try {

            ResultSet rs = ps.executeQuery();
    while (rs.next()) {
        datos[0] = rs.getString("id");
        datos[1] = rs.getString("doctor");
        datos[2] = rs.getString("paciente");
        datos[3] = rs.getString("fecha_hora");
        datos[4] = rs.getString("tipo");
        datos[5] = rs.getString("sintomas");
        datos[6] = rs.getString("diagnostico");
        datos[7] = rs.getString("tratamiento");
        datos[8] = rs.getString("observaciones");

        modelo.addRow(datos);
            }
        } catch (SQLException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error");
        }

    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        txtfecha = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnbuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablapacdiario = new javax.swing.JTable();
        btnactualizar = new javax.swing.JButton();
        btnregresar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 36)); // NOI18N
        jLabel2.setText("PACIENTE DIARIO");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));
        getContentPane().add(txtfecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, 310, 40));

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel3.setText("Fecha");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, -1, -1));

        btnbuscar.setBackground(new java.awt.Color(153, 153, 153));
        btnbuscar.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnbuscar.setText("BUSCAR");
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });
        getContentPane().add(btnbuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 200, -1, -1));

        tablapacdiario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tablapacdiario);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 830, 230));

        btnactualizar.setBackground(new java.awt.Color(102, 204, 0));
        btnactualizar.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnactualizar.setText("ACTUALIZAR");
        btnactualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnactualizarActionPerformed(evt);
            }
        });
        getContentPane().add(btnactualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 520, -1, -1));

        btnregresar.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnregresar.setText("Regresar");
        btnregresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregresarActionPerformed(evt);
            }
        });
        getContentPane().add(btnregresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 640, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/paciente2.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 40, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/fondoazul.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
         try {
        String fechaConsulta = txtfecha.getText().trim(); // Asume que tienes un campo de texto txtFecha para la fecha
        if (fechaConsulta.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese la fecha de la consulta.");
            return;
        }

        // Convertir la fecha de texto a un formato de fecha SQL (yyyy-MM-dd)
        LocalDate fecha = LocalDate.parse(fechaConsulta, DateTimeFormatter.ofPattern("dd/MM/yyyy")); // Ajusta el patrón de formato si es necesario
        buscarConsultasPorFecha(fecha); // Realizar la búsqueda por fecha

        if (tablapacdiario.getModel().getRowCount() == 0) {
            // No hay coincidencias
            JOptionPane.showMessageDialog(this, "No se encontraron consultas para la fecha proporcionada.");
        }
    } catch (DateTimeParseException ex) {
        JOptionPane.showMessageDialog(this, "El formato de la fecha es incorrecto. Use el formato dd/mm/yyyy.");
    }   catch (SQLException ex) {
            Logger.getLogger(FrmReportePacDiario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnbuscarActionPerformed

    private void btnactualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnactualizarActionPerformed
         try {
            JTable("Consulta");
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_btnactualizarActionPerformed

    private void btnregresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregresarActionPerformed
        FrmMenuReportes menuReportes= new FrmMenuReportes();
        menuReportes.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnregresarActionPerformed
private void buscarConsultasPorFecha(LocalDate fechaConsulta) throws SQLException {
    Connection con = Conexion.getConnection();
    String sql = "SELECT * FROM Consulta WHERE CAST(fecha_hora AS DATE) = ?"; // Asume que fecha_hora es de tipo TIMESTAMP o DATETIME en tu DB
    PreparedStatement ps = con.prepareStatement(sql);
    ps.setDate(1, java.sql.Date.valueOf(fechaConsulta)); // Establece la fecha para la consulta

    ResultSet rs = ps.executeQuery();

    DefaultTableModel modelo = (DefaultTableModel) tablapacdiario.getModel();
    modelo.setRowCount(0); // Limpiar la tabla

while (rs.next()) { // Agregar todas las filas que coincidan
    modelo.addRow(new Object[]{
        rs.getInt("id"),
        rs.getString("doctor"),
        rs.getString("paciente"),
        rs.getTimestamp("fecha_hora").toString(),
        rs.getString("tipo"),
        rs.getString("sintomas"),
        rs.getString("diagnostico"),
        rs.getString("tratamiento"),
        rs.getString("observaciones")
    });
}
rs.close();
ps.close();
}
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmReportePacDiario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmReportePacDiario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmReportePacDiario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmReportePacDiario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmReportePacDiario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnactualizar;
    public javax.swing.JButton btnbuscar;
    public javax.swing.JButton btnregresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tablapacdiario;
    public javax.swing.JTextField txtfecha;
    // End of variables declaration//GEN-END:variables
}
