package edu.neu.csye7374.singleton;

import edu.neu.csye7374.builder.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderManager implements OrderManagerAPI{

    private List<Order> orderList = new ArrayList<>();

    private static OrderManager instance = new OrderManager();

    private OrderManager() {}

    public static synchronized OrderManager getInstance() {
        if (instance == null) {
            instance = new OrderManager();
        }
        return instance;
    }

    @Override
    public void addNewOrder(Order order) {
        this.orderList.add(order);
        System.out.println("Order added successfully: "+order);
    }

    @Override
    public void cancelOrder(Order order) {
        this.orderList.remove(order);
        System.out.println("Order removed successfully: "+order);
    }

    @Override
    public List<Order> getOrderListFromManager() {
        return this.orderList;
    }

    @Override
    public Order getOrder(int index) {
        return this.orderList.get(index);
    }

}
