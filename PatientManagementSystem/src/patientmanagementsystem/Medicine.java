/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patientmanagementsystem;

/**
 *
 * @author Avebry
 */
public class Medicine {
    private int id;
    private String name;
    private Integer stock;

    public Medicine(int id, String name, Integer stock) {
        this.id = id;
        this.name = name;
        this.stock = stock;
    }

    

    
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public int getId() {
        return id;
    }
    
    public void ReduceQuantity(int amount)
    {
        stock -= amount;
    }
    
    public void IncreaseQuantity(int amount)
    {
        stock += amount;
    }
}
