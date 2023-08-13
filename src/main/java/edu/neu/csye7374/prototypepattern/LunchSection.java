package edu.neu.csye7374.prototypepattern;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LunchSection extends MenuItem{

    private List<MenuItem> lunchItems = new ArrayList<>();

    @Override
    public void addMenuItem(MenuItem item) {
        lunchItems.add(item);
    }

    @Override
    public void removeMenuItem(MenuItem item) {
        lunchItems.remove(item);
    }

    @Override
    public Iterator<MenuItem> getIterator() {
        return lunchItems.iterator();
    }

    @Override
    public void describe() {
        System.out.println("BELOW ARE THE ITEMS FOR LUNCH");

        for(MenuItem item : lunchItems) {
            item.describe();
        }
    }
}
