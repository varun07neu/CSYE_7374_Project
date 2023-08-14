package edu.neu.csye7374.prototypepattern;

import edu.neu.csye7374.factory.LunchDishFactory;

public class LunchItem1 extends MenuItem{

    public LunchItem1() {
        this.itemNo = 1;
        this.dish = LunchDishFactory.getInstance().createDish("Kung Pao Chicken",15.0);
    }

    @Override
    public void describe() {
        System.out.println("This is Lunch item 1 - " + this.dish);
    }
}
