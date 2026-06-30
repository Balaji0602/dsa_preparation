package com.balaji.leetcode.Trees.Easy.LevelOrderTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.balaji.leetcode.Trees.TreeNode;

public class LevelOrderTraversal {
    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            List<Integer> row = new ArrayList<>();
            int size = queue.size();
            for(int i = 0; i<size; i++) {
                TreeNode current = queue.poll();
                row.add(current.val);
                if(current.left != null) {
                    queue.add(current.left);
                } 
                if(current.right != null) {
                    queue.add(current.right);
                }
            }
            list.add(row);
        }
        return list;
    }
}
