package edu.neu.csye7374.state;

import edu.neu.csye7374.factory.DishAPI;
import edu.neu.csye7374.strategypattern.PaymentStrategy;

import java.util.List;

public class RestaurantDelivery implements RestaurantTakeoutStateAPI{

    List<DishAPI> dishes;

    public RestaurantTakeoutStateAPI resSelectItems;
    public RestaurantTakeoutStateAPI resSelectPayment;
    public RestaurantTakeoutStateAPI resPlaceOrder;
    public RestaurantTakeoutStateAPI resDeliverOrder;
    public RestaurantTakeoutStateAPI resCancel;
    public RestaurantTakeoutStateAPI currentState;

    public RestaurantDelivery(){
        this.currentState = new SelectItemsState(this, dishes);
//        TODO add more states
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

    public RestaurantTakeoutStateAPI getResDeliverOrder() {
        return resDeliverOrder;
    }

    public void setResDeliverOrder(RestaurantTakeoutStateAPI resDeliverOrder) {
        this.resDeliverOrder = resDeliverOrder;
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
    public void deliverOrder() {
        this.currentState.deliverOrder();
    }

    @Override
    public void cancelOrder() {
        this.currentState.cancelOrder();
    }
}
