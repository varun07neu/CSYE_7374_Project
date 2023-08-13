package edu.neu.csye7374.state;

import edu.neu.csye7374.factory.DishAPI;
import edu.neu.csye7374.strategypattern.PaymentStrategy;

import java.util.List;

public class PlaceOrderState implements RestaurantTakeoutStateAPI{
    public RestaurantDelivery res;

    public PlaceOrderState(RestaurantDelivery res){
        this.res = res;
    }

    @Override
    public void selectTakeoutitems(List<DishAPI> dishes) {
       System.out.println("Order has been placed, please cancel the order if you would like to change it");
    }

    @Override
    public void selectPaymentMethod(PaymentStrategy strat) {
        res.setCurrentState(res.getResSelectPayment());
        System.out.println("Selected payment method "+strat);
        res.selectPaymentMethod(strat);
        res.setCurrentState(res.getResPlaceOrder());
    }

    @Override
    public void placeOrder() {
        System.out.println("Processing payment");
        res.getStrategy().processPayment(res.getOrderTotal());
        res.setCurrentState(res.getResSelectItems());
    }


    @Override
    public void cancelOrder() {
        System.out.println("Cancelling your order");
        res.setDishes(null);
        res.setCurrentState(res.getResCancel());
    }
}
