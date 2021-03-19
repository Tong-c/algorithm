package com.tong.practise.y2021.m03;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树前中后序遍历以及按层遍历
 */
public class BSTTraversal {

    /**
     * 前序遍历
     *
     * @param root 根节点
     * @return 遍历结果
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        List<Integer> traversalResult = preTraversal(root, result);
        return null == traversalResult ? result : traversalResult;
    }

    /**
     * 中序遍历
     *
     * @param root 根节点
     * @return 遍历结果
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        List<Integer> traversalResult = inTraversal(root, result);
        return null == traversalResult ? result : traversalResult;
    }

    /**
     * 后序遍历
     *
     * @param root 根节点
     * @return 遍历结果
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        List<Integer> traversalResult = postTraversal(root, result);
        return null == traversalResult ? result : traversalResult;
    }

    /**
     * 层序遍历
     *
     * @param root 根节点
     * @return 遍历结果
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (null == root) {
            return result;
        }
        List<TreeNode> levelNodeList = new ArrayList<>();
        levelNodeList.add(root);
        while (levelNodeList.size() > 0) {
            List<TreeNode> newLevelNodeList = new ArrayList<>();
            List<Integer> levelValList = new ArrayList<>();
            for (TreeNode treeNode : levelNodeList) {
                levelValList.add(treeNode.val);
                if (null != treeNode.left) {
                    newLevelNodeList.add(treeNode.left);
                }
                if (null != treeNode.right) {
                    newLevelNodeList.add(treeNode.right);
                }
            }
            result.add(levelValList);
            levelNodeList = newLevelNodeList;
        }
        return result;
    }

    private List<Integer> inTraversal(TreeNode root, List<Integer> result) {
        if (null == root) {
            return null;
        }
        preTraversal(root.left, result);
        result.add(root.val);
        preTraversal(root.right, result);
        return result;
    }


    private List<Integer> preTraversal(TreeNode root, List<Integer> result) {
        if (null == root) {
            return null;
        }
        result.add(root.val);
        preTraversal(root.left, result);
        preTraversal(root.right, result);
        return result;
    }

    private List<Integer> postTraversal(TreeNode root, List<Integer> result) {
        if (null == root) {
            return null;
        }
        postTraversal(root.left, result);
        postTraversal(root.right, result);
        result.add(root.val);
        return result;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
