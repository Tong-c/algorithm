package com.tong.practise.y2023.linklist;

import com.tong.practise.base.ListNode;

import java.util.PriorityQueue;

public class MergeKLists2 {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode listNode : lists) {
            if (listNode != null) {
                pq.add(listNode);
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode dummyP = dummy;
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            dummyP.next = node;
            if (node.next != null) {
                pq.add(node.next);
            }
            dummyP = dummyP.next;
        }

        return dummy.next;
    }


    public static void main(String[] args) {
        MergeKLists2 mergeKLists = new MergeKLists2();
        ListNode head1 = new ListNode(1);
        ListNode node12 = new ListNode(4);
        ListNode node13 = new ListNode(5);
        head1.next = node12;
        node12.next = node13;

        ListNode head2 = new ListNode(1);
        ListNode node22 = new ListNode(3);
        ListNode node23 = new ListNode(4);
        head2.next = node22;
        node22.next = node23;

        ListNode head3 = new ListNode(2);
        ListNode node32 = new ListNode(6);
        head3.next = node32;

        ListNode[] list = {head1, head2, head3};
        ListNode result = mergeKLists.mergeKLists(list);
        System.out.println(result);
    }
}
