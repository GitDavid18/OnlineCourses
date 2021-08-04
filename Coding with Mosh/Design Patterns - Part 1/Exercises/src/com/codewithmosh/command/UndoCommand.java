package com.codewithmosh.command;

public class UndoCommand implements Command{
    private History history;

    public UndoCommand(History history){
        this.history = history;
    }

    @Override
    public void execute() {
        if(history.getLength() > 0){
            history.pop().unExecute();
        }
    }
}
