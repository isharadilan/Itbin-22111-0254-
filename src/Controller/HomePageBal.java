/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;


import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import model.PageDBconnection;

/**
 *
 * @author sheha
 */
public class HomePageBal {
    
    //create method for load,read data from employee table
    
    public List<HomePageBean> loadData(){
        List<HomePageBean> list = new ArrayList<HomePageBean>();
        try{
            //queryto select all data from employee table
            
            String query = "SELECT * FROM student";
            PreparedStatement ps = PageDBconnection.con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int id = rs.getInt("Id");
                String firstName = rs.getString("FirstName");
                String lastname = rs.getString("LastName");
                String gender = rs.getString("Gender");
                String city = rs.getString("City");
                
                Date date = rs.getDate("Date");
                String address = rs.getString("Address");
                
                
                //create homebean object
                HomePageBean bean = new HomePageBean(id, firstName, lastname, gender, city, date, address);
                list.add(bean); //add bean in list
                
            }
            
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, ""+e);
        }
        return list;
    }
    
    
    
    //method for insert data
    public void insert(HomePageBean homeBean){
        
        //inserting         
        try{
            //insert query
            String query = "INSERT INTO student VALUES (null, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = PageDBconnection.con.prepareStatement(query);
            ps.setString(1, homeBean.getFirstName());
            ps.setString(2, homeBean.getLastName());
            ps.setString(3, homeBean.getGender());
            ps.setString(4, homeBean.getCity());
            
            ps.setObject(5, homeBean.getDate());
            ps.setString(6, homeBean.getAddress());
          
           

            
            
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "A record has been inserted!!");
            
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, ""+e);
        }
    }
    
    //method for get data on click in table
    
    public HomePageBean returnAllDataToTesxtFields(int id){
        HomePageBean bean = null;
        try {
            String query = "SELECT * FROM student WHERE Id = "+id;
            PreparedStatement ps = PageDBconnection.con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                
                int ids = rs.getInt("Id");
                String firstName = rs.getString("FirstName");
                String lastname = rs.getString("LastName");
                String gender = rs.getString("Gender");
                String city = rs.getString("City");
                
                Date date = rs.getDate("Date");
                String address = rs.getString("Address");
                
                bean = new HomePageBean(ids, firstName, lastname , gender, city, date, address);
                
                
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, ""+e);
        }
        return bean;
    }
        
        //method for update
    public void updateDate(HomePageBean bean){
        try {
            String query = "UPDATE student SET FirstName = ?, LastName = ?, Gender = ?, City = ?, Date = ?, Address = ?  WHERE Id = ?";
            PreparedStatement ps = PageDBconnection.con.prepareStatement(query);
            ps.setString(1, bean.getFirstName());
            ps.setString(2, bean.getLastName());
            ps.setString(3, bean.getGender());
            ps.setString(4, bean.getCity());
           
            ps.setObject(5, bean.getDate());
            ps.setString(6, bean.getAddress());
            ps.setInt(7, bean.getId());
            
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "A record has been updated !!");
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, ""+e);
        }
    }
    
    //delete method
    public void deleteRecord(int id){
        try {
            String query = "DELETE FROM student WHERE Id = ?";
            PreparedStatement ps = PageDBconnection.con.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "A record has been deleted !!");
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, ""+e);
        }
    }
    
    }


