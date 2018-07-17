/**
 * 169. Majority Element
 * Related Topics: Math
 */

 /**
  * Accepted version 1
  *  
  * Time Complexity: O(n)
  * Space Complexity: O(1)
  *
  * Basic idea: Moore Voting Algorithm
  */

class Solution {
    public int majorityElement(int[] nums) {
        int major = nums[0], count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                count++;
                major = nums[i];
            } else if (major == nums[i]) {
                count++;
            } else {
                count--;
            }
        }
        return major;
    }
}

 /**
  * Accepted version 2
  *  
  * Time Complexity: O(nlogn)
  * Space Complexity: O(1)
  *
  * Basic idea: # of major elem is more than n/2, # of other elems are less
  * than n/2
  */

class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}