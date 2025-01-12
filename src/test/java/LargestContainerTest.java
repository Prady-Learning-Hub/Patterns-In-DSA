import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import twopointers.LargestContainer;

class LargestContainerTest {

  private LargestContainer largestContainer;

  @BeforeEach
  void setUp() {
    largestContainer = new LargestContainer();
  }

  @Test
  void testLargestContainerBruteForce_EmptyArray() {
    int[] heights = {};
    assertEquals(0, largestContainer.largestContainerBruteForce(heights));
  }

  @Test
  void testLargestContainerBruteForce_SingleElement() {
    int[] heights = {5};
    assertEquals(0, largestContainer.largestContainerBruteForce(heights));
  }

  @Test
  void testLargestContainerBruteForce_TwoElements() {
    int[] heights = {1, 8};
    assertEquals(1, largestContainer.largestContainerBruteForce(heights));
  }

  @Test
  void testLargestContainerBruteForce_MultipleElements() {
    int[] heights = {1, 8, 6, 2, 5, 4, 8, 3, 7};
    assertEquals(49, largestContainer.largestContainerBruteForce(heights));
  }

  @Test
  void testLargestContainerBruteForce_AllSameHeight() {
    int[] heights = {5, 5, 5, 5, 5};
    assertEquals(20, largestContainer.largestContainerBruteForce(heights));
  }
}