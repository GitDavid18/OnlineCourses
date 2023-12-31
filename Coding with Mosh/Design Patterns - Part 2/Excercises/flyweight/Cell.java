package com.codewithmosh.flyweight;

public class Cell {
  private CellContext cellContext;
  private final int row;
  private final int column;
  private String content;

  public Cell(int row, int column) {
    this.row = row;
    this.column = column;
  }

  public String getContent() {

    return content;
  }

  public void setContent(String content)
  {
    this.content = content;
  }

  public CellContext getCellContext() {
    return cellContext;
  }

  public void setCellContext(CellContext cellContext) {
    this.cellContext = cellContext;
  }

  public void render()
  {
    System.out.printf("(%d, %d): %s [%s]\n", row, column, content, cellContext.getFontFamily());
  }

}
