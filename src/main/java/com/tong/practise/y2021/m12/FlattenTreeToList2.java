package com.tong.practise.y2021.m12;

import com.tong.practise.y2021.m03.TreeNode;

public class FlattenTreeToList2 {

    public void flatten(TreeNode root) {
        if (null == root) {
            return;
        }

        flatten(root.left);
        flatten(root.right);

        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = null;
        root.right = left;

        TreeNode p = root;
        while (p.right != null) {
            p = p.right;
        }
        p.right = right;
    }
}
