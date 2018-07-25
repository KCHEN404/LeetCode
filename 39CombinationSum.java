/**
 * 39. Combination Sum
 * Related Topics: backtracking
 */  

 /**
  * My accepted version
  *  
  * Time Complexity: at least O(k*2^n), where k is the average length of sol
  * Space Complexity: O(n)
  *
  */

class Solution {
    List<List<Integer>> res;
    List<Integer> seq;
    int sum;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        seq = new ArrayList<>();
        sum = 0;
        Arrays.sort(candidates);
        backtracking(candidates, target, 0);
        return res;
    }
    
    private void backtracking(int[] candidates, int target, int index) {
        if (sum == target) {
            List<Integer> newSeq = new ArrayList<>(seq);
            if (!res.contains(newSeq)) {
                res.add(newSeq);
            }
            return;
        }
        if (index >= candidates.length) {
            return;
        }
        if (sum + candidates[index] <= target) {
            // add cur and do not move to next index
            sum += candidates[index];
            seq.add(candidates[index]);
            backtracking(candidates, target, index);
            sum -= candidates[index];
            seq.remove(seq.size() - 1);
            
            // add cur and move to next index
            sum += candidates[index];
            seq.add(candidates[index]);
            backtracking(candidates, target, index + 1);
            sum -= candidates[index];
            seq.remove(seq.size() - 1);
            
            // don't add cur and move to next index
            backtracking(candidates, target, index + 1);
            
        } 
    }
}

 /**
  * Improved version
  *  
  * Time Complexity: at least O(k*2^n), where k is the average length of sol
  * Space Complexity: O(n)
  *
  * Error Prone:
  * 1. static global take more than to access
  * 2. ignore same num in the loop to save time
  * 3. DFS using for loop
  */

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> seq = new ArrayList<>();
        Arrays.sort(candidates);
        backtracking(candidates, target, 0, res, seq);
        return res;
    }
    
    private void backtracking(int[] candidates, int remain, int start, List<List<Integer>> res, List<Integer> seq) {
        if (remain <= 0) {
            res.add(new ArrayList<>(seq));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > remain) {
                break;
            }
            if (i > 0 && candidates[i] == candidates[i - 1]) {
                continue;
            }
            seq.add(candidates[i]);
            backtracking(candidates, remain - candidates[i], i, res, seq);
            seq.remove(seq.size() - 1);
        }
    }
}