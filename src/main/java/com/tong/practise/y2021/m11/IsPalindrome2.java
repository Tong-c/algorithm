package com.tong.practise.y2021.m11;

import com.tong.practise.y2021.m03.ListNode;

public class IsPalindrome2 {

    public boolean isPalindrome(ListNode head) {
        if (null == head || null == head.next) {
            return true;
        }

        ListNode fast = head;
        ListNode slow = head;
        ListNode beforeMiddleNode = null;
        while (null != fast && null != fast.next) {
            fast = fast.next.next;
            beforeMiddleNode = slow;
            slow = slow.next;
        }

        beforeMiddleNode.next = null;

        ListNode reversedHead = reverse(head);
        ListNode leftPtr = reversedHead;
        ListNode rightPtr = null;
        if (null == fast) {
            rightPtr = slow;
        } else {
            rightPtr = slow.next;
        }

        while (null != leftPtr && null != rightPtr) {
            if (leftPtr.val != rightPtr.val) {
                return false;
            }
            leftPtr = leftPtr.next;
            rightPtr = rightPtr.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head) {
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



}
