package com.balaji.leetcode.Trees.Easy.BinaryTreePostorderTraversal;

import java.util.ArrayList;
import java.util.List;

import com.balaji.leetcode.Trees.TreeNode;

public class BinaryTreePostorderTraversal {
    List<Integer> resp = new ArrayList<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return resp;
        }
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        resp.add(root.val);
        return resp;
    }
}
