package com.tong.practise.y2021.m11;

import java.util.HashMap;
import java.util.Map;

public class CopyRandomList2 {

    public static Node copyRandomList(Node head) {
        if (null == head) {
            return head;
        }

        Map<Node, Node> map = new HashMap<>();
        Node currNode = head;
        while (currNode != null) {
            Node newNode = new Node(currNode.val);
            map.put(currNode, newNode);
            currNode = currNode.next;
        }

        currNode = head;
        while (currNode != null) {
            Node newNode = map.get(currNode);
            if (currNode.next != null) {
                newNode.next = map.get(currNode.next);
            }

            if (currNode.random != null) {
                newNode.random = map.get(currNode.random);
            }
            currNode = currNode.next;
        }
        return map.get(head);
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

}
