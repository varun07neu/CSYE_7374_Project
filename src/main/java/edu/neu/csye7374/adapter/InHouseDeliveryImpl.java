package edu.neu.csye7374.adapter;

import edu.neu.csye7374.builder.Order;

import java.util.Date;

public class InHouseDeliveryImpl implements InHouseDelivery{

    @Override
    public void startDelivery(Order order) {
        System.out.println("Starting delivery with InHouse for Customer "+ order.getCustomerName() + " Time : "+ new Date());
    }

    @Override
    public void deliver(Order order) {

        System.out.println("Delivered with InHouse for Customer "+ order.getCustomerName() + " Time : "+ new Date());
    }
}
