package edu.neu.csye7374;

import edu.neu.csye7374.adapter.DeliveryAdapter;
import edu.neu.csye7374.adapter.DoorDashDelivery;
import edu.neu.csye7374.adapter.DoorDashDeliveryImpl;
import edu.neu.csye7374.adapter.InHouseDelivery;
import edu.neu.csye7374.builder.DineInOrderBuilder;
import edu.neu.csye7374.builder.Order;
import edu.neu.csye7374.builder.OrderBuilder;
import edu.neu.csye7374.builder.TakeAwayOrderBuilder;
import edu.neu.csye7374.prototypepattern.DinnerSection;
import edu.neu.csye7374.prototypepattern.LunchSection;
import edu.neu.csye7374.decoratorypattern.ExtraProteinDecorator;
import edu.neu.csye7374.decoratorypattern.ExtraRiceDecorator;
import edu.neu.csye7374.decoratorypattern.ExtraSpicyDecorator;
import edu.neu.csye7374.decoratorypattern.MildSpicyDecorator;
import edu.neu.csye7374.factory.DinnerDishFactory;
import edu.neu.csye7374.factory.DishAPI;
import edu.neu.csye7374.factory.LunchDishFactory;
import edu.neu.csye7374.prototypepattern.MenuItem;
import edu.neu.csye7374.prototypepattern.MenuRegistry;
import edu.neu.csye7374.templatepattern.DineIn_Invoice;
import edu.neu.csye7374.templatepattern.OrderInvoice_Template;
import edu.neu.csye7374.templatepattern.Takeout_Invoice;

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

        System.out.println("------- DEMONSTRATE BUILDER PATTERN AND TEMPLATE PATTERN-------");
        OrderBuilder dineInOrderBuilder = new DineInOrderBuilder();
        dineInOrderBuilder.addMenuItems(lunch1);
        dineInOrderBuilder.addMenuItems(lunch2);
        dineInOrderBuilder.addCustomerName("Manoj");
        Order order = dineInOrderBuilder.build();
        System.out.println(order);
        OrderInvoice_Template invoice = new DineIn_Invoice();
        invoice.generateInvoice(order);
        System.out.println();

        OrderBuilder takeAwayOrderBuilder = new TakeAwayOrderBuilder();
        takeAwayOrderBuilder.addMenuItems(dinner1);
        takeAwayOrderBuilder.addMenuItems(dinner2);
        takeAwayOrderBuilder.addCustomerName("Jason");
        takeAwayOrderBuilder.addDeliveryAddress("Northeastern University Huntington Avenue");
        order = takeAwayOrderBuilder.build();
        System.out.println(order);
        invoice = new Takeout_Invoice();
        invoice.generateInvoice(order);
        System.out.println();

        System.out.println("------- DEMONSTRATE ADAPTER PATTERN -------");
        DoorDashDelivery doorDashDelivery = new DoorDashDeliveryImpl();
        InHouseDelivery deliveryAdapter = new DeliveryAdapter(doorDashDelivery);

        deliveryAdapter.startDelivery(order);
        deliveryAdapter.deliver(order);

        System.out.println("------- DEMONSTRATE DECORATOR PATTERN -------");
        System.out.println("Created Lunch And Dinner Dishes: with decorator");
        DishAPI kungPao = LunchDishFactory.getInstance().createDish("Kung Pao", 17);
        DishAPI teriyakiRice = DinnerDishFactory.getInstance().createDish("Teriyaki Rice", 13);
        
        teriyakiRice = new ExtraRiceDecorator(teriyakiRice);
        teriyakiRice = new ExtraSpicyDecorator(teriyakiRice);
        teriyakiRice = new ExtraProteinDecorator(teriyakiRice);
        kungPao = new MildSpicyDecorator(kungPao);
        System.out.println(teriyakiRice);
        System.out.println(kungPao);

        System.out.println("\n\n============Main Execution End===================");
    }
}
