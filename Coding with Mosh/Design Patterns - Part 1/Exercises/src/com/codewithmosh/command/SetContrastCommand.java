package com.codewithmosh.command;

public class SetContrastCommand extends AbstractUndoCommand {
    private float contrast;
    private float prevContrast;

    public SetContrastCommand(VideoEditor videoEditor, History history, float contrast){
        super(videoEditor, history);
        prevContrast = videoEditor.getContrast();
        this.contrast = contrast;
    }

    @Override
    protected void doExecute() {
        videoEditor.setContrast(contrast);
    }

    @Override
    public  void unExecute() {
        videoEditor.setContrast(prevContrast);
    }
}
