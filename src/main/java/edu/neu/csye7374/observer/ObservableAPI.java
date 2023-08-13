package edu.neu.csye7374.observer;

public interface ObservableAPI {
    public void addObserver(ObserverAPI observerAPI);
    public void unregisterObserver(ObserverAPI observerAPI);
    public void notifyAllObservers();
    public void setData(String data);
}
