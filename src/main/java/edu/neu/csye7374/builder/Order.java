package edu.neu.csye7374.builder;

import java.util.ArrayList;

public class Order {

    private List<MenuItem> menuItems = new ArrayList();

    private String deliveryAddress;

    private String customerName;

    public void removeMenuItems() {
        this.menuItems.remove(menuItem);
    }

    public void addMenuItems(MenuItem menuItem) {

        this.menuItems.add(menuItem);
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}
