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
public class Patient extends User{
    
    private String gender;
    private int age;
    private Boolean approvedAccount;
    private ArrayList<Appointment> appointmentList;
    private ArrayList<Prescription> prescriptionList;

    /**
     *
     * @param gender
     * @param age
     * @param id
     * @param password
     * @param givenName
     * @param surName
     * @param address
     */
    public Patient(String gender, int age, String id, String password, String givenName, String surName, String address) {
        super(id, password, givenName, surName, address);
        this.gender = gender;
        this.age = age;
        approvedAccount = false;
        appointmentList = new ArrayList<Appointment>();
        prescriptionList = new ArrayList<Prescription>();
    }

    /**
     *
     * @return
     */
    public Boolean getApprovedAccount() {
        return approvedAccount;
    }

    /**
     *
     * @param approvedAccount
     */
    public void setApprovedAccount(Boolean approvedAccount) {
        this.approvedAccount = approvedAccount;
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

    /**
     *
     * @return
     */
    public String getGender() {
        return gender;
    }

    /**
     *
     * @return
     */
    public int getAge() {
        return age;
    }

    /**
     *
     * @return
     */
    public ArrayList<Prescription> getPrescriptionList() {
        return prescriptionList;
    }
    
    /**
     *
     * @param p
     */
    public void addPrescription(Prescription p)
    {
        prescriptionList.add(p);
    }

    
    
    
    
}
