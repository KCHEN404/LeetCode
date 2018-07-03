/**
 * 94. Binary Tree Inorder Traversal
 * Related Topics: Tree
 */

 /**
  * My accepted version
  *  
  * Time Complexity: O(n)
  * Space Complexity: O(1)
  *
  */

  class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}