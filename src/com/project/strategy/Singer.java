package com.project.strategy;

import com.project.factory.IContent;
import com.project.factory.MusicFactory;

public class Singer implements IStrategy {

    // Implementation of the 'action' method defined in the 'IStrategy' interface
    @Override
    public IContent action(String name) {
        // Create an instance of 'MusicFactory' to facilitate content creation
        MusicFactory songFactory = new MusicFactory();

        // Use the 'MusicFactory' to create content (presumably a song) based on the provided name
        return songFactory.createContent(name);
    }
}
