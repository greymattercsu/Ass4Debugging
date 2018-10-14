/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.checkout;

import hotel.entities.Hotel;
import hotel.entities.ServiceType;
import hotel.service.RecordServiceCTL;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Meinong
 */
public class CheckoutCTLTest {

    public CheckoutCTLTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of roomIdEntered method, of class CheckoutCTL.
     */
    @Test
    public void testRoomIdEntered() throws Exception {


        System.out.println("Checking out after adding service");
        Hotel hotel = new Hotel();
        int roomId = 201;
        hotel.checkout(roomId);

        System.out.println("Service details for testing");
        ServiceType serviceType = ServiceType.ROOM_SERVICE;
        double cost = 50.0;

        RecordServiceCTL instance = new RecordServiceCTL(hotel);
        instance.roomNumberEntered(roomId);
        instance.serviceDetailsEntered(serviceType, cost);
        
        System.out.println("Total for room is 0.00");

    }

}
