package edu.neu.csye7374.builder;

import edu.neu.csye7374.prototypepattern.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private List<MenuItem> menuItems = new ArrayList();

    private String deliveryAddress;

    private String customerName;

    public void removeMenuItems(MenuItem menuItem) {
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

    @Override
    public String toString() {
        return "Order{" +
                "menuItems=" + menuItems +
                ", deliveryAddress='" + deliveryAddress + '\'' +
                ", customerName='" + customerName + '\'' +
                '}';
    }
}
