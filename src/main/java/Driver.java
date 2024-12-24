import twopointers.*;

public class Driver {
    public static void main(String[] args) {
        PairSumSorted objPairSumSorted = new PairSumSorted();
        int []sortedNumbers = new int[]{-5,-2,3,4,6};
        int target = 7;
        Integer [] resultOptimised = objPairSumSorted.findPairForTargetSum(sortedNumbers,target);
        System.out.println("First Index : " + resultOptimised[0]);
        System.out.println("Second Index : " + resultOptimised[1]);

        Integer [] resultBruteForce = objPairSumSorted.findPairForTargetSumBruteForce(sortedNumbers,target);
        System.out.println("First Index : " + resultBruteForce[0]);
        System.out.println("Second Index : " + resultBruteForce[1]);
    }
}
