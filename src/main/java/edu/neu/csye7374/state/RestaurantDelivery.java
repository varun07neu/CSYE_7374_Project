package edu.neu.csye7374.state;

import edu.neu.csye7374.factory.DishAPI;
import edu.neu.csye7374.strategypattern.PaymentStrategy;

import java.util.List;

public class RestaurantDelivery implements RestaurantTakeoutStateAPI{

    public List<DishAPI> dishes;
    public PaymentStrategy strategy;
    public double orderTotal;

    public RestaurantTakeoutStateAPI resSelectItems;
    public RestaurantTakeoutStateAPI resSelectPayment;
    public RestaurantTakeoutStateAPI resPlaceOrder;
    public RestaurantTakeoutStateAPI resCancel;
    public RestaurantTakeoutStateAPI currentState;

    public RestaurantDelivery(){
        this.currentState = new SelectItemsState(this);
        this.resSelectItems = new SelectItemsState(this);
        this.resSelectPayment = new SelectPaymentMethodState(this);
        this.resPlaceOrder = new PlaceOrderState(this);
        this.resCancel = new CancelState(this);
    }

    public List<DishAPI> getDishes() {
        return dishes;
    }

    public void setDishes(List<DishAPI> dishes) {
        this.dishes = dishes;
    }

    public RestaurantTakeoutStateAPI getResSelectItems() {
        return resSelectItems;
    }

    public void setStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void setResSelectItems(RestaurantTakeoutStateAPI resSelectItems) {
        this.resSelectItems = resSelectItems;
    }

    public RestaurantTakeoutStateAPI getResSelectPayment() {
        return resSelectPayment;
    }

    public void setResSelectPayment(RestaurantTakeoutStateAPI resSelectPayment) {
        this.resSelectPayment = resSelectPayment;
    }

    public RestaurantTakeoutStateAPI getResPlaceOrder() {
        return resPlaceOrder;
    }

    public void setResPlaceOrder(RestaurantTakeoutStateAPI resPlaceOrder) {
        this.resPlaceOrder = resPlaceOrder;
    }


    public RestaurantTakeoutStateAPI getResCancel() {
        return resCancel;
    }

    public void setResCancel(RestaurantTakeoutStateAPI resCancel) {
        this.resCancel = resCancel;
    }

    public RestaurantTakeoutStateAPI getCurrentState() {
        return currentState;
    }

    public void setCurrentState(RestaurantTakeoutStateAPI currentState) {
        this.currentState = currentState;
    }

    public PaymentStrategy getStrategy() {
        return strategy;
    }

    public double getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(double orderTotal) {
        this.orderTotal = orderTotal;
    }

    @Override
    public void selectTakeoutitems(List<DishAPI> dishes) {
        this.currentState.selectTakeoutitems(dishes);
    }

    @Override
    public void selectPaymentMethod(PaymentStrategy strat) {
        this.currentState.selectPaymentMethod(strat);
    }

    @Override
    public void placeOrder() {
        this.currentState.placeOrder();
    }


    @Override
    public void cancelOrder() {
        this.currentState.cancelOrder();
    }
}
