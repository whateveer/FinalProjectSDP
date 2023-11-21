package com.project.adapter;

// Importing the IPaymentStatusObserver interface
import com.project.observer.IPaymentStatusObserver;

// Importing necessary Java utility classes
import java.util.ArrayList;
import java.util.List;

public class PaymentMachine {

    // Default currency for payments
    private String currency = "KZT";

    // Cost required for an upgrade
    private int upgradeCost = 500;

    // List to store payment status observers
    private List<IPaymentStatusObserver> paymentStatusObservers = new ArrayList<>();

    // Method to add a payment status observer to the list
    public void addPaymentStatusObserver(IPaymentStatusObserver observer) {
        paymentStatusObservers.add(observer);
    }

    // Method to process a payment and notify observers
    public boolean pay(TengePayment tengePayment){
        // Checking if the payment currency matches and the amount is sufficient
        boolean paymentStatus = tengePayment.getCurrency().equals(currency) && tengePayment.getMoney() >= upgradeCost;

        // Notifying all payment status observers
        for (IPaymentStatusObserver observer : paymentStatusObservers) {
            observer.updatePaymentStatus(paymentStatus);
        }

        // Displaying a message based on the payment status
        if (paymentStatus){
            System.out.println("Payment accepted!");
            return true;
        } else {
            System.out.println("Not enough money or wrong currency");
            return false;
        }
    }
}
