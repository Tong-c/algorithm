package com.tong.practise.y2021.m11;

import com.tong.practise.y2021.m03.TreeNode;

public class InvertTree {

    public TreeNode invertTree(TreeNode root) {
        if (null == root) {
            return root;
        }

        recursion(root);
        return root;
    }

    private void recursion(TreeNode node) {
        if (null == node) {
            return;
        }

        TreeNode left = node.left;
        TreeNode right = node.right;

        node.right = left;
        node.left = right;

        recursion(node.right);
        recursion(node.left);
    }
}
