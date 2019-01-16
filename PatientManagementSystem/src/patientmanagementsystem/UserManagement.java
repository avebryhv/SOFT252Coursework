/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patientmanagementsystem;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Avebry
 */
public class UserManagement {
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
     *
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
     *
     * @return
     */
    public int UserCount()
    {
        return userList.size();
    }
    
    /**
     *
     * @param u
     */
    public void AddUser(User u)
    {
        userList.add(u);
        System.out.println(u.getGivenName() + " " + u.getSurName() + " added");
    }
    
    /**
     *
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
     *
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
     *
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
     *
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
     *
     * @param i
     */
    public void RemoveID(String i)
    {
        String num = i.substring(1);
        int toRemove = Integer.parseInt(num);
        userList.remove(toRemove);
    }
    
    /**
     *
     * @param userID
     * @param userPass
     * @return
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
     *
     */
    public void LogOut()
    {
        currentUser = null;
    }

    /**
     *
     * @return
     */
    public User getCurrentUser() {
        return currentUser;
    }
    
    /**
     *
     * @param toGet
     * @return
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
    
    private void AddToApproval(Patient p)
    {
        waitingApproval.add(p); 
        String note = p.getGivenName() + " " + p.getSurName() + "(" + p.getId() + ") is waiting for approval";
        NotifySecretary(note);
        System.out.println(p.getGivenName() + " " + p.getSurName() + "(" + p.getId() + ") is waiting for approval");
    }
    
    /**
     *
     * @param p
     */
    public void RequestTermination(User p)
    {
        String note = p.getGivenName() + " " + p.getSurName() + "(" + p.getId() + ") has requested termination";
        NotifySecretary(note);
    }
    
    /**
     *
     * @param ID
     * @return
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
     *
     * @param ID
     * @return
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
     *
     * @param ID
     */
    public void RemoveUser(String ID)
    {
        userList.remove(getUserByID(ID));
        System.out.println(ID + " removed");
    }
    
    /**
     *
     * @return
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
     *
     * @return
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
     *
     * @param note
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
