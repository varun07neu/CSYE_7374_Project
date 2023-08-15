# CSYE_7374_Project
# Restaurant Management Application

## Members:
1. Erarica Mehra -	002113683
2. Jason Paul Darivemula -	002198774
3. Varun Venkatesh Gowda - 002126161
4. Manoj Amireddy	- 002196218

## Running the application
- This is a console application making use of the following design patterns. A driver run configuration is added but can also be run by simply going to Driver.java and running the class

## Design Patterns

### Factory Method Pattern
- `DishFactory` is the factory interface represents a factory for obtaining new `Dish` objects
- `Dish` is the product interface represeting a dish
- `LunchDishFactory` is a concrete implementation of `DishFactory`
- `DinnerDishFactory` is a concrete implementation of `DishFactory`
- `LunchDish` is a concrete implementation of `Dish` representing a Lunch Dish
- `DinnerDish` is a concrete implementation of `Dish` representing a Dinner Dish

### Abstract Factory Pattern
- `IngredientAbstractFactory` is the factory interface represents a factory for obtaining new a set of ingredients
- `SpicyIngredientFactory` is a concrete implementation of  `IngredientAbstractFactory` and returns a set of spicy ingredients
- `StandardIngredientFactory` is a concrete implementation of  `IngredientAbstractFactory` and returns a set of standard ingredients

### Singleton Pattern
- `OrderManager` class is a central repository of all orders in the application. We return a single instance of this class

### Builder Pattern
- `OrderBuilder` is the builder interface that has the steps to build an `Order` object
- `Order` is a class representing a order
- `TakeAwayOrderBuilder` extends `Order` represents a Take away order
- `DineInOrderBuilder` extends `Order` represents a Dine In order

### Prototype Pattern 
- `MenuItem` is an abstract class that implements the Cloneable interface
- `MenuRegistry` is a central location of the different menu items. Anytime we need a menu item we get a clone of a menu item from here.

### Strategy Pattern 
- `PaymentStrategy` is an interface that represents a way to make a payment for an order
- `OnlinePaymentStrategy`
- `CreditCardPaymentStrategy`
- `CashPaymentStrategy`

### Command Pattern 
- `KitchenCommandAPI` represents a command/request to the kitchen
- `CookDishCommand` command to cook a dish
- `ServeDishCommand` command to serve a dish

### Adapter Pattern 
- `InHouseDelivery` is the Client API
- `DoorDashDelivery` represents the Third party API
- We adapt InHouseDelivery to use DoorDashDelivery

### Decorator Pattern 
- We used this pattern to decorate the different dishes in an Order
- `ExtraProteinDecorator`
- `ExtraRiceDecorator`
- `ExtraSpicyDecorator`
- `MildSpicyDecorator`

### Composite Pattern
- `LunchSection` is a composite of MenuItem
- `DinnerSection` is a composite of MenuItem

### Template Pattern
- `OrderInvoice_Template` is an interface that has the primitive steps to generate an Order Invoice
- `DineIn_Invoice` is used to generate Dine In Invoices
- `TakeOut_Invoice` is used to generate Take Out Invoices

### State Pattern
- `RestaurantTakeoutStateAPI` is an interface that has the state transition methods that other concrete state classes will implement
- `RestaurantDelivery` is the class that sets the initial state and holds the initial state transition into SelectItemsState and sets the MenuItem objects for the order
- `SelectItemsState` is the class that supports state transition into SelectPaymentMethodState and sets the payment strategy
- `SelectPaymentMethodState` is the class that supports state transition into PlaceOrderState and processes the payment for the order
- `PlaceOrderState` is the class that supports state transition into CancelState and closes out the order
- `CancelState` is the initial state and also enables clearing out the dishes in the order

### Observer Pattern
- `ObserverAPI` is an interface that the Observers implement to be able to notify users of the set message
- `ObservableAPI` is an interface that the RestaurantObservable implements
- `RestaurantObservable` adds/notify/remove observers and set message for notifying users
- `KitchenObserver, ChefObserverAPI` observers participate in the app to notify the kitchen and chefs of any new orders