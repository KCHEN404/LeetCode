/**
 * 5. Longest Palindromic Substring
 * Related Topics: DP
 */  

 /**
  * Accepted version
  *  
  * Time Complexity: O(n^2)
  * Space Complexity: O(n)
  *
  */

class Solution {
    private int lo, max;
    public String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        for (int i = 0; i < s.length() - 1; i++) {
            getLP(s, i, i);
            getLP(s, i, i + 1);
        }
        return s.substring(lo, lo + max);
    }
    
    private void getLP(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        if (right - left - 1 > max) {
            max = right - left - 1;
            lo = left + 1;
        }
    }
}

 /**
  * DP version
  *  
  * Time Complexity: O(n^2)
  * Space Complexity: O(n^2)
  *
  */
class Solution {
    public String longestPalindrome(String s) {
      int n = s.length();
      if (n < 2) {
          return s;
      }
      String res = null;

      boolean[][] dp = new boolean[n][n];
      for (int i = n - 1; i >= 0; i--) {
          for (int j = i; j < n; j++) {
              dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);
              if(dp[i][j] == true && (res == null || res.length() < j - i + 1)) {
                  res = s.substring(i, j + 1);
              }
          }
      }
      
      return res;
    }
}