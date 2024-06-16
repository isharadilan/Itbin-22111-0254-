/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author sheha
 */
public class PageDBconnection {
    
     
    public static Connection con = null;
    
    public static Connection loadConnection(){
        
        
        String url = "jdbc:mysql://localhost:3306/ishara";
        String root = "root";
        String pass = "Shehan123@";
        
        try {
            con = DriverManager.getConnection(url, root, pass);
            
            if (con != null){
                JOptionPane.showMessageDialog(null, "Database has been connected successfully");
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error in database loading"+e);
        }
    return con;
    }
    
}
