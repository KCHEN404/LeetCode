/**
 * 122. Best Time to Buy and Sell Stock II
 * Related Topics: DP
 */  

 /**
  * Accepted DP version
  *  
  * Time Complexity: O(n)
  * Space Complexity: O(1)
  *
  */

class Solution {
    public int maxProfit(int[] prices) {
        int res = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i + 1]) {
                res += prices[i + 1] - prices[i];
            }
        }
        return res;
    }
}