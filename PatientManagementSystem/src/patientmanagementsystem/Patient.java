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
    
}
