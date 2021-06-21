package com.codewithmoshDemos.command;

import com.codewithmoshDemos.command.fx.Command;

public class ResizeCommand implements Command {
  @Override
  public void execute() {
    System.out.println("Resize");
  }
}
