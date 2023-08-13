package edu.neu.csye7374.observer;

public class KitchenObserver implements ObserverAPI{
    @Override
    public void notify(String message) {
        System.out.println("Kitchen received the following message: "+message);
    }
}
