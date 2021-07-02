package com.codewithmosh.template;

public class ChatWindow extends Window {
    @Override
    protected void postClose() {
        System.out.println("Chat window closed");
    }

    @Override
    protected void preClose() {
        System.out.println("About to close the chat window");
    }
}
