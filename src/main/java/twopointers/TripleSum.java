package twopointers;

import java.util.*;

public class TripleSum {
    public Set<SortedSet<Integer>> findTripletForTargetSumBruteForce(int[] sortedNumbers, int target) {
        Set<SortedSet<Integer>> triplets = null;
        if (sortedNumbers == null || sortedNumbers.length < 3) {
            return triplets;
        }

        int sum;
        triplets = new HashSet<>();
        SortedSet<Integer> triplet;

        for (int leftPointer = 0; leftPointer < sortedNumbers.length - 2; leftPointer++) {
            for (int middlePointer = leftPointer + 1; middlePointer < sortedNumbers.length - 1; middlePointer++) {
                for (int rightPointer = middlePointer + 1; rightPointer < sortedNumbers.length; rightPointer++) {
                    sum = sortedNumbers[leftPointer] + sortedNumbers[middlePointer] + sortedNumbers[rightPointer];
                    if (sum == target) {
                        triplet = new TreeSet<>();
                        triplet.add(sortedNumbers[leftPointer]);
                        triplet.add(sortedNumbers[middlePointer]);
                        triplet.add(sortedNumbers[rightPointer]);
                        triplets.add(triplet);
                    }
                }
            }
        }
        return triplets;
    }
}
