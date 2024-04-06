package org.com.sudoku.userinterface;

import org.com.sudoku.problemdomain.SudokuGame;
public interface IUserInterfaceContract {

  interface EventListener {
    void onSudokuInput(int x, int y, int iput);
    void onDialogClick();
  }

  interface View {
    void setListener(IUserInterfaceContract.EventListener listener);
    // update one square after user input
    void updateSquare(int x, int y, int input);

    // update the entire board, like after game completion or initial execution of the program
    // or after an error occurs
    void updateBoard(SudokuGame game);
    void showDialog(String message);
    void showError(String message);


  }
}
