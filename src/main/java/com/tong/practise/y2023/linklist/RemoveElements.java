package com.tong.practise.y2023.linklist;

import com.tong.practise.base.ListNode;

public class RemoveElements {

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode dummyP = dummyNode;

        while (dummyP.next != null) {
            if (dummyP.next.val == val) {
                dummyP.next = dummyP.next.next;
            } else {
                dummyP = dummyP.next;
            }
        }
        return dummyNode.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        /*ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(6);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);*/

        /*head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;*/

        RemoveElements removeElements = new RemoveElements();
        ListNode result = removeElements.removeElements(head, 1);
        System.out.println(result);
    }

}
