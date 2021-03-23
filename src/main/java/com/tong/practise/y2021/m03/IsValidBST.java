package com.tong.practise.y2021.m03;

import java.util.ArrayList;
import java.util.List;

/**
 * 验证二叉搜索树
 */
public class IsValidBST {

    /**
     * 验证二叉搜索树
     *
     * @param root 根节点
     * @return 验证结果
     */
    public boolean isValidBST(TreeNode root) {
        if (null == root) {
            return true;
        }
        List<Integer> nodeValList = new ArrayList<>();
        inOrder(root, nodeValList);
        for (int i = 1; i < nodeValList.size(); i++) {
            if (nodeValList.get(i) <= nodeValList.get(i - 1)) {
                return false;
            }
        }
        return true;
    }

    private void inOrder(TreeNode root, List<Integer> nodeValList) {
        if (null == root) {
            return;
        }
        inOrder(root.left, nodeValList);
        nodeValList.add(root.val);
        inOrder(root.right, nodeValList);
    }


}
