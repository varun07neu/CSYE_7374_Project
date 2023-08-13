package edu.neu.csye7374.builder;

import edu.neu.csye7374.builder.OrderBuilder;
import edu.neu.csye7374.prototypepattern.MenuItem;

public class TakeAwayOrderBuilder implements OrderBuilder {


    private Order order;

    public TakeAwayOrderBuilder() {
        this.order = new Order();
    }

    @Override
    public void addMenuItems(MenuItem menuItem) {
        order.addMenuItems(menuItem);
    }

    @Override
    public void addDeliveryAddress(String deliveryAddress) {
        order.setDeliveryAddress(deliveryAddress);
    }

    @Override
    public void addCustomerName(String customerName) {
        order.setCustomerName(customerName);
    }

    @Override
    public Order build() {
        return order;
    }
}
