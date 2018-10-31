/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.management;

import java.util.*;
import java.sql.*;
import javax.swing.JOptionPane;


public class connect {
   public static Connection conn()throws SQLException{
      Connection myConn;
      String url="jdbc:mysql://localhost:3306/bank";
      String user="root";
      String pass="";
       
      try{
          //Class.forName("com.mysql.jdbc.Driver");
          myConn=DriverManager.getConnection(url,user,pass);
          return myConn;
          
      }
      catch(Exception ex)
      {
          ex.printStackTrace();
          JOptionPane.showMessageDialog(null, ex);
          return null;
      }
      
      
    };   
    
}
