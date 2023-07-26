package com.tong.practise.y2023.m07.linklist;

import com.tong.practise.base.ListNode;

public class GetKthFromEnd {

    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        ListNode p1 = head;
        int step = 0;
        while (p1 != null) {
            p1 = p1.next;
            step++;
            if (step == k) {
                break;
            }
        }

        ListNode p2 = head;
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p2;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;

        GetKthFromEnd getKthFromEnd = new GetKthFromEnd();
        ListNode kthFromEnd = getKthFromEnd.getKthFromEnd(head, 2);
        System.out.println(kthFromEnd);
    }
}
