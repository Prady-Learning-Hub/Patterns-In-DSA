import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import twopointers.*;
import java.util.Arrays;

public class TestPairSumSorted {
    private PairSumSorted pairSumSorted;


    @BeforeEach
    void setup(){
        pairSumSorted = new PairSumSorted();
    }

    @Test
    void testFindPairForTargetSum_NormalCase() {
        int[] sortedNumbers = {1, 2, 3, 4, 6};
        int target = 6;
        Integer[] expected = {1, 3}; // indices of 2 and 4
        assertArrayEquals(expected, pairSumSorted.findPairForTargetSum(sortedNumbers, target));
    }

    @Test
    void testFindPairForTargetSum_NoSolution() {
        int[] sortedNumbers = {1, 2, 3, 4, 6};
        int target = 11;
        Integer[] expected = {null, null};
        assertArrayEquals(expected, pairSumSorted.findPairForTargetSum(sortedNumbers, target));
    }

    @Test
    public void testFindPairForTargetSum_EmptyArray(){
        int []sortedNumbers = {};
        int target = 5;
        Integer[] expected = {null, null};
        assertArrayEquals( expected, pairSumSorted.findPairForTargetSum(sortedNumbers,target));
    }

    @Test
    public void testFindPairForTargetSum_NullArray(){
        int []sortedNumbers = null;
        int target = 5;
        Integer[] expected = {null, null};
        assertArrayEquals( expected, pairSumSorted.findPairForTargetSum(sortedNumbers,target));
    }

    @Test
    public void testFindPairForTargetSum_SingleElementArray(){
        int []sortedNumbers = {1};
        int target = 1;
        Integer[] expected = {null, null};
        assertArrayEquals( new Integer[2], pairSumSorted.findPairForTargetSum(sortedNumbers,target));
    }

    @Test
    public void testFindPairForTargetSum_TwoElementArray_EqualsTarget(){
        int []sortedNumbers = {2,3};
        int target = 5;
        Integer[] expected =  {0,1};
        assertArrayEquals( expected, pairSumSorted.findPairForTargetSum(sortedNumbers,target));
    }

    @Test
    public void testFindPairForTargetSum_TwoElementArray_NotEqualsTarget(){
        int []sortedNumbers = {2,4};
        int target = 5;
        Integer[] expected = {null, null};
        assertArrayEquals( expected, pairSumSorted.findPairForTargetSum(sortedNumbers,target));
    }

    @Test
    public void testFindPairForTargetSum_WithDuplicates_EqualsTarget(){
        int []sortedNumbers = {2,2,3};
        int target = 5;
        Integer[] expected = {0,1,2};

        boolean shouldBeTrue = Arrays.asList(expected).containsAll(Arrays.asList(pairSumSorted.findPairForTargetSum(sortedNumbers,target)));
        assertTrue(shouldBeTrue);
    }

    @Test
    public void testFindPairForTargetSum_WithOneNegativeNumbers(){
        int []sortedNumbers = {-1,2,3};
        int target = 2;
        Integer[] expected = {0,1,2};
        boolean shouldBeTrue = Arrays.asList(expected).containsAll(Arrays.asList(pairSumSorted.findPairForTargetSum(sortedNumbers,target)));
        assertTrue(shouldBeTrue);
    }

    @Test
    public void testFindPairForTargetSum_WithTwoNegativeNumbers(){
        int []sortedNumbers = {-3,-2,-1};
        int target = -5;
        Integer[] expected = {0,1,2};
        boolean shouldBeTrue = Arrays.asList(expected).containsAll(Arrays.asList(pairSumSorted.findPairForTargetSum(sortedNumbers,target)));
        assertTrue(shouldBeTrue);
    }

    @Test
    void testFindPairForTargetSumBruteForce_NormalCase() {
        int[] sortedNumbers = {1, 2, 3, 4, 6};
        int target = 6;
        Integer[] expected = {1, 3}; // indices of 1 and 5
        assertArrayEquals(expected, pairSumSorted.findPairForTargetSumBruteForce(sortedNumbers, target));
    }

    @Test
    void testFindPairForTargetSumBruteForce_NoSolution() {
        int[] sortedNumbers = {1, 2, 3, 4, 6};
        int target = 11;
        Integer[] expected = {null, null};
        assertArrayEquals(expected, pairSumSorted.findPairForTargetSumBruteForce(sortedNumbers, target));
    }

    @Test
    void testFindPairForTargetSumBruteForce_EmptyArray() {
        int[] sortedNumbers = {};
        int target = 5;
        Integer[] expected = {null, null};
        assertArrayEquals(expected, pairSumSorted.findPairForTargetSumBruteForce(sortedNumbers, target));
    }

    @Test
    void testFindPairForTargetSumBruteForce_NullArray() {
        int[] sortedNumbers = null;
        int target = 5;
        Integer[] expected = {null, null};
        assertArrayEquals(expected, pairSumSorted.findPairForTargetSumBruteForce(sortedNumbers, target));
    }

    @Test
    void testFindPairForTargetSumBruteForce_SingleElementArray() {
        int[] sortedNumbers = {5};
        int target = 5;
        Integer[] expected = {null, null};
        assertArrayEquals(expected, pairSumSorted.findPairForTargetSumBruteForce(sortedNumbers, target));
    }

    @Test
    void testFindPairForTargetSumBruteForce_TwoElementArray() {
        int[] sortedNumbers = {1, 5};
        int target = 6;
        Integer[] expected = {0, 1};
        assertArrayEquals(expected, pairSumSorted.findPairForTargetSumBruteForce(sortedNumbers, target));
    }

    @Test
    void testFindPairForTargetSumBruteForce_DuplicateElements() {
        int[] sortedNumbers = {1, 2, 2, 3, 5};
        int target = 4;
        Integer[] expected = {0,3,1,2}; // indices of 1 and 3
        boolean shouldBeTrue = Arrays.asList(expected).containsAll(Arrays.asList(pairSumSorted.findPairForTargetSumBruteForce(sortedNumbers,target)));
        assertTrue(shouldBeTrue);
    }

    @Test
    void testFindPairForTargetSumBruteForce_SameElementTwice() {
        int[] sortedNumbers = {1, 2, 3, 4, 5};
        int target = 6;
        Integer[] expected = {0,4,1,3};
        boolean shouldBeTrue = Arrays.asList(expected).containsAll(Arrays.asList(pairSumSorted.findPairForTargetSumBruteForce(sortedNumbers,target)));
        assertTrue(shouldBeTrue);
    }
}
