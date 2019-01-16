/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patientmanagementsystem;

import GUI.MainGUI;
import Serialiser.Serialiser;

/**
 *Main Method
 * @author ahoughton-vowles
 */
public class PatientManagementSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        UserManagement userManager;
        Serialiser serialiser = new Serialiser("user_file.ser");
        if (serialiser.readObject() == null) {
            userManager = UserManagement.getInstance();
        }else
        {
            userManager = (UserManagement)serialiser.readObject();
        }
        //UserManagement userManager = UserManagement.getInstance();
        MedicineManager mediManager = MedicineManager.getInstance();
        userManager.CreateAdmin("bepis", "Big", "Bepsi", "long dong lane");
        System.out.println(userManager.UserCount());
        if (userManager.LogIn("A0000", "bepis")) {            
            System.out.println("logged in");
            userManager.CreateSecretary("pass", "Dongus", "Kongus", "STRONG dong lane");
            userManager.CreatePatient("Male", 3, "pass2", "yeet", "beat", "meme land");
            userManager.CreateDoctor("pass", "Strong", "Kong", "STRONG dong lane");
            userManager.CreateDoctor("pass", "Stronger", "Konger", "STRONGer dong lane");
            userManager.ApproveAccount("P0002");
        }
        userManager.LogOut();
        mediManager.CreateMedicine("BONE HURTING JUICE", 10);
        mediManager.CreateMedicine("bad succ", 3);
        mediManager.CreateMedicine("big dick energy", 5);
        MainGUI initialForm = new MainGUI();
        initialForm.setVisible(true);
        //User u = userManager.getUserByID("P0");
        
        
    }
    
}
