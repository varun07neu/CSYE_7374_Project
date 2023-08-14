package edu.neu.csye7374;

import edu.neu.csye7374.adapter.*;
import edu.neu.csye7374.builder.DineInOrderBuilder;
import edu.neu.csye7374.builder.Order;
import edu.neu.csye7374.builder.OrderBuilder;
import edu.neu.csye7374.command.CookDishCommand;
import edu.neu.csye7374.command.KitchenCommandAPI;
import edu.neu.csye7374.command.ServeDishCommand;
import edu.neu.csye7374.builder.TakeAwayOrderBuilder;
import edu.neu.csye7374.observer.ChefObserver;
import edu.neu.csye7374.observer.KitchenObserver;
import edu.neu.csye7374.observer.ObservableAPI;
import edu.neu.csye7374.observer.RestaurantObservable;
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
import edu.neu.csye7374.state.RestaurantDelivery;
import edu.neu.csye7374.strategypattern.*;
import edu.neu.csye7374.singleton.OrderManager;
import edu.neu.csye7374.singleton.OrderManagerAPI;
import edu.neu.csye7374.strategypattern.CreditCardPaymentStrategy;
import edu.neu.csye7374.templatepattern.DineIn_Invoice;
import edu.neu.csye7374.templatepattern.OrderInvoice_Template;
import edu.neu.csye7374.templatepattern.Takeout_Invoice;

