/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package interfaces;

/**
 *
 * @author usuario
 */
public class FrmMenP extends javax.swing.JFrame {

    /**
     * Creates new form FrmMenP
     */
    public FrmMenP() {
        initComponents();
        this.setVisible(true);
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

        jPanel1 = new javax.swing.JPanel();
        btn_reportes = new javax.swing.JButton();
        btn_consulta = new javax.swing.JButton();
        btn_citas = new javax.swing.JButton();
        btn_usuarios = new javax.swing.JButton();
        btn_pacientes = new javax.swing.JButton();
        btn_farmacia = new javax.swing.JButton();
        imagenFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_reportes.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_reportes.setText("REPORTES");
        btn_reportes.setBorderPainted(false);
        btn_reportes.setContentAreaFilled(false);
        btn_reportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_reportesActionPerformed(evt);
            }
        });
        jPanel1.add(btn_reportes, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 520, 270, 60));

        btn_consulta.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_consulta.setText("CONSULTA MÉDICA");
        btn_consulta.setBorderPainted(false);
        btn_consulta.setContentAreaFilled(false);
        btn_consulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_consultaActionPerformed(evt);
            }
        });
        jPanel1.add(btn_consulta, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 370, 260, 60));

        btn_citas.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_citas.setText("CITAS");
        btn_citas.setBorderPainted(false);
        btn_citas.setContentAreaFilled(false);
        btn_citas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_citasActionPerformed(evt);
            }
        });
        jPanel1.add(btn_citas, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 290, 270, 60));

        btn_usuarios.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_usuarios.setText("USUARIOS");
        btn_usuarios.setBorderPainted(false);
        btn_usuarios.setContentAreaFilled(false);
        btn_usuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_usuariosActionPerformed(evt);
            }
        });
        jPanel1.add(btn_usuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 210, 270, 70));

        btn_pacientes.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_pacientes.setText("PACIENTES");
        btn_pacientes.setBorderPainted(false);
        btn_pacientes.setContentAreaFilled(false);
        btn_pacientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pacientesActionPerformed(evt);
            }
        });
        jPanel1.add(btn_pacientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 130, 270, 70));

        btn_farmacia.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_farmacia.setText("FARMACIA");
        btn_farmacia.setBorderPainted(false);
        btn_farmacia.setContentAreaFilled(false);
        btn_farmacia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_farmaciaActionPerformed(evt);
            }
        });
        jPanel1.add(btn_farmacia, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 440, 270, 60));

        imagenFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/pngMenPrin.png"))); // NOI18N
        jPanel1.add(imagenFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_reportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_reportesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_reportesActionPerformed

    private void btn_consultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_consultaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_consultaActionPerformed

    private void btn_citasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_citasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_citasActionPerformed

    private void btn_usuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_usuariosActionPerformed
        FrmGestionUsuarios menuUs=new FrmGestionUsuarios();
        menuUs.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_usuariosActionPerformed

    private void btn_pacientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pacientesActionPerformed
        FrmMenuPaciente menuPacientes=new FrmMenuPaciente();
        menuPacientes.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_pacientesActionPerformed

    private void btn_farmaciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_farmaciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_farmaciaActionPerformed

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
            java.util.logging.Logger.getLogger(FrmMenP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMenP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMenP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMenP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMenP().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn_citas;
    public javax.swing.JButton btn_consulta;
    public javax.swing.JButton btn_farmacia;
    public javax.swing.JButton btn_pacientes;
    public javax.swing.JButton btn_reportes;
    public javax.swing.JButton btn_usuarios;
    private javax.swing.JLabel imagenFondo;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
