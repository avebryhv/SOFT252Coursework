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
import patientmanagementsystem.Prescription;
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
    
    /**
     *Attempts to log a user in
     * @param ID input user ID
     * @param password input user password
     * @return
     */
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
    
    /**
     *Creates an account for a new patient
     * @param gender String Patient's gender
     * @param age Integer Patient's age
     * @param password String Patient's password
     * @param givenName String Patients given name
     * @param surName String Patient's surname
     * @param address String Patient's address
     */
    public void CreatePatientAccount(String gender, Integer age, String password, String givenName, String surName, String address)
    {
        userManager = UserManagement.getInstance();
        userManager.CreatePatient(gender, age, password, givenName, surName, address);
        
    }
    
    /**
     *Shows the form to create a new patient
     */
    public void ShowCreatePatient()
    {
        CreateAccount form = new CreateAccount();
        form.setVisible(true);
    }
    
    /**
     *Creates an account for a new Secretary
     * @param password
     * @param givenName
     * @param surName
     * @param address
     */
    public void CreateSecretaryAccount(String password, String givenName, String surName, String address)
    {
        userManager = UserManagement.getInstance();
        userManager.CreateSecretary(password, givenName, surName, address);
    }
    
    /**
     *Creates account for a new Doctor
     * @param password
     * @param givenName
     * @param surName
     * @param address
     */
    public void CreateDoctorAccount(String password, String givenName, String surName, String address)
    {
        userManager = UserManagement.getInstance();
        userManager.CreateDoctor(password, givenName, surName, address);
    }
    
    /**
     *Creates account for a new Admin
     * @param password
     * @param givenName
     * @param surName
     * @param address
     */
    public void CreateAdminAccount(String password, String givenName, String surName, String address)
    {
        userManager = UserManagement.getInstance();
        userManager.CreateAdmin(password, givenName, surName, address);
    }
    
    /**
     *Shows form to create new staff members
     */
    public void ShowStaffCreator()
    {
        CreateStaff form = new CreateStaff();
        form.setVisible(true);
    }
    
    /**
     *Returns a list of notifications for a user
     * @param ID User's ID
     * @return List of notifications
     */
    public ArrayList<String> getNotifications(String ID)
    {
        userManager = UserManagement.getInstance();
        return userManager.getCurrentUser().getNotifications();
    }
    
    /**
     *Returns the currently logged in user
     * @return User currently logged in
     */
    public User getCurrentUser()
    {
        userManager = UserManagement.getInstance();
        return userManager.getCurrentUser();
    }
    
    /**
     *Logs the current user out
     */
    public void LogOut()
    {
        userManager = UserManagement.getInstance();
        userManager.LogOut();
        MainGUI newScreen = new MainGUI();
        newScreen.setVisible(true);
    }
    
    /**
     *Used by secretaries to approve new Patients
     */
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
    
    /**
     *Used by Patients to request termination
     */
    public void RequestTermination()
    {
        userManager.RequestTermination(userManager.getCurrentUser());
        JOptionPane.showMessageDialog(null, "Account Termination Requested");
        userManager.getCurrentUser().AddNotification("Account Termination Requested");
    }
    
    /**
     *Deletes a patient from the system, after asking for their ID
     */
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
    
    /**
     *Returns a list of names of every doctor
     * @return List of doctor's names
     */
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
    
    /**
     *Returns a list of names of every patient
     * @return List of Patient names
     */
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
    
    /**
     *Returns a list of all reviews given to a doctor
     * @param name Name of doctor to get reviews of
     * @return List of reviews
     */
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
    
    /**
     *Adds a review to a doctor
     * @param name Name of doctor to review
     * @param review Review contents
     */
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
    
    /**
     *Adds private feedback to a doctor
     * @param name Name of doctor to give feedback
     * @param feedback Contents of feedback
     */
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
    
    /**
     *Creates an appointment between a doctor and patient
     * @param pName String name of patient
     * @param dName String name of doctor
     * @param time String time of appointment
     */
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
    
    /**
     *Requests an appointment
     * @param dName String name of doctor
     * @param time String requested time
     */
    public void RequestAppointment(String dName, String time)
    {
        String note = "Patient " + userManager.getCurrentUser().getGivenName() + " " + userManager.getCurrentUser().getSurName() + " has requested an appointment with " + dName + " at " + time;
        userManager.NotifySecretary(note);
    }
    
    /**
     *Gets list of all appointments for a patient
     * @param u User to get appointments of
     * @return List of appointments
     */
    public ArrayList<Appointment> GetAppointments(Patient u)
    {
        return u.getAppointmentList();
    }
    
    /**
     *Gets list of all appointments for a given doctor
     * @param u Doctor to get appointments of
     * @return List of appointments
     */
    public ArrayList<Appointment> GetAppointments(Doctor u)
    {
        return u.getAppointmentList();
    }
    
    /**
     *Returns list of medicines
     * @return List of medicine names
     */
    public ArrayList<String> getMedicineNames()
    {
        medicineManager = MedicineManager.getInstance();
        return medicineManager.getNames();        
    }
    
    /**
     *Returns stock of all medicines
     * @return Integer List of medicine stocks
     */
    public ArrayList<Integer> getMedicineStock()
    {
        medicineManager = MedicineManager.getInstance();
        return medicineManager.getStock();        
    }
    
    /**
     *Orders more of a medicine
     * @param name String medicine to order
     * @param quantity Integer amount to order
     */
    public void OrderMedicine(String name, int quantity)
    {
        medicineManager = MedicineManager.getInstance();
        medicineManager.Restock(name, quantity);
    }
    
    /**
     *Gives out medicine to patient
     * @param name String medicine to give
     * @param quantity Integer amount to give
     */
    public void UseMedicine(String name, int quantity)
    {
        medicineManager = MedicineManager.getInstance();
        medicineManager.HandOut(name, quantity);
    }
    
    /**
     *Adds a note to an appointment
     * @param a Appointment Relevant appointment
     * @param note String note to add
     */
    public void AddNote(Appointment a, String note)
    {
        a.setNotes(note);
    }
    
    /**
     *Creates a prescription
     * @param p Patient
     * @param d Doctor
     * @param notes
     * @param m Medicine
     * @param quantity
     * @param dosage
     */
    public void CreatePrescription(Patient p, Doctor d, String notes, String m, Integer quantity, String dosage)
    {
        userManager = UserManagement.getInstance();
        Prescription temp = new Prescription(p, d, notes, m, quantity, dosage);
        p.addPrescription(temp);
        appointmentManager = AppointmentManager.getInstance();
        appointmentManager.getCurrentAppointment().setPrescription(temp);
        JOptionPane.showMessageDialog(null, "Prescription Added to " + p.getGivenName());
    }
    
    /**
     *Sets an appointment as active
     * @param a Appointment to set
     */
    public void SetCurrentAppointment(Appointment a)
    {
        appointmentManager = AppointmentManager.getInstance();
        appointmentManager.setCurrentAppointment(a);
        System.out.println("Set current appointment" + a.getTime());
    }
    
    /**
     *Gets the currently active appointment
     * @return Appointment currently active
     */
    public Appointment GetCurrentAppointment()
    {
        appointmentManager = AppointmentManager.getInstance();
        System.out.println("Get current appointment" + appointmentManager.getCurrentAppointment().getTime());
        return appointmentManager.getCurrentAppointment();
        
    }
    
    /**
     *Creates a new Medicine
     * @param name String Name of new medicine
     */
    public void CreateMedicine(String name)
    {
        userManager = UserManagement.getInstance();
        medicineManager = MedicineManager.getInstance();
        medicineManager.CreateMedicine(name, 0);
        userManager.NotifySecretary("New medicine " + name + " has been added");
    }
    
}
