package edu.neu.csye7374.observer;

import java.util.ArrayList;
import java.util.List;

public class RestaurantObservable implements ObservableAPI{
    private List<ObserverAPI> observers = new ArrayList<>();
    String data ="THIS IS LATEST DATA";
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
        for(ObserverAPI ob : observers) {
            ob.notify(data);
        }
    }
}
