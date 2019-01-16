/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Serialiser;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author ahoughton-vowles
 */
public class Serialiser {
    private String name;

    public Serialiser(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
    
    public Serializable readObject(){
        Serializable loadedObject = null;
        try {
         FileInputStream fileIn = new FileInputStream(name);
         ObjectInputStream in = new ObjectInputStream(fileIn);
         loadedObject = (Serializable) in.readObject();
         in.close();
         fileIn.close();
         System.out.println("Data loaded from: "+ name);
        } catch (IOException i) {
            System.out.println("File not found.");
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Class not found");
            c.printStackTrace();
        }
        return loadedObject;
    }
    
    public boolean writeObject(Serializable object){
        try {
            FileOutputStream fileOut = new FileOutputStream(name);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(object);
            out.close();
            fileOut.close();
            System.out.println("Serialized data is saved in: " + name);
            return true;
         } catch (IOException i) {
            System.out.println("Failed to load!");
            i.printStackTrace();
            return false;
         }
    }
}
