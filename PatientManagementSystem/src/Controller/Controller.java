/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import patientmanagementsystem.UserManagement;

/**
 *
 * @author ahoughton-vowles
 */
public class Controller {   
    
    UserManagement userManager;
    
    public void LogIn(String ID, String password)
    {
        userManager = UserManagement.getInstance();
    }
    
    
}
