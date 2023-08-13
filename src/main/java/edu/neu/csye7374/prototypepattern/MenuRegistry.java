package edu.neu.csye7374.prototypepattern;

import java.util.HashMap;
import java.util.Map;

public class MenuRegistry {

    private static Map<Integer, MenuItem> menu = new HashMap<>();

    static {
        menu.put(1, new LunchItem1());
        menu.put(2, new LunchItem2());
        menu.put(3, new LunchItem3());
        menu.put(4, new DinnerItem1());
        menu.put(5, new DinnerItem2());
        menu.put(6, new DinnerItem3());
    }

    public static MenuItem getMenuItem(int menuItemNo) throws CloneNotSupportedException {
        return (MenuItem) menu.get(menuItemNo).clone();
    }

}

