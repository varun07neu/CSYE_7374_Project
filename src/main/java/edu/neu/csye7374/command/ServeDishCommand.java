package edu.neu.csye7374.command;

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
