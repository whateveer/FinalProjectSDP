package com.project.factory;

import java.util.List;

public class Podcast implements IContent {

    // Private instance variables to store information about the podcast
    private String name;
    private String author;
    private List<String> chapters;

    // An additional attribute to represent the service level of the podcast
    private int serviceLevel;

    // Constructor for creating a Podcast object with specified attributes
    public Podcast(String name, String author, List<String> chapters, int serviceLevel) {
        this.name = name;
        this.author = author;
        this.chapters = chapters;
        this.serviceLevel = serviceLevel;
    }

    // Getter method to retrieve the name of the podcast
    public String getName() {
        return name;
    }

    // Getter method to retrieve the author of the podcast
    public String getAuthor() {
        return author;
    }

    // Getter method to retrieve the list of chapters/episodes in the podcast
    public List<String> getChapters() {
        return chapters;
    }

    // Getter method to retrieve the service level of the podcast
    public int getServiceLevel() {
        return serviceLevel;
    }
}
