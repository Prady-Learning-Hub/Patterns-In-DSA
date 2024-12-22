import twopointers.*;

public class Driver {
    public static void main(String[] args) {
        PairSumSorted objPairSumSorted = new PairSumSorted();
        int []sortedArray = new int[]{-5,-2,3,4,6};
        int target = 7;
        int [] result = objPairSumSorted.findPairForTargetSum(sortedArray,target);
        System.out.println("First Index : " + result[0]);
        System.out.println("Second Index : " + result[1]);
    }
}
