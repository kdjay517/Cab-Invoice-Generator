package com.bridgelabz.cabinvoice;

import com.bridgelabz.model.Ride;

public class CabInvoiceGenerator {
    public static final double COST_PER_KM = 10;
    public static final int COST_PER_MIN = 1;
    public static final double MIN_Fare = 5.0;

    public double calculateFare(double distance, int time) {
        double totalFare = distance * COST_PER_KM + time * COST_PER_MIN;
        return Math.max(totalFare, MIN_Fare);
    }
    public double calculateFare(Ride[] rides) {
        double totalFare = 0.0;
        for (Ride ride : rides) {
            totalFare += calculateFare(ride.getDistance(), ride.getTime());
        }
        return totalFare;

    }
}