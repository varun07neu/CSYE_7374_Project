package edu.neu.csye7374.prototypepattern;

import edu.neu.csye7374.factory.DinnerDishFactory;

public class DinnerItem1 extends MenuItem{

    public DinnerItem1() {
        this.itemNo = 4;
        this.dish = DinnerDishFactory.getInstance().createDish("Red Pepper Chicken",17.0);

    }

    @Override
    public void describe() {
        System.out.println("This is Dinner item 1 - " + this.dish);
    }
}
