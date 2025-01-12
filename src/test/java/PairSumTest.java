import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import hashmapandsets.PairSum;


public class PairSumTest {
  private PairSum pairSum;

  @BeforeEach
  void setUp() {
    pairSum = new PairSum();
  }

  @Test
  void testFindPairSumUnSorted_NormalCase() {
    int[] nums = {2, 7, 11, 15};
    int target = 9;
    int[] expected = {0, 1};
    assertArrayEquals(expected, pairSum.findPairSumUnSorted(nums, target));
  }

  @Test
  void testFindPairSumUnSorted_NoSolution() {
    int[] nums = {2, 7, 11, 15};
    int target = 30;
    int[] expected = {0, 0};
    assertArrayEquals(expected, pairSum.findPairSumUnSorted(nums, target));
  }

  @Test
  void testFindPairSumUnSorted_EmptyArray() {
    int[] nums = {};
    int target = 10;
    int[] expected = {0, 0};
    assertArrayEquals(expected, pairSum.findPairSumUnSorted(nums, target));
  }
  @Test
  void testFindPairSumUnSorted_SingleElementArray() {
    int[] nums = {5};
    int target = 5;
    int[] expected = {0, 0};
    assertArrayEquals(expected, pairSum.findPairSumUnSorted(nums, target));
  }

  @Test
  void testFindPairSumUnSorted_NegativeNumbers() {
    int[] nums = {-1, -2, -3, -4, -5};
    int target = -9;
    int[] expected = {3, 4};
    assertArrayEquals(expected, pairSum.findPairSumUnSorted(nums, target));
  }

  @Test
  void testFindPairSumSortedSinglePass_NormalCase() {
    int[] nums = {2, 7, 11, 15};
    int target = 9;
    int[] expected = {0, 1};
    assertArrayEquals(expected, pairSum.findPairSumSortedSinglePass(nums, target));
  }

  @Test
  void testFindPairSumSortedSinglePass_NoSolution() {
    int[] nums = {2, 7, 11, 15};
    int target = 30;
    int[] expected = {0, 0};
    assertArrayEquals(expected, pairSum.findPairSumSortedSinglePass(nums, target));
  }

  @Test
  void testFindPairSumSortedSinglePass_EmptyArray() {
    int[] nums = {};
    int target = 10;
    int[] expected = {0, 0};
    assertArrayEquals(expected, pairSum.findPairSumSortedSinglePass(nums, target));
  }

  @Test
  void testFindPairSumSortedSinglePass_SingleElementArray() {
    int[] nums = {5};
    int target = 5;
    int[] expected = {0, 0};
    assertArrayEquals(expected, pairSum.findPairSumSortedSinglePass(nums, target));
  }


  @Test
  void testFindPairSumSortedSinglePass_NegativeNumbers() {
    int[] nums = {-1, -2, -3, -4, -5};
    int target = -9;
    int[] expected = {3, 4};
    assertArrayEquals(expected, pairSum.findPairSumSortedSinglePass(nums, target));
  }

  @Test
  void testFindPairSumSortedSinglePass_TargetSumAtEnds() {
    int[] nums = {1, 2, 3, 4, 7};
    int target = 8;
    int[] expected = {0, 4};
    assertArrayEquals(expected, pairSum.findPairSumSortedSinglePass(nums, target));
  }
}
