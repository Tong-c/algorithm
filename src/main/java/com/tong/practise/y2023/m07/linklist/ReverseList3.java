package com.tong.practise.y2023.m07.linklist;

import com.tong.practise.base.ListNode;

public class ReverseList3 {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode last = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }


    public static void main(String[] args) {
        ReverseList3 reverseList = new ReverseList3();
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);

        head.next = node1;

        ListNode node = reverseList.reverseList(head);
        System.out.println(node);
    }
}
