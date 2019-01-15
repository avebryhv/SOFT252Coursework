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
public class Doctor extends User{
    private ArrayList<String> reviewList;

    public Doctor(String id, String password, String givenName, String surName, String address) {
        super(id, password, givenName, surName, address);
        reviewList = new ArrayList<String>();
    }

    public void AddReview(String review)
    {
        reviewList.add(review);
    }

    public ArrayList<String> getReviewList() {
        return reviewList;
    }
    
    
    
}
