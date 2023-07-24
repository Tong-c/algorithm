package com.tong.practise.y2021.m03;


import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树中的最大路径和
 */
public class MaxPathSum {

    private int max;

    /**
     * 二叉树中的最大路径和
     *
     * @param root 根节点
     * @return 最大路径和
     */
    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        dfs(root);
        return max;
    }


    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftMax = Math.max(0, dfs(node.left));
        int rightMax = Math.max(0, dfs(node.right));
        max = Math.max(max, leftMax + rightMax + node.val);
        return Math.max(leftMax, rightMax) + node.val;
    }

    public static void main(String[] args) {
        MaxPathSum maxPathSum = new MaxPathSum();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        maxPathSum.maxPathSum(root);
    }
}
