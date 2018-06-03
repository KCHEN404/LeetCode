/**
 * 226 Invert Binary Tree
 * Related Topics: String
 */

 /**
  * version 1
  * Time Complexity: O(n)
  * Space Complexity: O(1)
  *
  * Error Prone:
  * 1. substring(beginning index, ending index): ending index
  *    is the index of the first char that is not included
  * 2. List<Type> list_name = new ArrayList<>();
  * 3. list.add();
  * 4. StringBuilder name = new StringBuilder();
  * 5. stringbuilder.append();
  * 6. substring is O(n)
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