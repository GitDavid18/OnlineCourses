package com.codewithmosh.decorator;

public class ErrorDecorator implements ArtefactDecorator{

    private ArtefactDecorator artefactDecorator;

    public ErrorDecorator(ArtefactDecorator artefactDecorator) {
        this.artefactDecorator = artefactDecorator;
    }

    @Override
    public String render() {
        var icon = artefactDecorator.render();
        return icon + " [Error]";
    }
}
