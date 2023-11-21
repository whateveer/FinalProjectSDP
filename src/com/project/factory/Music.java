package com.project.factory;

import java.util.List;

public class Music implements IContent {

    // Private fields for storing music information
    private String name;
    private String author;
    private int serviceLevel;

    // Constructor for creating a Music object with specified name, author, and service level
    public Music(String name, String author, int serviceLevel) {
        this.name = name;
        this.author = author;
        this.serviceLevel = serviceLevel;
    }

    // Override the getChapters method from the IContent interface (not used in Music)
    @Override
    public List<String> getChapters() {
        return null; // Music doesn't have chapters, so returning null
    }

    // Getter method for retrieving the name of the music
    public String getName() {
        return name;
    }

    // Getter method for retrieving the author of the music
    public String getAuthor() {
        return author;
    }

    // Override the getServiceLevel method from the IContent interface
    @Override
    public int getServiceLevel() {
        return serviceLevel; // Return the service level associated with the music
    }
}
