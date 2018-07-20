/**
 * 89. Gray Code
 * Related Topics: backtracking, bit operation
 */  

 /**
  * Accepted version
  *  
  * Time Complexity: O(n)
  * Space Complexity: O(1)
  *
  * Error Prone:
  * 1. formula: G(i) = i^(i/2)
  * 2. num << n : move num left by n bits, equal to num*(2^n)
  * 3. num >> n : move num right by n bits, equal to num/(2^n)
  *
  */

class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < 1 << n; i++) {
            res.add(i^i>>1);
        }
        return res;
    }
}