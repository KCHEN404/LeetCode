/**
 * 46. Permutations
 * Related Topics: backtracking
 */  

 /**
  * Accepted version
  *  
  * Time Complexity: at least O(n*n!) -> n! permutations, each permutation
  * takes O(n) time
  * Space Complexity: O(n*n!)
  *
  * Error Prone:
  * 1. List<List<Integer>> res = new ArrayList<>(); not List<List<Integer>>
  * res = new ArrayList<ArrayList<Integer>>();
  * 2. res.add(new ArrayList<Integer>(temp)); not res.add(temp); temp will
  * be changed later in its own and other function calls, need to make a new
  * copy and add the copy into the return list.
  * 3. temp.remove(temp.size()-1); need to remove the last letter and try
  * permutations
  *
  */


class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtracking(res, new ArrayList<>(), nums);
        return res;
    }
    
    private void backtracking(List res, ArrayList temp, int[] nums) {
        if (temp.size() == nums.length) {
            res.add(new ArrayList<Integer>(temp));
        } else {
            for (int i = 0; i< nums.length; i++) {
                if (temp.contains(nums[i])) {
                    continue;
                } else {
                    temp.add(nums[i]);
                    backtracking(res, temp, nums);
                    temp.remove(temp.size()-1);
                }
            }
        }
        
    }
}