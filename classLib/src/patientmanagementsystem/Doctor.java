/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patientmanagementsystem;

import java.util.ArrayList;

/**
 *Doctors
 * @author Avebry
 */
public class Doctor extends User{
    private ArrayList<String> reviewList;
    private ArrayList<Appointment> appointmentList;

    /**
     *
     * @param id
     * @param password
     * @param givenName
     * @param surName
     * @param address
     */
    public Doctor(String id, String password, String givenName, String surName, String address) {
        super(id, password, givenName, surName, address);
        reviewList = new ArrayList<String>();
        appointmentList = new ArrayList<Appointment>();
    }

    /**
     *
     * @param review
     */
    public void AddReview(String review)
    {
        reviewList.add(review);
    }

    /**
     *
     * @return
     */
    public ArrayList<String> getReviewList() {
        return reviewList;
    }

    /**
     *
     * @return
     */
    public ArrayList<Appointment> getAppointmentList() {
        return appointmentList;
    }
    
    /**
     *
     * @param a
     */
    public void AddAppointment(Appointment a)
    {
        appointmentList.add(a);
    }
    
}
