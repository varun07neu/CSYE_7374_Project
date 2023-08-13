package edu.neu.csye7374.state;

import edu.neu.csye7374.factory.DishAPI;
import edu.neu.csye7374.strategypattern.PaymentStrategy;

import java.util.List;

public class CancelState implements RestaurantTakeoutStateAPI{
    public RestaurantDelivery res;

    public CancelState(RestaurantDelivery res){
        this.res = res;
    }

    @Override
    public void selectTakeoutitems(List<DishAPI> dishes) {
        res.setCurrentState(res.getResSelectItems());
        System.out.println("Here are your items: ");
        for (DishAPI dish :
                dishes) {
            System.out.println(dish.getName());
        }
        res.setCurrentState(res.getResSelectPayment());
    }

    @Override
    public void selectPaymentMethod(PaymentStrategy strat) {
        System.out.println("Order has been cancelled");
    }

    @Override
    public void placeOrder() {
        System.out.println("Order has been cancelled");
    }


    @Override
    public void cancelOrder() {
        System.out.println("Order has been cancelled");
        res.setCurrentState(res.getResSelectItems());
    }
}
