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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author aliso
 */
public class FrmReportePacEs extends javax.swing.JFrame {

    /**
     * Creates new form FrmReportePacEs
     */
    public FrmReportePacEs() {
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
        tablapacespecifico.setModel(modelo);

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
        txtnombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnbuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablapacespecifico = new javax.swing.JTable();
        btnactualizar = new javax.swing.JButton();
        btnregresar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 36)); // NOI18N
        jLabel2.setText("PACIENTE ESPECÍFICO");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));
        getContentPane().add(txtnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, 310, 40));

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel3.setText("Cédula del Paciente");
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

        tablapacespecifico.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablapacespecifico);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 820, 230));

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

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/paciente1.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 40, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/fondoazul.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
         try {
        String cedulaPaciente = txtnombre.getText().trim(); 
        if (cedulaPaciente.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese la cédula del paciente.");
            return;
        }

        buscarPacientePorCedula(cedulaPaciente); // Realizar la búsqueda por cédula

        if (tablapacespecifico.getModel().getRowCount() == 0) {
            // No hay coincidencias
            JOptionPane.showMessageDialog(this, "No se encontraron pacientes con la cédula proporcionada.");
        }
    } catch (SQLException ex) { 
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error al realizar la búsqueda: " + ex.getMessage());
    }  
    }//GEN-LAST:event_btnbuscarActionPerformed
private void buscarPacientePorCedula(String cedulaPaciente) throws SQLException {
    Connection con = Conexion.getConnection();
    String sql = "SELECT * FROM Consulta WHERE paciente LIKE ?";
    PreparedStatement ps = con.prepareStatement(sql);
    ps.setString(1, cedulaPaciente + "%"); // Buscar por cédula que comience con la secuencia proporcionada

    ResultSet rs = ps.executeQuery();

    DefaultTableModel modelo = (DefaultTableModel) tablapacespecifico.getModel();
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
    ps.close();
    rs.close();
}


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
            java.util.logging.Logger.getLogger(FrmReportePacEs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmReportePacEs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmReportePacEs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmReportePacEs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmReportePacEs().setVisible(true);
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
    public javax.swing.JTable tablapacespecifico;
    public javax.swing.JTextField txtnombre;
    // End of variables declaration//GEN-END:variables
}
