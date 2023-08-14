package edu.neu.csye7374.prototypepattern;

import edu.neu.csye7374.factory.LunchDishFactory;

public class LunchItem2 extends MenuItem{

    public LunchItem2() {
        this.itemNo = 2;
        this.dish = LunchDishFactory.getInstance().createDish("Veggie Chow Mein",13.0);
    }

    @Override
    public void describe() {
        System.out.println("This is Lunch item 2 - " + this.dish);
    }
}
