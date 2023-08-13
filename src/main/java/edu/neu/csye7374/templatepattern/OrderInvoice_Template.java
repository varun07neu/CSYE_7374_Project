package edu.neu.csye7374.templatepattern;

import edu.neu.csye7374.builder.Order;

public abstract class OrderInvoice_Template {

    public abstract void generateHeader(Order order);
    public abstract void generateItems(Order order);
    public abstract void generateTotal();

    public final void generateInvoice(Order order) {
        generateHeader(order);
        generateItems(order);
        generateTotal();
    }

    public abstract double getTotal();
}
