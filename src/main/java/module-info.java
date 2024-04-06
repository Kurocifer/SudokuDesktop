module org.sudoku.sudokudesktop {
  requires javafx.controls;
  requires javafx.fxml;


  opens org.com.sudoku to javafx.fxml;
  exports org.com.sudoku;
}