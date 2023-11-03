/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package fee.management.system;
import java.awt.Color;
import java.util.Date;
import javax.swing.JOptionPane;
import java.sql.*;
import java.sql.DriverManager;
import javax.xml.transform.Result;
import java.util.Date;
import javax.swing.JOptionPane;
import java.lang.*;
import java.text.SimpleDateFormat;
 
/**
 *
 * @author sathw
 */
public class Addfees extends javax.swing.JFrame {

    /**
     * Creates new form Addfees
     */
    public Addfees() {
        initComponents();
        displayCashFirst();
        fillCombo();
        int receiptNo = getReceiptNo();
        txtrno.setText(Integer.toString(receiptNo));
    }
    
    public void displayCashFirst(){
        lblddno.setVisible(false);
        lblchequeno.setVisible(false);
        lblbankname.setVisible(false);
        txtddno.setVisible(false);
        txtchequeno.setVisible(false);
        txtbankname.setVisible(false);
        
        
        
    }
    
    public boolean Validation(){
        if(txtreceivedfrom.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Please Enter Username!!");
            return false;
        }
        if(DateChooser.getDate()==null){
            JOptionPane.showMessageDialog(this, "Please select Date!!");
            return false;
        }
        if(txtamount.getText().equals("") || txtamount.getText().matches("[0-9]+")==false){
            JOptionPane.showMessageDialog(this, "Please enter amount!!");
            return false;
        }
        if(combopaymentmode.getSelectedItem().toString().equals("Cheque"))
        {
           if(txtchequeno.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Please enter Cheque number!!");   
            return false;
           } 
           if(txtbankname.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Please enter Bank name!!");   
            return false;
           }
        }
        if(combopaymentmode.getSelectedItem().toString().equals("DD"))
        {
           if(txtddno.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Please enter DD number!!");   
            return false;
           } 
           if(txtbankname.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Please enter Bank name!!");   
            return false;
           }
        }
        if(combopaymentmode.getSelectedItem().toString().equals("Card"))
        {
           if(txtbankname.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Please enter Bank name!!");   
            return false;
           }
        }
        return true;
    }
    public void fillCombo(){
         try{
             Connection Con1=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/database?zeroDateTimeBehavior=CONVERT_TO_NULL","root","Sathwik3010@");
             PreparedStatement stmt=Con1.prepareStatement("Select Course from course");
             ResultSet rs=stmt.executeQuery();
             while(rs.next()){
                 combocourse.addItem(rs.getString("Course"));
             }
         }   
         catch(Exception e){
             e.printStackTrace();
         }
    }
    public int getReceiptNo(){
        int receiptNo=0;
        try{
            Connection con = DBconnection.getConnection();
            PreparedStatement stmt=con.prepareStatement("select max(reciept_no) from fees_Details");
            ResultSet rs=stmt.executeQuery();
            if(rs.next()==true){
                receiptNo=rs.getInt(1);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return receiptNo+1;
    }
    
    public String insertData(){
        
        String status="";
        int receiptno=Integer.parseInt(txtrno.getText());
        String studentname=txtreceivedfrom.getText();
        String rollno=txtrollno.getText();
        String paymentmode=(String) combopaymentmode.getSelectedItem();
        String chequeno=txtchequeno.getText();
        String bankname=txtbankname.getText();
        String ddno=txtddno.getText();
        String coursename=txtcoursename.getText();
        String gstin=txtgstno.getText();
        float totalamount=Float.parseFloat(txttotal.getText());
        SimpleDateFormat spd=new SimpleDateFormat("yyyy-MM-dd");
        String date=spd.format(DateChooser.getDate());
        float initialamount=Float.parseFloat(txtamount.getText());
        float tax=Float.parseFloat(txttax.getText());
        float gst=Float.parseFloat(txtgst.getText());
        String totalinwords=txttotalinwords.getText();
        String remark=txtremarks.getText();
        int year1=Integer.parseInt(txtyear1.getText());
        int year2=Integer.parseInt(txtyear2.getText());
        
        try{
            Connection con=DBconnection.getConnection();
            PreparedStatement stmt=con.prepareStatement("insert into fees_details values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            
            
            stmt.setInt(1,receiptno);
            stmt.setString(2, studentname);
            stmt.setString(3, rollno);
            stmt.setString(4, paymentmode);
            stmt.setString(5, chequeno);
            stmt.setString(6, bankname);
            stmt.setString(7, ddno);
            stmt.setString(8, coursename);
            stmt.setString(9, gstin);
            stmt.setFloat(10, totalamount);
            stmt.setString(11, date);
            stmt.setFloat(12, initialamount);
            stmt.setFloat(13, tax);
            stmt.setFloat(14, gst);
            stmt.setString(15, totalinwords);
            stmt.setString(16, remark);
            stmt.setInt(17,year1);
            stmt.setInt(18,year2);
            
            int rowcount;
            rowcount = stmt.executeUpdate();
            if(rowcount ==1){
                status="success";
            }
            else{
                status="failed";
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return status;  
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelsidebar = new javax.swing.JPanel();
        paneledit = new javax.swing.JPanel();
        btnedit = new javax.swing.JLabel();
        panelhome = new javax.swing.JPanel();
        btnhome = new javax.swing.JLabel();
        panelsearchrecord = new javax.swing.JPanel();
        btnsearchrecord = new javax.swing.JLabel();
        panelviewall = new javax.swing.JPanel();
        btnviewall = new javax.swing.JLabel();
        panellogout = new javax.swing.JPanel();
        btnlogout = new javax.swing.JLabel();
        panelback = new javax.swing.JPanel();
        btnback = new javax.swing.JLabel();
        panelparent = new javax.swing.JPanel();
        lblchequeno = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtgstno = new javax.swing.JLabel();
        lblddno = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblbankname = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtbankname = new javax.swing.JTextField();
        txtrno = new javax.swing.JTextField();
        combopaymentmode = new javax.swing.JComboBox<>();
        DateChooser = new com.toedter.calendar.JDateChooser();
        txtchequeno = new javax.swing.JTextField();
        panelchild = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        lblreceivedfrom = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        combocourse = new javax.swing.JComboBox<>();
        txtyear2 = new javax.swing.JTextField();
        txtyear1 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtrollno = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtcoursename = new javax.swing.JTextField();
        txttotal = new javax.swing.JTextField();
        txtamount = new javax.swing.JTextField();
        txttax = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        txtgst = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txttotalinwords = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtremarks = new javax.swing.JTextArea();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel18 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtreceivedfrom = new javax.swing.JTextField();
        txtddno = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelsidebar.setBackground(new java.awt.Color(255, 255, 255));
        panelsidebar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(51, 102, 255), null, null));
        panelsidebar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        paneledit.setBackground(new java.awt.Color(153, 255, 255));
        paneledit.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        paneledit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                paneleditMouseEntered(evt);
            }
        });
        paneledit.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnedit.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnedit.setText("        Edit Course");
        btnedit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btneditMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btneditMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btneditMouseExited(evt);
            }
        });
        paneledit.add(btnedit, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 170, -1));

        panelsidebar.add(paneledit, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 170, 40));

        panelhome.setBackground(new java.awt.Color(153, 255, 255));
        panelhome.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelhome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelhomeMouseEntered(evt);
            }
        });
        panelhome.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnhome.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnhome.setText("            Home");
        btnhome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnhomeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnhomeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnhomeMouseExited(evt);
            }
        });
        panelhome.add(btnhome, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 170, -1));

        panelsidebar.add(panelhome, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 170, 40));

        panelsearchrecord.setBackground(new java.awt.Color(153, 255, 255));
        panelsearchrecord.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(51, 204, 255), null, null));
        panelsearchrecord.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelsearchrecordMouseEntered(evt);
            }
        });
        panelsearchrecord.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnsearchrecord.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnsearchrecord.setText("      Search Record");
        btnsearchrecord.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnsearchrecordMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnsearchrecordMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnsearchrecordMouseExited(evt);
            }
        });
        panelsearchrecord.add(btnsearchrecord, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 170, -1));

        panelsidebar.add(panelsearchrecord, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 170, 40));

        panelviewall.setBackground(new java.awt.Color(153, 255, 255));
        panelviewall.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelviewall.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelviewallMouseEntered(evt);
            }
        });
        panelviewall.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnviewall.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnviewall.setText("   View All Records");
        btnviewall.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnviewallMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnviewallMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnviewallMouseExited(evt);
            }
        });
        panelviewall.add(btnviewall, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 170, -1));

        panelsidebar.add(panelviewall, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 170, 40));

        panellogout.setBackground(new java.awt.Color(153, 255, 255));
        panellogout.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panellogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panellogoutMouseEntered(evt);
            }
        });
        panellogout.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnlogout.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnlogout.setText("          Logout ");
        btnlogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnlogoutMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnlogoutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnlogoutMouseExited(evt);
            }
        });
        panellogout.add(btnlogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 170, -1));

        panelsidebar.add(panellogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 170, 40));

        panelback.setBackground(new java.awt.Color(153, 255, 255));
        panelback.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelback.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelbackMouseEntered(evt);
            }
        });
        panelback.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnback.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnback.setText("            Back");
        btnback.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnbackMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnbackMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnbackMouseExited(evt);
            }
        });
        panelback.add(btnback, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 170, -1));

        panelsidebar.add(panelback, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 170, 40));

        getContentPane().add(panelsidebar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 220, 620));

        panelparent.setBackground(new java.awt.Color(153, 255, 204));
        panelparent.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblchequeno.setText("Cheque no.:");
        panelparent.add(lblchequeno, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 110, 20));

        jLabel2.setText("Receipt No.:  MLR-");
        panelparent.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 110, 20));

        txtgstno.setText("GSTIN: 7594683124");
        panelparent.add(txtgstno, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 40, 110, -1));

        lblddno.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        lblddno.setText("DD no.");
        panelparent.add(lblddno, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 110, 20));

        jLabel5.setText("Mode of payment :");
        panelparent.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 110, 20));

        lblbankname.setText("Bank name :");
        panelparent.add(lblbankname, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 110, 20));

        jLabel7.setText("Date:");
        panelparent.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, 40, 20));
        panelparent.add(txtbankname, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, 140, -1));
        panelparent.add(txtrno, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 140, -1));

        combopaymentmode.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DD", "Cheque", "Cash", "Card", " " }));
        combopaymentmode.setSelectedIndex(2);
        combopaymentmode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combopaymentmodeActionPerformed(evt);
            }
        });
        panelparent.add(combopaymentmode, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, 140, -1));
        panelparent.add(DateChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(416, 10, 140, -1));
        panelparent.add(txtchequeno, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 140, -1));

        panelchild.setBackground(new java.awt.Color(153, 255, 204));
        panelchild.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setText("The following payments in the college office for the year :");
        panelchild.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 310, 20));

        lblreceivedfrom.setText("Received From :");
        panelchild.add(lblreceivedfrom, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 100, 20));

        jLabel10.setText("to");
        panelchild.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 50, -1, 20));

        jLabel11.setText("Course :");
        panelchild.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 80, 20));

        combocourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combocourseActionPerformed(evt);
            }
        });
        panelchild.add(combocourse, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, 150, -1));
        panelchild.add(txtyear2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 50, 80, -1));
        panelchild.add(txtyear1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 50, 70, -1));

        jLabel12.setText("Roll no. :");
        panelchild.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 80, 80, 20));
        panelchild.add(txtrollno, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 80, 90, -1));
        panelchild.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 540, 20));
        panelchild.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 110, 560, 10));

        jLabel13.setText("Amount");
        panelchild.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 120, -1, -1));

        jLabel14.setText("S.No.:");
        panelchild.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));

        jLabel15.setText("Head");
        panelchild.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 120, -1, -1));

        txtcoursename.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcoursenameActionPerformed(evt);
            }
        });
        panelchild.add(txtcoursename, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, 280, -1));
        panelchild.add(txttotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 260, 90, -1));

        txtamount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtamountActionPerformed(evt);
            }
        });
        panelchild.add(txtamount, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 160, 90, -1));
        panelchild.add(txttax, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 190, 90, -1));
        panelchild.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 250, 110, 10));
        panelchild.add(txtgst, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 220, 90, -1));

        jLabel16.setText("Total in Words:");
        panelchild.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, -1, 20));
        panelchild.add(txttotalinwords, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 260, 280, -1));

        jLabel17.setText("Total in Words:");
        panelchild.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, -1, 20));

        txtremarks.setColumns(20);
        txtremarks.setRows(5);
        jScrollPane1.setViewportView(txtremarks);

        panelchild.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 300, 280, -1));
        panelchild.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 353, 120, -1));

        jLabel18.setText("Receiver Signature");
        panelchild.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 360, -1, -1));

        jButton1.setText("Print");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        panelchild.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 410, -1, -1));

        jLabel19.setText("GST:");
        panelchild.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 220, 190, 20));

        jLabel20.setText("Tax:");
        panelchild.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 190, 180, 20));
        panelchild.add(txtreceivedfrom, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 200, -1));

        panelparent.add(panelchild, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 590, 490));
        panelparent.add(txtddno, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 140, -1));

        getContentPane().add(panelparent, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 0, 590, 620));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btneditMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btneditMouseEntered
        // TODO add your handling code here:
        Color clr=new Color(153,204,255);
        paneledit.setBackground(clr);
    }//GEN-LAST:event_btneditMouseEntered

    private void btneditMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btneditMouseExited
        // TODO add your handling code here:
        Color clr=new Color(153,255,255);
        paneledit.setBackground(clr);
    }//GEN-LAST:event_btneditMouseExited

    private void paneleditMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paneleditMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_paneleditMouseEntered

    private void btnhomeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnhomeMouseEntered
        // TODO add your handling code here:
        Color clr=new Color(153,204,255);
        panelhome.setBackground(clr);
    }//GEN-LAST:event_btnhomeMouseEntered

    private void btnhomeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnhomeMouseExited
        // TODO add your handling code here:
        Color clr=new Color(153,255,255);
        panelhome.setBackground(clr);
        
    }//GEN-LAST:event_btnhomeMouseExited

    private void panelhomeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelhomeMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_panelhomeMouseEntered

    private void btnsearchrecordMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnsearchrecordMouseEntered
        // TODO add your handling code here:
        Color clr=new Color(153,204,255);
        panelsearchrecord.setBackground(clr);
    }//GEN-LAST:event_btnsearchrecordMouseEntered

    private void btnsearchrecordMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnsearchrecordMouseExited
        // TODO add your handling code here:
        Color clr=new Color(153,255,255);
        panelsearchrecord.setBackground(clr);
    }//GEN-LAST:event_btnsearchrecordMouseExited

    private void panelsearchrecordMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelsearchrecordMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_panelsearchrecordMouseEntered

    private void btnviewallMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnviewallMouseEntered
        // TODO add your handling code here:
        Color clr=new Color(153,204,255);
        panelviewall.setBackground(clr);
    }//GEN-LAST:event_btnviewallMouseEntered

    private void btnviewallMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnviewallMouseExited
        // TODO add your handling code here:
        Color clr=new Color(153,255,255);
        panelviewall.setBackground(clr);
    }//GEN-LAST:event_btnviewallMouseExited

    private void panelviewallMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelviewallMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_panelviewallMouseEntered

    private void btnlogoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnlogoutMouseEntered
        // TODO add your handling code here:
        Color clr=new Color(153,204,255);
        panellogout.setBackground(clr);
    }//GEN-LAST:event_btnlogoutMouseEntered

    private void btnlogoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnlogoutMouseExited
        // TODO add your handling code here:
        Color clr=new Color(153,255,255);
        panellogout.setBackground(clr);
    }//GEN-LAST:event_btnlogoutMouseExited

    private void panellogoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panellogoutMouseEntered
        // TODO add your handling code here:
        
    }//GEN-LAST:event_panellogoutMouseEntered

    private void btnbackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnbackMouseEntered
        // TODO add your handling code here:
         Color clr=new Color(153,204,255);
        panelback.setBackground(clr);
    }//GEN-LAST:event_btnbackMouseEntered

    private void btnbackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnbackMouseExited
        // TODO add your handling code here:
        Color clr=new Color(153,255,255);
        panelback.setBackground(clr);
    }//GEN-LAST:event_btnbackMouseExited

    private void panelbackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelbackMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_panelbackMouseEntered

    private void btnhomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnhomeMouseClicked
        // TODO add your handling code here:.
        home hm=new home();
        hm.show();
        this.dispose();
    }//GEN-LAST:event_btnhomeMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if(Validation()){
            String result=insertData();
            if(result == "success"){
                JOptionPane.showMessageDialog(this,"Record inserted Successfully");
                printreceipt rp=new printreceipt();
                rp.show();
                this.dispose();
                
            }
            else{
                JOptionPane.showMessageDialog(this,"Record insertion failed");
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void combopaymentmodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combopaymentmodeActionPerformed
        // TODO add your handling code here:
        if(combopaymentmode.getSelectedIndex()==0){
             lblddno.setVisible(true);
             lblchequeno.setVisible(false);
             lblbankname.setVisible(true);
             txtddno.setVisible(true);
             txtchequeno.setVisible(false);
             txtbankname.setVisible(true);
             
        }
        if(combopaymentmode.getSelectedIndex()==1){
             lblddno.setVisible(false);
             lblchequeno.setVisible(true);
             lblbankname.setVisible(true);
             txtddno.setVisible(false);
             txtchequeno.setVisible(true);
             txtbankname.setVisible(true);
             
        }
        if(combopaymentmode.getSelectedIndex()==2){
             lblddno.setVisible(false);
             lblchequeno.setVisible(false);
             lblbankname.setVisible(false);
             txtddno.setVisible(false);
             txtchequeno.setVisible(false);
             txtbankname.setVisible(false);
             
        }
        if(combopaymentmode.getSelectedIndex()==3){
             lblddno.setVisible(false);
             lblchequeno.setVisible(false);
             lblbankname.setVisible(true);
             txtddno.setVisible(false);
             txtchequeno.setVisible(false);
             txtbankname.setVisible(true);
             
        }
            
    }//GEN-LAST:event_combopaymentmodeActionPerformed

    private void txtamountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtamountActionPerformed
        // TODO add your handling code here:
        float amount=Float.parseFloat(txtamount.getText());
        float tax=(amount*0.09f);
        float gst=(amount*0.09f);
        
        txttax.setText(Float.toString(tax));
        txtgst.setText(Float.toString(gst));
        
        float total=amount+tax+gst;
        txttotal.setText(Float.toString(total));
        
        txttotalinwords.setText(NumberToWordsConverter.convert((int)total)+" only");
    }//GEN-LAST:event_txtamountActionPerformed

    private void combocourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combocourseActionPerformed
        // TODO add your handling code here:
        txtcoursename.setText(combocourse.getSelectedItem().toString());
    }//GEN-LAST:event_combocourseActionPerformed

    private void txtcoursenameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcoursenameActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtcoursenameActionPerformed

    private void btnsearchrecordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnsearchrecordMouseClicked
        // TODO add your handling code here:
        searchRecord sc=new searchRecord();
        sc.show();
        this.dispose();
    }//GEN-LAST:event_btnsearchrecordMouseClicked

    private void btneditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btneditMouseClicked
        // TODO add your handling code here:
        editCourse ec=new editCourse();
        ec.show();
        this.dispose();
    }//GEN-LAST:event_btneditMouseClicked

    private void btnviewallMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnviewallMouseClicked
        // TODO add your handling code here:
        viewAllRecord var=new viewAllRecord();
        var.show();
        this.dispose();
        
    }//GEN-LAST:event_btnviewallMouseClicked

    private void btnbackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnbackMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btnbackMouseClicked

    private void btnlogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnlogoutMouseClicked
        // TODO add your handling code here:
        Login lg=new Login();
        lg.show();
        this.dispose();
    }//GEN-LAST:event_btnlogoutMouseClicked

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
            java.util.logging.Logger.getLogger(Addfees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Addfees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Addfees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Addfees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Addfees().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser DateChooser;
    private javax.swing.JLabel btnback;
    private javax.swing.JLabel btnedit;
    private javax.swing.JLabel btnhome;
    private javax.swing.JLabel btnlogout;
    private javax.swing.JLabel btnsearchrecord;
    private javax.swing.JLabel btnviewall;
    private javax.swing.JComboBox<String> combocourse;
    private javax.swing.JComboBox<String> combopaymentmode;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel lblbankname;
    private javax.swing.JLabel lblchequeno;
    private javax.swing.JLabel lblddno;
    private javax.swing.JLabel lblreceivedfrom;
    private javax.swing.JPanel panelback;
    private javax.swing.JPanel panelchild;
    private javax.swing.JPanel paneledit;
    private javax.swing.JPanel panelhome;
    private javax.swing.JPanel panellogout;
    private javax.swing.JPanel panelparent;
    private javax.swing.JPanel panelsearchrecord;
    private javax.swing.JPanel panelsidebar;
    private javax.swing.JPanel panelviewall;
    private javax.swing.JTextField txtamount;
    private javax.swing.JTextField txtbankname;
    private javax.swing.JTextField txtchequeno;
    private javax.swing.JTextField txtcoursename;
    private javax.swing.JTextField txtddno;
    private javax.swing.JTextField txtgst;
    private javax.swing.JLabel txtgstno;
    private javax.swing.JTextField txtreceivedfrom;
    private javax.swing.JTextArea txtremarks;
    private javax.swing.JTextField txtrno;
    private javax.swing.JTextField txtrollno;
    private javax.swing.JTextField txttax;
    private javax.swing.JTextField txttotal;
    private javax.swing.JTextField txttotalinwords;
    private javax.swing.JTextField txtyear1;
    private javax.swing.JTextField txtyear2;
    // End of variables declaration//GEN-END:variables
}
