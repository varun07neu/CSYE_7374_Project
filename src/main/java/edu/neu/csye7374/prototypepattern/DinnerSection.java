package edu.neu.csye7374.prototypepattern;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DinnerSection extends MenuItem{

    private List<MenuItem> dinnerItems = new ArrayList<>();

    @Override
    public void addMenuItem(MenuItem item) {
        dinnerItems.add(item);
    }

    @Override
    public void removeMenuItem(MenuItem item) {
        dinnerItems.remove(item);
    }

    @Override
    public Iterator<MenuItem> getIterator() {
        return dinnerItems.iterator();
    }

    @Override
    public void describe() {
        System.out.println("BELOW ARE THE ITEMS FOR DINNER");

        for(MenuItem item : dinnerItems) {
            item.describe();
        }
    }
}
