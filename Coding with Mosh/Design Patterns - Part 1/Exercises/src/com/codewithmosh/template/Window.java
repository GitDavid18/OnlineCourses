package com.codewithmosh.template;

public abstract class Window {
    public void close() {
        preClose();
        System.out.println("Removing the window from the screen");
        postClose();
    }

    protected void preClose(){
        System.out.println("My prestep.");
    }

    protected void postClose(){
        System.out.println("My poststep.");
    }
}
