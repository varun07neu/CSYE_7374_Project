package edu.neu.csye7374;

import edu.neu.csye7374.adapter.DeliveryAdapter;
import edu.neu.csye7374.adapter.DoorDashDelivery;
import edu.neu.csye7374.adapter.DoorDashDeliveryImpl;
import edu.neu.csye7374.adapter.InHouseDelivery;
import edu.neu.csye7374.builder.DineInOrderBuilder;
import edu.neu.csye7374.builder.Order;
import edu.neu.csye7374.builder.OrderBuilder;
import edu.neu.csye7374.prototypepattern.MenuItem;
import edu.neu.csye7374.prototypepattern.MenuRegistry;

public class Driver {
    public static void main(String[] args) throws CloneNotSupportedException {
        System.out.println("============Main Execution Start===================\n\n");

        System.out.println("------- DEMONSTRATE PROTOTYPE PATTERN AND FACTORY METHOD PATTERN -------");
        MenuItem lunch1 = (MenuItem) MenuRegistry.getMenuItem(1);
        MenuItem lunch2 = (MenuItem) MenuRegistry.getMenuItem(2);
        MenuItem lunch3 = (MenuItem) MenuRegistry.getMenuItem(3);
        MenuItem dinner1 = (MenuItem) MenuRegistry.getMenuItem(4);
        MenuItem dinner2 = (MenuItem) MenuRegistry.getMenuItem(5);
        MenuItem dinner3 = (MenuItem) MenuRegistry.getMenuItem(6);
        lunch1.describe();
        lunch2.describe();
        lunch3.describe();
        dinner1.describe();
        dinner2.describe();
        dinner3.describe();

        OrderBuilder dineInOrderBuilder = new DineInOrderBuilder();
        dineInOrderBuilder.addMenuItems(lunch1);
        dineInOrderBuilder.addMenuItems(lunch2);
        dineInOrderBuilder.addCustomerName("Manoj");
        Order order = dineInOrderBuilder.build();
        System.out.println(order);

        DoorDashDelivery doorDashDelivery = new DoorDashDeliveryImpl();
        InHouseDelivery deliveryAdapter = new DeliveryAdapter(doorDashDelivery);

        deliveryAdapter.startDelivery(order);
        deliveryAdapter.deliver(order);

        System.out.println("\n\n============Main Execution End===================");
    }
}
