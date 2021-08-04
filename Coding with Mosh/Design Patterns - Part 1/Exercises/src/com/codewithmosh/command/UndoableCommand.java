package com.codewithmosh.command;

public interface UndoableCommand extends Command{
    public void unExecute();
}
