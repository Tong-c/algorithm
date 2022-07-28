package com.tong.practise.y2022.m07;

import java.util.Arrays;

public class BuildTree12 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }

        int rootVal = preorder[0];
        int inRootIndex = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootVal) {
                inRootIndex = i;
            }
        }

        int[] preLeft = Arrays.copyOfRange(preorder, 1, inRootIndex + 1);
        int[] preRight = Arrays.copyOfRange(preorder, inRootIndex + 1, preorder.length);

        int[] inLeft = Arrays.copyOfRange(inorder, 0, inRootIndex);
        int[] inRight = Arrays.copyOfRange(inorder, inRootIndex + 1, inorder.length);

        TreeNode node = new TreeNode(rootVal);
        node.left = buildTree(preLeft, inLeft);
        node.right = buildTree(preRight, inRight);
        return node;
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
        BuildTree12 buildTree = new BuildTree12();
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode rootNode = buildTree.buildTree(preorder, inorder);
        System.out.println(rootNode);
    }
}
