package twopointers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class TripleSum {

  public Set<SortedSet<Integer>> findTripletForTargetSumBruteForce(int[] sortedNumbers,
      int target) {
    Set<SortedSet<Integer>> triplets = null;
    if (sortedNumbers == null || sortedNumbers.length < 3) {
      return triplets;
    }

    int sum;
    triplets = new HashSet<>();
    SortedSet<Integer> triplet;

    for (int leftPointer = 0; leftPointer < sortedNumbers.length - 2; leftPointer++) {
      for (int middlePointer = leftPointer + 1; middlePointer < sortedNumbers.length - 1;
          middlePointer++) {
        for (int rightPointer = middlePointer + 1; rightPointer < sortedNumbers.length;
            rightPointer++) {
          sum = sortedNumbers[leftPointer] + sortedNumbers[middlePointer]
              + sortedNumbers[rightPointer];
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

  public Set<SortedSet<Integer>> findTripletForTargetSum(int[] nums, int target) {
    Set<SortedSet<Integer>> triplets = null;
    //if the numbers are null or have less than 3 elements, return an empty set
    if (nums == null || nums.length < 3) {
      return triplets;
    }

    //sort the numbers in ascending order
    Arrays.sort(nums);

    //initialize the triplets set and the sum
    triplets = new HashSet<>();
    SortedSet<Integer> triplet = null;
    Set<SortedSet<Integer>> pairs = null;

    //for each number, find the two other numbers that add up to the target -ve number
    //if the sum is found, add the triplet to the set
    for (int i = 0; i < nums.length; i++) {
      //triplets consisting of only positive numbers, would never add upto to the target when target is zero
      if (target == 0 && nums[i] > 0) {
        break;
      }

      //to avoid duplicate triplets, skip the current number if it is same as the previous one
      if (i > 0 && nums[i] == nums[i - 1]) {
        continue;
      }

      //find all the pairs that add upto  target - nums[i]
      pairs = findPairsForTargetSum(nums, i + 1, target - nums[i]);
      if (pairs == null || pairs.isEmpty()) {
        continue;
      }
      for (SortedSet<Integer> pair : pairs) {
        triplet = new TreeSet<>();
        triplet.add(nums[i]);
        triplet.addAll(pair);
        triplets.add(triplet);
      }
    }

    return triplets;
  }

  private Set<SortedSet<Integer>> findPairsForTargetSum(int[] nums, int start, int target) {
    Set<SortedSet<Integer>> pairs = null;
    //if the numbers are null or have less than 2 elements, return an empty set
    if (nums == null || nums.length < 2) {
      return pairs;
    }

    pairs = new HashSet<>();
    SortedSet<Integer> pair = null;
    //initialize two pointers for the left and right ends of the array
    int left = start;
    int right = nums.length - 1;

    //while the left pointer is less than the right pointer
    while (left < right) {
      //calculate the sum of the current pair
      int sum = nums[left] + nums[right];

      //if the sum is equal to the target, add the pair to the set and move the pointers
      if (sum == target) {
        pair = new TreeSet<>();
        pair.add(nums[left]);
        pair.add(nums[right]);
        pairs.add(pair);
        left++;
        //to avoid duplicate '[b, c]' pairs, skip b if it is same as the previous number
        while (left < right && nums[left] == nums[left - 1]) {
          left++;
        }

      }
      //if the sum is less than the target, move the left pointer to the right
      else if (sum < target) {
        left++;
      }
      //if the sum is greater than the target, move the right pointer to the left
      else {
        right--;
      }
    }

    return pairs;

  }
}
