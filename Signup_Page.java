/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package fee.management.system;
//import com.mysql.cj.xdevapi.Statement;
import java.util.Date;
import javax.swing.JOptionPane;
import java.lang.*;
//import org.apache.derby.iapi.sql.ResultSet;
import java.sql.*;
import java.sql.DriverManager;
import javax.xml.transform.Result;
//import com.sun.jdi.connect.spi.Connection;
//package com.sun.jdi.connect.spi;

//import java.beans.Statement;

import java.text.SimpleDateFormat;

/**
 *
 * @author sathw
 */
public class Signup_Page extends javax.swing.JFrame {

    /**
     * Creates new form Signup_Page
     */
    private static Connection CON;
    String curl="jdbc:mysql://localhost:3306/database?zeroDateTimeBehavior=CONVERT_TO_NULL";
    public Signup_Page() {
        initComponents();
    }
    
    String fname,sname,uname,password,conpass,contact;
    Date dob;
    int id=0;
    public int getId(){
        ResultSet rs=null;
         try{
             //ConexaoPlus con = new ConexaoPlus();
            //Connection conn=null;
            //Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            CON =(Connection) DriverManager.getConnection(curl,"root","Sathwik3010@");
            
            String sql="select max(id) from Signup";
            Statement st;
            st = (Statement)CON.createStatement();
            rs= (ResultSet) st.executeQuery(sql);
            while(rs.next()){
                
                id=rs.getInt(1);
                id++;
            }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
         return id;
    }
    boolean validation()
    {
        
        
        fname=txt_firstname.getText();
        sname=txt_secondname.getText();
        uname=txt_username.getText();
        password=txt_password.getText();
        conpass=txt_confirmpassword.getText();
        contact=txt_contact.getText();
        dob=txt_dob.getDate();
        
        if(fname.equals("")){
            JOptionPane.showMessageDialog(this,"Please enter firstname");
            return false;
        }
        if(sname.equals("")){
            JOptionPane.showMessageDialog(this,"Please enter Secondname");
            return false;
        }
        if(uname.equals("")){
            JOptionPane.showMessageDialog(this,"Please enter username");
            return false;
        }
        if(password.equals("")){
            JOptionPane.showMessageDialog(this,"Please enter password");
            return false;
        }
        if(conpass.equals("")){
            JOptionPane.showMessageDialog(this,"Please confirm password");
            return false;
        }
        if(dob.equals(null)){
            JOptionPane.showMessageDialog(this,"please enter date");
            return false;
        }
        if(!password.equals(conpass)){
            JOptionPane.showMessageDialog(this, "Password doesnot match!!");
        }
        
        
        return true;
    }
    public void checkpassword(){
        password=txt_password.getText();
        if(password.length()<8){
            lbl_password_error.setText("Password should be 8 digits.");
        }
        else{
            lbl_password_error.setText("");
        }
    }
    public void checkcontact(){
        contact=txt_contact.getText();
        if(contact.length()==10){
            lbl_contact_error.setText("");
        }
        else{
            lbl_contact_error.setText("Contact No. should be 10 digits");
        }
    }
    
    void insertDetails(){
        //int id=0;
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        String mydob=format.format(dob);
        PreparedStatement stmt;
        try{
            //Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            //Connection conn;
            CON = (Connection) DriverManager.getConnection(curl, "root", "Sathwik3010@");
            String sql="insert into Signup values(?,?,?,?,?,?,?)";
            //PreparedStatement stmt;        
            stmt = CON.prepareStatement(sql);
            stmt.setInt(1,getId());
            stmt.setString(2,fname);
            stmt.setString(3,sname);
            stmt.setString(4,uname);
            stmt.setString(5,password);
            stmt.setString(6,mydob);
            stmt.setString(7,contact);
            int i=stmt.executeUpdate();
            //id++;
            if(i>0){
                JOptionPane.showMessageDialog(this, "record inserted");
            }
            else{
                JOptionPane.showMessageDialog(this, "record not inserted");
            }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
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
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_firstname = new javax.swing.JTextField();
        txt_username = new javax.swing.JTextField();
        txt_secondname = new javax.swing.JTextField();
        txt_contact = new javax.swing.JTextField();
        txt_password = new javax.swing.JPasswordField();
        txt_confirmpassword = new javax.swing.JPasswordField();
        txt_dob = new com.toedter.calendar.JDateChooser();
        btn_signup = new javax.swing.JButton();
        btn_login = new javax.swing.JButton();
        lbl_password_error = new javax.swing.JLabel();
        lbl_contact_error = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel1.setText("SignUp");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(243, 243, 243)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(250, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 640, -1));

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel2.setText("Second Name:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 88, 95, -1));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel3.setText("First Name    :");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 47, 95, -1));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel4.setText("Username      :");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 126, 95, -1));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel5.setText("Password      :");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 167, 95, -1));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel6.setText("Confirm Password:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 207, 135, -1));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel7.setText("Contact         :");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 288, 95, -1));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel8.setText("D.O.B           :");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 248, 95, -1));

        txt_firstname.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        txt_firstname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_firstnameActionPerformed(evt);
            }
        });
        jPanel2.add(txt_firstname, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 50, 164, -1));

        txt_username.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        txt_username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_usernameActionPerformed(evt);
            }
        });
        jPanel2.add(txt_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 130, 164, -1));

        txt_secondname.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        txt_secondname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_secondnameActionPerformed(evt);
            }
        });
        jPanel2.add(txt_secondname, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 90, 164, -1));

        txt_contact.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        txt_contact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_contactActionPerformed(evt);
            }
        });
        txt_contact.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_contactKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_contactKeyReleased(evt);
            }
        });
        jPanel2.add(txt_contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 290, 164, -1));

        txt_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_passwordActionPerformed(evt);
            }
        });
        txt_password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_passwordKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_passwordKeyReleased(evt);
            }
        });
        jPanel2.add(txt_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 170, 164, -1));
        jPanel2.add(txt_confirmpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 210, 164, -1));
        jPanel2.add(txt_dob, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 250, 164, -1));

        btn_signup.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        btn_signup.setText("Signup");
        btn_signup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_signupActionPerformed(evt);
            }
        });
        jPanel2.add(btn_signup, new org.netbeans.lib.awtextra.AbsoluteConstraints(88, 349, -1, -1));

        btn_login.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        btn_login.setText("Login");
        btn_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_loginActionPerformed(evt);
            }
        });
        jPanel2.add(btn_login, new org.netbeans.lib.awtextra.AbsoluteConstraints(457, 349, 80, -1));
        jPanel2.add(lbl_password_error, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 170, 260, 20));
        jPanel2.add(lbl_contact_error, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 290, 240, 20));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 640, 460));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void txt_firstnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_firstnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_firstnameActionPerformed

    private void txt_usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_usernameActionPerformed

    private void txt_secondnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_secondnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_secondnameActionPerformed

    private void txt_contactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_contactActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_contactActionPerformed

    private void txt_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_passwordActionPerformed

    private void btn_signupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_signupActionPerformed
       if(validation()){
           insertDetails();
       }
    }//GEN-LAST:event_btn_signupActionPerformed

    private void txt_passwordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_passwordKeyPressed
        // TODO add your handling code here:
        checkpassword();
    }//GEN-LAST:event_txt_passwordKeyPressed

    private void txt_passwordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_passwordKeyReleased
        // TODO add your handling code here:
        checkpassword();
    }//GEN-LAST:event_txt_passwordKeyReleased

    private void txt_contactKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_contactKeyPressed
        // TODO add your handling code here:
        checkcontact();
    }//GEN-LAST:event_txt_contactKeyPressed

    private void txt_contactKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_contactKeyReleased
        // TODO add your handling code here:
        checkcontact();
    }//GEN-LAST:event_txt_contactKeyReleased

    private void btn_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_loginActionPerformed
        // TODO add your handling code here:
        Login lg=new Login();
        lg.show();
        this.dispose();
    }//GEN-LAST:event_btn_loginActionPerformed

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
            java.util.logging.Logger.getLogger(Signup_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Signup_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Signup_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Signup_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Signup_Page().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_login;
    private javax.swing.JButton btn_signup;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbl_contact_error;
    private javax.swing.JLabel lbl_password_error;
    private javax.swing.JPasswordField txt_confirmpassword;
    private javax.swing.JTextField txt_contact;
    private com.toedter.calendar.JDateChooser txt_dob;
    private javax.swing.JTextField txt_firstname;
    private javax.swing.JPasswordField txt_password;
    private javax.swing.JTextField txt_secondname;
    private javax.swing.JTextField txt_username;
    // End of variables declaration//GEN-END:variables
}
