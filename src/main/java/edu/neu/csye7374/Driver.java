package edu.neu.csye7374;

import edu.neu.csye7374.adapter.*;
import edu.neu.csye7374.builder.DineInOrderBuilder;
import edu.neu.csye7374.builder.Order;
import edu.neu.csye7374.builder.OrderBuilder;
import edu.neu.csye7374.command.CookDishCommand;
import edu.neu.csye7374.command.KitchenCommandAPI;
import edu.neu.csye7374.command.ServeDishCommand;
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
import edu.neu.csye7374.singleton.OrderManager;
import edu.neu.csye7374.singleton.OrderManagerAPI;
import edu.neu.csye7374.strategypattern.CreditCardPaymentStrategy;
import edu.neu.csye7374.templatepattern.DineIn_Invoice;
import edu.neu.csye7374.templatepattern.OrderInvoice_Template;

public class Driver {
    public static void main(String[] args) throws CloneNotSupportedException {
        System.out.println("============Main Execution Start===================\n\n");

//        System.out.println("------- DEMONSTRATE PROTOTYPE PATTERN & FACTORY METHOD PATTERN -------");
//        MenuItem lunch1 = (MenuItem) MenuRegistry.getMenuItem(1);
//        MenuItem lunch2 = (MenuItem) MenuRegistry.getMenuItem(2);
//        MenuItem lunch3 = (MenuItem) MenuRegistry.getMenuItem(3);
//        MenuItem dinner1 = (MenuItem) MenuRegistry.getMenuItem(4);
//        MenuItem dinner2 = (MenuItem) MenuRegistry.getMenuItem(5);
//        MenuItem dinner3 = (MenuItem) MenuRegistry.getMenuItem(6);
//        lunch1.describe();
//        lunch2.describe();
//        lunch3.describe();
//        dinner1.describe();
//        dinner2.describe();
//        dinner3.describe();
//
//        System.out.println("------- DEMONSTRATE COMPOSITE PATTERN -------");
//        MenuItem lunchSection = new LunchSection();
//        lunchSection.addMenuItem(lunch1);
//        lunchSection.addMenuItem(lunch2);
//        lunchSection.addMenuItem(lunch3);
//        lunchSection.describe();
//        MenuItem dinnerSection = new DinnerSection();
//        dinnerSection.addMenuItem(dinner1);
//        dinnerSection.addMenuItem(dinner2);
//        dinnerSection.addMenuItem(dinner3);
//        dinnerSection.describe();
//
//        OrderBuilder dineInOrderBuilder = new DineInOrderBuilder();
//        dineInOrderBuilder.addMenuItems(lunch1);
//        dineInOrderBuilder.addMenuItems(lunch2);
//        dineInOrderBuilder.addCustomerName("Manoj");
//        Order order = dineInOrderBuilder.build();
//        System.out.println(order);
//
//        DoorDashDelivery doorDashDelivery = new DoorDashDeliveryImpl();
//        InHouseDelivery deliveryAdapter = new DeliveryAdapter(doorDashDelivery);
//
//        deliveryAdapter.startDelivery(order);
//        deliveryAdapter.deliver(order);
//
//        System.out.println("Created Lunch And Dinner Dishes: with decorator");
//        DishAPI kungPao = LunchDishFactory.getInstance().createDish("Kung Pao", 17);
//        DishAPI teriyakiRice = DinnerDishFactory.getInstance().createDish("Teriyaki Rice", 13);
//
//        teriyakiRice = new ExtraRiceDecorator(teriyakiRice);
//        teriyakiRice = new ExtraSpicyDecorator(teriyakiRice);
//        teriyakiRice = new ExtraProteinDecorator(teriyakiRice);
//        kungPao = new MildSpicyDecorator(kungPao);
//        System.out.println(teriyakiRice);
//        System.out.println(kungPao);

        // Creating the order for JOHN
        OrderBuilder dineInOrderBuilderJohn = new DineInOrderBuilder();
        dineInOrderBuilderJohn.addCustomerName("JOHN");
        MenuItem johnMenuItem1 = (MenuItem) MenuRegistry.getMenuItem(1);
        DishAPI johnDish;
        johnDish = johnMenuItem1.getDish();
        johnDish = new ExtraProteinDecorator(johnDish);
        johnDish = new ExtraRiceDecorator(johnDish);
        johnDish = new ExtraSpicyDecorator(johnDish);
        johnMenuItem1.setDish(johnDish);
        System.out.println(johnDish);
        dineInOrderBuilderJohn.addMenuItems(johnMenuItem1);

        MenuItem johnMenuItem2 = (MenuItem) MenuRegistry.getMenuItem(2);
        dineInOrderBuilderJohn.addMenuItems(johnMenuItem2);

        Order johnOrder = dineInOrderBuilderJohn.build();

        //TODO OBSERVER

        KitchenCommandAPI kitchenCommandAPI = new CookDishCommand(johnMenuItem1.getDish());
        kitchenCommandAPI.exec();

        kitchenCommandAPI = new CookDishCommand(johnMenuItem2.getDish());
        kitchenCommandAPI.exec();

        kitchenCommandAPI = new ServeDishCommand(johnDish);
        kitchenCommandAPI.exec();

        kitchenCommandAPI = new ServeDishCommand(johnMenuItem2.getDish());
        kitchenCommandAPI.exec();

        OrderInvoice_Template orderInvoiceTemplate = new DineIn_Invoice();
        orderInvoiceTemplate.generateInvoice(johnOrder);

        johnOrder.setPaymentStrategy(new CreditCardPaymentStrategy(100, 10, "JOHN"));
        johnOrder.getPaymentStrategy().processPayment(orderInvoiceTemplate.getTotal());

        InHouseDelivery inHouseDelivery = new InHouseDeliveryImpl();
        inHouseDelivery.startDelivery(johnOrder);
        inHouseDelivery.deliver(johnOrder);

        OrderManagerAPI orderManagerAPI = OrderManager.getInstance();
        orderManagerAPI.addNewOrder(johnOrder);


        System.out.println("\n\n============Main Execution End===================");
    }
}
