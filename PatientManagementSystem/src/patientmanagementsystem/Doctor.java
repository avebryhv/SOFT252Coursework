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
public class Doctor extends User{
    private ArrayList<String> reviewList;
    private ArrayList<Appointment> appointmentList;

    public Doctor(String id, String password, String givenName, String surName, String address) {
        super(id, password, givenName, surName, address);
        reviewList = new ArrayList<String>();
        appointmentList = new ArrayList<Appointment>();
    }

    public void AddReview(String review)
    {
        reviewList.add(review);
    }

    public ArrayList<String> getReviewList() {
        return reviewList;
    }

    public ArrayList<Appointment> getAppointmentList() {
        return appointmentList;
    }
    
    public void AddAppointment(Appointment a)
    {
        appointmentList.add(a);
    }
    
}
