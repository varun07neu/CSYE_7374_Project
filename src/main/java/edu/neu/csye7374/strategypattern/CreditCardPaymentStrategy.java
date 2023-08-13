package edu.neu.csye7374.strategypattern;

public class CreditCardPaymentStrategy implements PaymentStrategy{

    int paymentAmount;
    int tipAmount;

    String creditCardHolderName;

    public CreditCardPaymentStrategy(int paymentAmount, int tipAmount, String creditCardHolderName) {
        this.paymentAmount = paymentAmount;
        this.tipAmount = tipAmount;
        this.creditCardHolderName = creditCardHolderName;
    }

    @Override
    public void processPayment(int totalBillAmount) {
        System.out.println("CASH PAYMENT DETAILS");
        System.out.println("Total Bill Amount " + totalBillAmount);
        System.out.println("Tip Amount " + this.tipAmount);
        System.out.println("Amount received " + this.paymentAmount);
        System.out.println("Credit Card Holder " + this.creditCardHolderName);
        System.out.println("Amount returned " + (this.paymentAmount - this.tipAmount -totalBillAmount));
        System.out.println("------------" + "\n");
    }
}