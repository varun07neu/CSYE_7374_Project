package edu.neu.csye7374.builder;

import edu.neu.csye7374.builder.OrderBuilder;

public class DineInOrderBuilder implements OrderBuilder {

    private Order order;

    public DineInOrderBuilder() {
        this.order = new Order();
    }

    @Override
    public void addMenuItems(MenuItem menuItem) {
        order.addMenuItems(menuItem);
    }

    @Override
    public void addDeliveryAddress(String deliveryAddress) {
        order.setDeliveryAddress("IN HOUSE");
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
