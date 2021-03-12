package com.tong.practise.y2021.m03;

/**
 * 实现一个二叉查找树，并且支持插入、删除、查找操作
 */
public class TBinaryTree {

    private TreeNode root;


    /**
     * 插入
     *
     * @param data 插入数据
     */
    public void insert(int data) {
        if (null == root) {
            root = new TreeNode(data);
        } else {
            TreeNode node = root;
            while (node != null) {
                if (node.val < data) {
                    if (null == node.right) {
                        node.right = new TreeNode(data);
                        break;
                    } else {
                        node = node.right;
                    }
                } else if (node.val > data) {
                    if (null == node.left) {
                        node.left = new TreeNode(data);
                        break;
                    } else {
                        node = node.left;
                    }
                }
            }
        }
    }


    /**
     * 查找
     *
     * @param data 待查找数据
     * @return 查找到的结果
     */
    public TreeNode find(int data) {
        TreeNode node = root;
        while (node != null) {
            if (node.val == data) {
                return node;
            } else if (node.val > data) {
                node = node.left;
            } else if (node.val < data) {
                node = node.right;
            }
        }
        return null;
    }


    /**
     * 删除
     *
     * @param key 待删除数据
     */
    public TreeNode delete(TreeNode root, int key) {
        TreeNode node = root;
        String direction = null;
        TreeNode parentNode = root;
        while (node != null) {
            if (node.val == key) {
                int childNodeNum = 0;
                TreeNode left = node.left;
                TreeNode right = node.right;
                if (left == null && right == null) {
                    childNodeNum = 0;
                } else if (left != null && right != null) {
                    childNodeNum = 2;
                } else {
                    childNodeNum = 1;
                }

                if (childNodeNum == 0) {
                    if ("left".equals(direction)) {
                        parentNode.left = null;
                    } else if ("right".equals(direction)) {
                        parentNode.right = null;
                    } else {
                        if (node == root) {
                            root = null;
                        }
                        node = null;
                        parentNode = null;
                    }
                } else if (childNodeNum == 1) {
                    if ("left".equals(direction)) {
                        parentNode.left = (null == left ? right : left);
                    } else if ("right".equals(direction)) {
                        parentNode.right = (null == left ? right : left);
                    } else {
                        if (node == root) {
                            if (node.left != null) {
                                root = root.left;
                            } else if (node.right != null) {
                                root = root.right;
                            }
                        }
                    }
                } else {
                    TreeNode scanNode = right;
                    TreeNode scanParentNode = right;
                    if (right.left == null) {
                        node.val = scanNode.val;
                        scanParentNode.left = null;
                        node.right = scanNode.right;
                    } else {
                        while (scanNode != null) {
                            if (scanNode.left == null) {
                                break;
                            } else {
                                scanParentNode = scanNode;
                                TreeNode nextLeft = scanNode.left;
                                if (null != nextLeft) {
                                    scanNode = scanNode.left;
                                }
                            }
                        }

                        scanParentNode.left = scanNode.right;
                        node.val = scanNode.val;
                    }
                }
                return root;
            } else if (node.val > key) {
                parentNode = node;
                node = node.left;
                direction = "left";
            } else if (node.val < key) {
                parentNode = node;
                node = node.right;
                direction = "right";
            }
        }
        return root;
    }

    public static void main(String[] args) {
        TBinaryTree binaryTree = new TBinaryTree();
        binaryTree.insert(50);
        binaryTree.insert(30);
        binaryTree.insert(40);
        binaryTree.insert(35);
        binaryTree.insert(45);
        binaryTree.insert(19);
        System.out.println("==============");
        System.out.println("==============");
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
