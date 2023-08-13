package edu.neu.csye7374.state;

import edu.neu.csye7374.prototypepattern.MenuItem;
import edu.neu.csye7374.strategypattern.PaymentStrategy;

import java.util.List;

public class SelectPaymentMethodState implements RestaurantTakeoutStateAPI{
    public RestaurantDelivery res;

    public SelectPaymentMethodState(RestaurantDelivery res){
        this.res = res;
    }

    @Override
    public void selectTakeoutitems(List<MenuItem> dishes) {
        System.out.println("Here are your items: ");
        for (MenuItem dish :
                res.getDishes()) {
            System.out.println(dish);
        }
        res.setDishes(dishes);
    }

    @Override
    public void selectPaymentMethod(PaymentStrategy strat) {
        System.out.println("Selected payment method "+strat);
    }

    @Override
    public void placeOrder() {
        res.setCurrentState(res.getResPlaceOrder());
        System.out.println("Order placed using:");
        res.getStrategy().processPayment(res.getOrderTotal());
    }


    @Override
    public void cancelOrder() {
        res.setCurrentState(res.getResCancel());
        System.out.println("Cancelling your order");
        res.setDishes(null);
    }
}
