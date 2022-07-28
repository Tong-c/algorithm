package com.tong.practise.y2022.m07;

import java.util.Arrays;

public class BuildTree2 {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0) {
            return null;
        }

        int rootVal = postorder[postorder.length - 1];
        int inRootIndex = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootVal) {
                inRootIndex = i;
            }
        }

        int[] postLeft = Arrays.copyOfRange(postorder, 0, inRootIndex);
        int[] postRight = Arrays.copyOfRange(postorder, inRootIndex, postorder.length - 1);

        int[] inLeft = Arrays.copyOfRange(inorder, 0, inRootIndex);
        int[] inRight = Arrays.copyOfRange(inorder, inRootIndex + 1, inorder.length);

        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree(inLeft, postLeft);
        root.right = buildTree(inRight, postRight);
        return root;
    }

    private static class TreeNode {
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

    public static void main(String[] args) {
        BuildTree2 buildTree = new BuildTree2();
        int[] postorder = {9, 15, 7, 20, 3};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode rootNode = buildTree.buildTree(inorder, postorder);
        System.out.println(rootNode);
    }
}
