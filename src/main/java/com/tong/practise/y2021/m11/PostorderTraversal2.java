package com.tong.practise.y2021.m11;

import com.tong.practise.y2021.m03.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostorderTraversal2 {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> nodeVals = new ArrayList<>();
        if (null == root) {
            return nodeVals;
        }

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);
        while (!stack1.isEmpty()) {
            TreeNode node = stack1.pop();
            stack2.push(node);

            if (node.right != null) {
                stack1.push(node.right);
            }

            if (node.left != null) {
                stack1.push(node.left);
            }
        }

        while (!stack2.isEmpty()) {
            nodeVals.add(stack2.pop().val);
        }
        return nodeVals;
    }
}
