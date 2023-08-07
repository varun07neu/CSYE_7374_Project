package edu.neu.csye7374.state;

import java.util.List;

public class SelectItemsState implements RestaurantTakeoutStateAPI{
    public RestaurantDelivery res;
    public List<DishAPI> items;

    public SelectItemsState(RestaurantDelivery res, List<DishAPI> dishes){
        this.res = res;
        this.items = dishes;
    }

    @Override
    public void selectTakeoutitems(List<DishAPI> dishes) {
        System.out.println("Here are your items: ");
        for (DishAPI dish :
                dishes) {
            System.out.println(dish.getName());
        }
    }

    @Override
    public void selectPaymentMethod(PaymentStrategy strat) {
        System.out.println("Selected payment method "+strat);
        //TODO: calculate total and use strategy
        res.setCurrentState(res.getResSelectPayment());
    }

    @Override
    public void placeOrder() {
        System.out.println("Choose payment method first");
    }

    @Override
    public void deliverOrder() {
        System.out.println("Choose payment method first and place your order");
    }

    @Override
    public void cancelOrder() {
        System.out.println("Cancelling your order");
        this.items = null;
        res.setDishes(null);
    }
}
