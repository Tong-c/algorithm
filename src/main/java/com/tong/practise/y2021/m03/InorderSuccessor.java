package com.tong.practise.y2021.m03;

/**
 * 找出二叉搜索树中指定节点的 “下一个” 节点（也即中序后继）
 */
public class InorderSuccessor {

    /**
     * 非递归版本
     *
     * @param root 根节点
     * @param p    待查找节点
     * @return 后继节点
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode node = root;
        TreeNode parentNode = root;
        TreeNode grandParentNode = root;
        while (node != null) {
            if (node.val == p.val) {
                if (null != node.right) {
                    TreeNode tempNode = node.right;
                    while (null != tempNode) {
                        if (null == tempNode.left) {
                            return tempNode;
                        } else {
                            tempNode = tempNode.left;
                        }
                    }
                } else {
                    if (p.val < root.val) {
                        if (p.val < parentNode.val) {
                            return parentNode;
                        } else {
                            return grandParentNode;
                        }
                    } else if (p.val > root.val) {
                        if (p.val < parentNode.val) {
                            return parentNode;
                        } else {
                            return null;
                        }
                    } else {
                        return null;
                    }
                }
            } else if (node.val > p.val) {
                grandParentNode = parentNode;
                parentNode = node;
                node = node.left;
            } else {
                grandParentNode = parentNode;
                parentNode = node;
                node = node.right;
            }
        }
        return null;
    }

    /**
     * 递归版本
     *
     * @param root 根节点
     * @param p    待查找节点
     * @return 后继节点
     */
    public TreeNode inorderSuccessorRecursion(TreeNode root, TreeNode p) {
        if (null == root) {
            return null;
        }
        if (root.val <= p.val) {
            return inorderSuccessorRecursion(root.right, p);
        }
        TreeNode node = inorderSuccessorRecursion(root.left, p);
        return node == null ? root : node;
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
