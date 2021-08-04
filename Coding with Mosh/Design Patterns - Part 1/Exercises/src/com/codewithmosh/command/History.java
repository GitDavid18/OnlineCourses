package com.codewithmosh.command;

import java.util.ArrayDeque;
import java.util.Deque;

public class History {
    Deque<UndoableCommand> history = new ArrayDeque<>();

    public void push (UndoableCommand com){
        history.add(com);
    }

    public UndoableCommand pop (){
        return history.pop();
    }

    public int getLength(){
        return history.size();
    }

}
