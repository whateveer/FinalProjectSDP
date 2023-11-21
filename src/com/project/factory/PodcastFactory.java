package com.project.factory;

import java.util.ArrayList;
import java.util.List;

public class PodcastFactory extends Factory {

    // List to store the names of chapters in the podcast
    private List<String> chapters = new ArrayList<String>();

    // Override the createContent method from the parent class Factory
    @Override
    public IContent createContent(String authorName) {
        // Prompt the user to enter the name of the audiobook
        System.out.println("Enter the name of the podcast:");
        name = sc.nextLine(); // Read user input for the audiobook name

        // Prompt the user to enter the number of chapters in the podcast
        System.out.println("Enter the number of chapters");
        int size = Integer.parseInt(sc.nextLine()); // Read user input for the number of chapters

        // Loop to collect names of each chapter from the user
        for (int i = 1; i <= size; i++) {
            System.out.printf("Enter a name of a chapter №%d \n", i);
            String chapterName = sc.nextLine();
            chapters.add(chapterName); // Add each chapter name to the list
        }

        // Prompt the user to enter the service level (basic, premium, ultra) for the podcast
        System.out.println("Enter the service level (1. basic, 2. premium, 3. ultra):");
        serviceLevel = Integer.parseInt(sc.nextLine()); // Read user input for the service level

        // Create and return a new Podcast object with the gathered information
        return new Podcast(name, authorName, chapters, serviceLevel);
    }
}
