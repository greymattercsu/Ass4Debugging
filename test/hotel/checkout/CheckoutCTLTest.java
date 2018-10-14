/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.checkout;

import hotel.HotelHelper;
import hotel.entities.Hotel;
import hotel.entities.ServiceType;
import hotel.service.RecordServiceCTL;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Meinong
 */
public class CheckoutCTLTest {

    private Object outContent;

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

        int roomId = 201;
        double total = 7.00;
        Hotel hotel = HotelHelper.loadHotel();
        CheckoutCTL instance = new CheckoutCTL(hotel);
        instance.roomIdEntered(roomId);
        String actualString = outContent.toString();
        String actualTotalString = actualString.substring(actualString.indexOf("Total")+ 8);
        double actualTotal = Double.parseDouble(actualTotalString);
        assertEquals(total, actualTotal, 0);
       


    }
    
   /**
     * Test of roomIdEntered method, of class CheckoutCTL.
     */
   @Test
   public void testCheckOutAndChargeRoom() throws Exception {
       int roomId = 201;
        double costRestaurant = 50.00;
        double costRoomService = 50.00;
        double total = costRestaurant + costRoomService;
        Hotel hotel = HotelHelper.loadHotel();
        RecordServiceCTL recordService = new RecordServiceCTL(hotel);
        recordService.roomNumberEntered(roomId);
        recordService.serviceDetailsEntered(ServiceType.RESTAURANT, costRestaurant);
        
        CheckoutCTL instance = new CheckoutCTL(hotel);
        instance.roomIdEntered(roomId);
        String actualString = outContent.toString();
        String actualTotalString = actualString.substring(actualString.indexOf("Total")+ 8);
        double actualTotal = Double.parseDouble(actualTotalString);
        assertEquals(total, actualTotal, 0);

   }


}
