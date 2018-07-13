/**
 * 22. Generate Parentheses
 * Related Topics: String, backtracking
 */ 

 /**
  * Accepted version
  *  
  * Time Complexity: O(4^n/n^(1/2))
  * Space Complexity: O(4^n/n^(1/2))
  *
  * Basic idea: Start an opening bracket if still have one (of n) left to place
  * Start a closing bracket if it would not exceed the number of opening 
  * brackets.
  *
  * Error Prone:
  * 1. List is abstract; cannot be instantiated
  * 2. close < open, not close < max
  *
  */

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backTrack(res, "", 0, 0, n);
        return res;
    }
    
    private void backTrack(List<String> res, String str, int open, int close, int max) {
        if (str.length() == max*2) {
            res.add(str);
            return;
        }
        if (open < max) {
            backTrack(res, str+"(", open+1, close, max);
        }
        if (close < open) {
            backTrack(res, str+")", open, close+1, max);
        }
    }
}