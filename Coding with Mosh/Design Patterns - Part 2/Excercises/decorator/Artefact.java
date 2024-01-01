package com.codewithmosh.decorator;

public class Artefact implements ArtefactDecorator{
    private String name;
    public Artefact(String name) {
        this.name = name;
    }

    public String render() {
        return name;
    }
}
