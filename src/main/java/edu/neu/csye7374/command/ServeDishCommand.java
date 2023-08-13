package edu.neu.csye7374.command;

import edu.neu.csye7374.factory.DishAPI;

public class ServeDishCommand implements KitchenCommandAPI {

    public DishAPI receiver;

    public ServeDishCommand(DishAPI rec){
        receiver = rec;
    }

    @Override
    public void exec() {
        System.out.print("Kitchen update: ");
        receiver.serve();
        System.out.println();
    }
}
