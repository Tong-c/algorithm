package com.tong.practise.y2022.m07;

import java.util.Arrays;

public class BuildTree1 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[0]);
        int num = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == root.val) {
                num = i;
            }
        }

        int[] preLeft = Arrays.copyOfRange(preorder, 1, num + 1);
        int[] preRight = Arrays.copyOfRange(preorder, num + 1, preorder.length);

        int[] inLeft = Arrays.copyOfRange(inorder, 0, num);
        int[] inRight = Arrays.copyOfRange(inorder, num + 1, inorder.length);
        root.left = buildTree(preLeft, inLeft);
        root.right = buildTree(preRight, inRight);
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
        BuildTree1 buildTree = new BuildTree1();
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode rootNode = buildTree.buildTree(preorder, inorder);
        System.out.println(rootNode);
    }
}
