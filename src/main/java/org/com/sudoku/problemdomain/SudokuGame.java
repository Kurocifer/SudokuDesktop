package org.com.sudoku.problemdomain;

import java.io.Serializable;
import org.com.sudoku.constants.GameState;

public class SudokuGame implements Serializable {
  private final GameState gameState;
  private final int[][] gridState;
  public static final int GRID_BOUNDARY = 9;

  public SudokuGame(GameState gameState, int[][] gridState) {
    this.gameState = gameState;
    this.gridState = gridState;
  }
}