/**
 * 258 Add Digits
 * Related Topics: Math
 */

 /**
  * Accepted version
  *
  * Time Complexity: O(1)
  * Space Complexity: O(1)
  *
  * Error Prone:
  * 1. If a number is divisible by 9, the sum of its digits can also be
  * divided by 9
  */

class Solution {
    public int addDigits(int num) {
        if (num == 0) {
            return 0;
        } else if (num%9 == 0) {
            return 9;
        } else {
            return num%9;
        }
    }
}