package edu.neu.csye7374.command;

public class KitchenInvoker implements KitchenInvokerAPI{

    public KitchenCommandAPI command;

    public KitchenInvoker(KitchenCommandAPI comm){
        command = comm;
    }

    @Override
    public void invoke() {
        System.out.print("Kitchen update: ");
        command.exec();
    }
}
