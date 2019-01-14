/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patientmanagementsystem;

import java.util.ArrayList;

/**
 *
 * @author Avebry
 */
public class UserManagement {
    private static UserManagement uniqueInstance = null;
    private ArrayList<User> userList;
    private User currentUser;

    public UserManagement() {
        userList = new ArrayList<User>();
    }
    
    public static UserManagement getInstance()
    {
        if (uniqueInstance == null){      
    	uniqueInstance = new UserManagement(); 
        }
   	return uniqueInstance;
    }
    
    public int UserCount()
    {
        return userList.size();
    }
    
    public void AddUser(User u)
    {
        userList.add(u);
        System.out.println(u.getGivenName() + " " + u.getSurName() + " added");
    }
    
    public void CreatePatient(String gender, int age, String password, String givenName, String surName, String address)
    {
        String newID = "P" + String.format("%04d",UserCount());
        Patient p = new Patient(gender, age, newID, password, givenName, surName, address);
        AddUser(p);
        System.out.println("Patient Added with id " + newID + ", password " + password);
    }
    
    public void CreateDoctor(String password, String givenName, String surName, String address)
    {
        String newID = "D" + String.format("%04d",UserCount());
        Doctor d = new Doctor(newID, password, givenName, surName, address);
        AddUser(d);
        System.out.println("Doctor Added with id " + newID + ", password " + password);
    }
    
    public void CreateAdmin(String password, String givenName, String surName, String address)
    {
        String newID = "A" + String.format("%04d", UserCount());
        Admin a = new Admin(newID, password, givenName, surName, address);
        AddUser(a);
        System.out.println("Admin added with id " + newID + ", password " + password);
    }
    
    public void CreateSecretary(String password, String givenName, String surName, String address)
    {
        String newID = "S" + String.format("%04d",UserCount());
        Secretary s = new Secretary(newID, password, givenName, surName, address);
        AddUser(s);
        System.out.println("Secretary Added with id " + newID + ", password " + password);
    }
    
    public void RemoveID(String i)
    {
        String num = i.substring(1);
        int toRemove = Integer.parseInt(num);
        userList.remove(toRemove);
    }
    
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
    
    public void LogOut()
    {
        currentUser = null;
    }

    public User getCurrentUser() {
        return currentUser;
    }
    
    public User getUserByID(String toGet)
    {
        for (int i = 0; i < UserCount(); i++) {
            if (userList.get(i).getId().equals(toGet)) {
                return userList.get(i);
            }
        }
        return null;
    }
    
    
}
