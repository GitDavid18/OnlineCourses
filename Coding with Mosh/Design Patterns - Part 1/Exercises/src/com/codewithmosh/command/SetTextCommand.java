package com.codewithmosh.command;

public class SetTextCommand extends AbstractUndoCommand {
private String text;

    public SetTextCommand(VideoEditor videoEditor, History history, String text){
        super(videoEditor,history);
        this.text = text;
    }

    @Override
    protected void doExecute() {
        videoEditor.setText(text);
    }

    @Override
    public void unExecute() {
        videoEditor.removeText();
    }
}
