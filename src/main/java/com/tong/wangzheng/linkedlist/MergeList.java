package com.tong.wangzheng.linkedlist;

/**
 * 两个有序链表合并
 */
public class MergeList {

    /**
     * 双指针迭代
     */
    public static SinglyLinkedlist.Node mergeTwoLists(SinglyLinkedlist.Node list1, SinglyLinkedlist.Node list2) {
        SinglyLinkedlist.Node n1 = list1;
        SinglyLinkedlist.Node n2 = list2;
        SinglyLinkedlist.Node newNode = null;
        while (n1 != null || n2 != null) {

            if (n1 == null) {
                newNode = addToNewNode(n2.data, newNode);
                n2 = n2.next;
                continue;
            } else if (n2 == null) {
                newNode = addToNewNode(n1.data, newNode);
                n1 = n1.next;
                continue;
            }

            if (n1.data >= n2.data) {
                newNode = addToNewNode(n2.data, newNode);
                n2 = n2.next;
            } else if (n1.data < n2.data) {
                newNode = addToNewNode(n1.data, newNode);
                n1 = n1.next;
            }
        }
        return newNode;
    }

    /**
     * 递归法
     */
    public static SinglyLinkedlist.Node mergeTwoListsTwo(SinglyLinkedlist.Node list1, SinglyLinkedlist.Node list2) {
        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        if (list1.data < list2.data) {
            list1.next = mergeTwoListsTwo(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoListsTwo(list1, list2.next);
            return list2;
        }
    }


    private static SinglyLinkedlist.Node addToNewNode(int data, SinglyLinkedlist.Node newNode) {
        SinglyLinkedlist.Node node = new SinglyLinkedlist.Node(data);
        if (newNode == null) {
            newNode = node;
        } else {
            SinglyLinkedlist.Node currNode = newNode;
            while (currNode.next != null) {
                currNode = currNode.next;
            }
            currNode.next = node;
        }
        return newNode;
    }


    public static void main(String[] args) {
        SinglyLinkedlist.Node n1 = new SinglyLinkedlist.Node(1);
        n1.next = new SinglyLinkedlist.Node(3);
        n1.next.next = new SinglyLinkedlist.Node(7);

        SinglyLinkedlist.Node n2 = new SinglyLinkedlist.Node(2);
        n2.next = new SinglyLinkedlist.Node(3);
        n2.next.next = new SinglyLinkedlist.Node(5);

        SinglyLinkedlist.Node node = mergeTwoListsTwo(n1, n2);
        System.out.println(node);
    }
}
