package com.tong.practise.y2021.m10;

import com.tong.practise.y2021.m03.ListNode;

/**
 * 链表排序
 */
public class SortListClass {

    public ListNode sortList(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }
        return mergeSort(head);
    }


    private ListNode mergeSort(ListNode head) {
        if (null == head.next) {
            return head;
        }
        ListNode fastNode = head;
        ListNode slowNode = head;
        ListNode prevNode = null;
        while (null != fastNode && null != fastNode.next) {
            prevNode = slowNode;
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }
        ListNode rightNode = mergeSort(slowNode);
        prevNode.next = null;
        ListNode leftNode = mergeSort(head);
        return merge(leftNode, rightNode);
    }

    private ListNode merge(ListNode leftNode, ListNode rightNode) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = leftNode;
        ListNode dummyPtr = dummyNode;
        ListNode leftPtr = leftNode;
        ListNode rightPtr = rightNode;
        while (null != leftPtr && null != rightPtr) {
            int leftNodeVal = leftPtr.val;
            int rightNodeVal = rightPtr.val;

            if (leftNodeVal <= rightNodeVal) {
                leftPtr = leftPtr.next;
                dummyPtr.next = leftNode;
            } else {
                rightPtr = rightPtr.next;
                dummyPtr.next = rightNode;
            }
            dummyPtr = dummyPtr.next;
        }

        if (null != rightPtr) {
            dummyPtr.next = rightPtr;
        }

        if (null != leftPtr) {
            dummyPtr.next = leftPtr;
        }

        return dummyNode.next;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(7);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(6);
        ListNode node5 = new ListNode(8);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        SortListClass sortListClass = new SortListClass();
        ListNode sortedListNode = sortListClass.sortList(head);
        System.out.println(sortedListNode);
    }
}
