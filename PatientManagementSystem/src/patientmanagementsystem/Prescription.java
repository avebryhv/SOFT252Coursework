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
    private ArrayList<Medicine> medicineList;
    private ArrayList<Integer> quantities;
    private String dosage;
}
