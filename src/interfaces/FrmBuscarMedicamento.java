/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package interfaces;

import base.Conexion;
import base.MetodosSQL;
import clases.Medicamento;
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
public class FrmBuscarMedicamento extends javax.swing.JFrame {

    /**
     * Creates new form FrmBuscarMedicamento
     */
    public FrmBuscarMedicamento() {
        initComponents();
        this.setLocationRelativeTo(null);
          try {
            JTable("Medicamento");
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
        modelo.addColumn("Nombre");
        modelo.addColumn("Especificaciones");
        modelo.addColumn("Registro Sanitario");
        modelo.addColumn("Precio");
        modelo.addColumn("Cantidad");
        tablamedicamento.setModel(modelo);

        String[] datos = new String[6];
        try {

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                datos[5] = rs.getString(6);

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
        jScrollPane1 = new javax.swing.JScrollPane();
        tablamedicamento = new javax.swing.JTable();
        btnactualizar = new javax.swing.JButton();
        btnregresar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        btnbuscar = new javax.swing.JButton();
        btnmodificar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/buscar2.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 40, -1, -1));

        tablamedicamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Especificaciones", "Registro Sanitario", "Precio", "Cantidad"
            }
        ));
        jScrollPane1.setViewportView(tablamedicamento);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 730, 270));

        btnactualizar.setBackground(new java.awt.Color(51, 204, 0));
        btnactualizar.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnactualizar.setText("Actualizar");
        btnactualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnactualizarActionPerformed(evt);
            }
        });
        getContentPane().add(btnactualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 530, 140, 40));

        btnregresar.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnregresar.setText("Regresar");
        btnregresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregresarActionPerformed(evt);
            }
        });
        getContentPane().add(btnregresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 590, 110, 40));

        btneliminar.setBackground(new java.awt.Color(204, 0, 0));
        btneliminar.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btneliminar.setText("Eliminar");
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btneliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 530, 110, 40));

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel3.setText("ID");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, -1, -1));
        getContentPane().add(txtid, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, 300, 30));

        btnbuscar.setBackground(new java.awt.Color(153, 153, 153));
        btnbuscar.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnbuscar.setText("Buscar");
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });
        getContentPane().add(btnbuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 180, 110, 30));

        btnmodificar.setBackground(new java.awt.Color(255, 255, 0));
        btnmodificar.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnmodificar.setText("Modificar");
        btnmodificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmodificarActionPerformed(evt);
            }
        });
        getContentPane().add(btnmodificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 530, 110, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/buscarmedicamento.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, 830, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnactualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnactualizarActionPerformed
        try {
            JTable("Medicamento");
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_btnactualizarActionPerformed

    private void btnregresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregresarActionPerformed
        FrmMenuMedicamento menumedi= new FrmMenuMedicamento();
        menumedi.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnregresarActionPerformed

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
        try {
        String idTexto = txtid.getText().trim();
        if (idTexto.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un ID.");
            return;
        }

        int id = Integer.parseInt(idTexto); // Convertir a entero
        buscarMedicamentoPorId(id); // Realizar la búsqueda

        if (tablamedicamento.getModel().getRowCount() == 0) {
            // No hay coincidencias
            JOptionPane.showMessageDialog(this, "No se encontraron medicamentos con el ID proporcionado.");
        }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Por favor, ingrese un ID válido.");
    } catch (SQLException ex) { 
        Logger.getLogger(FrmBuscarMedicamento.class.getName()).log(Level.SEVERE, null, ex);
    }  
    }//GEN-LAST:event_btnbuscarActionPerformed
private void buscarMedicamentoPorId(int id) throws SQLException {
    Connection con = Conexion.getConnection();
    String sql = "SELECT * FROM Medicamento WHERE CAST(id AS VARCHAR) LIKE ?";
    PreparedStatement ps = con.prepareStatement(sql);
    ps.setString(1, id + "%"); // Añade el comodín % al final del texto de búsqueda

    ResultSet rs = ps.executeQuery();

    DefaultTableModel modelo = (DefaultTableModel) tablamedicamento.getModel();
    modelo.setRowCount(0); // Limpiar la tabla

    while (rs.next()) { // Agregar todas las filas que coincidan
        modelo.addRow(new Object[]{
            rs.getInt("id"),
            rs.getString("nombre"),
            rs.getString("especificaciones"),
            rs.getString("RegistroSanitario"),
            rs.getDouble("precio"),
            rs.getInt("cantidad")
        });
    }
}
    private void btnmodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmodificarActionPerformed
         int filaSeleccionada = tablamedicamento.getSelectedRow();
    if (filaSeleccionada != -1) { // Verificar si se seleccionó alguna fila
        // Obtener los datos de la fila seleccionada
        int id = Integer.parseInt(tablamedicamento.getValueAt(filaSeleccionada, 0).toString());
        String nombre = tablamedicamento.getValueAt(filaSeleccionada, 1).toString();
        String especificaciones = tablamedicamento.getValueAt(filaSeleccionada, 2).toString();
        String regisSani = tablamedicamento.getValueAt(filaSeleccionada, 3).toString();
        double precio = Double.parseDouble(tablamedicamento.getValueAt(filaSeleccionada, 4).toString());
        int cantidad = Integer.parseInt(tablamedicamento.getValueAt(filaSeleccionada, 5).toString());

        Medicamento medicamentoSeleccionado = new Medicamento(id, nombre, especificaciones, regisSani, precio, cantidad);

        FrmModificarMedicamento modimedi = new FrmModificarMedicamento(medicamentoSeleccionado);
        modimedi.setVisible(true);
        this.dispose();
    } else {
        JOptionPane.showMessageDialog(this, "Por favor, seleccione un medicamento de la lista.");
    }
    }//GEN-LAST:event_btnmodificarActionPerformed

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
       
   int filaSeleccionada = tablamedicamento.getSelectedRow();
    if (filaSeleccionada != -1) { 
        int id = Integer.parseInt(tablamedicamento.getValueAt(filaSeleccionada, 0).toString());
        
        if (new MetodosSQL().eliminarMedicamento(id)) {
            JOptionPane.showMessageDialog(this, "Medicamento eliminado con éxito.");
            
            
            try {
                JTable("Medicamento");
            } catch (Exception e) {
                System.out.println(e);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Error al eliminar el medicamento.");
        }
    } else {
        JOptionPane.showMessageDialog(this, "Por favor, seleccione un medicamento de la lista.");
    }
    }//GEN-LAST:event_btneliminarActionPerformed

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
            java.util.logging.Logger.getLogger(FrmBuscarMedicamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmBuscarMedicamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmBuscarMedicamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmBuscarMedicamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmBuscarMedicamento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnactualizar;
    public javax.swing.JButton btnbuscar;
    public javax.swing.JButton btneliminar;
    public javax.swing.JButton btnmodificar;
    public javax.swing.JButton btnregresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tablamedicamento;
    public javax.swing.JTextField txtid;
    // End of variables declaration//GEN-END:variables

    
}
