/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import GUI.AdminForm;
import GUI.CreateAccount;
import GUI.CreateStaff;
import GUI.DoctorForm;
import GUI.MainGUI;
import GUI.PatientForm;
import GUI.SecretaryForm;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import patientmanagementsystem.Appointment;
import patientmanagementsystem.AppointmentManager;
import patientmanagementsystem.Doctor;
import patientmanagementsystem.MedicineManager;
import patientmanagementsystem.Patient;
import patientmanagementsystem.User;
import patientmanagementsystem.UserManagement;

/**
 *
 * @author ahoughton-vowles
 */
public class Controller {   
    
    UserManagement userManager;
    AppointmentManager appointmentManager;
    MedicineManager medicineManager;
    
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
    
    public void CreateSecretaryAccount(String password, String givenName, String surName, String address)
    {
        userManager = UserManagement.getInstance();
        userManager.CreateSecretary(password, givenName, surName, address);
    }
    
    public void CreateDoctorAccount(String password, String givenName, String surName, String address)
    {
        userManager = UserManagement.getInstance();
        userManager.CreateDoctor(password, givenName, surName, address);
    }
    
    public void CreateAdminAccount(String password, String givenName, String surName, String address)
    {
        userManager = UserManagement.getInstance();
        userManager.CreateAdmin(password, givenName, surName, address);
    }
    
    public void ShowStaffCreator()
    {
        CreateStaff form = new CreateStaff();
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
    
    public ArrayList<String> GetDoctorNames()
    {
        userManager = UserManagement.getInstance();
        ArrayList<String> list = new ArrayList<String>();
        ArrayList<Doctor> doctors = userManager.GetDoctors();
        for (int i = 0; i < doctors.size(); i++) {
            list.add(doctors.get(i).getGivenName() + " " + doctors.get(i).getSurName());
        }
        return list;
    }
    
    public ArrayList<String> GetPatientNames()
    {
        userManager = UserManagement.getInstance();
        ArrayList<String> list = new ArrayList<String>();
        ArrayList<Patient> patients = userManager.GetPatients();
        for (int i = 0; i < patients.size(); i++) {
            list.add(patients.get(i).getGivenName() + " " + patients.get(i).getSurName());
        }
        return list;
    }
    
    public ArrayList<String> GetDoctorReviews(String name)
    {
        userManager = UserManagement.getInstance();
        ArrayList<Doctor> doctors = userManager.GetDoctors();
        ArrayList<String> list = new ArrayList<String>();
        
        for (int i = 0; i < doctors.size(); i++) {
            String docName = doctors.get(i).getGivenName() + " " + doctors.get(i).getSurName();
            if (docName.equals(name)) {
                list = doctors.get(i).getReviewList();
            }
        }
        
        return list;
    }
    
    public void AddReview(String name, String review)
    {
        userManager = UserManagement.getInstance();
        ArrayList<Doctor> doctors = userManager.GetDoctors();
        for (int i = 0; i < doctors.size(); i++) {
            String docName = doctors.get(i).getGivenName() + " " + doctors.get(i).getSurName();
            if (docName.equals(name)) {
                doctors.get(i).AddReview(review);
                JOptionPane.showMessageDialog(null, "Review Added");
                break;
            }
        }
    }
    
    public void AddFeedback(String name, String feedback)
    {
        userManager = UserManagement.getInstance();
        ArrayList<Doctor> doctors = userManager.GetDoctors();
        for (int i = 0; i < doctors.size(); i++) {
            String docName = doctors.get(i).getGivenName() + " " + doctors.get(i).getSurName();
            if (docName.equals(name)) {
                doctors.get(i).AddNotification("Feedback Recieved: " + feedback);
                JOptionPane.showMessageDialog(null, "Feedback Submitted");
                break;
            }
        }
    }
    
    public void CreateAppointment(String pName, String dName, String time)
    {
        userManager = UserManagement.getInstance();
        Doctor d = null;
        Patient p = null;
        userManager = UserManagement.getInstance();
        ArrayList<Doctor> doctors = userManager.GetDoctors();
        for (int i = 0; i < doctors.size(); i++) {
            String docName = doctors.get(i).getGivenName() + " " + doctors.get(i).getSurName();
            if (docName.equals(dName)) {
                d = doctors.get(i);
                break;
            }
        }
        ArrayList<Patient> patients = userManager.GetPatients();
        for (int i = 0; i < patients.size(); i++) {
            String patName = patients.get(i).getGivenName() + " " + patients.get(i).getSurName();
            if (patName.equals(pName)) {
                p = patients.get(i);
                break;
            }
        }
        appointmentManager = AppointmentManager.getInstance();
        appointmentManager.CreateAppointment(d, p, time);
        JOptionPane.showMessageDialog(null, "Appointment Created: " + p.getGivenName() + " " + p.getSurName() + " with " + d.getGivenName() + " " + d.getSurName() + " at " + time);
        d.AddNotification("Appointment with " + p.getGivenName() + " " + p.getSurName() + " at " + time);
        p.AddNotification("Appointment granted with " + d.getGivenName() + " " + d.getSurName() + " at " + time);
    }
    
    public void RequestAppointment(String dName, String time)
    {
        String note = "Patient " + userManager.getCurrentUser().getGivenName() + " " + userManager.getCurrentUser().getSurName() + " has requested an appointment with " + dName + " at " + time;
        userManager.NotifySecretary(note);
    }
    
    public ArrayList<Appointment> GetAppointments(Patient u)
    {
        return u.getAppointmentList();
    }
    
    public ArrayList<Appointment> GetAppointments(Doctor u)
    {
        return u.getAppointmentList();
    }
    
    public ArrayList<String> getMedicineNames()
    {
        medicineManager = MedicineManager.getInstance();
        return medicineManager.getNames();        
    }
    
    public ArrayList<Integer> getMedicineStock()
    {
        medicineManager = MedicineManager.getInstance();
        return medicineManager.getStock();        
    }
    
    public void OrderMedicine(String name, int quantity)
    {
        medicineManager = MedicineManager.getInstance();
        medicineManager.Restock(name, quantity);
    }
    
    public void UseMedicine(String name, int quantity)
    {
        medicineManager = MedicineManager.getInstance();
        medicineManager.HandOut(name, quantity);
    }
    
    public void AddNote(Appointment a, String note)
    {
        a.setNotes(note);
    }
    
    public void CreatePrescription(Patient p, Doctor d, String notes, String m, Integer quantity, String dosage)
    {
        
    }
    
}
