package com.tong.practise.y2021.m11;


public class CopyRandomList {

    public static Node copyRandomList(Node head) {
        if (null == head) {
            return head;
        }
        Node currNode = head;
        while (null != currNode) {
            int currVal = currNode.val;
            Node currRandom = currNode.random;

            Node newNode = new Node(currVal);
            newNode.random = currRandom;
            newNode.next = currNode.next;

            Node nextNode = currNode.next;

            currNode.next = newNode;
            currNode = nextNode;
        }

        currNode = head;
        while (null != currNode && null != currNode.next) {
            Node newNode = currNode.next;
            Node random = currNode.random;
            if (null != random) {
                Node newRandomNode = random.next;
                newNode.random = newRandomNode;
            }

            currNode = currNode.next.next;
        }

        Node dummyNode = new Node(-1);
        Node dummyPtr = dummyNode;
        currNode = head;
        Node dummyOldNode = new Node(-1);
        Node dummyOldPtr = dummyOldNode;
        int i = 0;
        Node prevLastNode = null;
        while (null != currNode) {
            i++;
            if (i % 2 == 0) {
                dummyPtr.next = currNode;
                dummyPtr = dummyPtr.next;
            } else {
                dummyOldPtr.next = currNode;
                dummyOldPtr = dummyOldPtr.next;
            }
            if (null != currNode.next && null == currNode.next.next) {
                prevLastNode = currNode;
            }
            currNode = currNode.next;
        }
        prevLastNode.next = null;
        head = dummyOldNode.next;
        return dummyNode.next;
    }


    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static void main(String[] args) {
        Node node1 = new Node(7);
        Node node2 = new Node(13);
        Node node3 = new Node(11);
        Node node4 = new Node(10);
        Node node5 = new Node(1);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        node1.random = null;
        node2.random = node1;
        node3.random = node5;
        node4.random = node3;
        node5.random = node1;

        copyRandomList(node1);
    }
}
