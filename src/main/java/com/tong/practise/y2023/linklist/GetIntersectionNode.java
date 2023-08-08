package com.tong.practise.y2023.linklist;

import com.tong.practise.base.ListNode;

public class GetIntersectionNode {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        int lenA = 0;
        ListNode pointA = headA;
        while (pointA != null) {
            lenA++;
            pointA = pointA.next;
        }

        int lenB = 0;
        ListNode pointB = headB;
        while (pointB != null) {
            lenB++;
            pointB = pointB.next;
        }

        if (lenA > lenB) {
            int step = lenA - lenB;
            pointA = headA;
            for (int i = 0; i < step; i++) {
                pointA = pointA.next;
            }
            pointB = headB;
        }

        if (lenB > lenA) {
            int step = lenB - lenA;
            pointB = headB;
            for (int i = 0; i < step; i++) {
                pointB = pointB.next;
            }
            pointA = headA;
        }

        if (lenA == lenB) {
            pointA = headA;
            pointB = headB;
        }

        while (pointA != pointB) {
            pointA = pointA.next;
            pointB = pointB.next;
        }

        return pointA;
    }

    public static void main(String[] args) {
        GetIntersectionNode getIntersectionNode = new GetIntersectionNode();

        ListNode headA = new ListNode(1);
        ListNode headB = new ListNode(2);

        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(4);

        headA.next = node1;
        node1.next = node2;
        headB.next = node1;

        ListNode intersectionNode = getIntersectionNode.getIntersectionNode(headA, headB);
        System.out.println(intersectionNode.val);
    }
}
