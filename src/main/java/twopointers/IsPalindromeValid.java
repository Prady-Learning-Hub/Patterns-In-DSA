package twopointers;

public class IsPalindromeValid {

  public boolean isPalindrome(String input) {
    if (input == null || input.length() <= 1) {
      return true;
    }
    int leftPointer = 0;
    int rightPointer = input.length() - 1;

    //check if the string contains only non-alphanumeric characters
    while (leftPointer < rightPointer && !Character.isLetterOrDigit(input.charAt(leftPointer))) {
      leftPointer++;
    }
    if (leftPointer >= 1 & leftPointer == rightPointer) {
      return true; // The string contains only non-alphanumeric character, which is a palindrome
    }

    while (leftPointer < rightPointer) {
      // Ignore non-alphanumeric characters from the left
      while (leftPointer < rightPointer && !Character.isLetterOrDigit(input.charAt(leftPointer))) {
        leftPointer++;
      }

      // Ignore non-alphanumeric characters from the right
      while (leftPointer < rightPointer && !Character.isLetterOrDigit(input.charAt(rightPointer))) {
        rightPointer--;
      }

      if (leftPointer >= rightPointer) {
        return true; // The string is empty or contains only one character, which is a palindrome
      }

      // Convert characters to lowercase to make the comparison case-insensitive
      char leftPointerChar = Character.toLowerCase(input.charAt(leftPointer));
      char rightPointerChar = Character.toLowerCase(input.charAt(rightPointer));

      // If the characters do not match at leftPointer and rightPointer, the string is not a palindrome
      if (leftPointerChar != rightPointerChar) {
        return false;
      }
      leftPointer++;
      rightPointer--;
    }
    return true;
  }
}
