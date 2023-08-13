package edu.neu.csye7374.observer;

import edu.neu.csye7374.builder.Order;

import java.util.ArrayList;
import java.util.List;

public class RestaurantObservable implements ObservableAPI{
    private List<ObserverAPI> observers = new ArrayList<>();
    String data;

    public List<ObserverAPI> getObservers() {
        return observers;
    }

    public void setObservers(List<ObserverAPI> observers) {
        this.observers = observers;
    }

    public String getData() {
        return data;
    }

    @Override
    public void setData(String data) {
        this.data = data;
    }

    public static String getMessageForOrder(Order order){
        return "Order placed: "+order;
    }

    @Override
    public void addObserver(ObserverAPI observerAPI) {
        observers.add(observerAPI);
    }

    @Override
    public void unregisterObserver(ObserverAPI observerAPI) {
        observers.remove(observerAPI);
    }

    @Override
    public void notifyAllObservers() {
        System.out.println("Notification!");
        for(ObserverAPI ob : observers) {
            ob.notify(data);
        }
    }
}
