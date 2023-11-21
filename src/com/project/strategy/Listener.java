package com.project.strategy;

import com.project.DatabaseFunctions;
import com.project.factory.IContent;

import java.sql.SQLException;
import java.util.Scanner;

// The Listener class implements the IStrategy interface
public class Listener implements IStrategy {
    private DatabaseFunctions dbf;

    // Constructor that takes a DatabaseFunctions object as a parameter
    public Listener(DatabaseFunctions dbf) {
        this.dbf = dbf;
    }

    // Implementation of the action method from the IStrategy interface
    @Override
    public IContent action(String name) {
        // This method is not currently implemented and returns null
        return null;
    }

    // Method to listen to content based on the user's access level
    public void listenToContent(int accessLevel) throws SQLException {
        Scanner sc = new Scanner(System.in);

        // Display options for the user
        System.out.println("1. Listen to the Music");
        System.out.println("2. Listen to the Podcast");

        // Read the user's choice
        int option = Integer.parseInt(sc.nextLine());

        // Perform actions based on the user's choice
        if (option == 1) {
            // If the user chooses to listen to music, prompt for the song name and call the appropriate method in DatabaseFunctions
            System.out.println("Enter the name of the music:");
            dbf.listenToMusic(accessLevel, sc.nextLine());
        } else {
            // If the user chooses to listen to an audiobook, prompt for the audiobook name and call the appropriate method in DatabaseFunctions
            System.out.println("Enter the name of podcast:");
            dbf.listenToAudioBook(accessLevel, sc.nextLine());
        }
    }
}
