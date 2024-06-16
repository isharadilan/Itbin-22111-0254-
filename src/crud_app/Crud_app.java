/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud_app;

import model.PageDBconnection;
import view.LoggingFrame;

/**
 *
 * @author sheha
 */
public class Crud_app {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LoggingFrame loginObj = new LoggingFrame();
        loginObj.show();
        
        PageDBconnection.loadConnection(); 
    }
    
}
