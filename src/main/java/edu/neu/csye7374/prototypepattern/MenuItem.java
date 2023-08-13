package edu.neu.csye7374.prototypepattern;

import edu.neu.csye7374.factory.DishAPI;

public abstract class MenuItem implements Cloneable{

    int itemNo;
    DishAPI dish;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public abstract void describe();

    @Override
    public String toString() {
        return "MenuItem{" +
                "itemNo=" + itemNo +
                ", dish=" + dish +
                '}';
    }
}
