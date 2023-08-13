package edu.neu.csye7374.strategypattern;

public class OnlinePaymentStrategy implements PaymentStrategy{

    int paymentAmount;
    int tipAmount;

    String onlinePlatform;

    public OnlinePaymentStrategy(int paymentAmount, int tipAmount, String onlinePlatform) {
        this.paymentAmount = paymentAmount;
        this.tipAmount = tipAmount;
        this.onlinePlatform = onlinePlatform;
    }

    @Override
    public void processPayment(double totalBillAmount) {
        System.out.println("CASH PAYMENT DETAILS");
        System.out.println("Total Bill Amount " + totalBillAmount);
        System.out.println("Tip Amount " + this.tipAmount);
        System.out.println("Amount received " + this.paymentAmount);
        System.out.println("Online Platform " + this.onlinePlatform);
        System.out.println("Amount returned " + (this.paymentAmount - this.tipAmount -totalBillAmount));
        System.out.println("------------" + "\n");
    }
}
