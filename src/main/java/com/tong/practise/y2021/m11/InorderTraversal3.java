package com.tong.practise.y2021.m11;

import com.tong.practise.y2021.m03.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTraversal3 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> nodeVals = new ArrayList<>();
        if (null == root) {
            return nodeVals;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (!stack.isEmpty() || curr != null) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            TreeNode node = stack.pop();
            nodeVals.add(node.val);
            if (node.right != null) {
                curr = node.right;
            }
        }
        return nodeVals;
    }


}
