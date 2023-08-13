package edu.neu.csye7374.singleton;

import edu.neu.csye7374.builder.Order;

import java.util.List;

public interface OrderManagerAPI {
    void addNewOrder(Order order);
    void cancelOrder(Order order);
    List<Order> getOrderListFromManager();
    Order getOrder(int index);
}
