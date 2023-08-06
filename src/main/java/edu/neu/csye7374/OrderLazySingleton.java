package edu.neu.csye7374;

public class OrderLazySingleton {

    private static OrderLazySingleton instance = new OrderLazySingleton();

    private OrderLazySingleton() {}

    static synchronized OrderLazySingleton getInstance() {
        if (instance == null) {
            instance = new OrderLazySingleton();
        }
        return instance;
    }

    //TODO: Uncomment after Order code is pulled
//    public OrderAPI getObject(OrderBuilder b) {
//        return new Order(b);
//    }
}
