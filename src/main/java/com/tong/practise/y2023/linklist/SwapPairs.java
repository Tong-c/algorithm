package com.tong.practise.y2023.linklist;

import com.tong.practise.base.ListNode;

public class SwapPairs {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode next = head.next;
        ListNode tmp = head.next.next;
        head.next.next = head;
        head.next = tmp;

        head.next = swapPairs(head.next);
        return next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;

        SwapPairs swapPairs = new SwapPairs();
        ListNode result = swapPairs.swapPairs(head);
        System.out.println(result);
    }
}
