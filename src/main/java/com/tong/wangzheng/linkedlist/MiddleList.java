package com.tong.wangzheng.linkedlist;

/**
 * 链表的中间节点
 */
public class MiddleList {

    /**
     * 暴力法
     */
    public static SinglyLinkedlist.Node middleNode(SinglyLinkedlist.Node head) {
        int size = 0;
        SinglyLinkedlist.Node currNode = head;
        while (currNode != null) {
            size++;
            currNode = currNode.next;
        }

        int middleSize = size / 2 + 1;
        int nextSize = 0;
        SinglyLinkedlist.Node nextCurrNode = head;
        while (nextCurrNode != null) {
            nextSize++;
            if (nextSize == middleSize) {
                return nextCurrNode;
            }
            nextCurrNode = nextCurrNode.next;
        }
        return null;
    }


    /**
     * 快慢双指针法
     */
    public static SinglyLinkedlist.Node middleNodeTwo(SinglyLinkedlist.Node head) {
        SinglyLinkedlist.Node fast = head;
        SinglyLinkedlist.Node slow = head;
        while (fast != null) {
            if (fast.next == null) {
                break;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }


    public static void main(String[] args) {
        SinglyLinkedlist.Node head = new SinglyLinkedlist.Node(3);
        head.next = new SinglyLinkedlist.Node(4);
        head.next.next = new SinglyLinkedlist.Node(5);
        SinglyLinkedlist.Node node = middleNodeTwo(head);
        System.out.println(node);
    }
}
