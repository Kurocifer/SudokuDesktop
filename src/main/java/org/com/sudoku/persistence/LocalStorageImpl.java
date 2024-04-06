package org.com.sudoku.persistence;

import org.com.sudoku.problemdomain.IStorage;
import org.com.sudoku.problemdomain.SudokuGame;


import java.io.*;
public class LocalStorageImpl implements IStorage {

  private static File GAME_DATA = new File(
          System.getProperty("user.home"),
          "gamedata.txt"
  );

  @Override
  public void updateGameData(SudokuGame game) throws IOException {
    try {
      FileOutputStream fileOutputStream = new FileOutputStream(GAME_DATA);
      ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

      objectOutputStream.writeObject(game);
      objectOutputStream.close();
    } catch (IOException ex) {
      throw new IOException("Unable to acces Game data");
    }
  }

  @Override
  public SudokuGame getGameData() throws IOException {
    FileInputStream fileInputStream =
            new FileInputStream(GAME_DATA);
    ObjectInputStream objectOutputStream = new ObjectInputStream(fileInputStream);

    try {
      SudokuGame gameState = (SudokuGame) objectOutputStream.readObject();
      objectOutputStream.close();
      return gameState;
    } catch (ClassNotFoundException e) {
      throw new IOException("File Not Found");
    }
  }
}
