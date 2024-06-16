/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author ishara
 */
public class PageSignupBean {
    private int id;
    private String fullName;
    private String email;
    

    public PageSignupBean(int id, String fullName, String email) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }
    
}

