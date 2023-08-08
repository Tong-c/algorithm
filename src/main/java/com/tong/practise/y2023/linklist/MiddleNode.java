package com.tong.practise.y2023.linklist;

import com.tong.practise.base.ListNode;

public class MiddleNode {

    public ListNode middleNode(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode fastP = head;
        ListNode slowP = head;
        while (fastP != null && fastP.next != null) {
            slowP = slowP.next;
            fastP = fastP.next.next;
        }
        return slowP;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(6);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        MiddleNode middleNode = new MiddleNode();
        ListNode node = middleNode.middleNode(head);
        System.out.println(node);
    }
}
