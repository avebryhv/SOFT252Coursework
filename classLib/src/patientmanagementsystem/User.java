/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patientmanagementsystem;

import java.util.ArrayList;
import utilities.IObserver;
import utilities.ISubject;

/**
 *Abstract class for generic users
 * @author Avebry
 */
public abstract class User implements ISubject{
    
    private String id;
    private String password;
    private String givenName;
    private String surName;
    private String address;
    private ArrayList<String> notifications;
    private ArrayList<IObserver> observers = null;


    /**
     *
     * @param id
     * @param password
     * @param givenName
     * @param surName
     * @param address
     */
    public User(String id, String password, String givenName, String surName, String address) {
        this.id = id;
        this.password = password;
        this.givenName = givenName;
        this.surName = surName;
        this.address = address;
        notifications = new ArrayList<String>();
    }

    /**
     *
     * @param idInput
     * @param passInput
     * @return
     */
    public Boolean LogIn(String idInput, String passInput)
    {
        if (idInput.equals(id) && passInput.equals(password)) {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     *
     * @return
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @return
     */
    public String getGivenName() {
        return givenName;
    }

    /**
     *
     * @return
     */
    public String getSurName() {
        return surName;
    }

    /**
     *
     * @return
     */
    public String getAddress() {
        return address;
    }

    /**
     *
     * @return
     */
    public ArrayList<String> getNotifications() {
        return notifications;
    }
    
    /**
     *
     * @param note
     */
    public void AddNotification(String note)
    {
        notifications.add(note);
        notifyObservers();
    }
    
    /**
     *
     * @param o
     * @return
     */
    @Override
    public Boolean registerObserver(IObserver o) {
        Boolean blnAdded = false;                   //Assume this method will fail
        //Validate that observer exists
        if (o != null) {
            //If observer list not initialised create it
            if (this.observers == null) {
                this.observers = new ArrayList<>();
            }
            //Add the observer to the list of registered observers if not already registered
            if(!this.observers.contains(o)){
                blnAdded = this.observers.add(o);
            }
        }
        //Return the result
        return blnAdded;
    }

    /**
     *
     * @param o
     * @return
     */
    @Override
    public Boolean removeObserver(IObserver o) {
        Boolean blnRemoved = false;
        //Validate we have something to remove
        if (o != null) {
            if(this.observers != null && this.observers.size() > 0){
                blnRemoved = this.observers.remove(o);
            }
        }
        return blnRemoved;
    }

    /**
     *
     */
    @Override
    public void notifyObservers() {
        //Ensure we have a valid list of observers
        if (this.observers != null && this.observers.size() > 0) {
            //Start foreach loop
            for (IObserver currentObserver : this.observers) {
                //Call update on this observer
                currentObserver.update();
            }
        }
    }
    
}
