package com.codewithmoshDemos.command;

import com.codewithmoshDemos.command.fx.Command;

public class BlackAndWhiteCommand implements Command {
  @Override
  public void execute() {
    System.out.println("Black and white");
  }
}
