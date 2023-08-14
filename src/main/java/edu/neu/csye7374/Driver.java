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
import edu.neu.csye7374.strategypattern.CreditCardPaymentStrategy;
import edu.neu.csye7374.strategypattern.OnlinePaymentStrategy;
import edu.neu.csye7374.strategypattern.PaymentStrategy;
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

        //Creating observers
        ObservableAPI restaurantObservable = new RestaurantObservable();
        KitchenObserver kitchenObserver = new KitchenObserver();
        ChefObserver chefObserver = new ChefObserver();
        restaurantObservable.addObserver(kitchenObserver);
        restaurantObservable.addObserver(chefObserver);

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
        dineInOrderBuilderJohn.addMenuItems(johnMenuItem1);

        MenuItem johnMenuItem2 = (MenuItem) MenuRegistry.getMenuItem(2);
        dineInOrderBuilderJohn.addMenuItems(johnMenuItem2);

        Order johnOrder = dineInOrderBuilderJohn.build();
        System.out.println("----Order Placed for John-----");
        System.out.println(johnOrder);

        //Notify kitchen and chefs
        restaurantObservable.setData(RestaurantObservable.getMessageForOrder(johnOrder));
        restaurantObservable.notifyAllObservers();

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
