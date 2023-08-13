package edu.neu.csye7374.state;

import edu.neu.csye7374.prototypepattern.MenuItem;
import edu.neu.csye7374.strategypattern.PaymentStrategy;

import java.util.List;

public class SelectItemsState implements RestaurantTakeoutStateAPI{
    public RestaurantDelivery res;

    public SelectItemsState(RestaurantDelivery res){
        this.res = res;
    }

    @Override
    public void selectTakeoutitems(List<MenuItem> dishes) {
        System.out.println("Already in the menu ");
    }

    @Override
    public void selectPaymentMethod(PaymentStrategy strat) {
        res.setCurrentState(res.getResSelectPayment());
        res.setStrategy(strat);
        System.out.println("Choose Payment type ");
    }

    @Override
    public void placeOrder() {
        System.out.println("Choose items first");
    }


    @Override
    public void cancelOrder() {
        res.setCurrentState(res.getResSelectItems());
        System.out.println("Cancelling your order");
        res.setDishes(null);
    }
}
