/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patientmanagementsystem;

import java.util.ArrayList;

/**
 *
 * @author Avebry
 */
public abstract class User {
    
    private String id;
    private String password;
    private String givenName;
    private String surName;
    private String address;
    private ArrayList<String> notifications;

    public User(String id, String password, String givenName, String surName, String address) {
        this.id = id;
        this.password = password;
        this.givenName = givenName;
        this.surName = surName;
        this.address = address;
        notifications = new ArrayList<String>();
    }

    

    
    
    public Boolean LogIn(String idInput, String passInput)
    {
        if (idInput.equals(id) && passInput.equals(password)) {
            return true;
        }
        else
        {
            return false;
        }
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getGivenName() {
        return givenName;
    }

    public String getSurName() {
        return surName;
    }

    public String getAddress() {
        return address;
    }

    public ArrayList<String> getNotifications() {
        return notifications;
    }
    
    public void AddNotification(String note)
    {
        notifications.add(note);
    }
    
    
    
}
