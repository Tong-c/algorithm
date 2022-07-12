package com.tong.practise.y2021.m12;

import com.tong.practise.y2021.m03.TreeNode;

public class ConstructMaximumBinaryTree {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    private TreeNode build(int[] nums, int lo, int hi) {
        if (lo > hi) {
            return null;
        }

        int index = -1;
        int maxValue = Integer.MIN_VALUE;
        for (int i = lo; i <= hi; i++) {
            if (maxValue < nums[i]) {
                index = i;
                maxValue = nums[i];
            }
        }

        TreeNode root = new TreeNode(maxValue);
        root.left = build(nums, lo, index - 1);
        root.right = build(nums, index + 1, hi);
        return root;
    }
}
