package com.tong.practise.y2021.m12;

import com.tong.practise.y2021.m03.TreeNode;

public class ConstructMaximumBinaryTree2 {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    private TreeNode build(int[] nums, int lo, int hi) {
        if (lo > hi) {
            return null;
        }

        int maxValue = Integer.MIN_VALUE;
        int index = 0;

        for (int i = lo; i <= hi; i++) {
            if (nums[i] > maxValue) {
                maxValue = nums[i];
                index = i;
            }
        }

        TreeNode root = new TreeNode(maxValue);
        root.left = build(nums, lo, index - 1);
        root.right = build(nums, index + 1, hi);
        return root;
    }

}

