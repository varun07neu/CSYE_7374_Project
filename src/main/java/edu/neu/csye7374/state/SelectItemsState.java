package edu.neu.csye7374.state;

import edu.neu.csye7374.factory.DishAPI;
import edu.neu.csye7374.strategypattern.PaymentStrategy;

import java.util.List;

public class SelectItemsState implements RestaurantTakeoutStateAPI{
    public RestaurantDelivery res;

    public SelectItemsState(RestaurantDelivery res){
        this.res = res;
    }

    @Override
    public void selectTakeoutitems(List<DishAPI> dishes) {
        System.out.println("Here are your items: ");
        for (DishAPI dish :
                dishes) {
            System.out.println(dish.getName());
        }
        res.setCurrentState(res.getResSelectPayment());
    }

    @Override
    public void selectPaymentMethod(PaymentStrategy strat) {
        System.out.println("Choose items first ");

    }

    @Override
    public void placeOrder() {
        System.out.println("Choose items first");
    }


    @Override
    public void cancelOrder() {
        System.out.println("Cancelling your order");
        res.setDishes(null);
        res.setCurrentState(res.getResSelectItems());
    }
}
