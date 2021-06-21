package com.codewithmoshDemos.state;

public class EraserTool implements Tool {
  @Override
  public void mouseDown() {
    System.out.println("Eraser icon");
  }

  @Override
  public void mouseUp() {
    System.out.println("Erase something");
  }
}
