package com.tong.practise.y2021.m03;

import com.tong.practise.base.ListNode;

public class ReverseList {

    /**
     * 反转一个单链表
     *
     * @param head 头节点
     * @return 头节点
     */
    public ListNode reverseList(ListNode head) {
        if (null == head) {
            return head;
        }
        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {
            ListNode tempNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tempNode;
        }
        return prev;
    }


    /**
     * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。
     * 请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
     *
     * @param head  头节点
     * @param left  整数一
     * @param right 整数二
     * @return 头节点
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (null == head) {
            return null;
        }
        ListNode prev = null;
        ListNode curr = head;
        ListNode prevLeftNode = null;
        ListNode leftNode = null;
        while (curr != null) {
            if (curr.val == left) {
                prevLeftNode = curr;
                leftNode = curr;
            }
            if (curr.val == right) {
                leftNode.next = curr.next;
                curr.next = prevLeftNode;
            }
            prev = curr;
            curr = curr.next;
        }
        return head;
    }
}
