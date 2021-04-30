package com.tong.practise.y2021.m04;

import com.tong.practise.y2021.m03.ListNode;

public class Link {

    /**
     * 删除排序链表中的重复元素 II
     *
     * @param head 头节点
     * @return 头节点
     * @see <a href= "https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/">82. 删除排序链表中的重复元素 II</a>
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummyNode = new ListNode();
        dummyNode.next = head;
        ListNode curr = dummyNode;

        while (curr != null && curr.next != null) {
            curr.next = recSingleNode(curr);
            curr = curr.next;
        }
        return dummyNode.next;
    }

    private ListNode recSingleNode(ListNode node) {
        if (null == node || null == node.next) {
            return null;
        }
        if (null != node.next.next) {
            if (node.val == node.next.val || node.next.val == node.next.next.val) {
                return recSingleNode(node.next);
            } else {
                return node.next;
            }
        } else {
            if (node.val == node.next.val) {
                return recSingleNode(node.next);
            } else {
                return node.next;
            }
        }

    }

    /**
     * 反转链表 II
     *
     * @param head 头节点
     * @return 头节点
     * @see <a href= "https://leetcode-cn.com/problems/reverse-linked-list-ii/">92. 反转链表 II</a>
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyNode = new ListNode(-501);
        dummyNode.next = head;
        ListNode curr = dummyNode;
        ListNode prevLeft = null;
        ListNode nextRight = null;
        ListNode prev = null;
        ListNode leftNode = null;
        ListNode rightNode = null;
        int index = 1;
        while (curr != null) {
            index++;
            if (index == left) {
                leftNode = curr;
                prevLeft = prev;
            }

            if (index == right) {
                rightNode = curr;
                nextRight = curr.next;
            }

            if (prevLeft != null) {
                ListNode tempNode = curr.next;
                curr.next = prev;
                prev = curr;
                curr = tempNode;
                if (rightNode != null) {
                    break;
                }
            } else {
                prev = curr;
                curr = curr.next;
            }
        }
        if (null != prevLeft) {
            prevLeft.next = rightNode;
        }

        if (null != leftNode) {
            leftNode.next = nextRight;
        }
        return dummyNode.next;
    }

    /**
     * 合并两个有序链表
     *
     * @param l1 链表头节点一
     * @param l2 链表头节点二
     * @return 合并后链表的头节点
     * @see <a href= "https://leetcode-cn.com/problems/merge-two-sorted-lists/">21. 合并两个有序链表</a>
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
       ListNode newNode = new ListNode(-1);
       ListNode l1Ptr = l1;
       ListNode l2Ptr = l2;
       ListNode newNodePtr = newNode;
        while (l1Ptr != null && l2Ptr != null) {
            if (l1Ptr.val >= l2Ptr.val) {
                newNodePtr = l2Ptr;
            } else {
                newNodePtr = l1Ptr;
            }

            l1Ptr = l1Ptr.next;
            l2Ptr = l2Ptr.next;
            newNodePtr = newNodePtr.next;
        }

        if (l1Ptr == null) {
            newNodePtr.next = l2Ptr;
        }

        if (l2Ptr == null) {
            newNodePtr.next = l1Ptr;
        }

        return newNodePtr.next;
    }


    public static void main(String[] args) {
        Link link = new Link();
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        link.reverseBetween(head, 2, 4);

        System.out.println("");

    }
}
