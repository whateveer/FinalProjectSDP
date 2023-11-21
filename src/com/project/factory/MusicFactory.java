package com.project.factory;

public class MusicFactory extends Factory {

    // Override the createContent method from the parent class
    @Override
    public IContent createContent(String authorName) {

        // Display a prompt to enter the name of the song
        System.out.println("Enter the name of the song:");

        // Read the input for the name of the song from the user
        name = sc.nextLine();

        // Display a prompt to enter the service level
        System.out.println("Enter the service level (1. basic, 2. premium, 3. ultra):");

        // Read the input for the service level from the user and convert it to an integer
        serviceLevel = Integer.parseInt(sc.nextLine());

        // Create a new Music object with the provided parameters and return it
        return new Music(name, authorName, serviceLevel);
    }
}
