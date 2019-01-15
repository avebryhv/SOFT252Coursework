/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import GUI.AdminForm;
import GUI.CreateAccount;
import GUI.DoctorForm;
import GUI.MainGUI;
import GUI.PatientForm;
import GUI.SecretaryForm;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import patientmanagementsystem.User;
import patientmanagementsystem.UserManagement;

/**
 *
 * @author ahoughton-vowles
 */
public class Controller {   
    
    UserManagement userManager;
    
    public Boolean LogIn(String ID, String password)
    {
        userManager = UserManagement.getInstance();
        if (userManager.LogIn(ID, password)) {
            System.out.println("Current ID: " + userManager.getCurrentUser().getId());
            if (userManager.CheckApproved(userManager.getCurrentUser().getId())) {
                JOptionPane.showMessageDialog(null, "Account Not Yet Approved");
            }
            else
            {
                //Login Here
                switch(userManager.getCurrentUser().getId().charAt(0))
                {
                    case 'S':
                        SecretaryForm secForm = new SecretaryForm();
                        secForm.setVisible(true);
                        return true;
                        
                    case 'P':
                        PatientForm patForm = new PatientForm();
                        patForm.setVisible(true);
                        return true;
                        
                    case 'D':
                        DoctorForm docForm = new DoctorForm();
                        docForm.setVisible(true);
                        return true;
                        
                    case 'A':
                        AdminForm adForm = new AdminForm();
                        adForm.setVisible(true);
                        return true;
                    default:
                        break;
                }
            }
        }else
        {
            JOptionPane.showMessageDialog(null, "Login Details Incorrect");
        }
        return false;
    }
    
    public void CreatePatientAccount(String gender, Integer age, String password, String givenName, String surName, String address)
    {
        userManager = UserManagement.getInstance();
        userManager.CreatePatient(gender, age, password, givenName, surName, address);
        
    }
    
    public void ShowCreatePatient()
    {
        CreateAccount form = new CreateAccount();
        form.setVisible(true);
    }
    
    public ArrayList<String> getNotifications(String ID)
    {
        userManager = UserManagement.getInstance();
        return userManager.getCurrentUser().getNotifications();
    }
    
    public User getCurrentUser()
    {
        userManager = UserManagement.getInstance();
        return userManager.getCurrentUser();
    }
    
    public void LogOut()
    {
        userManager = UserManagement.getInstance();
        userManager.LogOut();
        MainGUI newScreen = new MainGUI();
        newScreen.setVisible(true);
    }
    
    public void ApproveNewPatient()
    {
        String ID;
        ID = JOptionPane.showInputDialog("Please input the ID of the account to approve");
        if (userManager.ApproveAccount(ID)) {
            JOptionPane.showMessageDialog(null, "Account Approved");
        }else
        {
            JOptionPane.showMessageDialog(null, "Account Not Found");
        }
    }
    
    public void RequestTermination()
    {
        userManager.RequestTermination(userManager.getCurrentUser());
        JOptionPane.showMessageDialog(null, "Account Termination Requested");
        userManager.getCurrentUser().AddNotification("Account Termination Requested");
    }
    
    public void DeletePatient()
    {
        String ID;
        ID = JOptionPane.showInputDialog("Please input the ID of the Patient to delete");
        if (ID.charAt(0) == 'P') {
            userManager.RemoveUser(ID);
        }else
        {
            JOptionPane.showMessageDialog(null, "Input ID not a valid patient ID");
        }
    }
}
