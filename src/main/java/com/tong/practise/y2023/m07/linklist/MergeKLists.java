package com.tong.practise.y2023.m07.linklist;

import com.tong.practise.base.ListNode;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKLists {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, (a, b) -> (a.val - b.val));
        for (ListNode head : lists) {
            if (head != null) {
                pq.add(head);
            }
        }

        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            p.next = node;
            if (node.next != null) {
                pq.add(node.next);
            }
            p = p.next;
        }
        return dummy.next;
    }


    public static void main(String[] args) {
        MergeKLists mergeKLists = new MergeKLists();
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
        mergeKLists.mergeKLists(list);
    }
}
