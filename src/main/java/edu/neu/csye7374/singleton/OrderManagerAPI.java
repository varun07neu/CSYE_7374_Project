package edu.neu.csye7374.singleton;

public interface OrderManagerAPI {
    void addNewOrder(OrderAPI order);
    void cancelOrder(OrderAPI order);
    List<OrderAPI> getOrderList();
    OrderAPI getOrder(int index);
}
