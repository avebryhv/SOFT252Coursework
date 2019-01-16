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
        InitialUsers(userManager);
        MainGUI initialForm = new MainGUI();
        initialForm.setVisible(true);
        //User u = userManager.getUserByID("P0");
        
        
    }
    
    private static void InitialUsers(UserManagement m)
    {
        m.CreateAdmin("admin", "Kaira", "Warner", "2 Admin Street");
        m.CreateSecretary("secretary", "Ryder", "Kelley", "88 T Lane");
        m.CreateDoctor("doctor", "Carlie", "Roman", "44 Doc Street");
        m.CreateDoctor("password", "Byron", "Cooley", "23 Doc Street");
        m.CreateDoctor("password", "Daniela", "Sharpe", "77 Doc Street");
        m.CreatePatient("Male", 34, "patient", "Kurtis", "Dudley", "4 P Street");
        m.CreatePatient("Male", 25, "pass", "Derrick", "Mathews", "88 P Street");
        m.CreatePatient("Female", 29, "1234", "Meg", "Key", "4 P Street");
        m.ApproveAccount("P0005");
        m.ApproveAccount("P0006");
        m.ApproveAccount("P0007");
        MedicineManager med = MedicineManager.getInstance();
        med.CreateMedicine("Humira", 55);
        med.CreateMedicine("Avastin", 12);
        med.CreateMedicine("Enbrel", 88);
        med.CreateMedicine("Rituxan", 170);
        med.CreateMedicine("Crestor", 50);
        med.CreateMedicine("Herceptin", 100);
        med.CreateMedicine("Remicade", 30);
        med.CreateMedicine("Lantus", 88);
        med.CreateMedicine("Advair", 20);
        med.CreateMedicine("Prolia", 71);
    }
    
}
