
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

import twopointers.TripleSum;

class TripleSumTest {

    private TripleSum tripleSum;

    @BeforeEach
    void setUp() {
        tripleSum = new TripleSum();
    }

    @Test
    void testNormalCase() {
        int[] numbers = {1, 2, 3, 4, 5, 6};
        int target = 10;
        List<Integer[]> result = tripleSum.findTripletForTargetSumBruteForce(numbers, target);
        
        assertEquals(3, result.size());
        assertArrayEquals(new Integer[]{1, 3, 6}, result.get(0));
        assertArrayEquals(new Integer[]{1, 4, 5}, result.get(1));
        assertArrayEquals(new Integer[]{2, 3, 5}, result.get(2));
    }

    @Test
    void testNoSolution() {
        int[] numbers = {1, 2, 3, 4, 5};
        int target = 20;
        List<Integer[]> result = tripleSum.findTripletForTargetSumBruteForce(numbers, target);
        
        assertTrue(result.isEmpty());
    }

    @Test
    void testNullInput() {
        List<Integer[]> result = tripleSum.findTripletForTargetSumBruteForce(null, 10);
        assertNull(result);
    }

    @Test
    void testInsufficientElements() {
        int[] numbers = {1, 2};
        List<Integer[]> result = tripleSum.findTripletForTargetSumBruteForce(numbers, 6);
        assertNull(result);
    }

    @Test
    void testNegativeNumbers() {
        int[] numbers = {-11, 4, 7, 3, 2, -5};
        int target = 0;
        List<Integer[]> result = tripleSum.findTripletForTargetSumBruteForce(numbers, target);
        
        assertEquals(2, result.size());
        assertArrayEquals(new Integer[]{-11, 4, 7}, result.get(0));
        assertArrayEquals(new Integer[]{3, 2, -5}, result.get(1));
    }

    /*@ParameterizedTest
    @MethodSource("provideTripletTestCases")
    void testParameterizedCases(int[] numbers, int target, int expectedSize) {
        List<Integer[]> result = tripleSum.findTripletForTargetSumBruteForce(numbers, target);
        assertEquals(expectedSize, result.size());
    }

    private static Stream<Arguments> provideTripletTestCases() {
        return Stream.of(
            Arguments.of(new int[]{5, 4, 1, 3, 8, -1}, 10, 2),
            Arguments.of(new int[]{100, 500, 900, 1000, 700, -200}, 1500, 2)

        );
    }
*/
    @Test
    void testLargeInput() {
        int[] numbers = new int[1000];
        for (int i = 0; i < 1000; i++) {
            numbers[i] = i + 1;
        }
        int target = 1500;
        List<Integer[]> result = tripleSum.findTripletForTargetSumBruteForce(numbers, target);
        assertFalse(result.isEmpty());
    }
}