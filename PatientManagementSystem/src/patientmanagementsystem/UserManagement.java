/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patientmanagementsystem;

import Serialiser.Serialiser;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Avebry
 */
public class UserManagement implements Serializable{
    private static UserManagement uniqueInstance = null;
    private ArrayList<User> userList;
    private ArrayList<Patient> waitingApproval;
    private User currentUser;
    
    

    /**
     * 
     */
    public UserManagement() {
        userList = new ArrayList<User>();
        waitingApproval = new ArrayList<Patient>();
    }
    
    /**
     *Allows single instance of user manager to be passed throughout program
     * @return
     */
    public static UserManagement getInstance()
    {
        if (uniqueInstance == null){      
    	uniqueInstance = new UserManagement(); 
        }
   	return uniqueInstance;
    }
    
    /**
     *Gets number of users in the system
     * @return int The number of users
     */
    public int UserCount()
    {
        return userList.size();
    }
    
    /**
     *Adds a user to the list
     * @param u The user to be added
     */
    public void AddUser(User u)
    {
        userList.add(u);
        System.out.println(u.getGivenName() + " " + u.getSurName() + " added");
    }
    
    /**
     *Creates a new patient to be added
     * @param gender
     * @param age
     * @param password
     * @param givenName
     * @param surName
     * @param address
     */
    public void CreatePatient(String gender, int age, String password, String givenName, String surName, String address)
    {
        String newID = "P" + String.format("%04d",UserCount());
        Patient p = new Patient(gender, age, newID, password, givenName, surName, address);
        AddUser(p);
        System.out.println("Patient Added with id " + newID + ", password " + password);
        AddToApproval(p);
        JOptionPane.showMessageDialog(null, "Account created: \n ID: " + p.getId() + "\n Password: " + p.getPassword());
        for (int j = 0; j < UserCount(); j++) {
                    if (userList.get(j).getId().charAt(0) == 'A') {
                    userList.get(j).AddNotification(p.getGivenName() + " " + p.getSurName() + "(" + p.getId() + ") has been added");
                    }
                }
    }
    
    /**
     *Creates a new doctor to be added
     * @param password
     * @param givenName
     * @param surName
     * @param address
     */
    public void CreateDoctor(String password, String givenName, String surName, String address)
    {
        String newID = "D" + String.format("%04d",UserCount());
        Doctor d = new Doctor(newID, password, givenName, surName, address);
        AddUser(d);
        System.out.println("Doctor Added with id " + newID + ", password " + password);
        for (int j = 0; j < UserCount(); j++) {
                    if (userList.get(j).getId().charAt(0) == 'A') {
                    userList.get(j).AddNotification(d.getGivenName() + " " + d.getSurName() + "(" + d.getId() + ") has been added");
                    }
                }
    }
    
    /**
     *Creates a new admin to be added
     * @param password
     * @param givenName
     * @param surName
     * @param address
     */
    public void CreateAdmin(String password, String givenName, String surName, String address)
    {
        String newID = "A" + String.format("%04d", UserCount());
        Admin a = new Admin(newID, password, givenName, surName, address);
        AddUser(a);
        System.out.println("Admin added with id " + newID + ", password " + password);
        for (int j = 0; j < UserCount(); j++) {
                    if (userList.get(j).getId().charAt(0) == 'A') {
                    userList.get(j).AddNotification(a.getGivenName() + " " + a.getSurName() + "(" + a.getId() + ") has been added");
                    }
                }
    }
    
    /**
     *Creates a new secretary to be added
     * @param password
     * @param givenName
     * @param surName
     * @param address
     */
    public void CreateSecretary(String password, String givenName, String surName, String address)
    {
        String newID = "S" + String.format("%04d",UserCount());
        Secretary s = new Secretary(newID, password, givenName, surName, address);
        AddUser(s);
        System.out.println("Secretary Added with id " + newID + ", password " + password);
        for (int j = 0; j < UserCount(); j++) {
                    if (userList.get(j).getId().charAt(0) == 'A') {
                    userList.get(j).AddNotification(s.getGivenName() + " " + s.getSurName() + "(" + s.getId() + ") has been added");
                    }
                }
    }
    
    /**
     *Removes a user with matching ID
     * @param i The ID of the user to remove
     */
    public void RemoveID(String i)
    {
        String num = i.substring(1);
        int toRemove = Integer.parseInt(num);
        userList.remove(toRemove);
    }
    
