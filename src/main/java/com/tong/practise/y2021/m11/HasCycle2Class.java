package com.tong.practise.y2021.m11;

import com.tong.practise.y2021.m03.ListNode;

public class HasCycle2Class {

    public ListNode detectCycle(ListNode head) {
        if (null == head || null == head.next) {
            return null;
        }

        int index = 0;
        int length = 10;
        ListNode[] nodes = new ListNode[length];
        ListNode pointer = head;
        while (null != pointer) {
            if (index + 1 == length) {
                nodes = resizeArr(nodes);
                length = nodes.length;
            }
            nodes[index] = pointer;
            index++;
            pointer = pointer.next;

            if (findNode(nodes, pointer)) {
                return pointer;
            }
        }
        return null;
    }

    private ListNode[] resizeArr(ListNode[] nodes) {
        int length = nodes.length;
        int newLength = length * 2;
        ListNode[] newNodes = new ListNode[newLength];
        for (int i = 0; i < nodes.length; i++) {
            newNodes[i] = nodes[i];
        }
        return newNodes;
    }

    private boolean findNode(ListNode[] nodes, ListNode node) {
        for (ListNode currNode : nodes) {
            if (currNode == node) {
                return true;
            }
        }
        return false;
    }


    public static ListNode detectCycle2(ListNode head) {
        if (null == head || null == head.next) {
            return null;
        }
        boolean hasCycle = false;
        ListNode fast = head;
        ListNode slow = head;
        while (null != fast && null != fast.next) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                hasCycle = true;
                break;
            }
        }

        if (hasCycle) {
            ListNode pointer1 = head;
            ListNode pointer2 = fast;
            while (true) {
                if (head == fast) {
                    return head;
                }
                pointer2 = pointer2.next;
                pointer1 = pointer1.next;

                if (pointer1 == pointer2) {
                    return pointer1;
                }
            }
        }

        return null;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        ListNode node = detectCycle2(node1);
        System.out.println(node);
    }

}
