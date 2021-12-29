package com.bridgelabz.cabinvoice;

import com.bridgelabz.model.Ride;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CabInvoiceGeneratorTest {
    CabInvoiceGenerator cabInvoiceGenerator;

    @Before
    public void setUp() {
        cabInvoiceGenerator = new CabInvoiceGenerator();
    }

    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare() {
        double distance = 2.0;
        int time = 5;
        double totalFare = cabInvoiceGenerator.calculateFare(distance, time);
        Assert.assertEquals(25.0, totalFare, 0.0);
    }

    @Test
    public void givenLessDistanceAndTime_ShouldReturnMinFare() {
        cabInvoiceGenerator = new CabInvoiceGenerator();
        double distance = 0.1;
        int time = 1;
        double totalFare = cabInvoiceGenerator.calculateFare(distance, time);
        Assert.assertEquals(5.0, totalFare, 0);
    }

    @Test
    public void givenMultipleRides_ShouldReturnInvoiceSummary() {
        Ride[] rides={ new Ride(2.0,5),
                new Ride(0.1,1)
        };
        InvoiceSummary invoiceSummary = cabInvoiceGenerator.calculateFare(rides);
        InvoiceSummary expectedInvoice=new InvoiceSummary(2,30.0);
        Assert.assertEquals(invoiceSummary,expectedInvoice);
    }

    @Test
    public void givenUserId_ShouldReturnInvoiceSummary() {
        InvoiceSummary invoiceSummary = cabInvoiceGenerator.getInvoice(3);
        InvoiceSummary expectedInvoiceSummery = new InvoiceSummary(2, 30);
        Assert.assertEquals(expectedInvoiceSummery.getInvoiceSummary(), invoiceSummary.getInvoiceSummary());
    }
}