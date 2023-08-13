package edu.neu.csye7374.strategypattern;

public class CashPaymentStrategy implements PaymentStrategy{

    double paymentAmount;
    double tipAmount;

    public CashPaymentStrategy(double paymentAmount, double tipAmount) {
        this.paymentAmount = paymentAmount;
        this.tipAmount = tipAmount;
    }

    @Override
    public void processPayment(double totalBillAmount) {
        System.out.println("CASH PAYMENT DETAILS");
        System.out.println("Total Bill Amount " + totalBillAmount);
        System.out.println("Tip Amount " + this.tipAmount);
        System.out.println("Cash received " + this.paymentAmount);
        System.out.println("Cash returned " + (this.paymentAmount - this.tipAmount -totalBillAmount));
        System.out.println("------------" + "\n");
    }
}
