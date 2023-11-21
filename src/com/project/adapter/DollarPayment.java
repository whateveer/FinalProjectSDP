package com.project.adapter;

public class DollarPayment {
    private String currency = "USD";   // Private member variable to store the currency, initialized to "USD"
    private int money;  // Private member variable to store the amount of money

    public DollarPayment(int money) {
        this.money = money;
    } // Constructor to initialize the DollarPayment object with the given amount of money

    public int getMoney() {
        return money;
    } // Getter method to retrieve the amount of money
}
