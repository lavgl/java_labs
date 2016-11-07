package com.kpi.lab4;

import com.kpi.lab4.passengers.Firefighter;
import com.kpi.lab4.passengers.Passenger;
import com.kpi.lab4.passengers.Policeman;
import com.kpi.lab4.vehicles.FireTruck;
import com.kpi.lab4.vehicles.PoliceCar;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FireTruckTest {

    FireTruck truck;

    @Before
    public void init() {
        truck = new FireTruck();
    }

    @Test
    public void creationTest() {
        Assert.assertNotNull(truck);
    }

//    its ok because of generics type checking
//    @Test
//    public void testEmbarkPassenger() {
//        try {
//            truck.embarkPassenger(new Passenger());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

//    @Test
//    public void testEmbarkPoliceman() {
//        try {
//            truck.embarkPassenger(new Policeman());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    @Test
    public void testEmbarkFirefighter() {
        try {
            truck.embarkPassenger(new Firefighter());
            Assert.assertEquals(1, truck.getCurrentPassengersNumber());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
