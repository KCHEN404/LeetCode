/**
 * 260 Single Number III
 * Related Topics: Bit Manipulation
 */

 /**
  * Accepted version
  * Basic Idea: XOR twice. In the first XOR, we get the XOR of the two numbers
  * we need to find. Since the two numbers are distinct, there must be a set
  * bit (value 1) in the XOR result. Find out an arbitrary set bit. In the
  * second XOR, we divide all numbers into two groups, one with the
  * aforementioned bit set, another with the aforementinoed bit unset. Two
  * different numbers we need to find must fall into the two distrinct groups.
  * XOR numbers in each group, we can find a number in either group.
  * Note: Idea credit to zhiqing_xiao on LeetCode.
  *
  * Time Complexity: O(n)
  * Space Complexity: O(1)
  *
  * Error Prone:
  * 1. diff &= -diff:
  * the original formula to get the last set bit is diff &= ~(diff - 1).
  * The diff &= -diff is an abbreviation with the knowledge of ~(diff - 1)
  * = - (diff - 1) - 1 = -diff.
  */

  class Solution {
    public int[] singleNumber(int[] nums) {
        int diff = 0;
        for (int num: nums) {
            diff ^= num;
        }
        diff &= -diff;
        int[] res = {0,0};
        for (int num: nums) {
            if ((diff & num) == 0) {
                res[0] ^= num;
            } else {
                res[1] ^= num;
            }
        }
        return res;
    }
}
  