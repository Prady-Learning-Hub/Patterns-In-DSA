import hashmapandsets.ZeroStripping;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ZeroStrippingTest {

  private ZeroStripping zeroStripping;

  @BeforeEach
  void setUp() {
    zeroStripping = new ZeroStripping();
  }

  @Test
  void testNullMatrix() {
    assertNull(zeroStripping.zeroMatrix(null));
  }

  @Test
  void testEmptyMatrix() {
    int[][] emptyMatrix = {};
    assertArrayEquals(emptyMatrix, zeroStripping.zeroMatrix(emptyMatrix));
  }

  @Test
  void testMatrixWithNoZeros() {
    int[][] input = {{1, 2}, {3, 4}};
    int[][] expected = {{1, 2}, {3, 4}};
    assertArrayEquals(expected, zeroStripping.zeroMatrix(input));
  }

  @Test
  void testMatrixWithOneZero() {
    int[][] input = {{1, 0}, {3, 4}};
    int[][] expected = {{0, 0}, {3, 0}};
    assertArrayEquals(expected, zeroStripping.zeroMatrix(input));
  }

  @Test
  void testMatrixWithMultipleZeros() {
    int[][] input = {
        {1, 2, 3, 4},
        {5, 0, 7, 8},
        {9, 10, 11, 12},
        {13, 14, 0, 16}
    };
    int[][] expected = {
        {1, 0, 0, 4},
        {0, 0, 0, 0},
        {9, 0, 0, 12},
        {0, 0, 0, 0}
    };
    assertArrayEquals(expected, zeroStripping.zeroMatrix(input));
  }

  @Test
  void testMatrixWithAllZeros() {
    int[][] input = {{0, 0}, {0, 0}};
    int[][] expected = {{0, 0}, {0, 0}};
    assertArrayEquals(expected, zeroStripping.zeroMatrix(input));
  }

  @Test
  void testSingleElementMatrix() {
    int[][] input = {{1}};
    int[][] expected = {{1}};
    assertArrayEquals(expected, zeroStripping.zeroMatrix(input));
  }

  @Test
  void testSingleElementMatrixWithZero() {
    int[][] input = {{0}};
    int[][] expected = {{0}};
    assertArrayEquals(expected, zeroStripping.zeroMatrix(input));
  }

  @Test
  void testZeroMatrixOptimized_NullMatrix() {
    int[][] matrix = null;
    assertNull(zeroStripping.zeroMatrixOptimized(matrix));
  }

  @Test
  void testZeroMatrixOptimized_EmptyMatrix() {
    int[][] matrix = new int[0][0];
    assertArrayEquals(new int[0][0], zeroStripping.zeroMatrixOptimized(matrix));
  }

  @Test
  void testZeroMatrixOptimized_NoZeros() {
    int[][] matrix = {
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 9}
    };
    int[][] expected = {
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 9}
    };
    assertArrayEquals(expected, zeroStripping.zeroMatrixOptimized(matrix));
  }

  @Test
  void testZeroMatrixOptimized_WithZeros() {
    int[][] matrix = {
        {1, 2, 3},
        {4, 0, 6},
        {7, 8, 9}
    };
    int[][] expected = {
        {1, 0, 3},
        {0, 0, 0},
        {7, 0, 9}
    };
    assertArrayEquals(expected, zeroStripping.zeroMatrixOptimized(matrix));
  }

  @Test
  void testZeroMatrixOptimized_FirstRowZero() {
    int[][] matrix = {
        {1, 0, 3},
        {4, 5, 6},
        {7, 8, 9}
    };
    int[][] expected = {
        {0, 0, 0},
        {4, 0, 6},
        {7, 0, 9}
    };
    assertArrayEquals(expected, zeroStripping.zeroMatrixOptimized(matrix));
  }

  @Test
  void testZeroMatrixOptimized_FirstColumnZero() {
    int[][] matrix = {
        {0, 2, 3},
        {4, 5, 6},
        {7, 8, 9}
    };
    int[][] expected = {
        {0, 0, 0},
        {0, 5, 6},
        {0, 8, 9}
    };
    assertArrayEquals(expected, zeroStripping.zeroMatrixOptimized(matrix));
  }

  @Test
  void testZeroMatrixOptimized_AllZeros() {
    int[][] matrix = {
        {0, 0},
        {0, 0}
    };
    int[][] expected = {
        {0, 0},
        {0, 0}
    };
    assertArrayEquals(expected, zeroStripping.zeroMatrixOptimized(matrix));
  }


}