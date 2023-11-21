package com.project.adapter;

// Import statement for the IPaymentStatusObserver interface
import com.project.observer.IPaymentStatusObserver;

// DollarToTengeAdapter class extends TengePayment and implements IPaymentStatusObserver
public class DollarToTengeAdapter extends TengePayment implements IPaymentStatusObserver {

    // Private field to hold a reference to the DollarPayment object
    private DollarPayment dollarPayment;

    // Constructor for DollarToTengeAdapter, taking an initial money value and a DollarPayment object
    public DollarToTengeAdapter(int money, DollarPayment dollarPayment) {
        // Call the constructor of the superclass (TengePayment) with the provided money value
        super(money);
        // Assign the provided DollarPayment object to the local field
        this.dollarPayment = dollarPayment;
    }

    // Implementation of the getCurrency method from the TengePayment superclass
    @Override
    public String getCurrency() {
        // Return the currency code for Tenge (KZT)
        return "KZT";
    }

    // Implementation of the getMoney method from the TengePayment superclass
    @Override
    public int getMoney() {
        // Multiply the money value of the associated DollarPayment object by the conversion rate (460) and return the result
        return dollarPayment.getMoney() * 460;
    }

    // Implementation of the updatePaymentStatus method from the IPaymentStatusObserver interface
    @Override
    public void updatePaymentStatus(boolean paymentStatus) {
        // Print a message indicating the payment status for Dollars currency
        System.out.println("Payment status for Dollars currency: " + (paymentStatus ? "Success" : "Failed"));
    }
}
