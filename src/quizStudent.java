import Project.ConnectionProvider;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.swing.Timer;
import javax.swing.JOptionPane;
//import java.util.HashMap;
//import java.util.Map;
public class quizStudent extends javax.swing.JFrame {
    private int currentQuestionNumber = 1;
    public String questionId = "1";
    public String answer;
    public int min = 0;
    public int sec = 0;
    public int marks = 0;
    private boolean isAnswered = false; 
//  // Map to store the selected answers
//    private Map<String, String> selectedAnswers = new HashMap<>();

    public void answerCheck() {
    if (!isAnswered) {  // Only check and update if the question hasn't been answered yet
        String studentAnswer = "";
        if (jRadioButton1.isSelected()) {
            studentAnswer = jRadioButton1.getText();
        } else if (jRadioButton2.isSelected()) {
            studentAnswer = jRadioButton2.getText();
        } else if (jRadioButton3.isSelected()) {
            studentAnswer = jRadioButton3.getText();
        } else {
            studentAnswer = jRadioButton4.getText();
        }
        if (!studentAnswer.isEmpty()) {
            if (studentAnswer.equals(answer)) {
                marks++;
                String marks1 = String.valueOf(marks);
                jLabel19.setText(marks1);
            }

            // Move to the next random question
            int currentQuestionIndex = randomQuestionIds.indexOf(questionId);
            if (currentQuestionIndex + 1 < randomQuestionIds.size()) {
                questionId = randomQuestionIds.get(currentQuestionIndex + 1);
                currentQuestionNumber++;
                question();
            } else {
                // No more questions, hide Next button
                jButton1.setVisible(false);
            }

            isAnswered = true;
        } else {
           
            JOptionPane.showMessageDialog(this, "Please select an answer before proceeding.");
        }
    // Clear radio button selections
    jRadioButton1.setSelected(false);
    jRadioButton2.setSelected(false);
    jRadioButton3.setSelected(false);
    jRadioButton4.setSelected(false);

     }
    }
    private List<String> randomQuestionIds = new ArrayList<>();
   private void getAllQuestionIds() {
    try {
        Connection con = ConnectionProvider.getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT id FROM question");
        
        // Retrieve all question IDs from the database
        while (rs.next()) {
            randomQuestionIds.add(rs.getString("id"));
        }
        
        // Shuffle the question IDs to randomize their order
        Collections.shuffle(randomQuestionIds);

        // Set the first question
        if (!randomQuestionIds.isEmpty()) {
            questionId = randomQuestionIds.get(0);  // Set the first question ID
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
    }
}
    
    public void question() { 
        
    try {
        Connection con = ConnectionProvider.getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM question WHERE id='" + questionId + "'");

        if (rs.next()) {
            Qno.setText(String.valueOf(currentQuestionNumber));  // Custom question number          
            jLabel14.setText(rs.getString(2));  // Question Text
            jRadioButton1.setText(rs.getString(3));  // Option 1
            jRadioButton2.setText(rs.getString(4));  // Option 2
            jRadioButton3.setText(rs.getString(5));  // Option 3
            jRadioButton4.setText(rs.getString(6));  // Option 4
            answer = rs.getString(7);  // Correct answer
        }

        isAnswered = false; 
        if (currentQuestionNumber == randomQuestionIds.size()) {
            jButton1.setVisible(false);  // Hide "Next" button if it's the last question
        } else {
            jButton1.setVisible(true);  // Otherwise, make sure it's visible
        }
        
//            // Restore the previously selected answer if available
//                if (selectedAnswers.containsKey(questionId)) {
//                    String selectedAnswer = selectedAnswers.get(questionId);
//                    if (jRadioButton1.getText().equals(selectedAnswer)) {
//                        jRadioButton1.setSelected(true);
//                    } else if (jRadioButton2.getText().equals(selectedAnswer)) {
//                        jRadioButton2.setSelected(true);
//                    } else if (jRadioButton3.getText().equals(selectedAnswer)) {
//                        jRadioButton3.setSelected(true);
//                    } else if (jRadioButton4.getText().equals(selectedAnswer)) {
//                        jRadioButton4.setSelected(true);
//                    }
//                }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }
    public void submit() {
    // Call answerCheck only if the last question has been answered
    if (jRadioButton1.isSelected() || jRadioButton2.isSelected() || 
        jRadioButton3.isSelected() || jRadioButton4.isSelected()) {
       
        answerCheck();  
    } 
    String rollNo = jLabel15.getText();
    try {
        Connection con = ConnectionProvider.getConnection();
        Statement st = con.createStatement();
        st.executeUpdate("UPDATE student SET marks='" + marks + "', isSubmitted=TRUE WHERE rollNo='" + rollNo + "'");
        String marks1 = String.valueOf(marks);
        setVisible(false);
        new successfullySubmitted(marks1).setVisible(true);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
    }
}
    public quizStudent() {
        initComponents();
    }
    Timer time;
    public quizStudent(String rollNo) {  
        initComponents();
        currentQuestionNumber = 1;
        jLabel15.setText(rollNo);
         getAllQuestionIds();
       
            question();
         //date
        SimpleDateFormat dFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date();
        jLabel4.setText(dFormat.format(date));
        
        //first question and student details
        try {
        Connection con = ConnectionProvider.getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM student WHERE rollNo='" + rollNo + "'");
        if (rs.next()) {
            jLabel16.setText(rs.getString(2));  // Display student's name
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
    }
        //time
        setLocationRelativeTo(this);
        time = new Timer(1000,new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                jLabel26.setText(String.valueOf(sec));
                jLabel25.setText(String.valueOf(min));
                if(sec==60){
                    sec=0;
                    min++;
                    if(min==60){
                       time.stop();
                       answerCheck();
                       submit();
                    }
                }
                sec++;
            }
        });
        time.start();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSpinner1 = new javax.swing.JSpinner();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        Qno = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(222, 249, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(171, 224, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(79, 34, -1, -1));

        jLabel2.setFont(new java.awt.Font("Algerian", 0, 40)); // NOI18N
        jLabel2.setText("Welcome");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(91, 47, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel3.setText("Date:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(756, 67, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel4.setText("jLabel4");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(846, 67, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel5.setText("Total Time:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1650, 30, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel6.setText("60 Min");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1790, 30, 91, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel7.setText("Time Taken:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1093, 593, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 51, 51));
        jLabel8.setText("00 ");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1246, 593, -1, -1));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 51, 51));
        jLabel20.setText("00");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(1285, 593, -1, -1));

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/index student.png"))); // NOI18N
        jPanel1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 41, -1, -1));

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel24.setText("Time Taken:");
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(1640, 70, -1, -1));

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 51, 51));
        jLabel25.setText("00");
        jPanel1.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(1790, 70, -1, -1));

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 51, 51));
        jLabel26.setText("00");
        jPanel1.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(1830, 70, -1, -1));

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 0, 51));
        jLabel27.setText(":");
        jPanel1.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(1820, 70, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1920, 150));

        jPanel2.setBackground(new java.awt.Color(171, 224, 255));
        jPanel2.setToolTipText("");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 23)); // NOI18N
        jLabel9.setText("Roll Number:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 23)); // NOI18N
        jLabel10.setText("Name:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 23)); // NOI18N
        jLabel13.setText("Your Marks:");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 23)); // NOI18N
        jLabel15.setText("1111");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 23)); // NOI18N
        jLabel16.setText("Your Name");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 23)); // NOI18N
        jLabel19.setText("00");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel15))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel13)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel19))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel10)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel16))))
                .addContainerGap(106, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel15))
                .addGap(81, 81, 81)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel16))
                .addGap(81, 81, 81)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel19))
                .addContainerGap(597, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 121, 380, 960));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        jLabel14.setText("Question...?");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 240, -1, -1));

        jRadioButton1.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        jRadioButton1.setText("jRadioButton1");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 340, -1, -1));

        jRadioButton2.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        jRadioButton2.setText("jRadioButton2");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 420, -1, -1));

        jRadioButton3.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        jRadioButton3.setText("jRadioButton3");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 500, -1, -1));

        jRadioButton4.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        jRadioButton4.setText("jRadioButton4");
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 580, -1, -1));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 23)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/Next.png"))); // NOI18N
        jButton1.setText("Next");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 840, -1, -1));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 23)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/save.png"))); // NOI18N
        jButton2.setText("Submit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1600, 840, -1, -1));
        getContentPane().add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        Qno.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        Qno.setText("00");
        getContentPane().add(Qno, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 240, -1, -1));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        jLabel22.setText(".");
        getContentPane().add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 240, -1, -1));

        jLabel28.setBackground(new java.awt.Color(223, 239, 248));
        jLabel28.setForeground(new java.awt.Color(204, 255, 255));
        jLabel28.setText("jLabel28");
        jLabel28.setOpaque(true);
        jLabel28.setPreferredSize(new java.awt.Dimension(1920, 1080));
        getContentPane().add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
   //next
        answerCheck();
        question();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4ActionPerformed
       if (jRadioButton4.isSelected()) {
            jRadioButton1.setSelected (false) ;
            jRadioButton2. setSelected (false) ;
            jRadioButton3.setSelected (false) ;
        }
    }//GEN-LAST:event_jRadioButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // submit
        int a=JOptionPane.showConfirmDialog(null,"<html><b style=\"font-size:15px\">Do you really want to submit?</b></html>","Select",JOptionPane.YES_NO_OPTION);
        if(a==0){
            answerCheck();
            submit();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        if (jRadioButton1.isSelected()) {
            jRadioButton2. setSelected (false) ;
            jRadioButton3.setSelected (false) ;
            jRadioButton4.setSelected (false) ;
        }
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        if (jRadioButton2.isSelected()) {
            jRadioButton1. setSelected (false) ;
            jRadioButton3.setSelected (false) ;
            jRadioButton4.setSelected (false) ;
        }
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
         if (jRadioButton3.isSelected()) {
            jRadioButton1.setSelected (false) ;
            jRadioButton2. setSelected (false) ;
            jRadioButton4.setSelected (false) ;
        }
    }//GEN-LAST:event_jRadioButton3ActionPerformed
       
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
            java.util.logging.Logger.getLogger(quizStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(quizStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(quizStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(quizStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new quizStudent().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Qno;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JSpinner jSpinner1;
    // End of variables declaration//GEN-END:variables
}
