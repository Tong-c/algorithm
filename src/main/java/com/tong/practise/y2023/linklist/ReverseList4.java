package com.tong.practise.y2023.linklist;

import com.tong.practise.base.ListNode;

public class ReverseList4 {

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
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);

        head.next = node1;
        node1.next = node2;

        ReverseList4 reverseList4 = new ReverseList4();
        ListNode result = reverseList4.reverseList(head);
        System.out.println(result);
    }
}
