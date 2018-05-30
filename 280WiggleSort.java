/**
 * 280. Wiggle Sort
 * Related Topics: Array. Sort.
 */

/**
 * My accepted version
 *  Time Complexity: O(nlogn)
 * Space Complexity: O(1)
 *
 * Error prone:
 * 1. input []
 */
class Solution {
    public void wiggleSort(int[] nums) {
        if (nums.length != 0) {
            quicksort(nums, 0, nums.length - 1);
            int tmp;
            int copy[] = nums.clone();
            int m = 0, n = copy.length - 1;
            for(int i = 0; i < copy.length; i++) {
                if (i%2 == 0){
                    nums[i] = copy[m];
                    m++;
                } else {
                    nums[i] = copy[n];
                    n--;
                }
            }
        }
    }
    
    public int partition(int[] nums, int left, int right) {
        int tmp;
        int i = left, j = right; 
        int pivot = nums[(left + right)/2];
        
        while (i <= j) {
            while(nums[i] < pivot) {
                i++;
            }
            while (nums[j] > pivot) {
                j--;
            }
            if (i <= j) {
                tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                i++;
                j--;
            }
        }
        return i;
    }
    
    public void quicksort(int[] nums, int left, int right) {
        int index = partition(nums, left, right);
        if (left < index - 1) {
            quicksort(nums, left, index - 1);
        }
        if (right > index) {
            quicksort(nums, index, right);
        }
    }
}

/**
 * Improved version
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
class Solution {
    public void wiggleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (i%2 == 0) {
                if (nums[i] > nums[i+1]) {
                    int tmp = nums[i];
                    nums[i] = nums[i+1];
                    nums[i+1] = tmp;
                }
            } else {
                if (nums[i] < nums[i+1]) {
                    int tmp = nums[i];
                    nums[i] = nums[i+1];
                    nums[i+1] = tmp; 
                }
            }
        }
    }
}

/**
 * Improved version 2
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

 class Solution {
    public void wiggleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if ((i%2 == 0) == (nums[i] > nums[i+1])) {
                int tmp = nums[i];
                nums[i] = nums[i+1];
                nums[i+1] = tmp;
            } 
        }
    }
}