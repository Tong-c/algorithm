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

    /**
     * 层序遍历
     *
     * @param root 根节点
     * @return 遍历结果
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
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

        List<List<Integer>> bottomResult = new ArrayList<>();
        for (int i = 0; i < result.size(); i++) {
            bottomResult.add(result.get(result.size() - i - 1));
        }
        return bottomResult;
    }

    /**
     * 锯齿形层序遍历
     *
     * @param root 根节点
     * @return 遍历结果
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
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

        List<List<Integer>> zigzagResult = new ArrayList<>();
        for (int i = 0; i < result.size(); i++) {
            if (i % 2 == 1) {
                List<Integer> toReverseList = result.get(i);
                List<Integer> tempList = new ArrayList<>();
                for (int j = 0; j < toReverseList.size(); j++) {
                    tempList.add(toReverseList.get(toReverseList.size() - j - 1));
                }
                zigzagResult.add(tempList);
            } else {
                zigzagResult.add(result.get(i));
            }
        }
        return zigzagResult;
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
