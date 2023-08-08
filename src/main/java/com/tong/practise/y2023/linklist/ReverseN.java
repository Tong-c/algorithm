package com.tong.practise.y2023.linklist;

import com.tong.practise.base.ListNode;

public class ReverseN {

    ListNode successor = null;
    public ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            successor = head.next;
            return head;
        }
        ListNode last = reverseN(head.next, n - 1);
        head.next.next = head;
        head.next = successor;
        return last;
    }

    public static void main(String[] args) {
        ReverseN reverseN = new ReverseN();
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode node = reverseN.reverseN(head, 2);
        System.out.println(node);
    }
}
