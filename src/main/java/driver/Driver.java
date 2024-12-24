package driver;

import twopointers.*;

import java.util.Iterator;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

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
        Set<SortedSet<Integer>> triplets = tripleSum.findTripletForTargetSumBruteForce(numbers, targetSum);
        if (triplets == null) {
            System.out.println("No triplet found");
        }
        for (int tripletCount = 0; tripletCount < triplets.size(); tripletCount++) {
            //Iterator<Integer> treeSet = ((TreeSet<Integer>)triplets.toArray()[tripletCount]).iterator();
            System.out.println("triplet["+tripletCount+"] :" + triplets.toArray()[tripletCount]);
           /* Integer index = 0;
            while (treeSet.hasNext()) {
                System.out.println("Index["+index+"] of triplet["+tripletCount+"] :" + treeSet.next());
                index++;
            }*/
        }
    }
}
