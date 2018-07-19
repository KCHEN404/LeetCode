/**
 * 17. Letter Combinations of a Phone Number
 * Related Topics: backtracking
 */  

 /**
  * Accepted version
  *  
  * Time Complexity: at least O(n*4^n) -> 4^n results, each takes O(n) time
  * Space Complexity: O(n*4^n)
  *
  * Error Prone:
  * 1. need to check the case which the input is empty
  * 2. String number to Int: int num = Integer.parseInt(string)
  *
  */

class Solution {
    String[][] mapping = {{"a","b","c"}, {"d","e","f"}, {"g","h","i"},
    {"j","k","l"}, {"m","n","o"}, {"p","q","r","s"}, {"t","u","v"},
    {"w","x","y","z"}};
    
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) {
            return res;
        }
        backtracking(res, digits, new String());
        return res;
    }
    
    private void backtracking(List res, String digits, String comb) {
        if (comb.length() == digits.length()) {
            res.add(comb);
            return;
        }
        int num = Integer.parseInt(digits.substring(comb.length(),
            comb.length()+1));
        for(String letter: mapping[num-2]) {
            backtracking(res, digits, comb+letter);
        }
    }
}