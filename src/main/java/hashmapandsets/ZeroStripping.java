package hashmapandsets;


import java.util.HashSet;
import java.util.Set;

//For each Zero in a mxn matrix, set its entire row and column to zero in place
public class ZeroStripping {
  public int[][] zeroMatrix(int[][] matrix){
    if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
      return matrix;
    }
    int rows = matrix.length;
    int cols = matrix[0].length;
    Set<Integer> rowIndices = new HashSet<>();
    Set<Integer> columnIndices = new HashSet<>();

    //Find the indices of zero elements in the matrix and store them in sets
    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < cols; col++) {
        if(matrix[row][col] == 0){
          rowIndices.add(row);
          columnIndices.add(col);
        }
      }
    }

    //if either the row index is present in the rowIndices set OR
    //the column index is present in the columnIndicesSet
    //then set that cell to zero
    for (int row = 0; row < rows; row++) {
      for(int col = 0; col < cols; col++){
        if(rowIndices.contains(row) || columnIndices.contains(col)){
          matrix[row][col] = 0;
        }
      }
    }
    return matrix;
  }

  public int[][] zeroMatrixOptimized(int[][] matrix){
    if(matrix == null || matrix.length == 0 || matrix[0].length ==0){
      return matrix;
    }
    int rows = matrix.length;
    int columns = matrix[0].length;

    //check if the first row initially contains zero in the matrix
    boolean firstRowHasZero = false;
    for(int col = 0; col < columns; col++){
      if(matrix[0][col] == 0){
        firstRowHasZero = true;
        break;
      }
    }

    //check if the first column initially contains zero in the matrix
    boolean firstColumnHasZero = false;
    for(int row = 0; row < rows; row++) {
      if (matrix[row][0] == 0) {
        firstColumnHasZero = true;
        break;
      }
    }

    //use the first row and first column as markers.
    //if an element in the submatrix is zero, mark its corresponding row and column
    // in the first row and first column as zero
    for(int row = 1; row < rows; row++) {
      for (int col = 0; col < columns; col++) {
        if (matrix[row][col] == 0) {
          matrix[row][0] = 0;//mark the column as zero
          matrix[0][col] = 0;//mark the row as zero
        }
      }
    }

    //update the submatrix using the markers in the first row and first column
    for (int row = 1; row < rows; row++) {
      for(int col = 1; col < columns; col++) {
        if(matrix[row][0] == 0 || matrix[0][col] == 0){
          matrix[row][col] = 0;
        }
      }
    }

    //if the first row had zero initially, set all the elements in the first row to zero
    if(firstRowHasZero){
      for(int col = 0; col < columns; col++){
        matrix[0][col] = 0;
      }
    }
    //if the first column had zero initially, set all the elements in the first column to zero
    if(firstColumnHasZero){
      for(int row = 0; row < rows; row++){
        matrix[row][0] = 0;
      }
    }
    return matrix;
  }
}
