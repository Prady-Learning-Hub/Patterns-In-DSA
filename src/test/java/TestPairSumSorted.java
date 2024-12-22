import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import twopointers.PairSumSorted;

public class TestPairSumSorted {
    @Test
    public void testWithInputSortedArrayEmpty(){
        PairSumSorted objPairSumSorted = new PairSumSorted();
        int []sortedArray = new int[]{};
        int target = 0;
        int []result = objPairSumSorted.findPairForTargetSum(sortedArray,target);
        assertArrayEquals( new int[2],result);
    }

    @Test
    public void testWithInputSortedArrayOneElement(){
        PairSumSorted objPairSumSorted = new PairSumSorted();
        int []sortedArray = new int[]{1};
        int target = 1;
        int []result = objPairSumSorted.findPairForTargetSum(sortedArray,target);
        assertArrayEquals( new int[2],result);
    }

    @Test
    public void testWithInputSortedArrayTwoElementsEqualsTarget(){
        PairSumSorted objPairSumSorted = new PairSumSorted();
        int []sortedArray = new int[]{2,3};
        int target = 5;
        int []result = objPairSumSorted.findPairForTargetSum(sortedArray,target);
        assertArrayEquals( new int[]{0,1},result);
    }

    @Test
    public void testWithInputSortedArrayTwoElementsNotEqualsTarget(){
        PairSumSorted objPairSumSorted = new PairSumSorted();
        int []sortedArray = new int[]{2,4};
        int target = 5;
        int []result = objPairSumSorted.findPairForTargetSum(sortedArray,target);
        assertArrayEquals( new int[2],result);
    }
}
