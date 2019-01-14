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
public class Admin extends User{
    UserManagement userManager;
    public Admin(String id, String password, String givenName, String surName, String address) {
        super(id, password, givenName, surName, address);
        userManager = UserManagement.getInstance();
    }
    
    public void CreateSecretary(String password, String givenName, String surName, String address)
    {
        userManager.CreateSecretary(password, givenName, surName, address);
    }

    
    
    
    
}
