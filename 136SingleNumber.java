/**
 * 136 Single Number
 * Related Topics: Bit Manipulation / Hash Table
 */

 /**
  * My accepted version
  * Time Complexity: O(n)
  * Space Complexity: O(1)
  *
  * Basic Idea: XOR (bit manipulation)
  */

class Solution {
    public int singleNumber(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum ^ nums[i];
        }
        return sum;
    }
}

/**
 * Other version 1
 * Basic Idea: Sorting
 * Time Complexity: O(nlogn)
 * Space Complexity: O(1)
 *
 * Error Prone:
 * 1. Arrays.sort(arr);
 */

 class Solution {
    public int singleNumber(int[] nums) {
        int sum = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i%2 == 0) {
                sum += nums[i];
            } else {
                sum -= nums[i];
            }
        }
        return sum;
    }
}

/**
 * Other version 2
 * Basic Idea: Hashing
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 * Error Prone:
 * 1. Hashset: add()
 * 2. Hashset: remove()
 * 3. Hashset: iterator()
 */
class Solution {
    public int singleNumber(int[] nums) {
        HashSet<Integer> hs = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (! hs.add(nums[i])) {
                hs.remove(nums[i]);
            }
        }
        return hs.iterator().next();
    }
}