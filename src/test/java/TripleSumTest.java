import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import twopointers.TripleSum;

public class TripleSumTest {

  private TripleSum tripleSum;

  @BeforeEach
  void setUp() {
    tripleSum = new TripleSum();
  }

  @Test
  void testNormalCase() {
    int[] numbers = {1, 2, 3, 4, 5, 6};
    int target = 10;
    Set<SortedSet<Integer>> result = tripleSum.findTripletForTargetSumBruteForce(numbers, target);

    assertEquals(3, result.size());
    assertTrue(result.stream().anyMatch(set -> set.containsAll(Set.of(1, 3, 6))));
    assertTrue(result.stream().anyMatch(set -> set.containsAll(Set.of(1, 4, 5))));
    assertTrue(result.stream().anyMatch(set -> set.containsAll(Set.of(2, 3, 5))));
  }

  @Test
  void testNoSolution() {
    int[] numbers = {1, 2, 3, 4, 5};
    int target = 20;
    Set<SortedSet<Integer>> result = tripleSum.findTripletForTargetSumBruteForce(numbers, target);

    assertTrue(result.isEmpty());
  }

  @Test
  void testNullInput() {
    Set<SortedSet<Integer>> result = tripleSum.findTripletForTargetSumBruteForce(null, 10);
    assertNull(result);
  }

  @Test
  void testInsufficientElements() {
    int[] numbers = {1, 2};
    Set<SortedSet<Integer>> result = tripleSum.findTripletForTargetSumBruteForce(numbers, 6);
    assertNull(result);
  }

  @Test
  void testNegativeNumbers() {
    int[] numbers = {-1, 0, 11, 2, 5, 3};
    int target = 10;
    Set<SortedSet<Integer>> result = tripleSum.findTripletForTargetSumBruteForce(numbers, target);

    assertEquals(2, result.size());
    assertTrue(result.stream().anyMatch(set -> set.containsAll(Set.of(-1, 0, 11))));
    assertTrue(result.stream().anyMatch(set -> set.containsAll(Set.of(2, 5, 3))));
  }

  @Test
  void testDuplicateTriplets() {
    int[] numbers = {1, 1, 1, 2, 2, 3, 3};
    int target = 6;
    Set<SortedSet<Integer>> result = tripleSum.findTripletForTargetSumBruteForce(numbers, target);

    assertEquals(1, result.size());
    assertTrue(result.stream().anyMatch(set -> set.containsAll(Set.of(1, 2, 3))));
  }

  @Test
  void testLargeInput() {
    int[] numbers = new int[1000];
    for (int i = 0; i < 10; i++) {
      numbers[i] = i + 1;
    }
    int target = 1500;
    Set<SortedSet<Integer>> result = tripleSum.findTripletForTargetSumBruteForce(numbers, target);
    assertTrue(result.isEmpty());
  }

  @Test
  void testFindTripletForTargetSum_NormalCase() {
    int[] nums = {-1, 0, 1, 3, 2, -5};
    int target = 0;
    Set<SortedSet<Integer>> result = tripleSum.findTripletForTargetSum(nums, target);

    assertEquals(2, result.size());
    assertTrue(result.contains(new TreeSet<>(Set.of(-1, 0, 1))));
    assertTrue(result.contains(new TreeSet<>(Set.of(3, 2, -5))));
  }


  @Test
  void testFindTripletForTargetSum_NoSolution() {
    int[] nums = {1, 2, 3, 4, 5};
    int target = 20;
    Set<SortedSet<Integer>> result = tripleSum.findTripletForTargetSum(nums, target);

    assertTrue(result.isEmpty());
  }

  @Test
  void testFindTripletForTargetSum_NullInput() {
    Set<SortedSet<Integer>> result = tripleSum.findTripletForTargetSum(null, 0);
    assertNull(result);
  }

  @Test
  void testFindTripletForTargetSum_InsufficientElements() {
    int[] nums = {1, 2};
    Set<SortedSet<Integer>> result = tripleSum.findTripletForTargetSum(nums, 3);
    assertNull(result);
  }


  @Test
  void testFindTripletForTargetSum_AllPositiveNumbers() {
    int[] nums = {1, 2, 3, 4, 5};
    int target = 12;
    Set<SortedSet<Integer>> result = tripleSum.findTripletForTargetSum(nums, target);

    assertEquals(1, result.size());
    assertTrue(result.contains(new TreeSet<>(Set.of(3, 4, 5))));
  }

  @Test
  void testFindTripletForTargetSum_AllNegativeNumbers() {
    int[] nums = {-5, -4, -3, -2, -1};
    int target = -6;
    Set<SortedSet<Integer>> result = tripleSum.findTripletForTargetSum(nums, target);

    assertEquals(1, result.size());
    assertTrue(result.contains(new TreeSet<>(Set.of(-3, -2, -1))));
  }

  @Test
  void testFindTripletForTargetSum_LargeNumbers() {
    int[] nums = {1000000, -3000000, 2000000, -9000000, 6000000, 3000000};
    int target = 0;
    Set<SortedSet<Integer>> result = tripleSum.findTripletForTargetSum(nums, target);

    assertEquals(2, result.size());
    assertTrue(result.contains(new TreeSet<>(Set.of(-9000000, 3000000, 6000000))));
    assertTrue(result.contains(new TreeSet<>(Set.of(-3000000, 1000000, 2000000))));
  }

}