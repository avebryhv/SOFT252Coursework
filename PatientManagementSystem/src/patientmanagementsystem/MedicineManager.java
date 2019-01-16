/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patientmanagementsystem;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Avebry
 */
public class MedicineManager {
    
    private static MedicineManager uniqueInstance = null;
    private ArrayList<Medicine> medicineList;

    public MedicineManager() {
        medicineList = new ArrayList<Medicine>();
    }
    
    public static MedicineManager getInstance()
    {
        if (uniqueInstance == null){      
    	uniqueInstance = new MedicineManager(); 
        }
   	return uniqueInstance;
    }
    
    public void CreateMedicine(String name, int quantity)
    {
        int id = medicineList.size();
        Medicine m = new Medicine(id, name, quantity);
        AddMedicine(m);
    }
    
    public void AddMedicine(Medicine m)
    {
        medicineList.add(m);
    }
    
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
    
    public ArrayList<String> getNames()
    {
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < medicineList.size(); i++) {
            list.add(medicineList.get(i).getName());
        }
        return list;
    }
    
    public ArrayList<Integer> getStock()
    {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < medicineList.size(); i++) {
            list.add(medicineList.get(i).getStock());
        }
        return list;
    }
}
