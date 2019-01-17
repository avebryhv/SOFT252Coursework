/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patientmanagementsystem;

import java.util.ArrayList;

/**
 *Secretaries
 * @author Avebry
 */
public class Secretary extends User{

    UserManagement userManager;
            
    /**
     *
     * @param id
     * @param password
     * @param givenName
     * @param surName
     * @param address
     */
    public Secretary(String id, String password, String givenName, String surName, String address) {
        super(id, password, givenName, surName, address);
        userManager = UserManagement.getInstance();
    }

    /**
     *
     * @param ID
     */
    public void ApprovePatient(String ID)
   {
       userManager.ApproveAccount(ID);
   }
    
    
    
}
