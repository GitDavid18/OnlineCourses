package com.codewithmoshSolutions.command;

public interface UndoableCommand extends Command {
    void undo();
}
