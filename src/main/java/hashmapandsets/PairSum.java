package hashmapandsets;

import java.util.HashMap;
import java.util.Map;

public class PairSum {
  public int[] findPairSumUnSorted(int[] nums, int target){
    int[] result = new int[2];
    Map<Integer, Integer> num_map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      num_map.put(nums[i], i);
    }
    for (int i = 0; i < nums.length; i++) {
      int complement = target - nums[i];
      if(num_map.containsKey(complement) && num_map.get(complement) != i){
        result[0] = num_map.get(complement);
        result[1] = i;
      }
    }
    return result;
  }

  public int[] findPairSumSortedSinglePass(int[] nums, int target){
    int[] result = new int[2];
    Map<Integer, Integer> num_map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int complement = target - nums[i];
      if(num_map.containsKey(complement)){
       result[0] = num_map.get(complement);
       result[1] = i;
       return result;
      }
      num_map.put(nums[i], i);
    }
    return result;
  }
}
