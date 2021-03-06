/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patientmanagementsystem;

import java.util.ArrayList;
import java.util.Date;

/**
 *Singleton class to store appointment details
 * @author Avebry
 */
public class AppointmentManager {
    
    private static AppointmentManager uniqueInstance = null;
    private ArrayList<Appointment> appointmentList;
    private Appointment currentAppointment;
    UserManagement userManager;
    
    /**
     *
     */
    public AppointmentManager() {
        appointmentList = new ArrayList<Appointment>();
    }
    
    /**
     *
     * @return
     */
    public static AppointmentManager getInstance()
    {
        if (uniqueInstance == null){      
    	uniqueInstance = new AppointmentManager(); 
        }
   	return uniqueInstance;
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
     *Creates a new appointment
     * @param d Doctor
     * @param p Patient
     * @param time String date of appointment
     */
    public void CreateAppointment(Doctor d, Patient p, String time)
    {
        Appointment a = new Appointment(d, p, time);
        a.setID(appointmentList.size());
        AddAppointment(a);
        userManager = UserManagement.getInstance();
        
        ArrayList<Doctor> doctors = userManager.GetDoctors();
        for (int i = 0; i < doctors.size(); i++) {
            if (d.equals(doctors.get(i))) {
                doctors.get(i).AddAppointment(a);
            }
        }
        
        ArrayList<Patient> patients = userManager.GetPatients();
        for (int i = 0; i < patients.size(); i++) {
            if (p.equals(patients.get(i))) {
                patients.get(i).AddAppointment(a);
            }
        }
    }

    /**
     *
     * @return
     */
    public Appointment getCurrentAppointment() {
        return currentAppointment;
    }

    /**
     *
     * @param currentAppointment
     */
    public void setCurrentAppointment(Appointment currentAppointment) {
        this.currentAppointment = currentAppointment;
    }
    
    
    
    


    
}
