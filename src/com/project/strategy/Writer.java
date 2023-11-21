package com.project.strategy;

import com.project.factory.IContent;
import com.project.factory.PodcastFactory;

public class Writer implements IStrategy {

    // Implementation of the 'action' method from the 'IStrategy' interface
    @Override
    public IContent action(String name) {
        // Create an instance of 'PodcastFactory' to generate 'Podcast' objects
        PodcastFactory audioBookFactory = new PodcastFactory();

        // Use the factory to create a 'Podcast' object with the given name
        return audioBookFactory.createContent(name);
    }
}
