/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patientmanagementsystem;

import GUI.MainGUI;

/**
 *
 * @author ahoughton-vowles
 */
public class PatientManagementSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        UserManagement userManager = UserManagement.getInstance();
        userManager.CreateAdmin("bepis", "Big", "Bepsi", "long dong lane");
        System.out.println(userManager.UserCount());
        if (userManager.LogIn("A0000", "bepis")) {            
            System.out.println("logged in");
            userManager.CreateSecretary("pass", "Dongus", "Kongus", "STRONG dong lane");
            userManager.CreatePatient("Male", 3, "pass2", "yeet", "beat", "meme land");
        }
        userManager.LogOut();
        MainGUI initialForm = new MainGUI();
        initialForm.setVisible(true);
        //User u = userManager.getUserByID("P0");
        
        
    }
    
}
