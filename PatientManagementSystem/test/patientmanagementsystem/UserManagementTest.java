/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patientmanagementsystem;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Avebry
 */
public class UserManagementTest {
    
    UserManagement test;
    
    public UserManagementTest() {
        
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        test = new UserManagement();
        
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testUserCount() {
    }

    @Test
    public void testAddUser() {
    }

    @Test
    public void testCreatePatient() {
        System.out.println("Testing Patient Creation");
        test.CreatePatient("Male", 33, "pass", "Billy", "Herrington", "2 Street");
        Assert.assertNotNull("Test patient exists",test.getUserByID("P0"));
    }

    @Test
    public void testCreateDoctor() {
    }

    @Test
    public void testCreateAdmin() {
    }

    @Test
    public void testCreateSecretary() {
    }

    @Test
    public void testRemoveID() {
    }

    @Test
    public void testLogIn() {
        System.out.println("Testing Log In");
        test.CreatePatient("Male", 33, "pass", "Billy", "Herrington", "2 Street");
        test.LogIn("P0", "pass");
        Assert.assertEquals(test.getCurrentUser().getSurName(), "Herrington");
    }

    @Test
    public void testGetCurrentUser() {
    }

    @Test
    public void testGetUserByID() {
    }
    
}
