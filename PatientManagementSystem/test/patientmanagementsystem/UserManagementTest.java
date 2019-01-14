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
        Assert.assertNotNull("Test patient exists",test.getUserByID("P0000"));
    }

    @Test
    public void testCreateDoctor() {
        System.out.println("Testing Doctor Creation");
        test.CreateDoctor("pass", "David", "Hayter", "6 Street");
        Assert.assertNotNull("Test doctor exists",test.getUserByID("D0000"));
    }

    @Test
    public void testCreateAdmin() {
        System.out.println("Testing Admin Creation");
        test.CreateAdmin("pass", "Steven", "Armstrong", "9 Street");
        Assert.assertNotNull("Test admin exists",test.getUserByID("A0000"));
    }

    @Test
    public void testCreateSecretary() {
        System.out.println("Testing Secretary Creation");
        test.CreateSecretary("pass", "Kazuhira", "Miller", "1 Street");
        Assert.assertNotNull("Test secretary exists",test.getUserByID("S0000"));
    }

    @Test
    public void testRemoveID() {
    }

    @Test
    public void testLogIn() {
        System.out.println("Testing Log In");
        test.CreatePatient("Male", 33, "pass", "TEST", "MAN", "2 Street");        
        Assert.assertEquals(test.LogIn("P0000", "pass"), true);
    }

    @Test
    public void testGetCurrentUser() {
        System.out.println("Testing Get Current");
        test.CreatePatient("Male", 33, "pass", "TEST", "MAN", "2 Street");  
        test.LogIn("P0000", "pass");
        Assert.assertEquals(test.getCurrentUser().getSurName(), "MAN");
    }

    @Test
    public void testGetUserByID() {
        System.out.println("Testing Get By ID");
        test.CreatePatient("Male", 33, "pass", "TEST", "ONE", "2 Street");  
        test.CreateDoctor("pass", "TEST", "TWO", "2 Street");
        test.CreateSecretary("pass", "TEST", "THREE", "2 Street");
        Assert.assertEquals(test.getUserByID("D0001").getSurName(), "TWO");
    }
    
}
