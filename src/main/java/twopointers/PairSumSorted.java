package twopointers;

public class PairSumSorted {
    public Integer[] findPairForTargetSum(int[] sortedNumbers, int target){
        Integer [] result = {null,null};
        if(sortedNumbers == null || sortedNumbers.length == 0 || sortedNumbers.length == 1){
            return result;
        }

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
                result = new Integer[]{leftPointer,rightPointer};
                return result;
            }
        }
        return result;
    }
}
