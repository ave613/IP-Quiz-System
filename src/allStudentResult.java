import Project.ConnectionProvider;
import com.sun.prism.paint.Color;
import java.awt.BorderLayout;
import net.proteanit.sql.DbUtils;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class allStudentResult extends javax.swing.JFrame {

    public allStudentResult() {
        initComponents();
        try{
           Connection con=ConnectionProvider.getConnection();
           Statement st = con.createStatement();
           ResultSet rs = st.executeQuery("select * from student");
           jTable1.setAutoResizeMode(jTable1.AUTO_RESIZE_ALL_COLUMNS);
           jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            
       }
        catch(Exception e){
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jTextField1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 235, 255));
        setForeground(new java.awt.Color(204, 235, 255));
        setLocation(new java.awt.Point(280, 200));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/all student result.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 16, -1, -1));

        jLabel2.setFont(new java.awt.Font("Algerian", 0, 40)); // NOI18N
        jLabel2.setText("All Students Result");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(93, 22, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel3.setText("Filter By Marks");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 121, -1, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/Close.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 10, -1, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 98, 1370, 10));

        jTextField1.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 120, 140, 30));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jButton2.setText("Sort Marks");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 120, -1, -1));

        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(51, 51, 51));
        jTextField2.setText(" ");
        jTextField2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField2FocusLost(evt);
            }
        });
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField2KeyReleased(evt);
            }
        });
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 120, 190, -1));

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/search.png"))); // NOI18N
        jButton3.setText("Search");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 120, -1, -1));

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "rollNum", "name", "gender", "section", "semester", "contactNo", "email"
            }
        ));
        jTable1.setFillsViewportHeight(true);
        jTable1.setFocusable(false);
        jTable1.setMinimumSize(new java.awt.Dimension(1266, 100));
        jTable1.setName(""); // NOI18N
        jTable1.setPreferredSize(new java.awt.Dimension(1266, 2000));
        jTable1.setRowHeight(25);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setHeaderValue("rollNum");
            jTable1.getColumnModel().getColumn(1).setHeaderValue("name");
            jTable1.getColumnModel().getColumn(2).setHeaderValue("gender");
            jTable1.getColumnModel().getColumn(3).setHeaderValue("section");
            jTable1.getColumnModel().getColumn(4).setHeaderValue("semester");
            jTable1.getColumnModel().getColumn(5).setHeaderValue("contactNo");
            jTable1.getColumnModel().getColumn(6).setHeaderValue("email");
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, 1247, 520));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/pages background student.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // close
        adminHome.open=0;
        setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
       
        int marks;
        if(jTextField1.getText().equals("")){
            marks=0;
        }
        else
            marks=Integer.parseInt(jTextField1.getText());
        try{
           Connection con=ConnectionProvider.getConnection();
           Statement st = con.createStatement();
           ResultSet rs = st.executeQuery("select * from student where marks>='"+marks+"' ");
           jTable1.setAutoResizeMode(jTable1.AUTO_RESIZE_OFF);
           jTable1.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e){
            JFrame jf=new JFrame();
            jf.setAlwaysOnTop(true);
            JOptionPane.showMessageDialog(jf, e);
        }
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // Merge Sort Descending (marks)
    try {
        Connection con = ConnectionProvider.getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from student");

        List<StudentResult> resultsList = new ArrayList<>();
        while (rs.next()) {
            String rollNo = rs.getString("rollNo");
            String name = rs.getString("name");
            String gender = rs.getString("gender");
            String section = rs.getString("section");
            String semester = rs.getString("semester");
            String contactNo = rs.getString("contactNo");
            String email = rs.getString("email");
            int marks = rs.getInt("marks");
            resultsList.add(new StudentResult(rollNo, name, gender, section, semester, contactNo, email, marks));
        }

        MergeSortDescending.mergeSort(resultsList);

       // Update the JTable with the sorted results
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0); // Clear the table first

        for (StudentResult result : resultsList) {
            model.addRow(new Object[]{
                result.getRollNo(),
                result.getName(),
                result.getGender(),
                result.getSection(),
                result.getSemester(),
                result.getContactNo(),
                result.getEmail(),
                result.getMarks()
            });
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(rootPane, e);
    }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    // Linear search all
    String searchTerm = jTextField2.getText().trim();
    if (searchTerm.isEmpty()) {
        JOptionPane.showMessageDialog(rootPane, "<html><b style=\"font-size:15px\">Please enter a search term.</b></html>");
        return;
    }
    searchTerm = searchTerm.toLowerCase().replaceAll("\\s+", "");

    try {
        Connection con = ConnectionProvider.getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from student");
        List<StudentResult> resultsList = new ArrayList<>();
        
        while (rs.next()) {
            String rollNo = rs.getString("rollNo");
            String name = rs.getString("name");
            String gender = rs.getString("gender");
            String section = rs.getString("section");
            String semester = rs.getString("semester");
            String contactNo = rs.getString("contactNo");
            String email = rs.getString("email");
            int marks = rs.getInt("marks");
            resultsList.add(new StudentResult(rollNo, name, gender, section, semester, contactNo, email, marks));
        }

        //search across all fields
        List<StudentResult> foundResults = new ArrayList<>();
        for (StudentResult student : resultsList) {
            if (containsIgnoreCase(student.getRollNo(), searchTerm) ||
                containsIgnoreCase(student.getName(), searchTerm) ||
                containsIgnoreCase(student.getGender(), searchTerm) ||
                containsIgnoreCase(student.getSection(), searchTerm) ||
                containsIgnoreCase(student.getSemester(), searchTerm) ||
                containsIgnoreCase(student.getContactNo(), searchTerm) ||
                containsIgnoreCase(student.getEmail(), searchTerm) ||
                containsIgnoreCase(String.valueOf(student.getMarks()), searchTerm)) {
                foundResults.add(student);
            }
        }

        if (!foundResults.isEmpty()) {
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0); // Clear the table

            // Add to table
            for (StudentResult student : foundResults) {
                model.addRow(new Object[]{
                    student.getRollNo(),
                    student.getName(),
                    student.getGender(),
                    student.getSection(),
                    student.getSemester(),
                    student.getContactNo(),
                    student.getEmail(),
                    student.getMarks()
                });
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "<html><b style=\"font-size:15px\">No student found matching the search term.</b></html>");
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(rootPane, e);
      }
    }   
                                     
    // to check partial match (case-insensitive)
    private boolean containsIgnoreCase(String field, String searchTerm) {
    if (field == null) {
        return false;
    }
    // remove extra spaces and convert to lowercase
    String normalizedField = field.toLowerCase().replaceAll("\\s+", "");
    return normalizedField.contains(searchTerm);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextField2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField2FocusGained
//        if("Enter Roll Number".equals(jTextField2.getText().trim())){
//            jTextField2.setText("");
//            jTextField2.setForeground(new Color(0,0,0));
//        }
    }//GEN-LAST:event_jTextField2FocusGained

    private void jTextField2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField2FocusLost
//     if(jTextField2.getText().equals("")){
//            jTextField2.setText("Enter Roll Number");
//            jTextField2.setForeground(new Color(153,153,153));
//        }      
    }//GEN-LAST:event_jTextField2FocusLost

    private void jTextField2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyReleased
         int marks;
        if(jTextField1.getText().equals("")){
            marks=0;
        }
        else
            marks=Integer.parseInt(jTextField1.getText());
        try{
           Connection con=ConnectionProvider.getConnection();
           Statement st = con.createStatement();
           ResultSet rs = st.executeQuery("select * from student where marks>='"+marks+"' ");
           jTable1.setAutoResizeMode(jTable1.AUTO_RESIZE_OFF);
           jTable1.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e){
            JFrame jf=new JFrame();
            jf.setAlwaysOnTop(true);
            JOptionPane.showMessageDialog(jf, e);
        }
    }//GEN-LAST:event_jTextField2KeyReleased

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
            java.util.logging.Logger.getLogger(allStudentResult.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(allStudentResult.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(allStudentResult.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(allStudentResult.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new allStudentResult().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
