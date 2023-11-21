package com.project;

import com.project.adapter.DollarPayment;
import com.project.adapter.DollarToTengeAdapter;
import com.project.adapter.PaymentMachine;
import com.project.adapter.TengePayment;
import com.project.decorator.IAccessLevelDecorator;
import com.project.decorator.PremiumAccessDecorator;
import com.project.decorator.UltraAccessDecorator;
import com.project.strategy.Listener;
import com.project.strategy.Singer;
import com.project.strategy.User;
import com.project.strategy.Writer;

import java.sql.SQLException;
import java.util.Scanner;

public class AppRunner {
    public static void main(String[] args) throws SQLException {
        // Create an instance of DatabaseFunctions to interact with the database
        DatabaseFunctions dbf = new DatabaseFunctions();
        // Create a Scanner object to get user input
        Scanner sc = new Scanner(System.in);
        // Initialize User, PaymentMachine, and other related variables
        User user = null;
        PaymentMachine paymentMachine = new PaymentMachine();
        TengePayment tengePayment;
        DollarPayment dollarPayment;
        DollarToTengeAdapter dollarToTengePayment;
        int option;

        // Main loop for the application
        outerLoop:
        while (true) {
            // Display main menu options
            System.out.println("1. Sign in");
            System.out.println("2. Sign up");
            System.out.println("3. Exit");
            option = Integer.parseInt(sc.nextLine());
            boolean status = false;
            String session = "";
            String name;
            String password;
            // Switch statement for main menu options
            switch (option) {
                // Case 1: User sign-in
                case 1:
                    // Get user credentials for sign-in
                    System.out.println("Enter the name:");
                    name = sc.nextLine();
                    System.out.println("Enter the password:");
                    password = sc.nextLine();

                    // Sub-menu for selecting user type during sign-in
                    System.out.println("1. Sign In as a Listener");
                    System.out.println("2. Sign In as a Singer");
                    System.out.println("3. Sign In as a Podcaster");
                    System.out.println("4. Exit");
                    option = Integer.parseInt(sc.nextLine());

                    // Switch statement for user type selection during sign-in
                    switch (option) {
                        case 1:
                            // Create a User instance with a Listener decorator
                            user = new User(new Listener(dbf), name, password);
                            // Check if the user exists in the database
                            status = dbf.checkUser(user, "Listeners");
                            // Set the user's access level based on database information
                            user.setAccessLevel(dbf.getAccessLevel(user));
                            session = "Listener";
                            break;
                        case 2:
                            // Create a User instance with a Singer decorator
                            user = new User(new Singer(), name, password);
                            status = dbf.checkUser(user, "Singers");
                            session = "Singer";
                            break;
                        case 3:
                            // Create a User instance with a Writer decorator
                            user = new User(new Writer(), name, password);
                            status = dbf.checkUser(user, "Podcasters");
                            session = "Podcaster";
                            break;
                        case 4:
                            // Exit the sign-in process
                            break;
                    }

                    // Display appropriate message based on sign-in status
                    if (status) {
                        System.out.printf("Hello %s!\n", user.getName());
                    } else {
                        System.out.println("User does not exist! Check credentials or try to sign up.");
                    }
                    break;

                // Case 2: User sign-up
                case 2:
                    // Get user credentials for sign-up
                    System.out.println("Enter the name:");
                    name = sc.nextLine();

                    // Loop to ensure password confirmation during sign-up
                    while (true) {
                        System.out.println("Enter the password:");
                        password = sc.nextLine();
                        System.out.println("Repeat the password:");
                        String password2 = sc.nextLine();
                        if (password2.equals(password)) {
                            break;
                        } else {
                            System.out.println("Passwords don't match");
                        }
                    }

                    // Sub-menu for selecting user type during sign-up
                    System.out.println("1. Sign Up as a Listener");
                    System.out.println("2. Sign Up as a Singer");
                    System.out.println("3. Sign Up as a Podcaster");
                    System.out.println("4. Exit");
                    option = Integer.parseInt(sc.nextLine());

                    // Switch statement for user type selection during sign-up
                    switch (option) {
                        case 1:
                            // Create a User instance with a Listener decorator and add to the database
                            user = new User(new Listener(dbf), name, password);
                            dbf.addUser(user, "Listeners");
                            break;
                        case 2:
                            // Create a User instance with a Singer decorator and add to the database
                            user = new User(new Singer(), name, password);
                            dbf.addUser(user, "Singers");
                            break;
                        case 3:
                            // Create a User instance with a Writer decorator and add to the database
                            user = new User(new Writer(), name, password);
                            dbf.addUser(user, "Podcasters");
                            break;
                        case 4:
                            // Exit the sign-up process
                            break;
                    }
                    break;

                // Case 3: Exit the application
                case 3:
                    break outerLoop;
            }

            // Check if the user is signed in
            if (status) {
                // Second outer loop for user actions after sign-in
                secondOuter:
                while (true) {
                    // Actions based on the user's session type
                    if (session.equals("Singer")) {
                        // Sub-menu for Singer actions
                        System.out.println("1. Add a song");
                        System.out.println("2. Show my songs");
                        System.out.println("3. Log out");
                        option = Integer.parseInt(sc.nextLine());
                        switch (option) {
                            case 1:
                                // Add a song to the database
                                dbf.addSong(user.action());
                                break;
                            case 2:
                                // Display the songs of the current user
                                dbf.showSong(user.getName());
                                break;
                            case 3:
                                // Exit the Singer session
                                break secondOuter;
                        }
                    } else if (session.equals("Podcaster")) {
                        // Sub-menu for Podcaster actions
                        System.out.println("1. Add a podcast");
                        System.out.println("2. Show my podcast");
                        System.out.println("3. Log out");
                        option = Integer.parseInt(sc.nextLine());
                        switch (option) {
                            case 1:
                                // Add a podcast to the database
                                dbf.addAudioBook(user.action());
                                break;
                            case 2:
                                // Display the podcasts of the current user
                                dbf.showAudioBook(user.getName());
                                break;
                            case 3:
                                // Exit the Podcaster session
                                break secondOuter;
                        }
                    } else {
                        // Sub-menu for Listener actions
                        System.out.println("1. Start Listening");
                        System.out.println("2. Upgrade Access Level for 500 tenge");
                        System.out.println("3. Log out");
                        option = Integer.parseInt(sc.nextLine());
                        switch (option) {
                            case 1:
                                // Start listening to content
                                user.listenToContent();
                                break;
                            case 2:
                                // Upgrade access level for the Listener
                                int clientAL = user.getAccessLevel();
                                if (clientAL == 3) {
                                    System.out.println("You already have maximum access level");
                                } else if (clientAL == 2) {
                                    // Upgrade to Ultra access level
                                    System.out.println("Your access level upgrading to ultra");
                                    System.out.println("Select the payment currency");
                                    System.out.println("1. KZT - Tenge");
                                    System.out.println("2. USD - Dollars");
                                    int currencyOption = Integer.parseInt(sc.nextLine());
                                    System.out.println("Enter the payment amount:");
                                    int payment = Integer.parseInt(sc.nextLine());
                                    boolean paymentStatus;
                                    if (currencyOption == 1) {
                                        // Make a payment in Tenge
                                        tengePayment = new TengePayment(payment);
                                        paymentMachine.addPaymentStatusObserver(tengePayment);
                                        paymentStatus = paymentMachine.pay(tengePayment);
                                    } else {
                                        // Make a payment in Dollars and adapt it to Tenge
                                        dollarPayment = new DollarPayment(payment);
                                        dollarToTengePayment = new DollarToTengeAdapter(payment, dollarPayment);
                                        paymentMachine.addPaymentStatusObserver(dollarToTengePayment);
                                        paymentStatus = paymentMachine.pay(dollarToTengePayment);
                                    }
                                    // Update the user's access level in the database
                                    if (paymentStatus) {
                                        IAccessLevelDecorator ultraListener = new UltraAccessDecorator(new Listener(dbf));
                                        user = new User(ultraListener, user.getName(), user.getPassword());
                                        dbf.setAccessLevel(user, 3);
                                        System.out.println("Access level is upgraded!");
                                    } else {
                                        System.out.println("Error!");
                                        break;
                                    }
                                } else {
                                    // Upgrade to Premium access level
                                    System.out.println("Your access level upgrading to premium");
                                    System.out.println("Select the payment currency");
                                    System.out.println("1. KZT - Tenge");
                                    System.out.println("2. USD - Dollars");
                                    int currencyOption = Integer.parseInt(sc.nextLine());
                                    System.out.println("Enter the payment amount:");
                                    int payment = Integer.parseInt(sc.nextLine());
                                    boolean paymentStatus;
                                    if (currencyOption == 1) {
                                        // Make a payment in Tenge
                                        tengePayment = new TengePayment(payment);
                                        paymentMachine.addPaymentStatusObserver(tengePayment);
                                        paymentStatus = paymentMachine.pay(tengePayment);
                                    } else {
                                        // Make a payment in Dollars and adapt it to Tenge
                                        dollarPayment = new DollarPayment(payment);
                                        dollarToTengePayment = new DollarToTengeAdapter(payment, dollarPayment);
                                        paymentMachine.addPaymentStatusObserver(dollarToTengePayment);
                                        paymentStatus = paymentMachine.pay(dollarToTengePayment);
                                    }
                                    // Update the user's access level in the database
                                    if (paymentStatus) {
                                        IAccessLevelDecorator premiumListener = new PremiumAccessDecorator(new Listener(dbf));
                                        user = new User(premiumListener, user.getName(), user.getPassword());
                                        dbf.setAccessLevel(user, 2);
                                        System.out.println("Access level is upgraded!");
                                    } else {
                                        System.out.println("Error!");
                                        break;
                                    }
                                }
                                break;
                            case 3:
                                // Exit the Listener session
                                break secondOuter;
                        }
                    }
                }
            }
        }
    }
}
