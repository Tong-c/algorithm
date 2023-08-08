package com.tong.practise.y2023.m07.linklist;

import com.tong.practise.base.ListNode;

public class ReverseList {

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode p = head;
        ListNode newHead = null;
        ListNode prev = null;
        while (p != null) {
            ListNode temp = p.next;
            p.next = prev;
            prev = p;
            newHead = p;
            p = temp;
        }
        return newHead;
    }

    public static void main(String[] args) {
        ReverseList reverseList = new ReverseList();
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);

        head.next = node1;

        ListNode node = reverseList.reverseList(head);
        System.out.println(node);
    }
}