import java.util.ArrayList;
import java.util.List;

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
        System.out.println();

        System.out.println("------- DEMONSTRATE COMPOSITE PATTERN -------");
        MenuItem lunchSection = new LunchSection();
        lunchSection.addMenuItem(lunch1);
        lunchSection.addMenuItem(lunch2);
        lunchSection.addMenuItem(lunch3);
        lunchSection.describe();
        MenuItem dinnerSection = new DinnerSection();
        dinnerSection.addMenuItem(dinner1);
        dinnerSection.addMenuItem(dinner2);
        dinnerSection.addMenuItem(dinner3);
        dinnerSection.describe();
        System.out.println();

        System.out.println("------- DEMONSTRATE SINGLETON PATTERN -------");
        OrderManagerAPI orderManagerAPI = OrderManager.getInstance();
        System.out.println("Created a SINGLE INSTANCE of " + OrderManagerAPI.class + "\n");


        System.out.println("****************************** CREATING DINE IN LUNCH ORDER FOR JOHN ******************************");
        System.out.println("------- DEMONSTRATE BUILDER PATTERN & DECORATOR PATTERN -------");
        OrderBuilder dineInOrderBuilderJohn = new DineInOrderBuilder();
        System.out.println("Start BUILDING of Order for JOHN");
        dineInOrderBuilderJohn.addCustomerName("JOHN");
        MenuItem johnMenuItem1 = (MenuItem) MenuRegistry.getMenuItem(1);
        DishAPI johnDish;
        System.out.println("DECORATE Item 1 of Order for JOHN");
        johnDish = johnMenuItem1.getDish();
        johnDish = new ExtraProteinDecorator(johnDish);
        johnDish = new ExtraRiceDecorator(johnDish);
        johnDish = new ExtraSpicyDecorator(johnDish);
        johnMenuItem1.setDish(johnDish);
        dineInOrderBuilderJohn.addMenuItems(johnMenuItem1);

        MenuItem johnMenuItem2 = (MenuItem) MenuRegistry.getMenuItem(2);
        dineInOrderBuilderJohn.addMenuItems(johnMenuItem2);

        Order johnOrder = dineInOrderBuilderJohn.build();
        System.out.println("Order BUILT for JOHN");
        System.out.println(johnOrder + "\n");

        System.out.println("------- DEMONSTRATE OBSERVER PATTERN -------");
        //Notify kitchen and chefs
        //Creating observers
        ObservableAPI restaurantObservable = new RestaurantObservable();
        KitchenObserver kitchenObserver = new KitchenObserver();
        ChefObserver chefObserver = new ChefObserver();
        restaurantObservable.addObserver(kitchenObserver);
        restaurantObservable.addObserver(chefObserver);
        restaurantObservable.setData(RestaurantObservable.getMessageForOrder(johnOrder));
        restaurantObservable.notifyAllObservers();
        System.out.println();

        System.out.println("------- DEMONSTRATE COMMAND & ABSTRACT FACTORY METHOD PATTERN -------");

        KitchenCommandAPI kitchenCommandAPI = new CookDishCommand(johnMenuItem1.getDish());
        kitchenCommandAPI.exec();

        kitchenCommandAPI = new CookDishCommand(johnMenuItem2.getDish());
        kitchenCommandAPI.exec();

        kitchenCommandAPI = new ServeDishCommand(johnMenuItem1.getDish());
        kitchenCommandAPI.exec();

        kitchenCommandAPI = new ServeDishCommand(johnMenuItem2.getDish());
        kitchenCommandAPI.exec();

        System.out.println("------- DEMONSTRATE TEMPLATE PATTERN -------");
        OrderInvoice_Template orderInvoiceTemplate = new DineIn_Invoice();
        orderInvoiceTemplate.generateInvoice(johnOrder);
        System.out.println();

        System.out.println("------- DEMONSTRATE STRATEGY PATTERN -------");
        johnOrder.setPaymentStrategy(new CreditCardPaymentStrategy(100, 10, "JOHN"));
        johnOrder.getPaymentStrategy().processPayment(orderInvoiceTemplate.getTotal());
        System.out.println();

        System.out.println("------- DEMONSTRATE ADAPTER PATTERN -------");
        InHouseDelivery inHouseDelivery = new InHouseDeliveryImpl();
        inHouseDelivery.startDelivery(johnOrder);
        inHouseDelivery.deliver(johnOrder);
        System.out.println();

        orderManagerAPI.addNewOrder(johnOrder);

        System.out.println("------- DEMONSTRATE STATE PATTERN -------");

        System.out.println("Normal Transition of state from creation of order to placing it: ");
        RestaurantDelivery restaurantDelivery = new RestaurantDelivery();
        OrderBuilder takeAwayOrderBuilder1 = new TakeAwayOrderBuilder();
        takeAwayOrderBuilder1.addMenuItems(MenuRegistry.getMenuItem(4));
        takeAwayOrderBuilder1.addMenuItems(MenuRegistry.getMenuItem(5));
        takeAwayOrderBuilder1.addCustomerName("Varun");
        takeAwayOrderBuilder1.addDeliveryAddress("Northeastern University Huntington Avenue");
        Order takeawayOrder1 = takeAwayOrderBuilder1.build();
        Takeout_Invoice invoice = new Takeout_Invoice();
        invoice.generateInvoice(takeawayOrder1);
        restaurantDelivery.getCurrentState().selectTakeoutitems(takeawayOrder1.getMenuItems());
        PaymentStrategy strategy = new OnlinePaymentStrategy(50,2.0,"Apple Pay");
        restaurantDelivery.getCurrentState().selectPaymentMethod(strategy);
        restaurantDelivery.setOrderTotal(invoice.getTotal());
        restaurantDelivery.getCurrentState().placeOrder();

       //Notify kitchen and chefs
        restaurantObservable.setData(RestaurantObservable.getMessageForOrder(takeawayOrder1));
        restaurantObservable.notifyAllObservers();
        System.out.println();

        System.out.println("****************************** CREATING TAKEOUT DINNER ORDER FOR MARK ******************************");
        System.out.println("------- DEMONSTRATE BUILDER PATTERN & DECORATOR PATTERN -------");
        OrderBuilder takeAwayOrderBuilderMark = new TakeAwayOrderBuilder();
        System.out.println("Start BUILDING of Order for MARK");
        takeAwayOrderBuilderMark.addCustomerName("MARK");
        takeAwayOrderBuilderMark.addDeliveryAddress("Northeastern University, Huntington Avenue");
        MenuItem markMenuItem1 = (MenuItem) MenuRegistry.getMenuItem(4);
        DishAPI markDish;
        System.out.println("DECORATE Item 1 of Order for MARK");
        markDish = markMenuItem1.getDish();
        markDish = new ExtraProteinDecorator(markDish);
        markDish = new ExtraRiceDecorator(markDish);
        markMenuItem1.setDish(markDish);
        takeAwayOrderBuilderMark.addMenuItems(markMenuItem1);

        MenuItem markMenuItem2 = (MenuItem) MenuRegistry.getMenuItem(5);
        takeAwayOrderBuilderMark.addMenuItems(markMenuItem2);

        Order markOrder = takeAwayOrderBuilderMark.build();
        System.out.println("Order BUILT for MARK");
                System.out.println(markOrder + "\n");

        System.out.println("------- DEMONSTRATE OBSERVER PATTERN -------");
        //Notify kitchen and chefs
        restaurantObservable.setData(RestaurantObservable.getMessageForOrder(markOrder));
        restaurantObservable.notifyAllObservers();
        System.out.println();

        System.out.println("------- DEMONSTRATE COMMAND & ABSTRACT FACTORY METHOD PATTERN -------");

        kitchenCommandAPI = new CookDishCommand(markMenuItem1.getDish());
        kitchenCommandAPI.exec();

        kitchenCommandAPI = new CookDishCommand(markMenuItem2.getDish());
        kitchenCommandAPI.exec();

        kitchenCommandAPI = new ServeDishCommand(markMenuItem1.getDish());
        kitchenCommandAPI.exec();

        kitchenCommandAPI = new ServeDishCommand(markMenuItem2.getDish());
        kitchenCommandAPI.exec();

        System.out.println("------- DEMONSTRATE TEMPLATE PATTERN -------");
        orderInvoiceTemplate = new Takeout_Invoice();
        orderInvoiceTemplate.generateInvoice(markOrder);
        System.out.println();

        System.out.println("------- DEMONSTRATE STRATEGY PATTERN -------");
        markOrder.setPaymentStrategy(new CashPaymentStrategy(100, 10));
        markOrder.getPaymentStrategy().processPayment(orderInvoiceTemplate.getTotal());
        System.out.println();

        System.out.println("------- DEMONSTRATE ADAPTER PATTERN -------");
        inHouseDelivery = new DeliveryAdapter(new DoorDashDeliveryImpl());
        inHouseDelivery.startDelivery(markOrder);
        inHouseDelivery.deliver(markOrder);
        System.out.println();

        //Case 2: Uncomment if needed
