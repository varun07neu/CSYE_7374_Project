package edu.neu.csye7374.adapter;

import edu.neu.csye7374.builder.Order;

public interface DoorDashDelivery {

    public void initializeDelivery(Order order);

    public void doDelivery(Order order);

}
