package com.tong.practise.y2023.linklist;

import com.tong.practise.base.ListNode;

import java.util.List;

public class MyLinkedList {

    private ListNode head;

    public MyLinkedList() {

    }

    public int get(int index) {
        ListNode p = head;
        int step = 0;
        while (p != null) {
            if (step == index) {
                return p.val;
            }
            p = p.next;
            step++;
        }
        return -1;
    }

    public void addAtHead(int val) {
        ListNode newHead = new ListNode(val);
        newHead.next = head;
        head = newHead;
    }

    public void addAtTail(int val) {
        ListNode newNode = new ListNode(val);
        if (head == null) {
            head = newNode;
            return;
        }
        ListNode p = head;
        while (p.next != null) {
            p = p.next;
        }
        p.next = newNode;
    }

    public void addAtIndex(int index, int val) {
        ListNode newNode = new ListNode(val);
        if (head == null && index == 0) {
            head = newNode;
            return;
        }

        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode dummyP = dummyNode;
        ListNode prev = null;
        int step = -1;
        while (dummyP != null) {
            if (step >= 0 && step == index) {
                prev.next = newNode;
                newNode.next = dummyP;
                head = dummyNode.next;
                return;
            }
            prev = dummyP;
            dummyP = dummyP.next;
            step++;
        }

        if (step == index) {
            addAtTail(val);
        }
    }

    public void deleteAtIndex(int index) {
        if (head == null) {
            return;
        }
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode dummyP = dummyNode;
        int step = -1;
        ListNode prev = null;
        while (dummyP != null) {
            if (step >= 0 && step == index) {
                prev.next = dummyP.next;
                break;
            }

            prev = dummyP;
            dummyP = dummyP.next;
            step++;
        }
        head = dummyNode.next;
    }

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtIndex(1, 0);
        System.out.println(myLinkedList.get(0));
    }
}
