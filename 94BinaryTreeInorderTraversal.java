/**
 * 94. Binary Tree Inorder Traversal
 * Related Topics: Tree
 */

 /**
  * My accepted version
  *  
  * Time Complexity: O(n)
  * Space Complexity: O(n)
  * 
  * Basic idea: recursion
  *
  */

  class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root,res);
        return res;
    }
    
    private void inorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }
}