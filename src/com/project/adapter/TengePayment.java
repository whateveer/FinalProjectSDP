package com.project.adapter;

// Importing the IPaymentStatusObserver interface from the com.project.observer package
import com.project.observer.IPaymentStatusObserver;

// TengePayment class implements the IPaymentStatusObserver interface
public class TengePayment implements IPaymentStatusObserver {


    private String currency = "KZT";

    private int money;

    // Constructor for initializing the TengePayment object with a specified amount of money
    public TengePayment(int money) {
        this.money = money;
    }

    // Getter method to retrieve the currency of the payment
    public String getCurrency() {
        return currency;
    }

    // Getter method to retrieve the amount of money in the payment
    public int getMoney() {
        return money;
    }

    // Implementation of the updatePaymentStatus method from the IPaymentStatusObserver interface
    // This method is called when the payment status is updated
    @Override
    public void updatePaymentStatus(boolean paymentStatus) {
        // Print a message indicating the payment status for Tenge currency (Success or Failed)
        System.out.println("Payment status for Tenge currency: " + (paymentStatus ? "Success" : "Failed"));
    }
}
