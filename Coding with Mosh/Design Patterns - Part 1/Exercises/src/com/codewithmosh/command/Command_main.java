package com.codewithmosh.command;

public class Command_main {
    public static void main(String [] args){
        var videoEditor = new VideoEditor();
        var history = new History();

        var setTextCommand = new SetTextCommand(videoEditor, history, "Video Title");
        setTextCommand.execute();
        System.out.println("TEXT: " + videoEditor);

        var setContrast = new SetContrastCommand(videoEditor, history, 1);
        setContrast.execute();
        System.out.println("CONTRAST: " + videoEditor);

        var undoCommand = new UndoCommand(history);
        undoCommand.execute();
        System.out.println("UNDO: " + videoEditor);

        undoCommand.execute();
        System.out.println("UNDO: " + videoEditor);

        undoCommand.execute();
        System.out.println("UNDO: " + videoEditor);
    }
}
