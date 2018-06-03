/**
 * 292 Nim Game
 * Related Topics: Brainteaser
 */

 /**
  * Math version
  * Time Complexity: O(1)
  * Space Complexity: O(1)
  *
  * Error Prone:
  * 1. If n = 4, always lose. If n = 5, remove one stone and there are 4 stones
  * for another player - win. If n = 6 or 7, remove 2 or 3 stones - win. If
  * n = 8, no matter how many stones removed, there are 7 or 6 or 5 stones for
  * another player - lose. So the rule is n%4.
  * 2. Can use DP to solve this problem.
  */

class Solution {
    public boolean canWinNim(int n) {
        return (n%4 != 0);
    }
}