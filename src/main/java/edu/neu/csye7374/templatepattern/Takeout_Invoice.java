package edu.neu.csye7374.templatepattern;

import edu.neu.csye7374.builder.Order;
import edu.neu.csye7374.factory.DishAPI;
import edu.neu.csye7374.prototypepattern.MenuItem;

import java.util.List;

public class Takeout_Invoice extends OrderInvoice_Template{
    double total;
    @Override
    public void generateHeader(Order order) {
        System.out.println("INVOICE FOR TAKEOUT ORDER BY " + order.getCustomerName());
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
        System.out.println("THE TOTAL FOR THIS INVOICE IS " + total*1.15);
    }

    @Override
    public double getTotal() {
        return total;
    }
}
