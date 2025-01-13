package hashmapandsets;

import java.util.HashSet;
import java.util.Set;

public class SudokuBoard {
  public boolean verifySudoku(int[][] board) {
    //create hashsets for each row, column, and subgrid to keep track of
    //numbers previously seen on any given row, column, or subgrid
    Set<Integer>[] rowSets = new HashSet[9];
    Set<Integer>[] columnSets = new HashSet[9];
    Set<Integer>[][] subgridSets = new HashSet[3][3];

    for(int i = 0; i < 9; i++) {
      rowSets[i] = new HashSet<>();
      columnSets[i] = new HashSet<>();
    }
    for(int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        subgridSets[i][j] = new HashSet<>();
      }
    }

    for (int row = 0; row < 9; row++) {
      for (int col = 0; col < 9; col++) {
        int num = board[row][col];
        if(num <= 0){continue;}

        if(rowSets[row].contains(num)){
          System.out.println("Failed Row Validation");
          System.out.println("Duplicate number found in row " + row + ", column " + col + ": " + num);
          return false;
        }
        if(columnSets[col].contains(num)){
          System.out.println("Failed Column Validation");
          System.out.println("Duplicate number found in row " + row + ", column " + col + ": " + num);
          return false;
        }
        if(subgridSets[row / 3][col / 3].contains(num)){
          System.out.println("Failed grid Validation");
          System.out.println("Duplicate number found in row " + row + ", column " + col + ": " + num);
          return false;
        }
        //if we passed the above checks, mark this values as seen
        //by adding it to the respective row, column and subgrid set
        rowSets[row].add(num);
        columnSets[col].add(num);
        subgridSets[row / 3][col / 3].add(num);
      }
    }
    return true;
  }
}
