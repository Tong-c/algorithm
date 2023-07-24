package com.tong.practise.y2021.m10;

import com.tong.practise.base.ListNode;

import java.util.ArrayList;
import java.util.List;

public class HasCycle {

    public boolean hasCycle(ListNode head) {
        if (null == head || null == head.next) {
            return false;
        }
        List<ListNode> nodes = new ArrayList<>();
        ListNode pointer = head;
        while (null != pointer) {
            nodes.add(pointer);
            pointer = pointer.next;
            if (nodes.contains(pointer)) {
                return true;
            }
        }
        return false;
    }

    public boolean hasCycle2(ListNode head) {
        if (null == head || null == head.next) {
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (null != fast && null != fast.next) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
