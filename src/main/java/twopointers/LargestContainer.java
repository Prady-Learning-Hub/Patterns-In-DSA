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

  public int largestContainerTwoPointers(int[] heights) {
    int max_area = 0;
    int leftPointer = 0;
    int rightPointer = heights.length - 1;

    while(leftPointer < rightPointer) {
      int area = Math.min(heights[leftPointer], heights[rightPointer]) * (rightPointer - leftPointer);
      if(area > max_area){
        max_area = area;
      }

      //if heights[leftPointer] is smaller, move left pointer else
      //if heights[rightPointer] is smaller, move right pointer
      //if heights[leftPointer] is equal to heights[rightPointer], move both pointers towards the center

      if(heights[leftPointer] < heights[rightPointer]) {
        leftPointer++;
      } else if(heights[leftPointer] > heights[rightPointer])  {
        rightPointer--;
      }else {
        leftPointer++;
        rightPointer--;
      }
    }
    return max_area;
  }
}