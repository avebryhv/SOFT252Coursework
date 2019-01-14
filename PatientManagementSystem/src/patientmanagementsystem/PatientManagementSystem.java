/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patientmanagementsystem;

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
        UserManagement userManager = new UserManagement();
        userManager.CreatePatient("Male", 23, "bepis", "Big", "Bepsi", "long dong lane");
        
        if (userManager.LogIn("P0", "bepis")) {
            User u = userManager.getUserByID("P0");
            System.out.println(u.getSurName());
        }
        
        
        
    }
    
}
