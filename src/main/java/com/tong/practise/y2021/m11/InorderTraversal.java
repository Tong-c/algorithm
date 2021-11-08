package com.tong.practise.y2021.m11;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTraversal {

    /**
     * 递归
     * @param root  根节点
     * @return  节点值列表
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> nodeVals = new ArrayList<>();
        if (null == root) {
            return nodeVals;
        }
        recursive(root, nodeVals);
        return nodeVals;
    }

    private void recursive(TreeNode root, List<Integer> nodeVals) {
        if (null == root) {
            return;
        }
        recursive(root.left, nodeVals);
        nodeVals.add(root.val);
        recursive(root.right, nodeVals);
    }


    /**
     * 迭代
     *
     * @param root 根节点
     * @return 节点值列表
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        if (null == root) {
            return new ArrayList<>();
        }
        List<Integer> values = new ArrayList<>();
        Stack<ColorNode> stack = new Stack<>();
        stack.push(new ColorNode(root, "white"));

        while (!stack.isEmpty()) {
            ColorNode cn = stack.pop();

            if (cn.color.equals("white")) {
                if (cn.node.right != null) {
                    stack.push(new ColorNode(cn.node.right, "white"));
                }
                stack.push(new ColorNode(cn.node, "gray"));
                if (cn.node.left != null) {
                    stack.push(new ColorNode(cn.node.left, "white"));
                }
            } else {
                values.add(cn.node.val);
            }
        }
        return values;
    }



    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
        }
    }

    public static class ColorNode {
        TreeNode node;
        String color;

        public ColorNode(TreeNode node, String color) {
            this.node = node;
            this.color = color;
        }
    }
}
