package twopointers;

import java.util.ArrayList;
import java.util.List;

public class TripleSum {
    public List<Integer[]> findTripletForTargetSumBruteForce(int[] sortedNumbers, int target) {
        List<Integer[]> result = null;
        if (sortedNumbers == null || sortedNumbers.length < 3) {
            return result;
        }

        int sum;
        result = new ArrayList<>();

        for (int leftPointer = 0; leftPointer < sortedNumbers.length - 2; leftPointer++) {
            for (int middlePointer = leftPointer + 1; middlePointer < sortedNumbers.length - 1; middlePointer++) {
                for (int rightPointer = middlePointer + 1; rightPointer < sortedNumbers.length; rightPointer++) {
                    sum = sortedNumbers[leftPointer] + sortedNumbers[middlePointer] + sortedNumbers[rightPointer];
                    if (sum == target) {
                        result.add(new Integer[]{sortedNumbers[leftPointer], sortedNumbers[middlePointer], sortedNumbers[rightPointer]});
                    }
                }
            }
        }
        return result;
    }
}
