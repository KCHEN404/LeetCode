/**
 * 238. Product of Array Except Self
 * Related Topics: Array
 */

 /**
  * Accepted version
  *  
  * Time Complexity: O(n)
  * Space Complexity: O(1)
  *
  * Basic idea: one pass from the left, one pass from the right
  *
  */

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int right = 1, n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i-1] * nums[i-1];
        }
        for (int i = n-1; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i];
        }
        return res;
    }
}