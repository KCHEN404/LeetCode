/**
 * 171. Excel Sheet Column Number
 * Related Topics: Math
 */

 /**
  * My accepted version
  *  
  * Time Complexity: O(n)
  * Space Complexity: O(1)
  *
  * Basic idea: ascii
  *
  * Error Prone:
  * 1. convert char to int: (int) character
  *
  */

class Solution {
    public int titleToNumber(String s) {
        int sum = 0, n = s.length();
        for (int i = 0; i < n; i++) {
            sum += ((int)(s.charAt(i)) - 64) * Math.pow(26, (n-i-1));
        }
        return sum;
    }
}