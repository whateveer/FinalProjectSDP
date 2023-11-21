package com.project.observer;

// Interface defining the contract for payment status observers.
public interface IPaymentStatusObserver {

    // Method signature for updating payment status.
    // Implementing classes will provide functionality for handling changes in payment status.
    void updatePaymentStatus(boolean paymentStatus);
}
