package com.tong.practise.y2021.m10;

import com.tong.practise.y2021.m03.ListNode;

public class ReOrderList {

    public ListNode reorderList(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }
        ListNode fastNode = head;
        ListNode slowNode = head;
        ListNode beforeMiddleNode = null;
        while (fastNode != null && fastNode.next != null) {
            fastNode = fastNode.next.next;
            beforeMiddleNode = slowNode;
            slowNode = slowNode.next;
        }
        beforeMiddleNode.next = null;

        ListNode upperNode = reverseNode(slowNode);

        ListNode lowerPtr = head;
        ListNode upperPtr = upperNode;
        ListNode dummyNode = new ListNode(-1);
        ListNode newPtr = dummyNode;
        while (lowerPtr != null && upperPtr != null) {
            newPtr.next = lowerPtr;
            lowerPtr = lowerPtr.next;
            newPtr = newPtr.next;

            newPtr.next = upperPtr;
            upperPtr = upperPtr.next;
            newPtr = newPtr.next;
        }

        if (null != lowerPtr) {
            newPtr.next = lowerPtr;
        }

        if (null != upperPtr) {
            newPtr.next = upperPtr;
        }

        return dummyNode.next;
    }

    private static ListNode reverseNode(ListNode head) {

        if (null == head || null == head.next) {
            return head;
        }

        ListNode prevNode = null;
        ListNode nextNode = null;
        ListNode currNode = head;

        while (null != currNode.next) {
            nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
        }
        currNode.next = prevNode;
        return currNode;
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
        ReOrderList reOrderList = new ReOrderList();
        ListNode result = reOrderList.reorderList(head);
        System.out.println(result);
    }
}
