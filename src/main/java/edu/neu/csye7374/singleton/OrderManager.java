package edu.neu.csye7374.singleton;

import java.util.ArrayList;
import java.util.List;

public class OrderManager implements OrderManagerAPI{

    private List<OrderAPI> orderList = new ArrayList<OrderAPI>();

    private static OrderManager instance = new OrderManager();

    private OrderManager() {}

    static synchronized OrderManager getInstance() {
        if (instance == null) {
            instance = new OrderManager();
        }
        return instance;
    }

    @Override
    public void addNewOrder(OrderAPI order) {
        this.orderList.add(order);
        System.out.println("Order added successfully: "+order);
    }

    @Override
    public void cancelOrder(OrderAPI order) {
        this.orderList.remove(order);
        System.out.println("Order removed successfully: "+order);
    }

    @Override
    public List<OrderAPI> getOrderList() {
        return this.orderList;
    }

    @Override
    public OrderAPI getOrder(int index) {
        return this.orderList.get(index);
    }

}
