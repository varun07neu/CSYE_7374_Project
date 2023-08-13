package edu.neu.csye7374.state;

import edu.neu.csye7374.prototypepattern.MenuItem;
import edu.neu.csye7374.strategypattern.PaymentStrategy;

import java.util.List;

public class CancelState implements RestaurantTakeoutStateAPI{
    public RestaurantDelivery res;

    public CancelState(RestaurantDelivery res){
        this.res = res;
    }

    @Override
    public void selectTakeoutitems(List<MenuItem> dishes) {
        res.setCurrentState(res.getResSelectItems());
        System.out.println("Here are your items: ");
        for (MenuItem dish :
                dishes) {
            System.out.println(dish);
        }
    }

    @Override
    public void selectPaymentMethod(PaymentStrategy strat) {
        System.out.println("Order has been cancelled");
    }

    @Override
    public void placeOrder() {
        System.out.println("Add items to your order first");
    }


    @Override
    public void cancelOrder() {
        System.out.println("Order has been cancelled");
        res.setDishes(null);
    }
}
