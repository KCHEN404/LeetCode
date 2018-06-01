/**
 * 136 Single Number
 * Related Topics: Bit Manipulation
 */

 /**
  * My accepted version
  * Time Complexity: O(n)
  * Space Complexity: O(1)
  *
  * Basic Idea: XOR (bit manipulation)
  */
  
class Solution {
    public int singleNumber(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum ^ nums[i];
        }
        return sum;
    }
}