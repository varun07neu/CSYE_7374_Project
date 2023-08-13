package edu.neu.csye7374.state;

import edu.neu.csye7374.factory.DishAPI;
import edu.neu.csye7374.strategypattern.PaymentStrategy;

import java.util.List;

public class SelectPaymentMethodState implements RestaurantTakeoutStateAPI{
    public RestaurantDelivery res;

    public SelectPaymentMethodState(RestaurantDelivery res){
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
        res.setDishes(dishes);
        res.setCurrentState(res.getResSelectPayment());
    }

    @Override
    public void selectPaymentMethod(PaymentStrategy strat) {
        System.out.println("Selected payment method "+strat);
        res.selectPaymentMethod(strat);
        res.setCurrentState(res.getResPlaceOrder());
    }

    @Override
    public void placeOrder() {
        System.out.println("Choose payment method first");
    }


    @Override
    public void cancelOrder() {
        System.out.println("Cancelling your order");
        res.setDishes(null);
        res.setCurrentState(res.getResCancel());
    }
}
