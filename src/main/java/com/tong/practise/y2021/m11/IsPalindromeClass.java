package com.tong.practise.y2021.m11;

import com.tong.practise.y2021.m03.ListNode;

public class IsPalindromeClass {

    public static boolean isPalindrome(ListNode head) {
        if (null == head || null == head.next) {
            return true;
        }
        ListNode newHead = copyList(head);
        ListNode reversedHead = reverse(head);
        ListNode pointer = newHead;
        ListNode reversedPointer = reversedHead;
        while (null != pointer && null != reversedPointer) {
            if (pointer.val != reversedPointer.val) {
                return false;
            }
            pointer = pointer.next;
            reversedPointer = reversedPointer.next;
        }
        return true;
    }

    private static ListNode copyList(ListNode head) {
        ListNode pointer = head;
        ListNode dummyNode = new ListNode(-1);
        ListNode dummyPointer = dummyNode;
        while (pointer != null) {
            ListNode node = new ListNode(pointer.val);
            dummyPointer.next = node;

            pointer = pointer.next;
            dummyPointer = dummyPointer.next;
        }
        return dummyNode.next;
    }

    private static ListNode reverse(ListNode head) {
        ListNode currNode = head;
        ListNode prevNode = null;
        ListNode nextNode = null;
        while (null != currNode) {
            nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
        }
        return prevNode;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(1);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        isPalindrome(node1);

    }
}
