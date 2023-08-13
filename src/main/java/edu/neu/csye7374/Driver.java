package edu.neu.csye7374;

import edu.neu.csye7374.builder.DineInOrderBuilder;
import edu.neu.csye7374.builder.Order;
import edu.neu.csye7374.builder.OrderBuilder;
import edu.neu.csye7374.prototypepattern.DinnerSection;
import edu.neu.csye7374.prototypepattern.LunchSection;
import edu.neu.csye7374.prototypepattern.MenuItem;
import edu.neu.csye7374.prototypepattern.MenuRegistry;

public class Driver {
    public static void main(String[] args) throws CloneNotSupportedException {
        System.out.println("============Main Execution Start===================\n\n");

        System.out.println("------- DEMONSTRATE PROTOTYPE PATTERN & FACTORY METHOD PATTERN -------");
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

        System.out.println("------- DEMONSTRATE COMPOSITE PATTERN -------");
        MenuItem lunchSection = new LunchSection();
        lunchSection.addMenuItem(lunch1);
        lunchSection.addMenuItem(lunch2);
        lunchSection.addMenuItem(lunch3);
        lunchSection.describe();
        MenuItem dinnerSection = new DinnerSection();
        dinnerSection.addMenuItem(lunch1);
        dinnerSection.addMenuItem(lunch2);
        dinnerSection.addMenuItem(lunch3);
        dinnerSection.describe();

        OrderBuilder dineInOrderBuilder = new DineInOrderBuilder();
        dineInOrderBuilder.addMenuItems(lunch1);
        dineInOrderBuilder.addMenuItems(lunch2);
        dineInOrderBuilder.addCustomerName("Manoj");
        Order order = dineInOrderBuilder.build();
        System.out.println(order);


        System.out.println("\n\n============Main Execution End===================");
    }
}
