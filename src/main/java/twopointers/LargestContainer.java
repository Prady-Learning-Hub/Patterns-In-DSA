package twopointers;

public class LargestContainer {

  public int largestContainerBruteForce(int[] heights) {
    int max_area = 0;

    for (int i = 0; i < heights.length; i++) {
      for (int j = i + 1; j < heights.length; j++) {
        int current_area = Math.min(heights[i], heights[j]) * (j - i); // Fixed: (j - i) instead of (j - 1)
        if (current_area > max_area) {
          max_area = current_area;
        }
      }
    }
    
    return max_area;
  }
}