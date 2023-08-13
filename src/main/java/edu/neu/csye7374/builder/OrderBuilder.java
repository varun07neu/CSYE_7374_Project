package edu.neu.csye7374.builder;

public interface OrderBuilder {

    public void addMenuItems(MenuItem menuItem);

    public void addDeliveryAddress(String deliveryAddress);

    public void addCustomerName(String customerName);

    public Order build();
}
