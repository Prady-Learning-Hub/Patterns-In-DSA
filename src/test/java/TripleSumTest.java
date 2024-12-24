import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import twopointers.TripleSum;

import java.util.Set;
import java.util.SortedSet;

import static org.junit.jupiter.api.Assertions.*;

public class TripleSumTest{
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

}