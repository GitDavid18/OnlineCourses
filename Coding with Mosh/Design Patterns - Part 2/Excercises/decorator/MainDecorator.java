package com.codewithmosh.decorator;

public class MainDecorator implements ArtefactDecorator {
    private ArtefactDecorator artefactDecorator;

    public MainDecorator(ArtefactDecorator artefactDecorator) {
        this.artefactDecorator = artefactDecorator;
    }

    @Override
    public String render() {
        var icon = artefactDecorator.render();
        return icon + " [Main]";
    }
}
