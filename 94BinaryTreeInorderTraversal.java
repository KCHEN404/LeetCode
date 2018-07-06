/**
 * 94. Binary Tree Inorder Traversal
 * Related Topics: Tree
 */

 /**
  * Recursive version
  *  
  * Time Complexity: O(n)
  * Space Complexity: O(n)
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

 /**
  * Iterative version
  *  
  * Time Complexity: O(n)
  * Space Complexity: O(n)
  * 
  * Error Prone:
  * 1. stack class in java
  * 2. stack.push()
  * 3. stack.pop()
  * 4. stack.empty()
  * 5. stack.peek()
  * 6. stack.search()
  *
  */

import java.io.*;
import java.util.*;

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stk = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stk.empty()) {
            if (cur != null) {
                stk.push(cur);
                cur = cur.left;
            } else {
                cur = stk.pop();
                res.add(cur.val);
                cur = cur.right;
            }
        }
        return res;
    }
}