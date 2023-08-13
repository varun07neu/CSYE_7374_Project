package edu.neu.csye7374.adapter;

import edu.neu.csye7374.builder.Order;

public interface InHouseDelivery {

    public void startDelivery(Order order);

    public void deliver(Order order);

}
