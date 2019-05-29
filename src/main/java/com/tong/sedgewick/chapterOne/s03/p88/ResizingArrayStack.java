package com.tong.sedgewick.chapterOne.s03.p88;

import java.util.Iterator;

/**
 * 下压栈-能够动态调整数组大小的实现
 */
public class ResizingArrayStack<T> implements Iterable<T> {

    private T[] a = (T[]) new Object[1];
    private int N = 0;

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    /**
     * 调整数组大小，新建临时数组，复制数据
     *
     * @param max
     */
    public void resize(int max) {
        T[] temp = (T[]) new Object[max];
        for (int i = 0; i < N; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }

    /**
     * 将元素添加到栈顶
     *
     * @param t
     */
    public void push(T t) {
        if (N == a.length) {
            resize(2 * a.length);
        }
        a[N++] = t;
    }

    /**
     * 从栈顶删除元素
     *
     * @return
     */
    public T pop() {
        T t = a[--N];
        a[N] = null; //避免对象游离
        if (N > 0 && N == a.length / 4) {
            resize(a.length / 2);
        }
        return t;
    }

    @Override
    public Iterator<T> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<T> {

        private int i = N;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public T next() {
            return a[--i];
        }

        @Override
        public void remove() {

        }
    }
}
