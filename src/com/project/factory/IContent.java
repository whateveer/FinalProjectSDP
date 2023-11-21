package com.project.factory;

import java.util.List;

// Define an interface named IContent
public interface IContent {

    // Declare a method to get the name of the content
    String getName();

    // Declare a method to get the author of the content
    String getAuthor();

    // Declare a method to get the service level of the content as an integer
    int getServiceLevel();

    // Declare a method to get a list of chapters for the content
    List<String> getChapters();
}
