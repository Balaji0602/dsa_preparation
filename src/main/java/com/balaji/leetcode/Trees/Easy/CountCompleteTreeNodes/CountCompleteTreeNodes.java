package com.balaji.leetcode.Trees.Easy.CountCompleteTreeNodes;

import com.balaji.leetcode.Trees.TreeNode;

public class CountCompleteTreeNodes {
    int count = 0;
    public int countNodes(TreeNode root) {
        traverseNode(root);
        return count;
    }

    public void traverseNode(TreeNode node) {
        if(node == null) {
            return;
        }
        traverseNode(node.left);
        count++;
        traverseNode(node.right);
    }
}
