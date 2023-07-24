package com.tong.practise.y2021.m03;

import com.tong.practise.base.ListNode;

import java.util.ArrayList;
import java.util.List;

public class DeleteDuplates {

    /**
     * 删除排序链表中的重复元素
     *
     * @param head 头节点
     * @return 头节点
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (null == head) {
            return head;
        }
        ListNode pointer = head;
        int val = head.val;
        while (pointer != null && pointer.next != null) {
            if (pointer.next.val == pointer.val) {
                pointer.next = pointer.next.next;
            } else {
                val = pointer.next.val;
                pointer = pointer.next;
            }
        }
        return head;
    }

    /**
     * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
     *
     * @param head 头节点
     * @return 头节点
     */
    public ListNode deleteDuplicatesTwo(ListNode head) {
        if (null == head || head.next == null) {
            return head;
        }
        List<ListNode> finalNodeList = new ArrayList<>();
        ListNode pointer = head;
        List<Integer> allValues = new ArrayList<>();
        while (pointer != null) {
            allValues.add(pointer.val);
            pointer = pointer.next;
        }

        ListNode tempPointer = head;
        while (tempPointer != null) {
            if (!isDuplicate(allValues, tempPointer.val)) {
                finalNodeList.add(tempPointer);
            }
            tempPointer = tempPointer.next;
        }

        if (finalNodeList.size() == 1) {
            ListNode tempHead = finalNodeList.get(0);
            tempHead.next = null;
            return tempHead;
        }

        ListNode tempHead = null;
        finalNodeList.get(finalNodeList.size() - 1).next = null;
        for (int i = 0; i < finalNodeList.size() - 1; i++) {
            if (i == 0) {
                tempHead = finalNodeList.get(i);
            }

            finalNodeList.get(i).next = finalNodeList.get(i + 1);

        }

        return tempHead;
    }

    /**
     * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
     * 使用哑节点
     *
     * @param head 头节点
     * @return 头节点
     */
    public ListNode deleteDuplicatesWithDummyNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyNode = new ListNode();
        dummyNode.next = head;
        ListNode prev = dummyNode;
        ListNode curr = head;
        while (curr != null && curr.next != null) {
            if (prev.next.val != curr.next.val) {
                prev = prev.next;
                curr = curr.next;
            } else {
                while (curr != null && curr.next != null && prev.next.val == curr.next.val) {
                    curr = curr.next;
                }
                prev.next = curr.next;
                curr = curr.next;
            }
        }
        return dummyNode.next;
    }

    private boolean isDuplicate(List<Integer> allValues, int val) {
        int count = 0;
        for (Integer value : allValues) {
            if (val == value) {
                count++;
            }
        }
        if (count > 1) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        DeleteDuplates deleteDuplates = new DeleteDuplates();
        deleteDuplates.deleteDuplicatesWithDummyNode(node1);
    }
}
