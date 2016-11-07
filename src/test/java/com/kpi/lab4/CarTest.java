package com.kpi.lab4;

import com.kpi.lab4.passengers.Firefighter;
import com.kpi.lab4.passengers.Passenger;
import com.kpi.lab4.passengers.Policeman;
import com.kpi.lab4.vehicles.Car;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CarTest {
    Car<Passenger> car;

    @Before
    public void init() {
        car = new Car<>();
    }

    @Test
    public void creationTest() {
        Assert.assertNotNull(car);
    }

    @Test
    public void testEmbarkPassenger() {
        try {
            car.embarkPassenger(new Passenger());
            Assert.assertEquals(1, car.getCurrentPassengersNumber());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testEmbarkFirefighter() {
        try {
            car.embarkPassenger(new Firefighter());
            Assert.assertEquals(1, car.getCurrentPassengersNumber());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testEmbarkPoliceman() {
        try {
            car.embarkPassenger(new Policeman());
            Assert.assertEquals(1, car.getCurrentPassengersNumber());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testMaxPassengers() {
        int i = 0;
        int max = car.getMaxPassengersNumber();
        try {
            for (i = 0; i < max + 1; i++) {
                car.embarkPassenger(new Passenger());
            }
        } catch (Exception e) {
            Assert.assertEquals(Exception.class, e.getClass());
            Assert.assertEquals(max, i);
        }
    }

    @Test
    public void testSuccessfulDisembarkPassenger() {
        Passenger passenger = new Passenger();
        try {
            car.embarkPassenger(passenger);
            Assert.assertEquals(1, car.getCurrentPassengersNumber());

            car.disembarkPassenger(passenger);
            Assert.assertEquals(0, car.getCurrentPassengersNumber());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testUnsuccessfulDisembarkPassenger() {
        try {
            car.embarkPassenger(new Passenger());
            car.disembarkPassenger(new Passenger());
        } catch (Exception e) {
            Assert.assertEquals(Exception.class, e.getClass());
        }
    }
}
