/**
 * 283 Move Zeros
 * Related Topics: Array, Two Pointers
 */

 /**
  * My accepted version
  * Basic Idea: 
  *
  * Time Complexity: O(n^2)
  * Space Complexity: O(1)
  *
  */

  class Solution {
    public void moveZeroes(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                for (int j = i+1; j < nums.length; j++) {
                    if (nums[j] != 0) {
                        int tmp = nums[j];
                        nums[j] = nums[i];
                        nums[i] = tmp;
                        break;
                    }
                }
            }
        }
    }
}

 /**
  * Improved version
  * Basic Idea: Two pointers
  *
  * Time Complexity: O(n)
  * Space Complexity: O(1)
  *
  */

class Solution {
    public void moveZeroes(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
        }
        while (index < nums.length) {
            nums[index] = 0;
            index++;
        }
    }
}