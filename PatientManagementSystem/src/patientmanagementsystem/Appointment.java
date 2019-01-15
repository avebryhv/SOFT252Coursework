/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patientmanagementsystem;

import java.util.Date;

/**
 *
 * @author Avebry
 */
public class Appointment {
    private int ID;
    private Doctor doctor;
    private Patient patient;
    private Prescription prescription;
    private String time;
    private String notes;

    public Appointment(Doctor doctor, Patient patient, String time) {
        this.doctor = doctor;
        this.patient = patient;
        this.time = time;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public Prescription getPrescription() {
        return prescription;
    }

    public String getTime() {
        return time;
    }

    public String getNotes() {
        return notes;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }  
    
    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
    
    
    
    
    
}
