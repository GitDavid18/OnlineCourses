package com.codewithmosh.command;

public abstract class AbstractUndoCommand implements UndoableCommand {
    protected VideoEditor videoEditor;
    protected History history;

    public AbstractUndoCommand(VideoEditor videoEditor, History history){
        this.history = history;
        this.videoEditor = videoEditor;
    }

    @Override
    public void execute() {
        doExecute();

        history.push(this);
    }

    protected abstract void doExecute();
}
