package com.codewithmosh.flyweight;

public class SpreadSheet {
  private final int MAX_ROWS = 3;
  private final int MAX_COLS = 3;

  private Cell[][] cells = new Cell[MAX_ROWS][MAX_COLS];
  private CellContextFactory contextFactory;

  public SpreadSheet(CellContextFactory contextFactory) {
    this.contextFactory = contextFactory;
    generateCells();
  }

  public void setContent(int row, int col, String content) {
    ensureCellExists(row, col);

    cells[row][col].setContent(content);
  }

  public void setFontFamily(int row, int col, String fontFamily) {
    ensureCellExists(row, col);

    var cell = cells[row][col];
    var cellContext = cell.getCellContext();
    cells[row][col].setCellContext(contextFactory.getCellContext(fontFamily,cellContext.getFontSize() ,cellContext.isBold()));
  }

  private void ensureCellExists(int row, int col) {
    if (row < 0 || row >= MAX_ROWS)
      throw new IllegalArgumentException();

    if (col < 0 || col >= MAX_COLS)
      throw new IllegalArgumentException();
  }

  private void generateCells() {
    for (var row = 0; row < MAX_ROWS; row++)
      for (var col = 0; col < MAX_COLS; col++) {
        var cell = new Cell(row, col);
        cell.setCellContext(getDefaultCellContext());
        cells[row][col] = cell;
      }
  }

  private CellContext getDefaultCellContext(){
    return new CellContext("Times New Roman", 12, false);
  }

  public void render() {
    for (var row = 0; row < MAX_ROWS; row++)
      for (var col = 0; col < MAX_COLS; col++)
        cells[row][col].render();
  }
}
