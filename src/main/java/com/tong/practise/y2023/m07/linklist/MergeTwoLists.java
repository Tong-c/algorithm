package com.tong.practise.y2023.m07.linklist;

import com.tong.practise.base.ListNode;

public class MergeTwoLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummyNode = new ListNode(-1);
        ListNode pointer1 = list1;
        ListNode pointer2 = list2;
        ListNode dummyPointer = dummyNode;
        while (pointer1 != null && pointer2 != null) {
            if (pointer1.val <= pointer2.val) {
                dummyPointer.next = pointer1;
                pointer1 = pointer1.next;
            } else {
                dummyPointer.next = pointer2;
                pointer2 = pointer2.next;
            }

            dummyPointer = dummyPointer.next;
        }

        if (pointer1 == null && pointer2 != null) {
            dummyPointer.next = pointer2;
        }

        if (pointer1 != null) {
            dummyPointer.next = pointer1;
        }

        return dummyNode.next;
    }

    public static void main(String[] args) {
        MergeTwoLists mergeTwoLists = new MergeTwoLists();
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(2);

        ListNode node2 = new ListNode(3);
        node2.next = new ListNode(4);

        ListNode node = mergeTwoLists.mergeTwoLists(node1, node2);
        System.out.println(node);

    }
}
