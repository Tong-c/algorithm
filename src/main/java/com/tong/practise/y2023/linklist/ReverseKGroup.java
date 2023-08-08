package com.tong.practise.y2023.linklist;

import com.tong.practise.base.ListNode;

public class ReverseKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        ListNode a, b;
        a = b = head;
        for (int i = 0; i < k; i++) {
            if (b == null) return head;
            b = b.next;
        }
        ListNode newHead = reverse(a, b);
        a.next = reverseKGroup(b, k);
        return newHead;
    }

    ListNode reverse(ListNode a, ListNode b) {
        ListNode pre, cur, nxt;
        pre = null; cur = a; nxt = a;
        while (cur != b) {
            nxt = cur.next;
            // 逐个结点反转
            cur.next = pre;
            // 更新指针位置
            pre = cur;
            cur = nxt;
        }
        // 返回反转后的头结点
        return pre;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        // 1, 2, 3, 4, 5
        // 3, 2, 1, 4, 5
        ReverseKGroup reverseKGroup = new ReverseKGroup();
        ListNode result = reverseKGroup.reverseKGroup(head, 3);
        System.out.println(result);
    }

}
