package edu.neu.csye7374.prototypepattern;

import edu.neu.csye7374.factory.DishAPI;

import java.util.Iterator;

public abstract class MenuItem implements Cloneable{

    int itemNo;
    DishAPI dish;

    public int getItemNo() {
        return itemNo;
    }

    public DishAPI getDish() {
        return dish;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public abstract void describe();

    public void addMenuItem(MenuItem item) {

    }
    public void removeMenuItem(MenuItem item){

    }

    public void setDish(DishAPI dish) {
        this.dish = dish;
    }

    public Iterator<MenuItem> getIterator() {
        return null;
    }

    @Override
    public String toString() {
        return "MenuItem{" +
                "itemNo=" + itemNo +
                ", dish=" + dish +
                '}';
    }
}
