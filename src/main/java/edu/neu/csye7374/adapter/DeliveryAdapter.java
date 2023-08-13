package edu.neu.csye7374.adapter;

import edu.neu.csye7374.builder.Order;

public class DeliveryAdapter implements InHouseDelivery{

    private DoorDashDelivery doorDashDelivery;

    public DeliveryAdapter(DoorDashDelivery doorDashDelivery) {
        this.doorDashDelivery = doorDashDelivery;
    }

    @Override
    public void startDelivery(Order order) {

        System.out.println("Adapting InHouse to use DoorDash for Delivery");
        doorDashDelivery.initializeDelivery(order);
    }

    @Override
    public void deliver(Order order) {
        System.out.println("Adapted InHouse to use DoorDash for Delivery");
        doorDashDelivery.doDelivery(order);
    }
}
