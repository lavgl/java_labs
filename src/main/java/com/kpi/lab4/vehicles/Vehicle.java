package com.kpi.lab4.vehicles;

import com.kpi.lab4.passengers.Passenger;

import java.util.HashSet;
import java.util.Set;

public abstract class Vehicle<P extends Passenger> {
    Set<P> passengers;

    Vehicle() {
        this.passengers = new HashSet<P>();
    }

    public abstract int getMaxPassengersNumber();

    public int getCurrentPassengersNumber() {
        return this.passengers.size();
    }

    public boolean hasFreeSeats() {
        return this.getCurrentPassengersNumber() < this.getMaxPassengersNumber();
    }

    public void embarkPassenger(P passenger) throws Exception {
        if (this.hasFreeSeats()) {
            this.passengers.add(passenger);
        } else {
            throw new Exception("No free seats");
        }
    }

    public void disembarkPassenger(P passenger) throws Exception {
        if (this.passengers.contains(passenger)) {
            this.passengers.remove(passenger);
        } else {
            throw new Exception("No such passenger");
        }
    }
}