    /**
     *Checks if login details are valid
     * @param userID The input user ID to be checked
     * @param userPass The input password to be checked
     * @return Boolean true if login details are correct
     */
    public Boolean LogIn(String userID, String userPass)
    {
        Boolean canLogIn = false;
        for (int i = 0; i < UserCount(); i++) {
            if (userList.get(i).LogIn(userID, userPass)) {
                currentUser = userList.get(i);
                canLogIn = true;
                break;
            }
        }
        return canLogIn;
    }
    
    /**
     *Logs Out
     */
    public void LogOut()
    {
        currentUser = null;
    }

    /**
     *Retrieves the currently logged in user
     * @return User currently logged in
     */
    public User getCurrentUser() {
        return currentUser;
    }
    
    /**
     *Retrieves a user with given ID
     * @param toGet the ID to get
     * @return User with specified ID
     */
    public User getUserByID(String toGet)
    {
        for (int i = 0; i < UserCount(); i++) {
            if (userList.get(i).getId().equals(toGet)) {
                return userList.get(i);
            }
        }
        return null;
    }
    
    /**
     * Adds a new patient to the list of accounts to be approved
     * @param p The patient to add
     */
    private void AddToApproval(Patient p)
    {
        waitingApproval.add(p); 
        String note = p.getGivenName() + " " + p.getSurName() + "(" + p.getId() + ") is waiting for approval";
        NotifySecretary(note);
        System.out.println(p.getGivenName() + " " + p.getSurName() + "(" + p.getId() + ") is waiting for approval");
    }
    
    /**
     *Notifies a secretary the patient wishes to be terminated
     * @param p The patient to be terminated
     */
    public void RequestTermination(User p)
    {
        String note = p.getGivenName() + " " + p.getSurName() + "(" + p.getId() + ") has requested termination";
        NotifySecretary(note);
    }
    
    /**
     *Approves a pending account
     * @param ID The ID of the account to verify
     * @return Boolean true if a valid ID was input
     */
    public Boolean ApproveAccount(String ID)
    {
        for (int i = 0; i < waitingApproval.size(); i++) {
            if (waitingApproval.get(i).getId().equals(ID)) {
                waitingApproval.get(i).setApprovedAccount(true);
                waitingApproval.remove(waitingApproval.get(i));
                System.out.println(ID + " approved");
                String note = getUserByID(ID).getGivenName() + " " + getUserByID(ID).getSurName() + "(" + getUserByID(ID).getId() + ") has been approved";
                NotifySecretary(note);
                return true;
            }
        }   
        return false;
    }
    
    /**
     *Check if a patient account is approved
     * @param ID ID of the account to check
     * @return Boolean True if the account is approved
     */
    public Boolean CheckApproved(String ID)
    {
        for (int i = 0; i < waitingApproval.size(); i++) {
            if (ID.equals(waitingApproval.get(i).getId())) {
                return true;
            }
        }
        return false;
    }
    
    /**
     *Removes a user from the system
     * @param ID ID of the user to remove
     */
    public void RemoveUser(String ID)
    {
        userList.remove(getUserByID(ID));
        System.out.println(ID + " removed");
    }
    
    /**
     *Gets a list of all doctors
     * @return ArrayList list of doctors
     */
    public ArrayList<Doctor> GetDoctors()
    {
        ArrayList<Doctor> list = new ArrayList<Doctor>();
        for (int i = 0; i < UserCount(); i++) {
            if (userList.get(i).getId().charAt(0) == 'D') {
                list.add((Doctor)userList.get(i));
            }
        }
        return list;      
        
    }    
    
    /**
     *Gets a list of all patients
     * @return ArrayList list of patients
     */
    public ArrayList<Patient> GetPatients()
    {
        ArrayList<Patient> list = new ArrayList<Patient>();
        for (int i = 0; i < UserCount(); i++) {
            if (userList.get(i).getId().charAt(0) == 'P') {
                list.add((Patient)userList.get(i));
            }
        }
        return list;      
        
    }    
    
    /**
     *Sends a notification to all secretaries
     * @param note String to send
     */
    public void NotifySecretary(String note)
    {
        for (int i = 0; i < UserCount(); i++) {
            if (userList.get(i).getId().charAt(0) == 'S') {
                userList.get(i).AddNotification(note);
            }
        }
    }
}
