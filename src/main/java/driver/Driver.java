package driver;

import twopointers.*;

import java.util.List;

public class Driver {
    public static void main(String[] args) {
//        PairSumSorted pairSumSorted = new PairSumSorted();
//        int []sortedNumbers = {-5,-2,3,4,6};
//        int target = 7;
//        Integer [] resultOptimised = pairSumSorted.findPairForTargetSum(sortedNumbers,target);
//        System.out.println("First Index : " + resultOptimised[0]);
//        System.out.println("Second Index : " + resultOptimised[1]);
//
//        Integer [] resultBruteForce = pairSumSorted.findPairForTargetSumBruteForce(sortedNumbers,target);
//        System.out.println("First Index : " + resultBruteForce[0]);
//        System.out.println("Second Index : " + resultBruteForce[1]);

        TripleSum tripleSum = new TripleSum();
        int [] numbers = {0,-1,2,-3,1};
        int targetSum = 0;
        List<Integer[]> resultTripleSum = tripleSum.findTripletForTargetSumBruteForce(numbers, targetSum);
        if (resultTripleSum == null) {
            System.out.println("No triplet found");
        }
        for (int resultTripleSumCount = 0; resultTripleSumCount < resultTripleSum.size(); resultTripleSumCount++) {
            System.out.println("First Index of result Array " + resultTripleSumCount + " : " + resultTripleSum.get(resultTripleSumCount)[0]);
            System.out.println("Second Index of result Array " + resultTripleSumCount + " : " + resultTripleSum.get(resultTripleSumCount)[1]);
            System.out.println("Third Index of result Array " + resultTripleSumCount + " : " +  resultTripleSum.get(resultTripleSumCount)[2]);
        }
    }
}
