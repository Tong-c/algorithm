package com.tong.practise.y2021.m11;

import com.tong.practise.y2021.m03.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreorderTraversal3 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> nodeVals = new ArrayList<>();
        if (root == null) {
            return nodeVals;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            nodeVals.add(node.val);
            if (null != node.right) {
                stack.push(node.right);
            }

            if (null != node.left) {
                stack.push(node.left);
            }
        }
        return nodeVals;
    }
}
