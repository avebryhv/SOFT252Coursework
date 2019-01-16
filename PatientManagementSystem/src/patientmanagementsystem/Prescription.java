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
public class Prescription {
    private Patient patient;
    private Doctor doctor;
    private ArrayList<String> medicineList;
    private ArrayList<Integer> quantities;
    private ArrayList<String> dosageList;
    private String notes;

    public Prescription(Patient patient, Doctor doctor,String note, String m, Integer quantity, String dosage) {
        this.patient = patient;
        this.doctor = doctor;
        medicineList = new ArrayList<String>();
        this.medicineList.add(m);
        quantities = new ArrayList<Integer>();
        this.quantities.add(quantity);
        dosageList = new ArrayList<String>();
        this.dosageList.add(dosage);
        notes = note;
    }
    
    public void AddMedicine(String m, Integer q, String d)
    {
        medicineList.add(m);
        quantities.add(q);
        dosageList.add(d);
    }

    public Patient getPatient() {
        return patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public ArrayList<String> getMedicineList() {
        return medicineList;
    }

    public ArrayList<Integer> getQuantities() {
        return quantities;
    }

    public ArrayList<String> getDosage() {
        return dosageList;
    }
    
    
    
    
}
