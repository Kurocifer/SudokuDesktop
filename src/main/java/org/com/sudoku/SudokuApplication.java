package org.com.sudoku;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.com.sudoku.buildlogic.SudokuBuildLogic;
import org.com.sudoku.userinterface.IUserInterfaceContract;
import org.com.sudoku.userinterface.UserInterfaceImpl;

import java.io.IOException;
import java.util.Objects;

public class SudokuApplication extends Application {
  private IUserInterfaceContract.View uiImpl;
  @Override
  public void start(Stage stage) throws IOException {
    // Get sudokuGame object for a new game
    uiImpl = new UserInterfaceImpl(stage);
    

    try {
      SudokuBuildLogic.build(uiImpl);
    } catch (IOException ex) {
      ex.printStackTrace();
      throw ex;
    }
//    FXMLLoader fxmlLoader = new FXMLLoader(SudokuApplication.class.getResource("hello-view.fxml"));
//    Scene scene = new Scene(fxmlLoader.load(), 320, 240);
//    stage.setTitle("Hello!");
//    stage.setScene(scene);
//    stage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}