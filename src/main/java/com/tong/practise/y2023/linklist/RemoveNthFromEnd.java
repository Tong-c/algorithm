package com.tong.practise.y2023.linklist;

import com.tong.practise.base.ListNode;

public class RemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p1 = dummy;

        int step = 0;
        while (p1 != null) {
            p1 = p1.next;
            step++;
            if (step == n + 1) {
                break;
            }
        }

        ListNode p2 = dummy;
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        p2.next = p2.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        RemoveNthFromEnd removeNthFromEnd = new RemoveNthFromEnd();
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode head2 = new ListNode(1);
        ListNode node = removeNthFromEnd.removeNthFromEnd(head2, 1);
        System.out.println(node);
    }
}
