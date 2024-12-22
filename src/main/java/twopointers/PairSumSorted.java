package twopointers;

public class PairSumSorted {
    public int[] findPairForTargetSum(int[] sortedNumbers, int target){
        int [] result = new int[2];
        int sum ;
        int leftPointer = 0;
        int rightPointer = sortedNumbers.length - 1;
        while(leftPointer < rightPointer){
            sum = sortedNumbers[leftPointer] + sortedNumbers[rightPointer];

            // if the sum is smaller, increment the left pointer ,
            // aiming to increase the sum towards the target value
            if(sum < target){
                leftPointer++;
            }
            //if the sum is larger, decrement the right pointer,
            //aiming to decrease the sum towards the target value
            else if(sum > target){
                rightPointer --;
            }
            //if the target pair is found, return its indexes
            else{
                result[0] = leftPointer;
                result[1] = rightPointer;
                return result;
            }
        }
        return result;
    }
}
