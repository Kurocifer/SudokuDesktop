package org.com.sudoku.userinterface.logic;

import org.com.sudoku.computationlogic.GameLogic;
import org.com.sudoku.constants.GameState;
import org.com.sudoku.constants.Messages;
import org.com.sudoku.problemdomain.IStorage;
import org.com.sudoku.problemdomain.SudokuGame;
import org.com.sudoku.userinterface.IUserInterfaceContract;

import java.io.IOException;

public class ControlLogic implements IUserInterfaceContract.EventListener {
  private IStorage storage;
  private IUserInterfaceContract.View view;

  public ControlLogic(IStorage storage, IUserInterfaceContract.View view) {
    this.storage = storage;
    this.view = view;
  }

  /**
   * Retrieve current "state" of the data from IStorage
   * Update it according to the input
   * Write the result to IStorage
   *
   * @param x X coordinate of the selected input
   * @param y Y ...
   * @param input Which key was entered, One of:
   *  - Numbers 0-9
   *
   */
  @Override
  public void onSudokuInput(int x, int y, int input) {
    try {
      SudokuGame gameData = storage.getGameData();
      int[][] newGridState = gameData.getCopyOfGridState();
      newGridState[x][y] = input;

      gameData = new SudokuGame(
              GameLogic.checkForCompletion(newGridState),
              newGridState
      );

      storage.updateGameData(gameData);
      view.updateSquare(x, y, input);

      // if game is complete show dialog
      if (gameData.getGameState() == GameState.COMPLETE) view.showDialog(Messages.GAME_COMPLETE);
    } catch (IOException ex) {
      ex.printStackTrace();
      view.showError(Messages.ERROR);
    }
  }

  @Override
  public void onDialogClick() {
    try {
      storage.updateGameData(
              GameLogic.getNewGame()
      );

      view.updateBoard(storage.getGameData());
    } catch (IOException e) {
      view.showError(Messages.ERROR);
    }
  }
}
