import javax.swing.JOptionPane;
public class index extends javax.swing.JFrame {

    public index() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        adminButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();
        studentButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        adminButton.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        adminButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/index admin.png"))); // NOI18N
        adminButton.setText("Admin");
        adminButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminButtonActionPerformed(evt);
            }
        });
        getContentPane().add(adminButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 600, -1, -1));

        exitButton.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        exitButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/Close.png"))); // NOI18N
        exitButton.setText("Exit");
        exitButton.setIconTextGap(7);
        exitButton.setInheritsPopupMenu(true);
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });
        getContentPane().add(exitButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1730, 40, -1, -1));

        studentButton.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        studentButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/index student.png"))); // NOI18N
        studentButton.setText("Student");
        studentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentButtonActionPerformed(evt);
            }
        });
        getContentPane().add(studentButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 600, -1, -1));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel2.setFont(new java.awt.Font("Algerian", 0, 60)); // NOI18N
        jLabel2.setText("Welcome to our ip practice quiz system ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 420, -1, -1));

        jLabel3.setBackground(new java.awt.Color(207, 241, 255));
        jLabel3.setForeground(new java.awt.Color(210, 245, 254));
        jLabel3.setText("jLabel3");
        jLabel3.setOpaque(true);
        jLabel3.setPreferredSize(new java.awt.Dimension(1920, 1080));
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void adminButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminButtonActionPerformed
        setVisible(false);
        new loginAdmin().setVisible(true);
    }//GEN-LAST:event_adminButtonActionPerformed

    private void studentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentButtonActionPerformed
        setVisible(false);
        new studentDetails().setVisible(true);
    }//GEN-LAST:event_studentButtonActionPerformed

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        int a=JOptionPane.showConfirmDialog(null,"<html><b style=\"font-size:15px\">Do you really want to exit from application?</b></html>","Select",JOptionPane.YES_NO_OPTION);
        if(a==0){ //user select yes option
            System.exit(0);
        }
    }//GEN-LAST:event_exitButtonActionPerformed

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
            java.util.logging.Logger.getLogger(index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new index().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton adminButton;
    private javax.swing.JButton exitButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton studentButton;
    // End of variables declaration//GEN-END:variables
}
