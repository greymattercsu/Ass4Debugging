/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.service;

import hotel.HotelHelper;
import hotel.checkout.CheckoutCTL;
import hotel.utils.IOUtils;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import hotel.entities.Hotel;
import hotel.entities.ServiceType;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Meinong
 */
public class RecordServiceCTLTest {

        private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    
    public RecordServiceCTLTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
                System.setOut(new PrintStream(outContent));

    }
    
    @After
    public void tearDown() {
    }

   

    /**
     * Test of roomNumberEntered method, of class RecordServiceCTL.
     * @throws java.lang.Exception
     */
    @Test
    public void testRoomNumberEntered() throws Exception {
        int roomNumber = 201;
        String expectedOutput = String.format("No active booking for room id: %d", roomNumber);
        Hotel hotel = HotelHelper.loadHotel();
        hotel.checkout(roomNumber);
        RecordServiceCTL instance = new RecordServiceCTL(hotel);
        instance.roomNumberEntered(roomNumber);
        String actualOutput = outContent.toString();
        assertTrue(actualOutput.contains(expectedOutput));
        
    }
    
    /**
     * Test of run method, of class RecordServiceCTL.
     * @throws java.lang.Exception
     */
    @Test
    public void testRoomNumberEnteredCheckout() throws Exception {
        int roomNumber = 201;
        String excpeted = String.format("No active booking for room id: %d", roomNumber);
        Hotel hotel = HotelHelper.loadHotel();
        hotel.checkout(roomNumber);
        RecordServiceCTL instance = new RecordServiceCTL(hotel);
        instance.roomNumberEntered(roomNumber);
        String actualOutput = outContent.toString();
        assertTrue(actualOutput.contains(excpeted));
    }
    
          /**
     * Test of run method, of class RecordServiceCTL.
     * @throws java.lang.Exception
     */
    @Test
    public void testRoomNumberEnteredCheckIn() throws Exception {
        int roomNumber = 201;
        double cost = 50.00;
        ServiceType serviceType = ServiceType.BAR_FRIDGE;
        String excpeted = String.format("Room %d charged $%.2f for %s", roomNumber, cost, serviceType.getDescription());
        
        Hotel hotel = HotelHelper.loadHotel();
        RecordServiceCTL instance = new RecordServiceCTL(hotel);
        instance.roomNumberEntered(roomNumber);
        instance.serviceDetailsEntered(serviceType, cost);
        String actualOutput = outContent.toString();
        
        assertTrue(actualOutput.contains(excpeted));
    }

    
    
}
