/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author sheha
 */
public class PageBal {
    
    
     public boolean checkLogin(String email, String pass){
        boolean b = false;
        try {
            //create query
            String query = "SELECT Email, Password FROM signup WHERE  Email = '"+email+"' AND Password = '"+pass+"'";
            Statement st = PageDBconnection.con.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            if(rs.next()) {
                b = true;
            } else{
                JOptionPane.showMessageDialog(null, "Invalid email or password ,try again!!");
            } 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "" +e);
        }
        return b;
    }
     
     public void insertDataSignup(PageBean beanObj){
        Connection con = null;
        Statement stmt = null;
        
        
        try {
            con = PageDBconnection.loadConnection();
            //create query for inserting signup data
            String query = "INSERT INTO signup (FullName, Email, Password) VALUES ('" +
                                        beanObj.getFullName() + "', '" + 
                                        beanObj.getEmail() + "', '" +
                                        beanObj.getPassword() + "')";
            
            stmt = con.createStatement();
            stmt.executeUpdate(query);
            
            JOptionPane.showMessageDialog(null, "You have signup successfully, Start login!!");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error:" +e);
        }
    
     }
}
