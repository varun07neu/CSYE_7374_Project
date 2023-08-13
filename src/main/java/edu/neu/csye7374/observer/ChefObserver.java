package edu.neu.csye7374.observer;

public class ChefObserver implements ObserverAPI{
    @Override
    public void notify(String message) {
        System.out.println("Chef received the following message: "+message);
    }
}
