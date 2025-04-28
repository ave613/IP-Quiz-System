import javax.swing.JFrame;
import javax.swing.JOptionPane;
public class adminHome extends javax.swing.JFrame {
public static int open=0;
    public adminHome() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/index background.png"))); // NOI18N

        jMenuBar1.setBackground(new java.awt.Color(0, 153, 153));
        jMenuBar1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Admin Home Page", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 32), new java.awt.Color(0, 153, 153))); // NOI18N
        jMenuBar1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/add new question.png"))); // NOI18N
        jMenu1.setText("Add New Question");
        jMenu1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jMenu1.setMargin(new java.awt.Insets(0, 6, 0, 40));
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/Update Question.png"))); // NOI18N
        jMenu2.setText("Update Question");
        jMenu2.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jMenu2.setIconTextGap(8);
        jMenu2.setMargin(new java.awt.Insets(0, 6, 0, 40));
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/all questions.png"))); // NOI18N
        jMenu3.setText("All Questions");
        jMenu3.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jMenu3.setIconTextGap(8);
        jMenu3.setMargin(new java.awt.Insets(0, 6, 0, 40));
        jMenu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu3MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu3);

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/delete Question.png"))); // NOI18N
        jMenu4.setText("Delete Question");
        jMenu4.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jMenu4.setIconTextGap(8);
        jMenu4.setMargin(new java.awt.Insets(0, 6, 0, 40));
        jMenu4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu4MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu4);

        jMenu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/all student result.png"))); // NOI18N
        jMenu5.setText("All Students Result");
        jMenu5.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jMenu5.setIconTextGap(8);
        jMenu5.setMargin(new java.awt.Insets(0, 6, 0, 40));
        jMenu5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu5MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu5);

        jMenu6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/Logout.png"))); // NOI18N
        jMenu6.setText("Logout");
        jMenu6.setFocusable(false);
        jMenu6.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jMenu6.setIconTextGap(10);
        jMenu6.setMargin(new java.awt.Insets(0, 6, 0, 40));
        jMenu6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu6MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu6);

        jMenu7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/Close.png"))); // NOI18N
        jMenu7.setText("Exit");
        jMenu7.setFocusable(false);
        jMenu7.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jMenu7.setIconTextGap(10);
        jMenu7.setMargin(new java.awt.Insets(0, 6, 0, 40));
        jMenu7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu7MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu7);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(1939, 1939, 1939))
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu6MouseClicked
        JFrame jf=new JFrame();
        jf.setAlwaysOnTop(true);
        int a=JOptionPane.showConfirmDialog(jf, "<html><b style=\"font-size:15px\">Do you really want to Logout?</b></html>", "Select", JOptionPane.YES_NO_OPTION);
        if(a==0){
            setVisible(false);
            new loginAdmin().setVisible(true);
        }
    }//GEN-LAST:event_jMenu6MouseClicked

    private void jMenu7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu7MouseClicked

        JFrame jf=new JFrame();
        jf.setAlwaysOnTop(true);
        int a=JOptionPane.showConfirmDialog(jf, "<html><b style=\"font-size:15px\">Do you really want to exit from application?</b></html>", "Select", JOptionPane.YES_NO_OPTION);
        if(a==0){
            System.exit(0);
        }
    }//GEN-LAST:event_jMenu7MouseClicked

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
       if(open==0){
        new addNewQuestion().setVisible(true);
        open=1;
       }
       else{
           JFrame jf=new JFrame();
           jf.setAlwaysOnTop(true);
           JOptionPane.showMessageDialog(jf,"One form is already opened");
       }
    }//GEN-LAST:event_jMenu1MouseClicked

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
        // update
       if(open==0){
        new updateQuestion().setVisible(true);
        open=1;
       }
       else{
           JFrame jf=new JFrame();
           jf.setAlwaysOnTop(true);
           JOptionPane.showMessageDialog(jf,"One form is already opened");
       }
    }//GEN-LAST:event_jMenu2MouseClicked

    private void jMenu3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3MouseClicked
        // allQ
        if(open==0){
        new allQuestion().setVisible(true);
        open=1;
       }
       else{
           JFrame jf=new JFrame();
           jf.setAlwaysOnTop(true);
           JOptionPane.showMessageDialog(jf,"One form is already opened");
       }
    }//GEN-LAST:event_jMenu3MouseClicked

    private void jMenu4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu4MouseClicked
        // delete
        if(open==0){
        new deleteQuestion().setVisible(true);
        open=1;
       }
       else{
           JFrame jf=new JFrame();
           jf.setAlwaysOnTop(true);
           JOptionPane.showMessageDialog(jf,"One form is already opened");
       }
    }//GEN-LAST:event_jMenu4MouseClicked

    private void jMenu5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu5MouseClicked
        // result
        if(open==0){
        new allStudentResult().setVisible(true);
        open=1;
       }
       else{
           JFrame jf=new JFrame();
           jf.setAlwaysOnTop(true);
           JOptionPane.showMessageDialog(jf,"One form is already opened");
       }
    }//GEN-LAST:event_jMenu5MouseClicked

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
            java.util.logging.Logger.getLogger(adminHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(adminHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(adminHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(adminHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new adminHome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}
