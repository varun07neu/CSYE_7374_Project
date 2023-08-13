package edu.neu.csye7374.builder;

import edu.neu.csye7374.prototypepattern.MenuItem;

public interface OrderBuilder {

    public void addMenuItems(MenuItem menuItem);

    public void addDeliveryAddress(String deliveryAddress);

    public void addCustomerName(String customerName);

    public Order build();
}
