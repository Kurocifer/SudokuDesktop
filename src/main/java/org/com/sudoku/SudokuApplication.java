package org.com.sudoku;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SudokuApplication extends Application {
  private UserInterfaceContract.View uiImpl;
  @Override
  public void start(Stage stage) throws IOException {
    // Get sudokuGame object for a new game
    uiImpl = new UserInterfaceImpl(primaryStage); // primary stage, is one given by javaFx

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