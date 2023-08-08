package com.tong.practise.y2023.linklist;

import com.tong.practise.base.ListNode;

public class DetectCycle {

    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (fast == slow) {
                break;
            }
        }

        if (fast == null || fast.next == null) {
            return null;
        }

        slow = head;
        while (true) {
            if (slow == fast) {
                return slow;
            }
            slow = slow.next;
            fast = fast.next;
        }
    }

    public static void main(String[] args) {
       /* ListNode head = new ListNode(3);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(-4);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node1;*/

        ListNode head = new ListNode(1);
        ListNode node = new ListNode(2);

        head.next = node;
        node.next = head;

        DetectCycle detectCycle = new DetectCycle();
        System.out.println(detectCycle.detectCycle(head).val);
    }
}
