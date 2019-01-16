/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patientmanagementsystem;

import java.util.ArrayList;

/**
 *System Admins
 * @author Avebry
 */
public class Admin extends User{
    UserManagement userManager;

    /**
     *
     * @param id
     * @param password
     * @param givenName
     * @param surName
     * @param address
     */
    public Admin(String id, String password, String givenName, String surName, String address) {
        super(id, password, givenName, surName, address);
        userManager = UserManagement.getInstance();
    }
    
    /**
     *
     * @param password
     * @param givenName
     * @param surName
     * @param address
     */
    public void CreateSecretary(String password, String givenName, String surName, String address)
    {
        userManager.CreateSecretary(password, givenName, surName, address);
    }

    
    
    
    
}
