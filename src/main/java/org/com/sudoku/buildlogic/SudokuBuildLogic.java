package org.com.sudoku.buildlogic;

import org.com.sudoku.computationlogic.GameLogic;
import org.com.sudoku.persistence.LocalStorageImpl;
import org.com.sudoku.problemdomain.SudokuGame;
import org.com.sudoku.userinterface.IUserInterfaceContract;
import org.com.sudoku.userinterface.logic.ControlLogic;
import org.com.sudoku.problemdomain.IStorage;

import java.io.IOException;
public class SudokuBuildLogic {

  public static void build(IUserInterfaceContract.View userInterface) throws IOException {
    SudokuGame initialState;
    IStorage storage = new LocalStorageImpl();

    try {
      //will throw if no game data is found in local storage

      initialState = storage.getGameData();
    } catch (IOException e) {

      initialState = GameLogic.getNewGame();
      //this method below will also throw an IOException
      //if we cannot update the game data. At this point
      //the application is considered unrecoverable
      storage.updateGameData(initialState);
    }

    IUserInterfaceContract.EventListener uiLogic = new ControlLogic(storage, userInterface);
    userInterface.setListener(uiLogic);
    userInterface.updateBoard(initialState);
  }
}
