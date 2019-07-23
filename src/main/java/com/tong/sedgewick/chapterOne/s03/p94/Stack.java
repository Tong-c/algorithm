package com.tong.sedgewick.chapterOne.s03.p94;

import java.util.Iterator;

/**
 * 下压堆栈-链表实现
 *
 * @param <T>
 */
public class Stack<T> implements Iterable {

    private Node first;
    private int N;
    private T latest;

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }

    public void push(T t) {
        Node oldFirst = first;
        first = new Node();
        first.item = t;
        first.next = oldFirst;
        N++;
        latest = t;
    }

    public T pop() {
        T t = first.item;
        first = first.next;
        N--;
        latest = first.next.item;
        return t;
    }

    /**
     * 返回栈中最近添加的元素
     *
     * @return
     */
    public T peek() {
        return latest;
    }

    @Override
    public Iterator iterator() {
        return new ListIterator();
    }

    private class Node {
        T item;
        Node next;
    }

    private class ListIterator implements Iterator<T> {

        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T item = current.item;
            current = current.next;
            return item;
        }

        @Override
        public void remove() {

        }
    }

}
