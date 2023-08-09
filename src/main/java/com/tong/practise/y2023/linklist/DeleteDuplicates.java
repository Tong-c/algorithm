package com.tong.practise.y2023.linklist;

import com.tong.practise.base.ListNode;

public class DeleteDuplicates {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode p = head;
        while (p != null && p.next != null) {
            if (p.val == p.next.val) {
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;

        DeleteDuplicates deleteDuplicates = new DeleteDuplicates();
        ListNode result = deleteDuplicates.deleteDuplicates(head);
        System.out.println(result);
    }
}