//        System.out.println("Unsupported Transition of state from selecting order to placing it without payment: ");
//        RestaurantDelivery restaurantDelivery2 = new RestaurantDelivery();
//        OrderBuilder takeAwayOrderBuilder2 = new TakeAwayOrderBuilder();
//        takeAwayOrderBuilder2.addMenuItems(MenuRegistry.getMenuItem(1));
//        takeAwayOrderBuilder2.addMenuItems(MenuRegistry.getMenuItem(2));
//        takeAwayOrderBuilder2.addMenuItems(MenuRegistry.getMenuItem(3));
//        takeAwayOrderBuilder2.addCustomerName("Dan");
//        takeAwayOrderBuilder2.addDeliveryAddress("Northeastern University Huntington Avenue");
//        Order takeawayOrder2 = takeAwayOrderBuilder2.build();
//        Takeout_Invoice invoice2 = new Takeout_Invoice();
//        invoice2.generateInvoice(takeawayOrder2);
//        restaurantDelivery2.setOrderTotal(invoice2.getTotal());
//        restaurantDelivery2.getCurrentState().placeOrder();
//        restaurantDelivery2.getCurrentState().selectTakeoutitems(takeawayOrder2.getMenuItems());
//        PaymentStrategy strat2 = new CreditCardPaymentStrategy(30.0,2.0,"Chase");
//        restaurantDelivery2.getCurrentState().placeOrder();
//        restaurantDelivery2.getCurrentState().selectPaymentMethod(strat2);
//        restaurantDelivery2.getCurrentState().placeOrder();
//        invoice.generateInvoice(takeawayOrder2);
//        System.out.println();


        System.out.println("\n\n============Main Execution End===================");

    }
}
