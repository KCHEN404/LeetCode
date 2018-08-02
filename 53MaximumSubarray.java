/**
 * 53. Maximum Subarray
 * Related Topics: DP
 */  

 /**
  * Accepted DP version
  *  
  * Time Complexity: O(n)
  * Space Complexity: O(n), can optimized to O(1)
  *
  */

class Solution {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        int result = nums[0];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}