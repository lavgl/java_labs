package com.kpi.lab4;

import com.kpi.lab4.passengers.Firefighter;
import com.kpi.lab4.passengers.Passenger;
import com.kpi.lab4.passengers.Policeman;
import com.kpi.lab4.vehicles.Bus;
import com.kpi.lab4.vehicles.Car;
import com.kpi.lab4.vehicles.FireTruck;
import com.kpi.lab4.vehicles.PoliceCar;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.omg.PortableInterceptor.Interceptor;

public class RoadTest {
    Road road;

    @Before
    public void init() {
        road = new Road();
    }

    @Test
    public void testAddCar() {
        road.addCarToRoad(new Car());

        Assert.assertEquals(1, road.carsInRoad.size());
    }

    @Test
    public void testCountHumans() {
        Car car1 = new Car();
        Car car2 = new Car();
        FireTruck car3 = new FireTruck();
        Car car4 = new PoliceCar();
        Bus car5 = new Bus();

        try {
            car1.embarkPassenger(new Passenger());
            car1.embarkPassenger(new Firefighter());
            car1.embarkPassenger(new Policeman());

            car2.embarkPassenger(new Passenger());
            car2.embarkPassenger(new Firefighter());
            car2.embarkPassenger(new Policeman());

            car3.embarkPassenger(new Firefighter());
            car4.embarkPassenger(new Policeman());

            road.addCarToRoad(car1);
            road.addCarToRoad(car2);
            road.addCarToRoad(car3);
            road.addCarToRoad(car4);
            road.addCarToRoad(car5);

            int count = road.getCountOfHumans();

            Assert.assertEquals(8, count);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
