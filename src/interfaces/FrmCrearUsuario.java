/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package interfaces;

/**
 *
 * @author Usuario
 */
public class FrmCrearUsuario extends javax.swing.JFrame {

    /**
     * Creates new form FrmCrearUs
     */
    public FrmCrearUsuario() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel7 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        rol = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        Administrador = new javax.swing.JCheckBox();
        Administrador1 = new javax.swing.JCheckBox();
        Administrador2 = new javax.swing.JCheckBox();
        Administrador3 = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel7.setBackground(new java.awt.Color(204, 204, 204));
        jPanel7.setDoubleBuffered(false);
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Registro");
        jPanel7.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, -1, -1));

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Apellido:");
        jPanel7.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Nombre:");
        jPanel7.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));
        jPanel7.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 190, -1));
        jPanel7.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 190, -1));

        rol.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        rol.setForeground(new java.awt.Color(0, 0, 0));
        rol.setText("Rol:");
        jPanel7.add(rol, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, -1));
        jPanel7.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 190, -1));

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Cedula:");
        jPanel7.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        Administrador.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        Administrador.setForeground(new java.awt.Color(0, 0, 0));
        Administrador.setText("Medico");
        Administrador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdministradorActionPerformed(evt);
            }
        });
        jPanel7.add(Administrador, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 220, -1, -1));

        Administrador1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        Administrador1.setForeground(new java.awt.Color(0, 0, 0));
        Administrador1.setText("Admin");
        Administrador1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Administrador1ActionPerformed(evt);
            }
        });
        jPanel7.add(Administrador1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, -1, -1));

        Administrador2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        Administrador2.setForeground(new java.awt.Color(0, 0, 0));
        Administrador2.setText("Enfermero");
        jPanel7.add(Administrador2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 250, -1, -1));

        Administrador3.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        Administrador3.setForeground(new java.awt.Color(0, 0, 0));
        Administrador3.setText("Secretari@");
        jPanel7.add(Administrador3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Administrador1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Administrador1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Administrador1ActionPerformed

    private void AdministradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdministradorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AdministradorActionPerformed

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
            java.util.logging.Logger.getLogger(FrmCrearUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmCrearUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmCrearUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmCrearUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmCrearUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox Administrador;
    private javax.swing.JCheckBox Administrador1;
    private javax.swing.JCheckBox Administrador2;
    private javax.swing.JCheckBox Administrador3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JLabel rol;
    // End of variables declaration//GEN-END:variables
}
