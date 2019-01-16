/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patientmanagementsystem;

import java.util.Date;

/**
 *Appointments between patients and doctors
 * @author Avebry
 */
public class Appointment {
    private int ID;
    private Doctor doctor;
    private Patient patient;
    private Prescription prescription;
    private String time;
    private String notes;

    /**
     *
     * @param doctor
     * @param patient
     * @param time
     */
    public Appointment(Doctor doctor, Patient patient, String time) {
        this.doctor = doctor;
        this.patient = patient;
        this.time = time;
    }

    /**
     *
     * @return
     */
    public Doctor getDoctor() {
        return doctor;
    }

    /**
     *
     * @return
     */
    public Patient getPatient() {
        return patient;
    }

    /**
     *
     * @return
     */
    public Prescription getPrescription() {
        return prescription;
    }

    /**
     *
     * @return
     */
    public String getTime() {
        return time;
    }

    /**
     *
     * @return
     */
    public String getNotes() {
        return notes;
    }

    /**
     *
     * @return
     */
    public int getID() {
        return ID;
    }

    /**
     *
     * @param ID
     */
    public void setID(int ID) {
        this.ID = ID;
    }  
    
    /**
     *
     * @param prescription
     */
    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }

    /**
     *
     * @param notes
     */
    public void setNotes(String notes) {
        this.notes = notes;
    }
    
    
    
    
    
}
