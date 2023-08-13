package edu.neu.csye7374.state;

import edu.neu.csye7374.prototypepattern.MenuItem;
import edu.neu.csye7374.strategypattern.PaymentStrategy;

import java.util.List;

public interface RestaurantTakeoutStateAPI {
    void selectTakeoutitems(List<MenuItem> dishes);
    void selectPaymentMethod(PaymentStrategy strat);
    void placeOrder();
    void cancelOrder();
}
