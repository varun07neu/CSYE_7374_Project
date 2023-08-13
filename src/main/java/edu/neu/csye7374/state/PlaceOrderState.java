package edu.neu.csye7374.state;

import edu.neu.csye7374.prototypepattern.MenuItem;
import edu.neu.csye7374.strategypattern.PaymentStrategy;

import java.util.List;

public class PlaceOrderState implements RestaurantTakeoutStateAPI{
    public RestaurantDelivery res;

    public PlaceOrderState(RestaurantDelivery res){
        this.res = res;
    }

    @Override
    public void selectTakeoutitems(List<MenuItem> dishes) {
       System.out.println("Order has been placed, please cancel the order if you would like to change it");
    }

    @Override
    public void selectPaymentMethod(PaymentStrategy strat) {
        System.out.println("Order placed");
    }

    @Override
    public void placeOrder() {
        System.out.println("Order placed");
    }


    @Override
    public void cancelOrder() {
        res.setCurrentState(res.getResCancel());
        System.out.println("Cancelling your order");
        res.setDishes(null);

    }
}
