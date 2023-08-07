package edu.neu.csye7374.command;

public class ServeDishCommand implements KitchenCommandAPI {

    public KitchenActions receiver;

    public ServeDishCommand(KitchenActions rec){
        receiver = rec;
    }

    @Override
    public void exec() {
        System.out.print("Kitchen update: ");
        receiver.serveDish();
        System.out.println();
    }
}
