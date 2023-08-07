package edu.neu.csye7374.state;

import java.util.List;

public interface RestaurantTakeoutStateAPI {
    void selectTakeoutitems(List<DishAPI> dishes);
    void selectPaymentMethod(PaymentStrategy strat);
    void placeOrder();
    void deliverOrder();
    void cancelOrder();
}
