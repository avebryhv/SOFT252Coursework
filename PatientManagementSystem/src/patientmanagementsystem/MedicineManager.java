/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patientmanagementsystem;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *Singleton to store medicine details
 * @author Avebry
 */
public class MedicineManager {
    
    private static MedicineManager uniqueInstance = null;
    private ArrayList<Medicine> medicineList;

    /**
     *
     */
    public MedicineManager() {
        medicineList = new ArrayList<Medicine>();
    }
    
    /**
     *
     * @return
     */
    public static MedicineManager getInstance()
    {
        if (uniqueInstance == null){      
    	uniqueInstance = new MedicineManager(); 
        }
   	return uniqueInstance;
    }
    
    /**
     *
     * @param name
     * @param quantity
     */
    public void CreateMedicine(String name, int quantity)
    {
        int id = medicineList.size();
        Medicine m = new Medicine(id, name, quantity);
        AddMedicine(m);
    }
    
    /**
     *
     * @param m
     */
    public void AddMedicine(Medicine m)
    {
        medicineList.add(m);
    }
    
    /**
     *Depletes stock
     * @param name Name of medicine to hand out
     * @param quantity Amount of medicine to use
     */
    public void HandOut(String name, int quantity)
    {
        for (int i = 0; i < medicineList.size(); i++) {
            if (name.equals(medicineList.get(i).getName())) {
                if (medicineList.get(i).getStock() > quantity) {
                    medicineList.get(i).ReduceQuantity(quantity);
                    JOptionPane.showMessageDialog(null, "Medicine Given: \n " + medicineList.get(i).getName() + " x" + quantity);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Insufficient Stock");
                }
                
                
                break;
            }
        }
    }
    
    /**
     *Replenishes stock
     * @param name Name of medicine
     * @param quantity Amount to order
     */
    public void Restock(String name, int quantity)
    {
        for (int i = 0; i < medicineList.size(); i++) {
            if (name.equals(medicineList.get(i).getName())) {
                medicineList.get(i).IncreaseQuantity(quantity);
                JOptionPane.showMessageDialog(null, "Medicine Ordered: \n " + medicineList.get(i).getName() + " x" + quantity);
                break;
            }
        }
    }
    
    /**
     *Returns list of all medicines
     * @return String List of medicine names
     */
    public ArrayList<String> getNames()
    {
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < medicineList.size(); i++) {
            list.add(medicineList.get(i).getName());
        }
        return list;
    }
    
    /**
     *Returns the amount of stock of a given medicine
     * @return Integer stock remaining
     */
    public ArrayList<Integer> getStock()
    {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < medicineList.size(); i++) {
            list.add(medicineList.get(i).getStock());
        }
        return list;
    }
}
