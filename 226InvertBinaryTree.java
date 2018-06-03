/**
 * 226 Invert Binary Tree
 * Related Topics: String
 */

 /**
  * recusive version
  * Time Complexity: O(n)
  * Space Complexity: O(n)
  *
  * Error Prone:
  * 1. Because of recursion, O(h) function calls
  * will be placed on the stack in the worst case,
  * where h is the height of the tree. So, the 
  * space complexity is O(n).
  */

class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}

/**
 * Iterative version
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 * Error Prone:
 * 1. Queue is an interface (can't be instantiated directly)
 *    need to create an instance of a class implementing
 *    that interface
 * 2. Queue<Type> queue = new LinkedList<Type>();
 * 3. queue.add();
 * 4. queue.poll();
 * 5. queue.isEmpty();
 */

class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            TreeNode tmp = current.left;
            current.left = current.right;
            current.right = tmp;
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
        return root;
    }
}