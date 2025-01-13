
import hashmapandsets.SudokuBoard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SudokuBoardTest {

  private SudokuBoard sudokuBoard;

  @BeforeEach
  void setUp() {
    sudokuBoard = new SudokuBoard();
  }

  @Test
  void testValidSudokuBoard() {
    int[][] validBoard = {
        {5,3,4,6,7,8,9,1,2},
        {6,7,2,1,9,5,3,4,8},
        {1,9,8,3,4,2,5,6,7},
        {8,5,9,7,6,1,4,2,3},
        {4,2,6,8,5,3,7,9,1},
        {7,1,3,9,2,4,8,5,6},
        {9,6,1,5,3,7,2,8,4},
        {2,8,7,4,1,9,6,3,5},
        {3,4,5,2,8,6,1,7,9}
    };
    assertTrue(sudokuBoard.verifySudoku(validBoard));
  }

  @Test
  void testInvalidSudokuBoard() {
    int[][] invalidBoard = {
        {5,3,4,6,7,8,9,1,2},
        {6,7,2,1,9,5,3,4,8},
        {1,9,8,3,4,2,5,6,7},
        {8,5,9,7,6,1,4,2,3},
        {4,2,6,8,5,3,7,9,1},
        {7,1,3,9,2,4,8,5,6},
        {9,6,1,5,3,7,2,8,4},
        {2,8,7,4,1,9,6,3,5},
        {3,4,5,2,8,6,1,7,5}  // Last number changed from 9 to 5
    };
    assertFalse(sudokuBoard.verifySudoku(invalidBoard));
  }

  @Test
  void testEmptySudokuBoard() {
    int[][] emptyBoard = new int[9][9];
    assertTrue(sudokuBoard.verifySudoku(emptyBoard));
  }

  @ParameterizedTest
  @MethodSource("provideInvalidBoards")
  void testInvalidSudokuBoards(int[][] board, String description) {
    assertFalse(sudokuBoard.verifySudoku(board), "Failed on: " + description);
  }

  private static Stream<Arguments> provideInvalidBoards() {
    return Stream.of(
        Arguments.of(new int[][]{
            {1,1,1,1,1,1,1,1,1},
            {2,2,2,2,2,2,2,2,2},
            {3,3,3,3,3,3,3,3,3},
            {4,4,4,4,4,4,4,4,4},
            {5,5,5,5,5,5,5,5,5},
            {6,6,6,6,6,6,6,6,6},
            {7,7,7,7,7,7,7,7,7},
            {8,8,8,8,8,8,8,8,8},
            {9,9,9,9,9,9,9,9,9}
        }, "All rows with same number"),
        Arguments.of(new int[][]{
            {1,2,3,4,5,6,7,8,9},
            {1,2,3,4,5,6,7,8,9},
            {1,2,3,4,5,6,7,8,9},
            {1,2,3,4,5,6,7,8,9},
            {1,2,3,4,5,6,7,8,9},
            {1,2,3,4,5,6,7,8,9},
            {1,2,3,4,5,6,7,8,9},
            {1,2,3,4,5,6,7,8,9},
            {1,2,3,4,5,6,7,8,9}
        }, "All columns with same sequence"),
        Arguments.of(new int[][]{
            {1,2,3,1,2,3,1,2,3},
            {4,5,6,4,5,6,4,5,6},
            {7,8,9,7,8,9,7,8,9},
            {1,2,3,1,2,3,1,2,3},
            {4,5,6,4,5,6,4,5,6},
            {7,8,9,7,8,9,7,8,9},
            {1,2,3,1,2,3,1,2,3},
            {4,5,6,4,5,6,4,5,6},
            {7,8,9,7,8,9,7,8,9}
        }, "Invalid subgrids")
    );
  }
}