package com.tong.practise.y2023.m07.linklist;

import com.tong.practise.base.ListNode;

public class ReverseList2 {

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        return doReverse(null, head);
    }

    public ListNode doReverse(ListNode prev, ListNode cur) {
        if (cur == null) {
            return prev;
        }
        ListNode temp = cur.next;
        cur.next = prev;
        prev = cur;
        return doReverse(prev, temp);
    }

    public static void main(String[] args) {
        ReverseList2 reverseList = new ReverseList2();
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);

        head.next = node1;

        ListNode node = reverseList.reverseList(head);
        System.out.println(node);
    }
}
