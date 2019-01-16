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

    /**
     *
     * @param id
     * @param name
     * @param stock
     */
    public Medicine(int id, String name, Integer stock) {
        this.id = id;
        this.name = name;
        this.stock = stock;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public Integer getStock() {
        return stock;
    }

    /**
     *
     * @param stock
     */
    public void setStock(Integer stock) {
        this.stock = stock;
    }

    /**
     *
     * @return
     */
    public int getId() {
        return id;
    }
    
    /**
     *
     * @param amount
     */
    public void ReduceQuantity(int amount)
    {
        stock -= amount;
    }
    
    /**
     *
     * @param amount
     */
    public void IncreaseQuantity(int amount)
    {
        stock += amount;
    }
}
