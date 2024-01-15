
package interfaces;

import clases.Usuario;


public class FrmMenuReportes extends javax.swing.JFrame {

    private Usuario usuario;
    public FrmMenuReportes(Usuario usuario) {
        this.usuario=usuario;
        initComponents();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
public FrmMenuReportes() {
       
        initComponents();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnregresar = new javax.swing.JButton();
        btnpacdiario = new javax.swing.JButton();
        btnpacespecifico = new javax.swing.JButton();
        btninvenfarmacia = new javax.swing.JButton();
        btnrecmedica = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnregresar.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        btnregresar.setText("REGRESAR");
        btnregresar.setBorderPainted(false);
        btnregresar.setContentAreaFilled(false);
        btnregresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregresarActionPerformed(evt);
            }
        });
        getContentPane().add(btnregresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 630, 200, 30));

        btnpacdiario.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        btnpacdiario.setText("PACIENTE DIARIO");
        btnpacdiario.setBorderPainted(false);
        btnpacdiario.setContentAreaFilled(false);
        btnpacdiario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpacdiarioActionPerformed(evt);
            }
        });
        getContentPane().add(btnpacdiario, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 270, 250, 30));

        btnpacespecifico.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        btnpacespecifico.setText("PACIENTE ESPECÍFICO");
        btnpacespecifico.setBorderPainted(false);
        btnpacespecifico.setContentAreaFilled(false);
        btnpacespecifico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpacespecificoActionPerformed(evt);
            }
        });
        getContentPane().add(btnpacespecifico, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 340, 300, 30));

        btninvenfarmacia.setFont(new java.awt.Font("Verdana", 1, 17)); // NOI18N
        btninvenfarmacia.setText("INVENTARIO DE FARMACIA");
        btninvenfarmacia.setBorderPainted(false);
        btninvenfarmacia.setContentAreaFilled(false);
        btninvenfarmacia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btninvenfarmaciaActionPerformed(evt);
            }
        });
        getContentPane().add(btninvenfarmacia, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 420, 320, 30));

        btnrecmedica.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        btnrecmedica.setText("RECETAS MÉDICAS");
        btnrecmedica.setBorderPainted(false);
        btnrecmedica.setContentAreaFilled(false);
        btnrecmedica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnrecmedicaActionPerformed(evt);
            }
        });
        getContentPane().add(btnrecmedica, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 500, 240, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/menureportes.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnregresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregresarActionPerformed
       FrmMenP menup= new FrmMenP(this.usuario);
       menup.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_btnregresarActionPerformed

    private void btnpacdiarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpacdiarioActionPerformed
        FrmReportePacDiario pacDiario= new FrmReportePacDiario();
        pacDiario.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnpacdiarioActionPerformed

    private void btnpacespecificoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpacespecificoActionPerformed
        FrmReportePacEs pacEs= new FrmReportePacEs();
        pacEs.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnpacespecificoActionPerformed

    private void btninvenfarmaciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btninvenfarmaciaActionPerformed
        FrmReporteInvenFarma invenFarma= new FrmReporteInvenFarma();
        invenFarma.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btninvenfarmaciaActionPerformed

    private void btnrecmedicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnrecmedicaActionPerformed
       FrmReporteRecMedica recMedica= new FrmReporteRecMedica();
       recMedica.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_btnrecmedicaActionPerformed

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
            java.util.logging.Logger.getLogger(FrmMenuReportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMenuReportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMenuReportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMenuReportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMenuReportes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btninvenfarmacia;
    public javax.swing.JButton btnpacdiario;
    public javax.swing.JButton btnpacespecifico;
    public javax.swing.JButton btnrecmedica;
    public javax.swing.JButton btnregresar;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
