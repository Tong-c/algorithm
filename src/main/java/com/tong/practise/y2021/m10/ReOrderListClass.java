package com.tong.practise.y2021.m10;

import com.tong.practise.y2021.m03.ListNode;

public class ReOrderListClass {

    public ListNode reorderList(ListNode head) {
        ListNode fastNode = head;
        ListNode slowNode = head;
        ListNode beforeMiddleNode = null;
        while (fastNode != null && fastNode.next != null) {
            fastNode = fastNode.next.next;
            beforeMiddleNode = slowNode;
            slowNode = slowNode.next;
        }

        ListNode lowerNode = head;
        ListNode upperNode = slowNode;


        return null;
    }

    private ListNode reverseNode(ListNode head) {
        
        return null;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        ReOrderListClass reOrderListClass = new ReOrderListClass();
    }
}
