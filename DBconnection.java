/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
 
/**
 *
 * @author sathw
 */
public class DBconnection {
    public static Connection getConnection(){
        Connection con=null;
        try{
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/database?zeroDateTimeBehavior=CONVERT_TO_NULL","root","Sathwik3010@");
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return con;
    }
}
