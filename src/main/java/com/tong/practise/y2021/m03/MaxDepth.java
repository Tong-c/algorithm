package com.tong.practise.y2021.m03;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的最大深度
 */
public class MaxDepth {


    /**
     * 广度优先
     *
     * @param root 根节点
     * @return 最大深度
     */
    public int bfsMaxDepth(TreeNode root) {
        int maxDepth = 0;
        if (null == root) {
            return 0;
        }
        List<TreeNode> levelNodeList = new ArrayList<>();
        levelNodeList.add(root);
        while (levelNodeList.size() > 0) {
            maxDepth++;
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
        return maxDepth;
    }


    /**
     * 深度优先
     *
     * @param root 根节点
     * @return 最大深度
     */
    public int dfsMaxDepth(TreeNode root) {
        if (null == root) {
            return 0;
        }
        int leftHeight = dfsMaxDepth(root.left);
        int rightHeight = dfsMaxDepth(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
