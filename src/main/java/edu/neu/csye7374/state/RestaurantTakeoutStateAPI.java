package edu.neu.csye7374.state;

import edu.neu.csye7374.factory.DishAPI;
import edu.neu.csye7374.strategypattern.PaymentStrategy;

import java.util.List;

public interface RestaurantTakeoutStateAPI {
    void selectTakeoutitems(List<DishAPI> dishes);
    void selectPaymentMethod(PaymentStrategy strat);
    void placeOrder();
    void deliverOrder();
    void cancelOrder();
}
