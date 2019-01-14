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
    private ArrayList<User> userList;
    private User currentUser;

    public UserManagement() {
        userList = new ArrayList<User>();
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
        String newID = "P" + Integer.toString(UserCount());
        Patient p = new Patient(gender, age, newID, password, givenName, surName, address);
        AddUser(p);
        System.out.println("Patient Added with id " + newID);
    }
    
    public void CreateDoctor(String password, String givenName, String surName, String address)
    {
        String newID = "D" + Integer.toString(UserCount());
        Doctor d = new Doctor(newID, password, givenName, surName, address);
        AddUser(d);
    }
    
    public void CreateAdmin(String password, String givenName, String surName, String address)
    {
        String newID = "A" + Integer.toString(UserCount());
        Admin a = new Admin(newID, password, givenName, surName, address);
        AddUser(a);
    }
    
    public void CreateSecretary(String password, String givenName, String surName, String address)
    {
        String newID = "S" + Integer.toString(UserCount());
        Secretary s = new Secretary(newID, password, givenName, surName, address);
        AddUser(s);
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

    public User getCurrentUser() {
        return currentUser;
    }
    
    public User getUserByID(String toGet)
    {
        for (int i = 0; i < UserCount(); i++) {
            if (userList.get(i).getId() == toGet) {
                return userList.get(i);
            }
        }
        return null;
    }
    
    
}
