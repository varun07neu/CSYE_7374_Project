package edu.neu.csye7374.templatepattern;

import edu.neu.csye7374.builder.Order;
import edu.neu.csye7374.factory.DishAPI;
import edu.neu.csye7374.prototypepattern.MenuItem;

import java.util.List;

public class DineIn_Invoice extends OrderInvoice_Template{
    double total;
    @Override
    public void generateHeader(Order order) {
        System.out.println("INVOICE FOR DINE IN ORDER BY " + order.getCustomerName());
    }

    @Override
    public void generateItems(Order order) {
        total = 0;
        List<MenuItem> items = order.getMenuItems();

        for(MenuItem item : items) {
            DishAPI dish = item.getDish();
            System.out.println(dish.getName() + "------" + dish.getPrice());
            total += dish.getPrice();
        }

    }

    @Override
    public void generateTotal() {
        System.out.println("THE TOTAL FOR THIS INVOICE IS " + total);
    }

    @Override
    public double getTotal() {
        return total;
    }
}
