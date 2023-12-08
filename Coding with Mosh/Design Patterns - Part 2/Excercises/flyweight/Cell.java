package com.codewithmosh.flyweight;

public class Cell {
  private final int row;
  private final int column;
  private String content;
  private String fontFamily;
  private int fontSize;
  private boolean isBold;

  public Cell(int row, int column) {
    this.row = row;
    this.column = column;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getFontFamily() {
    return fontFamily;
  }

  public void setFontFamily(String fontFamily) {
    this.fontFamily = fontFamily;
  }

  public int getFontSize() {
    return fontSize;
  }

  public void setFontSize(int fontSize) {
    this.fontSize = fontSize;
  }

  public boolean isBold() {
    return isBold;
  }

  public void setBold(boolean bold) {
    isBold = bold;
  }

  public void render() {
    System.out.printf("(%d, %d): %s [%s]\n", row, column, content, fontFamily);
  }
}
