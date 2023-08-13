package edu.neu.csye7374.adapter;

import edu.neu.csye7374.builder.Order;

import java.util.Date;

public class DoorDashDeliveryImpl implements DoorDashDelivery{


    @Override
    public void initializeDelivery(Order order) {

        System.out.println("Starting delivery with DoorDash for Customer "+ order.getCustomerName() + " Time : "+ new Date());
    }

    @Override
    public void doDelivery(Order order) {

        System.out.println("Delivered with DoorDash for Customer "+ order.getCustomerName() + " Time : "+ new Date());
    }
}
