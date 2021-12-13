package com.tong.practise.y2021.m12;

public class PopulateNextRightPointer {

    public Node connect(Node root) {
        if (null == root) {
            return root;
        }

        recurisive(root.left, root.right);
        return root;
    }

    private void recurisive(Node node1, Node node2) {
        if (null == node1 || null == node2) {
            return;
        }
        node1.next = node2;
        recurisive(node1.left, node1.right);
        recurisive(node2.left, node2.right);
        recurisive(node1.right, node2.left);
    }


    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

}
