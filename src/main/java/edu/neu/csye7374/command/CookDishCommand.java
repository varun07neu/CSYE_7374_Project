package edu.neu.csye7374.command;

import edu.neu.csye7374.factory.DishAPI;

public class CookDishCommand implements KitchenCommandAPI{

    public DishAPI receiver;

    public CookDishCommand(DishAPI rec){
        receiver = rec;
    }

    @Override
    public void exec() {
        System.out.print("Kitchen update: ");
        receiver.cook();
        System.out.println();
    }
}
