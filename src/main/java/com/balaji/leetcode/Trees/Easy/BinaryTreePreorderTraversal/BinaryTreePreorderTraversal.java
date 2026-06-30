package com.balaji.leetcode.Trees.Easy.BinaryTreePreorderTraversal;

import java.util.ArrayList;
import java.util.List;

import com.balaji.leetcode.Trees.TreeNode;

public class BinaryTreePreorderTraversal {
    List<Integer> resp = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null) {
            return resp;
        }
        resp.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return resp;
    }
}
