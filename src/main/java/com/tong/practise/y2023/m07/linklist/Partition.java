package com.tong.practise.y2023.m07.linklist;

import com.tong.practise.base.ListNode;

public class Partition {

    public ListNode partition(ListNode head, int x) {
        ListNode pointer = head;
        ListNode dummy1 = new ListNode(-1);
        ListNode dummyP1 = dummy1;

        ListNode dummy2 = new ListNode(-1);
        ListNode dummyP2 = dummy2;

        while (pointer != null) {
            if (pointer.val < x) {
                dummyP1.next = pointer;
                dummyP1 = dummyP1.next;
            } else {
                dummyP2.next = pointer;
                dummyP2 = dummyP2.next;
            }
            pointer = pointer.next;
        }

        dummyP2.next = null;

        dummyP1.next = dummy2.next;
        return dummy1.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(2);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        Partition partition = new Partition();
        ListNode result = partition.partition(head, 3);
        System.out.println(result);
    }
}
