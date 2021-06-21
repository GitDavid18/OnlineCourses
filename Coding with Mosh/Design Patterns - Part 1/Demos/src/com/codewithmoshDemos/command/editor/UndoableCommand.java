package com.codewithmoshDemos.command.editor;

public interface UndoableCommand extends Command {
  void unexecute();
}
