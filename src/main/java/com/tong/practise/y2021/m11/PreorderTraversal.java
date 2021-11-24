package com.tong.practise.y2021.m11;

import com.tong.practise.y2021.m03.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PreorderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> nodeVals = new ArrayList<>();
        recursion(root, nodeVals);
        return nodeVals;
    }

    private void recursion(TreeNode node, List<Integer> nodeVals) {
        if (null == node) {
            return;
        }
        nodeVals.add(node.val);
        recursion(node.left, nodeVals);
        recursion(node.right, nodeVals);
    }

}
