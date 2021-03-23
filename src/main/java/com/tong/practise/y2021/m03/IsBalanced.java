package com.tong.practise.y2021.m03;

import java.util.ArrayList;
import java.util.List;

/**
 * 平衡二叉树
 */
public class IsBalanced {

    /**
     * 判断是否是平衡二叉树
     *
     * @param root 根节点
     * @return 是否是平衡二叉树
     */
    public boolean isBalanced(TreeNode root) {
        if (null == root) {
            return false;
        }
        List<TreeNode> allNodeList = new ArrayList<>();
        List<TreeNode> levelNodeList = new ArrayList<>();
        levelNodeList.add(root);
        allNodeList.add(root);
        while (levelNodeList.size() > 0) {
            List<TreeNode> currLevelNodeList = new ArrayList<>();
            for (TreeNode node : levelNodeList) {
                if (null != node.left) {
                    currLevelNodeList.add(node.left);
                }
                if (null != node.right) {
                    currLevelNodeList.add(node.right);
                }
                allNodeList.addAll(currLevelNodeList);
                levelNodeList = currLevelNodeList;
            }
        }

        for (TreeNode node : allNodeList) {
            if (!isNodeBalanced(node)) {
                return false;
            }
        }
        return true;
    }

    private boolean isNodeBalanced(TreeNode node) {
        int leftHeight = depth(node.left);
        int rightHeight = depth(node.right);
        if (leftHeight - rightHeight > 1 || rightHeight - leftHeight > 1) {
            return false;
        }
        return true;
    }

    private int depth(TreeNode node) {
        int depth = 0;
        if (null == node) {
            return 0;
        }
        List<TreeNode> levelNodeList = new ArrayList<>();
        levelNodeList.add(node);
        while (levelNodeList.size() > 0) {
            depth++;
            List<TreeNode> currLevelNodeList = new ArrayList<>();
            for (TreeNode treeNode : levelNodeList) {
                if (null != treeNode.left) {
                    currLevelNodeList.add(treeNode.left);
                }
                if (null != treeNode.right) {
                    currLevelNodeList.add(treeNode.right);
                }
            }
            levelNodeList = currLevelNodeList;
        }
        return depth;
    }

}
