import java.util.*;

import com.balaji.leetcode.Trees.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class BinaryTreeInOrderTraversal {

    List<Integer> resp = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return resp;
        }
        inorderTraversal(root.left);
        resp.add(root.val);
        inorderTraversal(root.right);
        return resp;
    }
}
