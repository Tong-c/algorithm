package com.tong.practise.y2023.linklist;

import com.tong.practise.base.ListNode;

public class ReverseBetween {

    ListNode successor = null;

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == 1) {
            return reverseN(head, right);
        }
        head.next = reverseBetween(head.next, left - 1, right - 1);
        return head;
    }

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
        ReverseBetween reverseBetween = new ReverseBetween();

        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        // 1, 2, 3, 4, 5
        // 1, 4, 3, 2, 5
        ListNode result = reverseBetween.reverseBetween(head, 2, 4);
        System.out.println(result);
    }
}
