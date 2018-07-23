/**
 * 10. Regular Expression Matching
 * Related Topics: backtracking, DP
 */  

 /**
  * Accepted Bottom up version
  *  
  * Time Complexity: at least O(n*n)
  * Space Complexity: O(n*n)
  *
  * Error Prone:
  * 1. dp[i][j] corresponds to t.charAt(i - 1) and p.charAt(j - 1)
  * 2. reference: http://shmilyaw-hotmail-com.iteye.com/blog/2282539
  */

class Solution {
    public boolean isMatch(String text, String pattern) {
        boolean[][] dp = new boolean[text.length() + 1][pattern.length() + 1]; // one row and one column for 0
        dp[0][0] = true; // base case
        
        // fill in values for 0 text a*b* pattern
        for (int i = 1; i <= pattern.length(); i++) {
            if (pattern.charAt(i - 1) == '*') {
                dp[0][i] = dp[0][i - 2];
            }
        }
        
        //bottom up
        for (int i = 1; i <= text.length(); i++) {
            for (int j = 1; j <= pattern.length(); j++) {
                if (pattern.charAt(j - 1) == text.charAt(i - 1) || pattern.charAt(j - 1) == '.') { // two chars match, or p is '.'
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pattern.charAt(j - 1) == '*') {
                    // 1. * match one or more times
                    // 2. .* -> multiple '.'
                    // 3. * match 0 time
                    dp[i][j] = dp[i - 1][j] && (pattern.charAt(j - 2) == text.charAt(i - 1) || pattern.charAt(j - 2) == '.') || dp[i][j - 2];
                }
        }
        }
        
        return dp[text.length()][pattern.length()];
    }
}